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
public class C_Loc_Grp_Loc_Manager extends Abstract_Controller_Manager<C_Loc_Grp_Loc> {

  private static C_Loc_Grp_Loc_Manager currentInstance = null;

  public static C_Loc_Grp_Loc_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Loc_Grp_Loc_Manager();
    }
    return currentInstance;
  }

  public C_Loc_Grp_Loc_Manager() {
    super(C_Loc_Grp_Loc.class);
  }

  public List<C_Loc> get_avail_c_loc_list(Session session_, Integer c_loc_grp_id_) {
    List<C_Loc> res = null;
    if (c_loc_grp_id_ == null) {
      return null;
    }
    Query q_ = session_.createSQLQuery("select * from C_Loc t where t.is_deleted=false and not exists ("
      + "select 1 from C_Loc_Grp_Loc t2 "
      + "where "
      + "  t2.c_loc_grp=:c_loc_grp_id_ "
      + "  and t2.c_loc=t.c_loc "
      + "  and t2.is_deleted=false "
      + ") order by t.name ").addEntity(C_Loc.class);
    q_.setInteger("c_loc_grp_id_", c_loc_grp_id_);
    res = q_.list();
    return res;
  }

  public List<C_Loc> get_avail_c_loc_list(Integer c_loc_grp_id_) {
    List<C_Loc> res = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_avail_c_loc_list(session_, c_loc_grp_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Loc_Grp_Loc get_unique_rec(Session session_, Integer c_loc_grp_id_,
    Integer c_loc_id_, Integer exclude_id_) {
    Query q_ = session_.createQuery("from C_Loc_Grp_Loc where "
      + " c_loc_grp=:c_loc_grp_id_ "
      + " and c_loc=:c_loc_id_ "
      + (exclude_id_ == null ? "" : " and c_loc_grp_loc<>:exclude_id_")
      + " and is_deleted=false ");
    q_.setInteger("c_loc_grp_id_", c_loc_grp_id_);
    q_.setInteger("c_loc_id_", c_loc_id_);
    if (exclude_id_ != null) {
      q_.setInteger("exclude_id_", exclude_id_);
    }
    List<C_Loc_Grp_Loc> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }

  public String get_unique_violation_exception_string(Session session_, C_Loc_Grp_Loc rec_) {
    return "(" + rec_.getC_loc_grp_t_2(session_).getName() + ", " + rec_.getC_loc_t_2(session_).getCalc_full_name_2(session_, "->") + ")";
  }
  
}
