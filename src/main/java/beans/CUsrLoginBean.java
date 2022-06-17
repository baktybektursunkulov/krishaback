package beans;

import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import gs.common.jsf.jsf_funcs;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import managers.core.dbtables.C_Usr_Log_Manager;
import managers.core.dbtables.C_Usr_Log_Service_Manager;
import managers.core.dbtables.C_Usr_Log_Type_Manager;
import managers.core.dbtables.C_Usr_Manager;
import model.core.dbtables.C_Usr;
import org.hibernate.Session;
import gs.common.hibernate_funcs;
import gs.common.primefaces.primefaces_funcs;
import org.hibernate.Transaction;
import others.CustomConsts;
import others.CustomLogger;
import others.custom_user_password_funcs;
import javax.faces.bean.SessionScoped;
import managers.core.dbtables.C_Lang_Manager;
import managers.core.dbtables.C_Limit_Log_Manager;
import managers.core.dbtables.C_Proj_Manager;
import managers.core.dbtables.C_Usr_Type_Manager;
import model.core.dbutil.CoreSessionFactoryUtil;
import others.core_custom_funcs;

@ManagedBean
@SessionScoped
public class CUsrLoginBean implements Serializable {

  private C_Usr logging_c_usr;

  String action = "";
  String action_usr_name = "";
  String action_usr_pswd = "";
  int unsuccessful_login_cnt = 0;

  public static CUsrLoginBean getCurrentBean() {
    return jsf_funcs.findBean("cUsrLoginBean");
  }

  public CUsrLoginBean() {
  }

  protected String getLogged_usr_session_key_name() {
    return "logged_c_usr";
  }

  public C_Usr getLogging_c_usr() {
    if (logging_c_usr == null) {
      logging_c_usr = new C_Usr();
    }
    return logging_c_usr;
  }

