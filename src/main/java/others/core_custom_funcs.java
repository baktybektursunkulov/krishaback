package others;

import additional_classes.Content_Params;
import additional_classes.MyHttpServletRequest;
import beans.LocaleBean;
import beans.SessionBean;
import beans.VariablesBean;
import com.ocpsoft.pretty.PrettyContext;
import extras.I18NControl;
import gs.common.Consts;
import gs.common.date_time_funcs;
import gs.common.hibernate_funcs;
import gs.common.locale_funcs;
import gs.common.other_funcs;
import gs.common.servlet.servlet_funcs;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import managers.core.dbtables.C_Proj_Sender_Email_Manager;
import managers.core.dbtables.C_Site_Manager;
import managers.core.dbtables.C_Site_Page_Meta_Val_Manager;
import managers.core.dbtables.I_Html_Txt_Manager;
import managers.core.dbtables.C_Img_Converted_Manager;
import managers.core.dbtables.C_Img_Manager;
import managers.core.dbtables.C_Img_Type_Manager;
import model.core.dbtables.C_Email_Out;
import model.core.dbtables.C_Period_Type;
import model.core.dbtables.C_Proj;
import model.core.dbtables.C_Site;
import model.core.dbtables.C_Site_Meta;
import model.core.dbtables.C_Site_Page;
import model.core.dbtables.C_Usr;
import model.core.dbtables.I_Html_Txt;
import model.core.dbtables.C_Img;
import model.core.dbtables.C_Img_Converted;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jsoup.Jsoup;

@ManagedBean
@ApplicationScoped
public class core_custom_funcs {

  private Integer current_year;

  public Integer getCurrent_year() {
    if (current_year == null) {
      current_year = (new Date()).getYear() + 1900;
    }
    return current_year;
  }

  public void setCurrent_year(Integer current_year) {
    this.current_year = current_year;
  }

  public static String get_pretty_faces_full_current_url() {
    String url_ = PrettyContext.getCurrentInstance().getRequestURL().toURL() + PrettyContext.getCurrentInstance().getRequestQueryString();
    //String originalURI = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
    //System.err.println("originalURI=" + originalURI);    
    return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + url_;
  }

  public static void redirect_to_pretty_faces_full_current_url() {
    try {
      FacesContext.getCurrentInstance().getExternalContext().redirect(get_pretty_faces_full_current_url());
    } catch (Exception e) {
      CustomLogger.error(e);
    }
  }

  public static String IntListToStr(List<Integer> int_list_) {
    if (int_list_ == null) {
      return IntListToStr(new ArrayList<>());
    }
    return int_list_.toString();
  }

  public static String StrListToStr(List<String> str_list_) {
    if (str_list_ == null) {
      return StrListToStr(new ArrayList<>());
    }
    return str_list_.toString();
  }

  public static List<Integer> StrToIntList(String str_) {
    if (str_ == null || str_.trim().isEmpty() || str_.trim().length() < 2) {
      return new ArrayList();
    }
    String str_2_ = str_.trim().substring(1);
    str_2_ = str_2_.substring(0, str_2_.length() - 1);
    String[] str_2_arr_ = str_2_.split(", ");
    List<Integer> res = new ArrayList();
    for (int k = 0; k < str_2_arr_.length; k++) {
      if (!str_2_arr_[k].trim().isEmpty()) {
        res.add(Integer.valueOf(str_2_arr_[k]));
      }
    }
    return res;
  }

  public static List<String> StrToStrList(String str_) {
    if (str_ == null || str_.trim().isEmpty() || str_.trim().length() < 2) {
      return new ArrayList();
    }
    String str_2_ = str_.trim().substring(1);
    str_2_ = str_2_.substring(0, str_2_.length() - 1);
    String[] str_2_arr_ = str_2_.split(", ");
    List<String> res = new ArrayList();
    for (int k = 0; k < str_2_arr_.length; k++) {
      if (!str_2_arr_[k].trim().isEmpty()) {
        res.add(str_2_arr_[k]);
      }
    }
    return res;
  }

