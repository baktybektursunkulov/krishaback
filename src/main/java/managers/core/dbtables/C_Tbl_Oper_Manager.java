package managers.core.dbtables;

import beans.CUsrBean;
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
import java.io.Serializable;
import java.util.*;
import java.text.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@ManagedBean
@ApplicationScoped
public class C_Tbl_Oper_Manager extends Abstract_Controller_Manager<C_Tbl_Oper> {

  private static C_Tbl_Oper_Manager currentInstance = null;

  public static C_Tbl_Oper_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Oper_Manager();
    }
    return currentInstance;
  }

  public C_Tbl_Oper_Manager() {
    super(C_Tbl_Oper.class);
  }

  public static List get_tbl_oper_list(String c_tbl_id_, String object_id_) {
    Transaction tx = null;
    List res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Criteria criteria_ = session_.createCriteria(C_Tbl_Oper.class);
      if ((c_tbl_id_ != null) && (!c_tbl_id_.isEmpty())) {
        criteria_ = criteria_.add(Restrictions.eq("c_tbl.c_tbl", c_tbl_id_));
      }
      if ((object_id_ != null) && (!object_id_.isEmpty())) {
        criteria_ = criteria_.add(Restrictions.eq("object_id", object_id_));
      }
      criteria_ = criteria_.add(Restrictions.eq("is_deleted", false));
      criteria_ = criteria_.addOrder(Order.desc("object_his"));
      res = criteria_.list();
//      
//      res = session.createQuery("from C_Tbl_Oper order by object_his desc").list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      others.CustomLogger.error(gs.common.other_funcs.stack2string(e));
      throw e;
    }
    return res;
  }

  public static List<C_Tbl_Oper> get_tbl_oper_list_2(String c_tbl_id_, String object_id_) {
    Transaction tx = null;
    List res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Criteria criteria_ = session_.createCriteria(C_Tbl_Oper.class);
      criteria_ = criteria_.add(Restrictions.eq("c_tbl.c_tbl", c_tbl_id_));
      criteria_ = criteria_.add(Restrictions.eq("object_id", object_id_));
      criteria_ = criteria_.add(Restrictions.eq("is_deleted", false));
      criteria_ = criteria_.addOrder(Order.asc("ins_dt"));
      criteria_ = criteria_.addOrder(Order.asc("object_his"));
      res = criteria_.list();
//      
//      res = session.createQuery("from C_Tbl_Oper order by object_his desc").list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      others.CustomLogger.error(gs.common.other_funcs.stack2string(e));
      throw e;
    }
    return res;
  }

  public Collection<C_Tbl_Oper> get_available_tbl_oper_list(String c_tbl_id_, String object_id_) {
    Collection<C_Tbl_Oper> result = null;
    result = C_Tbl_Oper_Manager.get_tbl_oper_list(c_tbl_id_, object_id_);
    return result;
  }

  public static Integer insert_object_his(Session session_, String c_tbl_code_, Serializable rec_id_, String c_tbl_oper_kind_code_, String changes_text_, C_Usr c_usr_) {
    Integer res = null;
    try {
      C_Tbl c_tbl_ = C_Tbl_Manager.getCI().get_rec_by_code(session_, c_tbl_code_);
      if (c_tbl_ == null) {
        c_tbl_ = new C_Tbl();
        c_tbl_.setCode(c_tbl_code_);
        c_tbl_.setName(c_tbl_code_);
        session_.save(c_tbl_);
      }
      Integer c_tbl_id_ = c_tbl_.getC_tbl();
      Integer c_tbl_oper_kind_id_ = C_Tbl_Oper_Kind_Manager.getCI().get_rec_by_code(session_, c_tbl_oper_kind_code_).getC_tbl_oper_kind();
      C_Tbl_Oper rec_ = new C_Tbl_Oper();
      rec_.setC_tbl(c_tbl_id_);
      if (rec_id_ instanceof Integer) {
        rec_.setRec_id((long) (Integer) rec_id_);
      } else if (rec_id_ instanceof Long) {
        rec_.setRec_id((Long) rec_id_);
      }
      rec_.setC_tbl_oper_kind(c_tbl_oper_kind_id_);
      rec_.setOper_dt(new java.util.Date());
      //String user_name_ = "";
      rec_.setC_usr_t(c_usr_);
      rec_.setChanges_txt(changes_text_);
      rec_.setIs_deleted(false);
      session_.save(rec_);
      res = rec_.getC_tbl_oper();
    } catch (Exception e) {
      others.CustomLogger.error(gs.common.other_funcs.stack2string(e));
      throw e;
    }
    return res;
  }

  public static Integer insert_object_his(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_oper_kind_id_, String changes_text_, C_Usr c_usr_) {
    Integer res = null;
    try {
      C_Tbl_Oper rec_ = new C_Tbl_Oper();
      rec_.setC_tbl(c_tbl_id_);
      rec_.setRec_id(rec_id_);
      rec_.setC_tbl_oper_kind(c_tbl_oper_kind_id_);
      rec_.setOper_dt(new java.util.Date());
      //String user_name_ = "";
      rec_.setC_usr_t(c_usr_);
      rec_.setChanges_txt(changes_text_);
      rec_.setIs_deleted(false);
      session_.save(rec_);
      res = rec_.getC_tbl_oper();
    } catch (Exception e) {
      others.CustomLogger.error(gs.common.other_funcs.stack2string(e));
      throw e;
    }
    return res;
  }

  public static void insert_object_his_for_ins(Session session_, String c_tbl_code_, Integer rec_id_, String changes_text_, C_Usr c_usr_) {
    insert_object_his_for_ins(session_, c_tbl_code_, (long) rec_id_, changes_text_, c_usr_);
  }

  public static void insert_object_his_for_ins(Session session_, String c_tbl_code_, Long rec_id_, String changes_text_, C_Usr c_usr_) {
    C_Tbl c_tbl_ = C_Tbl_Manager.getCI().get_rec_by_code(session_, c_tbl_code_);
    if (c_tbl_ == null) {
      c_tbl_ = new C_Tbl();
      c_tbl_.setCode(c_tbl_code_);
      c_tbl_.setName(c_tbl_code_);
      c_tbl_.setIs_deleted(false);
      session_.save(c_tbl_);
    }
    insert_object_his(session_, c_tbl_.getC_tbl(), rec_id_, C_Tbl_Oper_Kind_Manager.getCI().get_rec_by_code(session_, "insert").getC_tbl_oper_kind(), changes_text_, c_usr_);
  }

  public static void insert_object_his_for_upd(Session session_, String c_tbl_code_, Long rec_id_, String changes_text_, C_Usr c_usr_) {
    C_Tbl c_tbl_ = C_Tbl_Manager.getCI().get_rec_by_code(session_, c_tbl_code_);
    if (c_tbl_ == null) {
      c_tbl_ = new C_Tbl();
      c_tbl_.setCode(c_tbl_code_);
      c_tbl_.setName(c_tbl_code_);
      c_tbl_.setIs_deleted(false);
      session_.save(c_tbl_);
    }
    insert_object_his(session_, c_tbl_.getC_tbl(), rec_id_, C_Tbl_Oper_Kind_Manager.getCI().get_rec_by_code(session_, "update").getC_tbl_oper_kind(), changes_text_, c_usr_);
  }

  public static void insert_object_his_for_del(Session session_, String c_tbl_code_, Long rec_id_, String changes_text_, C_Usr c_usr_) {
    C_Tbl c_tbl_ = C_Tbl_Manager.getCI().get_rec_by_code(session_, c_tbl_code_);
    if (c_tbl_ == null) {
      c_tbl_ = new C_Tbl();
      c_tbl_.setCode(c_tbl_code_);
      c_tbl_.setName(c_tbl_code_);
      c_tbl_.setIs_deleted(false);
      session_.save(c_tbl_);
    }
    insert_object_his(session_, c_tbl_.getC_tbl(), rec_id_, C_Tbl_Oper_Kind_Manager.getCI().get_rec_by_code(session_, "delete").getC_tbl_oper_kind(), changes_text_, c_usr_);
  }

}
