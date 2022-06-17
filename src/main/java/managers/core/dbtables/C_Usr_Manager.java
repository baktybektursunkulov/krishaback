package managers.core.dbtables;

import beans.CUsrBean;
import gs.common.date_time_funcs;
import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Transaction;
import others.CustomLogger;
import gs.common.model.db.SQL_Order_Condition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.core_custom_funcs;

@ManagedBean
@ApplicationScoped
public class C_Usr_Manager extends Abstract_Controller_Manager<C_Usr> {

  private static C_Usr_Manager currentInstance = null;

  public static C_Usr_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Manager() {
    super(C_Usr.class);
  }

  public List<C_Usr> getCreator_usr_list_for_logged_usr(C_Usr logged_c_usr_) {
    return C_Usr_Manager.getCI().get_creator_usr_list_for_logged_usr(logged_c_usr_);
  }

  public static C_Usr get_demo_c_usr(Integer c_proj_id_, Integer c_usr_type_id_) {
    return get_c_usr_by_name(c_proj_id_, c_usr_type_id_, "demo");
  }

  public static void delete_c_usr(Integer rec_id_) {
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Transaction tx = null;
    try {
      tx = session_.beginTransaction();
      delete_c_usr(session_, rec_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public static void delete_c_usr(Session session_, Integer rec_id_) {
    C_Usr new_rec_ = C_Usr_Manager.getCI().get_rec(session_, rec_id_);
    new_rec_.setIs_deleted(true);
    session_.merge(new_rec_);

    /*    
    // C_Tbl_Rec_Prop_Val
    {
      List<C_Tbl_Rec_Prop_Val> obj_prop_val_list_ = C_Tbl_Rec_Prop_Val_Manager.getCI().get_c_tbl_rec_prop_val_list(session_, Object_Type_Manager.c_object_type_id_c_usr, String.valueOf(rec_id_));
      for (int i = 0; i < obj_prop_val_list_.size(); i++) {
        C_Tbl_Rec_Prop_Val_Manager.getCI().delete_rec(session_, obj_prop_val_list_.get(i).getObject_prop_val());
      }
    }

    // C_Poi
    {
      List<C_Poi> list_ = C_Poi_Manager.getCI().get_c_poi_list(session_, rec_id_);
      for (int i = 0; i < list_.size(); i++) {
        C_Poi_Manager.getCI().delete_rec(session_, list_.get(i).getC_poi());
      }
    }

    // C_Gz
    {
      List<C_Gz> list_ = C_Gz_Manager.get_c_gz_list_by_c_usr(session_, rec_id_);
      for (int i = 0; i < list_.size(); i++) {
        C_Gz_Manager.getCI().delete_rec(session_, list_.get(i).getC_gz());
      }
    }

    // C_Obj_Indic_Val
    {
      List<C_Obj_Indic_Val> list_ = C_Obj_Indic_Val_Manager.getCI().get_c_obj_indic_val_list_by_usr_id(session_, rec_id_);
      for (int i = 0; i < list_.size(); i++) {
        C_Obj_Indic_Val_Manager.getCI().delete_rec(session_, list_.get(i).getC_obj_indic_val());
      }
    }

    // C_Usr_Access
    {
      List<C_Usr_Access> c_usr_access_list_ = C_Usr_Access_Manager.getCI().get_c_usr_access_list(session_, rec_id_);
      for (int i = 0; i < c_usr_access_list_.size(); i++) {
        C_Usr_Access_Manager.getCI().delete_rec(session_, c_usr_access_list_.get(i).getC_usr_access());
      }
    }
    {
      List<C_Usr_Access> c_usr_access_list_ = C_Usr_Access_Manager.getCI().get_from_c_usr_access_list(session_, rec_id_);
      for (int i = 0; i < c_usr_access_list_.size(); i++) {
        C_Usr_Access_Manager.getCI().delete_rec(session_, c_usr_access_list_.get(i).getC_usr_access());
      }
    }
    {
      List<C_Usr_Access> c_usr_access_list_ = C_Usr_Access_Manager.getCI().get_receiver_c_usr_access_list(session_, rec_id_);
      for (int i = 0; i < c_usr_access_list_.size(); i++) {
        C_Usr_Access_Manager.getCI().delete_rec(session_, c_usr_access_list_.get(i).getC_usr_access());
      }
    }

    // C_Obj_Access
    {
      List<C_Obj_Access> c_obj_access_list_ = C_Obj_Access_Manager.getCI().get_c_obj_access_list_by_c_usr_id(session_, rec_id_);
      for (int i = 0; i < c_obj_access_list_.size(); i++) {
        C_Obj_Access_Manager.getCI().delete_rec(session_, c_obj_access_list_.get(i).getC_obj_access());
      }
    }
    {
      List<C_Obj_Access> c_obj_access_list_ = C_Obj_Access_Manager.getCI().get_c_obj_access_list_by_from_c_usr_id(session_, rec_id_);
      for (int i = 0; i < c_obj_access_list_.size(); i++) {
        C_Obj_Access_Manager.getCI().delete_rec(session_, c_obj_access_list_.get(i).getC_obj_access());
      }
    }

    // C_Usr_Custom_Fld
    {
      List<C_Usr_Custom_Fld> list_ = C_Usr_Custom_Fld_Manager.getCI().get_c_usr_custom_fld_list(session_, rec_id_);
      for (int i = 0; i < list_.size(); i++) {
        C_Usr_Custom_Fld_Manager.getCI().delete_rec(session_, list_.get(i).getC_usr_custom_fld());
      }
    }

    // C_Usr_Log
    {
      List<C_Usr_Log> c_usr_log_list_ = C_Usr_Log_Manager.getCI().get_c_usr_log_list(session_, rec_id_);
      for (int i = 0; i < c_usr_log_list_.size(); i++) {
        C_Usr_Log_Manager.getCI().delete_rec(session_, c_usr_log_list_.get(i).getC_usr_log());
      }
    }

    // Childs
    {
      List<C_Usr> list_ = getCI().get_child_c_usr_list(session_, rec_id_);
      for (int i = 0; i < list_.size(); i++) {
        C_Usr_Manager.delete_c_usr(session_, list_.get(i).getC_usr());
      }
    }

    // C_Obj
    {
      List<C_Obj> c_obj_list_ = C_Obj_Manager.get_c_obj_list_by_creator_usr(session_, rec_id_);
      for (int i = 0; i < c_obj_list_.size(); i++) {
        C_Obj_Manager.delete_c_obj(session_, c_obj_list_.get(i));
      }
    }

    // C_Usr_Tariff
    {
      List<C_Usr_Tariff> c_usr_tariff_list_ = C_Usr_Tariff_Manager.getCI().get_c_usr_tariff_list_by_creator_usr_3(session_, rec_id_);
      for (int i = 0; i < c_usr_tariff_list_.size(); i++) {
        C_Usr_Tariff_Manager.getCI().delete_rec(session_, c_usr_tariff_list_.get(i).getC_usr_tariff());
      }
    }

    // C_Obj_Tariff
    {
      List<C_Obj_Tariff> c_obj_tariff_list_ = C_Obj_Tariff_Manager.getCI().get_c_obj_tariff_list_by_creator_usr_3(session_, rec_id_);
      for (int i = 0; i < c_obj_tariff_list_.size(); i++) {
        C_Obj_Tariff_Manager.getCI().delete_rec(session_, c_obj_tariff_list_.get(i).getC_obj_tariff());
      }
    }

    // C_Site
    {
      List<C_Site> C_Site_list_ = C_Site_Manager.getCI().get_c_site_list(session_, rec_id_);
      for (int i = 0; i < C_Site_list_.size(); i++) {
        C_Site_Manager.getCI().delete_rec(session_, C_Site_list_.get(i).getC_site());
      }
    }

    // C_Usr_Bal_Op
    {
      List<C_Usr_Bal_Op> c_usr_bal_op_list_ = C_Usr_Bal_Op_Manager.getCI().get_c_usr_bal_op_list_ordered_by_c_usr_bal_op(session_, rec_id_);
      for (int i = 0; i < c_usr_bal_op_list_.size(); i++) {
        C_Usr_Bal_Op_Manager.getCI().delete_rec(session_, c_usr_bal_op_list_.get(i).getC_usr_bal_op());
      }
    }

    // C_Usr_Day_Op c_usr
    {
      List<C_Usr_Day_Op> c_usr_day_op_list_ = C_Usr_Day_Op_Manager.getCI().get_c_usr_day_op_list_ordered_by_c_usr_day_op(session_, rec_id_);
      for (int i = 0; i < c_usr_day_op_list_.size(); i++) {
        C_Usr_Day_Op_Manager.getCI().delete_rec(session_, c_usr_day_op_list_.get(i).getC_usr_day_op());
      }
    }
    // C_Usr_Day_Op c_usr_2
    {
      List<C_Usr_Day_Op> c_usr_day_op_list_ = C_Usr_Day_Op_Manager.getCI().get_c_usr_day_op_list_ordered_by_c_usr_day_op_2(session_, rec_id_);
      for (int i = 0; i < c_usr_day_op_list_.size(); i++) {
        C_Usr_Day_Op_Manager.getCI().delete_rec(session_, c_usr_day_op_list_.get(i).getC_usr_day_op());
      }
    }

    try {
      C_Usr c_usr_ = (C_Usr) session_.load(C_Usr.class, rec_id_);
      session_.delete(c_usr_);
    } catch (org.hibernate.ObjectNotFoundException e) {
    }
     */
  }

  public List<C_Usr> get_c_usr_list() {
    Transaction tx = null;
    List<C_Usr> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Usr where is_deleted=false order by c_usr desc");
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

  public List<C_Usr> get_child_c_usr_list(Session session_, Long c_usr_id_) {
    List<C_Usr> res = null;
    Query q_ = session_.createQuery("from C_Usr where creator_usr.c_usr=:c_usr_id_ and is_deleted=false order by c_usr desc");
    //q_.setCacheable(use_query_cache);
    q_.setLong("c_usr_id_", c_usr_id_);
    res = q_.list();
    return res;
  }

  public List<C_Usr> get_creator_usr_list() {
    Transaction tx = null;
    List<C_Usr> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Usr where creator_usr is null and c_usr <> 1 and is_deleted=false order by c_usr desc");
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

  public List<C_Usr> get_creator_usr_list_sorted_by_name() {
    Transaction tx = null;
    List<C_Usr> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Usr where c_usr <> 1 and is_deleted=false order by name asc");
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

  /*
   public List<C_Usr> get_creator_usr_list_for_logged_usr(Session session_, int logged_usr_id_) {
   List<C_Usr> list_
   Query q_ = session_.createQuery("from C_Usr t where t.creator_usr.c_usr = :logged_usr_id_ and t.is_deleted=false ");
//q_.setCacheable(use_query_cache);
   List<C_Usr> list_ = q_.list();
   for (int i=0; i<list_.size(); i++) {
      
   }
   return list_;
   }
   */
  public List<C_Usr> get_creator_usr_list_for_logged_usr(C_Usr logged_c_usr_) {
    CustomLogger.log("get_creator_usr_list_for_logged_usr begin");
    Transaction tx = null;
    List<C_Usr> res = new ArrayList<C_Usr>();
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.getNamedQuery("C_Usr.get_creator_usr_list_for_logged_usr");
      //q_.setCacheable(use_query_cache);
      q_.setLong("logged_usr_id", logged_c_usr_.getC_usr());
      List list_ = q_.list();

      Long c_usr_id_ = null;
      Object[] object_arr_ = null;
      for (int i = 0; i < list_.size(); i++) {
        object_arr_ = (Object[]) (list_.get(i));
        c_usr_id_ = (Long) (object_arr_[0]);
        //CustomLogger.log("i=" + i + "; " + c_usr_id_);
        res.add((C_Usr) session_.load(C_Usr.class, c_usr_id_));
      }
//      q = session_.createQuery("from C_Usr where creator_usr is null and c_usr <> 1 order by c_usr desc");
//     res = q.list();

      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    CustomLogger.log("get_creator_usr_list_for_logged_usr end count=" + res.size());
    return res;
  }

  public List<C_Usr> get_c_usr_list_for_logged_usr(C_Usr logged_c_usr_) {
    //CustomLogger.log("get_c_usr_usr_list_for_logged_usr begin");
    if (logged_c_usr_ == null) {
      return null;
    }
    Transaction tx = null;
    List<C_Usr> res = new ArrayList<C_Usr>();
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q = session_.getNamedQuery("C_Usr.get_creator_usr_list_for_logged_usr");
      //q.setCacheable(use_query_cache);
      q.setLong("logged_usr_id", logged_c_usr_.getC_usr());
      List list_ = q.list();

      Long c_usr_id_ = null;
      Object[] object_arr_ = null;
      for (int i = 0; i < list_.size(); i++) {
        object_arr_ = (Object[]) (list_.get(i));
        c_usr_id_ = (Long) (object_arr_[0]);
        CustomLogger.log("i=" + i + "; " + c_usr_id_);
        if (!c_usr_id_.equals(logged_c_usr_.getC_usr())) {
          res.add((C_Usr) session_.load(C_Usr.class, c_usr_id_));
        }
      }
//      q = session_.createQuery("from C_Usr where creator_usr is null and c_usr <> 1 order by c_usr desc");
//     res = q.list();

      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    //CustomLogger.log("get_c_usr_usr_list_for_logged_usr end count=" + res.size());
    return res;
  }

  public C_Usr get_default_c_usr(Integer c_proj_id_, Integer c_usr_type_id_) {
    C_Usr res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_default_c_usr(session_, c_proj_id_, c_usr_type_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public static C_Usr get_default_c_usr(Session session_, Integer c_proj_id_, Integer c_usr_type_id_) {
    C_Usr res = null;
    Query q_ = session_.createQuery("from C_Usr where c_proj=:c_proj_id_ and c_usr_type=:c_usr_type_id_ and name='default' and is_deleted=false");
    q_.setInteger("c_proj_id_", c_proj_id_);
    q_.setInteger("c_usr_type_id_", c_usr_type_id_);
    List<C_Usr> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return res;
  }

  /*
   public static void load_default_vals(Session session_, C_Usr new_rec_) {
   C_Usr def_rec_ = get_default_c_usr(session_);
   load_default_vals(new_rec_, def_rec_, session_);
   }

   public static void load_default_vals(C_Usr new_rec_) {
   C_Usr def_rec_ = getCI().getDefault_c_usr();
   load_default_vals(new_rec_, def_rec_, null);
   CustomLogger.log("new_rec_2_=" + new_rec_);
   }
   */
  public static C_Usr get_new_c_usr_with_loaded_default_vals(Integer c_proj_id_, Integer c_usr_type_id_) {
    C_Usr res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_new_c_usr_with_loaded_default_vals(session_, c_proj_id_, c_usr_type_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public static C_Usr get_new_c_usr_with_loaded_default_vals(Session session_, Integer c_proj_id_, Integer c_usr_type_id_) {
    C_Usr res = null;
    C_Usr def_rec_ = get_default_c_usr(session_, c_proj_id_, c_usr_type_id_);
    //new_rec_.setName(def_rec_.getName());
    res = (C_Usr) def_rec_.clone();
    res.setC_usr(null);
    res.setName("");
    res.setPswd("");
    res.setPswd_salt("");
    res.setOur_note("");
    res.setEmail("");
    res.setIs_deleted(false);
    return res;
  }

  /*
   public static void load_default_vals(C_Usr new_rec_, C_Usr def_rec_, Session session_) {
   CustomLogger.log("def_rec_=" + def_rec_);
   try {
   //new_rec_.setName(def_rec_.getName());
   new_rec_ = (C_Usr)def_rec_.clone();
   } catch (CloneNotSupportedException ex) {
   CustomLogger.error_with_c_usr_login(ex);
   }
   CustomLogger.log("new_rec_=" + new_rec_);
   new_rec_.setC_usr(null);
   }
   */
  public static List<C_Usr> get_c_usr_list_ordered_by_usr_name() {
    Transaction tx = null;
    List res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Usr where c_usr <> 1 and is_deleted=false order by name asc");
      //q_.setCacheable(use_query_cache);
      res = q_.list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static List<C_Usr> get_c_usr_list_ordered_by_usr_name(String search_usr_name_) {
    Transaction tx = null;
    List res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Usr "
        + " where "
        + "  c_usr <> 1 "
        + "  and is_deleted=false "
        + "  and lower(name) like '%" + search_usr_name_.toLowerCase() + "%'"
        + " order by name asc");
      //q_.setCacheable(use_query_cache);
      res = q_.list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static C_Usr get_c_usr_by_name(Integer c_proj_id_, Integer c_usr_type_id_, String name_) {
    C_Usr res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_usr_by_name(session_, c_proj_id_, c_usr_type_id_, name_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static C_Usr get_c_usr_by_name(Session session_, Integer c_proj_id_, Integer c_usr_type_id_, String name_) {
    C_Usr res = null;
    Query q = session_.createQuery("from C_Usr t where t.is_deleted=false and t.c_proj=:c_proj_id_ and t.c_usr_type=:c_usr_type_id_ and t.name=:name_ ");
    q.setCacheable(use_query_cache);
    q.setInteger("c_proj_id_", c_proj_id_);
    q.setInteger("c_usr_type_id_", c_usr_type_id_);
    q.setString("name_", name_);
    List<C_Usr> c_usr_list_ = q.list();
    if (c_usr_list_.size() > 0) {
      res = c_usr_list_.get(0);
    }
    return res;
  }

  public static Boolean is_c_usr_by_name_exists(Session session_, Integer c_proj_id_, Integer c_usr_type_id_, String name_) {
    return get_c_usr_by_name(session_, c_proj_id_, c_usr_type_id_, name_) != null;
  }

  public static Boolean is_c_usr_by_name_exists(Integer c_proj_id_, Integer c_usr_type_id_, String name_) {
    return get_c_usr_by_name(c_proj_id_, c_usr_type_id_, name_) != null;
  }

  public static List<C_Usr> get_c_usr_list_by_creator_usr(Integer creator_usr_id_) {
    List<C_Usr> res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_usr_list_by_creator_usr(session_, creator_usr_id_);
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

  public static List<C_Usr> get_c_usr_list_by_creator_usr(Session session_, Integer creator_usr_id_) {
    List<C_Usr> res = null;
    Query q = session_.getNamedQuery("C_Usr.find_by_creator_usr");
    q.setCacheable(use_query_cache);
    q.setInteger("creator_usr_id", creator_usr_id_);
    res = q.list();
    return res;
  }

  public List<C_Usr> get_c_usr_list_by_creator_usr_for_logged_usr(C_Usr logged_c_usr_) {
    List<C_Usr> res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_usr_list_by_creator_usr_for_logged_usr(session_, logged_c_usr_);
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

  public List<C_Usr> get_c_usr_list_by_creator_usr_for_logged_usr(Session session_, C_Usr logged_c_usr_) {
    List<C_Usr> res = null;
    Query q = session_.getNamedQuery("C_Usr.find_by_creator_usr");
    q.setCacheable(use_query_cache);
    q.setLong("creator_usr_id", logged_c_usr_.getC_usr());
    res = q.list();
    return res;
  }

  public SimpleDateFormat get_c_usr_timestamp_sdf(C_Usr c_usr_) {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  }

  public SimpleDateFormat get_logged_c_usr_timestamp_sdf(C_Usr logged_c_usr_) {
    return get_c_usr_timestamp_sdf(logged_c_usr_);
  }

  public String timestampToStr(C_Usr c_usr_, Date date_) {
    SimpleDateFormat sdf_ = get_c_usr_timestamp_sdf(c_usr_);
    return sdf_.format(date_);
  }

  public String loggedUsrTimestampToStr(C_Usr logged_c_usr_, Date date_) {
    return timestampToStr(logged_c_usr_, date_);
  }

  public static void setUsrPropVal(C_Usr c_usr_, String prop_code_, String prop_val_) {
    C_Tbl_Rec_Prop_Val_Manager.getCI().set_string_c_tbl_rec_prop_val("c_usr", (long) c_usr_.getC_usr(), prop_code_, prop_val_);
  }

  public static void setUsrPropVal(Session session_, C_Usr c_usr_, String prop_code_, String prop_val_) {
    C_Tbl_Rec_Prop_Val_Manager.getCI().set_string_c_tbl_rec_prop_val(session_, "c_usr", (long) c_usr_.getC_usr(), prop_code_, prop_val_);
  }

  public static void setLoggedUsrPropVal(C_Usr logged_c_usr_, String prop_code_, String prop_val_) {
    setUsrPropVal(logged_c_usr_, prop_code_, prop_val_);
  }

  /*
  public static void setUsrPropValInThread(C_Usr c_usr_, String prop_code_, String prop_val_) {
    //C_Tbl_Rec_Prop_Val_Manager.getCI().set_string_c_tbl_rec_prop_val("c_usr", c_usr_.getC_usr(), prop_code_, prop_val_);
    new setUsrPropValThread(c_usr_, prop_code_, prop_val_);
  }
   */
 /*
  public static void setLoggedUsrPropValInThread(C_Usr logged_c_usr_, String prop_code_, String prop_val_) {
    new setUsrPropValThread(logged_c_usr_, prop_code_, prop_val_);
  }
   */
 /*
  public static class setUsrPropValThread implements Runnable {

    private C_Usr c_usr;
    private String prop_code;
    private String prop_val;

    public setUsrPropValThread(C_Usr c_usr_, String prop_code_, String prop_val_) {
      prop_code = prop_code_;
      prop_val = prop_val_;
      c_usr = c_usr_;
      new Thread(this).start();
    }

    @Override
    public void run() {
      setUsrPropVal(this.c_usr, this.prop_code, this.prop_val);
    }
  }
   */
  public String getUsrPropVal(C_Usr c_usr_, String prop_code_) {
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_string_c_tbl_rec_prop_val("c_usr", (long) c_usr_.getC_usr(), prop_code_);
  }

  public String getUsrPropVal(Session session_, C_Usr c_usr_, String prop_code_) {
    //CustomLogger.log("getUsrPropVal, prop_code_=" + prop_code_ + ", c_usr_=" + c_usr_);
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_string_c_tbl_rec_prop_val(session_, "c_usr", (long) c_usr_.getC_usr(), prop_code_);
  }

  public String getLoggedUsrPropVal(C_Usr logged_c_usr_, String prop_code_) {
    //CustomLogger.log("getLoggedUsrPropVal, prop_code_=" + prop_code_);
    return getUsrPropVal(logged_c_usr_, prop_code_);
  }

  public String getLoggedUsrPropVal(Session session_, C_Usr logged_c_usr_, String prop_code_) {
    return getUsrPropVal(session_, logged_c_usr_, prop_code_);
  }

  public Date getCorrectedEvtDtFromDatabase(C_Usr c_usr_, Date evt_dt_) {
    //CustomLogger.log("c_usr_=" + c_usr_ + ", evt_dt_=" + evt_dt_);
    return new Date(evt_dt_.getTime() + c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000);
  }

  public Date getCorrectedEvtDtFromDatabasePlusServerTZ(C_Usr c_usr_, Date evt_dt_) {
    //CustomLogger.log("c_usr_=" + c_usr_ + ", evt_dt_=" + evt_dt_);
    return new Date(evt_dt_.getTime() + c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000 + evt_dt_.getTimezoneOffset() * 60 * 1000);
  }

  public Date getCorrectedEvtDtForDatabase(C_Usr c_usr_, Date evt_dt_) {
    return new Date(evt_dt_.getTime() - c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000);
  }

  public Date getCorrectedEvtDtForDatabasePlusServerTZ(C_Usr c_usr_, Date evt_dt_) {
    return new Date(evt_dt_.getTime() - c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000 - evt_dt_.getTimezoneOffset() * 60 * 1000);
  }

  public Date getUsrTimeFromServerTime(C_Usr c_usr_, Date server_time_) {
    return new java.util.Date(server_time_.getTime() + server_time_.getTimezoneOffset() * 60 * 1000 + c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000);
  }

  public Date getUsrTimeFromAnotherTZ(C_Usr c_usr_, Date dt_, C_Tz another_c_tz_) {
    return new java.util.Date(dt_.getTime() - another_c_tz_.getInterval_in_min() * 60 * 1000 + c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000);
  }

  public Date getUsrTimeFromGMT0600TZ(C_Usr c_usr_, Date dt_) {
    return new java.util.Date(dt_.getTime() - 360 * 60 * 1000 + c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000);
  }

  public Date getUsrTimeToGMT0600TZ(C_Usr c_usr_, Date dt_) {
    return new java.util.Date(dt_.getTime() + 360 * 60 * 1000 - c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000);
  }

  public Date getUsrTimeToGMT00TZ(C_Usr c_usr_, Date dt_) {
    return new java.util.Date(dt_.getTime() - c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000);
  }

  public Date getServerTimeFromUsrTime(C_Usr c_usr_, Date usr_time_) {
    return new java.util.Date(usr_time_.getTime() - usr_time_.getTimezoneOffset() * 60 * 1000 - c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000);
  }

  public Date getCorrectedNow(C_Usr c_usr_) {
    java.util.Date now_ = new java.util.Date();
    return getCorrectedDt(c_usr_, now_);
  }

  public Date getCorrectedDt(C_Usr c_usr_, java.util.Date date_) {
    return new java.util.Date(date_.getTime() + date_.getTimezoneOffset() * 60 * 1000 + c_usr_.getC_tz_t().getInterval_in_min() * 60 * 1000);
  }

  public Date getLoggedUsrCorrectedNow(C_Usr logged_c_usr_) {
    return getCorrectedNow(logged_c_usr_);
  }

  public Date getLoggedUsrCorrectedEvtDt(C_Usr logged_c_usr_, Date evt_dt_) {
    return getCorrectedEvtDtFromDatabase(logged_c_usr_, evt_dt_);
  }

  public C_Tbl_Rec_Prop_Val getLoggedUsrObjectPropVal(C_Usr logged_c_usr_, String object_prop_code_) {
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_c_tbl_rec_prop_val("c_usr", (long) logged_c_usr_.getC_usr(), object_prop_code_);
  }

  public C_Tbl_Rec_Prop_Val getLoggedUsrObjectPropVal(Session session_, C_Usr logged_c_usr_, String object_prop_code_) {
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_c_tbl_rec_prop_val(session_, "c_usr", (long) logged_c_usr_.getC_usr(), object_prop_code_);
  }

  public C_Tbl_Rec_Prop_Val getUsrObjectPropVal(Session session_, C_Usr c_usr_, String object_prop_code_) {
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_c_tbl_rec_prop_val(session_, "c_usr", (long) c_usr_.getC_usr(), object_prop_code_);
  }

  public String getLoggedUsrStringObjectPropVal(C_Usr logged_c_usr_, String object_prop_code_) {
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_string_c_tbl_rec_prop_val("c_usr", (long) logged_c_usr_.getC_usr(), object_prop_code_);
  }

  public String getLoggedUsrStringObjectPropVal(Session session_, C_Usr logged_c_usr_, String object_prop_code_) {
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_string_c_tbl_rec_prop_val(session_, "c_usr", (long) logged_c_usr_.getC_usr(), object_prop_code_);
  }

  public String getUsrStringObjectPropVal(Session session_, C_Usr c_usr_, String object_prop_code_) {
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_string_c_tbl_rec_prop_val(session_, "c_usr", (long) c_usr_.getC_usr(), object_prop_code_);
  }

  public Boolean getLoggedUsrBooleanObjectPropVal(C_Usr logged_c_usr_, String object_prop_code_) {
    return getUsrBooleanObjectPropVal(logged_c_usr_, object_prop_code_);
  }

  public Boolean getUsrBooleanObjectPropVal(C_Usr c_usr_, String object_prop_code_) {
    if (c_usr_ == null) {
      return false;
    }
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_boolean_c_tbl_rec_prop_val("c_usr", (long) c_usr_.getC_usr(), object_prop_code_);
  }

  public Boolean getLoggedUsrBooleanObjectPropVal(Session session_, C_Usr logged_c_usr_, String object_prop_code_) {
    return getUsrBooleanObjectPropVal(session_, logged_c_usr_, object_prop_code_);
  }

  public Boolean getUsrBooleanObjectPropVal(Session session_, C_Usr c_usr_, String object_prop_code_) {
    if (c_usr_ == null) {
      return false;
    }
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_boolean_c_tbl_rec_prop_val(session_, "c_usr", (long) c_usr_.getC_usr(), object_prop_code_);
  }

  public Integer getLoggedUsrIntegerObjectPropVal(C_Usr logged_c_usr_, String object_prop_code_) {
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_integer_c_tbl_rec_prop_val("c_usr", (long) logged_c_usr_.getC_usr(), object_prop_code_);
  }

  public Integer getLoggedUsrIntegerObjectPropVal(Session session_, C_Usr logged_c_usr_, String object_prop_code_) {
    return C_Tbl_Rec_Prop_Val_Manager.getCI().get_integer_c_tbl_rec_prop_val(session_, "c_usr", (long) logged_c_usr_.getC_usr(), object_prop_code_);
  }

  public void setLoggedUsrStringObjectPropVal(C_Usr logged_c_usr_, String object_prop_code_, String prop_val_) {
    if (logged_c_usr_ == null) {
      return;
    }
    C_Tbl_Rec_Prop_Val_Manager.getCI().set_string_c_tbl_rec_prop_val("c_usr", (long) logged_c_usr_.getC_usr(), object_prop_code_, prop_val_);
  }

  public void setLoggedUsrStringObjectPropVal(Session session_, C_Usr logged_c_usr_, String object_prop_code_, String prop_val_) {
    if (logged_c_usr_ == null) {
      return;
    }
    C_Tbl_Rec_Prop_Val_Manager.getCI().set_string_c_tbl_rec_prop_val(session_, "c_usr", (long) logged_c_usr_.getC_usr(), object_prop_code_, prop_val_);
  }

  /*
  public void setLoggedUsrStringObjectPropValInThread(C_Usr logged_c_usr_, final String object_prop_code_, final String prop_val_) {
    if (logged_c_usr_ == null) {
      return;
    }
    C_Tbl_Rec_Prop_Val_Manager.getCI().set_string_c_tbl_rec_prop_val_in_thread("c_usr", logged_c_usr_.getC_usr(), object_prop_code_, prop_val_);
  }
   */

 /*
  public static C_Usr get_creator_dealer_usr_with_own_support_service(C_Usr c_usr_) {
    C_Usr new_c_usr_;
    new_c_usr_ = c_usr_;
    while (0 != 1) {
      if (new_c_usr_.getCreator_usr() == null) {
        return null;
      }
      if (new_c_usr_.getCreator_usr().getIs_dealer() && new_c_usr_.getCreator_usr().getIs_own_support_service()) {
        return new_c_usr_.getCreator_usr();
      }
      new_c_usr_ = new_c_usr_.getCreator_usr();
      if (new_c_usr_ == null) {
        return null;
      }
    }
  }
   */

 /*
  public static C_Usr get_dealer_usr_with_own_support_service(C_Usr c_usr_) {
    C_Usr new_c_usr_;
    new_c_usr_ = c_usr_;
    while (0 != 1) {
      if (new_c_usr_ == null) {
        return null;
      }
      if (new_c_usr_.getIs_dealer() && new_c_usr_.getIs_own_support_service()) {
        return new_c_usr_;
      }
      new_c_usr_ = new_c_usr_.getCreator_usr_t();
    }
  }
   */
 /*
  public static C_Usr get_dealer_usr(C_Usr c_usr_) {
    C_Usr new_c_usr_;
    new_c_usr_ = c_usr_;
    while (0 != 1) {
      if (new_c_usr_ == null) {
        return null;
      }
      if (new_c_usr_.getIs_dealer()) {
        return new_c_usr_;
      }
      new_c_usr_ = new_c_usr_.getCreator_usr();
    }
  }
   */
  public boolean is_hierarchy_creator_usr(C_Usr object_, C_Usr c_usr_) {
    if (object_ == null) {
      return false;
    }

    C_Usr clone_c_usr_;
    clone_c_usr_ = (C_Usr) object_.clone();
    C_Usr temp_c_usr_ = clone_c_usr_.getCreator_usr_t();
    while (temp_c_usr_ != null) {
      if (temp_c_usr_.getC_usr().equals(c_usr_.getC_usr())) {
        return true;
      }
      temp_c_usr_ = temp_c_usr_.getCreator_usr_t();
    }

    return false;
  }

  public boolean is_hierarchy_creator_usr_2(C_Usr object_, C_Usr logged_c_usr_) {
    return is_hierarchy_creator_usr(object_, logged_c_usr_);
  }

  public List<C_Usr> get_c_usr_list_without_default_c_usr(Session session_) {
    List<C_Usr> res = null;
    Query q_ = session_.createQuery("from C_Usr where c_usr.c_usr <> 1 and is_deleted=false order by c_usr asc");
    //q_.setCacheable(use_query_cache);
    res = q_.list();
    return res;
  }

  public static void setC_usr_status(Session session_, C_Usr c_usr_, C_Usr_Status c_usr_status_) {
    c_usr_.setC_usr_status_t(c_usr_status_);
    session_.merge(c_usr_);
  }

  public int get_c_usr_cnt_for_service(Session session_, Long c_usr_id_) {
    return core_custom_funcs.get_hierarchical_c_usr_table_row_count(session_, "C_Usr", "creator_usr", c_usr_id_);
  }

  public boolean is_parent_c_usr_blocked(C_Usr c_usr_) {
    C_Usr new_c_usr_;
    new_c_usr_ = c_usr_.getCreator_usr_t();
    List<Long> list_ = new ArrayList();
    while (0 != 1) {
      if (new_c_usr_ == null) {
        return false;
      }
      if (list_.contains(new_c_usr_.getC_usr())) {
        break;
      }
      list_.add(new_c_usr_.getC_usr());
      if (new_c_usr_.getIs_blocked()) {
        return true;
      }
      new_c_usr_ = new_c_usr_.getCreator_usr_t();
    }
    return false;
  }

  public boolean is_this_or_parent_c_usr_blocked(C_Usr c_usr_) {
    C_Usr new_c_usr_;
    new_c_usr_ = c_usr_;
    List<Long> list_ = new ArrayList();
    while (0 != 1) {
      if (new_c_usr_ == null) {
        return false;
      }
      if (list_.contains(new_c_usr_.getC_usr())) {
        break;
      }
      list_.add(new_c_usr_.getC_usr());
      if (new_c_usr_.getIs_blocked()) {
        return true;
      }
      new_c_usr_ = new_c_usr_.getCreator_usr_t();
    }
    return false;
  }

  public boolean is_this_or_parent_c_usr_deleted(C_Usr c_usr_) {
    C_Usr new_c_usr_;
    new_c_usr_ = c_usr_;
    List<Long> list_ = new ArrayList();
    while (0 != 1) {
      if (new_c_usr_ == null) {
        return false;
      }
      if (list_.contains(new_c_usr_.getC_usr())) {
        break;
      }
      list_.add(new_c_usr_.getC_usr());
      if (new_c_usr_.getIs_deleted()) {
        return true;
      }
      new_c_usr_ = new_c_usr_.getCreator_usr_t();
    }
    return false;
  }

  public int get_c_usr_cnt_by_c_usr_tariff(Session session_, Integer c_usr_tariff_id_) {
    int res = 0;
    if (c_usr_tariff_id_ == null) {
      return 0;
    }
    Query q_ = session_.createQuery("select count(*) from C_Usr "
      + "where c_usr_tariff.c_usr_tariff=:c_usr_tariff_id_ "
    );
    q_.setInteger("c_usr_tariff_id_", c_usr_tariff_id_);
    //q_.setCacheable(use_query_cache);
    res = ((Long) q_.iterate().next()).intValue();
    return res;
  }

  public C_Lang get_current_c_lang(Session session_, C_Usr c_usr_) {
    C_Lang res;
    res = c_usr_.getCurrent_c_lang_t_2(session_);
    if (res == null) {
      return c_usr_.getC_proj_t_2(session_).getDef_c_lang_t_2(session_);
    }
    return res;
  }
}
