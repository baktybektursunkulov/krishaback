package managers.core.dbtables;

import additional_classes.core.comparators.C_Lang_Comparator;
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
public class C_Proj_Lang_Manager extends Abstract_Controller_Manager<C_Proj_Lang> {

  private static C_Proj_Lang_Manager currentInstance = null;

  public static C_Proj_Lang_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Proj_Lang_Manager();
    }
    return currentInstance;
  }

  public C_Proj_Lang_Manager() {
    super(C_Proj_Lang.class);
  }

  public List<C_Lang> get_avail_c_lang_list(Session session_, Integer c_proj_id_) {
    List<C_Lang> res = null;
    if (c_proj_id_ == null) {
      return null;
    }
    Query q_ = session_.createSQLQuery("select * from C_Lang t where t.is_deleted=false and not exists ("
      + "select 1 from C_Proj_Lang t2 "
      + "where "
      + "  t2.is_deleted=false "
      + "  and t2.c_proj=:c_proj_id_ "
      + "  and t2.c_lang=t.c_lang "
//      + "  and t2.is_deleted=false "
      + ") order by t.name ").addEntity(C_Lang.class);
    q_.setInteger("c_proj_id_", c_proj_id_);
    res = q_.list();
    return res;
  }

  public List<C_Lang> get_avail_c_lang_list(Integer c_proj_id_) {
    List<C_Lang> res = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_avail_c_lang_list(session_, c_proj_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }  
  
  public C_Proj_Lang get_unique_rec(Session session_, Integer c_proj_id_,
    Integer c_lang_id_, Integer exclude_id_) {
    Query q_ = session_.createQuery("from C_Proj_Lang where "
      + "  t.is_deleted=false "
      + "  and c_proj=:c_proj_id_ "
      + "  and c_lang=:c_lang_id_ "
      + (exclude_id_ == null ? "" : " and c_proj_lang<>:exclude_id_")
//      + " and is_deleted=false "
    );
    q_.setInteger("c_proj_id_", c_proj_id_);
    q_.setInteger("c_lang_id_", c_lang_id_);
    if (exclude_id_ != null) {
      q_.setInteger("exclude_id_", exclude_id_);
    }
    List<C_Proj_Lang> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }

  public String get_unique_violation_exception_string(Session session_, C_Proj_Lang rec_) {
    return "(" + rec_.getC_proj_t_2(session_).getName() + ", " + rec_.getC_lang_t_2(session_).getName() + ")";
  }
 
  public List<C_Lang> get_proj_lang_list(Session session_, Integer c_proj_id_) {
    Query q_ = session_.createQuery("select l from C_Proj_Lang t, C_Lang l where t.is_deleted=false and t.c_lang = l.c_lang and t.c_proj=:c_proj_id_ and l.is_deleted=false order by l.code");
    q_.setInteger("c_proj_id_", c_proj_id_);
    List<C_Lang> list_ = q_.list();
    return list_;
  }
  
  
  public List<C_Lang> get_c_lang_list_for_select(Integer c_proj_id_, String lang_) throws Exception {
    List<C_Lang> res = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_c_lang_list_for_select_2(session_, c_proj_id_, lang_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public List<C_Lang> get_c_lang_list_for_select_2(Session session_, Integer c_proj_id_, String lang_) throws Exception {
    List<C_Lang> res = get_proj_lang_list(session_, c_proj_id_);
    for (int i = 0; i < res.size(); i++) {
      res.get(i).getName_translation_3(session_, lang_);
    }
    res.sort(new C_Lang_Comparator());
    return res;
  }
  
}
