package managers.core.dbtables;

import gs.common.managers.My_Abstract_Controller_Manager;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;import gs.common.hibernate_funcs;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class Abstract_Controller_Manager<T> extends My_Abstract_Controller_Manager<T> {

  public final static boolean use_query_cache = false;

  public Abstract_Controller_Manager(Class<T> entity_class_) {
    super(entity_class_);
  }

  @Override
  protected void error(Exception e) {
    CustomLogger.error(e);
  }

  @Override
  protected Session getOpenedSession() {
    return model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
  }

  @Override
  protected Session getCurrentSession() {
    return model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().getCurrentSession();
  }
}
