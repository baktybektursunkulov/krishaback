package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import gs.common.jsf.jsf_funcs;
import java.util.*;
import java.text.*;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ApplicationScoped
public class C_System_Version_Manager extends Abstract_Controller_Manager<C_System_Version> {

  private static C_System_Version_Manager currentInstance = null;

  public static C_System_Version_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_System_Version_Manager();
    }
    return currentInstance;
  }

  public C_System_Version_Manager() {
    super(C_System_Version.class);
  }

 public C_System_Version get_current_system_version(Session session_) {
    C_System_Version res = null;
    Query q_ = session_.createQuery("from C_System_Version where is_deleted=false and is_published = true order by major_version desc, minor_version desc ");
  //q_.setCacheable(use_query_cache);
    q_.setMaxResults(1);
    List<C_System_Version> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public C_System_Version get_current_system_version() {
    Transaction tx = null;
    C_System_Version res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_current_system_version(session_);
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
  
  public Integer get_system_max_major_version() {
    Transaction tx = null;
    Integer res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("select max(major_version) from C_System_Version where is_deleted=false ");
    //q_.setCacheable(use_query_cache);
      List<Integer> list_ = q_.list();
      if (list_.size() > 0) {
        res = list_.get(0);
      }
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

  public Integer get_system_max_minor_version(int major_version_) {
    Transaction tx = null;
    Integer res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("select max(minor_version) from C_System_Version where is_deleted=false and major_version=:major_version_ ");
    //q_.setCacheable(use_query_cache);
      q_.setInteger("major_version_", major_version_);
      List<Integer> list_ = q_.list();
      if (list_.size() > 0) {
        res = list_.get(0);
      }
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
  
  public List<C_System_Version> get_published_unsent_system_version_list() {
    Transaction tx = null;
    List<C_System_Version> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_System_Version where is_deleted=false and is_published = true and is_sent_to_subscribed_users = false order by major_version asc, minor_version asc");
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
  
  public String getFilledText(String text_) {
    C_Site c_site_ = C_Site_Manager.get_current_c_site();
    return getFilledText(c_site_, text_);
  }

  public String getFilledText(C_Site c_site_, String text_) {
    String res = null;
    HttpServletRequest request_ = jsf_funcs.getRequest();
    res = getFilledText(c_site_, request_, text_);
    return res;
  }

  public String getFilledText(C_Site c_site_, HttpServletRequest request_, String text_) {
    String res = text_;
    res = res.replace("%title%", c_site_.getTitle());
    res = res.replace("%copyright_text%", c_site_.getCopyright_text());
    res = res.replace("%copyright_url%", c_site_.getCopyright_url());
    res = res.replace("%domain%", c_site_.getDomain());
    if (request_ != null) {
      String host_ = request_.getServerName();
      if (request_.getServerPort() != 80 && request_.getServerPort() != 443) {
        host_ = host_ + ":" + request_.getServerPort();
      }
      res = res.replace("%host%", host_);
    }
    //res = res.replace("%title%", v3_site_.getTitle());
    return res;
  }  
}
