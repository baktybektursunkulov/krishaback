package beans;

import gs.common.Consts;
import gs.common.UAgentInfo;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.servlet.AttributeTools;
import gs.common.servlet.servlet_funcs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import managers.core.dbtables.C_Month_Manager;
import managers.core.dbtables.C_Site_Manager;
import managers.core.dbtables.C_Usr_Manager;
import managers.core.dbtables.C_Usr_Status_Manager;
import model.core.dbtables.C_Month;
import model.core.dbtables.C_Img;
import model.core.dbtables.C_Site;
import model.core.dbtables.C_Tz;
import model.core.dbtables.C_Usr;
import model.core.dbtables.C_Usr_Status;
import org.hibernate.Session;import gs.common.hibernate_funcs;
import managers.core.dbtables.C_Site_Img_Manager;
import managers.core.dbtables.C_Site_Img_Type_Manager;
import managers.core.dbtables.C_Tz_Manager;
import managers.core.dbtables.C_Img_Manager;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

  String c_site_logo_img_url = "get_common_image?table=C_Site&field=logo_img&cache=false";
  String c_site_entry_logo_img_url = "get_common_image?table=C_Site&field=entry_logo_img&cache=false";
  String c_site_favicon_img_url = "get_common_image?table=C_Site&field=favicon_img&cache=false";
  C_Site current_c_site;
  private static SessionBean currentBean = null;
  private Boolean isNativeAndroidBrowser = null;
  private Boolean isMobileBrowser = null;
  private List<C_Usr> creator_usr_list = null;

  private List<String> months;
  private List<String> days_of_month;
  private List<String> weeks;
  private List<String> days_of_week;

  List<C_Month> c_month_list;
  List<C_Tz> c_tz_list;

  public static SessionBean getCurrentBean() {
    SessionBean bean_ = jsf_funcs.findBean("sessionBean");
    if (bean_ == null) {
      bean_ = new SessionBean();
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionBean", bean_);
    }
    return bean_;
  }

  public static SessionBean getCurrentBean(HttpServletRequest request_) {
    SessionBean res = null;
    Object obj_ = AttributeTools.getSessionAttribute(request_, "sessionBean", null);
    if (obj_ == null) {
      res = new SessionBean();
      AttributeTools.setSessionAttribute(request_, "sessionBean", res);
    } else {
      res = (SessionBean) obj_;
    }
    return res;
  }

  public String getC_site_logo_img_url() {
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    //Img img_ = C_Site_.getLogo_img();
    //return "get_img?img_id=" + img_.getImg() + "&v=" + img_.getVersion();
    C_Img img_ = C_Site_Img_Manager.getCI().get_c_site_img(C_Site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__logo).getImg_t();
    return "get_img_converted_by_height?img_id=" + img_.getC_img() + "&img_type_code=png&img_height=32&v=" + img_.getVersion();
    //return C_Site_logo_img_url;
  }

  public void setC_Site_logo_img_url(String c_site_logo_img_url) {
    this.c_site_logo_img_url = c_site_logo_img_url;
  }

  public String getC_site_entry_logo_img_url() {
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    //Img img_ = C_Site_.getEntry_logo_img();
    //return "get_img?img_id=" + img_.getImg() + "&v=" + img_.getVersion();
    C_Img img_ = C_Site_Img_Manager.getCI().get_c_site_img(C_Site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__entry_logo).getImg_t();
    return "get_img_converted_by_width?img_id=" + img_.getC_img() + "&img_type_code=png&img_width=250&v=" + img_.getVersion();
    //return C_Site_entry_logo_img_url;
  }

  public String getC_site_entry_logo_img_url_by_height(Long img_height_) {
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    //Img img_ = C_Site_.getEntry_logo_img();
    //return "get_img?img_id=" + img_.getImg() + "&v=" + img_.getVersion();
    C_Img img_ = C_Site_Img_Manager.getCI().get_c_site_img(C_Site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__entry_logo).getImg_t();
    return "get_img_converted_by_height?img_id=" + img_.getC_img() + "&img_type_code=png&img_height=" + img_height_ + "&v=" + img_.getVersion();
    //return C_Site_entry_logo_img_url;
  }
  
  public String getC_site_entry_logo_img_url_by_height_2(C_Site C_Site_, Long img_height_) {
    //Img img_ = C_Site_.getEntry_logo_img();
    //return "get_img?img_id=" + img_.getImg() + "&v=" + img_.getVersion();
    C_Img img_ = C_Site_Img_Manager.getCI().get_c_site_img(C_Site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__entry_logo).getImg_t();
    return "get_img_converted_by_height?img_id=" + img_.getC_img() + "&img_type_code=png&img_height=" + img_height_ + "&v=" + img_.getVersion();
    //return C_Site_entry_logo_img_url;
  }
  
  public String getC_site_doc_logo_img_url() {
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    //Img img_ = C_Site_.getEntry_logo_img();
    //return "get_img?img_id=" + img_.getImg() + "&v=" + img_.getVersion();
    C_Img img_ = C_Site_Img_Manager.getCI().get_c_site_img(C_Site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__entry_logo).getImg_t();
    return "get_img_converted_by_height?img_id=" + img_.getC_img() + "&img_type_code=png&img_height=50&v=" + img_.getVersion();
    //return C_Site_entry_logo_img_url;
  }

  public void setC_Site_entry_logo_img_url(String c_site_entry_logo_img_url) {
    this.c_site_entry_logo_img_url = c_site_entry_logo_img_url;
  }

  public String getC_site_favicon_img_url() {
    //String res;
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    return getC_site_favicon_img_url_2(C_Site_);
  }

  public String getC_site_favicon_img_url_2(C_Site C_Site_) {
    String res;
    //Img img_ = C_Site_.getFavicon_img();
    C_Img img_ = C_Site_Img_Manager.getCI().get_c_site_img(C_Site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__favicon).getImg_t();
    res = "get_img?img_id=" + img_.getC_img()  + "&v=" + img_.getVersion();
    //res = "get_img_converted_by_height?img_id=" + img_.getImg() + "&img_type_code=png&img_height=32&v=" + img_.getVersion();
    //int browser_type_ = jsf_funcs.getBrowserType();
    //HttpServletRequest request = jsf_funcs.getRequest();
    //String url_ = servlet_funcs.getAbsoluteURIWithoutPathInfo(request);
    //if (browser_type_ == Consts.c_browser_type_chrome) {
    //  return url_ + "/" + res;
    //}
    return res;
    //return C_Site_favicon_img_url;
  }
  
  public void setC_Site_favicon_img_url(String c_site_favicon_img_url) {
    this.c_site_favicon_img_url = c_site_favicon_img_url;
  }

   
  public C_Site getCurrent_c_site() {
    if (current_c_site == null) {
      current_c_site = C_Site_Manager.get_current_c_site();
    }
    return current_c_site;
  }

  public void setCurrent_c_site(C_Site current_c_site) {
    this.current_c_site = current_c_site;
  }

  public boolean getIsNativeAndroidBrowser() {
    if (isNativeAndroidBrowser == null) {
      isNativeAndroidBrowser = jsf_funcs.getIsNativeAndroidBrowser();
    }
    return isNativeAndroidBrowser;
  }

  public void setIsNativeAndroidBrowser(boolean isNativeAndroidBrowser) {
    this.isNativeAndroidBrowser = isNativeAndroidBrowser;
  }

  public Boolean getIsMobileBrowser() {
    if (isMobileBrowser == null) {
      isMobileBrowser = jsf_funcs.getIsMobileBrowser();
    }
    return isMobileBrowser;
  }

  public void setIsMobileBrowser(Boolean isMobileBrowser) {
    this.isMobileBrowser = isMobileBrowser;
  }

  public List<C_Usr> getCreator_usr_list(C_Usr logged_c_usr_) {
    if (creator_usr_list == null) {
      refresh_creator_usr_list(logged_c_usr_);
    }
    return creator_usr_list;
  }

  public void setCreator_usr_list(List<C_Usr> creator_usr_list) {
    this.creator_usr_list = creator_usr_list;
  }

  public List<String> getMonths() {
    if (months == null) {
      refresh_months();
    }
    return months;
  }

  public void setMonths(List<String> months) {
    this.months = months;
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

  public List<String> getWeeks() {
    if (weeks == null) {
      refresh_weeks();
    }
    return weeks;
  }

  public void setWeeks(List<String> weeks) {
    this.weeks = weeks;
  }

  public List<String> getDays_of_week() {
    if (days_of_week == null) {
      refresh_days_of_week();
    }
    return days_of_week;
  }

  public void setDays_of_week(List<String> days_of_week) {
    this.days_of_week = days_of_week;
  }

  public List<C_Month> getC_month_list() {
    if (c_month_list == null) {
      c_month_list = C_Month_Manager.getCI().get_rec_list_ordered_by_id_asc_with_cacheable();
    }
    return c_month_list;
  }

  public void setC_month_list(List<C_Month> c_month_list) {
    this.c_month_list = c_month_list;
  }

  public List<C_Tz> getC_tz_list() {
    if (c_tz_list == null) {
      c_tz_list = C_Tz_Manager.getCI().get_c_tz_list();
    }
    return c_tz_list;
  }

  public void setC_tz_list(List<C_Tz> c_tz_list) {
    this.c_tz_list = c_tz_list;
  }

  public String getFull_url_wo_uri_and_query_string() {
    return servlet_funcs.getRequestFullUrlWithoutURIAndQueryString(jsf_funcs.getRequest());
  }
  
  public void refresh_creator_usr_list(C_Usr logged_c_usr_) {
    creator_usr_list = C_Usr_Manager.getCI().get_creator_usr_list_for_logged_usr(logged_c_usr_);
  }

  public void refresh_months() {
    months = new ArrayList<String>();
    months.add(bundle_funcs.getBundleValue("Janvar"));
    months.add(bundle_funcs.getBundleValue("Fevral"));
    months.add(bundle_funcs.getBundleValue("Mart"));
    months.add(bundle_funcs.getBundleValue("Aprel"));
    months.add(bundle_funcs.getBundleValue("Maj"));
    months.add(bundle_funcs.getBundleValue("Ijun"));
    months.add(bundle_funcs.getBundleValue("Ijul"));
    months.add(bundle_funcs.getBundleValue("Avgust"));
    months.add(bundle_funcs.getBundleValue("Sentjabr"));
    months.add(bundle_funcs.getBundleValue("Oktjabr"));
    months.add(bundle_funcs.getBundleValue("Nojabr"));
    months.add(bundle_funcs.getBundleValue("Dekabr"));
  }

  public void refresh_days_of_month() {
    days_of_month = new ArrayList<String>();
    for (int i = 1; i <= 31; i++) {
      days_of_month.add(String.valueOf(i));
    }
    days_of_month.add(bundle_funcs.getBundleValue("posled"));
  }

  public void refresh_weeks() {
    weeks = new ArrayList<String>();
    for (int i = 1; i <= 4; i++) {
      weeks.add(String.valueOf(i));
    }
    weeks.add(bundle_funcs.getBundleValue("posled"));
  }

  public void refresh_days_of_week() {
    days_of_week = new ArrayList<String>();
    days_of_week.add(bundle_funcs.getBundleValue("PN"));
    days_of_week.add(bundle_funcs.getBundleValue("VT"));
    days_of_week.add(bundle_funcs.getBundleValue("SR"));
    days_of_week.add(bundle_funcs.getBundleValue("CHT"));
    days_of_week.add(bundle_funcs.getBundleValue("PT"));
    days_of_week.add(bundle_funcs.getBundleValue("SB"));
    days_of_week.add(bundle_funcs.getBundleValue("VS"));
  }

}
