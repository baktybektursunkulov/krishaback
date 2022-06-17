package managers.core.dbtables;

import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.model.db.SQL_Order_Condition;
import java.util.ArrayList;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class I_Tbl_Fld_Trans_Manager extends Abstract_Controller_Manager<I_Tbl_Fld_Trans> {

  private static I_Tbl_Fld_Trans_Manager currentInstance = null;
  //private HashMap<I_Tbl_Fld_Trans_Key, I_Tbl_Fld_Trans> i_tbl_fld_trans_map = null;

  public static I_Tbl_Fld_Trans_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new I_Tbl_Fld_Trans_Manager();
    }
    return currentInstance;
  }

  public I_Tbl_Fld_Trans_Manager() {
    super(I_Tbl_Fld_Trans.class);
  }

  /*
  public HashMap<I_Tbl_Fld_Trans_Key, I_Tbl_Fld_Trans> getI_tbl_fld_trans_map_2(Session session_) {
    if (i_tbl_fld_trans_map == null) {
      refresh_i_tbl_fld_trans_map(session_);
    }
    return i_tbl_fld_trans_map;
  }
   */
 /*
  public synchronized void sync_refresh_i_tbl_fld_trans_map(Session session_) {
    if (i_tbl_fld_trans_map == null) {
      refresh_i_tbl_fld_trans_map(session_);
    }
  }
   */
 /*
  public void setI_tbl_fld_trans_map(HashMap<I_Tbl_Fld_Trans_Key, I_Tbl_Fld_Trans> i_tbl_fld_trans_map_) {
    this.i_tbl_fld_trans_map = i_tbl_fld_trans_map_;
  }
   */
  public List<I_Tbl_Fld_Trans> get_i_tbl_fld_trans_list() {
    Transaction tx = null;
    List<I_Tbl_Fld_Trans> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from I_Tbl_Fld_Trans where is_deleted=false order by i_tbl_fld_trans desc");
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

  public List<I_Tbl_Fld_Trans> get_i_tbl_fld_trans_list(SQL_Order_Condition sql_order_condition_) {
    Transaction tx = null;
    List<I_Tbl_Fld_Trans> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from I_Tbl_Fld_Trans where is_deleted=false order by " + sql_order_condition_.getField_name() + " " + sql_order_condition_.getSort_order());
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

  public static String get_tbl_fld_translation(String i_tbl_name_, Long rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_in_ru_) {
    return getCI().private_get_tbl_fld_translation(i_tbl_name_, rec_id_, i_tbl_fld_name_, c_lang_code_, translation_in_ru_);
  }

  public static String get_tbl_fld_translation(String i_tbl_name_, Integer rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_in_ru_) {
    return getCI().private_get_tbl_fld_translation(i_tbl_name_, (long) rec_id_, i_tbl_fld_name_, c_lang_code_, translation_in_ru_);
  }

  public static String get_tbl_fld_translation(Session session_, String i_tbl_name_, Long rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_in_ru_) {
    return getCI().private_get_tbl_fld_translation(session_, i_tbl_name_, rec_id_, i_tbl_fld_name_, c_lang_code_, translation_in_ru_);
  }

  public static String get_tbl_fld_translation(Session session_, String i_tbl_name_, Integer rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_in_ru_) {
    if (rec_id_ == null) {
      return "";
    }
    return getCI().private_get_tbl_fld_translation(session_, i_tbl_name_, (long) rec_id_, i_tbl_fld_name_, c_lang_code_, translation_in_ru_);
  }

  public String private_get_tbl_fld_translation(String i_tbl_name_, Long rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_in_ru_) {
    String res = "";

    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_tbl_fld_translation(session_, i_tbl_name_, rec_id_, i_tbl_fld_name_, c_lang_code_, translation_in_ru_);
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

  public String private_get_tbl_fld_translation(Session session_, String i_tbl_name_, Long rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_in_ru_) {
    String res = "";

    if (translation_in_ru_ == null) {
      translation_in_ru_ = "";
    }
    I_Tbl i_tbl_ = I_Tbl_Manager.getCI().get_rec_by_name(session_, i_tbl_name_);
    if (i_tbl_ == null) {
      I_Tbl new_i_tbl_ = new I_Tbl();
      new_i_tbl_.setName(i_tbl_name_);
      new_i_tbl_.setPk_fld_name(i_tbl_name_.toLowerCase());
      new_i_tbl_.setHas_fld_is_deleted(false);
      new_i_tbl_.setIs_deleted(false);
      I_Tbl_Manager.getCI().insert_rec(session_, new_i_tbl_);
      i_tbl_ = new_i_tbl_;
    }
    I_Tbl_Fld i_tbl_fld_ = I_Tbl_Fld_Manager.getCI().get_i_tbl_fld_2(session_, i_tbl_name_, i_tbl_fld_name_);
    if (i_tbl_fld_ == null) {
      I_Tbl_Fld new_i_tbl_fld_ = new I_Tbl_Fld();
      new_i_tbl_fld_.setI_tbl(i_tbl_.getI_tbl());
      new_i_tbl_fld_.setName(i_tbl_fld_name_);
      new_i_tbl_fld_.setIs_html_format(false);
      new_i_tbl_fld_.setIs_deleted(false);
      I_Tbl_Fld_Manager.getCI().insert_rec(session_, new_i_tbl_fld_);
      i_tbl_fld_ = new_i_tbl_fld_;
    }
    I_Tbl_Fld_Trans rec_ = get_tbl_fld_translation_rec(session_, i_tbl_.getI_tbl(), rec_id_, i_tbl_fld_.getI_tbl_fld(), c_lang_code_);
    if (rec_ != null) {
      if (c_lang_code_.equals("ru") || c_lang_code_.equals("en")) {
        if (rec_.getSource_text_hash_code() == null) {
          rec_.setSource_text_hash_code(translation_in_ru_.hashCode());
          session_.merge(rec_);
        } else {
          if (!rec_.getSource_text_hash_code().equals(translation_in_ru_.hashCode())) {
            rec_ = null;
          }
        }
      } else {
        I_Tbl_Fld_Trans en_rec_ = get_tbl_fld_translation_rec(session_, i_tbl_.getI_tbl(), rec_id_, i_tbl_fld_.getI_tbl_fld(), "en");
        if (en_rec_ != null) {
          if (en_rec_.getSource_text_hash_code() == null) {
            en_rec_.setSource_text_hash_code(translation_in_ru_.hashCode());
            session_.merge(en_rec_);
          } else {
            if (!en_rec_.getSource_text_hash_code().equals(translation_in_ru_.hashCode())) {
              rec_ = null;
            } else {
              String translation_in_en_ = en_rec_.getTranslation();
              if (rec_.getSource_text_hash_code() == null) {
                rec_.setSource_text_hash_code(translation_in_en_.hashCode());
                session_.merge(rec_);
              } else {
                if (!rec_.getSource_text_hash_code().equals(translation_in_en_.hashCode())) {
                  rec_ = null;
                }
              }
            }
          }
        } else {
          rec_ = null;
        }
      }
    }

    if (rec_ != null) {
      res = rec_.getTranslation();
      return res;
    } else {
      if (c_lang_code_.equals("ru")) {
        return translation_in_ru_;
      } else if (c_lang_code_.equals("en")) {
        if (i_tbl_fld_.getIs_html_format()) {
          res = C_Translation_Manager.translate_html_format(session_, "ru", c_lang_code_, translation_in_ru_);
        } else {
          res = C_Translation_Manager.translate_text_format(session_, "ru", c_lang_code_, translation_in_ru_);
        }
        if (res != null) {
          set_tbl_fld_translation(session_, i_tbl_name_, rec_id_, i_tbl_fld_name_, c_lang_code_, res, translation_in_ru_);
          return res;
        } else {
          return "";
        }
      } else {
        String translation_in_en_ = private_get_tbl_fld_translation(session_, i_tbl_name_, rec_id_, i_tbl_fld_name_, "en", translation_in_ru_);
        if (translation_in_en_ != null && !translation_in_en_.isEmpty()) {
          if (i_tbl_fld_.getIs_html_format()) {
            res = C_Translation_Manager.translate_html_format(session_, "en", c_lang_code_, translation_in_en_);
          } else {
            res = C_Translation_Manager.translate_text_format(session_, "en", c_lang_code_, translation_in_en_);
          }
          if (res != null) {
            set_tbl_fld_translation(session_, i_tbl_name_, rec_id_, i_tbl_fld_name_, c_lang_code_, res, translation_in_ru_);
            return res;
          } else {
            return "";
          }
        }
      }
    }

    return res;
  }


  /*
  public void refresh_i_tbl_fld_trans_map() {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      refresh_i_tbl_fld_trans_map(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }
   */
 /*
  public void refresh_i_tbl_fld_trans_map(Session session_) {
    HashMap<I_Tbl_Fld_Trans_Key, I_Tbl_Fld_Trans> i_tbl_fld_trans_map_ = new HashMap();
    Query q_ = session_.createQuery("from I_Tbl_Fld_Trans  order by i_tbl_fld_trans asc ");
    //q_.setCacheable(use_query_cache);
    List<I_Tbl_Fld_Trans> list_ = q_.list();
    I_Tbl_Fld_Trans rec_;
    I_Tbl_Fld_Trans_Key i_Tbl_Fld_Trans_Key;
    for (int i = 0; i < list_.size(); i++) {
      rec_ = list_.get(i);
      //i_Tbl_Fld_Trans_Key = new I_Tbl_Fld_Trans_Key(rec_.getI_tbl_fld_trans(), rec_.getI_tbl(), rec_.getI_tbl().getName(), rec_.getRec_id(), rec_.getI_tbl_fld(), rec_.getI_tbl_fld().getName(), rec_.getI_lang(), rec_.getI_lang().getCode(), rec_.getTranslation());
      i_Tbl_Fld_Trans_Key = new I_Tbl_Fld_Trans_Key(rec_.getI_tbl(), rec_.getRec_id(), rec_.getI_tbl_fld(), rec_.getC_lang_t_2(session_).getCode());
      //if (!i_tbl_fld_trans_map_.containsKey(i_Tbl_Fld_Trans_Key)) {
      i_tbl_fld_trans_map_.put(i_Tbl_Fld_Trans_Key, rec_);
      //}
    }

    setI_tbl_fld_trans_map(i_tbl_fld_trans_map_);
  }
   */
  public I_Tbl_Fld_Trans get_tbl_fld_translation_rec(Session session_, Integer i_tbl_id_, Long rec_id_, Integer i_tbl_fld_id_, String c_lang_code_) {
    I_Tbl_Fld_Trans res = null;

    /*
    getI_tbl_fld_trans_map_2(session_);

    I_Tbl_Fld_Trans_Key i_Tbl_Fld_Trans_Key = new I_Tbl_Fld_Trans_Key(i_tbl_id_, rec_id_, i_tbl_fld_id_, c_lang_code_);
    if (getI_tbl_fld_trans_map_2(session_).containsKey(i_Tbl_Fld_Trans_Key)) {
      res = getI_tbl_fld_trans_map_2(session_).get(i_Tbl_Fld_Trans_Key);
    }
     */
    C_Lang c_lang_ = C_Lang_Manager.getCI().get_rec_by_code_and_is_not_deleted(session_, c_lang_code_);
    Query q_ = session_.createQuery("from I_Tbl_Fld_Trans "
      + "where "
      + "  is_deleted=false "
      + "  and i_tbl=:i_tbl_id_ "
      + "  and rec_id=:rec_id_ "
      + "  and i_tbl_fld=:i_tbl_fld_id_ "
      + "  and c_lang=:c_lang_id_");
    q_.setCacheable(use_query_cache);
    q_.setInteger("i_tbl_id_", i_tbl_id_);
    q_.setLong("rec_id_", rec_id_);
    q_.setInteger("i_tbl_fld_id_", i_tbl_fld_id_);
    q_.setInteger("c_lang_id_", c_lang_.getC_lang());
    List<I_Tbl_Fld_Trans> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public I_Tbl_Fld_Trans get_tbl_fld_translation_rec(Integer i_tbl_id_, Long rec_id_, Integer i_tbl_fld_id_, String c_lang_code_) {
    I_Tbl_Fld_Trans res = null;

    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_tbl_fld_translation_rec(session_, i_tbl_id_, rec_id_, i_tbl_fld_id_, c_lang_code_);
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

  public String set_tbl_fld_translation(Session session_, I_Tbl i_tbl_, Long rec_id_, I_Tbl_Fld i_tbl_fld_, C_Lang c_lang_, String translation_, String translation_in_ru_) {
    String res = "";

    if (translation_in_ru_ == null) {
      translation_in_ru_ = "";
    }
    if (i_tbl_ == null || i_tbl_fld_ == null || c_lang_ == null) {
      //throw new Exception("set_tbl_fld_translation i_tbl_=" + i_tbl_ + ", i_tbl_fld_=" + i_tbl_fld_ + ",c_lang_=" + c_lang_);
      //CustomEmailSender.getInstance().send_email("Custom error", "set_tbl_fld_translation i_tbl_=" + i_tbl_ + ", i_tbl_fld_=" + i_tbl_fld_ + ",c_lang_=" + c_lang_);
      //throw new Exception("set_tbl_fld_translation i_tbl_=" + i_tbl_ + ", i_tbl_fld_=" + i_tbl_fld_ + ",c_lang_=" + c_lang_);
    }
    I_Tbl_Fld_Trans rec_ = get_tbl_fld_translation_rec(session_, i_tbl_.getI_tbl(), rec_id_, i_tbl_fld_.getI_tbl_fld(), c_lang_.getCode());

    Integer source_text_hash_code_;
    if (c_lang_.getCode().equals("en")) {
      source_text_hash_code_ = translation_in_ru_.hashCode();
    } else {
      I_Tbl_Fld_Trans en_rec_ = get_tbl_fld_translation_rec(session_, i_tbl_.getI_tbl(), rec_id_, i_tbl_fld_.getI_tbl_fld(), "en");
      if (en_rec_ != null) {
        String translation_in_en_ = en_rec_.getTranslation();
        source_text_hash_code_ = translation_in_en_.hashCode();
      } else {
        source_text_hash_code_ = translation_in_ru_.hashCode();
      }
    }

    if (rec_ != null) {
      rec_.setTranslation(translation_);
      rec_.setSource_text_hash_code(source_text_hash_code_);
      session_.merge(rec_);
    } else {
      rec_ = new I_Tbl_Fld_Trans();
      rec_.setI_tbl_t(i_tbl_);
      rec_.setRec_id(rec_id_);
      rec_.setI_tbl_fld_t(i_tbl_fld_);
      rec_.setC_lang_t(c_lang_);
      rec_.setTranslation(translation_);
      rec_.setSource_text_hash_code(source_text_hash_code_);
      rec_.setIs_deleted(false);
      session_.save(rec_);
    }
    //refresh_i_tbl_fld_trans_map(session_);
    return res;
  }

  public String set_tbl_fld_translation(Session session_, String i_tbl_name_, Long rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_, String translation_in_ru_) {
    String res = "";

    I_Tbl i_tbl_ = I_Tbl_Manager.getCI().get_rec_by_name(session_, i_tbl_name_);
    I_Tbl_Fld i_tbl_fld_ = I_Tbl_Fld_Manager.getCI().get_i_tbl_fld_2(session_, i_tbl_name_, i_tbl_fld_name_);
    C_Lang c_lang_ = C_Lang_Manager.getCI().get_rec_by_code(session_, c_lang_code_);
    set_tbl_fld_translation(session_, i_tbl_, rec_id_, i_tbl_fld_, c_lang_, translation_, translation_in_ru_);

    return res;
  }

  public static String get_tbl_fld_val(String i_tbl_name_, String i_tbl_pk_fld_name_, Long rec_id_, String i_tbl_fld_name_) {
    String res = "";

    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_tbl_fld_val(session_, i_tbl_name_, i_tbl_pk_fld_name_, rec_id_, i_tbl_fld_name_);
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

  public static String get_tbl_fld_val(Session session_, String i_tbl_name_, String i_tbl_pk_fld_name_, Long rec_id_, String i_tbl_fld_name_) {
    String res = "";
    if (rec_id_ == null) {
      return "";
    }

    Query q_ = session_.createQuery("select " + i_tbl_fld_name_ + " from " + i_tbl_name_ + " "
      + "where "
      + "  is_deleted=false "
      + "  and cast(" + i_tbl_pk_fld_name_ + " as integer)=:rec_id_ "
    );
    //q_.setCacheable(use_query_cache);
    q_.setLong("rec_id_", rec_id_);
    List list_ = q_.list();
    if (list_.size() > 0) {
      res = String.valueOf(list_.get(0));
    }
    return res;
  }

  public List<I_Tbl_Fld_Trans> get_i_tbl_fld_trans_list_for_mass_add(I_Tbl i_tbl_, I_Tbl_Fld i_tbl_fld_, C_Lang c_lang_) {
    Transaction tx = null;
    List<I_Tbl_Fld_Trans> res = new ArrayList<I_Tbl_Fld_Trans>();
    I_Tbl_Fld_Trans rec_;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("select " + i_tbl_.getPk_fld_name() + " from " + i_tbl_.getName() + " where is_deleted=false order by " + i_tbl_.getPk_fld_name());
      //q_.setCacheable(use_query_cache);
      List list_ = q_.list();
      String translation_in_ru_;
      Long rec_id_;
      for (int i = 0; i < list_.size(); i++) {
        rec_id_ = (Long) list_.get(i);
        rec_ = new I_Tbl_Fld_Trans();
        rec_.setRec_id(rec_id_);
        rec_.setC_lang_t(c_lang_);
        rec_.setI_tbl_t(i_tbl_);
        rec_.setI_tbl_fld_t(i_tbl_fld_);
        translation_in_ru_ = I_Tbl_Fld_Trans_Manager.get_tbl_fld_val(session_, i_tbl_.getName(), i_tbl_.getPk_fld_name(), rec_id_, i_tbl_fld_.getName());
        rec_.setTranslation(get_tbl_fld_translation(session_, i_tbl_.getName(), rec_id_, i_tbl_fld_.getName(), c_lang_.getCode(), translation_in_ru_));
        rec_.setI_tbl_fld_val(get_tbl_fld_val(session_, i_tbl_.getName(), i_tbl_.getPk_fld_name(), rec_id_, i_tbl_fld_.getName()));
        rec_.setI_tbl_fld_trans(i);
        rec_.setIs_deleted(false);
        res.add(rec_);
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

  public List<Long> get_available_rec_id_list(I_Tbl i_tbl_, I_Tbl_Fld i_tbl_fld_, C_Lang c_lang_) {
    Transaction tx = null;
    List<Long> res = new ArrayList();
    Long rec_id_;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("select " + i_tbl_.getPk_fld_name() + " from " + i_tbl_.getName() + " order by " + i_tbl_.getPk_fld_name());
      //q_.setCacheable(use_query_cache);
      List list_ = q_.list();
      I_Tbl_Fld_Trans i_tbl_fld_trans_;
      for (int i = 0; i < list_.size(); i++) {
        rec_id_ = (Long) list_.get(i);
        i_tbl_fld_trans_ = get_tbl_fld_translation_rec(session_, i_tbl_.getI_tbl(), rec_id_, i_tbl_fld_.getI_tbl_fld(), c_lang_.getCode());
        if (i_tbl_fld_trans_ == null) {
          res.add(rec_id_);
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
    return res;
  }

  public List<Long> get_all_rec_id_list(I_Tbl i_tbl_, I_Tbl_Fld i_tbl_fld_, C_Lang c_lang_) {
    Transaction tx = null;
    List<Long> res = new ArrayList();
    Long rec_id_;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("select " + i_tbl_.getPk_fld_name() + " from " + i_tbl_.getName() + " order by " + i_tbl_.getPk_fld_name());
      //q_.setCacheable(use_query_cache);
      List list_ = q_.list();
      for (int i = 0; i < list_.size(); i++) {
        rec_id_ = (Long) list_.get(i);
        res.add(rec_id_);
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

  public String get_translation_sql(Integer i_tbl_id_, Integer i_tbl_fld_id_, Integer c_lang_id_, String rec_id_alias_) {
    String res = "select tft.translation from I_Tbl_Fld_Trans tft where tft.is_deleted=false and tft.i_tbl=" + i_tbl_id_.toString() + " "
      + "  and tft.rec_id=" + rec_id_alias_ + " "
      + "  and tft.i_tbl_fld=" + i_tbl_fld_id_.toString() + " "
      + "  and tft.c_lang=" + c_lang_id_.toString();
    return res;
  }
}
