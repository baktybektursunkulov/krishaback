package managers.core.dbtables;

import email.Email_Attachment_Rec;
import gs.common.byte_funcs;
import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.other_funcs;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static managers.core.dbtables.C_Res_Bundle_Manager.check_all_translations;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Proj_Sender_Email_Manager extends Abstract_Controller_Manager<C_Proj_Sender_Email> {

  private static C_Proj_Sender_Email_Manager currentInstance = null;
  private ConcurrentHashMap<Integer, Integer> email_send_counter_map = new ConcurrentHashMap();

  public static C_Proj_Sender_Email_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Proj_Sender_Email_Manager();
    }
    return currentInstance;
  }

  public C_Proj_Sender_Email_Manager() {
    super(C_Proj_Sender_Email.class);
  }

  public C_Proj_Sender_Email get_common_c_proj_sender_email(Session session_) {
    return get_c_proj_sender_email(session_, C_Proj_Manager.getCI().get_common_c_proj(session_).getC_proj());
  }

  public C_Proj_Sender_Email get_common_c_proj_sender_email() {
    return get_c_proj_sender_email(C_Proj_Manager.getCI().get_common_c_proj().getC_proj());
  }

  public C_Proj_Sender_Email get_c_proj_sender_email(Session session_, Integer c_proj_id_) {
    Query q_ = session_.createQuery("from C_Proj_Sender_Email t where is_deleted=false and c_proj=:c_proj_id_ order by 1 asc");
    q_.setInteger("c_proj_id_", c_proj_id_);
    List<C_Proj_Sender_Email> list_ = q_.list();
    if (!list_.isEmpty()) {
      int k;
      if (!email_send_counter_map.containsKey(c_proj_id_)) {
        k = 1;
        email_send_counter_map.put(c_proj_id_, k);
      } else {
        k = email_send_counter_map.get(c_proj_id_);
        k++;
        email_send_counter_map.put(c_proj_id_, k);
      }
      return list_.get(k % list_.size());
    }
    return null;
  }

  public C_Proj_Sender_Email get_c_proj_sender_email(Integer c_proj_id_) {
    C_Proj_Sender_Email res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = get_c_proj_sender_email(session_, c_proj_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Email_Out ins_email_with_attachments(Integer c_proj_id_, String to_, String cc_, String bcc_, String subject_, String body_,
          Vector<Email_Attachment_Rec> attachments_, boolean in_html_format_, String lang_, Boolean is_immediate_send_) throws Exception {
    C_Email_Out res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = ins_email_with_attachments(session_, c_proj_id_, to_, cc_, bcc_, subject_, body_, attachments_, in_html_format_, lang_, is_immediate_send_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
  public C_Email_Out ins_email_with_attachments(Session session_, Integer c_proj_id_, String to_, String cc_, String bcc_, String subject_, String body_,
          Vector<Email_Attachment_Rec> attachments_, boolean in_html_format_, String lang_, Boolean is_immediate_send_) throws Exception {
    C_Email_Out res;
    C_Proj_Sender_Email c_proj_sender_email_ = C_Proj_Sender_Email_Manager.getCI().get_c_proj_sender_email(session_, c_proj_id_);
    List<C_Email_Out_File> c_email_out_file_list_ = null;
    if (attachments_ != null && !attachments_.isEmpty()) {
      c_email_out_file_list_ = new ArrayList();
      C_Email_Out_File c_email_out_file_;
      Email_Attachment_Rec email_Attachment_Rec;
      for (int i = 0; i < attachments_.size(); i++) {
        email_Attachment_Rec = attachments_.get(i);
        c_email_out_file_ = new C_Email_Out_File();
        c_email_out_file_.setContent_type(email_Attachment_Rec.getDs_content_type());
        //try {
          c_email_out_file_.setC_bin_file_body(C_Bin_File_Body_Manager.getCI().ins_row(session_, byte_funcs.convertInputStreamToByteArr(email_Attachment_Rec.getDs_input_stream())));
        //} catch (Exception ex) {
        //  return other_funcs.stack2string(ex);
        //}
        c_email_out_file_.setFile_name(email_Attachment_Rec.getDs_file_name());
        c_email_out_file_list_.add(c_email_out_file_);
      }
    }
    res = C_Email_Out_Manager.getCI().ins_c_email_out(session_, c_proj_id_, c_proj_sender_email_.getC_smtp_security_t_2(session_), c_proj_sender_email_.getSmtp_server_port(),
            c_proj_sender_email_.getSmtp_server(), c_proj_sender_email_.getIs_smtp_authorize(), c_proj_sender_email_.getSmtp_login(), c_proj_sender_email_.getSmtp_pswd(),
            c_proj_sender_email_.getSender_name(), c_proj_sender_email_.getSender_email(), to_, cc_, bcc_, subject_, body_, in_html_format_, c_email_out_file_list_, lang_, is_immediate_send_);
    /*
    String email_send_res_ = email.funcs.send_email_with_attachments(C_Smtp_Security_Manager.get_smtp_security_model(c_proj_sender_email_.getC_smtp_security_t_2(session_)),
            c_proj_sender_email_.getSmtp_server_port(), c_proj_sender_email_.getSmtp_server(), c_proj_sender_email_.getIs_smtp_authorize(), c_proj_sender_email_.getSmtp_login(), c_proj_sender_email_.getSmtp_pswd(),
            c_proj_sender_email_.getSender_name(), c_proj_sender_email_.getSender_email(), to_, cc_, bcc_, subject_,
            body_, false, false, attachments_);
    return email_send_res_;
     */
    return res;
  }

  public C_Email_Out ins_email(Integer c_proj_id_, String to_, String cc_, String bcc_, String subject_, String body_, boolean in_html_format_, String lang_, Boolean is_immediate_send_) throws Exception {
    C_Email_Out res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = ins_email(session_, c_proj_id_, to_, cc_, bcc_, subject_, body_, in_html_format_, lang_, is_immediate_send_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
  public C_Email_Out ins_email(Session session_, Integer c_proj_id_, String to_, String cc_, String bcc_, String subject_, String body_, boolean in_html_format_, String lang_, Boolean is_immediate_send_) throws Exception {
    return ins_email_with_attachments(session_, c_proj_id_, to_, cc_, bcc_, subject_, body_, null, in_html_format_, lang_, is_immediate_send_);
  }

  public C_Email_Out ins_email_with_immediate_send(Session session_, Integer c_proj_id_, String to_, String cc_, String bcc_, String subject_, String body_, boolean in_html_format_, String lang_) throws Exception {
    return ins_email(session_, c_proj_id_, to_, cc_, bcc_, subject_, body_, in_html_format_, lang_, true);
  }
}
