package managers.core.dbtables;

import virtualentities.VE_I_Tbl_Row;
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
import java.util.*;
import java.text.*;
import java.util.concurrent.ConcurrentHashMap;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

@ManagedBean
@ApplicationScoped
public class I_Tbl_Manager extends Abstract_Controller_Manager<I_Tbl> {

  private static I_Tbl_Manager currentInstance = null;
  private ConcurrentHashMap<String, I_Tbl> map = new ConcurrentHashMap();

  public static I_Tbl_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new I_Tbl_Manager();
    }
    return currentInstance;
  }

  public I_Tbl_Manager() {
    super(I_Tbl.class);
  }

  public List<I_Tbl> get_i_tbl_list() {
    Transaction tx = null;
    List<I_Tbl> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from I_Tbl where is_deleted=false order by i_tbl desc");
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

  public List<I_Tbl> get_i_tbl_list_sorted_by_name() {
    Transaction tx = null;
    List<I_Tbl> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from I_Tbl where is_deleted=false order by name asc");
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

  public List<VE_I_Tbl_Row> get_row_list(Session session_, Integer i_tbl_id_, Integer i_tbl_fld_id_) {
    I_Tbl i_Tbl = I_Tbl_Manager.getCI().get_rec(session_, i_tbl_id_);
    I_Tbl_Fld i_Tbl_Fld = I_Tbl_Fld_Manager.getCI().get_rec(session_, i_tbl_fld_id_);

    Query q_ = session_.createSQLQuery("select cast(t." + i_Tbl.getPk_fld_name() + " as text) as id, t." + i_Tbl_Fld.getName() + " as label from " + i_Tbl.getName() + " t "
      + (i_Tbl.getHas_fld_is_deleted() ? " where t.is_deleted=false " : " ")
      + " order by t." + i_Tbl_Fld.getName() + " asc ").addScalar("id", new StringType()).addScalar("label", new StringType()).setResultTransformer(Transformers.aliasToBean(VE_I_Tbl_Row.class));
    List<VE_I_Tbl_Row> list_ = q_.list();
    return list_;
  }

  public I_Tbl get_row_by_name_with_ins_if_not_exists(Session session_, String name_) {
    I_Tbl res;
    res = I_Tbl_Manager.getCI().get_rec_by_name(session_, name_);
    if (res == null) {
      res = new I_Tbl();
      res.setName(name_);
      res.setPk_fld_name(name_.toLowerCase());
      res.setHas_fld_is_deleted(false);      
      I_Tbl_Manager.getCI().insert_rec(session_, res);
    }    
    return res;
  }
  
  public I_Tbl get_row_ignore_case(Session session_, String name_) {
    String key_ = name_.toLowerCase();
    if (map.contains(key_)) {
      return map.get(key_);
    } else {
      I_Tbl i_Tbl = I_Tbl_Manager.getCI().get_rec_by_name_with_trim_and_lower(session_, name_);
      map.put(key_, i_Tbl);
      return i_Tbl;
    }
  }
  
  public I_Tbl get_row_ignore_case(String name_) {
    I_Tbl res;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row_ignore_case(session_, name_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
}
