package beans;

import gs.common.hibernate_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.locale_funcs;
import gs.common.other_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.servlet.servlet_funcs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managers.core.dbtables.C_Proj_Manager;
import managers.core.dbtables.C_Site_Manager;
import model.core.dbtables.C_Proj;
import model.core.dbtables.C_Site;
import org.hibernate.Session;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class LocaleBean implements Serializable {

  private Locale currentLocale;
  private List<Locale> supportedLocales = new ArrayList<Locale>();
  private static LocaleBean currentBean = null;

  public static LocaleBean getCurrentBean() {
    LocaleBean bean_ = getCurrentBean((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest());
    return bean_;
  }

  public static LocaleBean getCurrentBean(HttpServletRequest request_) {
    LocaleBean bean_ = jsf_funcs.findBean("localeBean");
    if (bean_ == null) {
      bean_ = new LocaleBean();
      if (request_ != null || request_.getSession(true) != null) {
        HttpSession session_ = request_.getSession(true);
        CustomLogger.log("bean_=" + bean_);
        CustomLogger.log("session_=" + session_);
        session_.setAttribute("localeBean", bean_);
      }
    }
    return bean_;
  }

  @PostConstruct
  public void init() {
    FacesContext.getCurrentInstance().getExternalContext().getSession(true);
  }

  public Locale getCurrentLocale() {
    if (currentLocale != null) {
      return currentLocale;
    }
    if (FacesContext.getCurrentInstance() != null) {
      String cookie_lang_tag_ = servlet_funcs.getCookieValue(jsf_funcs.getRequest(), "lang");
      if (cookie_lang_tag_ != null) {
        try {
          currentLocale = locale_funcs.getLocale(cookie_lang_tag_);
        } catch (Exception e) {
          currentLocale = null;
        }
      }
    }
    if (currentLocale == null) {
      if (FacesContext.getCurrentInstance().getViewRoot() != null) {
        currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
      } else if (FacesContext.getCurrentInstance().getExternalContext() != null) {
        currentLocale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
      } else if (FacesContext.getCurrentInstance().getApplication() != null) {
        currentLocale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
      }
    }

    C_Proj c_proj_ = null;
    String languageTag = locale_funcs.getLanguageTag(currentLocale);
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      C_Site c_site_ = C_Site_Manager.get_current_c_site(session_, (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(), true);
      if (c_site_ != null) {
        c_proj_ = c_site_.getC_proj_t_2(session_);
        if (c_proj_ != null) {
          for (int i = 0; i < c_proj_.getProj_lang_list_2(session_).size(); i++) {
            if (c_proj_.getProj_lang_list_2(session_).get(i).getCode().equals(languageTag)) {
              hibernate_funcs.rollbackAndClose(session_);
              return currentLocale;
            }
          }
        }
      }
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }

    if (c_proj_ != null && c_proj_.getDef_c_lang() != null) {      
      setLanguageTag(c_proj_.getDef_c_lang_t().getCode());
      currentLocale = locale_funcs.getLocale(c_proj_.getDef_c_lang_t().getCode());
      return currentLocale;
    }
    currentLocale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
    return currentLocale;
  }

  public void setCurrentLocale(Locale currentLocale) {
    this.currentLocale = currentLocale;
    FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
  }

  public String getLanguageTag() {
    return locale_funcs.getLanguageTag(getCurrentLocale());
  }

  public void setLanguageTag(String language_tag_) {
    currentLocale = locale_funcs.getLocale(language_tag_);
    FacesContext ctx = FacesContext.getCurrentInstance();
    if (ctx != null) {
      UIViewRoot viewRoot = ctx.getViewRoot();
      if (viewRoot != null) {
        viewRoot.setLocale(currentLocale);
      }
    }
    //FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
    try {
      HttpServletResponse response_ = jsf_funcs.getResponse();
      servlet_funcs.setCookieValue(response_, "lang", language_tag_, "/", 60 * 60 * 24 * 30);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<Locale> getSupportedLocales() {
    if (supportedLocales.isEmpty() && FacesContext.getCurrentInstance() != null) {
      Iterator<Locale> facesLocales = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
      while (facesLocales.hasNext()) {
        supportedLocales.add(facesLocales.next());
      }
    }
    return supportedLocales;
  }

  public void setSupportedLocaleStrings(Collection<String> localeStrings) {
    supportedLocales.clear();
    for (String checkLocale : localeStrings) {
      for (Locale locale : Locale.getAvailableLocales()) {
        if (locale.toString().equals(checkLocale)) {
          supportedLocales.add(locale);
          break;
        }
      }
    }

  }
}