  public void setLogging_c_usr(C_Usr logging_c_usr) {
    this.logging_c_usr = logging_c_usr;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getAction_usr_name() {
    return action_usr_name;
  }

  public void setAction_usr_name(String action_usr_name) {
    this.action_usr_name = action_usr_name;
  }

  public String getAction_usr_pswd() {
    return action_usr_pswd;
  }

  public void setAction_usr_pswd(String action_usr_pswd) {
    this.action_usr_pswd = action_usr_pswd;
  }

  public int getUnsuccessful_login_cnt() {
    return unsuccessful_login_cnt;
  }

  public void setUnsuccessful_login_cnt(int unsuccessful_login_cnt) {
    this.unsuccessful_login_cnt = unsuccessful_login_cnt;
  }

  public boolean getIsCaptchaVisible() {
    return this.unsuccessful_login_cnt >= 10;
  }

  public String demoEntryAction(Integer c_proj_id_, Integer c_usr_type_id_) throws Exception {
    /*
    getLogging_c_usr().setName(VariablesBean.getCI().getSite().getDemo_entry_login());
    getLogging_c_usr().setPswd(VariablesBean.getCI().getSite().getDemo_entry_pswd());
     */
    String res = loginAction(false, "", c_proj_id_, c_usr_type_id_, "main_menu.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version(), true);
    if (res == null) {
      if (SessionBean.getCurrentBean().getIsMobileBrowser()) {
        primefaces_funcs.executeJS("document.getElementById('id_page_login:id_form_login:id_cb_enter').disabled = false;");
      } else {
        primefaces_funcs.executeJS("PF('wv_cb_enter').enable();");
      }
    }
    return res;
  }

  public String adminLoginAction() throws Exception {
    return loginAction(C_Proj_Manager.const_c_proj_id_common, C_Usr_Type_Manager.getCI().getConst_c_usr_type_id_admin(), "main_menu.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version(), true);
  }

  public String loginAction(Integer c_proj_id_, Integer c_usr_type_id_, String success_outcome_, Boolean check_password_) throws Exception {
    //primefaces_funcs.executeJS("PF('id_cb_enter').disable();");
    String res = loginAction(false, "", c_proj_id_, c_usr_type_id_, success_outcome_, check_password_);
    if (res == null) {
      /*
      if (SessionBean.getCurrentBean().getIsMobileBrowser()) {
        primefaces_funcs.executeJS("document.getElementById('id_page_login:id_form_login:id_cb_enter').disabled = false;");
      } else {
        primefaces_funcs.executeJS("PF('wv_cb_enter').enable();");
      }
       */
      primefaces_funcs.executeJS("PF('wv_cb_enter').enable();");
    }
    return res;
  }

  public String loginAction(boolean autologon_, String autologon_url_, Integer c_proj_id_, Integer c_usr_type_id_, String success_outcome_, Boolean check_password_) throws Exception {
    //Sys_Admin sys_admin_ = Sys_Admin_Manager.getSysAdminByUsrName(logging_c_usr.getName());
    C_Usr C_Usr_ = C_Usr_Manager.get_c_usr_by_name(c_proj_id_, c_usr_type_id_, logging_c_usr.getName());
    LinkedList<String> checkLoginRes = checkLogin((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(), logging_c_usr.getName(), logging_c_usr.getPswd(),
      bundle_funcs.getBundle(), C_Usr_, c_proj_id_, c_usr_type_id_, check_password_);
    if (checkLoginRes.size() > 0) {
      C_Limit_Log_Manager.getCI().ins_unsucc_login_limit_log(jsf_funcs.getRequest().getRemoteAddr(), logging_c_usr.getName(), logging_c_usr.getPswd(), C_Usr_Log_Service_Manager.getC_c_usr_log_service__web());
      if (!C_Limit_Log_Manager.getCI().check_unsucc_login(jsf_funcs.getRequest().getRemoteAddr(), C_Usr_Log_Service_Manager.getC_c_usr_log_service__web())) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Prevyshen_limit_neudachnykh_popytok_vkhoda")));
        getLogging_c_usr().setPswd("");
        return null;
      }

      for (int i = 0; i < checkLoginRes.size(); i++) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(checkLoginRes.get(i)));
      }
      this.unsuccessful_login_cnt++;
      getLogging_c_usr().setPswd("");
      return null;
    }
    this.unsuccessful_login_cnt = 0;

    CUsrBean.invalidateAndCreateNewSessionWithFilledSettings();

    if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey(getLogged_usr_session_key_name())) {
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(getLogged_usr_session_key_name());
    }

    if (C_Usr_.getCurrent_c_lang() == null || !C_Usr_.getCurrent_c_lang_t().getCode().equals(LocaleBean.getCurrentBean().getLanguageTag())) {
      C_Usr_.setCurrent_c_lang_t(C_Lang_Manager.getCI().get_rec_by_code(LocaleBean.getCurrentBean().getLanguageTag()));
      C_Usr_Manager.getCI().merge_rec(C_Usr_);
    }

    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(getLogged_usr_session_key_name(), C_Usr_);

    if (SessionBean.getCurrentBean().getIsMobileBrowser()) {
      C_Usr_Log_Manager.insUsrLog(C_Usr_, C_Usr_Log_Type_Manager.getC_c_usr_log_type__login(), C_Usr_Log_Service_Manager.getC_c_usr_log_service__mobile_web(),
        jsf_funcs.getRequestRemoteHost());
    } else {
      C_Usr_Log_Manager.insUsrLog(C_Usr_, C_Usr_Log_Type_Manager.getC_c_usr_log_type__login(), C_Usr_Log_Service_Manager.getC_c_usr_log_service__web(),
        jsf_funcs.getRequestRemoteHost());
    }

    //mainController.getMainControllerBean().load_theme();
    if (autologon_) {
      //String url_ = autologon_url_ + "?faces-redirect=true";
      //FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
      //    handleNavigation(FacesContext.getCurrentInstance(), null, url_);
      return null;
    }

    /*
    if (SessionBean.getCurrentBean().getIsMobileBrowser()) {
      return "mob_main.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    } else {
      return "main.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version();
    }
     */
    //if (c_usr_type_id_ == C_Usr_Type_Manager.getCI().getConst_c_usr_type_id_admin) {
    return success_outcome_;
    //}
    //return null;
  }

