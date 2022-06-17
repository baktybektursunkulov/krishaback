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
public class C_Usr_Jur_Person_Addr_Manager extends Abstract_Controller_Manager<C_Usr_Jur_Person_Addr> {

  private static C_Usr_Jur_Person_Addr_Manager currentInstance = null;

  public static C_Usr_Jur_Person_Addr_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Jur_Person_Addr_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Jur_Person_Addr_Manager() {
    super(C_Usr_Jur_Person_Addr.class);
  }

  public C_Usr_Jur_Person_Addr get_row(Integer c_usr_jur_person_id_, Integer c_jur_person_addr_type_id_) {
    C_Usr_Jur_Person_Addr res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row(session_, c_usr_jur_person_id_, c_jur_person_addr_type_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Usr_Jur_Person_Addr get_row(Session session_, Integer c_usr_jur_person_id_, Integer c_jur_person_addr_type_id_) {
    Query q_ = session_.createQuery("from C_Usr_Jur_Person_Addr t "
      + "where t.is_deleted=false and t.c_usr_jur_person=:c_usr_jur_person_id_ and t.c_jur_person_addr_type=:c_jur_person_addr_type_id_ "
      + "order by 1 asc");
    q_.setInteger("c_usr_jur_person_id_", c_usr_jur_person_id_);
    q_.setInteger("c_jur_person_addr_type_id_", c_jur_person_addr_type_id_);
    q_.setMaxResults(1);
    List<C_Usr_Jur_Person_Addr> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public C_Usr_Jur_Person_Addr get_row_2(Long c_usr_id_, Integer c_jur_person_addr_type_id_) {
    C_Usr_Jur_Person_Addr res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row_2(session_, c_usr_id_, c_jur_person_addr_type_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Usr_Jur_Person_Addr get_row_2(Session session_, Long c_usr_id_, Integer c_jur_person_addr_type_id_) {
    C_Usr_Jur_Person c_Usr_Jur_Person = C_Usr_Jur_Person_Manager.getCI().get_row(session_, c_usr_id_);
    return get_row(session_, c_Usr_Jur_Person.getC_usr_jur_person(), c_jur_person_addr_type_id_);
  }

}
