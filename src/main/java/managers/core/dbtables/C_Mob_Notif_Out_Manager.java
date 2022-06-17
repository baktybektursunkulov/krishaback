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
public class C_Mob_Notif_Out_Manager extends Abstract_Controller_Manager<C_Mob_Notif_Out> {

  private static C_Mob_Notif_Out_Manager currentInstance = null;

  public static C_Mob_Notif_Out_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Mob_Notif_Out_Manager();
    }
    return currentInstance;
  }

  public C_Mob_Notif_Out_Manager() {
    super(C_Mob_Notif_Out.class);
  }

  public void ins_c_mob_notif_out(Session session_, C_Usr c_usr_, String title_, String txt_) {
    C_Mob_Notif_Out c_Mob_Notif_Out = new C_Mob_Notif_Out();
    c_Mob_Notif_Out.setC_usr_t(c_usr_);
    c_Mob_Notif_Out.setTitle(title_);
    c_Mob_Notif_Out.setTxt(txt_);
    c_Mob_Notif_Out.setIns_dt(new Date());
    c_Mob_Notif_Out.setIs_sent(false);
    c_Mob_Notif_Out.setSent_dt(null);
    c_Mob_Notif_Out.setSent_err_msg(null);
    session_.save(c_Mob_Notif_Out);
  }

  public List<C_Mob_Notif_Out> get_unsent_list(Session session_) {
    return get_rec_list_5_1_c(session_, new SQL_Where_Condition("is_sent=false"), new SQL_Order_Condition("c_mob_notif_out", "asc"), false);
  }

  public List<C_Mob_Notif_Out> get_last_rec_list_for_monitor(Session session_, C_Usr c_usr_, Integer last_c_mob_notif_out_id_, Integer count_) {
    Query q_ = session_.createQuery("from C_Mob_Notif_Out where c_usr.c_usr=:c_usr_id_ and is_sent=true and c_mob_notif_out>:last_c_mob_notif_out_id_ order by sent_dt desc");
    q_.setLong("c_usr_id_", c_usr_.getC_usr());
    q_.setInteger("last_c_mob_notif_out_id_", last_c_mob_notif_out_id_);
    if (count_ != null) {
      q_.setMaxResults(count_);
    }
  //q_.setCacheable(use_query_cache);
    return q_.list();
  }

  public Integer get_max_id(Session session_, C_Usr c_usr_) {
    Query q_ = session_.createQuery("select coalesce(max(c_mob_notif_out), 0) from C_Mob_Notif_Out where c_usr.c_usr=:c_usr_id_ and is_sent=true");
    q_.setLong("c_usr_id_", c_usr_.getC_usr());
  //q_.setCacheable(use_query_cache);
    List list_ = q_.list();
    if (list_.size() > 0) {
      return (Integer) list_.get(0);
    }
    return 0;
  }

  public List<C_Mob_Notif_Out> get_rec_list(Session session_, C_Usr c_usr_, Date begin_dt_, Date end_dt_) {
    Query q_ = session_.createQuery("from C_Mob_Notif_Out where sent_dt between :begin_dt_ and :end_dt_ and is_sent=true order by sent_dt asc");
    q_.setTimestamp("begin_dt_", C_Usr_Manager.getCI().getUsrTimeToGMT0600TZ(c_usr_, begin_dt_));
    q_.setTimestamp("end_dt_", C_Usr_Manager.getCI().getUsrTimeToGMT0600TZ(c_usr_, end_dt_));
  //q_.setCacheable(use_query_cache);
    return q_.list();
  }  
}
