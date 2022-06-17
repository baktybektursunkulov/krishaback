package gs.security.services;

import model.core.dbtables.C_Site;
import model.core.dbtables.C_Usr;
import gs.repositories.core.dbtables.C_Site_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gs.repositories.core.dbtables.C_Usr_Repository;
import gs.services.core.dbtables.C_Proj_Service;
import gs.services.core.dbtables.C_Site_Service;
import gs.services.core.dbtables.C_Usr_Type_Service;
import javax.servlet.http.HttpServletRequest;

@Service
public class User_Details_Service_Impl implements UserDetailsService {

  @Autowired
  C_Usr_Repository c_Usr_Repository;

  //@Autowired
  //C_Proj_Service c_Proj_Service;

  @Autowired
  C_Usr_Type_Service c_Usr_Type_Service;

  @Autowired
  HttpServletRequest httpServletRequest;

  //@Autowired
  //C_Site_Repository c_Site_Repository;

  @Autowired
  C_Site_Service c_Site_Service;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    C_Site c_Site = c_Site_Service.get_c_site_from_request(httpServletRequest);
    //String domain_ = httpServletRequest.getServerName();
    //C_Site c_Site = c_Site_Repository.find_by_domain(domain_).orElseThrow(() -> new RuntimeException("Domain is not found: " + domain_));
    C_Usr c_Usr = c_Usr_Repository.find_by_name(c_Site.getC_proj(), c_Usr_Type_Service.id__user, username)
      .orElseThrow(() -> new UsernameNotFoundException("User Not Found with name: " + username));

    return UserDetailsImpl.build(c_Usr);
  }

}
