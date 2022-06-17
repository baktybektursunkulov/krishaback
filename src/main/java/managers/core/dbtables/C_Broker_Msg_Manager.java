package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;
import org.codehaus.jettison.json.JSONObject;

@ManagedBean
@ApplicationScoped
public class C_Broker_Msg_Manager extends Abstract_Controller_Manager<C_Broker_Msg> {

  private static C_Broker_Msg_Manager currentInstance = null;

  public static C_Broker_Msg_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Broker_Msg_Manager();
    }
    return currentInstance;
  }

  public C_Broker_Msg_Manager() {
    super(C_Broker_Msg.class);
  }

  public Integer ins_row(String c_broker_sender__client_id_, String subject_, String body_, JSONObject params_) {
    Integer res = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = ins_row(session_, c_broker_sender__client_id_, subject_, body_, params_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
  
  public Integer ins_row(Session session_, String c_broker_sender__client_id_, String subject_, String body_, JSONObject params_) {
    C_Broker_Msg new_rec_ = new C_Broker_Msg();
    new_rec_.setC_broker_sender_t(C_Broker_Sender_Manager.getCI().get_row_by_client_id(session_, c_broker_sender__client_id_));
    new_rec_.setSubject(subject_);
    new_rec_.setBody(body_);
    if (params_ != null) {
      new_rec_.setParams(params_.toString());
    }
    new_rec_.setIns_dt(new Date());
    new_rec_.setIs_sent(true);
    new_rec_.setSent_dt(new Date());
    new_rec_.setSent_err_msg("");
    new_rec_.setIs_deleted(false);
    session_.save(new_rec_);
    return new_rec_.getC_broker_msg();
  }
  
  public void upd_sent_err_msg(Integer c_broker_msg_id_, String sent_err_msg_) {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      upd_sent_err_msg(session_, c_broker_msg_id_, sent_err_msg_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }
  
  
  public void upd_sent_err_msg(Session session_, Integer c_broker_msg_id_, String sent_err_msg_) {
    C_Broker_Msg new_rec_ = C_Broker_Msg_Manager.getCI().get_rec(session_, c_broker_msg_id_);
    new_rec_.setSent_err_msg(sent_err_msg_);
    session_.merge(new_rec_);
  }
}
