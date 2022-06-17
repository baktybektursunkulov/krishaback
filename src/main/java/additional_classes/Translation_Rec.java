package additional_classes;

import beans.ApplicationBean;
import beans.LocaleBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managers.core.dbtables.I_Tbl_Fld_Trans_Manager;
import model.core.dbtables.C_Lang;
import org.hibernate.Session;
public class Translation_Rec implements Serializable {

  private Map<String, String> translated_map = new HashMap();
  private String old_translation_lang;
  private String translation_lang = LocaleBean.getCurrentBean().getLanguageTag();
  private String translation;

  public Map<String, String> getTranslated_map() {
    return translated_map;
  }

  public void setTranslated_map(Map<String, String> translated_map) {
    this.translated_map = translated_map;
  }

  public String getOld_translation_lang() {
    return old_translation_lang;
  }

  public void setOld_translation_lang(String old_translation_lang) {
    this.old_translation_lang = old_translation_lang;
  }

  public String getTranslation_lang() {
    return translation_lang;
  }

  public void setTranslation_lang(String translation_lang) {
    this.translation_lang = translation_lang;
  }

  public String getTranslation() {
    return translation;
  }

  public void setTranslation(String translation) {
    translated_map.put(getOld_translation_lang(), translation);
    setOld_translation_lang(getTranslation_lang());
    this.translation = translated_map.get(getTranslation_lang());
  }

  public void afterLoadDefaultAndLoadRecForCusTblFld(Session session_, String mode_, String translation_in_ru_, String tbl_name_, Integer rec_id_, String tbl_fld_name_) throws Exception {
    this.setTranslated_map(new HashMap());
    String lang_;
    List<C_Lang> c_lang_list_ = ApplicationBean.getCurrentBean().getSupported_c_lang_list_2(session_);
    for (int i = 0; i < c_lang_list_.size(); i++) {
      lang_ = c_lang_list_.get(i).getCode();
      if (mode_.equals("add")) {
        this.getTranslated_map().put(lang_, "");
      } else {
        if (lang_.equals("ru")) {
          this.getTranslated_map().put(lang_, translation_in_ru_);
        } else {
          this.getTranslated_map().put(lang_, I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, tbl_name_, rec_id_, tbl_fld_name_, lang_, translation_in_ru_));
        }
      }
    }
    this.setTranslation_lang(LocaleBean.getCurrentBean().getLanguageTag());
    this.setOld_translation_lang(this.getTranslation_lang());
    this.setTranslation(this.getTranslated_map().get(this.getTranslation_lang()));

  }

}
