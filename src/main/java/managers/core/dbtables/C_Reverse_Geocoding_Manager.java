package managers.core.dbtables;

import gs.common.google_reverse_geocode_funcs;
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
import static managers.core.dbtables.C_Reverse_Geocoding_Manager.getCI;
import model.core.dbutil.CoreSessionFactoryUtil;

@ManagedBean
@ApplicationScoped
public class C_Reverse_Geocoding_Manager extends Abstract_Controller_Manager<C_Reverse_Geocoding> {

  private static C_Reverse_Geocoding_Manager currentInstance = null;

  public static C_Reverse_Geocoding_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Reverse_Geocoding_Manager();
    }
    return currentInstance;
  }

  public C_Reverse_Geocoding_Manager() {
    super(C_Reverse_Geocoding.class);
  }

  public C_Reverse_Geocoding get_row(Double lat_, Double lon_, String lang_) {
    C_Reverse_Geocoding res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = get_row(session_, lat_, lon_, lang_);
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

  public C_Reverse_Geocoding get_row(Session session_, Double lat_, Double lon_, String lang_) {
    Query q_ = session_.createQuery("from C_Reverse_Geocoding t where t.is_deleted=false and t.lat=:lat_ and t.lon=:lon_ and t.lang=:lang_ order by 1 asc");
    q_.setDouble("lat_", lat_);
    q_.setDouble("lon_", lon_);
    q_.setString("lang_", lang_);
    List<C_Reverse_Geocoding> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public static String reverse_geocode(Double lat_, Double lon_, String lang_) {
    String res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = reverse_geocode(session_, lat_, lon_, lang_);
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

  public static String reverse_geocode(Session session_, Double lat_, Double lon_, String lang_) {
    String res;

    C_Reverse_Geocoding rec_ = getCI().get_row(session_, lat_, lon_, lang_);
    if (rec_ == null) {
      res = google_reverse_geocode_funcs.reverse_geocode(lat_, lon_, lang_);
      if (res != null) {
        rec_ = new C_Reverse_Geocoding();
        rec_.setLat(lat_);
        rec_.setLon(lon_);
        rec_.setLang(lang_);
        rec_.setResponse(res);
        rec_.setIs_deleted(false);
        session_.save(rec_);
      }
    } else {
      return rec_.getResponse();
    }

    return res;
  }
  
}
