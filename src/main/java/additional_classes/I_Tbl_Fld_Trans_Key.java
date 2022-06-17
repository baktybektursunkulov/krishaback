package additional_classes;

import java.io.Serializable;
import java.util.Objects;

public class I_Tbl_Fld_Trans_Key implements Serializable {

  //private Integer i_tbl_fld_trans;
  //private I_Tbl i_tbl;
  private Integer i_tbl_id;
  private Integer rec_id;
  //private I_Tbl_Fld i_tbl_fld;
  private Integer i_tbl_fld_id;
  //private I_Lang i_lang;
  private String i_lang_code;
  //private String translation;

  public I_Tbl_Fld_Trans_Key() {

  }

  /*
  public I_Tbl_Fld_Trans_Key(Integer i_tbl_fld_trans, I_Tbl i_tbl, String i_tbl_name, String rec_id, I_Tbl_Fld i_tbl_fld, String i_tbl_fld_name, I_Lang i_lang, String i_lang_code, String translation) {
    this.i_tbl_fld_trans = i_tbl_fld_trans;
    this.i_tbl = i_tbl;
    this.i_tbl_name = i_tbl_name;
    this.rec_id = rec_id;
    this.i_tbl_fld = i_tbl_fld;
    this.i_tbl_fld_name = i_tbl_fld_name;
    this.i_lang = i_lang;
    this.i_lang_code = i_lang_code;
    this.translation = translation;
  }
   */
  public I_Tbl_Fld_Trans_Key(Integer i_tbl_id, Integer rec_id, Integer i_tbl_fld_id, String i_lang_code) {
    this.i_tbl_id = i_tbl_id;
    this.rec_id = rec_id;
    this.i_tbl_fld_id = i_tbl_fld_id;
    this.i_lang_code = i_lang_code;
  }

  /*
  public Integer getI_tbl_fld_trans() {
    return i_tbl_fld_trans;
  }

  public void setI_tbl_fld_trans(Integer i_tbl_fld_trans) {
    this.i_tbl_fld_trans = i_tbl_fld_trans;
  }

  public I_Tbl getI_tbl() {
    return i_tbl;
  }

  public void setI_tbl(I_Tbl i_tbl) {
    this.i_tbl = i_tbl;
  }
   */
  public Integer getI_tbl_id() {
    return i_tbl_id;
  }

  public void setI_tbl_id(Integer i_tbl_id) {
    this.i_tbl_id = i_tbl_id;
  }

  public Integer getRec_id() {
    return rec_id;
  }

  public void setRec_id(Integer rec_id) {
    this.rec_id = rec_id;
  }

  /*
  public I_Tbl_Fld getI_tbl_fld() {
    return i_tbl_fld;
  }

  public void setI_tbl_fld(I_Tbl_Fld i_tbl_fld) {
    this.i_tbl_fld = i_tbl_fld;
  }
   */
  public Integer getI_tbl_fld_id() {
    return i_tbl_fld_id;
  }

  public void setI_tbl_fld_name(Integer i_tbl_fld_id) {
    this.i_tbl_fld_id = i_tbl_fld_id;
  }

  /*
  public I_Lang getI_lang() {
    return i_lang;
  }

  public void setI_lang(I_Lang i_lang) {
    this.i_lang = i_lang;
  }
   */
  public String getI_lang_code() {
    return i_lang_code;
  }

  public void setI_lang_code(String i_lang_code) {
    this.i_lang_code = i_lang_code;
  }

  /*
  public String getTranslation() {
    return translation;
  }

  public void setTranslation(String translation) {
    this.translation = translation;
  }
   */

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.i_tbl_id);
    hash = 67 * hash + Objects.hashCode(this.rec_id);
    hash = 67 * hash + Objects.hashCode(this.i_tbl_fld_id);
    hash = 67 * hash + Objects.hashCode(this.i_lang_code);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final I_Tbl_Fld_Trans_Key other = (I_Tbl_Fld_Trans_Key) obj;
    if (!Objects.equals(this.i_tbl_id, other.i_tbl_id)) {
      return false;
    }
    if (!Objects.equals(this.rec_id, other.rec_id)) {
      return false;
    }
    if (!Objects.equals(this.i_tbl_fld_id, other.i_tbl_fld_id)) {
      return false;
    }
    if (!Objects.equals(this.i_lang_code, other.i_lang_code)) {
      return false;
    }
    return true;
  }
}
