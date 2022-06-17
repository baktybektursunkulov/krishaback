package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Usr_Log_Service_Manager extends Abstract_Controller_Manager<C_Usr_Log_Service> {

  private static C_Usr_Log_Service_Manager currentInstance = null;
  private static C_Usr_Log_Service c_c_usr_log_service__web;
  private static C_Usr_Log_Service c_c_usr_log_service__mobile_web;
  private static C_Usr_Log_Service c_c_usr_log_service__json_api;
 
  public static C_Usr_Log_Service_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Log_Service_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Log_Service_Manager() {
    super(C_Usr_Log_Service.class);
  }

  public static C_Usr_Log_Service getC_c_usr_log_service__web() {
    if (c_c_usr_log_service__web == null) {
      c_c_usr_log_service__web = getCI().get_rec_by_code_2_with_cache("web");
    }
    return c_c_usr_log_service__web;
  }

  public static void setC_c_usr_log_service__web(C_Usr_Log_Service c_c_usr_log_service__web) {
    C_Usr_Log_Service_Manager.c_c_usr_log_service__web = c_c_usr_log_service__web;
  }

  public static C_Usr_Log_Service getC_c_usr_log_service__mobile_web() {
    if (c_c_usr_log_service__mobile_web == null) {
      c_c_usr_log_service__mobile_web = getCI().get_rec_by_code_2_with_cache("mobile_web");
    }
    return c_c_usr_log_service__mobile_web;
  }

  public static void setC_c_usr_log_service__mobile_web(C_Usr_Log_Service c_c_usr_log_service__mobile_web) {
    C_Usr_Log_Service_Manager.c_c_usr_log_service__mobile_web = c_c_usr_log_service__mobile_web;
  }

  public static C_Usr_Log_Service getC_c_usr_log_service__json_api() {
    if (c_c_usr_log_service__json_api == null) {
      c_c_usr_log_service__json_api = getCI().get_rec_by_code_2_with_cache("json_api");
    }
    return c_c_usr_log_service__json_api;
  }

  public static void setC_c_usr_log_service__json_api(C_Usr_Log_Service c_c_usr_log_service__json_api) {
    C_Usr_Log_Service_Manager.c_c_usr_log_service__json_api = c_c_usr_log_service__json_api;
  }
   
}
