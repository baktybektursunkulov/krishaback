package gs.services.core;

import beans.SessionBean;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import gs.configuration.CoreDataSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gs.services.core.dbtables.*;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import managers.core.dbtables.*;
import model.core.dbtables.*;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import others.custom_user_password_funcs;

@Service
public class CoreSessionFactoryInitService {

  //@Autowired
  //C_Lang_Service c_Lang_Service;

  private SessionFactory hibernateFactory;

  public SessionFactory getHibernateFactory() {
    return hibernateFactory;
  }

  public void setHibernateFactory(SessionFactory hibernateFactory) {
    this.hibernateFactory = hibernateFactory;
  }
  
  @Autowired
  public CoreSessionFactoryInitService(EntityManagerFactory factory) {
    if (factory.unwrap(SessionFactory.class) == null) {
      throw new NullPointerException("factory is not a hibernate factory");
    }
    this.hibernateFactory = factory.unwrap(SessionFactory.class);
    CoreSessionFactoryUtil.getSessionFactoryUtilInstance().setSf(hibernateFactory);
    CoreSessionFactoryUtil.getSessionFactoryUtilInstance().after_initialize();
  }

}
