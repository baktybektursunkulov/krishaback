package model.core.dbutil;

import java.io.Serializable; import gs.common.model.db.Abstract_Entity;
import org.hibernate.Session;import gs.common.hibernate_funcs;
import org.hibernate.Transaction;
import others.CustomLogger;

// SessionFactory and session could not be serialized
// http://stackoverflow.com/questions/11273808/tomcat-restart-could-not-find-a-sessionfactory-uuid-name-null
public class AbstractTransaction {

  public AbstractTransaction() {
    CustomLogger.log("AbstractTransaction()");
    Transaction tx_ = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      doInTransation(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public AbstractTransaction(boolean openSession) {
    CustomLogger.log("AbstractTransaction()");
    Transaction tx_ = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      doInTransation(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public void doInTransation(Session session_) {

  }
}
