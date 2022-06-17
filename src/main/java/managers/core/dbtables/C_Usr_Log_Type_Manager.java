package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Usr_Log_Type_Manager extends Abstract_Controller_Manager<C_Usr_Log_Type> {

  private static C_Usr_Log_Type_Manager currentInstance = null;
  private static C_Usr_Log_Type c_c_usr_log_type__login;
  private static C_Usr_Log_Type c_c_usr_log_type__logout;   

  public static C_Usr_Log_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Log_Type_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Log_Type_Manager() {
    super(C_Usr_Log_Type.class);
  }

  public static C_Usr_Log_Type getC_c_usr_log_type__login() {
    if (c_c_usr_log_type__login == null) {
      c_c_usr_log_type__login = getCI().get_rec_by_code_with_cache("login");
    }
    return c_c_usr_log_type__login;
  }

  public static void setC_c_usr_log_type__login(C_Usr_Log_Type c_c_usr_log_type__login) {
    C_Usr_Log_Type_Manager.c_c_usr_log_type__login = c_c_usr_log_type__login;
  }

  public static C_Usr_Log_Type getC_c_usr_log_type__logout() {
    if (c_c_usr_log_type__logout == null) {
      c_c_usr_log_type__logout = getCI().get_rec_by_code_with_cache("logout");
    }
    return c_c_usr_log_type__logout;
  }

  public static void setC_c_usr_log_type__logout(C_Usr_Log_Type c_c_usr_log_type__logout) {
    C_Usr_Log_Type_Manager.c_c_usr_log_type__logout = c_c_usr_log_type__logout;
  }   
}
