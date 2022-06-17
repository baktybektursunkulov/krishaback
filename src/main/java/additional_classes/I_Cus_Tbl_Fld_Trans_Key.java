package additional_classes;

import java.io.Serializable;
import java.util.Objects;

public class I_Cus_Tbl_Fld_Trans_Key implements Serializable {

  //private Integer i_cus_tbl_fld_trans;
  //private I_Cus_Tbl i_cus_tbl;
  private String i_cus_tbl_name;
  private String rec_id;
  //private I_Cus_Tbl_Fld i_cus_tbl_fld;
  private String i_cus_tbl_fld_name;
  //private I_Lang i_lang;
  private String i_lang_code;
  //private String translation;

  public I_Cus_Tbl_Fld_Trans_Key() {

  }
/*
  public I_Cus_Tbl_Fld_Trans_Key(Integer i_cus_tbl_fld_trans, I_Cus_Tbl i_cus_tbl, String i_cus_tbl_name, String rec_id, I_Cus_Tbl_Fld i_cus_tbl_fld, String i_cus_tbl_fld_name, I_Lang i_lang, String i_lang_code, String translation) {
    this.i_cus_tbl_fld_trans = i_cus_tbl_fld_trans;
    this.i_cus_tbl = i_cus_tbl;
    this.i_cus_tbl_name = i_cus_tbl_name;
    this.rec_id = rec_id;
    this.i_cus_tbl_fld = i_cus_tbl_fld;
    this.i_cus_tbl_fld_name = i_cus_tbl_fld_name;
    this.i_lang = i_lang;
    this.i_lang_code = i_lang_code;
    this.translation = translation;
  }
*/
  public I_Cus_Tbl_Fld_Trans_Key(String i_cus_tbl_name, String rec_id, String i_cus_tbl_fld_name, String i_lang_code) {
    this.i_cus_tbl_name = i_cus_tbl_name;
    this.rec_id = rec_id;
    this.i_cus_tbl_fld_name = i_cus_tbl_fld_name;
    this.i_lang_code = i_lang_code;
  }
/*
  public Integer getI_cus_tbl_fld_trans() {
    return i_cus_tbl_fld_trans;
  }

  public void setI_cus_tbl_fld_trans(Integer i_cus_tbl_fld_trans) {
    this.i_cus_tbl_fld_trans = i_cus_tbl_fld_trans;
  }

  public I_Cus_Tbl getI_cus_tbl() {
    return i_cus_tbl;
  }

  public void setI_cus_tbl(I_Cus_Tbl i_cus_tbl) {
    this.i_cus_tbl = i_cus_tbl;
  }
*/
  public String getI_cus_tbl_name() {
    return i_cus_tbl_name;
  }

  public void setI_cus_tbl_name(String i_cus_tbl_name) {
    this.i_cus_tbl_name = i_cus_tbl_name;
  }

  public String getRec_id() {
    return rec_id;
  }

  public void setRec_id(String rec_id) {
    this.rec_id = rec_id;
  }
/*
  public I_Cus_Tbl_Fld getI_cus_tbl_fld() {
    return i_cus_tbl_fld;
  }

  public void setI_cus_tbl_fld(I_Cus_Tbl_Fld i_cus_tbl_fld) {
    this.i_cus_tbl_fld = i_cus_tbl_fld;
  }
*/
  public String getI_cus_tbl_fld_name() {
    return i_cus_tbl_fld_name;
  }

  public void setI_cus_tbl_fld_name(String i_cus_tbl_fld_name) {
    this.i_cus_tbl_fld_name = i_cus_tbl_fld_name;
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
    int hash = 3;
    hash = 97 * hash + Objects.hashCode(this.i_cus_tbl_name);
    hash = 97 * hash + Objects.hashCode(this.rec_id);
    hash = 97 * hash + Objects.hashCode(this.i_cus_tbl_fld_name);
    hash = 97 * hash + Objects.hashCode(this.i_lang_code);
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
    final I_Cus_Tbl_Fld_Trans_Key other = (I_Cus_Tbl_Fld_Trans_Key) obj;
    if (!Objects.equals(this.i_cus_tbl_name, other.i_cus_tbl_name)) {
      return false;
    }
    if (!Objects.equals(this.rec_id, other.rec_id)) {
      return false;
    }
    if (!Objects.equals(this.i_cus_tbl_fld_name, other.i_cus_tbl_fld_name)) {
      return false;
    }
    if (!Objects.equals(this.i_lang_code, other.i_lang_code)) {
      return false;
    }
    return true;
  }
}
