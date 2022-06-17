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
public class C_Usr_Review_Addition_Manager extends Abstract_Controller_Manager<C_Usr_Review_Addition> {

  private static C_Usr_Review_Addition_Manager currentInstance = null;

  public static C_Usr_Review_Addition_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Review_Addition_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Review_Addition_Manager() {
    super(C_Usr_Review_Addition.class);
  }

  public C_Usr_Review_Addition get_first_row(Integer c_usr_review_id_) {
    C_Usr_Review_Addition res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_first_row(session_, c_usr_review_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Usr_Review_Addition get_first_row(Session session_, Integer c_usr_review_id_) {
    Query q_ = session_.createQuery("from C_Usr_Review_Addition t where t.is_deleted=false and t.c_usr_review=:c_usr_review_id_ order by 1 asc");
    q_.setInteger("c_usr_review_id_", c_usr_review_id_);
    q_.setMaxResults(1);
    List<C_Usr_Review_Addition> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }
  
}
