package managers.core.dbtables;

import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Order_Condition;
import java.util.Date;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class Jr_Rep_Manager extends Abstract_Controller_Manager<Jr_Rep> {

  private static Jr_Rep_Manager currentInstance = null;
  Jr_Rep default_jr_rep = null;

  public static Jr_Rep_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Rep_Manager();
    }
    return currentInstance;
  }

  public Jr_Rep_Manager() {
    super(Jr_Rep.class);
  }

  public Jr_Rep getDefault_jr_rep() {
    if (default_jr_rep == null) {
      default_jr_rep = get_rec_2(0);
    }
    return default_jr_rep;
  }

  public void setDefault_jr_rep(Jr_Rep default_jr_rep) {
    this.default_jr_rep = default_jr_rep;
  }

  public List<Jr_Rep> get_jr_rep_list() {
    Transaction tx = null;
    List<Jr_Rep> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from Jr_Rep where jr_rep<>0 and is_deleted=false order by order_num asc");
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

  public List<Jr_Rep> get_system_jr_rep_list() {
    Transaction tx = null;
    List<Jr_Rep> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from Jr_Rep where jr_rep<>0 and creator_usr.C_Usr=1 and is_deleted=false order by order_num asc");
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

  public List<Jr_Rep> get_system_jr_rep_list_2(Jr_Rep_Tpl_Grp jr_Rep_Tpl_Grp) {
    Transaction tx = null;
    List<Jr_Rep> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_;
      if (jr_Rep_Tpl_Grp != null) {
        q_ = session_.createQuery("from Jr_Rep where jr_rep<>0 and creator_usr.C_Usr=1 and jr_rep_tpl.jr_rep_tpl_grp=:jr_rep_tpl_grp_id_ and is_deleted=false order by order_num asc");
        q_.setInteger("jr_rep_tpl_grp_id_", jr_Rep_Tpl_Grp.getJr_rep_tpl_grp());
      } else {
        q_ = session_.createQuery("from Jr_Rep where jr_rep<>0 and creator_usr.C_Usr=1 and is_deleted=false order by order_num asc");
      }
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

  public List<Jr_Rep> get_system_jr_rep_list_order_by_name() {
    Transaction tx = null;
    List<Jr_Rep> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from Jr_Rep where jr_rep<>0 and creator_usr.C_Usr=1 and is_deleted=false order by name asc");
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

  public List<Jr_Rep> get_jr_rep_list(SQL_Order_Condition sql_order_condition_) {
    Transaction tx = null;
    List<Jr_Rep> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from Jr_Rep where is_deleted=false order by " + sql_order_condition_.getField_name() + " " + sql_order_condition_.getSort_order());
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

  public static Jr_Rep get_default_jr_rep(Session session_) {
    Jr_Rep res = (Jr_Rep) session_.load(Jr_Rep.class, 0);
    CustomLogger.log(res);
    return res;
  }

  public static void load_default_jr_rep(Session session_, Jr_Rep new_rec_) {
    Jr_Rep def_rec_ = get_default_jr_rep(session_);
    load_default_vals(new_rec_, def_rec_, session_);
  }

  public static void load_default_vals(Jr_Rep new_rec_) {
    if (new_rec_ == null) {
      new_rec_ = new Jr_Rep();
    }
    Jr_Rep def_rec_ = getCI().getDefault_jr_rep();
    load_default_vals(new_rec_, def_rec_, null);
  }

  public static void load_default_vals(Jr_Rep new_rec_, Jr_Rep def_rec_, Session session_) {
    System.err.println("def_rec_=" + def_rec_);
    //new_rec_.setJr_rep_tpl(def_rec_.getJr_rep_tpl());
    new_rec_.setIs_display_report_title(def_rec_.getIs_display_report_title());
    new_rec_.setIs_display_total(def_rec_.getIs_display_total());
    new_rec_.setIs_display_row_num(def_rec_.getIs_display_row_num());
    new_rec_.setIs_title_on_new_page(def_rec_.getIs_title_on_new_page());
    new_rec_.setIs_summary_on_new_page(def_rec_.getIs_summary_on_new_page());
    new_rec_.setIs_summary_with_page_head_foot(def_rec_.getIs_summary_with_page_head_foot());
    new_rec_.setIs_float_column_footer(def_rec_.getIs_float_column_footer());
    new_rec_.setIs_ignore_pagination(def_rec_.getIs_ignore_pagination());
    new_rec_.setIs_create_bookmarks(def_rec_.getIs_create_bookmarks());
    new_rec_.setPage_width(def_rec_.getPage_width());
    new_rec_.setPage_height(def_rec_.getPage_height());
    new_rec_.setPage_top_margin(def_rec_.getPage_top_margin());
    new_rec_.setPage_left_margin(def_rec_.getPage_left_margin());
    new_rec_.setPage_bottom_margin(def_rec_.getPage_bottom_margin());
    new_rec_.setPage_right_margin(def_rec_.getPage_right_margin());
    new_rec_.setJr_rep_page_orient(def_rec_.getJr_rep_page_orient());
    new_rec_.setDate_format_pattern(def_rec_.getDate_format_pattern());
    new_rec_.setTime_format_pattern(def_rec_.getTime_format_pattern());
    new_rec_.setDate_time_format_pattern(def_rec_.getDate_time_format_pattern());
    new_rec_.setC_speed_unit(def_rec_.getC_speed_unit());
    new_rec_.setC_distance_unit(def_rec_.getC_distance_unit());
    new_rec_.setC_volume_unit(def_rec_.getC_volume_unit());
    new_rec_.setIs_add_total(false);
    new_rec_.setIs_grp_by_dates(false);
    new_rec_.setIns_dt(new Date());
    new_rec_.setIs_deleted(false);
    new_rec_.setOrder_num(1);
    new_rec_.setTitle(" ");
  }

  public boolean is_jr_rep_has_period_params(Jr_Rep jr_rep_) {
    return Jr_Rep_Tpl_Param_Manager.getCI().is_jr_rep_tpl_has_period_params(jr_rep_.getJr_rep_tpl_t().getJr_rep_tpl());
  }

  public boolean is_jr_rep_has_period_params(Session session_, Jr_Rep jr_rep_) {
    return Jr_Rep_Tpl_Param_Manager.getCI().is_jr_rep_tpl_has_period_params(session_, jr_rep_.getJr_rep_tpl_t_2(session_).getJr_rep_tpl());
  }

  public boolean is_jr_rep_has_obj_params(Jr_Rep jr_rep_) {
    return Jr_Rep_Tpl_Param_Manager.getCI().is_jr_rep_tpl_has_obj_params(jr_rep_.getJr_rep_tpl_t().getJr_rep_tpl());
  }

  public boolean is_jr_rep_has_obj_params(Session session_, Jr_Rep jr_rep_) {
    return Jr_Rep_Tpl_Param_Manager.getCI().is_jr_rep_tpl_has_obj_params(session_, jr_rep_.getJr_rep_tpl_t_2(session_).getJr_rep_tpl());
  }

  public boolean is_jr_rep_has_add_params(Jr_Rep jr_rep_) {
    return Jr_Rep_Tpl_Param_Manager.getCI().is_jr_rep_tpl_has_add_params(jr_rep_.getJr_rep_tpl_t().getJr_rep_tpl());
  }

  public boolean is_jr_rep_has_add_params(Session session_, Jr_Rep jr_rep_) {
    return Jr_Rep_Tpl_Param_Manager.getCI().is_jr_rep_tpl_has_add_params(session_, jr_rep_.getJr_rep_tpl_t_2(session_).getJr_rep_tpl());
  }

  public Jr_Rep get_clone_jr_rep(Integer jr_rep_id_) throws Exception {
    return (Jr_Rep) (get_rec_2(jr_rep_id_).clone());
  }

  public Jr_Rep get_clone_jr_rep_2(Session core_session_, Integer jr_rep_id_) throws Exception {
    return (Jr_Rep) (get_rec(core_session_, jr_rep_id_).clone());
  } 
  
}
