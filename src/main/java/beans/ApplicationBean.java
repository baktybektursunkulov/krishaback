package beans;

import gs.common.date_time_funcs;
import gs.common.locale_funcs;
import gs.common.jsf.jsf_funcs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import managers.core.dbtables.*;
import managers.core.dbtables.C_Lang_Manager;
import model.core.dbtables.*;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import gs.common.hibernate_funcs;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class ApplicationBean implements Serializable {

  List<C_Theme> c_theme_list;
  String current_version = null;
  public static ConcurrentHashMap<Integer, ConcurrentHashMap<String, String>> c_geocoding_service_obj_request_map = new ConcurrentHashMap();
  private C_Lang default_c_lang;
  private volatile List<C_Lang> supported_c_lang_list = new LinkedList<C_Lang>();
  private static ApplicationBean currentBean = null;
  private static ApplicationBean currentInstance = null;
  private List<String> days_of_month;
  private Map<String, C_Site> c_site_map_with_expiration = new HashMap();
  private Date c_site_map_with_expiration_last_sync_dt;
  private List<C_Proj> c_proj_list = new ArrayList();

  public static ApplicationBean getCurrentBean() {
    ApplicationBean applicationBean = jsf_funcs.findBean("applicationBean");
    if (applicationBean == null) {
      applicationBean = new ApplicationBean();
      FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("applicationBean", applicationBean);
    }
    return applicationBean;
  }

  public static ApplicationBean getCI() {
    if (currentInstance == null) {
      currentInstance = new ApplicationBean();
    }
    return currentInstance;
  }

  public List<C_Theme> getC_theme_list() {
    if (c_theme_list == null) {
      c_theme_list = C_Theme_Manager.getCI().get_rec_list_ordered_by_code_asc();
    }
    return c_theme_list;
  }

  public void setC_theme_list(List<C_Theme> c_theme_list) {
    this.c_theme_list = c_theme_list;
  }

  public String getCurrent_version() {
    //if (current_version == null) {
    current_version = CacheBean.getCacheBean().getCurrent_version();
    return current_version;
  }

  public void setCurrent_version(String current_version) {
    this.current_version = current_version;
  }

  public C_Lang getDefault_c_lang() {
    if (default_c_lang == null) {
      default_c_lang = C_Lang_Manager.getCI().get_rec(1);// Русский
    }
    return default_c_lang;
  }

  public void setDefault_c_lang(C_Lang default_c_lang) {
    this.default_c_lang = default_c_lang;
  }

  public List<C_Lang> getSupported_c_lang_list() {
    if (supported_c_lang_list.isEmpty()) {
      fill_supported_c_lang_list();
    }
    return supported_c_lang_list;
  }

  public void setSupported_c_lang_list(List<C_Lang> supported_c_lang_list) {
    this.supported_c_lang_list = supported_c_lang_list;
  }

  public List<C_Lang> getSupported_c_lang_list_2(Session session_) {
    if (supported_c_lang_list.isEmpty()) {
      fill_supported_c_lang_list(session_);
    }
    return supported_c_lang_list;
  }

  public synchronized void fill_supported_c_lang_list() {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      fill_supported_c_lang_list(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public synchronized void fill_supported_c_lang_list(Session session_) {
    if (!supported_c_lang_list.isEmpty()) {
      return;
    }
    //List<C_Lang> list_ = C_Lang_Manager.getCI().get_rec_list_2_1(session_, new SQL_Order_Condition("c_lang", "asc"));
    List<C_Lang> list_ = new ArrayList();
    C_Site c_site_ = C_Site_Manager.get_current_c_site(session_, (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(), true);
    if (c_site_ != null) {
      C_Proj c_proj_ = c_site_.getC_proj_t_2(session_);
      if (c_proj_ != null) {
        list_ = c_proj_.getProj_lang_list_2(session_);
      }
    }

    //List<C_Lang> list_ = new ArrayList();
    /*
    list_.add(new C_Lang(1, "ru", "Русский"));
    list_.add(new C_Lang(3, "en", "English"));
    list_.add(new C_Lang(4, "es", "Español"));
     */
    List<Locale> supported_locale_list_ = LocaleBean.getCurrentBean().getSupportedLocales();
    supported_locale_list_.add(FacesContext.getCurrentInstance().getApplication().getDefaultLocale());
    String lang_tag_;
    for (int i = 0; i < list_.size(); i++) {
      for (int j = 0; j < supported_locale_list_.size(); j++) {
        lang_tag_ = locale_funcs.getLanguageTag(supported_locale_list_.get(j));
        if (list_.get(i).getCode().equals(lang_tag_)) {
          //list_.get(i).setLocale(supported_locale_list_.get(j));
          if (!supported_c_lang_list.contains(list_.get(i))) {
            supported_c_lang_list.add(list_.get(i));
          }
          break;
        }
      }
    }
  }

  public List<String> getDays_of_month() {
    if (days_of_month == null) {
      refresh_days_of_month();
    }
    return days_of_month;
  }

  public void setDays_of_month(List<String> days_of_month) {
    this.days_of_month = days_of_month;
  }

  public void refresh_days_of_month() {
    days_of_month = new ArrayList<String>();
    for (int i = 1; i <= 31; i++) {
      days_of_month.add(String.valueOf(i));
    }
  }

  public Map<String, C_Site> getC_site_map_with_expiration() {
    if (c_site_map_with_expiration_last_sync_dt == null
      || date_time_funcs.add_minutes(c_site_map_with_expiration_last_sync_dt, 60).getTime() < (new Date()).getTime()) {
      refresh_c_site_map_with_expiration();
      c_site_map_with_expiration_last_sync_dt = new Date();
    }
    return c_site_map_with_expiration;
  }

  public void setC_site_map_with_expiration(Map<String, C_Site> c_site_map_with_expiration) {
    this.c_site_map_with_expiration = c_site_map_with_expiration;
  }

  public List<C_Proj> getC_proj_list() {
    return c_proj_list;
  }

  public void setC_proj_list(List<C_Proj> c_proj_list) {
    this.c_proj_list = c_proj_list;
  }

  public void refresh_c_site_map_with_expiration() {
    List<C_Site> c_Sites = C_Site_Manager.getCI().get_c_site_list();
    c_site_map_with_expiration.clear();
    for (C_Site c_Site : c_Sites) {
      c_site_map_with_expiration.put(c_Site.getDomain().toLowerCase(), c_Site);
    }
  }

  @PostConstruct
  public void perApplicationConstructor() {
    VariablesBean.getCI().setExternal_host_name(System.getProperty("core__external_host_name"));
    VariablesBean.getCI().setIs_send_email_on_error(Boolean.valueOf(System.getProperty("core__is_send_email_on_error")));
    VariablesBean.getCI().setIs_print_log_text(Boolean.valueOf(System.getProperty("core__is_print_log_text")));
    VariablesBean.getCI().setIs_print_error_text(Boolean.valueOf(System.getProperty("core__is_print_error_text")));
    VariablesBean.getCI().setIs_debug_mode(Boolean.valueOf(System.getProperty("core__is_debug_mode")));
    VariablesBean.getCI().setEmail_send_timeout_in_min(Integer.valueOf(System.getProperty("core__email_send_timeout_in_min")));
    VariablesBean.getCI().setSms_send_timeout_in_min(Integer.valueOf(System.getProperty("core__sms_send_timeout_in_min")));
////    ApplicationFactory af = (ApplicationFactory)FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
////    javax.faces.application.Application appl=af.getApplication();
////    appl.addBehavior("org.primefaces.component.AjaxBehavior", "org.primefaces.component.behavior.ajax.AjaxBehavior");    
////    CustomLogger.log("InitializationBean");
    //System.loadLibrary("poi-3.2-FINAL.jar");
  }

  @PreDestroy
  public void preDestroy() {
    //if (!VariablesBean.currentInstance.getIs_test_mode()) {
    // 
    CustomLogger.log("ApplicationBean.preDestroy");
    /*
    for (Object o : C3P0Registry.getPooledDataSources()) {
      try {
        ((PooledDataSource) o).close();
      } catch (Exception e) {
        // oh well, let tomcat do the complaing for us.
      }
    }
*/
    //if (!VariablesBean.getCI().getIs_test_mode()) {
    CoreSessionFactoryUtil.getInstance().close();
    //}
    //Hazelcast.shutdownAll();
    //}
  }

  public long getCurrentTimeMillis() {
    return System.currentTimeMillis();
  }

}