  public static String get_i_html_txt_filled_text_2(Session session_, Integer c_proj_id_, String code_, Content_Params content_params_) throws Exception {
    String res = "";
    I_Html_Txt i_html_txt_ = I_Html_Txt_Manager.getCI().get_suitable_row(session_, c_proj_id_, code_);
    //res = C_Site_Manager.getCI().getFilledTextForDocumentation(session_, RequestBean.getRequestBean().getC_site(), i_html_txt_.getTxt_translation_2(session_), LocaleBean.getCurrentBean().getLanguageTag());
    res = i_html_txt_.getTxt_translation_2(session_);
    res = get_filled_text(session_, res, content_params_);
    return res;
  }

  public static String get_filled_text(Session session_, String text_, Content_Params content_params_) {
    String res = "";
    if (text_ == null) {
      return "";
    }
    res = C_Site_Manager.getCI().getFilledTextForDocumentation(session_, content_params_.c_site, text_, content_params_.lang, "");

    return res;
  }

  public static String get_filled_meta_val_translation_2(Session session_, Integer c_site_id_, Integer c_site_page_id_, Integer c_site_meta_id_, Content_Params content_params_) throws Exception {
    String res = "";
    res = C_Site_Page_Meta_Val_Manager.getCI().get_c_site_page_meta_val_translation_2(session_, c_site_id_, c_site_page_id_, c_site_meta_id_, content_params_.lang);
    res = get_filled_text(session_, res, content_params_);
    return res;
  }

  /*
  public static String getSiteFaviconImgUrl(C_Site c_site_) {
      Integer img_ = C_Site_Manager.getCI().get_favicon_img_id(c_site_);
      return "img/" + img_ + "/" + Img_Manager.getCI().get_img_file_name(img_);
  }
   */
  public static String getSiteFaviconImgUrl(Session session_, C_Site c_site_) {
    Long img_ = C_Site_Manager.getCI().get_favicon_img_id(session_, c_site_);
    if (img_ == null) {
      return "";
    }
    return "img/" + img_ + "/" + C_Img_Manager.getCI().get_img_file_name(session_, img_);
  }

  public static String getSiteLogoImgUrl(Session session_, C_Site c_site_, int max_height_) throws Exception {
    C_Img img_ = C_Site_Manager.getCI().get_logo_img(c_site_);
    if (img_ == null) {
      return "";
    }
    int img_type_id_ = C_Img_Type_Manager.getPng_img_type(session_).getC_img_type();
    C_Img_Converted img_converted_ = C_Img_Converted_Manager.getCI().get_img_converted_by_height(session_, img_, img_type_id_, max_height_, true);
    return "converted_image/" + img_converted_.getC_img_converted() + "/logo.png";
  }

  public static String getSiteEntryLogoImgUrl(Session session_, C_Site c_site_) throws Exception {
    C_Img img_ = C_Site_Manager.getCI().get_entry_logo_img(c_site_);
    int img_type_id_ = C_Img_Type_Manager.getPng_img_type(session_).getC_img_type();
    C_Img_Converted img_converted_ = C_Img_Converted_Manager.getCI().get_img_converted(session_, img_, img_type_id_, 250, true);
    return "converted_image/" + img_converted_.getC_img_converted() + "/entry_logo.png";
  }

  public static ResourceBundle getResourceBundle(String languageTag_) {
    ResourceBundle rb_ = ResourceBundle.getBundle("bundle", locale_funcs.getLocale(languageTag_), new I18NControl());
    return rb_;
  }

  public static String getRequestURIWithoutAppName(FacesContext fc) {
    Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
    if (request instanceof HttpServletRequest) {
      return ((HttpServletRequest) request).getRequestURI().toString().replace("/ts", "");
    } else {
      return null;
    }

  }

  public static String getSessionId(FacesContext fc_) {
    HttpSession session_ = (HttpSession) fc_.getExternalContext().getSession(false);
    return (session_ == null ? "" : session_.getId());
  }

  public static String getRemovedSessionIdFromUrl(String url_) {
    String res;
    if (!url_.contains(";jsessionid=")) {
      return url_;
    } else {
      if (!url_.contains("?")) {
        res = url_.substring(0, url_.indexOf(";jsessionid="));
      } else {
        res = url_.substring(0, url_.indexOf(";jsessionid=")) + url_.substring(url_.indexOf("?"));
      }
    }
    return res;
  }

