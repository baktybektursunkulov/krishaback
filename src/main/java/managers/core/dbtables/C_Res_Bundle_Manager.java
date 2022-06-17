package managers.core.dbtables;

import gs.common.hibernate_funcs;
import gs.common.json_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.model.db.SQL_Order_Condition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Res_Bundle_Manager extends Abstract_Controller_Manager<C_Res_Bundle> {

  private static C_Res_Bundle_Manager currentInstance = null;

  public static Map<String, Object[][]> c_res_bundle_map = null;

  public static C_Res_Bundle_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Res_Bundle_Manager();
    }
    return currentInstance;
  }

  public C_Res_Bundle_Manager() {
    super(C_Res_Bundle.class);
  }

  public static void initialize() {
    if (c_res_bundle_map == null) {
      refresh_c_res_bundle_map();
    }
  }

  public static void refresh_c_res_bundle_map() {
    Map<String, Object[][]> temp_c_res_bundle_map_ = new HashMap();
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      C_Res_Bundle_Base c_res_bundle_base_;
      C_Lang c_lang_;
      List<C_Res_Bundle_Base> c_res_bundle_base_list_ = C_Res_Bundle_Base_Manager.getCI().get_rec_list_2_1(session_, new SQL_Order_Condition("1", "asc"));
      List<C_Lang> c_lang_list_ = C_Lang_Manager.getCI().get_c_lang_list(session_);
      List<C_Res_Bundle> c_res_bundle_list_;
      Object[][] res;
      for (int k = 0; k < c_res_bundle_base_list_.size(); k++) {
        c_res_bundle_base_ = c_res_bundle_base_list_.get(k);
        for (int i = 0; i < c_lang_list_.size(); i++) {          
          if (i > 0) {// Только русский подгружать
            continue;
          }
          c_lang_ = c_lang_list_.get(i);
          c_res_bundle_list_ = C_Res_Bundle_Manager.getCI().get_custom_rec_list(session_, c_res_bundle_base_.getName(), c_lang_.getCode());
          res = new Object[c_res_bundle_list_.size()][2];
          for (int j = 0; j < c_res_bundle_list_.size(); j++) {
            res[j] = new Object[]{c_res_bundle_list_.get(j).getKey(), c_res_bundle_list_.get(j).getVal()};
          }
          temp_c_res_bundle_map_.put(c_res_bundle_base_.getName() + "_" + c_lang_.getCode(), res);
        }
      }
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    c_res_bundle_map = temp_c_res_bundle_map_;
  }

  public static void check_all_translations() {
    //Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      check_all_translations(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (session_.getTransaction() != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public static void check_all_translations(Session session_) {
    C_Res_Bundle_Base c_res_bundle_base_;
    C_Lang c_lang_;
    List<C_Res_Bundle_Base> c_res_bundle_base_list_ = C_Res_Bundle_Base_Manager.getCI().get_rec_list_ordered_by_id_asc(session_);
    List<C_Lang> c_lang_list_ = C_Lang_Manager.getCI().get_rec_list_ordered_by_id_asc(session_);
    List<C_Res_Bundle> from_c_res_bundle_list_ = new ArrayList();
    List<C_Res_Bundle> c_res_bundle_list_;
    //Map<String, String> rus_c_res_bundle_map_;
    Map<String, C_Res_Bundle> c_res_bundle_map_;
    C_Res_Bundle from_c_res_bundle_, c_res_bundle_;
    String translation_;
    for (int k = 0; k < c_res_bundle_base_list_.size(); k++) {
      c_res_bundle_base_ = c_res_bundle_base_list_.get(k);

      for (int i = 0; i < c_lang_list_.size(); i++) {
        c_lang_ = c_lang_list_.get(i);
        if (c_lang_.getCode().equals("ru")) {
          continue;
        }
        if (c_lang_.getCode().equals("en")) {
          from_c_res_bundle_list_ = C_Res_Bundle_Manager.getCI().get_custom_rec_list(session_, c_res_bundle_base_.getName(), "ru");
        } else {
          from_c_res_bundle_list_ = C_Res_Bundle_Manager.getCI().get_custom_rec_list(session_, c_res_bundle_base_.getName(), "en");
        }

        c_res_bundle_list_ = C_Res_Bundle_Manager.getCI().get_custom_rec_list(session_, c_res_bundle_base_.getName(), c_lang_.getCode());
        c_res_bundle_map_ = new HashMap();
        for (int l = 0; l < c_res_bundle_list_.size(); l++) {
          c_res_bundle_map_.put(c_res_bundle_list_.get(l).getKey(), c_res_bundle_list_.get(l));
        }
        for (int l = 0; l < from_c_res_bundle_list_.size(); l++) {
          from_c_res_bundle_ = from_c_res_bundle_list_.get(l);
          if (c_res_bundle_map_.containsKey(from_c_res_bundle_.getKey())) {
            c_res_bundle_ = c_res_bundle_map_.get(from_c_res_bundle_.getKey());
            if (c_res_bundle_.getSource_text_hash_code() == null) {
              c_res_bundle_.setSource_text_hash_code(from_c_res_bundle_.getVal().hashCode());
              session_.merge(c_res_bundle_);
            } else if (!c_res_bundle_.getSource_text_hash_code().equals(from_c_res_bundle_.getVal().hashCode())) {
              translation_ = C_Translation_Manager.translate_text_format(session_, from_c_res_bundle_.getC_lang_t_2(session_).getCode(), c_lang_.getCode(), from_c_res_bundle_.getVal());
              if (translation_ != null) {
                c_res_bundle_.setVal(translation_);
                c_res_bundle_.setSource_text_hash_code(from_c_res_bundle_.getVal().hashCode());
                session_.merge(c_res_bundle_);
              }
            }
          } else {
            translation_ = C_Translation_Manager.translate_text_format(session_, from_c_res_bundle_.getC_lang_t_2(session_).getCode(), c_lang_.getCode(), from_c_res_bundle_.getVal());
            if (translation_ != null) {
              c_res_bundle_ = new C_Res_Bundle();
              c_res_bundle_.setC_lang_t(c_lang_);
              c_res_bundle_.setC_res_bundle_base_t(c_res_bundle_base_);
              c_res_bundle_.setKey(from_c_res_bundle_.getKey());
              c_res_bundle_.setVal(translation_);
              c_res_bundle_.setSource_text_hash_code(from_c_res_bundle_.getVal().hashCode());
              c_res_bundle_.setIs_deleted(false);
              session_.save(c_res_bundle_);
            }
          }
          hibernate_funcs.commit(session_);
          session_.getTransaction().begin();
        }
      }
    }
  }

  public List<C_Res_Bundle> get_custom_rec_list(Session session_, String base_name_, String lang_) {
    List<C_Res_Bundle> res;
    C_Res_Bundle_Base c_Res_Bundle_Base = C_Res_Bundle_Base_Manager.getCI().get_rec_by_name(session_, base_name_);
    C_Lang c_Lang = C_Lang_Manager.getCI().get_rec_by_code(session_, lang_);
    Query q_ = session_.createQuery("from C_Res_Bundle where is_deleted=false and c_res_bundle_base=:c_res_bundle_base_id_ and c_lang=:c_lang_id_");
    q_.setInteger("c_res_bundle_base_id_", c_Res_Bundle_Base.getC_res_bundle_base());
    q_.setInteger("c_lang_id_", c_Lang == null ? -1 : c_Lang.getC_lang());
    //q_.setCacheable(use_query_cache);
    res = q_.list();
    return res;
  }

  public List<C_Res_Bundle> get_custom_rec_list(String base_name_, String lang_) {
    List<C_Res_Bundle> res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_custom_rec_list(session_, base_name_, lang_);
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

  public static JSONObject get_json_object_for_i18n(String base_name_, String lang_) {
    JSONObject res = new JSONObject();
    if (C_Res_Bundle_Manager.c_res_bundle_map == null) {
      return res;
    }
    Object[][] obj_arr_ = C_Res_Bundle_Manager.c_res_bundle_map.get(base_name_ + "_" + lang_);
    if (obj_arr_ == null) {
      return res;
    }
    Object[] obj_;
    for (int i = 0; i < obj_arr_.length; i++) {
      obj_ = obj_arr_[i];
      json_funcs.silent_put(res, (String) obj_[0], (String) obj_[1]);
    }
    return res;
  }
}
