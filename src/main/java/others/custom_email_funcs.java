package others;

import static email.funcs.c_smtp_security_model_ssl;
import static email.funcs.*;
import gs.common.other_funcs;
import static managers.core.dbtables.C_Java_Data_Type_Manager.*;
import org.hibernate.Session;
import gs.common.hibernate_funcs;
import managers.core.dbtables.C_Proj_Manager;
import managers.core.dbtables.C_Proj_Sender_Email_Manager;
import model.core.dbtables.C_Email_Out;
import model.core.dbtables.C_Proj;
import model.core.dbtables.C_Proj_Sender_Email;
import org.hibernate.Transaction;

public class custom_email_funcs {

  public static String send_email_from_common_settings_sender_email(String subject_, String body_) {
    String res = "";
    new Thread() {
      public void run() {
        //C_Proj_Sender_Email_Manager.getCI().ins_email(C_Proj_Manager.const_c_proj_id_common, "barkuan@mail.ru", "", "", subject_, body_, false, "");
        C_Proj c_proj_ = C_Proj_Manager.getCI().get_rec(C_Proj_Manager.const_c_proj_id_common);
        //C_Proj_Sender_Email c_proj_sender_email_ = C_Proj_Sender_Email_Manager.getCI().get_c_proj_sender_email(C_Proj_Manager.const_c_proj_id_common);
        try {
          C_Email_Out res = core_custom_funcs.send_email(c_proj_, "barkuan@mail.ru", subject_, body_, "", false, "ru", false);
          /*
          String res = send_email(c_proj_sender_email_.getC_smtp_security_t().getCode(), c_proj_sender_email_.getSmtp_server_port(), c_proj_sender_email_.getSmtp_server(), c_proj_sender_email_.getIs_smtp_authorize(),
            c_proj_sender_email_.getSmtp_login(), c_proj_sender_email_.getSmtp_pswd(),
            c_proj_sender_email_.getSender_email(), "barkuan@mail.ru",
            subject_, body_, false);
           */
        } catch (Exception e) {
          //CustomLogger.error(e);
          //CustomLogger.error(e);
          //CustomEmailSender.getInstance().send_email(other_funcs.stack2string(e));
        }

      }
    }.start();
    return res;
  }

}
