package managers.core.dbtables;

import gs.common.date_time_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.Date;
import org.hibernate.Session;
import gs.common.model.db.*;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.math.BigInteger;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Limit_Log_Manager extends Abstract_Controller_Manager<C_Limit_Log> {

  private static C_Limit_Log_Manager currentInstance = null;

  public static C_Limit_Log_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Limit_Log_Manager();
    }
    return currentInstance;
  }

  public C_Limit_Log_Manager() {
    super(C_Limit_Log.class);
  }

  public void ins_unsucc_login_limit_log(String remote_ip_, String usr_name_, String usr_pwd_, C_Usr_Log_Service c_usr_log_service_) {
    C_Limit_Log c_Limit_Log = new C_Limit_Log();
    c_Limit_Log.setC_limit_t(C_Limit_Manager.getC_c_limit__unsucc_login());
    c_Limit_Log.setRemote_ip(remote_ip_);
    c_Limit_Log.setIns_dt(new Date());
    c_Limit_Log.setUsr_name(usr_name_);
    c_Limit_Log.setC_usr_log_service_t(c_usr_log_service_);
    c_Limit_Log.setIs_deleted(false);
    C_Limit_Log_Manager.getCI().insert_rec(c_Limit_Log);
  }

  public int get_rec_cnt(Session session_, Integer c_limit_id_, String remote_ip_, Date begin_dt_, Date end_dt_, Integer c_usr_log_service_id_) {
    int res;

    Query q_ = session_.createSQLQuery("select count(1) "
      + "FROM c_limit_log t "
      + "where "
      + "  t.is_deleted=false "
      + "  and t.c_limit=:c_limit_id_ "
      + "  and t.remote_ip=:remote_ip_ "
      + "  and t.ins_dt between :begin_dt_ and :end_dt_ "
      + "  and t.c_usr_log_service=:c_usr_log_service_id_ ");
    q_.setInteger("c_limit_id_", c_limit_id_);
    q_.setString("remote_ip_", remote_ip_);
    q_.setTimestamp("begin_dt_", begin_dt_);
    q_.setTimestamp("end_dt_", end_dt_);
    q_.setInteger("c_usr_log_service_id_", c_usr_log_service_id_);
    res = ((BigInteger) q_.list().get(0)).intValue();

    return res;
  }

  public boolean check_unsucc_login(Session session_, String remote_ip_, C_Usr_Log_Service c_usr_log_service_) {
    Date end_dt_ = new Date();
    C_Limit c_limit_ = C_Limit_Manager.getC_c_limit__unsucc_login(session_);
    Date bedin_dt_ = date_time_funcs.subtract_minutes(end_dt_, 1);
    int rec_cnt_ = get_rec_cnt(session_, c_limit_.getC_limit(), remote_ip_, bedin_dt_, end_dt_, c_usr_log_service_.getC_usr_log_service());
    if (rec_cnt_ > c_limit_.getCnt()) {
      return false;
    }
    return true;
  }

  public boolean check_unsucc_login(String remote_ip_, C_Usr_Log_Service c_usr_log_service_) {
    boolean res = false;
    Transaction tx_ = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      res = check_unsucc_login(session_, remote_ip_, c_usr_log_service_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
    }
    return res;
  }
}
