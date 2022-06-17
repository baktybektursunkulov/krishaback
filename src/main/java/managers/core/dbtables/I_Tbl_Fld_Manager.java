package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import gs.common.model.db.*;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;
import static managers.core.dbtables.I_Tbl_Fld_Trans_Manager.get_tbl_fld_val;

@ManagedBean
@ApplicationScoped
public class I_Tbl_Fld_Manager extends Abstract_Controller_Manager<I_Tbl_Fld> {

  private static I_Tbl_Fld_Manager currentInstance = null;

  public static I_Tbl_Fld_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new I_Tbl_Fld_Manager();
    }
    return currentInstance;
  }

  public I_Tbl_Fld_Manager() {
    super(I_Tbl_Fld.class);
  }

  public I_Tbl_Fld get_i_tbl_fld_2(Session session_, String i_tbl_name_, String i_tbl_fld_name_) {
    I_Tbl_Fld res = null;
    Query q_ = session_.createQuery("select t from I_Tbl_Fld t, I_Tbl t2 where t.is_deleted=false and t.i_tbl=t2.i_tbl and t2.name=:i_tbl_name_ and t.name=:i_tbl_fld_name_");
    q_.setString("i_tbl_name_", i_tbl_name_);
    q_.setString("i_tbl_fld_name_", i_tbl_fld_name_);
    //q_.setCacheable(use_query_cache);
    List<I_Tbl_Fld> list_ = q_.list();
    if (!list_.isEmpty()) {
      res = list_.get(0);
    }
    return res;
  }

  public I_Tbl_Fld get_i_tbl_fld_3(Integer i_tbl_id_, String i_tbl_fld_name_) {
    I_Tbl_Fld res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_i_tbl_fld_3(session_, i_tbl_id_, i_tbl_fld_name_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
  public I_Tbl_Fld get_i_tbl_fld_3(Session session_, Integer i_tbl_id_, String i_tbl_fld_name_) {
    I_Tbl_Fld res = null;
    Query q_ = session_.createQuery("select t from I_Tbl_Fld t where t.is_deleted=false and t.i_tbl=:i_tbl_id_ and t.name=:i_tbl_fld_name_");
    q_.setInteger("i_tbl_id_", i_tbl_id_);
    q_.setString("i_tbl_fld_name_", i_tbl_fld_name_);
    //q_.setCacheable(use_query_cache);
    List<I_Tbl_Fld> list_ = q_.list();
    if (!list_.isEmpty()) {
      res = list_.get(0);
    }
    return res;
  }


  public List<I_Tbl_Fld> get_i_tbl_fld_list(Integer i_tbl_id_) {
    Transaction tx = null;
    List<I_Tbl_Fld> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from I_Tbl_Fld where is_deleted=false and i_tbl=:i_tbl_id_ order by name asc");
      q_.setInteger("i_tbl_id_", i_tbl_id_);
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

  public I_Tbl_Fld get_row_by_name_with_ins_if_not_exists(Session session_, Integer i_tbl_id_, String i_tbl_fld_name_) {
    I_Tbl_Fld res;
    //I_Tbl i_tbl_ = I_Tbl_Manager.getCI().get_row_by_name_with_ins_if_not_exists(session_, i_tbl_name_);
    res = I_Tbl_Fld_Manager.getCI().get_i_tbl_fld_3(session_, i_tbl_id_, i_tbl_fld_name_);
    if (res == null) {
      res = new I_Tbl_Fld();
      res.setI_tbl(i_tbl_id_);
      res.setName(i_tbl_fld_name_);
      res.setIs_html_format(false);
      res.setIs_deleted(false);
      I_Tbl_Fld_Manager.getCI().insert_rec(session_, res);
    }
    return res;
  }

}
