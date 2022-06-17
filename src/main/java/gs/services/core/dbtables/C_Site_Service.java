package gs.services.core.dbtables;

import gs.common.servlet.servlet_funcs;
import model.core.dbtables.*;
import gs.repositories.core.dbtables.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class C_Site_Service {

  @Autowired
  private C_Site_Repository repository;

  @Autowired
  HttpServletRequest httpServletRequest;

  public C_Site get_c_site_from_request() {
    return get_c_site_from_request(httpServletRequest);
  }

  public C_Site get_c_site_from_request(HttpServletRequest httpServletRequest) {
    C_Site res;
    String domain_ = httpServletRequest.getServerName();
    res = repository.find_by_domain(domain_).orElseThrow(() -> new RuntimeException("Domain is not found: " + domain_));
    return res;
  }

}
