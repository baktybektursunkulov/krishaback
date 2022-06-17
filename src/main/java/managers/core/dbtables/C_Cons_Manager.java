package managers.core.dbtables;

import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Cons_Manager extends Abstract_Controller_Manager<C_Cons> {

  private static C_Cons_Manager currentInstance = null;

  public static C_Cons_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Cons_Manager();
    }
    return currentInstance;
  }

  public C_Cons_Manager() {
    super(C_Cons.class);
  }

  public C_Cons get_row(Integer c_proj_id_, String code_) {
    C_Cons res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row(session_, c_proj_id_, code_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;    
  }

  
  public C_Cons get_row(Session session_, Integer c_proj_id_, String code_) {
    Query q_ = session_.createQuery("from C_Cons t where t.is_deleted=false and t.c_proj=:c_proj_id_ and code=:code_ order by 1 asc");
    q_.setInteger("c_proj_id_", c_proj_id_);
    q_.setString("code_", code_);
    q_.setMaxResults(1);
    List<C_Cons> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }
}
