package managers.core.dbtables;

import beans.CUsrBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.jsf.jsf_funcs;
import java.util.Date;

@ManagedBean
@ApplicationScoped
public class C_Usr_Log_Manager extends Abstract_Controller_Manager<C_Usr_Log> {

  private static C_Usr_Log_Manager currentInstance = null;

  public static C_Usr_Log_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Log_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Log_Manager() {
    super(C_Usr_Log.class);
  }

  public static void insUsrLog(C_Usr c_usr_, Date log_dt_, C_Usr_Log_Type c_usr_log_type_, String log_host_, C_Usr_Log_Service c_usr_log_service_) {
    C_Usr_Log c_usr_log_ = new C_Usr_Log();
    c_usr_log_.setC_usr(c_usr_.getC_usr());
    c_usr_log_.setLog_dt(log_dt_);
    c_usr_log_.setC_usr_log_type(c_usr_log_type_.getC_usr_log_type());
    c_usr_log_.setLog_host(log_host_);
    c_usr_log_.setC_usr_log_service(c_usr_log_service_.getC_usr_log_service());
    c_usr_log_.setIs_deleted(false);
    getCI().insert_rec(c_usr_log_);
  }

  public static void insUsrLog(C_Usr c_usr_, C_Usr_Log_Type c_usr_log_type_, C_Usr_Log_Service c_usr_log_service_, String remote_addr_) {
    insUsrLog(c_usr_, C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(c_usr_), c_usr_log_type_, remote_addr_, c_usr_log_service_);
  }

  public static void insLoggedUsrLog(C_Usr logged_c_usr_, C_Usr_Log_Type c_usr_log_type_, C_Usr_Log_Service c_usr_log_service_, String remote_addr_) {
    insUsrLog(logged_c_usr_, C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(logged_c_usr_), c_usr_log_type_, remote_addr_, c_usr_log_service_);
  }

  // Р’ РїРѕС‚РѕРєРµ FacesContext РЅРѕРІС‹Р№, РёР·-Р·Р° СЌС‚РѕРіРѕ РЅРµ СЃС‚РѕРёС‚ РёСЃРїРѕР»СЊР·РѕРІР°С‚СЊ
  /*
  public static void insUsrLogInThread(C_Usr c_usr_, Date log_dt_, C_Usr_Log_Type c_usr_log_type_, String log_host_, C_Usr_Log_Service c_usr_log_service_) {
    //C_Tbl_Rec_Prop_Val_Manager.getCurrentInstance().set_string_c_tbl_rec_prop_val("c_usr", c_usr_.getC_usr().toString(), prop_code_, prop_val_);
    new insUsrLogThread(c_usr_, log_dt_, c_usr_log_type_, log_host_, c_usr_log_service_);
  }
  */
/*
  public static void insLoggedUsrLogInThread(C_Usr logged_c_usr_, C_Usr_Log_Type c_usr_log_type_, C_Usr_Log_Service c_usr_log_service_) {
    //C_Tbl_Rec_Prop_Val_Manager.getCurrentInstance().set_string_c_tbl_rec_prop_val("c_usr", c_usr_.getC_usr().toString(), prop_code_, prop_val_);
    new insUsrLogThread(logged_c_usr_, C_Usr_Manager.getCI().getLoggedUsrCorrectedNow(logged_c_usr_), c_usr_log_type_, jsf_funcs.getRequestRemoteHost(), c_usr_log_service_);
  }
*/
  /*
   public static void insUsrLogInThread(C_Usr c_usr_, C_Usr_Log_Type c_usr_log_type_, C_Usr_Log_Service c_usr_log_service_) {
   //C_Tbl_Rec_Prop_Val_Manager.getCurrentInstance().set_string_c_tbl_rec_prop_val("c_usr", c_usr_.getC_usr().toString(), prop_code_, prop_val_);
   new insUsrLogThread(c_usr_, c_usr_log_type_, jsf_funcs.getRequestRemoteHost(), c_usr_log_service_);
   }
   */
  // Р’ РїРѕС‚РѕРєРµ FacesContext РЅРѕРІС‹Р№, РёР·-Р·Р° СЌС‚РѕРіРѕ РЅРµ СЃС‚РѕРёС‚ РёСЃРїРѕР»СЊР·РѕРІР°С‚СЊ
  /*
  public static class insUsrLogThread implements Runnable {

    private Date log_dt;
    private C_Usr c_usr;
    private C_Usr_Log_Type c_usr_log_type;
    private String log_host;
    private C_Usr_Log_Service c_usr_log_service;

    public insUsrLogThread(C_Usr c_usr_, Date log_dt_, C_Usr_Log_Type c_usr_log_type_, String log_host_, C_Usr_Log_Service c_usr_log_service_) {
      c_usr = c_usr_;
      log_dt = log_dt_;
      c_usr_log_type = c_usr_log_type_;
      log_host = log_host_;
      c_usr_log_service = c_usr_log_service_;
      new Thread(this).start();
    }

    @Override
    public void run() {
      insUsrLog(this.c_usr, this.log_dt, this.c_usr_log_type, this.log_host, this.c_usr_log_service);
    }
  }  
*/
}
