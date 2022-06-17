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
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Proj_Manager extends Abstract_Controller_Manager<C_Proj> {

  private static C_Proj_Manager currentInstance = null;
  public static Integer const_c_proj_id_common = 2;

  public static C_Proj_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Proj_Manager();
    }
    return currentInstance;
  }

  public C_Proj_Manager() {
    super(C_Proj.class);
  }

  public C_Proj get_common_c_proj(Session session_) {
    Query q_ = session_.createQuery("from C_Proj where is_deleted=false and code='common'");
    List<C_Proj> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }
  
  public C_Proj get_common_c_proj() {
    C_Proj res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = get_common_c_proj(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }  
}
