package managers.core.dbtables;

import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Order_Condition;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Tz_Manager extends Abstract_Controller_Manager<C_Tz> {

  private static C_Tz_Manager currentInstance = null;

  public static C_Tz_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tz_Manager();
    }
    return currentInstance;
  }

  public C_Tz_Manager() {
    super(C_Tz.class);
  }

  public List<C_Tz> get_c_tz_list() {
    Transaction tx = null;
    List<C_Tz> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Tz where is_deleted=false order by interval_in_min asc");
    //q_.setCacheable(use_query_cache);
      res = q_.list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }   
  
  public static C_Tz get_c_tz_by_interval_in_min(int interval_in_min_) {
    C_Tz res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_tz_by_interval_in_min(session_, interval_in_min_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static C_Tz get_c_tz_by_interval_in_min(Session session_, int interval_in_min_) {
    C_Tz res = null;
    Query q_ = session_.createQuery("from C_Tz where is_deleted=false and interval_in_min=" + interval_in_min_);
  //q_.setCacheable(use_query_cache);
    if (!q_.list().isEmpty()) {
      res = (C_Tz) q_.list().get(0);
    }
    return res;
  }   
}
