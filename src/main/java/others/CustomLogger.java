package others;

import beans.CUsrBean;
import beans.VariablesBean;
import gs.common.MyLogger;
import gs.common.jsf.bundle_funcs;
import gs.common.other_funcs;
import gs.common.jsf.jsf_funcs;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import model.core.dbtables.C_Usr;

public class CustomLogger extends MyLogger {

  private static CustomLogger instance = new CustomLogger();

  public static CustomLogger getInstance() {
    if (instance == null) {
      return new CustomLogger();
    }
    return instance;
  }

  @Override
  protected void instance_log_after(String str_) {
    if (VariablesBean.getCI().getIs_print_log_text()) {
      System.out.println(str_);
    }
  }

  @Override
  protected void instance_log_after(String TAG, String str_) {
    if (VariablesBean.getCI().getIs_print_log_text()) {
      System.out.println(TAG + ", " + str_);
    }
  }

  @Override
  protected void instance_log_after(Object obj_) {
    if (VariablesBean.getCI().getIs_print_log_text()) {
      System.out.println(obj_);
    }
  }

  @Override
  protected void instance_error_after(String str_) {
    CUsrBean cUsrBean = CUsrBean.getCurrentBean();
    if (cUsrBean != null && cUsrBean.getLoggedCUsr() != null && cUsrBean.getLoggedCUsr() != null) {
      str_ = "User login: " + cUsrBean.getLoggedCUsr().getName() + ", error_text: " + str_;
    }
    if (VariablesBean.getCI().getIs_print_error_text()) {
      System.out.println(str_);
    }
    if (VariablesBean.getCI().getIs_send_email_on_error()) {
      ResourceBundle resourceBundle = null;
      try {
        resourceBundle = bundle_funcs.getBundle();
      } catch (Exception e) {
        resourceBundle = null;
      }
      if (resourceBundle == null || (resourceBundle != null && !str_.equals(bundle_funcs.getBundleValue(resourceBundle, "U_vas_net_prav_na_vypolnenie_dannoj_operacii")))) {
        if (is_email_body_correct(str_)) {
          CustomEmailSender.getInstance().send_email(str_);
        }
      }
    }
    check_on_sens_sms(str_);
  }

  @Override
  protected void instance_error_after(String subject_, String body_) {
    CUsrBean cUsrBean = CUsrBean.getCurrentBean();
    if (cUsrBean != null && cUsrBean.getLoggedCUsr() != null && cUsrBean.getLoggedCUsr() != null) {
      body_ = "User login: " + cUsrBean.getLoggedCUsr().getName() + ", error_text: " + body_;
    }
    if (VariablesBean.getCI().getIs_print_error_text()) {
      System.out.println(body_);
    }
    if (VariablesBean.getCI().getIs_send_email_on_error()) {
      boolean is_send_mail_ = false;
      if (FacesContext.getCurrentInstance() != null && !body_.equals(bundle_funcs.getBundleValue("U_vas_net_prav_na_vypolnenie_dannoj_operacii"))) {
        is_send_mail_ = true;
      } else {
        is_send_mail_ = true;
      }
      if (is_send_mail_) {
        if (is_email_body_correct(body_)) {
          CustomEmailSender.getInstance().send_email(subject_, body_);
        }
      }
    }
    check_on_sens_sms(body_);
  }

  public boolean is_email_body_correct(String body_) {
    if (!body_.contains("C_Usr_Manager.java:761") && !body_.contains("C_Usr_Manager.java:737") && !body_.contains("C_Usr_Manager.java:765")
      && !body_.contains("mainUsersAccessController.java:453")
      && !body_.contains("Jr_Rep_Manager.java:149") && !body_.contains("get_img_converted_by_width_servlet.java:46")
      && !body_.contains("get_img_converted_by_width_servlet.java:44") && !body_.contains("main_js_str_list_servlet.java:76")
      && !body_.contains("Main_Reports_Controller_Execute_Thread.java:83")
      && !body_.contains("Main_Check_New_V3_Online_Notif_Thread.java:77")
      && !body_.contains("Main_Check_New_V3_Online_Notif_Thread.java:85")
      && !body_.contains("Main_Check_New_V3_Info_Msg_Usr_Thread.java:78")
      && !body_.trim().equals("java.lang.NullPointerException")
      && !body_.contains("javax.faces.application.ViewExpiredException")
      && !body_.contains(".php")
      /*&& (!((body_.contains("java.lang.NullPointerException") || body_.contains("javax.faces.FacesException")) && (body_.contains("InvokeApplicationPhase")
      || body_.contains("ProcessValidationsPhase")
      || body_.contains("ApplyRequestValuesPhase")
      || body_.contains("UpdateModelValuesPhase")
      || body_.contains("RenderResponsePhase")
      || body_.contains("RestoreViewPhase"))))*/) {
      return true;
    }
    return false;
  }

  public static void check_on_sens_sms(String body_) {
    if (VariablesBean.getCI().getIs_test_mode()) {
      return;
    }
    String sms_txt_ = body_;
    if (sms_txt_.length() > 90) {
      sms_txt_ = sms_txt_.substring(0, 90);
    }
    if (body_.contains("OutOfMemory") || body_.contains("nested transactions not supported") /*|| body_.contains("org.hibernate.TransactionException")*/
      || body_.contains("org.hibernate.service.UnknownServiceException")) {
      CustomEmailSender.getInstance().send_sms(sms_txt_);
    }
  }

  public static void error(String str_) {
    getInstance().instance_error(str_);
  }

  public static void log(String str_) {
    getInstance().instance_log(str_);
  }

  public static void log(String TAG, String str_) {
    getInstance().instance_log(TAG, str_);
  }

  public static void log(Object obj_) {
    getInstance().instance_log(obj_);
  }

  public static void error(Exception e) {
    getInstance().instance_error(e);
  }

  public static void error(Throwable t) {
    getInstance().instance_error(t);
  }

  public static void error_with_c_usr_login(C_Usr logged_c_usr_, String str_) {
    getInstance().instance_error(str_ + ", logged_c_usr_name=" + (logged_c_usr_ == null ? "null" : logged_c_usr_.getName()));
  }

  public static void error_with_c_usr_login(C_Usr logged_c_usr_, Exception e) {
    getInstance().instance_error(e.toString(), other_funcs.stack2string(e) + ", logged_c_usr_name=" + (logged_c_usr_ == null ? "null" : logged_c_usr_.getName()));
  }

  public static void error_with_c_usr_login(C_Usr logged_c_usr_, Throwable t) {
    getInstance().instance_error(t.toString(), other_funcs.stack2string(t) + ", logged_c_usr_name=" + (logged_c_usr_ == null ? "null" : logged_c_usr_.getName()));
  }
}
