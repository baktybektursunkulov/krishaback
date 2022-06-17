package gs.services.core.dbtables;

import gs.common.servlet.servlet_funcs;
import model.core.dbtables.*;
import gs.repositories.core.dbtables.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import managers.core.dbtables.C_Lang_Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class C_Lang_Service {

  @Autowired
  private C_Lang_Repository repository;

  @Autowired
  HttpServletRequest httpServletRequest;

  public String get_lang_from_request(HttpServletRequest httpServletRequest) {
    return servlet_funcs.getCookieValue(httpServletRequest, "i18n_redirected");
  }

  public String get_lang_from_request() {
    return get_lang_from_request(httpServletRequest);
  }

  public C_Lang get_c_lang_from_request(HttpServletRequest httpServletRequest) {
    String lang_ = get_lang_from_request(httpServletRequest);
    if (lang_ != null) {
      C_Lang c_Lang = repository.find_by_code(lang_).get();
      return c_Lang;
    } else {
      return C_Lang_Manager.getCI().get_rec(1);
    }
    //return null;
  }

  public C_Lang get_c_lang_from_request() {
    return get_c_lang_from_request(httpServletRequest);
  }

  public List<C_Lang> find_all(Integer c_proj_id_) {
    return repository.find_all(c_proj_id_);
  }

}
