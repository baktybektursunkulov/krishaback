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
public class C_Dyn_Guide_Row_Manager extends Abstract_Controller_Manager<C_Dyn_Guide_Row> {

  private static C_Dyn_Guide_Row_Manager currentInstance = null;

  public static C_Dyn_Guide_Row_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Dyn_Guide_Row_Manager();
    }
    return currentInstance;
  }

  public C_Dyn_Guide_Row_Manager() {
    super(C_Dyn_Guide_Row.class);
  }

  public C_Dyn_Guide_Row get_unique_rec(Session session_, Integer c_dyn_guide_id_, String val_, Integer exclude_id_) {
    Query q_ = session_.createQuery("from C_Dyn_Guide_Row where "
      + " c_dyn_guide=:c_dyn_guide_id_ "
      + " and lower(trim(val))=:val_ "
      + (exclude_id_ == null ? "" : "and c_dyn_guide_row<>:exclude_id_") + " and is_deleted=false ");
    q_.setString("val_", val_.trim().toLowerCase());
    q_.setInteger("c_dyn_guide_id_", c_dyn_guide_id_);
    if (exclude_id_ != null) {
      q_.setInteger("exclude_id_", exclude_id_);
    }
    List<C_Dyn_Guide_Row> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }

  public String get_unique_violation_exception_string(Session session_, C_Dyn_Guide_Row rec_) {
    return "(" + rec_.getC_dyn_guide_t_2(session_).getName() + ", " + rec_.getVal() + ")";
  }
  
  public List<C_Dyn_Guide_Row> get_row_list(Session session_, Integer c_dyn_guide_id_) {
    Query q_ = session_.createQuery("from C_Dyn_Guide_Row where "
      + " c_dyn_guide=:c_dyn_guide_id_ "
      + " and is_deleted=false "
      + " order by val asc "); 
    q_.setInteger("c_dyn_guide_id_", c_dyn_guide_id_);
    List<C_Dyn_Guide_Row> list_ = q_.list();
    return list_;
  }

}
