package beans;

import gs.common.Consts;
import gs.common.jsf.jsf_funcs;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Site_Manager;
import model.core.dbtables.C_Site;
import model.core.dbtables.C_Usr;
import others.CustomConsts;

@ManagedBean
@ApplicationScoped
public class VariablesBean implements Serializable {

  private int version = 186;
  //private String build_version = "123";
  static VariablesBean currentInstance;
  private Boolean is_send_email_on_error;
  private Boolean is_print_log_text;
  private Boolean is_print_error_text;
  private Boolean is_debug_mode;
  private Boolean is_debug_session;
  private String ws_url;
  private Boolean is_check_new_events;
  private Boolean is_test_mode;
  private String report_db_connection_url;
  private String report_db_connection_username;
  private String report_db_connection_password;
  private String report_db_connection_driver_class;
  private Integer email_send_timeout_in_min;
  private Integer sms_send_timeout_in_min;
  private String external_host_name;
  private String db_connection_url;
  private String db_connection_username;
  private String db_connection_password;
  private String db_connection_driver_class;
  private Boolean is_url_session_tracking_mode = null;

  public static VariablesBean getCI() {
    if (currentInstance == null) {
      currentInstance = new VariablesBean();
    }
    return currentInstance;
  }

  public void setCurrentInstance(VariablesBean currentInstance) {
    this.currentInstance = currentInstance;
  }

  public SimpleDateFormat getSdfddMMyyyy() {
    return new SimpleDateFormat(Consts.ddMMyyyy);
  }

  public String getBuild_version() {
    String res = String.valueOf(System.currentTimeMillis() / 1000 / 3600 / 24 + version);
    return res;
  }

  public Integer getRow_cnt_per_page() {
    return Integer.valueOf(System.getProperty("core__row_cnt_per_page"));
  }

  public java.util.TimeZone getLocalTimeZone() {
    return TimeZone.getDefault();
    //return "GMT+06:00";
  }

  public String getGoogle_maps_api_v3_key() {
    return CustomConsts.c_google_maps_api_v3_key;
  }

  public String getC_C_Usr_map_type_id() {
    return CustomConsts.c_c_usr_map_type_id;
  }

  public String getEmailValidationPattern() {
    return "[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";
  }

  // Допустимо использовать только латинские буквы, цифры, символы _ . @, длина должна быть от 4 до 30 символов.
  public String getLoginValidationPattern() {
    return "^[a-zA-Z0-9_.@]{4,30}$";
  }

  // Допустимо использовать только латинские буквы, цифры, символы ! @ $ ^ * ( ) - _ + = ; : , . / ? | ' ~, длина должна быть от 6 до 40 символов.
  // Знаки [ ] { } нельзя использовать в выражении regex
  public String getPasswordValidationPattern() {
    return "^[a-zA-Z0-9!@$^*()-_+=;:,./?|'~]{6,40}$";
  }

  // Допустимо использовать только латинские буквы, цифры, символы ! @ $ ^ * ( ) - _ + = ; : , . / ? | ' ~, длина должна быть от 1 до 40 символов.
  // Знаки [ ] { } нельзя использовать в выражении regex
  public String getObjectNamePattern() {
    return "^[a-zA-Z0-9!@$^*()-_+=;:,./?|'~]{1,80}$";
  }

  public Boolean getIs_send_email_on_error() {
    if (is_send_email_on_error == null) {
      if (FacesContext.getCurrentInstance() != null) {
        is_send_email_on_error = Boolean.valueOf(System.getProperty("core__is_send_email_on_error"));
      } else {
        is_send_email_on_error = true;
      }
    }
    return is_send_email_on_error;
  }

  public void setIs_send_email_on_error(Boolean is_send_email_on_error) {
    this.is_send_email_on_error = is_send_email_on_error;
  }

  public Boolean getIs_print_log_text() {
    if (is_print_log_text == null) {
      if (FacesContext.getCurrentInstance() != null) {
        is_print_log_text = Boolean.valueOf(System.getProperty("core__is_print_log_text"));
      } else {
        is_print_log_text = true;
      }
    }

    return is_print_log_text;
  }

  public void setIs_print_log_text(Boolean is_print_log_text) {
    this.is_print_log_text = is_print_log_text;
  }

  public Boolean getIs_print_error_text() {
    if (is_print_error_text == null) {
      if (FacesContext.getCurrentInstance() != null) {
        is_print_error_text = Boolean.valueOf(System.getProperty("core__is_print_error_text"));
      } else {
        is_print_error_text = true;
      }
    }
    return is_print_error_text;
  }

