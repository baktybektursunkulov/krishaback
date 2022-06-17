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
public class C_Usr_Jur_Person_Manager extends Abstract_Controller_Manager<C_Usr_Jur_Person> {

  private static C_Usr_Jur_Person_Manager currentInstance = null;

  public static C_Usr_Jur_Person_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Jur_Person_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Jur_Person_Manager() {
    super(C_Usr_Jur_Person.class);
  }

  public C_Usr_Jur_Person get_row(Long c_usr_id_) {
    C_Usr_Jur_Person res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row(session_, c_usr_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
  public C_Usr_Jur_Person get_row(Session session_, Long c_usr_id_) {
    Query q_ = session_.createQuery("from C_Usr_Jur_Person t where t.is_deleted=false and t.c_usr=:c_usr_id_ order by 1 asc");
    q_.setLong("c_usr_id_", c_usr_id_);
    q_.setMaxResults(1);
    List<C_Usr_Jur_Person> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }
}
