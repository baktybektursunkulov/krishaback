package gs.security.services;

import beans.SessionBean;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import gs.common.servlet.servlet_funcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gs.services.core.dbtables.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import managers.core.dbtables.*;
import model.core.dbtables.*;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import others.core_custom_funcs;
import others.custom_user_password_funcs;

@Service
public class AuthService {

  @Autowired
  PasswordEncoder passwordEncoder;

  public void after_successfull_login(C_Lang c_Lang, C_Usr c_Usr, HttpServletRequest httpServletRequest) {
    if (c_Lang != null) {
      if (c_Usr.getCurrent_c_lang() == null || !c_Usr.getCurrent_c_lang().equals(c_Lang.getC_lang())) {
        c_Usr.setCurrent_c_lang(c_Lang.getC_lang());
        C_Usr_Manager.getCI().merge_rec(c_Usr);
      }
    }

    if (servlet_funcs.getIsMobileBrowser(httpServletRequest)) {
      C_Usr_Log_Manager.insUsrLog(c_Usr, C_Usr_Log_Type_Manager.getC_c_usr_log_type__login(), C_Usr_Log_Service_Manager.getC_c_usr_log_service__mobile_web(),
        servlet_funcs.getRemoteAddr(httpServletRequest));
    } else {
      C_Usr_Log_Manager.insUsrLog(c_Usr, C_Usr_Log_Type_Manager.getC_c_usr_log_type__login(), C_Usr_Log_Service_Manager.getC_c_usr_log_service__web(),
        servlet_funcs.getRemoteAddr(httpServletRequest));
    }
  }

  public void after_unsuccessfull_login(HttpServletRequest httpServletRequest, String user_name_, String user_password_) {
    C_Limit_Log_Manager.getCI().ins_unsucc_login_limit_log(servlet_funcs.getRemoteAddr(httpServletRequest), user_name_, user_password_, C_Usr_Log_Service_Manager.getC_c_usr_log_service__web());
  }

  public ArrayList<String> check_login(HttpServletRequest httpServletRequest, String user_name_, String user_password_, ResourceBundle bundle_, Integer c_proj_id_, Integer c_usr_type_id_,
    Boolean check_password_, C_Usr c_Usr) throws Exception {
    ArrayList<String> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = check_login(session_, httpServletRequest, user_name_, user_password_, bundle_, c_proj_id_, c_usr_type_id_, check_password_, c_Usr);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public ArrayList<String> check_login(Session session_, HttpServletRequest httpServletRequest, String user_name_, String user_password_, ResourceBundle bundle, Integer c_proj_id_, Integer c_usr_type_id_,
    Boolean check_password_, C_Usr c_Usr) throws Exception {
    ArrayList<String> res = new ArrayList<String>();
    //C_Usr c_Usr = C_Usr_Manager.get_c_usr_by_name(c_proj_id_, c_usr_type_id_, user_name_);

    //Sys_Admin sys_admin_ = Sys_Admin_Manager.getSysAdminByUsrName(logging_c_usr.getName());
    if (c_Usr == null) {
      String msg_ = bundle_funcs.getBundleValue(bundle, "Nevernoe_imja_polzovatelja_ili_parol");
      res.add(msg_);
      after_unsuccessfull_login(httpServletRequest, user_name_, user_password_);
      return res;
    }
    //if (!sys_admin_.getUsr_password().equals(password)) {
    if (check_password_) {
      /*
      String encoded_password_ = passwordEncoder.encode(user_password_);
      if (!custom_user_password_funcs.isUserPasswordCorrectForEncodedPassword(session_, C_Usr_, user_password_, encoded_password_, c_proj_id_, c_usr_type_id_)) {
        String msg_ = bundle_funcs.getBundleValue(bundle_, "Nevernoe_imja_polzovatelja_ili_parol");
        res.add(msg_);
        return res;
      }
       */
    }
    if (!c_Usr.getIs_on()) {
      String msg_ = bundle_funcs.getBundleValue(bundle, "Polzovatel_otkljuchen");
      res.add(msg_);
      after_unsuccessfull_login(httpServletRequest, user_name_, user_password_);
      return res;
    }
    /*
    if (!C_Common_Settings_Manager.getCurrent_c_common_settings(session_).getIs_system_launched()) {
      String msg_ = bundle_funcs.getBundleValue(bundle_, "Sistema_zakryta_na_tehnicheskoe_obsluzhivanie");
      res.add(msg_);
      return res;
    }
    if (!C_Site_Manager.get_current_c_site(session_, request_, true).getIs_site_launched()) {
      String msg_ = bundle_funcs.getBundleValue(bundle_, "Sajt_zakryt_na_tehnicheskoe_obsluzhivanie");
      res.add(msg_);
      return res;
    }
     */
    if (httpServletRequest != null) {
      /*
      CustomLogger.log("request_.getRemoteHost()=" + request_.getRemoteHost());
      if (C_Usr_.getHost_mask() != null && !C_Usr_.getHost_mask().trim().isEmpty()) {
        if (!other_funcs.isStringMathesMask(request_.getRemoteHost(), C_Usr_.getHost_mask())) {
          String msg_ = bundle_funcs.getBundleValue(bundle_, "Polzovatel_ne_mozhet_vojti_tak_kak_IP_adres_ne_sootvetstvuet_maske_hosta_polzovatelja");
          res.add(msg_);
          return res;
        }
      }
       */
    }
    if (c_Usr.getC_usr_status().equals(C_Usr_Status_Manager.getCI().getId__blocked())) {
      String msg_ = bundle_funcs.getBundleValue(bundle, "Polzovatel_zablokirovan");
      res.add(msg_);
      after_unsuccessfull_login(httpServletRequest, user_name_, user_password_);
      return res;
    }
    /*
    if (C_Usr_Manager.getCI().is_parent_c_usr_blocked(c_Usr)) {
      String msg_ = bundle_funcs.getBundleValue(bundle, "Polzovatel_zablokirovan");
      res.add(msg_);
      after_unsuccessfull_login(httpServletRequest, user_name_, user_password_);
      return res;
    }
     */

    if (!C_Limit_Log_Manager.getCI().check_unsucc_login(servlet_funcs.getRemoteAddr(httpServletRequest), C_Usr_Log_Service_Manager.getC_c_usr_log_service__web())) {
      res.add(bundle_funcs.getBundleValue(bundle, "Prevyshen_limit_neudachnykh_popytok_vkhoda"));
      after_unsuccessfull_login(httpServletRequest, user_name_, user_password_);
      return res;
    }

    return res;
  }

}
