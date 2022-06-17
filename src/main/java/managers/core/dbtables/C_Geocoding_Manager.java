package managers.core.dbtables;

import gs.common.additional_classes.GoogleGeocodeResult;
import gs.common.google_geocode_funcs;
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
import static managers.core.dbtables.C_Geocoding_Manager.getCI;
import model.core.dbutil.CoreSessionFactoryUtil;

@ManagedBean
@ApplicationScoped
public class C_Geocoding_Manager extends Abstract_Controller_Manager<C_Geocoding> {

  private static C_Geocoding_Manager currentInstance = null;

  public static C_Geocoding_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Geocoding_Manager();
    }
    return currentInstance;
  }

  public C_Geocoding_Manager() {
    super(C_Geocoding.class);
  }

  public C_Geocoding get_row(String address_) {
    C_Geocoding res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = get_row(session_, address_);
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

  public C_Geocoding get_row(Session session_, String address_) {
    Query q_ = session_.createQuery("from C_Geocoding t where t.is_deleted=false and t.address=:address_ order by 1 asc");
    q_.setString("address_", address_);
    List<C_Geocoding> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public static GoogleGeocodeResult geocode(String address_) {
    GoogleGeocodeResult res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = geocode(session_, address_);
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

  public static GoogleGeocodeResult geocode(Session session_, String address_) {
    GoogleGeocodeResult res;

    C_Geocoding rec_ = getCI().get_row(session_, address_);
    if (rec_ == null) {
      res = google_geocode_funcs.geocode(address_);
      if (res != null) {
        rec_ = new C_Geocoding();
        rec_.setAddress(address_);
        rec_.setResponse_lat(res.getResponse_lat());
        rec_.setResponse_lon(res.getResponse_lon());
        rec_.setResponse_view_ne_lat(res.getResponse_view_ne_lat());
        rec_.setResponse_view_ne_lon(res.getResponse_view_ne_lon());
        rec_.setResponse_view_sw_lat(res.getResponse_view_sw_lat());
        rec_.setResponse_view_sw_lon(res.getResponse_view_sw_lon());
        rec_.setIs_deleted(false);
        rec_.setResponse_json(res.getResponse_json());
        session_.save(rec_);
      }
    } else {
      return new GoogleGeocodeResult(rec_.getResponse_lat(), rec_.getResponse_lon(),
        rec_.getResponse_view_ne_lat(), rec_.getResponse_view_ne_lon(), rec_.getResponse_view_sw_lat(), rec_.getResponse_view_sw_lon(), rec_.getResponse_json());
    }

    return res;
  }

}
