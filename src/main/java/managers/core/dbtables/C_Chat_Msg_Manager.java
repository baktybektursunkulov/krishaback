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
import org.hibernate.type.StandardBasicTypes;

@ManagedBean
@ApplicationScoped
public class C_Chat_Msg_Manager extends Abstract_Controller_Manager<C_Chat_Msg> {

  private static C_Chat_Msg_Manager currentInstance = null;

  public static C_Chat_Msg_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Chat_Msg_Manager();
    }
    return currentInstance;
  }

  public C_Chat_Msg_Manager() {
    super(C_Chat_Msg.class);
  }

  public C_Chat_Msg ins_row(Session session_, Integer c_chat_id_, Integer c_chat_msg_type_id_,
    Integer sender_c_tbl_id_, Long sender_rec_id_, Integer to_c_tbl_id_, Long to_rec_id_, String msg_txt_, Long reply_id_, Date dt_) {
    C_Chat_Msg res = new C_Chat_Msg();
    res.setC_chat(c_chat_id_);
    res.setC_chat_msg_type(c_chat_msg_type_id_);
    res.setSender_c_tbl(sender_c_tbl_id_);
    res.setSender_rec_id(sender_rec_id_);
    res.setMsg_txt(msg_txt_);
    //Date now_ = new Date();
    res.setIs_delivered(true);
    res.setDeliver_dt(dt_);
    res.setIs_read(false);
    res.setRead_dt(null);
    res.setReply_id(reply_id_);
    res.setIns_dt(dt_);
    res.setIs_deleted(false);
    res.setIs_sent(true);
    res.setSent_dt(dt_);
    session_.save(res);

    C_Chat_Msg_Recipient_Manager.getCI().ins_row(session_, res.getC_chat_msg(), to_c_tbl_id_, to_rec_id_, dt_);

    return res;
  }

  public List<C_Chat_Msg> get_unread_row_list(Session session_, Integer c_chat_id_, Integer sender_c_tbl_id_, Long sender_rec_id_) {
    Query q_ = session_.createQuery("from C_Chat_Msg t "
      + "where "
      + "  t.is_deleted=false and t.c_chat=:c_chat_id_ and t.is_read=false "
      + "  and t.sender_c_tbl=:sender_c_tbl_id_ "
      + "  and t.sender_rec_id=:sender_rec_id_  "
      + "order by t.ins_dt asc");
    q_.setInteger("c_chat_id_", c_chat_id_);
    q_.setInteger("sender_c_tbl_id_", sender_c_tbl_id_);
    q_.setLong("sender_rec_id_", sender_rec_id_);
    return q_.list();
  }

  public List<C_Chat_Msg> get_row_list_for_monitoring(Session session_, Integer c_tbl_id_, Long rec_id_, Long last_c_chat_msg_id_, Integer row_cnt_) {
    Query q_ = session_.createQuery("select t from C_Chat_Msg t, C_Chat c "
      + "where "
      + "  t.is_deleted=false and t.c_chat=c.c_chat and c.is_deleted=false "
      + (last_c_chat_msg_id_ == null ? "" : "  and t.c_chat_msg>:last_c_chat_msg_id_ ")
      + "  and exists ("
      + "    select 1 from C_Chat_Cli cc where cc.is_deleted=false and cc.c_chat=c.c_chat and cc.c_tbl=:c_tbl_id_ and cc.rec_id=:rec_id_ "
      + "  ) "
      + "order by t.c_chat_msg asc");
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setLong("rec_id_", rec_id_);
    if (last_c_chat_msg_id_ != null) {
      q_.setLong("last_c_chat_msg_id_", last_c_chat_msg_id_);
    }
    if (row_cnt_ != null) {
      q_.setMaxResults(row_cnt_);
    }
    return q_.list();
  }

}
