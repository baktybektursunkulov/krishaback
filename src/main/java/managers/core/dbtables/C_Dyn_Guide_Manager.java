package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Dyn_Guide_Manager extends Abstract_Controller_Manager<C_Dyn_Guide> {

  private static C_Dyn_Guide_Manager currentInstance = null;

  public static C_Dyn_Guide_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Dyn_Guide_Manager();
    }
    return currentInstance;
  }

  public C_Dyn_Guide_Manager() {
    super(C_Dyn_Guide.class);
  }

  public C_Dyn_Guide get_unique_rec(Session session_, Integer c_proj_id_, String code_, Integer exclude_id_) {
    Query q_ = session_.createQuery("from C_Dyn_Guide where "
      + " is_deleted=false "
      + " and c_proj=:c_proj_id_ "
      + " and lower(trim(code))=:code_ "
      + (exclude_id_ == null ? "" : "and c_dyn_guide<>:exclude_id_") + " and is_deleted=false ");
    q_.setString("code_", code_.trim().toLowerCase());
    q_.setInteger("c_proj_id_", c_proj_id_);
    if (exclude_id_ != null) {
      q_.setInteger("exclude_id_", exclude_id_);
    }
    List<C_Dyn_Guide> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }

}
