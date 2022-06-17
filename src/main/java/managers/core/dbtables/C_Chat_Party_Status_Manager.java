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
public class C_Chat_Party_Status_Manager extends Abstract_Controller_Manager<C_Chat_Party_Status> {

  private static C_Chat_Party_Status_Manager currentInstance = null;

  public static C_Chat_Party_Status_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Chat_Party_Status_Manager();
    }
    return currentInstance;
  }

  public C_Chat_Party_Status_Manager() {
    super(C_Chat_Party_Status.class);
  }

  public C_Chat_Party_Status ins_row(Session session_, Integer c_tbl_id_, Long rec_id_, Date last_visit_dt_) {
    C_Chat_Party_Status res = new C_Chat_Party_Status();
    res.setC_tbl(c_tbl_id_);
    res.setRec_id(rec_id_);
    res.setLast_visit_dt(last_visit_dt_);
    res.setIs_deleted(false);
    session_.save(res);
    return res;
  }

  public C_Chat_Party_Status get_row(Session session_, Integer c_tbl_id_, Long rec_id_) {
    Query q_ = session_.createQuery("from C_Chat_Party_Status t where t.is_deleted=false and t.c_tbl=:c_tbl_id_ and t.rec_id=:rec_id_ ");
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setLong("rec_id_", rec_id_);
    List<C_Chat_Party_Status> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public C_Chat_Party_Status get_or_ins_row(Session session_, Integer c_tbl_id_, Long rec_id_) {
    C_Chat_Party_Status res = C_Chat_Party_Status_Manager.getCI().get_row(session_, c_tbl_id_, rec_id_);
    if (res == null) {
      ins_row(session_, c_tbl_id_, rec_id_, null);
    }
    return res;
  }
  
  public void set_last_visit_dt(Session session_, Integer c_tbl_id_, Long rec_id_, Date last_visit_dt_) {
    C_Chat_Party_Status res = C_Chat_Party_Status_Manager.getCI().get_row(session_, c_tbl_id_, rec_id_);
    if (res == null) {
      ins_row(session_, c_tbl_id_, rec_id_, last_visit_dt_);
    } else {
      res.setLast_visit_dt(last_visit_dt_);
      session_.merge(res);
    }
  }
}
