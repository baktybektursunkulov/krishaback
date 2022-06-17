package model.db;

import gs.common.model.db.My_SQL_Manager;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;import gs.common.hibernate_funcs;
import others.CustomLogger;

public class SQL_Manager extends My_SQL_Manager {

  private static SQL_Manager currentInstance;

  public static SQL_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new SQL_Manager();
    }
    return currentInstance;
  }

  public static void setCurrentInstance(SQL_Manager currentInstance) {
    SQL_Manager.currentInstance = currentInstance;
  }

  @Override
  protected void error(Exception e) {
    CustomLogger.error(e);
  }

  @Override
  protected Session getOpenedSession() {
    return CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
  }

  @Override
  protected Session getCurrentSession() {
    return CoreSessionFactoryUtil.getSessionFactoryUtilInstance().getCurrentSession();
  }

}
