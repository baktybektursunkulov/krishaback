package managers.core.dbtables;

import beans.CUsrBean;
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
public class Jr_Rep_Col_Manager extends Abstract_Controller_Manager<Jr_Rep_Col> {

  private static Jr_Rep_Col_Manager currentInstance = null;

  public static Jr_Rep_Col_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Rep_Col_Manager();
    }
    return currentInstance;
  }

  public Jr_Rep_Col_Manager() {
    super(Jr_Rep_Col.class);
  }

  public List<Jr_Rep_Col> get_jr_rep_col_list(Integer jr_rep_id_) {
    Transaction tx = null;
    List<Jr_Rep_Col> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_jr_rep_col_list(session_, jr_rep_id_);
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

  public List<Jr_Rep_Col> get_jr_rep_col_list(Session session_, Integer jr_rep_id_) {
    List<Jr_Rep_Col> res = null;
    Query q_ = session_.createQuery("from Jr_Rep_Col where jr_rep.jr_rep=:jr_rep_id_ order by order_num asc");
  //q_.setCacheable(use_query_cache);
    q_.setInteger("jr_rep_id_", jr_rep_id_);
    res = q_.list();
    return res;
  }

  public List<Jr_Rep_Col> get_jr_rep_col_list(SQL_Order_Condition sql_order_condition_) {
    Transaction tx = null;
    List<Jr_Rep_Col> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from Jr_Rep_Col  order by " + sql_order_condition_.getField_name() + " " + sql_order_condition_.getSort_order());
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

  public void del_by_jr_rep_id(Session session_, Integer jr_rep_id_) {
    Query q_ = session_.createQuery("delete from Jr_Rep_Col where jr_rep.jr_rep=:jr_rep_id_ ");
    q_.setInteger("jr_rep_id_", jr_rep_id_);
    q_.executeUpdate();
  }

  public List<Jr_Rep_Tpl_Col> get_jr_rep_tpl_col_list_by_jr_rep_id(Integer jr_rep_id_) {
    List<Jr_Rep_Tpl_Col> res = null;
    Transaction tx_ = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      res = get_jr_rep_tpl_col_list_by_jr_rep_id(session_, jr_rep_id_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
    } finally {
      if (tx_ != null) {
        hibernate_funcs.commitAndClose(session_);
      }
    }
    return res;
  }

  public List<Jr_Rep_Tpl_Col> get_jr_rep_tpl_col_list_by_jr_rep_id(Session session_, Integer jr_rep_id_) {
    //List<Jr_Rep_Tpl_Col> res = new ArrayList();
    if (jr_rep_id_ == null) {
      jr_rep_id_ = -1;
    }
    Query q_ = session_.createQuery("select t.jr_rep_tpl_col from Jr_Rep_Col t where t.jr_rep.jr_rep=:jr_rep_id_ order by t.jr_rep_tpl_col.name ");
    q_.setInteger("jr_rep_id_", jr_rep_id_);
  //q_.setCacheable(use_query_cache);
    return q_.list();
  }

  public List<Jr_Rep_Col> get_jr_rep_col_list_by_jr_rep_id(Integer jr_rep_id_) {
    List<Jr_Rep_Col> res = null;
    Transaction tx_ = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      res = get_jr_rep_col_list_by_jr_rep_id(session_, jr_rep_id_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
    } finally {
      if (tx_ != null) {
        hibernate_funcs.commitAndClose(session_);
      }
    }
    return res;
  }

  public List<Jr_Rep_Col> get_jr_rep_col_list_by_jr_rep_id(Session session_, Integer jr_rep_id_) {
    //List<Jr_Rep_Tpl_Col> res = new ArrayList();
    Query q_ = session_.createQuery("from Jr_Rep_Col t where t.jr_rep.jr_rep=:jr_rep_id_ order by t.jr_rep_tpl_col.name ");
    q_.setInteger("jr_rep_id_", jr_rep_id_);
  //q_.setCacheable(use_query_cache);
    return q_.list();
  }

  public Integer get_jr_rep_tpl_col_cnt_by_jr_rep_id(Session session_, Integer jr_rep_id_) {
    //List<Jr_Rep_Tpl_Col> res = new ArrayList();
    Query q_ = session_.createQuery("select count(*) from Jr_Rep_Col t where t.jr_rep.jr_rep=:jr_rep_id_ ");
    q_.setInteger("jr_rep_id_", jr_rep_id_);
    return ((Long) q_.list().get(0)).intValue();
  }

  public List<Jr_Rep_Col> get_jr_rep_col_list_by_C_Usr_id(Session session_, Long c_usr_id_) {
    //List<Jr_Rep_Tpl_Col> res = new ArrayList();
    Query q_ = session_.createQuery("from Jr_Rep_Col t where t.jr_rep.C_Usr.C_Usr=:C_Usr_id_ and t.jr_rep.is_deleted=false order by t.jr_rep.name asc, t.jr_rep_tpl_col.name asc");
    q_.setLong("C_Usr_id_", c_usr_id_);
  //q_.setCacheable(use_query_cache);
    return q_.list();
  }

  public List<Jr_Rep_Col> get_jr_rep_col_list_by_logged_usr(Session session_, C_Usr logged_c_usr_) {
    return get_jr_rep_col_list_by_C_Usr_id(session_, logged_c_usr_.getC_usr());
  }

  public Jr_Rep_Col get_jr_rep_col(Session session_, Integer jr_rep_id_, Integer jr_rep_tpl_col_id_) {
    Query q_ = session_.createQuery("from Jr_Rep_Col t where t.jr_rep.jr_rep=:jr_rep_id_ and t.jr_rep_tpl_col.jr_rep_tpl_col=:jr_rep_tpl_col_id_ ");
    q_.setInteger("jr_rep_id_", jr_rep_id_);
    q_.setInteger("jr_rep_tpl_col_id_", jr_rep_tpl_col_id_);
  //q_.setCacheable(use_query_cache);
    List<Jr_Rep_Col> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }  
}
