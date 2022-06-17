package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.servlet.servlet_funcs;
import java.util.*;
import java.text.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ManagedBean
@ApplicationScoped
public class C_Session_Manager extends Abstract_Controller_Manager<C_Session> {

  private static C_Session_Manager currentInstance = null;

  public static C_Session_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Session_Manager();
    }
    return currentInstance;
  }

  public C_Session_Manager() {
    super(C_Session.class);
  }

  public C_Session ins_row(Integer c_session_type_id_) {
    C_Session res = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = ins_row(session_, c_session_type_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Session ins_row(Session session_, Integer c_session_type_id_) {
    C_Session rec_ = new C_Session();
    rec_.setC_session_type(c_session_type_id_);
    rec_.setSession_id(java.util.UUID.randomUUID().toString());
    rec_.setIns_dt(new Date());
    rec_.setIs_deleted(false);
    session_.save(rec_);
    return rec_;
  }

  public C_Session get_row(Session session_, Integer c_session_type_id_, String session_id_) {
    Query q_ = session_.createQuery("from C_Session t where t.is_deleted=false and t.c_session_type=:c_session_type_id_ and t.session_id=:session_id_ order by 1 asc");
    q_.setInteger("c_session_type_id_", c_session_type_id_);
    q_.setString("session_id_", session_id_);
    q_.setMaxResults(1);
    List<C_Session> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public static void main(String[] params) {
    System.out.println(java.util.UUID.randomUUID());
  }

  public C_Session get_c_session_from_browser_cookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    C_Session res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_c_session_from_browser_cookie(session_, httpServletRequest, httpServletResponse);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Session get_c_session_from_browser_cookie(Session session_, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    C_Session res;
    String cookie_session_id_ = servlet_funcs.getCookieValue(httpServletRequest, "session_id");
    if (cookie_session_id_ == null || cookie_session_id_.trim().isEmpty()) {
      res = C_Session_Manager.getCI().ins_row(session_, C_Session_Type_Manager.c_session_type_id__web);
      servlet_funcs.setCookieValue(httpServletResponse, "session_id", res.getSession_id(), "/", 60 * 60 * 24 * 365 * 10);
    } else {
      res = C_Session_Manager.getCI().get_row(session_, C_Session_Type_Manager.c_session_type_id__web, cookie_session_id_);
      if (res == null) {
        res = C_Session_Manager.getCI().ins_row(session_, C_Session_Type_Manager.c_session_type_id__web);
      }
    }
    return res;
  }
}
