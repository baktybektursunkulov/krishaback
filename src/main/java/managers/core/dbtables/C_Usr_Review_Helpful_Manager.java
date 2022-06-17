package managers.core.dbtables;

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
public class C_Usr_Review_Helpful_Manager extends Abstract_Controller_Manager<C_Usr_Review_Helpful> {

  private static C_Usr_Review_Helpful_Manager currentInstance = null;

  public static C_Usr_Review_Helpful_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Review_Helpful_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Review_Helpful_Manager() {
    super(C_Usr_Review_Helpful.class);
  }

  public C_Usr_Review_Helpful get_row(Integer c_usr_review_id_, Long c_usr_id_) {
    C_Usr_Review_Helpful res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row(session_, c_usr_review_id_, c_usr_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Usr_Review_Helpful get_row(Session session_, Integer c_usr_review_id_, Long c_usr_id_) {
    Query q_ = session_.createQuery("from C_Usr_Review_Helpful t where t.is_deleted=false and t.c_usr_review=:c_usr_review_id_ and t.c_usr=:c_usr_id_ order by 1 asc ");
    q_.setInteger("c_usr_review_id_", c_usr_review_id_);
    q_.setLong("c_usr_id_", c_usr_id_);
    q_.setMaxResults(1);
    List<C_Usr_Review_Helpful> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public void set_helpful(Integer c_usr_review_id_, Long c_usr_id_, Boolean is_helpful_) {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      set_helpful(session_, c_usr_review_id_, c_usr_id_, is_helpful_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public void set_helpful(Session session_, Integer c_usr_review_id_, Long c_usr_id_, Boolean is_helpful_) {
    C_Usr_Review_Helpful rec_ = get_row(session_, c_usr_review_id_, c_usr_id_);
    if (rec_ != null) {
      if (!rec_.getIs_helpful().equals(is_helpful_)) {
        rec_.setIs_helpful(is_helpful_);
        session_.merge(rec_);
        C_Usr_Review_Manager.getCI().refresh_helpful_fields(session_, c_usr_review_id_);
      }
    } else {
      rec_ = new C_Usr_Review_Helpful();
      rec_.setC_usr_review(c_usr_review_id_);
      rec_.setC_usr(c_usr_id_);
      rec_.setIns_dt(new Date());
      rec_.setIs_deleted(false);
      rec_.setIs_helpful(is_helpful_);
      session_.save(rec_);
      C_Usr_Review_Manager.getCI().refresh_helpful_fields(session_, c_usr_review_id_);
    }
  }
}