  public static LinkedList<String> checkLogin(HttpServletRequest request_, String user_name_, String user_password_, ResourceBundle bundle_, C_Usr C_Usr_, Integer c_proj_id_, Integer c_usr_type_id_,
    Boolean check_password_) throws Exception {
    LinkedList<String> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = checkLogin(session_, request_, user_name_, user_password_, bundle_, C_Usr_, c_proj_id_, c_usr_type_id_, check_password_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public static LinkedList<String> checkLogin(Session session_, HttpServletRequest request_, String user_name_, String user_password_, ResourceBundle bundle_, C_Usr C_Usr_, Integer c_proj_id_, Integer c_usr_type_id_,
    Boolean check_password_) throws Exception {
    LinkedList<String> res = new LinkedList<String>();
    //Sys_Admin sys_admin_ = Sys_Admin_Manager.getSysAdminByUsrName(logging_c_usr.getName());
    if (C_Usr_ == null) {
      String msg_ = bundle_funcs.getBundleValue(bundle_, "Nevernoe_imja_polzovatelja_ili_parol");
      res.add(msg_);
      return res;
    }
    //if (!sys_admin_.getUsr_password().equals(password)) {
    if (check_password_) {
      if (!custom_user_password_funcs.isUserPasswordCorrect(session_, C_Usr_, user_password_, c_proj_id_, c_usr_type_id_)) {
        String msg_ = bundle_funcs.getBundleValue(bundle_, "Nevernoe_imja_polzovatelja_ili_parol");
        res.add(msg_);
        return res;
      }
    }
    if (!C_Usr_.getIs_on()) {
      String msg_ = bundle_funcs.getBundleValue(bundle_, "Polzovatel_otkljuchen");
      res.add(msg_);
      return res;
    }
    /*
    if (!C_Common_Settings_Manager.getCurrent_c_common_settings(session_).getIs_system_launched()) {
      String msg_ = bundle_funcs.getBundleValue(bundle_, "Sistema_zakryta_na_tehnicheskoe_obsluzhivanie");
      res.add(msg_);
      return res;
    }
    if (!C_Site_Manager.get_current_c_site(session_, request_, true).getIs_site_launched()) {
      String msg_ = bundle_funcs.getBundleValue(bundle_, "Sajt_zakryt_na_tehnicheskoe_obsluzhivanie");
      res.add(msg_);
      return res;
    }
     */
    if (request_ != null) {
      /*
      CustomLogger.log("request_.getRemoteHost()=" + request_.getRemoteHost());
      if (C_Usr_.getHost_mask() != null && !C_Usr_.getHost_mask().trim().isEmpty()) {
        if (!other_funcs.isStringMathesMask(request_.getRemoteHost(), C_Usr_.getHost_mask())) {
          String msg_ = bundle_funcs.getBundleValue(bundle_, "Polzovatel_ne_mozhet_vojti_tak_kak_IP_adres_ne_sootvetstvuet_maske_hosta_polzovatelja");
          res.add(msg_);
          return res;
        }
      }
      */
    }
    if (C_Usr_.getC_usr_status_t_2(session_).getCode().equals("blocked")) {
      String msg_ = bundle_funcs.getBundleValue(bundle_, "Polzovatel_zablokirovan");
      res.add(msg_);
      return res;
    }
    if (C_Usr_Manager.getCI().is_parent_c_usr_blocked(C_Usr_)) {
      String msg_ = bundle_funcs.getBundleValue(bundle_, "Polzovatel_zablokirovan");
      res.add(msg_);
      return res;
    }

    return res;
  }

  public void adminForwardToLoginIfNotLoggedIn(ComponentSystemEvent cse) throws Exception {
    if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
      return;
    }
    String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();

    // Autologon
    if (!CUsrBean.getCurrentBean().isCUsrLoggedIn() && !viewId.contains("login")) {
      Boolean auto_logon_ = Boolean.valueOf(System.getProperty("core__admin_auto_logon"));
      String auto_login_ = String.valueOf(System.getProperty("core__admin_auto_login"));
      String auto_password_ = String.valueOf(System.getProperty("core__admin_auto_password"));
      if (auto_logon_ && logging_c_usr == null) {
        logging_c_usr = new C_Usr();
        logging_c_usr.setName(auto_login_);
        logging_c_usr.setPswd(auto_password_);
        loginAction(auto_logon_, core_custom_funcs.getRequestURIWithoutAppName(FacesContext.getCurrentInstance()), C_Proj_Manager.const_c_proj_id_common, C_Usr_Type_Manager.getCI().getConst_c_usr_type_id_admin(),
          "main_menu.xhtml?faces-redirect=true&v=" + VariablesBean.getCI().getBuild_version(), true);
        return;
      }
    }

    if (!CUsrBean.getCurrentBean().isCUsrLoggedIn() && !viewId.contains("login")) {
      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
        handleNavigation(FacesContext.getCurrentInstance(), null,
          CUsrBean.getCurrentBean().getLoginURL(FacesContext.getCurrentInstance(), C_Proj_Manager.const_c_proj_id_common, C_Usr_Type_Manager.getCI().getConst_c_usr_type_id_admin()));
    }
  }

  /*
  public void forwardToLoginIfNotLoggedIn(ComponentSystemEvent cse) throws Exception {
    if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
      return;
    }
    String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();

    // Autologon
    if (!CUsrBean.getCI().isCUsrLoggedIn() && !viewId.contains("login")) {
      Boolean autologon_ = Boolean.valueOf(System.getProperty("core__autologon"));
      String autologin_ = String.valueOf(System.getProperty("core__autologin"));
      if (autologon_ && logging_c_usr == null) {
        logging_c_usr = new C_Usr();
        logging_c_usr.setName(autologin_);
        logging_c_usr.setPswd(C_Usr_Manager.getCI().getDefault_c_usr().getPswd());
        loginAction(autologon_, CustomFuncs.getRequestURIWithoutAppName(FacesContext.getCurrentInstance()));
        return;
      }
    }

    if (!CUsrBean.getCI().isCUsrLoggedIn() && !viewId.contains("login")) {
      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
        handleNavigation(FacesContext.getCurrentInstance(), null,
          CustomFuncs.getLoginURL(FacesContext.getCurrentInstance()));
    }
  }
   */
  public void forwardToLoginIfSystemStopped(ComponentSystemEvent cse) {
    if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
      return;
    }
    /*
    C_Common_Settings c_common_settings_ = C_Common_Settings_Manager.getCurrent_c_common_settings();
    if (!c_common_settings_.getIs_system_launched()) {
      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
        handleNavigation(FacesContext.getCurrentInstance(), null,
          CustomFuncs.getLoginURL(FacesContext.getCurrentInstance()));
    }
     */
  }

