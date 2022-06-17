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
public class C_Loc_Grp_Manager extends Abstract_Controller_Manager<C_Loc_Grp> {

  private static C_Loc_Grp_Manager currentInstance = null;

  public static C_Loc_Grp_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Loc_Grp_Manager();
    }
    return currentInstance;
  }

  public C_Loc_Grp_Manager() {
    super(C_Loc_Grp.class);
  }

  public C_Loc_Grp get_unique_rec(Session session_, String name_, Integer exclude_id_) {
    Query q_ = session_.createQuery("from C_Loc_Grp where "
      + " lower(trim(name))=:name_ "
      + (exclude_id_ == null ? "" : "and c_loc_grp<>:exclude_id_") 
      + " and is_deleted=false ");
    q_.setString("name_", name_.trim().toLowerCase());
    if (exclude_id_ != null) {
      q_.setInteger("exclude_id_", exclude_id_);
    }
    List<C_Loc_Grp> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }

  
}
