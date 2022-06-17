package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import java.io.Serializable;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class I_Tbl_Fld_Trans_Multi_Manager implements Serializable {

  private static I_Tbl_Fld_Trans_Multi_Manager currentInstance = null;
  //private HashMap<I_Tbl_Fld_Trans_Key, I_Tbl_Fld_Trans> i_tbl_fld_trans_map = null;

  public static I_Tbl_Fld_Trans_Multi_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new I_Tbl_Fld_Trans_Multi_Manager();
    }
    return currentInstance;
  }

  public String multi_private_get_tbl_fld_translation(Session session_, String i_tbl_name_, Long rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_in_another_lang_, String another_lang_code_) {
    String res = "";

    if (translation_in_another_lang_ == null) {
      translation_in_another_lang_ = "";
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
    I_Tbl_Fld_Trans rec_ = I_Tbl_Fld_Trans_Manager.getCI().get_tbl_fld_translation_rec(session_, i_tbl_.getI_tbl(), rec_id_, i_tbl_fld_.getI_tbl_fld(), c_lang_code_);
    if (rec_ != null) {
      if (c_lang_code_.equals("ru") || c_lang_code_.equals("en")) {
        if (rec_.getSource_text_hash_code() == null) {
          rec_.setSource_text_hash_code(translation_in_another_lang_.hashCode());
          session_.merge(rec_);
        } else {
          if (!rec_.getSource_text_hash_code().equals(translation_in_another_lang_.hashCode())) {
            rec_ = null;
          }
        }
      } else {
        I_Tbl_Fld_Trans en_rec_ = I_Tbl_Fld_Trans_Manager.getCI().get_tbl_fld_translation_rec(session_, i_tbl_.getI_tbl(), rec_id_, i_tbl_fld_.getI_tbl_fld(), "en");
        if (en_rec_ != null) {
          if (en_rec_.getSource_text_hash_code() == null) {
            en_rec_.setSource_text_hash_code(translation_in_another_lang_.hashCode());
            session_.merge(en_rec_);
          } else {
            if (!en_rec_.getSource_text_hash_code().equals(translation_in_another_lang_.hashCode())) {
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
      if (c_lang_code_.equals(another_lang_code_)) {
        return translation_in_another_lang_;
      } else if (c_lang_code_.equals("en")) {
        if (i_tbl_fld_.getIs_html_format()) {
          res = C_Translation_Manager.translate_html_format(session_, another_lang_code_, c_lang_code_, translation_in_another_lang_);
        } else {
          res = C_Translation_Manager.translate_text_format(session_, another_lang_code_, c_lang_code_, translation_in_another_lang_);
        }
        if (res != null) {
          multi_set_tbl_fld_translation(session_, i_tbl_name_, rec_id_, i_tbl_fld_name_, c_lang_code_, res, translation_in_another_lang_, another_lang_code_);
          return res;
        } else {
          return "";
        }
      } else {
        String translation_in_en_ = multi_private_get_tbl_fld_translation(session_, i_tbl_name_, rec_id_, i_tbl_fld_name_, "en", translation_in_another_lang_, another_lang_code_);
        if (translation_in_en_ != null && !translation_in_en_.isEmpty()) {
          if (i_tbl_fld_.getIs_html_format()) {
            res = C_Translation_Manager.translate_html_format(session_, "en", c_lang_code_, translation_in_en_);
          } else {
            res = C_Translation_Manager.translate_text_format(session_, "en", c_lang_code_, translation_in_en_);
          }
          if (res != null) {
            multi_set_tbl_fld_translation(session_, i_tbl_name_, rec_id_, i_tbl_fld_name_, c_lang_code_, res, translation_in_another_lang_, another_lang_code_);
            return res;
          } else {
            return "";
          }
        }
      }
    }

    return res;
  }

  public String multi_set_tbl_fld_translation(Session session_, I_Tbl i_tbl_, Long rec_id_, I_Tbl_Fld i_tbl_fld_, C_Lang c_lang_, String translation_, String translation_in_another_lang_, String another_lang_code_) {
    String res = "";

    if (translation_in_another_lang_ == null) {
      translation_in_another_lang_ = "";
    }
    if (i_tbl_ == null || i_tbl_fld_ == null || c_lang_ == null) {
      //throw new Exception("set_tbl_fld_translation i_tbl_=" + i_tbl_ + ", i_tbl_fld_=" + i_tbl_fld_ + ",c_lang_=" + c_lang_);
      //CustomEmailSender.getInstance().send_email("Custom error", "set_tbl_fld_translation i_tbl_=" + i_tbl_ + ", i_tbl_fld_=" + i_tbl_fld_ + ",c_lang_=" + c_lang_);
      //throw new Exception("set_tbl_fld_translation i_tbl_=" + i_tbl_ + ", i_tbl_fld_=" + i_tbl_fld_ + ",c_lang_=" + c_lang_);
    }
    I_Tbl_Fld_Trans rec_ = I_Tbl_Fld_Trans_Manager.getCI().get_tbl_fld_translation_rec(session_, i_tbl_.getI_tbl(), rec_id_, i_tbl_fld_.getI_tbl_fld(), c_lang_.getCode());

    Integer source_text_hash_code_;
    if (c_lang_.getCode().equals("en")) {
      source_text_hash_code_ = translation_in_another_lang_.hashCode();
    } else {
      I_Tbl_Fld_Trans en_rec_ = I_Tbl_Fld_Trans_Manager.getCI().get_tbl_fld_translation_rec(session_, i_tbl_.getI_tbl(), rec_id_, i_tbl_fld_.getI_tbl_fld(), "en");
      if (en_rec_ != null) {
        String translation_in_en_ = en_rec_.getTranslation();
        source_text_hash_code_ = translation_in_en_.hashCode();
      } else {
        source_text_hash_code_ = translation_in_another_lang_.hashCode();
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

  public String multi_set_tbl_fld_translation(Session session_, String i_tbl_name_, Long rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_, String translation_in_another_lang_, String another_lang_code_) {
    String res = "";

    I_Tbl i_tbl_ = I_Tbl_Manager.getCI().get_rec_by_name(session_, i_tbl_name_);
    I_Tbl_Fld i_tbl_fld_ = I_Tbl_Fld_Manager.getCI().get_i_tbl_fld_2(session_, i_tbl_name_, i_tbl_fld_name_);
    C_Lang c_lang_ = C_Lang_Manager.getCI().get_rec_by_code(session_, c_lang_code_);
    multi_set_tbl_fld_translation(session_, i_tbl_, rec_id_, i_tbl_fld_, c_lang_, translation_, translation_in_another_lang_, another_lang_code_);

    return res;
  }

  public static String multi_get_tbl_fld_translation(Session session_, String i_tbl_name_, Long rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_in_another_lang_, String another_lang_code_) {
    return getCI().multi_private_get_tbl_fld_translation(session_, i_tbl_name_, rec_id_, i_tbl_fld_name_, c_lang_code_, translation_in_another_lang_, another_lang_code_);
  }

  public static String multi_get_tbl_fld_translation(Session session_, String i_tbl_name_, Integer rec_id_, String i_tbl_fld_name_, String c_lang_code_, String translation_in_another_lang_, String another_lang_code_) {
    return getCI().multi_private_get_tbl_fld_translation(session_, i_tbl_name_, (long)rec_id_, i_tbl_fld_name_, c_lang_code_, translation_in_another_lang_, another_lang_code_);
  }

}
