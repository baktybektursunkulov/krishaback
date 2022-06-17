package managers.core.dbtables;

import beans.CUsrBean;
import beans.SessionBean;
import gs.common.hibernate_funcs;
import gs.common.jsf.jsf_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Order_Condition;
import java.net.IDN;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Site_Manager extends Abstract_Controller_Manager<C_Site> {

  private static C_Site_Manager currentInstance = null;

  public static C_Site_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Site_Manager();
    }
    return currentInstance;
  }

  public C_Site_Manager() {
    super(C_Site.class);
  }

  public static C_Site get_c_site_by_domain(String domain_) {
    C_Site res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_site_by_domain(session_, domain_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static C_Site get_c_site_by_domain(Session session_, String domain_) {
    if (domain_ == null || domain_.isEmpty()) {
      return null;
    }

    C_Site res = null;
    Query q_ = session_.createQuery("from C_Site where is_deleted=false and domain=:domain_");
    q_.setString("domain_", domain_);
    //q_.setCacheable(use_query_cache);
    if (!q_.list().isEmpty()) {
      res = (C_Site) q_.list().get(0);
    }
    if (res == null) {
      q_ = session_.createQuery("from C_Site where is_deleted=false and domain=:domain_");
      q_.setString("domain_", IDN.toUnicode(domain_));
      //q_.setCacheable(use_query_cache);
      if (!q_.list().isEmpty()) {
        res = (C_Site) q_.list().get(0);
      }
    }
    return res;
  }

  public List<C_Site> get_c_site_list() {
    Transaction tx = null;
    List<C_Site> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_site_list(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public List<C_Site> get_c_site_list(Session session_) {
    List<C_Site> res = null;
    Query q_ = session_.createQuery("from C_Site where is_deleted=false order by c_site desc");
    //q_.setCacheable(use_query_cache);
    res = q_.list();
    return res;
  }

  public List<C_Site> get_c_site_list(SQL_Order_Condition sql_order_condition_) {
    Transaction tx = null;
    List<C_Site> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Site where is_deleted=false order by " + sql_order_condition_.getField_name() + " " + sql_order_condition_.getSort_order());
      //q_.setCacheable(use_query_cache);
      res = q_.list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static C_Site get_current_c_site() {
    C_Site res = null;
    res = get_current_c_site((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(), true);
    return res;
  }

  public static C_Site get_current_c_site_wo_creating_session_bean() {
    C_Site res = null;
    res = get_current_c_site((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(), false);
    return res;
  }

  public static C_Site get_current_c_site_wo_creating_session_bean(Session session_) {
    C_Site res = null;
    res = get_current_c_site(session_, (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(), false);
    return res;
  }

  public static C_Site get_current_c_site(Session session_, boolean is_create_session_bean_) {
    C_Site res = null;
    res = get_current_c_site(session_, (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(), is_create_session_bean_);
    return res;
  }

  public static C_Site get_current_c_site(HttpServletRequest request, boolean is_create_session_bean_) {
    C_Site res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_current_c_site(session_, request, is_create_session_bean_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }

    return res;
  }

  public static C_Site get_current_c_site(Session session_, HttpServletRequest request, boolean is_create_session_bean_) {
    C_Site res = null;
    String domain_ = request.getServerName();
    res = get_c_site_by_domain(session_, domain_);
    //if (res == null) {
    //  res = getDefault_c_site(session_);
    //}
    if (is_create_session_bean_) {
      SessionBean sessionBean = (SessionBean) request.getSession(true).getAttribute("sessionBean");
      if (sessionBean == null) {
        sessionBean = new SessionBean();
        request.getSession(true).setAttribute("sessionBean", sessionBean);
      }
      sessionBean.setCurrent_c_site(res);
    }

    return res;
  }

  public static C_Site getDefault_c_site() {
    return C_Site_Manager.getCI().get_rec_2(1);
  }

  public static C_Site getDefault_c_site(Session session_) {
    return C_Site_Manager.getCI().get_rec(session_, 1);
  }

  /*
  public static C_Site get_c_site_by_domain(Session session_, String domain_) {
    if (domain_ == null || domain_.isEmpty()) {
      return null;
    }
    C_Site c_site_;
    List<C_Site> c_site_list_ = C_Site_Manager.getCI().get_c_site_list(session_);
    for (int i = 0; i < c_site_list_.size(); i++) {
      c_site_ = c_site_list_.get(i);
      if (c_site_ != null && c_site_.getDomain().equals(domain_)) {
        return c_site_list_.get(i);
      }
    }
    return null;
  }
   */
  public List<C_Site> get_c_site_list(Integer v3_usr_id_) {
    Transaction tx = null;
    List<C_Site> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_c_site_list(session_, v3_usr_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public List<C_Site> get_c_site_list(Session session_, Integer v3_usr_id_) {
    List<C_Site> res = null;
    Query q_ = session_.createQuery("from C_Site "
      + "where "
      + "  is_deleted=false and v3_usr.v3_usr = :v3_usr_id_ "
      + "order by c_site desc");
    q_.setInteger("v3_usr_id_", v3_usr_id_);
    //q_.setCacheable(use_query_cache);
    res = q_.list();
    return res;
  }

  public static boolean is_confirmed_c_site_exists(Session session_, String domain_, Integer exclude_c_site_id_) {
    Query q_ = session_.createQuery("from C_Site where is_deleted=false and domain=:domain_ and is_confirmed=true and c_site<>:exclude_c_site_id_");
    if (exclude_c_site_id_ == null) {
      exclude_c_site_id_ = 0;
    }
    q_.setInteger("exclude_c_site_id_", exclude_c_site_id_);
    q_.setString("domain_", domain_);
    //q_.setCacheable(use_query_cache);
    List<C_Img> list_ = q_.list();
    return !list_.isEmpty();
  }

  public C_Site get_c_site_for_notification(Session session_, Integer v3_usr_id_) {
    C_Site res = null;
    Query q_ = session_.createQuery("from C_Site "
      + "where "
      + "  is_deleted=false and v3_usr.v3_usr = :v3_usr_id_ "
      + "order by c_site desc");
    q_.setMaxResults(1);
    q_.setInteger("v3_usr_id_", v3_usr_id_);
    //q_.setCacheable(use_query_cache);
    List<C_Site> list_ = q_.list();
    if (list_ == null || list_.isEmpty()) {
      res = getDefault_c_site(session_);
    } else {
      res = list_.get(0);
    }
    return res;
  }

  public String getFilledTextForDocumentation(Session session_, String text_, String lang_, String url_) {
    return getFilledTextForDocumentation(session_, C_Site_Manager.get_current_c_site(session_, false), text_, lang_, url_);
  }

  public String getFilledTextForDocumentation(Session session_, C_Site c_site_, String text_, String lang_, String url_) {
    String res = text_;
    if (c_site_ == null) {
      c_site_ = C_Site_Manager.get_current_c_site(session_, false);
    }
    boolean isSiteInURL;
    if (url_ != null) {
      isSiteInURL = url_.contains("/site/");
    } else {
      isSiteInURL = false;
    }
    if (isSiteInURL) {
      res = res.replace("/ts/docs/%lang%/", "/site/%lang%/docs/");
    } else {
      res = res.replace("/ts/docs/%lang%/", "/%lang%/docs/");
    }
    res = res.replace("%title%", c_site_.getTitle());
    res = res.replace("%copyright_text%", c_site_.getCopyright_text());
    res = res.replace("%copyright_url%", c_site_.getCopyright_url());
    res = res.replace("%domain%", c_site_.getDomain());
    res = res.replace("%lang%", lang_);
    res = res.replace("%usr_email%", c_site_.getC_usr_t_2(session_).getEmail());
    HttpServletRequest request = jsf_funcs.getRequest();
    String host_ = request.getServerName();
    if (request.getServerPort() != 80 && request.getServerPort() != 443) {
      host_ = host_ + ":" + request.getServerPort();
    }
    res = res.replace("%host%", host_);
    res = res.replace("%context_path%", request.getContextPath());    
    //res = res.replace("%title%", c_site_.getTitle());
    return res;
  }

  public static C_Site get_new_c_site_with_loaded_default_vals(C_Usr logged_c_usr_) {
    C_Site res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_new_c_site_with_loaded_default_vals(session_, logged_c_usr_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public static C_Site get_new_c_site_with_loaded_default_vals(Session session_, C_Usr logged_c_usr_) {
    C_Site res = null;
    C_Site def_rec_ = getDefault_c_site(session_);
    res = (C_Site) def_rec_.clone();
    res.setC_site(null);
    res.setDomain("");
    res.setTitle("");
    res.setCopyright_text("");
    res.setCopyright_url("");
    //res.setV3_theme(V3_Theme_Manager.getCI().get_rec_by_code_2_with_cache("aristo"));
    //res.setC_usr_log_service(V3_Usr_Log_Service_Manager.getCI().get_rec_by_code_2_with_cache("web"));
    //res.setIs_show_demo_entry(true);
    //res.setDemo_entry_login("demo");
    //res.setDemo_entry_pswd("demo");
    res.setC_usr_t(logged_c_usr_);
    res.setUse_https(false);
    res.setIs_deleted(false);
    return res;
  }
  
  public C_Site_Img get_favicon_site_img(C_Site c_site_) {
    return C_Site_Img_Manager.getCI().get_c_site_img(c_site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__favicon);
  }

  public C_Site_Img get_favicon_site_img(Session session_, C_Site c_site_) {
    if (c_site_ == null) {
      return null;
    }
    return C_Site_Img_Manager.getCI().get_c_site_img(session_, c_site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__favicon);
  }

  public C_Img get_favicon_img(C_Site c_site_) {
    C_Site_Img c_Site_Img = get_favicon_site_img(c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getImg_t());
  }

  public C_Img get_favicon_img(Session session_, C_Site c_site_) {
    C_Site_Img c_Site_Img = get_favicon_site_img(session_, c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getImg_t_2(session_));
  }

  public Long get_favicon_img_id(C_Site c_site_) {
    C_Site_Img c_Site_Img = get_favicon_site_img(c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getC_img());
  }

  public Long get_favicon_img_id(Session session_, C_Site c_site_) {
    C_Site_Img c_Site_Img = get_favicon_site_img(session_, c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getC_img());
  }

  public C_Site_Img get_entry_logo_site_img(C_Site c_site_) {
    if (c_site_ == null) {
      return null;
    }
    return C_Site_Img_Manager.getCI().get_c_site_img(c_site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__entry_logo);
  }

  public C_Site_Img get_entry_logo_site_img(Session session_, C_Site c_site_) {
    if (c_site_ == null) {
      return null;
    }
    return C_Site_Img_Manager.getCI().get_c_site_img(session_, c_site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__entry_logo);
  }

  public C_Img get_entry_logo_img(C_Site c_site_) {
    C_Site_Img c_Site_Img = get_entry_logo_site_img(c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getImg_t());
  }

  public C_Img get_entry_logo_img(Session session_, C_Site c_site_) {
    C_Site_Img c_Site_Img = get_entry_logo_site_img(session_, c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getImg_t_2(session_));
  }

  public Long get_entry_logo_img_id(C_Site c_site_) {
    C_Site_Img c_Site_Img = get_entry_logo_site_img(c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getC_img());
  }

  public Long get_entry_logo_img_id(Session session_, C_Site c_site_) {
    C_Site_Img c_Site_Img = get_entry_logo_site_img(session_, c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getC_img());
  }

  public C_Site_Img get_logo_site_img(C_Site c_site_) {
    if (c_site_ == null) {
      return null;
    }
    return C_Site_Img_Manager.getCI().get_c_site_img(c_site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__logo);
  }

  public C_Site_Img get_logo_site_img(Session session_, C_Site c_site_) {
    if (c_site_ == null) {
      return null;
    }
    return C_Site_Img_Manager.getCI().get_c_site_img(session_, c_site_.getC_site(), C_Site_Img_Type_Manager.const_c_site_img_type__logo);
  }

  public C_Img get_logo_img(C_Site c_site_) {
    C_Site_Img c_Site_Img = get_logo_site_img(c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getImg_t());
  }

  public C_Img get_logo_img(Session session_, C_Site c_site_) {
    C_Site_Img c_Site_Img = get_logo_site_img(session_, c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getImg_t_2(session_));
  }

  public Long get_logo_img_id(C_Site c_site_) {
    C_Site_Img c_Site_Img = get_logo_site_img(c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getC_img());
  }

  public Long get_logo_img_id(Session session_, C_Site c_site_) {
    C_Site_Img c_Site_Img = get_logo_site_img(session_, c_site_);
    return (c_Site_Img == null ? null : c_Site_Img.getC_img());
  }

}
