package additional_classes;

import java.io.Serializable;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;import gs.common.hibernate_funcs;
import org.hibernate.Transaction;
import others.CustomLogger;

public class ExecuteInCurrentSession implements Serializable {

  public ExecuteInCurrentSession() {
    test();
  }

  protected void execute(Session session_) {

  }

  public void test() {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      execute(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }
}
