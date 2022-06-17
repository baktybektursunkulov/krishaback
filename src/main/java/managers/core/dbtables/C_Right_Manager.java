package managers.core.dbtables;

import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Right_Manager extends Abstract_Controller_Manager<C_Right> {

  private static C_Right_Manager currentInstance = null;

  public static C_Right_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Right_Manager();
    }
    return currentInstance;
  }

  public C_Right_Manager() {
    super(C_Right.class);
  }

  public List<C_Right> get_c_right_list_by_right_kind(int c_right_kind_id_) {
    Transaction tx = null;
    List<C_Right> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Right where is_deleted=false and c_right_kind=:c_right_kind_id_ and is_active = true order by order_num asc");
      q_.setInteger("c_right_kind_id_", c_right_kind_id_);
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

    public List<C_Right> get_c_right_list_by_c_right_kind_code(String c_right_kind_code_) {
    Transaction tx = null;
    List<C_Right> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_right_list_by_c_right_kind_code(session_, c_right_kind_code_);
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
 
  public List<C_Right> get_c_right_list_by_c_right_kind_code(Session session_, String c_right_kind_code_) {
    CustomLogger.log("get_c_right_list_by_c_right_kind_code c_right_kind_code_=" + c_right_kind_code_);
    List<C_Right> res = null;
    Query q_ = session_.createQuery("SELECT t FROM C_Right t, C_Right_Kind rk where t.is_deleted=false and t.c_right_kind = rk.c_right_kind and rk.code=:c_right_kind_code and t.is_active = true order by t.order_num");
    q_.setString("c_right_kind_code", c_right_kind_code_);
    //q_.setCacheable(use_query_cache);
    res = q_.list();
    return res;
  }     
}
