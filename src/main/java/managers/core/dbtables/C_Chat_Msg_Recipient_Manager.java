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

@ManagedBean
@ApplicationScoped
public class C_Chat_Msg_Recipient_Manager extends Abstract_Controller_Manager<C_Chat_Msg_Recipient> {

  private static C_Chat_Msg_Recipient_Manager currentInstance = null;

  public static C_Chat_Msg_Recipient_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Chat_Msg_Recipient_Manager();
    }
    return currentInstance;
  }

  public C_Chat_Msg_Recipient_Manager() {
    super(C_Chat_Msg_Recipient.class);
  }

  public C_Chat_Msg_Recipient ins_row(Session session_, Long c_chat_msg_id_, Integer c_tbl_id_, Long rec_id_, Date dt_) {
    C_Chat_Msg_Recipient res = new C_Chat_Msg_Recipient();
    res.setC_chat_msg(c_chat_msg_id_);
    res.setC_tbl(c_tbl_id_);
    res.setRec_id(rec_id_);
    res.setIs_read(false);
    res.setRead_dt(null);
    res.setIs_delivered(true);
    res.setDeliver_dt(dt_);
    res.setIns_dt(new Date());
    res.setIs_deleted(false);
    session_.save(res);
    return res;
  }

  public List<C_Chat_Msg_Recipient> get_unread_row_list(Session session_, Long c_chat_msg_id_, Integer c_tbl_id_, Long rec_id_) {
    Query q_ = session_.createQuery("from C_Chat_Msg_Recipient t where t.is_deleted=false and t.c_chat_msg=:c_chat_msg_id_ and t.c_tbl=:c_tbl_id_ and t.rec_id=:rec_id_ and t.is_read=false order by t.ins_dt asc");
    q_.setLong("c_chat_msg_id_", c_chat_msg_id_);
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setLong("rec_id_", rec_id_);
    return q_.list();
  }
}
