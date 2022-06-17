package beans;

import gs.common.jsf.bundle_funcs;
import gs.common.other_funcs;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Usr_Log_Manager;
import managers.core.dbtables.C_Usr_Log_Service_Manager;
import managers.core.dbtables.C_Usr_Log_Type_Manager;
import managers.core.dbtables.C_Usr_Manager;
import model.core.dbtables.C_Usr;
import gs.common.jsf.jsf_funcs;
import gs.common.primefaces.primefaces_funcs;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import managers.core.dbtables.C_Proj_Manager;
import managers.core.dbtables.C_Usr_Type_Manager;
import managers.core.dbtables.I_Tbl_Fld_Trans_Manager;
import model.core.dbtables.C_Usr_Role;
import org.hibernate.Cache;
import others.core_custom_funcs;

@ManagedBean
@SessionScoped
public class CUsrBean implements Serializable {

  //static CUsrBean current_instance;
  public CUsrBean() {
  }

  public static CUsrBean getCurrentBean() {
    return jsf_funcs.findBean("cUsrBean");
  }

  protected String getLogged_usr_session_key_name() {
    return "logged_c_usr";
  }

  protected String getLoginURL(FacesContext fc, Integer c_proj_id_, Integer c_usr_type_id_) {
    String url_ = other_funcs.getRequestURL(fc);
    if (url_.contains("/admin/")) {
      return "/admin/login.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else if (url_.contains("/client/")) {
      /*
      if (SessionBean.getCurrentBean().getIsMobileBrowser()) {
        return "mob_login.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
      } else if (mainController.getMainControllerBean().getClient_mode().equals("user")) {
        return "dt_login.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
      } else {
        return "manager_login.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
      }
       */
      return null;
    } else {
      return null;
    }
  }