  public void setIs_print_error_text(Boolean is_print_error_text) {
    this.is_print_error_text = is_print_error_text;
  }

  public Boolean getIs_debug_mode() {
    if (is_debug_mode == null) {
      if (FacesContext.getCurrentInstance() != null) {
        is_debug_mode = Boolean.valueOf(System.getProperty("core__is_debug_mode"));
      } else {
        is_debug_mode = true;
      }
    }
    return is_debug_mode;
  }

  public void setIs_debug_mode(Boolean is_debug_mode) {
    this.is_debug_mode = is_debug_mode;
  }

  public Boolean getIs_debug_session() {
    if (is_debug_session == null) {
      if (FacesContext.getCurrentInstance() != null) {
        is_debug_session = Boolean.valueOf(System.getProperty("core__is_debug_session"));
        if (is_debug_session == null) {
          is_debug_session = false;
        }
      } else {
        is_debug_session = false;
      }
    }
    return is_debug_session;
  }

  public void setIs_debug_session(Boolean is_debug_session) {
    this.is_debug_session = is_debug_session;
  }

  public String getWs_url() {
    if (ws_url == null) {
      ws_url = System.getProperty("core__ws_url");
    }
    return ws_url;
  }

  public void setWs_url(String ws_url) {
    this.ws_url = ws_url;
  }

  public Boolean getIs_check_new_events() {
    if (is_check_new_events == null) {
      if (VariablesBean.getCI().getIs_test_mode()) {
        is_check_new_events = TestVariablesBean.getCI().getIs_check_new_messages();
        return is_check_new_events;
      }
      if (FacesContext.getCurrentInstance() != null) {
        is_check_new_events = Boolean.valueOf(System.getProperty("core__is_check_new_events"));
      } else {
        is_check_new_events = true;
      }
    }
    return is_check_new_events;
  }

  public void setIs_check_new_events(Boolean is_check_new_events) {
    this.is_check_new_events = is_check_new_events;
  }

  public Boolean getIs_test_mode() {
    if (is_test_mode == null) {
      if (FacesContext.getCurrentInstance() != null) {
        is_test_mode = Boolean.valueOf(System.getProperty("core__is_test_mode"));
      } else {
        if (System.getProperty("core__is_test_mode") != null) {
          is_test_mode = Boolean.valueOf(System.getProperty("core__is_test_mode"));
        } else {
          is_test_mode = true;
        }
      }
    }
    return is_test_mode;
  }

  public void setIs_test_mode(Boolean is_test_mode) {
    this.is_test_mode = is_test_mode;
  }

  public String getReport_db_connection_url() {
    if (report_db_connection_url == null) {
      report_db_connection_url = System.getProperty("core__report_db_connection_url");
    }
    return report_db_connection_url;
  }

  public void setReport_db_connection_url(String report_db_connection_url) {
    this.report_db_connection_url = report_db_connection_url;
  }

  public String getReport_db_connection_username() {
    if (report_db_connection_username == null) {
      report_db_connection_username = System.getProperty("core__report_db_connection_username");
    }
    return report_db_connection_username;
  }

  public void setReport_db_connection_username(String report_db_connection_username) {
    this.report_db_connection_username = report_db_connection_username;
  }

  public String getReport_db_connection_password() {
    if (report_db_connection_password == null) {
      report_db_connection_password = System.getProperty("core__report_db_connection_password");
    }
    return report_db_connection_password;
  }

  public void setReport_db_connection_password(String report_db_connection_password) {
    this.report_db_connection_password = report_db_connection_password;
  }

  public String getReport_db_connection_driver_class() {
    if (report_db_connection_driver_class == null) {
      report_db_connection_driver_class = System.getProperty("core__report_db_connection_driver_class");
    }
    return report_db_connection_driver_class;
  }

  public void setReport_db_connection_driver_class(String report_db_connection_driver_class) {
    this.report_db_connection_driver_class = report_db_connection_driver_class;
  }

  public Integer getEmail_send_timeout_in_min() {
    if (email_send_timeout_in_min == null) {
      if (FacesContext.getCurrentInstance() != null) {
        email_send_timeout_in_min = Integer.valueOf(System.getProperty("core__email_send_timeout_in_min"));
      } else {
        email_send_timeout_in_min = 0;
      }
    }
    return email_send_timeout_in_min;
  }

  public void setEmail_send_timeout_in_min(Integer email_send_timeout_in_min) {
    this.email_send_timeout_in_min = email_send_timeout_in_min;
  }

