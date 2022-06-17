package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Sms_Out_Manager extends Abstract_Controller_Manager<C_Sms_Out> {

  private static C_Sms_Out_Manager currentInstance = null;

  public static C_Sms_Out_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Sms_Out_Manager();
    }
    return currentInstance;
  }

  public C_Sms_Out_Manager() {
    super(C_Sms_Out.class);
  }

  public void ins_c_sms_out(Session session_, String phone_number_, String msg_txt_, Boolean is_with_feedback_) {
    C_Sms_Out c_Sms_Out = new C_Sms_Out();
    c_Sms_Out.setPhone_number(phone_number_);
    c_Sms_Out.setMsg_txt(msg_txt_);
    c_Sms_Out.setIs_with_feedback(is_with_feedback_);
    c_Sms_Out.setIns_dt(new Date());
    c_Sms_Out.setIs_sent(false);
    c_Sms_Out.setSent_dt(null);
    c_Sms_Out.setSent_err_msg(null);
    c_Sms_Out.setApi_msg_id(null);
    c_Sms_Out.setApi_cost(null);
    c_Sms_Out.setApi_cost_cur(null);
    c_Sms_Out.setIs_deleted(false);
    session_.save(c_Sms_Out);
  }

  public List<C_Sms_Out> get_unsent_list(Session session_) {
    return get_rec_list_5_1_c(session_, new SQL_Where_Condition("is_deleted=false and is_sent=false"), new SQL_Order_Condition("c_sms_out", "asc"), false);
  }

  public List<C_Sms_Out> get_rec_list(Session session_, C_Usr c_usr_, Date begin_dt_, Date end_dt_) {
    Query q_ = session_.createQuery("from C_Sms_Out where is_deleted=false and sent_dt between :begin_dt_ and :end_dt_ and is_sent=true order by sent_dt asc");
    q_.setTimestamp("begin_dt_", C_Usr_Manager.getCI().getUsrTimeToGMT0600TZ(c_usr_, begin_dt_));
    q_.setTimestamp("end_dt_", C_Usr_Manager.getCI().getUsrTimeToGMT0600TZ(c_usr_, end_dt_));
    return q_.list();
  }  
}
