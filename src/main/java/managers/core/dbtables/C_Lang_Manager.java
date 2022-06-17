package managers.core.dbtables;

import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Lang_Manager extends Abstract_Controller_Manager<C_Lang> {

  private static C_Lang_Manager currentInstance = null;

  public static C_Lang_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Lang_Manager();
    }
    return currentInstance;
  }

  public C_Lang_Manager() {
    super(C_Lang.class);
  }

  public List<C_Lang> get_c_lang_list(Session session_) {
    List<C_Lang> res;
    Query q_ = session_.createQuery("from C_Lang where is_deleted=false order by c_lang asc");
  //q_.setCacheable(use_query_cache);
    res = q_.list();
    return res;
  }

  public List<C_Lang> get_c_lang_list() {
    Transaction tx = null;
    List<C_Lang> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();      
      res = get_c_lang_list(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }
   
  
  
}