  public Integer getSms_send_timeout_in_min() {
    if (sms_send_timeout_in_min == null) {
      if (FacesContext.getCurrentInstance() != null) {
        sms_send_timeout_in_min = Integer.valueOf(System.getProperty("core__sms_send_timeout_in_min"));
      } else {
        sms_send_timeout_in_min = 0;
      }
    }
    return sms_send_timeout_in_min;
  }

  public void setSms_send_timeout_in_min(Integer sms_send_timeout_in_min) {
    this.sms_send_timeout_in_min = sms_send_timeout_in_min;
  }

  public String getExternal_host_name() {
    if (external_host_name == null) {
      external_host_name = System.getProperty("core__external_host_name");
    }
    return external_host_name;
  }

  public void setExternal_host_name(String external_host_name) {
    this.external_host_name = external_host_name;
  }

  public C_Site getSite() {
    C_Site res = C_Site_Manager.get_current_c_site();
    return res;
  }

  public String getSite_title() {
    String res = "";
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    return getSite_title_2(C_Site_);
  }

  public String getSite_title_2(C_Site C_Site_) {
    String res = "";
    res = C_Site_.getTitle();
    /*
    if (mainController.getMainControllerBean().getClient_mode() != null && mainController.getMainControllerBean().getClient_mode().equals("manager")) {
      res = res + " - Manager";
    }
    */
    return res;
  }

  public String getMobile_site_title() {
    String res = "";
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    res = C_Site_.getTitle() + " - Mobile";
    return res;
  }

  public String getSite_copyright_text() {
    String res = "";
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    res = C_Site_.getCopyright_text();
    return res;
  }

  public String getSite_copyright_text_2(C_Site C_Site_) {
    String res = "";
    res = C_Site_.getCopyright_text();
    return res;
  }

  public String getSite_copyright_url() {
    String res = "";
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    res = C_Site_.getCopyright_url();
    return res;
  }

  public C_Usr getSite_usr() {
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    return C_Site_.getC_usr_t();
  }

  public String getSite_usr_email() {
    String res = "";
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    res = C_Site_.getC_usr_t().getEmail();
    return res;
  }

  public String getSite_usr_email_2(C_Site C_Site_) {
    String res = "";
    res = C_Site_.getC_usr_t().getEmail();
    return res;
  }

  /*
  public String getLogo_url() {
    String res = "get_common_image?table=C_Site&field=favicon_img&cache=false&v=" + getBuild_version();

    int browser_type_ = jsf_funcs.getBrowserType();
    HttpServletRequest request = jsf_funcs.getRequest();
    String url_ = servlet_funcs.getAbsoluteURIWithoutPathInfo(request);
    if (browser_type_ == Consts.c_browser_type_chrome) {
      return url_ + "/" + res;
    }
    return res;
  }
   */
  public String getDb_connection_url() {
    if (db_connection_url == null) {
      db_connection_url = System.getProperty("core__hibernate.connection.url");
    }
    return db_connection_url;
  }

  public void setDb_connection_url(String db_connection_url) {
    this.db_connection_url = db_connection_url;
  }

  public String getDb_connection_username() {
    if (db_connection_username == null) {
      db_connection_username = System.getProperty("core__hibernate.connection.username");
    }
    return db_connection_username;
  }

  public void setDb_connection_username(String db_connection_username) {
    this.db_connection_username = db_connection_username;
  }

  public String getDb_connection_password() {
    if (db_connection_password == null) {
      db_connection_password = System.getProperty("core__hibernate.connection.password");
    }
    return db_connection_password;
  }

  public void setDb_connection_password(String db_connection_password) {
    this.db_connection_password = db_connection_password;
  }

  public String getDb_connection_driver_class() {
    if (db_connection_driver_class == null) {
      db_connection_driver_class = System.getProperty("core__hibernate.connection.driver_class");
    }
    return db_connection_driver_class;
  }

  public void setDb_connection_driver_class(String db_connection_driver_class) {
    this.db_connection_driver_class = db_connection_driver_class;
  }

  public Boolean getIs_url_session_tracking_mode() {
    //if (is_url_session_tracking_mode == null) {
    //ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    is_url_session_tracking_mode = jsf_funcs.getHttpServletRequest().getRequestURI().contains("jsessionid");
    //is_url_session_tracking_mode = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getEffectiveSessionTrackingModes().contains(SessionTrackingMode.URL);
    //}
    return is_url_session_tracking_mode;
  }

  public void setIs_url_session_tracking_mode(Boolean is_url_session_tracking_mode) {
    this.is_url_session_tracking_mode = is_url_session_tracking_mode;
  }

  public boolean getIs_secure_protocol() {
    return jsf_funcs.getHttpServletRequest().isSecure();
  }
}
