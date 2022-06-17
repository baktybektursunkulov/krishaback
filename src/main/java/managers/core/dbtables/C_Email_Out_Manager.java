package managers.core.dbtables;

import email.Email_Attachment_Rec;
import gs.common.byte_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Order_Condition;
import gs.common.model.db.SQL_Where_Condition;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Logger;
import org.hibernate.Session;
import others.core_custom_funcs;

@ManagedBean
@ApplicationScoped
public class C_Email_Out_Manager extends Abstract_Controller_Manager<C_Email_Out> {

  private static C_Email_Out_Manager currentInstance = null;

  public static C_Email_Out_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Email_Out_Manager();
    }
    return currentInstance;
  }

  public C_Email_Out_Manager() {
    super(C_Email_Out.class);
  }

  public C_Email_Out ins_c_email_out(Session session_, Integer c_proj_id_, C_Smtp_Security c_smtp_security_, Integer smtp_server_port_, String smtp_server_, boolean is_smtp_authorize_, String smtp_login_, String smtp_pswd_, String sender_name_,
    String sender_email_, String receiver_email_, String cc_, String bcc_, String subject_, String body_, boolean in_html_format_, List<C_Email_Out_File> c_email_out_file_list_,
    String lang_, Boolean is_immediate_send_
  ) {
    C_Email_Out rec_ = new C_Email_Out();
    rec_.setC_proj(c_proj_id_);
    rec_.setC_smtp_security_t(c_smtp_security_);
    rec_.setSmtp_server_port(smtp_server_port_);
    rec_.setSmtp_server(smtp_server_);
    rec_.setIs_smtp_authorize(is_smtp_authorize_);
    rec_.setSmtp_login(smtp_login_);
    rec_.setSmtp_pswd(smtp_pswd_);
    rec_.setSender_name(sender_name_);
    rec_.setSender_email(sender_email_);
    rec_.setReceiver_email(receiver_email_);
    rec_.setCc(cc_);
    rec_.setBcc(bcc_);
    rec_.setSubject(subject_);
    rec_.setBody(body_);
    rec_.setIn_html_format(in_html_format_);
    rec_.setLang(lang_);
    rec_.setIns_dt(new Date());
    rec_.setIs_sent(is_immediate_send_);
    rec_.setSent_dt(null);
    rec_.setSent_err_msg(null);
    rec_.setIs_deleted(false);
    session_.save(rec_);

    C_Email_Out_File c_email_out_file_;
    if (c_email_out_file_list_ != null) {
      for (int i = 0; i < c_email_out_file_list_.size(); i++) {
        c_email_out_file_ = new C_Email_Out_File();
        c_email_out_file_.setC_email_out_t(rec_);
        c_email_out_file_.setContent_type(c_email_out_file_list_.get(i).getContent_type());
        c_email_out_file_.setFile_name(c_email_out_file_list_.get(i).getFile_name());
        c_email_out_file_.setC_bin_file_body(c_email_out_file_list_.get(i).getC_bin_file_body());
        c_email_out_file_.setIs_deleted(false);
        session_.save(c_email_out_file_);
      }
    }
    if (is_immediate_send_) {
      process_c_email_out(session_, rec_, null);
    }
    return rec_;
  }

  public List<C_Email_Out> get_unsent_list(Session session_) {
    return get_rec_list_5_1_c(session_, new SQL_Where_Condition("is_deleted=false and is_sent=false"), new SQL_Order_Condition("c_email_out", "asc"), false);
  }

  public void process_c_email_out(Session session_, C_Email_Out c_email_out_, Logger logger) {
    List<C_Email_Out_File> c_email_out_file_list_;
    C_Email_Out_File c_email_out_file_;
    ResourceBundle bundle_;
    Vector<Email_Attachment_Rec> attachments_;
    Email_Attachment_Rec attachment_;
    String email_send_res_;
    String msg_;
    boolean is_send_email_ = true;

    c_email_out_file_list_ = C_Email_Out_File_Manager.getCI().get_rec_list(session_, c_email_out_.getC_email_out());
    attachments_ = new Vector<>();
    for (int k = 0; k < c_email_out_file_list_.size(); k++) {
      c_email_out_file_ = c_email_out_file_list_.get(k);
      attachment_ = new Email_Attachment_Rec();
      attachment_.setDs_content_type(c_email_out_file_.getContent_type());
      attachment_.setDs_file_name(c_email_out_file_.getFile_name());
      attachment_.setDs_input_stream(byte_funcs.convertByteArrToInputStream(c_email_out_file_.getBin_file_body_t_2(session_).getFile_body()));
      attachments_.add(attachment_);
    }

    bundle_ = core_custom_funcs.getResourceBundle(c_email_out_.getLang());
    email_send_res_ = email.funcs.send_email_with_attachments(C_Smtp_Security_Manager.get_smtp_security_model(c_email_out_.getC_smtp_security_t_2(session_)),
      c_email_out_.getSmtp_server_port(), c_email_out_.getSmtp_server(), c_email_out_.getIs_smtp_authorize(), c_email_out_.getSmtp_login(), c_email_out_.getSmtp_pswd(),
      c_email_out_.getSender_name(), c_email_out_.getSender_email(), c_email_out_.getReceiver_email(), c_email_out_.getCc(), c_email_out_.getBcc(),
      c_email_out_.getSubject(), c_email_out_.getBody().trim().isEmpty() ? c_email_out_.getSubject() : c_email_out_.getBody(),
      false, c_email_out_.getIn_html_format(), attachments_);
    if (!email_send_res_.isEmpty()) {
      c_email_out_.setSent_err_msg(email_send_res_);
      if (logger != null) {
        logger.warning("Ошибка при отправке с e-mail " + c_email_out_.getSender_email() + " на e-mail " + c_email_out_.getReceiver_email() + ": " + email_send_res_);
      }
    }
    c_email_out_.setIs_sent(true);
    c_email_out_.setSent_dt(new Date());
    session_.merge(c_email_out_);
  }
}
