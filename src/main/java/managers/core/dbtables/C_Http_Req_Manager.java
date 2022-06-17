package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Http_Req_Manager extends Abstract_Controller_Manager<C_Http_Req> {

  private static C_Http_Req_Manager currentInstance = null;

  public static C_Http_Req_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Http_Req_Manager();
    }
    return currentInstance;
  }

  public C_Http_Req_Manager() {
    super(C_Http_Req.class);
  }

  public C_Http_Req ins_out_http_req_row(Integer c_http_req_type_id_, String req_url_) {
    C_Http_Req res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = ins_out_http_req_row(session_, c_http_req_type_id_, req_url_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
  public C_Http_Req ins_out_http_req_row(Session session_, Integer c_http_req_type_id_, String req_url_) {
    return C_Http_Req_Manager.getCI().ins_row(session_, c_http_req_type_id_, req_url_, "", "", "", "", null, false);    
  }
  
  
  public C_Http_Req ins_out_http_req_row(Integer c_http_req_type_id_, String req_url_, String res_body_) {
    C_Http_Req res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = ins_out_http_req_row(session_, c_http_req_type_id_, req_url_, res_body_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Http_Req ins_out_http_req_row(Session session_, Integer c_http_req_type_id_, String req_url_, String res_body_) {
    return C_Http_Req_Manager.getCI().ins_row(session_, c_http_req_type_id_, req_url_, "", "", "", res_body_, null, false);    
  }

  public C_Http_Req ins_row(Integer c_http_req_type_id_, String req_url_, String req_body_, String req_params_, String req_headers_,
    String res_body_, Integer res_code_, Boolean is_in_req_) {
    C_Http_Req res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = ins_row(session_, c_http_req_type_id_, req_url_, req_body_, req_params_, req_headers_, res_body_, res_code_, is_in_req_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Http_Req ins_row(Session session_, Integer c_http_req_type_id_, String req_url_, String req_body_, String req_params_, String req_headers_,
    String res_body_, Integer res_code_, Boolean is_in_req_) {
    C_Http_Req res = new C_Http_Req();
    res.setC_http_req_type(c_http_req_type_id_);
    res.setReq_url(req_url_);
    res.setReq_body(req_body_);
    res.setReq_params(req_params_);
    res.setRes_body(res_body_);
    res.setRes_code(res_code_);
    res.setIs_in_req(is_in_req_);
    res.setIns_dt(new Date());
    res.setIs_deleted(false);
    session_.save(res);
    return res;
  }

}
