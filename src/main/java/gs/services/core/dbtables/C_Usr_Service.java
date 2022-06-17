package gs.services.core.dbtables;

import model.core.dbtables.*;
import gs.repositories.core.dbtables.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class C_Usr_Service {

  @Autowired
  private C_Usr_Repository repository;

  public Boolean exists_by_name(Integer c_proj_id_, Integer c_usr_type_id_, String name_) {
    return (repository.find_by_name(c_proj_id_, c_usr_type_id_, name_).isPresent());
  }

  public Boolean exists_by_email(Integer c_proj_id_, Integer c_usr_type_id_, String email_) {
    return (repository.find_by_email(c_proj_id_, c_usr_type_id_, email_).isPresent());
  }

  public C_Usr get_default_c_usr(Integer c_proj_id_, Integer c_usr_type_id_) {
    return (repository.find_by_name(c_proj_id_, c_usr_type_id_, "default").orElse(null));
  }

  public C_Usr get_new_c_usr_with_loaded_default_vals(Integer c_proj_id_, Integer c_usr_type_id_) {
    C_Usr res = null;
    C_Usr def_rec_ = get_default_c_usr(c_proj_id_, c_usr_type_id_);
    //new_rec_.setName(def_rec_.getName());
    res = (C_Usr) def_rec_.clone();
    res.setC_usr(null);
    res.setName("");
    res.setPswd("");
    res.setPswd_salt("");
    res.setOur_note("");
    res.setEmail("");
    return res;
  }

}
