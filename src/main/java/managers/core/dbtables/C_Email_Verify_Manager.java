package managers.core.dbtables;

import gs.common.hibernate_funcs;
import gs.common.other_funcs;
import gs.common.random_funcs;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Email_Verify_Manager extends Abstract_Controller_Manager<C_Email_Verify> {

  private static C_Email_Verify_Manager currentInstance = null;

  public static C_Email_Verify_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Email_Verify_Manager();
    }
    return currentInstance;
  }

  public C_Email_Verify_Manager() {
    super(C_Email_Verify.class);
  }

  public C_Email_Verify ins_row(String email_) {
    C_Email_Verify res;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      hibernate_funcs.beginTransaction(session_);
      res = ins_row(session_, email_);
      hibernate_funcs.commitAndClose(session_);
      return res;
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public C_Email_Verify ins_row(Session session_, String email_) {
    C_Email_Verify res;

    res = new C_Email_Verify();
    res.setEmail(email_);
    res.setIns_dt(new Date());
    res.setIs_verified(false);
    res.setIs_deleted(false);
    res.setVerif_code(String.valueOf(other_funcs.truncToInteger(random_funcs.get_random_val(1000.0, 9998.0))));
    session_.save(res);

    return res;
  }

}
