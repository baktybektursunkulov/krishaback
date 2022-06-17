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
public class C_Broker_Msg_Receiver_Manager extends Abstract_Controller_Manager<C_Broker_Msg_Receiver> {

  private static C_Broker_Msg_Receiver_Manager currentInstance = null;

  public static C_Broker_Msg_Receiver_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Broker_Msg_Receiver_Manager();
    }
    return currentInstance;
  }

  public C_Broker_Msg_Receiver_Manager() {
    super(C_Broker_Msg_Receiver.class);
  }

    public Integer ins_row(Integer c_broker_msg_id_, String c_broker_receiver__client_id_) {
    Integer res = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = ins_row(session_, c_broker_msg_id_, c_broker_receiver__client_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
  
  public Integer ins_row(Session session_, Integer c_broker_msg_id_, String c_broker_receiver__client_id_) {
    C_Broker_Msg_Receiver new_rec_ = new C_Broker_Msg_Receiver();
    new_rec_.setC_broker_msg(c_broker_msg_id_);
    new_rec_.setC_broker_receiver_t(C_Broker_Receiver_Manager.getCI().get_row_by_client_id(session_, c_broker_receiver__client_id_));
    new_rec_.setReceive_dt(new Date());
    new_rec_.setReceive_err_msg("");
    session_.save(new_rec_);
    return new_rec_.getC_broker_msg();
  }
  
  public void upd_receiver_err_msg(Integer c_broker_msg_id_, String sent_err_msg_) {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      upd_receiver_err_msg(session_, c_broker_msg_id_, sent_err_msg_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }
  
  
  public void upd_receiver_err_msg(Session session_, Integer c_broker_msg_receiver_id_, String receive_err_msg_) {
    C_Broker_Msg_Receiver new_rec_ = C_Broker_Msg_Receiver_Manager.getCI().get_rec(session_, c_broker_msg_receiver_id_);
    new_rec_.setReceive_err_msg(receive_err_msg_);
    session_.merge(new_rec_);
  }

}