  public static String getViewExpiredURLForRedirect(FacesContext fc) {
    return getViewExpiredURLForRedirect((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest());
  }

  public static String getViewExpiredURLForRedirect(HttpServletRequest request_) {
    String url_ = request_.getRequestURL().toString();
    if (url_.contains("/admin/")) {
      return "error_view_expired.xhtml?v=" + VariablesBean.getCI().getBuild_version();
    } else if (url_.contains("/client/")) {
      return "error_view_expired.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else {
      return "error_view_expired.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    }
  }

  public static String getErrorURL(FacesContext fc) {
    String url_ = other_funcs.getRequestURL(fc);
    if (url_.contains("/admin/")) {
      return "/admin/error.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else if (url_.contains("/client/")) {
      return "/client/error.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else {
      return "error.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    }
  }

  public static String getErrorURLForRedirect(FacesContext fc) {
    String url_ = other_funcs.getRequestURL(fc);
    if (url_.contains("/admin/")) {
      return "error.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else if (url_.contains("/client/")) {
      return "error.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else {
      return "error.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    }
  }

  public static String getMainURL(FacesContext fc) {
    String url_ = other_funcs.getRequestURL(fc);
    if (url_.contains("/admin/")) {
      return "/admin/main_menu.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else if (url_.contains("/client/")) {
      return "/client/" + (SessionBean.getCurrentBean().getIsMobileBrowser() ? "mob_main.xhtml" : "main.xhtml") + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else {
      return "/error.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    }
  }

  public static Long get_page_cnt(Long rec_cnt_) {
    if ((rec_cnt_ % (VariablesBean.getCI().getRow_cnt_per_page())) == 0) {
      return (rec_cnt_ / VariablesBean.getCI().getRow_cnt_per_page());
    } else {
      return ((rec_cnt_ / VariablesBean.getCI().getRow_cnt_per_page()) + 1);
    }

  }

  public static java.util.Date convertToUTCDate(java.util.Date date_) {
    java.util.Date res = null;
    SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
    dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

    // Local time zone     
    SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

    try {
      //Time in GMT
      res = dateFormatLocal.parse(dateFormatGmt.format(new java.util.Date()));
    } catch (ParseException ex) {
      Logger.getLogger(core_custom_funcs.class.getName()).log(Level.SEVERE, null, ex);
    }
    return res;
  }

  public static String getListForPrint(List list_) {
    String res = "{";
    for (int i = 0; i < list_.size(); i++) {
      if (i == 0) {
        res = res + list_.get(i).toString();
      } else {
        res = res + "," + list_.get(i).toString();
      }
    }
    return res + "}";
  }

  public static HttpSession getSession(FacesContext facesContext) {
    return (HttpSession) facesContext.getExternalContext().getSession(false);
  }

  public static String html2text(String html) {
    return Jsoup.parse(html).text();
  }

  public static int get_hierarchical_c_usr_table_row_count(Session session_, String table_name_, String C_Usr_field_name_, Long c_usr_id_) {
    return get_hierarchical_c_usr_table_row_count(session_, table_name_, C_Usr_field_name_, c_usr_id_, "");
  }

  public static int get_hierarchical_c_usr_table_row_count(Session session_, String table_name_, String C_Usr_field_name_, Long c_usr_id_, String add_where_sql_) {
    int res = 0;
    if (c_usr_id_ == null) {
      return 0;
    }
    String sql_ = CustomConsts.hierarchical_C_Usr_sql_.replace(":C_Usr_id_", c_usr_id_.toString());
    String sql_2_ = "(t." + C_Usr_field_name_ + " = any(array((" + sql_ + "))))";
    Query q = session_.createSQLQuery("SELECT count(*) FROM " + table_name_ + " t where " + sql_2_
      + (table_name_.equals("C_Obj") || table_name_.equals("C_Usr") || table_name_.equals("C_Gz") || table_name_.equals("C_Poi") ? " and t.is_deleted=false " : "")
      + (add_where_sql_.isEmpty() ? "" : " and " + add_where_sql_));
    //q.setCacheable(true);
    res = ((BigInteger) q.list().get(0)).intValue();
    return res;

  }

  public static List get_hierarchical_c_usr_table_list(Session session_, String table_name_, String C_Usr_field_name_, Long c_usr_id_, Class entity_class_) {
    return get_hierarchical_c_usr_table_list(session_, table_name_, C_Usr_field_name_, c_usr_id_, entity_class_, "");
  }

  public static List get_hierarchical_c_usr_table_list(Session session_, String table_name_, String C_Usr_field_name_, Long c_usr_id_, Class entity_class_, String add_where_sql_) {
    List res = null;
    if (c_usr_id_ == null) {
      return null;
    }
    String sql_ = CustomConsts.hierarchical_C_Usr_sql_.replace(":C_Usr_id_", c_usr_id_.toString());
    String sql_2_ = "(t." + C_Usr_field_name_ + " = any(array((" + sql_ + "))))";
    Query q = session_.createSQLQuery("SELECT t.* FROM " + table_name_ + " t where " + sql_2_
      + (table_name_.equals("C_Obj") || table_name_.equals("C_Usr") || table_name_.equals("C_Gz") || table_name_.equals("C_Poi") ? " and t.is_deleted=false " : "")
      + (add_where_sql_.isEmpty() ? "" : " and " + add_where_sql_)).addEntity(entity_class_);
    //q.setCacheable(true);
    res = q.list();
    return res;

  }

  public static int get_hierarchical_c_usr_table_row_count_2(Session session_, String from_sql_, String where_sql_, String C_Usr_field_name_, Long c_usr_id_) {
    int res = 0;
    if (c_usr_id_ == null) {
      return 0;
    }
    String sql_ = CustomConsts.hierarchical_C_Usr_sql_.replace(":C_Usr_id_", c_usr_id_.toString());
    String sql_2_ = "(" + C_Usr_field_name_ + " = any(array((" + sql_ + "))))";
    Query q = session_.createSQLQuery("SELECT count(*) FROM " + from_sql_ + " where " + where_sql_ + " " + sql_2_);
    //q.setCacheable(true);
    res = ((BigInteger) q.list().get(0)).intValue();
    return res;

  }

  public static int get_hierarchical_c_usr_table_row_count_by_reset(Session session_, String table_name_, String C_Usr_field_name_, Long c_usr_id_, Integer reset_qty_, C_Period_Type reset_period_type_, String ins_dt_field_name_) {
    return get_hierarchical_c_usr_table_row_count_by_reset(session_, table_name_, C_Usr_field_name_, c_usr_id_, reset_qty_, reset_period_type_, ins_dt_field_name_, "");
  }

  public static int get_hierarchical_c_usr_table_row_count_by_reset(Session session_, String table_name_, String C_Usr_field_name_, Long c_usr_id_, Integer reset_qty_, C_Period_Type reset_period_type_, String ins_dt_field_name_, String add_where_sql_) {
    int res = 0;
    if (c_usr_id_ == null) {
      return 0;
    }
    String sql_ = CustomConsts.hierarchical_C_Usr_sql_.replace(":C_Usr_id_", c_usr_id_.toString());
    String sql_2_ = "(t." + C_Usr_field_name_ + " = any(array((" + sql_ + "))))";
    String reset_sql_ = "";
    if (reset_qty_ != null && reset_period_type_ != null) {
      Date now_ = new Date();
      Date new_date_;
      if (reset_period_type_.getCode().equals("day")) {
        new_date_ = date_time_funcs.subtract_day(now_, reset_qty_);
      } else if (reset_period_type_.getCode().equals("month")) {
        new_date_ = date_time_funcs.subtract_month(now_, reset_qty_);
      } else if (reset_period_type_.getCode().equals("year")) {
        new_date_ = date_time_funcs.subtract_year(now_, reset_qty_);
      } else {
        new_date_ = now_;
      }
      reset_sql_ = " and " + ins_dt_field_name_ + " >= to_timestamp('" + new SimpleDateFormat(Consts.ddMMyyyyHHmmss).format(new_date_) + "', 'dd.MM.yyyy HH24:MI:SS')";
    }
    Query q = session_.createSQLQuery("SELECT count(*) FROM " + table_name_ + " t where " + sql_2_ + reset_sql_
      + (table_name_.equals("C_Obj") || table_name_.equals("C_Usr") || table_name_.equals("C_Gz") || table_name_.equals("C_Poi") ? " and t.is_deleted=false " : ""));
    //q.setCacheable(true);
    res = ((BigInteger) q.list().get(0)).intValue();
    return res;

  }

  /*
  public static String send_email_from_current_site(String to_, String cc_, String bcc_, String subject_, String body_) {
    return send_email_with_attachments_from_current_site(to_, cc_, bcc_, subject_, body_, null);
  }

  public static String send_email_with_attachments_from_current_site(String to_, String cc_, String bcc_, String subject_, String body_,
    Vector<Email_Attachment_Rec> attachments_) {
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    C_Usr C_Usr_ = C_Usr_Manager.get_dealer_usr_with_own_support_service(C_Site_.getC_Usr());
    return send_email_with_attachments(C_Usr_, to_, cc_, bcc_, subject_, body_, attachments_);
  }

  public static String send_email_with_attachments(C_Usr sender_dealer_usr_with_own_support_service_, String to_, String cc_, String bcc_, String subject_, String body_) {
    return send_email_with_attachments(sender_dealer_usr_with_own_support_service_, to_, cc_, bcc_, subject_, body_, null);
  }

  public static String send_email_with_attachments(C_Usr sender_dealer_usr_with_own_support_service_, String to_, String cc_, String bcc_, String subject_, String body_,
    Vector<Email_Attachment_Rec> attachments_) {
    C_Usr C_Usr_ = sender_dealer_usr_with_own_support_service_;
    String email_send_res_ = email.funcs.send_email_with_attachments(C_Smtp_Security_Manager.get_smtp_security_model(C_Usr_.getC_smtp_security()),
      C_Usr_.getSmtp_server_port(), C_Usr_.getSmtp_server(), C_Usr_.getIs_smtp_authorize(), C_Usr_.getSmtp_login(), C_Usr_.getSmtp_pswd(),
      C_Usr_.getSender_name(), C_Usr_.getSender_email(), to_, cc_, bcc_, subject_,
      body_, false, false, attachments_);
    return email_send_res_;
  }
   */
  public static String getAbsoluteContextPath(MyHttpServletRequest request) {
    return servlet_funcs.getAbsoluteContextPath(request.getServerPort(), request.getServerName(), request.getContextPath(), request.getScheme());
  }

  /**
   * Calculates the angle from one coords to another coords (lon, lat)
   */
  public static double getAngle(double x1, double y1, double x2, double y2) {
    double theta = Math.atan2(y2 - y1, x2 - x1);
    theta = Math.PI / 2.0 - theta;
    double angle = Math.toDegrees(theta);
    //angle = angle + Math.ceil(-angle / 360) * 360;    
    if (angle < 0) {
      angle += 360;
    }
    return angle;
  }

  public static java.sql.Time get_time(Date dt_) {
    return new java.sql.Time(dt_.getHours(), dt_.getMinutes(), dt_.getSeconds());
  }

  public static String get_filled_text_for_signup_verif_code(String s_, C_Site c_site_, String email_, String verif_code_) {
    String res;
    res = get_standart_filled_text(s_, c_site_);
    res = res.replace("%email%", email_);
    res = res.replace("％email％", email_);
    res = res.replace("%verif_code%", verif_code_);
    res = res.replace("％verif_code％", verif_code_);
    return res;
  }

  public static String get_filled_text_for_usr_register_and_restore_password(String s_, C_Site c_site_, String c_usr_name_, String url_, String exp_dt_) {
    String res;
    res = get_standart_filled_text(s_, c_site_);
    res = res.replace("%usr_name%", c_usr_name_);
    res = res.replace("％usr_name％", c_usr_name_);
    res = res.replace("%url%", url_);
    res = res.replace("％url％", url_);
    if (exp_dt_ != null) {
      res = res.replace("%exp_dt%", exp_dt_);
      res = res.replace("％exp_dt％", exp_dt_);
    }
    return res;
  }

  public static String get_standart_filled_text(String s_, C_Site c_site_) {
    String res = s_;
    res = res.replace("%domain%", c_site_.getDomain());
    res = res.replace("％domain％", c_site_.getDomain());
    res = res.replace("gv_domain", c_site_.getDomain());

    res = res.replace("%system_name%", c_site_.getTitle());
    res = res.replace("gv_system_name", c_site_.getTitle());
    res = res.replace("％system_name％", c_site_.getTitle());

    res = res.replace("gv_site_title", c_site_.getTitle());
    //res = res.replace("%usr_name%", c_usr_name_);
    //res = res.replace("％usr_name％", c_usr_name_);
    //res = res.replace("%url%", url_);
    //res = res.replace("％url％", url_);
    return res;
  }

  public static C_Email_Out send_email_after_usr_register(Session session_, C_Proj c_proj_, C_Site c_site_, C_Usr c_usr_, String message_subject_template_, String message_body_template_, String url_) throws Exception {
    String message_subject_ = message_subject_template_;
    String message_body_ = message_body_template_;
    message_subject_ = get_filled_text_for_usr_register_and_restore_password(message_subject_, c_site_, c_usr_.getName(), url_, null);
    message_body_ = get_filled_text_for_usr_register_and_restore_password(message_body_, c_site_, c_usr_.getName(), url_, null);
    String bcc_ = "";
    if (!c_usr_.getEmail().equals(c_proj_.getAdmin_email())) {
      bcc_ = c_proj_.getAdmin_email();
    }
    C_Email_Out res = C_Proj_Sender_Email_Manager.getCI().ins_email_with_immediate_send(session_, c_proj_.getC_proj(), c_usr_.getEmail(), "", bcc_,
      message_subject_, message_body_, false, LocaleBean.getCurrentBean().getLanguageTag());
    return res;
  }

  public static C_Email_Out send_email_for_signup_verif_code(Session session_, C_Proj c_proj_, C_Site c_site_, String email_, String message_subject_template_, String message_body_template_, String verif_code_, String lang_)
    throws Exception {
    String message_subject_ = message_subject_template_;
    String message_body_ = message_body_template_;
    message_subject_ = get_filled_text_for_signup_verif_code(message_subject_, c_site_, email_, verif_code_);
    message_body_ = get_filled_text_for_signup_verif_code(message_body_, c_site_, email_, verif_code_);
    String bcc_ = "";
    if (!email_.equals(c_proj_.getAdmin_email())) {
      bcc_ = c_proj_.getAdmin_email();
    }
    C_Email_Out c_Email_Out = C_Proj_Sender_Email_Manager.getCI().ins_email_with_immediate_send(session_, c_proj_.getC_proj(), email_, "", bcc_,
      message_subject_, message_body_, false, lang_);
    return c_Email_Out;
  }

  public static C_Email_Out send_email_after_restore_password(Session session_, C_Proj c_proj_, C_Site c_site_, String usr_name_, String email_, String message_subject_template_, String message_body_template_, String url_, String exp_dt_) throws Exception {
    String message_subject_ = message_subject_template_;
    String message_body_ = message_body_template_;
    message_subject_ = get_filled_text_for_usr_register_and_restore_password(message_subject_, c_site_, usr_name_, url_, exp_dt_);
    message_body_ = get_filled_text_for_usr_register_and_restore_password(message_body_, c_site_, usr_name_, url_, exp_dt_);
    String bcc_ = "";
    if (!email_.equals(c_proj_.getAdmin_email())) {
      bcc_ = c_proj_.getAdmin_email();
    }
    C_Email_Out c_Email_Out = C_Proj_Sender_Email_Manager.getCI().ins_email_with_immediate_send(session_, c_proj_.getC_proj(), email_, "", bcc_,
      message_subject_, message_body_, false, LocaleBean.getCurrentBean().getLanguageTag());
    return c_Email_Out;
  }

  public static C_Email_Out send_email(C_Proj c_proj_, String email_, String message_subject_, String message_body_, String bcc_, boolean in_html_format_, String lang_, Boolean is_immediate_send_) throws Exception {
    C_Email_Out res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = send_email(session_, c_proj_, email_, message_subject_, message_body_, bcc_, in_html_format_, lang_, is_immediate_send_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public static C_Email_Out send_email(Session session_, C_Proj c_proj_, String email_, String message_subject_, String message_body_, String bcc_, boolean in_html_format_, String lang_, Boolean is_immediate_send_) throws Exception {
    //String bcc_ = "";
    if (bcc_ == null || bcc_.trim().isEmpty()) {
      if (!email_.equals(c_proj_.getAdmin_email())) {
        bcc_ = c_proj_.getAdmin_email();
      }
    }
    C_Email_Out res = C_Proj_Sender_Email_Manager.getCI().ins_email(session_, c_proj_.getC_proj(), email_, "", bcc_,
      message_subject_, message_body_, in_html_format_, lang_, is_immediate_send_);
    return res;
  }

}
