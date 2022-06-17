package gs.controllers;

import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import gs.common.servlet.servlet_funcs;
import gs.exception.TokenRefreshException;
import model.core.dbtables.*;
import gs.payload.request.*;
import gs.payload.response.*;
import gs.security.jwt.JwtUtils;
import gs.security.services.RefreshTokenService;
import gs.security.services.UserDetailsImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import gs.repositories.core.dbtables.*;
import gs.security.services.*;
import gs.services.core.CoreSessionFactoryInitService;
import gs.services.core.dbtables.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javax.servlet.http.*;
import managers.core.dbtables.*;
import model.core.dbtables.*;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import others.CustomLogger;
import others.core_custom_funcs;
import others.core_spring_funcs;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  C_Usr_Repository c_Usr_Repository;

  @Autowired
  C_Usr_Service c_Usr_Service;

  @Autowired
  C_Usr_Role_Repository c_Usr_Role_Repository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  RefreshTokenService refreshTokenService;

  @Autowired
  C_Usr_Role_Service c_Usr_Role_Service;

  @Autowired
  C_Proj_Service c_Proj_Service;

  @Autowired
  C_Usr_Type_Service c_Usr_Type_Service;

  @Autowired
  C_Site_Repository c_Site_Repository;

  @Autowired
  C_Tz_Repository c_Tz_Repository;

  @Autowired
  C_Lang_Repository c_Lang_Repository;

  @Autowired
  C_Usr_Status_Service c_Usr_Status_Service;

  @Autowired
  HttpServletRequest httpServletRequest;

  @Autowired
  AuthService authService;

  @Autowired
  C_Lang_Service c_Lang_Service;

  @Autowired
  C_Site_Service c_Site_Service;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    //String domain_ = httpServletRequest.getServerName();
    //C_Site c_Site = c_Site_Repository.find_by_domain(domain_).orElseThrow(() -> new RuntimeException("Domain is not found: " + domain_));
    try {
      C_Site c_Site = c_Site_Service.get_c_site_from_request(httpServletRequest);
      Integer c_proj_id_ = c_Site.getC_proj();
      Integer c_usr_type_id_ = c_Usr_Type_Service.id__user;
      C_Lang c_Lang = c_Lang_Service.get_c_lang_from_request(httpServletRequest);
      ResourceBundle bundle = core_custom_funcs.getResourceBundle(c_Lang.getCode());

      Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(authentication);
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

      ArrayList<String> login_res_ = authService.check_login(httpServletRequest, loginRequest.getUsername(), loginRequest.getPassword(), bundle, c_proj_id_, c_usr_type_id_, true, userDetails.getC_usr());
      if (!login_res_.isEmpty()) {
        return core_spring_funcs.get_err_msg_response(other_funcs.StrListToStr(login_res_));
      }
      authService.after_successfull_login(c_Lang, userDetails.getC_usr(), httpServletRequest);

      String jwt = jwtUtils.generateJwtToken(userDetails);
      List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
        .collect(Collectors.toList());

      C_Usr_Refresh_Token с_C_Usr_Refresh_Token = refreshTokenService.createRefreshToken(userDetails.getC_usr());

      return ResponseEntity.ok(new JwtResponse(jwt, с_C_Usr_Refresh_Token.getRefresh_token(), userDetails.getC_usr().getC_usr(),
        userDetails.getUsername(), userDetails.getC_usr().getEmail(), roles));
    } catch (Exception e) {
      return core_spring_funcs.get_err_msg_response(e);
    }
  }

  @PostMapping("/get_signup_verif_code")
  public ResponseEntity<?> get_signup_verif_code(@Valid @RequestBody SignupVerifCodeRequest signupVerifCodeRequest, HttpServletRequest httpServletRequest) {
    try {
      C_Site c_Site = c_Site_Service.get_c_site_from_request(httpServletRequest);
      //String domain_ = httpServletRequest.getServerName();
      //C_Site c_Site = c_Site_Repository.find_by_domain(domain_).orElseThrow(() -> new RuntimeException("Domain is not found: " + domain_));
      C_Lang c_Lang = c_Lang_Service.get_c_lang_from_request(httpServletRequest);
      ResourceBundle bundle = core_custom_funcs.getResourceBundle(c_Lang.getCode());

      if (!signupVerifCodeRequest.getPassword().equals(signupVerifCodeRequest.getPassword2())) {
        return core_spring_funcs.get_err_msg_response(bundle_funcs.getBundleValue(bundle, "Paroli_ne_sovpadayut"));
      }
      if (c_Usr_Service.exists_by_name(c_Site.getC_proj(), c_Usr_Type_Service.id__user, signupVerifCodeRequest.getUsername())) {
        return core_spring_funcs.get_err_msg_response(bundle_funcs.getBundleValue(bundle, "Polzovatel_s_takim_email_uzhe_sushchestvuyet"));
      }

      if (c_Usr_Service.exists_by_email(c_Site.getC_proj(), c_Usr_Type_Service.id__user, signupVerifCodeRequest.getUsername())) {
        return core_spring_funcs.get_err_msg_response(bundle_funcs.getBundleValue(bundle, "Polzovatel_s_takim_email_uzhe_sushchestvuyet"));
      }

      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        hibernate_funcs.beginTransaction(session_);
        C_Email_Verify c_Email_Verify = C_Email_Verify_Manager.getCI().ins_row(session_, signupVerifCodeRequest.getUsername());
        core_custom_funcs.send_email_for_signup_verif_code(session_, c_Site.getC_proj_t_2(session_), 
          c_Site, signupVerifCodeRequest.getUsername(),
          I_Plain_Txt_Manager.getCI().get_row(session_, C_Proj_Manager.const_c_proj_id_common, "qoldan_signup_verif_code_email_message_subject_template").getTxt_translation_3(session_, c_Lang.getCode()),
          I_Plain_Txt_Manager.getCI().get_row(session_, C_Proj_Manager.const_c_proj_id_common, "qoldan_signup_verif_code_email_message_body_template").getTxt_translation_3(session_, c_Lang.getCode()),
          c_Email_Verify.getVerif_code(), c_Lang.getCode());
        hibernate_funcs.commitAndClose(session_);
        return core_spring_funcs.get_msg_response(c_Email_Verify.getVerif_code());
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }

      //return core_spring_funcs.get_msg_response("");
    } catch (Exception e) {
      return core_spring_funcs.get_err_msg_response(e);
    }
  }

  @PostMapping("/signup")
  public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signUpRequest, HttpServletRequest httpServletRequest) {
    try {
      C_Site c_Site = c_Site_Service.get_c_site_from_request(httpServletRequest);
      //String domain_ = httpServletRequest.getServerName();
      //C_Site c_Site = c_Site_Repository.find_by_domain(domain_).orElseThrow(() -> new RuntimeException("Domain is not found: " + domain_));
      C_Lang c_Lang = c_Lang_Service.get_c_lang_from_request(httpServletRequest);
      ResourceBundle bundle = core_custom_funcs.getResourceBundle(c_Lang.getCode());

      if (!signUpRequest.getPassword().equals(signUpRequest.getPassword2())) {
        return core_spring_funcs.get_err_msg_response(bundle_funcs.getBundleValue(bundle, "Paroli_ne_sovpadayut"));
      }
      if (c_Usr_Service.exists_by_name(c_Site.getC_proj(), c_Usr_Type_Service.id__user, signUpRequest.getUsername())) {
        return core_spring_funcs.get_err_msg_response(bundle_funcs.getBundleValue(bundle, "Polzovatel_s_takim_email_uzhe_sushchestvuyet"));
      }

      if (c_Usr_Service.exists_by_email(c_Site.getC_proj(), c_Usr_Type_Service.id__user, signUpRequest.getUsername())) {
        return core_spring_funcs.get_err_msg_response(bundle_funcs.getBundleValue(bundle, "Polzovatel_s_takim_email_uzhe_sushchestvuyet"));
      }

      // Create new user's account
      C_Usr c_Usr = c_Usr_Service.get_new_c_usr_with_loaded_default_vals(c_Site.getC_proj(), c_Usr_Type_Service.id__user);
      c_Usr.setName(signUpRequest.getUsername());
      c_Usr.setEmail(signUpRequest.getUsername());
      c_Usr.setPswd(passwordEncoder.encode(signUpRequest.getPassword()));
      Date now_ = new java.util.Date();
      c_Usr.setIns_dt(now_);
      //c_Usr.setPswd_salt(user_password_funcs.getSaltForPassword());
      c_Usr.setPswd_salt("");
      //c_Usr.setPswd(user_password_funcs.getEncodedPassword(c_Usr.getPswd(), c_Usr.getPswd_salt()));
      C_Tz c_tz_ = c_Tz_Repository.find_by_interval_in_min(-signUpRequest.getTz_offset_in_min()).orElseThrow(() -> new RuntimeException("TZ not specified: " + signUpRequest.getTz_offset_in_min()));
      c_Usr.setC_tz(c_tz_.getC_tz());
      c_Usr.setSale_date(now_);
      c_Usr.setIs_self_registered(true);
      c_Usr.setC_usr_status(c_Usr_Status_Service.id__active);
      c_Usr.setC_country(c_Site.getC_country());
      if (c_Lang != null) {
        c_Usr.setCurrent_c_lang(c_Lang.getC_lang());
      }

      Set<String> strRoles = signUpRequest.getRole();
      Set<C_Usr_Role> c_Usr_Roles = new HashSet<>();
      if (strRoles == null) {
        C_Usr_Role c_Usr_Role = c_Usr_Role_Repository.find_by_id(C_Usr_Role_Manager.getCI().getId_code__user())
          .orElseThrow(() -> new RuntimeException("Role is not found."));
        c_Usr_Roles.add(c_Usr_Role);
      } else {
        strRoles.forEach(role -> {
          C_Usr_Role c_Usr_Role = c_Usr_Role_Repository.find_by_code(role)
            .orElseThrow(() -> new RuntimeException("Role is not found."));
          c_Usr_Roles.add(c_Usr_Role);
        });
      }
      c_Usr.setC_usr_roles(c_Usr_Roles);

      c_Usr_Repository.save(c_Usr);

      return core_spring_funcs.get_succ_msg_response();
    } catch (Exception e) {
      return core_spring_funcs.get_err_msg_response(e);
    }
  }

  @PostMapping("/refresh_token")
  public ResponseEntity<?> refresh_token(@Valid @RequestBody TokenRefreshRequest request) {
    try {
      String requestRefreshToken = request.getRefreshToken();

      return refreshTokenService.find_by_refresh_token(requestRefreshToken)
        .map(refreshTokenService::verifyExpiration)
        .map(t -> c_Usr_Repository.getById(t.getC_usr()))
        .map(user -> {
          String token = jwtUtils.generateTokenFromUsername(user.getName());
          return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
        })
        .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
        "Refresh token is not in database!"));
    } catch (Exception e) {
      return core_spring_funcs.get_err_msg_response(e);
    }
  }

  @PostMapping("/logout")
  public ResponseEntity<?> logout(@Valid @RequestBody TokenRefreshRequest request) {
    try {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      refreshTokenService.del_by_refresh_token(request.getRefreshToken());
      return core_spring_funcs.get_succ_msg_response();
      //return ResponseEntity.ok(new UserResponse(new UserForResponse(userDetails)));

      /*
    String res = servlet_funcs.getRequestParams(httpServletRequest);
    return ResponseEntity.ok(new String(res));
       */
    } catch (Exception e) {
      return core_spring_funcs.get_err_msg_response(e);
    }
  }

  /*
  @PostMapping("/logout")
  public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequest logOutRequest) {
    refreshTokenService.del_by_c_usr_id(logOutRequest.getUserId());
    return ResponseEntity.ok(new MessageResponse("Log out successful!"));
  }
   */
  @GetMapping("/user")
  public ResponseEntity<?> user() {
    try {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      return ResponseEntity.ok(new UserResponse(new UserForResponse(userDetails)));
    } catch (Exception e) {
      return core_spring_funcs.get_err_msg_response(e);
    }
  }

}
