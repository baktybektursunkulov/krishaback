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
public class C_Chat_Manager extends Abstract_Controller_Manager<C_Chat> {

  private static C_Chat_Manager currentInstance = null;

  public static C_Chat_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Chat_Manager();
    }
    return currentInstance;
  }

  public C_Chat_Manager() {
    super(C_Chat.class);
  }

  public List<C_Chat> get_row_list(Session session_, Integer c_tbl_id_, Long rec_id_) {
    List<C_Chat> res;
    Query q_ = session_.createSQLQuery("select t.* from C_Chat t left join C_Chat_Msg cm on t.last_c_chat_msg=cm.c_chat_msg "
      + "where t.is_deleted=false and "
      + "((t.creator_c_tbl=:c_tbl_id_ and t.creator_rec_id=:rec_id_) "
      + "or exists (select 1 from C_Chat_Cli cc where cc.is_deleted=false and cc.c_chat=t.c_chat and cc.c_tbl=:c_tbl_id_ and cc.rec_id=:rec_id_)) "
      + "order by cm.sent_dt desc nulls last").addEntity(C_Chat.class);
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setLong("rec_id_", rec_id_);
    res = q_.list();

    return res;
  }

  public C_Chat get_row_for_indiv_chat(Session session_, Integer from_c_tbl_id_, Long from_rec_id_, Integer to_c_tbl_id_, Long to_rec_id_) {
    Query q_ = session_.createQuery("from C_Chat t where t.is_deleted=false and t.is_group_chat=false and "
      + "t.creator_c_tbl=:from_c_tbl_id_ "
      + "and t.creator_rec_id=:from_rec_id_ "
      + "and exists (select 1 from C_Chat_Cli cc where cc.is_deleted=false and cc.c_chat=t.c_chat and cc.c_tbl=:to_c_tbl_id_ and cc.rec_id=:to_rec_id_)) "
      + "order by 1 asc ");
    q_.setInteger("from_c_tbl_id_", from_c_tbl_id_);
    q_.setLong("from_rec_id_", from_rec_id_);
    q_.setInteger("to_c_tbl_id_", to_c_tbl_id_);
    q_.setLong("to_rec_id_", to_rec_id_);
    q_.setMaxResults(1);
    List<C_Chat> list_ = q_.list();

    if (list_.isEmpty()) {
      q_ = session_.createQuery("from C_Chat t where t.is_deleted=false and t.is_group_chat=false and "
        + "t.creator_c_tbl=:to_c_tbl_id_ "
        + "and t.creator_rec_id=:to_rec_id_ "
        + "and exists (select 1 from C_Chat_Cli cc where cc.is_deleted=false and cc.c_chat=t.c_chat and cc.c_tbl=:from_c_tbl_id_ and cc.rec_id=:from_rec_id_)) "
        + "order by 1 asc ");
      q_.setInteger("from_c_tbl_id_", from_c_tbl_id_);
      q_.setLong("from_rec_id_", from_rec_id_);
      q_.setInteger("to_c_tbl_id_", to_c_tbl_id_);
      q_.setLong("to_rec_id_", to_rec_id_);
      q_.setMaxResults(1);
      list_ = q_.list();
      if (list_.isEmpty()) {
        return null;
      } else {
        return list_.get(0);
      }
    } else {
      return list_.get(0);
    }
  }

  public C_Chat ins_row(Session session_, Integer creator_c_tbl_id_, Long creator_rec_id_, Boolean is_group_chat_, String name_for_group_chat_) {
    C_Chat res = new C_Chat();
    res.setCreator_c_tbl(creator_c_tbl_id_);
    res.setCreator_rec_id(creator_rec_id_);
    res.setIs_group_chat(is_group_chat_);
    res.setName_for_group_chat(name_for_group_chat_);
    res.setIns_dt(new Date());
    res.setIs_deleted(false);
    session_.save(res);
    return res;
  }

  public C_Chat ins_row_for_indiv_chat(Session session_, Integer creator_c_tbl_id_, Long creator_rec_id_) {
    return ins_row(session_, creator_c_tbl_id_, creator_rec_id_, false, "");
  }

  public C_Chat get_row_for_indiv_chat_or_ins(Session session_, Integer from_c_tbl_id_, Long from_rec_id_, Integer to_c_tbl_id_, Long to_rec_id_) {
    C_Chat res = get_row_for_indiv_chat(session_, from_c_tbl_id_, from_rec_id_, to_c_tbl_id_, to_rec_id_);
    if (res == null) {
      res = ins_row_for_indiv_chat(session_, from_c_tbl_id_, from_rec_id_);
      C_Chat_Cli_Manager.getCI().ins_row(session_, res.getC_chat(), from_c_tbl_id_, from_rec_id_, false);
      C_Chat_Cli_Manager.getCI().ins_row(session_, res.getC_chat(), to_c_tbl_id_, to_rec_id_, false);
    }
    return res;
  }
}
