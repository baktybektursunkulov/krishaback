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
public class C_Img_Type_Manager extends Abstract_Controller_Manager<C_Img_Type> {

  private static C_Img_Type_Manager currentInstance = null;
  private static C_Img_Type png_img_type;
 

  public static C_Img_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Img_Type_Manager();
    }
    return currentInstance;
  }

  public C_Img_Type_Manager() {
    super(C_Img_Type.class);
  }

  public static C_Img_Type getPng_img_type(Session session_) {
    if (png_img_type == null) {
      png_img_type = get_img_type_by_code(session_, "png");
    }
    return png_img_type;
  }

  public static void main(String[] args) {

  }

  public static C_Img_Type get_img_type(Integer rec_id_) {
    C_Img_Type res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = (C_Img_Type) session_.load(C_Img_Type.class, rec_id_);
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

  public static C_Img_Type get_img_type(Session session_, Integer rec_id_) {
    return (C_Img_Type) session_.load(C_Img_Type.class, rec_id_);
  }

  public static C_Img_Type get_img_type_by_code(String code_) {
    C_Img_Type res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Img_Type where is_deleted=false and code='" + code_ + "'");
    //q_.setCacheable(use_query_cache);
      if (!q_.list().isEmpty()) {
        res = (C_Img_Type) q_.list().get(0);
      }
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

  public static C_Img_Type get_img_type_by_code(Session session_, String code_) {
    C_Img_Type res = null;
    Query q_ = session_.createQuery("from C_Img_Type where is_deleted=false and code=:code_ ");
    q_.setString("code_", code_);
  //q_.setCacheable(use_query_cache);
    if (!q_.list().isEmpty()) {
      res = (C_Img_Type) q_.list().get(0);
    }
    return res;
  }

  public List<C_Img_Type> get_img_type_list() {
    Transaction tx = null;
    List<C_Img_Type> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Img_Type where is_deleted=false order by c_img_type desc");
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

  public List<C_Img_Type> get_img_type_list(SQL_Order_Condition sql_order_condition_) {
    Transaction tx = null;
    List<C_Img_Type> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Img_Type where is_deleted=false order by " + sql_order_condition_.getField_name() + " " + sql_order_condition_.getSort_order());
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
}
