package managers.core.dbtables;

import gs.common.additional_classes.IP2LocationIPGeolocationResponse;
import gs.common.date_time_funcs;
import gs.common.google_geocode_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import gs.common.ip2location_ip_geolocation_funcs;
import java.util.*;
import java.text.*;
import static managers.core.dbtables.C_Ip2location_Manager.getCI;
import model.core.dbutil.CoreSessionFactoryUtil;

@ManagedBean
@ApplicationScoped
public class C_Ip2location_Manager extends Abstract_Controller_Manager<C_Ip2location> {

  private static C_Ip2location_Manager currentInstance = null;

  public static C_Ip2location_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Ip2location_Manager();
    }
    return currentInstance;
  }

  public C_Ip2location_Manager() {
    super(C_Ip2location.class);
  }

  public C_Ip2location get_row(String ip_) {
    C_Ip2location res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = get_row(session_, ip_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (session_.getTransaction() != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public C_Ip2location get_row(Session session_, String ip_) {
    Query q_ = session_.createQuery("from C_Ip2location t where t.is_deleted=false and t.ip=:ip_ and t.ins_dt>:ins_dt_ order by 1 asc");
    q_.setString("ip_", ip_);
    q_.setTimestamp("ins_dt_", date_time_funcs.subtract_month(new Date(), 1));
    q_.setMaxResults(1);
    List<C_Ip2location> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public static IP2LocationIPGeolocationResponse ip_geolocation(String ip_) {
    IP2LocationIPGeolocationResponse res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = ip_geolocation(session_, ip_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (session_.getTransaction() != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static IP2LocationIPGeolocationResponse ip_geolocation(Session session_, String ip_) {
    IP2LocationIPGeolocationResponse res;

    C_Ip2location rec_ = getCI().get_row(session_, ip_);
    if (rec_ == null) {
      res = ip2location_ip_geolocation_funcs.ip_geolocation(ip_);
      if (res != null) {
        rec_ = new C_Ip2location();
        rec_.setIp(ip_);
        rec_.setResponse_country_code(res.getCountry_code());
        rec_.setResponse_lat(res.getLat());
        rec_.setResponse_lon(res.getLon());
        rec_.setResponse_json(res.getResponse_json());
        rec_.setIns_dt(new Date());
        rec_.setIs_deleted(false);
        session_.save(rec_);
      }
    } else {
      return new IP2LocationIPGeolocationResponse(rec_.getResponse_country_code(), rec_.getResponse_lat(), rec_.getResponse_lon(),
        rec_.getResponse_json());
    }

    return res;
  }
  
}
