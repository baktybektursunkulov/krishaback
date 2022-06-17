package managers.core.dbtables;

import gs.common.date_time_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Usr_Review_Manager extends Abstract_Controller_Manager<C_Usr_Review> {

  private static C_Usr_Review_Manager currentInstance = null;

  public static C_Usr_Review_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Review_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Review_Manager() {
    super(C_Usr_Review.class);
  }

  public Integer get_review_cnt(Session session_, Integer c_tbl_id_, Integer rec_id_, Integer rating_) {
    Query q_ = session_.createSQLQuery("select count(1) from C_Usr_Review t where t.c_tbl=:c_tbl_id_ and t.rec_id=:rec_id_ and t.rating=:rating_ and t.is_deleted=false ");
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setInteger("rec_id_", rec_id_);
    q_.setInteger("rating_", rating_);
    List<Long> list_ = q_.list();
    if (list_.isEmpty()) {
      return 0;
    } else {
      return list_.get(0).intValue();
    }
  }

  public void refresh_helpful_fields(Session session_, Integer c_usr_review_id_) {
    C_Usr_Review c_usr_review_ = C_Usr_Review_Manager.getCI().get_rec(session_, c_usr_review_id_);
    if (c_usr_review_ != null) {
      Query q_ = session_.createSQLQuery("update C_Usr_Review "
        + "set "
        + "  helpful_cnt=(select count(1) from C_Usr_Review_Helpful t2 where t2.is_deleted=false and t2.c_usr_review=:c_usr_review_id_ and t2.is_helpful=true), "
        + "  total_helpful_cnt=(select count(1) from C_Usr_Review_Helpful t2 where t2.is_deleted=false and t2.c_usr_review=:c_usr_review_id_) "
        + "where c_usr_review=:c_usr_review_id_");
      q_.setInteger("c_usr_review_id_", c_usr_review_id_);
      q_.executeUpdate();

      q_ = session_.createSQLQuery("update C_Usr_Review "
        + "set "
        + "  helpful_percent=(case total_helpful_cnt when 0.0 then 0.0 else helpful_cnt/total_helpful_cnt*100.0 end) "
        + "where c_usr_review=:c_usr_review_id_");
      q_.setInteger("c_usr_review_id_", c_usr_review_id_);
      q_.executeUpdate();
    }
  }

  public C_Usr_Review get_new_row_with_default_vals() {
    C_Usr_Review res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_new_row_with_default_vals(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Usr_Review get_new_row_with_default_vals(Session session_) {
    C_Usr_Review res = (C_Usr_Review) C_Usr_Review_Manager.getCI().get_rec(session_, -1).clone();
    res.setC_usr_review(null);
    res.setC_tbl_t(null);
    res.setRec_id(null);
    res.setRating(null);
    res.setIns_dt(null);
    res.setC_lang_t(null);
    //res.setGmt_ins_dt(null);
    res.setIs_published(false);
    res.setIs_deleted(false);
    return res;
  }
  
}
