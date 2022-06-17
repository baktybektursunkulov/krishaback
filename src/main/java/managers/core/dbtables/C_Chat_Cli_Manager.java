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
public class C_Chat_Cli_Manager extends Abstract_Controller_Manager<C_Chat_Cli> {

  private static C_Chat_Cli_Manager currentInstance = null;

  public static C_Chat_Cli_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Chat_Cli_Manager();
    }
    return currentInstance;
  }

  public C_Chat_Cli_Manager() {
    super(C_Chat_Cli.class);
  }

  public C_Chat_Cli ins_row(Session session_, Integer c_chat_id_, Integer c_tbl_id_, Long rec_id_, Boolean is_admin_) {
    C_Chat_Cli res = new C_Chat_Cli();
    res.setC_chat(c_chat_id_);
    res.setC_tbl(c_tbl_id_);
    res.setRec_id(rec_id_);
    res.setIs_admin(is_admin_);
    res.setUnread_msg_cnt(0);
    res.setIns_dt(new Date());
    res.setIs_deleted(false);
    session_.save(res);
    return res;
  }

  public C_Chat_Cli get_opposite_row_for_indiv_chat(Session session_, Integer c_chat_id_, Integer initiator_c_tbl_id_, Long initiator_rec_id_) {
    Query q_ = session_.createQuery("from C_Chat_Cli t where t.is_deleted=false and t.c_chat=:c_chat_id_ "
      + "and not (t.c_tbl=:initiator_c_tbl_id_ and t.rec_id=:initiator_rec_id_) "
      + "order by 1 asc");
    q_.setInteger("c_chat_id_", c_chat_id_);
    q_.setInteger("initiator_c_tbl_id_", initiator_c_tbl_id_);
    q_.setLong("initiator_rec_id_", initiator_rec_id_);
    q_.setMaxResults(1);
    List<C_Chat_Cli> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public C_Chat_Cli get_initiator_row_for_indiv_chat(Session session_, Integer c_chat_id_, Integer initiator_c_tbl_id_, Long initiator_rec_id_) {
    Query q_ = session_.createQuery("from C_Chat_Cli t where t.is_deleted=false and t.c_chat=:c_chat_id_ "
      + "and t.c_tbl=:initiator_c_tbl_id_ and t.rec_id=:initiator_rec_id_ "
      + "order by 1 asc");
    q_.setInteger("c_chat_id_", c_chat_id_);
    q_.setInteger("initiator_c_tbl_id_", initiator_c_tbl_id_);
    q_.setLong("initiator_rec_id_", initiator_rec_id_);
    q_.setMaxResults(1);
    List<C_Chat_Cli> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public void upd_unread_msg_cnt(Session session_, Integer c_chat_cli_id_) {
    Query q_ = session_.createQuery("update C_Chat_Cli t set unread_msg_cnt="
      + "("
      + "select count(cm.c_chat_msg) "
      + "from C_Chat_Msg cm, C_Chat_Msg_Recipient cmr "
      + "where "
      + "  cm.is_deleted=false and cm.c_chat=t.c_chat "
      + "  and cmr.is_deleted=false and cmr.c_chat_msg=cm.c_chat_msg and cmr.c_tbl=t.c_tbl and cmr.rec_id=t.rec_id and cmr.is_read=false  "
      + ") where c_chat_cli=:c_chat_cli_id_ ");
    q_.setInteger("c_chat_cli_id_", c_chat_cli_id_);
    q_.executeUpdate();
  }

  public void set_is_read(Session session_, C_Chat c_chat_, C_Chat_Cli initiator_c_chat_cli_, C_Chat_Cli opposite_c_chat_cli_, Date read_dt_) {
    List<C_Chat_Msg> c_chat_msg_list_ = C_Chat_Msg_Manager.getCI().get_unread_row_list(session_, c_chat_.getC_chat(), opposite_c_chat_cli_.getC_tbl(), opposite_c_chat_cli_.getRec_id());
    C_Chat_Msg c_Chat_Msg;
    List<C_Chat_Msg_Recipient> c_chat_msg_recipient_list_;
    C_Chat_Msg_Recipient c_Chat_Msg_Recipient;
    for (int i = 0; i < c_chat_msg_list_.size(); i++) {
      c_Chat_Msg = c_chat_msg_list_.get(i);
      c_Chat_Msg.setIs_read(true);
      c_Chat_Msg.setRead_dt(read_dt_);
      session_.merge(c_Chat_Msg);
      c_chat_msg_recipient_list_ = C_Chat_Msg_Recipient_Manager.getCI().get_unread_row_list(session_, c_Chat_Msg.getC_chat_msg(), initiator_c_chat_cli_.getC_tbl(), initiator_c_chat_cli_.getRec_id());
      for (int k = 0; k < c_chat_msg_recipient_list_.size(); k++) {
        c_Chat_Msg_Recipient = c_chat_msg_recipient_list_.get(k);
        c_Chat_Msg_Recipient.setIs_read(true);
        c_Chat_Msg_Recipient.setRead_dt(read_dt_);
        session_.merge(c_Chat_Msg_Recipient);
      }
    }
    if (!c_chat_msg_list_.isEmpty()) {
      upd_unread_msg_cnt(session_, initiator_c_chat_cli_.getC_chat_cli());
    }
  }

}
