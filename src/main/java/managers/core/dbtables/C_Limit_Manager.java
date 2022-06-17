package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class C_Limit_Manager extends Abstract_Controller_Manager<C_Limit> {

  private static C_Limit_Manager currentInstance = null;
  private static C_Limit c_c_limit__unsucc_login;

  public static C_Limit_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Limit_Manager();
    }
    return currentInstance;
  }

  public C_Limit_Manager() {
    super(C_Limit.class);
  }

  public static C_Limit getC_c_limit__unsucc_login() {
    if (c_c_limit__unsucc_login == null) {
      c_c_limit__unsucc_login = getCI().get_rec_by_code_with_cache("unsucc_login");
    }
    return c_c_limit__unsucc_login;
  }

  public static void setC_c_limit__unsucc_login(C_Limit c_c_limit__unsucc_login) {
    C_Limit_Manager.c_c_limit__unsucc_login = c_c_limit__unsucc_login;
  }

  public static C_Limit getC_c_limit__unsucc_login(Session session_) {
    if (c_c_limit__unsucc_login == null) {
      c_c_limit__unsucc_login = getCI().get_rec_by_code_with_cache(session_, "unsucc_login");
    }
    return c_c_limit__unsucc_login;
  }

}