  public void forwardToLoginIfSiteStopped(ComponentSystemEvent cse) {
    if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
      return;
    }
    /*
    C_Site C_Site_ = C_Site_Manager.get_current_c_site();
    if (!C_Site_.getIs_site_launched()) {
      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
        handleNavigation(FacesContext.getCurrentInstance(), null,
          CustomFuncs.getLoginURL(FacesContext.getCurrentInstance()));
    }
     */
  }

  public void callAction() {
    CustomLogger.log("callAction");
    /*
    if (VariablesBean.getCI().getIs_test_mode()) {
      setAction("login");
      setAction_usr_name("demo");
      setAction_usr_pswd("");
    }
     */
    if (getAction().isEmpty()) {
      return;
    }
    if (getAction().equals("login")) {
      if (action_usr_name != null && !action_usr_name.isEmpty()) {
        //getLogging_c_usr().setName(action_usr_name);
        //getLogging_c_usr().setPswd(action_usr_pswd);
        //CustomLogger.log(getLogging_c_usr().getName());
        //primefaces_funcs.updateElement("form_main:id_name");
        //loginAction(true, CustomFuncs.getMainURL(FacesContext.getCurrentInstance()));
        //FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
        //        handleNavigation(FacesContext.getCurrentInstance(), null,
        //                CustomFuncs.getMainURL(FacesContext.getCurrentInstance()));
        primefaces_funcs.executeJS("document.getElementById('form_main:id_name').value = '" + action_usr_name + "';");
        primefaces_funcs.executeJS("document.getElementById('form_main:id_pswd').value = '" + action_usr_pswd + "';");
        //primefaces_funcs.updateElement("form_main:id_name");
        //primefaces_funcs.updateElement("form_main:id_pswd");
        primefaces_funcs.executeJS("document.getElementById('form_main:id_cb_enter').click();");
      }
    }
  }

  public void callAction2() {
    primefaces_funcs.executeJS("document.getElementById('form_main:id_cb_enter').click();");
  }

  public void changeLocale() {
    CustomLogger.log("changeLocale " + LocaleBean.getCurrentBean().getLanguageTag());
    primefaces_funcs.executeJS("resizeDivs();");
    //FacesContext.getCurrentInstance().getApplication().setDefaultLocale(new Locale(getLogging_c_usr().getC_lang().getCode()));
    //FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(getLogging_c_usr().getC_lang().getCode()));
    //primefaces_funcs.executeJS("window.location.href = window.location.href;");
  }

  public void setIsMobileBrowserToTrue(ComponentSystemEvent cse) {
    SessionBean.getCurrentBean().setIsMobileBrowser(true);
  }

  public void setIsMobileBrowserToFalse(ComponentSystemEvent cse) {
    SessionBean.getCurrentBean().setIsMobileBrowser(false);
  }

  public void checkBrowser(ComponentSystemEvent cse) {
    try {
      if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
        return;
      }

      String currentUrl = getCurrentUrl();
      //url = url.replace("/ts/client", "");
      String correctUrl = getCorrectUrl();
      CustomLogger.log("checkBrowser currentUrl=" + currentUrl);
      CustomLogger.log("checkBrowser correctUrl=" + correctUrl);
      if (currentUrl != null && !currentUrl.isEmpty() && !currentUrl.equals(correctUrl)) {
        /*
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
          handleNavigation(FacesContext.getCurrentInstance(), null, correctUrl);
         */
        FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + correctUrl);
      }
    } catch (Exception e) {
      CustomLogger.error(e);
      jsf_funcs.addErrorMessage(e);
    }
  }

  public String getCurrentUrl() throws Exception {
    String url = jsf_funcs.getRequestURIWithQueryStringWithoutContextPath();
    return url;
  }

  public String getCorrectUrl() throws Exception {
    //String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
    //CustomLogger.log("viewId=" + viewId);

    String url = getCurrentUrl();
    //String url = viewId + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
    //CustomLogger.log("url=" + url);
    //CustomLogger.log("getIsMobileBrowser()=" + SessionBean.getCurrentBean().getIsMobileBrowser());

    String newUrl = "";
    if (SessionBean.getCurrentBean().getIsMobileBrowser()) {
      if (url.contains("/login.xhtml")) {
        newUrl = url.replace("/login.xhtml", "/mob_login.xhtml");
      } else if (url.contains("/dt_login.xhtml")) {
        newUrl = url.replace("/dt_login.xhtml", "/mob_login.xhtml");
      }
    } else if (url.contains("/login.xhtml")) {
      newUrl = url.replace("/login.xhtml", "/dt_login.xhtml");
    } else if (url.contains("/mob_login.xhtml")) {
      newUrl = url.replace("/mob_login.xhtml", "/dt_login.xhtml");
    }

    newUrl = core_custom_funcs.getRemovedSessionIdFromUrl(newUrl);
    if (!newUrl.isEmpty()) {
      if (!newUrl.contains("faces-redirect=true")) {
        if (newUrl.contains("?")) {
          newUrl = newUrl + "&faces-redirect=true";
        } else {
          newUrl = newUrl + "?faces-redirect=true";
        }
      }
      return newUrl;
    }
    return "";
  }

  public String switchToFullVersion() {
    try {
      SessionBean.getCurrentBean().setIsMobileBrowser(false);
      return getCorrectUrl();
    } catch (Exception e) {
      CustomLogger.error(e);
      jsf_funcs.addErrorMessage(e);
    }
    return "";
  }

  public String switchToMobileVersion() {
    try {
      SessionBean.getCurrentBean().setIsMobileBrowser(true);
      return getCorrectUrl();
    } catch (Exception e) {
      CustomLogger.error(e);
      jsf_funcs.addErrorMessage(e);
    }
    return "";
  }

  public void adminPreRenderView(ComponentSystemEvent cse) {
    if (!FacesContext.getCurrentInstance().isPostback()) {
      SessionBean.getCurrentBean().setIsMobileBrowser(false);
      getLogging_c_usr().setName("");
      getLogging_c_usr().setPswd("");
    }
  }

  public void commonPreRenderView(ComponentSystemEvent cse) {
    if (!FacesContext.getCurrentInstance().isPostback()) {
      SessionBean.getCurrentBean().setIsMobileBrowser(false);
      getLogging_c_usr().setName("");
      getLogging_c_usr().setPswd("");
    }
  }

  /*
  public void userPreRenderView(ComponentSystemEvent cse) {
    if (!FacesContext.getCurrentInstance().isPostback()) {
      SessionBean.getCurrentBean().setIsMobileBrowser(false);
      getLogging_c_usr().setName("");
      getLogging_c_usr().setPswd("");
      mainController.getMainControllerBean().setClient_mode("user");
    }
  }

  public void managerPreRenderView(ComponentSystemEvent cse) {
    if (!FacesContext.getCurrentInstance().isPostback()) {
      SessionBean.getCurrentBean().setIsMobileBrowser(false);
      getLogging_c_usr().setName("");
      getLogging_c_usr().setPswd("");
      mainController.getMainControllerBean().setClient_mode("manager");
    }
  }

  public void mobPreRenderView(ComponentSystemEvent cse) {
    if (!FacesContext.getCurrentInstance().isPostback()) {
      SessionBean.getCurrentBean().setIsMobileBrowser(true);
      getLogging_c_usr().setName("");
      getLogging_c_usr().setPswd("");
      mainController.getMainControllerBean().setClient_mode("user");
    }
  }
   */
 /*
  public String switchToFullVersionListener() {
    try {
      SessionBean.getCurrentBean().setIsMobileBrowser(false);
      //primefaces_funcs.executeJS("location.href='" + getCorrectViewId(FacesContext.getCurrentInstance().getViewRoot().getViewId()) + "'");
      //FacesContext.getCurrentInstance().getExternalContext().redirect(getCorrectViewId() + "?isMobileBrowser=false");
      String correctViewId = getCorrectViewId();
      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
          handleNavigation(FacesContext.getCurrentInstance(), null, correctViewId);
    } catch (Exception e) {
      CustomLogger.error(e); 
      jsf_funcs.addErrorMessage(e);
    }
    return "";
  }
   */
}
