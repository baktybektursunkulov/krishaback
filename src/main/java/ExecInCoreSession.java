
import gs.common.hibernate_funcs;
import org.hibernate.Session;
import others.CustomLogger;

public class ExecInCoreSession {

  public ExecInCoreSession() {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      hibernate_funcs.beginTransaction(session_);
      exec(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public Integer ExecInCoreSessionWithRes(Session session_) {
    return 1;
  }

  public Integer ExecInCoreSessionWithRes() {
    Integer res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      hibernate_funcs.beginTransaction(session_);
      res = ExecInCoreSessionWithRes(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  protected void exec(Session session_) {

  }
}