  protected String getMainURLForRedirect(FacesContext fc) {
    String url_ = other_funcs.getRequestURL(fc);
    if (url_.contains("/admin/")) {
      return "main_menu.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + core_custom_funcs.getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else if (url_.contains("/client/")) {
      return (SessionBean.getCurrentBean().getIsMobileBrowser() ? "mob_main.xhtml" : "main.xhtml") + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + core_custom_funcs.getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else {
      return "error.xhtml" + (VariablesBean.getCI().getIs_url_session_tracking_mode() ? ";jsessionid=" + core_custom_funcs.getSessionId(fc) : "") + "?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    }
  }

  /*
  protected static CUsrBean getCI() {
    if (current_instance == null) {
      current_instance = new CUsrBean();
    }
    return current_instance;
  }
   */
  public boolean isCUsrLoggedIn() {
    return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey(getLogged_usr_session_key_name());
  }

  public boolean isCUsrLoggedIn(HttpServletRequest request) {
    if (request.getSession() == null) {
      return false;
    }
    return (request.getSession().getAttribute(getLogged_usr_session_key_name()) != null);
  }

  public C_Usr getLoggedCUsr() {
    return (C_Usr) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(getLogged_usr_session_key_name());
  }

  public void setLoggedCUsr(C_Usr c_usr_) {
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(getLogged_usr_session_key_name(), c_usr_);
  }

  public C_Usr getLoggedCUsr(HttpServletRequest request) {
    return (C_Usr) request.getSession().getAttribute(getLogged_usr_session_key_name());
  }

  public void setLoggedCUsr(HttpServletRequest request, C_Usr c_usr_) {
    request.getSession().setAttribute(getLogged_usr_session_key_name(), c_usr_);
  }

  /*
  public static C_Usr staticGetLoggedCUsr() {
    return getCI().getLoggedCUsr();
  }

  public static C_Usr staticGetLoggedCUsr(HttpServletRequest request) {
    return getCI().getLoggedCUsr(request);
  }
   */
  public static void invalidateSession() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  }

  public static void invalidateAndCreateNewSessionWithFilledSettings() {
    Boolean isMobileBrowser = SessionBean.getCurrentBean().getIsMobileBrowser();
    LocaleBean localeBean = LocaleBean.getCurrentBean();
    //String client_mode_ = mainController.getMainControllerBean().getClient_mode();

    invalidateSession();

    SessionBean.getCurrentBean().setIsMobileBrowser(isMobileBrowser);
    if (localeBean != null) {
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("localeBean", localeBean);
    }
    //mainController.getMainControllerBean().setClient_mode(client_mode_);
  }

  public static void clearSession() {
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
  }

  public static void clearSessionAndFillSavedSettings() {
    Boolean isMobileBrowser = SessionBean.getCurrentBean().getIsMobileBrowser();
    LocaleBean localeBean = LocaleBean.getCurrentBean();
    //String client_mode_ = mainController.getMainControllerBean().getClient_mode();

    CUsrBean.clearSession();

    SessionBean.getCurrentBean().setIsMobileBrowser(isMobileBrowser);
    if (localeBean != null) {
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("localeBean", localeBean);
    }
    //mainController.getMainControllerBean().setClient_mode(client_mode_);
  }

  public String adminLogoutAction() {
    return logoutAction(C_Proj_Manager.const_c_proj_id_common, C_Usr_Type_Manager.getCI().getConst_c_usr_type_id_admin());
  }

  public String logoutAction(Integer c_proj_id_, Integer c_usr_type_id_) {
    boolean isMobileBrowser = SessionBean.getCurrentBean().getIsMobileBrowser();
    if (isMobileBrowser) {
      C_Usr_Log_Manager.insUsrLog(getLoggedCUsr(), C_Usr_Log_Type_Manager.getC_c_usr_log_type__logout(), C_Usr_Log_Service_Manager.getC_c_usr_log_service__mobile_web(),
        jsf_funcs.getRequestRemoteHost());
    } else {
      C_Usr_Log_Manager.insUsrLog(getLoggedCUsr(), C_Usr_Log_Type_Manager.getC_c_usr_log_type__logout(), C_Usr_Log_Service_Manager.getC_c_usr_log_service__web(),
        jsf_funcs.getRequestRemoteHost());
    }

    invalidateAndCreateNewSessionWithFilledSettings();
    String result = getLoginURL(FacesContext.getCurrentInstance(), c_proj_id_, c_usr_type_id_);

    return result;
  }

  public void connectToCUsr(C_Usr c_usr_) throws Exception {
    //mainController.getMainControllerBean().setClient_mode(client_mode_);
    CUsrBean.clearSessionAndFillSavedSettings();

    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(getLogged_usr_session_key_name(), c_usr_);
    //FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, CustomFuncs.getMainURL(FacesContext.getCurrentInstance()));

    C_Usr_Log_Manager.insUsrLog(getLoggedCUsr(), C_Usr_Log_Type_Manager.getC_c_usr_log_type__login(), C_Usr_Log_Service_Manager.getC_c_usr_log_service__web(),
      jsf_funcs.getRequestRemoteHost());
    primefaces_funcs.executeJS("location.href='" + getMainURLForRedirect(FacesContext.getCurrentInstance()) + "';");

    // dispatch causes "Expired View"
    //FacesContext.getCurrentInstance().getExternalContext().dispatch(CustomFuncs.getMainURLForRedirect(FacesContext.getCurrentInstance()));
    // handleNavigation causes "Expired View"
    //FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null,
    //  CustomFuncs.getMainURLForRedirect(FacesContext.getCurrentInstance()));
    // redirect causes "Expired View"
    //FacesContext.getCurrentInstance().getExternalContext().redirect(CustomFuncs.getMainURLForRedirect(FacesContext.getCurrentInstance()));
  }

  public void reconnectToLoggedCUsr() throws Exception {
    //CustomLogger.log("reconnectToLoggedCUsr()");
    C_Usr c_usr_ = C_Usr_Manager.getCI().get_rec_2(getLoggedCUsr().getC_usr());
    connectToCUsr(c_usr_);
  }

  // очищает весь кеш
  public void clearCache() {
    Cache cache = model.core.dbutil.CoreSessionFactoryUtil.getInstance().getCache();
    if (cache != null) {
      cache.evictAllRegions(); // Evict data from all query regions.
    }
    //I_Tbl_Fld_Trans_Manager.getCI().refresh_i_tbl_fld_trans_map();
    primefaces_funcs.executeJS("alert('" + bundle_funcs.getBundleValue("Kjesh_ochishhen") + "');");
  }

  public Boolean getIs_logged_usr_moderator() {
    return (getLoggedCUsr().getIs_moderator());
  }

}
