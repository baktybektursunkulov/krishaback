package managers.core.dbtables;

import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Order_Condition;
import java.math.BigInteger;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Tbl_Rec_Prop_Val_Manager extends Abstract_Controller_Manager<C_Tbl_Rec_Prop_Val> {

  private static C_Tbl_Rec_Prop_Val_Manager currentInstance = null;

  public static C_Tbl_Rec_Prop_Val_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Rec_Prop_Val_Manager();
    }
    return currentInstance;
  }

  public C_Tbl_Rec_Prop_Val_Manager() {
    super(C_Tbl_Rec_Prop_Val.class);
  }

  public List<C_Tbl_Rec_Prop_Val> get_c_tbl_rec_prop_val_list(Session session_, String c_tbl_code_, Long rec_id_) {
    List<C_Tbl_Rec_Prop_Val> res = null;
    Query q_ = session_.createQuery("from C_Tbl_Rec_Prop_Val where is_deleted=false and c_tbl.c_tbl=:c_tbl_id_ and rec_id=:rec_id_ order by c_tbl_rec_prop_val asc");
    //q_.setCacheable(use_query_cache);
    q_.setInteger("c_tbl_id_", C_Tbl_Manager.getCI().get_rec_by_code(session_, c_tbl_code_).getC_tbl());
    q_.setLong("rec_id_", rec_id_);
    res = q_.list();
    return res;
  }

  public C_Tbl_Rec_Prop_Val get_c_tbl_rec_prop_val(String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    Transaction tx = null;
    C_Tbl_Rec_Prop_Val res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_tbl_rec_prop_val(session_, c_tbl_code_, rec_id_, c_tbl_prop_code_);
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

  public C_Tbl_Rec_Prop_Val get_c_tbl_rec_prop_val(Session session_, String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    C_Tbl_Rec_Prop_Val res = null;
    Query q_ = session_.createQuery("select opv from C_Tbl_Rec_Prop_Val opv, C_Tbl_Prop op where opv.is_deleted=false and opv.c_tbl_prop=op.c_tbl_prop and opv.c_tbl=:c_tbl_id_ and opv.rec_id=:rec_id_ and op.code=:c_tbl_prop_code_");
    //q_.setCacheable(use_query_cache);
    q_.setInteger("c_tbl_id_", C_Tbl_Manager.getCI().get_rec_by_code(session_, c_tbl_code_).getC_tbl());
    q_.setLong("rec_id_", rec_id_);
    q_.setString("c_tbl_prop_code_", c_tbl_prop_code_);
    List<C_Tbl_Rec_Prop_Val> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public boolean is_c_tbl_rec_prop_val_exists(String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    return (get_c_tbl_rec_prop_val(c_tbl_code_, rec_id_, c_tbl_prop_code_) != null);
  }

  public String get_string_c_tbl_rec_prop_val(String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    //CustomLogger.log("get_string_c_tbl_rec_prop_val, c_tbl_id_=" + c_tbl_id_ + ", rec_id_=" + rec_id_ + ", c_tbl_prop_code_=" + c_tbl_prop_code_);
    String res = "";
    C_Tbl_Prop c_tbl_prop_ = C_Tbl_Prop_Manager.getCI().get_c_tbl_prop_by_c_tbl_code_and_code(c_tbl_code_, c_tbl_prop_code_, true);
    C_Tbl_Rec_Prop_Val c_tbl_rec_prop_val_ = get_c_tbl_rec_prop_val(c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (c_tbl_rec_prop_val_ == null) {
      if (c_tbl_prop_ != null) {
        if (c_tbl_prop_.getC_tbl_t().getC_tbl().equals("C_Usr") && c_tbl_prop_.getCode().equals("theme")) {
          res = "aristo";
        } else {
          res = c_tbl_prop_.getDefault_val();
        }
      }
    } else {
      res = c_tbl_rec_prop_val_.getProp_val();
    }
    //CustomLogger.log("get_string_c_tbl_rec_prop_val c_tbl_prop_code_=" + c_tbl_prop_code_ + ", res=" + res);
    return res;
  }

  public String get_string_c_tbl_rec_prop_val(Session session_, String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    String res = "";
    C_Tbl_Prop c_tbl_prop_ = C_Tbl_Prop_Manager.getCI().get_c_tbl_prop_by_c_tbl_code_and_code(session_, c_tbl_code_, c_tbl_prop_code_, true);
    C_Tbl_Rec_Prop_Val c_tbl_rec_prop_val_ = get_c_tbl_rec_prop_val(session_, c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (c_tbl_rec_prop_val_ == null) {
      if (c_tbl_prop_ != null) {
        if (c_tbl_prop_.getC_tbl_t_2(session_).getCode().equals("c_usr") && c_tbl_prop_.getCode().equals("theme")) {
          res = "aristo";
        } else {
          res = c_tbl_prop_.getDefault_val();
        }
      }
    } else {
      res = c_tbl_rec_prop_val_.getProp_val();
    }
    //CustomLogger.log("get_string_c_tbl_rec_prop_val c_tbl_prop_code_=" + c_tbl_prop_code_ + ", res=" + res);
    return res;
  }

  public Boolean get_boolean_c_tbl_rec_prop_val(String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    Boolean res;
    res = get_string_c_tbl_rec_prop_val(c_tbl_code_, rec_id_, c_tbl_prop_code_).equals("true");
    return res;
  }

  public Boolean get_boolean_c_tbl_rec_prop_val(Session session_, String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    Boolean res;
    res = get_string_c_tbl_rec_prop_val(session_, c_tbl_code_, rec_id_, c_tbl_prop_code_).equals("true");
    return res;
  }

  public Integer get_integer_c_tbl_rec_prop_val(String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    Integer res;
    String str_ = get_string_c_tbl_rec_prop_val(c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (str_ == null || str_.isEmpty()) {
      str_ = "0";
    }
    res = Integer.valueOf(str_);
    return res;
  }

  public Integer get_integer_c_tbl_rec_prop_val(Session session_, String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    Integer res;
    String str_ = get_string_c_tbl_rec_prop_val(session_, c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (str_ == null || str_.isEmpty()) {
      str_ = "0";
    }
    res = Integer.valueOf(str_);
    return res;
  }

  public Long get_long_c_tbl_rec_prop_val(String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    Long res;
    String str_ = get_string_c_tbl_rec_prop_val(c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (str_ == null || str_.isEmpty()) {
      str_ = "0";
    }
    res = Long.valueOf(str_);
    return res;
  }

  public BigInteger get_biginteger_c_tbl_rec_prop_val(String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    BigInteger res;
    String str_ = get_string_c_tbl_rec_prop_val(c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (str_ == null || str_.isEmpty()) {
      str_ = "0";
    }
    res = new BigInteger(str_);
    return res;
  }

  public BigInteger get_biginteger_c_tbl_rec_prop_val(Session session_, String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    BigInteger res;
    String str_ = get_string_c_tbl_rec_prop_val(session_, c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (str_ == null || str_.isEmpty()) {
      str_ = "0";
    }
    res = new BigInteger(str_);
    return res;
  }

  public Long get_long_c_tbl_rec_prop_val(Session session_, String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_) {
    Long res;
    String str_ = get_string_c_tbl_rec_prop_val(session_, c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (str_ == null || str_.isEmpty()) {
      str_ = "0";
    }
    res = Long.valueOf(str_);
    return res;
  }

  public void set_string_c_tbl_rec_prop_val(String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_, String prop_val_) {
    String res = "";
    C_Tbl_Rec_Prop_Val c_tbl_rec_prop_val_ = get_c_tbl_rec_prop_val(c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (c_tbl_rec_prop_val_ == null) {
      c_tbl_rec_prop_val_ = new C_Tbl_Rec_Prop_Val();
      c_tbl_rec_prop_val_.setC_tbl(C_Tbl_Manager.getCI().get_rec_by_code(c_tbl_code_).getC_tbl());
      c_tbl_rec_prop_val_.setRec_id(rec_id_);
      c_tbl_rec_prop_val_.setC_tbl_prop(C_Tbl_Prop_Manager.getCI().get_c_tbl_prop_by_c_tbl_code_and_code(c_tbl_code_, c_tbl_prop_code_, true).getC_tbl_prop());
      c_tbl_rec_prop_val_.setProp_val(prop_val_);
      c_tbl_rec_prop_val_.setIs_deleted(false);
      insert_rec(c_tbl_rec_prop_val_);
    } else {
      c_tbl_rec_prop_val_.setProp_val(prop_val_);
      update_rec(c_tbl_rec_prop_val_);
    }
  }

  public void set_string_c_tbl_rec_prop_val(Session session_, String c_tbl_code_, Long rec_id_, String c_tbl_prop_code_, String prop_val_) {
    String res = "";
    C_Tbl_Rec_Prop_Val c_tbl_rec_prop_val_ = get_c_tbl_rec_prop_val(session_, c_tbl_code_, rec_id_, c_tbl_prop_code_);
    if (c_tbl_rec_prop_val_ == null) {
      c_tbl_rec_prop_val_ = new C_Tbl_Rec_Prop_Val();
      c_tbl_rec_prop_val_.setC_tbl(C_Tbl_Manager.getCI().get_rec_by_code(session_, c_tbl_code_).getC_tbl());
      c_tbl_rec_prop_val_.setRec_id(rec_id_);
      c_tbl_rec_prop_val_.setC_tbl_prop(C_Tbl_Prop_Manager.getCI().get_c_tbl_prop_by_c_tbl_code_and_code(session_, c_tbl_code_, c_tbl_prop_code_, true).getC_tbl_prop());
      c_tbl_rec_prop_val_.setProp_val(prop_val_);
      c_tbl_rec_prop_val_.setIs_deleted(false);
      insert_rec(session_, c_tbl_rec_prop_val_);
    } else {
      c_tbl_rec_prop_val_.setProp_val(prop_val_);
      merge_rec(session_, c_tbl_rec_prop_val_);
    }
  }

  public void set_string_c_tbl_rec_prop_val_in_thread(final String c_tbl_code_, final Long rec_id_, final String c_tbl_prop_code_, final String prop_val_) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        C_Tbl_Rec_Prop_Val_Manager.getCI().set_string_c_tbl_rec_prop_val(c_tbl_code_, rec_id_, c_tbl_prop_code_, prop_val_);
      }
    }).start();

  }

  public List<C_Tbl_Rec_Prop_Val> get_c_tbl_rec_prop_val_list(SQL_Order_Condition sql_order_condition_) {
    Transaction tx = null;
    List<C_Tbl_Rec_Prop_Val> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Tbl_Rec_Prop_Val where is_deleted=false order by " + sql_order_condition_.getField_name() + " " + sql_order_condition_.getSort_order());
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

  public C_Tbl_Rec_Prop_Val get_row(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_) {
    C_Tbl_Rec_Prop_Val res = null;
    Query q_ = session_.createQuery("from C_Tbl_Rec_Prop_Val t where t.is_deleted=false and t.c_tbl=:c_tbl_id_ and t.rec_id=:rec_id_ and t.c_tbl_prop=:c_tbl_prop_id_ order by 1 asc");
    //q_.setCacheable(use_query_cache);
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setLong("rec_id_", rec_id_);
    q_.setInteger("c_tbl_prop_id_", c_tbl_prop_id_);
    q_.setMaxResults(1);
    List<C_Tbl_Rec_Prop_Val> list_ = q_.list();
    if (!list_.isEmpty()) {
      res = list_.get(0);
    }
    return res;
  }

  public void set_prop_val(Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_, String prop_val_) {
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      set_prop_val(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_, prop_val_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public void set_prop_val(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_, String prop_val_) {
    C_Tbl_Rec_Prop_Val c_tbl_rec_prop_val_ = get_row(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_);
    if (c_tbl_rec_prop_val_ == null) {
      c_tbl_rec_prop_val_ = new C_Tbl_Rec_Prop_Val();
      c_tbl_rec_prop_val_.setC_tbl(c_tbl_id_);
      c_tbl_rec_prop_val_.setRec_id(rec_id_);
      c_tbl_rec_prop_val_.setC_tbl_prop(c_tbl_prop_id_);
      c_tbl_rec_prop_val_.setProp_val(prop_val_);
      c_tbl_rec_prop_val_.setIs_deleted(false);
      insert_rec(session_, c_tbl_rec_prop_val_);
    } else {
      c_tbl_rec_prop_val_.setProp_val(prop_val_);
      merge_rec(session_, c_tbl_rec_prop_val_);
    }
  }

  public String get_prop_val(Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_) {
    String res;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_prop_val(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public String get_prop_val(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_) {
    C_Tbl_Rec_Prop_Val c_tbl_rec_prop_val_ = get_row(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_);
    if (c_tbl_rec_prop_val_ == null) {
      c_tbl_rec_prop_val_ = new C_Tbl_Rec_Prop_Val();
      c_tbl_rec_prop_val_.setC_tbl(c_tbl_id_);
      c_tbl_rec_prop_val_.setRec_id(rec_id_);
      c_tbl_rec_prop_val_.setC_tbl_prop(c_tbl_prop_id_);
      C_Tbl_Prop c_tbl_prop_ = C_Tbl_Prop_Manager.getCI().get_rec(session_, c_tbl_prop_id_);
      c_tbl_rec_prop_val_.setProp_val(c_tbl_prop_.getDefault_val());
      c_tbl_rec_prop_val_.setIs_deleted(false);
      insert_rec(session_, c_tbl_rec_prop_val_);
      return c_tbl_rec_prop_val_.getProp_val();
    } else {
      return c_tbl_rec_prop_val_.getProp_val();
    }
  }

  public void set_boolean_prop_val(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_, Boolean prop_val_) {
    set_prop_val(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_, prop_val_.toString());
  }

  public void set_boolean_prop_val(Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_, Boolean prop_val_) {
    set_prop_val(c_tbl_id_, rec_id_, c_tbl_prop_id_, prop_val_.toString());
  }

  public void set_integer_prop_val(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_, Integer prop_val_) {
    set_prop_val(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_, prop_val_ == null ? null : prop_val_.toString());
  }

  public void set_integer_prop_val(Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_, Integer prop_val_) {
    set_prop_val(c_tbl_id_, rec_id_, c_tbl_prop_id_, prop_val_ == null ? null : prop_val_.toString());
  }

  public void set_double_prop_val(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_, Double prop_val_) {
    set_prop_val(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_, prop_val_ == null ? null : prop_val_.toString());
  }

  public void set_double_prop_val(Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_, Double prop_val_) {
    set_prop_val(c_tbl_id_, rec_id_, c_tbl_prop_id_, prop_val_ == null ? null : prop_val_.toString());
  }
  
  public Boolean get_boolean_prop_val(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_) {
    return Boolean.valueOf(get_prop_val(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_));
  }

  public Integer get_integer_prop_val(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_) {
    String val_ = get_prop_val(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_);
    if (val_ == null || val_.trim().isEmpty()) {
      return null;
    } else {
      return Integer.valueOf(val_);
    }
  }
  
  public void set_int_prop_val(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_, Integer int_prop_val_) {
    C_Tbl_Rec_Prop_Val c_tbl_rec_prop_val_ = get_row(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_);
    if (c_tbl_rec_prop_val_ == null) {
      c_tbl_rec_prop_val_ = new C_Tbl_Rec_Prop_Val();
      c_tbl_rec_prop_val_.setC_tbl(c_tbl_id_);
      c_tbl_rec_prop_val_.setRec_id(rec_id_);
      c_tbl_rec_prop_val_.setC_tbl_prop(c_tbl_prop_id_);
      c_tbl_rec_prop_val_.setInt_prop_val(int_prop_val_);
      c_tbl_rec_prop_val_.setIs_deleted(false);
      insert_rec(session_, c_tbl_rec_prop_val_);
    } else {
      c_tbl_rec_prop_val_.setInt_prop_val(int_prop_val_);
      merge_rec(session_, c_tbl_rec_prop_val_);
    }
  }
  
  public void inc_int_prop_val(Session session_, Integer c_tbl_id_, Long rec_id_, Integer c_tbl_prop_id_) {
    Query q_ = session_.createQuery("update C_Tbl_Rec_Prop_Val set int_prop_val=coalesce(int_prop_val, 0)+1 where is_deleted=false and c_tbl=:c_tbl_id_ and rec_id=:rec_id_ and c_tbl_prop=:c_tbl_prop_id_");
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setLong("rec_id_", rec_id_);
    q_.setInteger("c_tbl_prop_id_", c_tbl_prop_id_);
    int cnt_ = q_.executeUpdate();
    if (cnt_ == 0) {
      set_int_prop_val(session_, c_tbl_id_, rec_id_, c_tbl_prop_id_, 1);
    }
  }
  
}
