package others;

import beans.VariablesBean;
import gs.common.MyEmailSender;
import java.net.InetAddress;

public class CustomEmailSender extends MyEmailSender {

  private static CustomEmailSender instance = new CustomEmailSender();

  public static CustomEmailSender getInstance() {
    if (instance == null) {
      return new CustomEmailSender();
    }
    return instance;
  }

  @Override
  protected int getEmail_send_timeout_in_min() {
    return VariablesBean.getCI().getEmail_send_timeout_in_min();
  }

  @Override
  protected int getSms_send_timeout_in_min() {
    return VariablesBean.getCI().getSms_send_timeout_in_min();
  }

  @Override
  protected synchronized void send_email_inner_code(String body_) throws Exception {
    custom_email_funcs.send_email_from_common_settings_sender_email("Error in " + System.getProperty("user.dir") + ", computer_name=" + InetAddress.getLocalHost().getHostName(), body_);
  }

  @Override
  protected synchronized void send_email_inner_code(String subject_, String body_) throws Exception {
    custom_email_funcs.send_email_from_common_settings_sender_email("Error in " + System.getProperty("user.dir") + ", computer_name=" + InetAddress.getLocalHost().getHostName() + ", " + subject_, body_);
  }
  
  @Override
  protected synchronized void send_sms_inner_code(String body_) throws Exception {
    email.funcs.send_sms_email_from_standart_sender("Error in " + System.getProperty("user.dir") + ", computer_name=" + InetAddress.getLocalHost().getHostName(), body_);
  }

}
