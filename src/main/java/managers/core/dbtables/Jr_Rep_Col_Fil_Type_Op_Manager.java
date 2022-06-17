package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class Jr_Rep_Col_Fil_Type_Op_Manager extends Abstract_Controller_Manager<Jr_Rep_Col_Fil_Type_Op> {

  private static Jr_Rep_Col_Fil_Type_Op_Manager currentInstance = null;

  public static Jr_Rep_Col_Fil_Type_Op_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Rep_Col_Fil_Type_Op_Manager();
    }
    return currentInstance;
  }

  public Jr_Rep_Col_Fil_Type_Op_Manager() {
    super(Jr_Rep_Col_Fil_Type_Op.class);
  }

  public List<Jr_Rep_Col_Fil_Type_Op> get_jr_rep_col_fil_type_op_list() {
    Transaction tx = null;
    List<Jr_Rep_Col_Fil_Type_Op> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from Jr_Rep_Col_Fil_Type_Op  order by jr_rep_col_fil_type_op asc");
    //q_.setCacheable(use_query_cache);
      res = q_.list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public List<Jr_Rep_Col_Fil_Type_Op> get_jr_rep_col_fil_type_op_list(Integer jr_rep_col_fil_type_id_) {
    Transaction tx = null;
    List<Jr_Rep_Col_Fil_Type_Op> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from Jr_Rep_Col_Fil_Type_Op where jr_rep_col_fil_type.jr_rep_col_fil_type=:jr_rep_col_fil_type_id_ order by jr_rep_col_fil_type_op asc");
    //q_.setCacheable(use_query_cache);
      q_.setInteger("jr_rep_col_fil_type_id_", jr_rep_col_fil_type_id_);
      res = q_.list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
  public List<Jr_Rep_Col_Fil_Type_Op> get_jr_rep_col_fil_type_op_list(SQL_Order_Condition sql_order_condition_) {
    Transaction tx = null;
    List<Jr_Rep_Col_Fil_Type_Op> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from Jr_Rep_Col_Fil_Type_Op  order by " + sql_order_condition_.getField_name() + " " + sql_order_condition_.getSort_order());
    //q_.setCacheable(use_query_cache);
      res = q_.list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }  
}
