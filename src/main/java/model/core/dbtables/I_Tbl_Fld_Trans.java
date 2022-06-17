package model.core.dbtables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import managers.core.dbtables.*;
import org.hibernate.Session;

@Entity
@Table(name = "i_tbl_fld_trans")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class I_Tbl_Fld_Trans extends Abstract_Entity {

  //fields
  private Integer i_tbl_fld_trans;
  private Integer i_tbl;
  private Long rec_id;
  private Integer i_tbl_fld;
  private Integer c_lang;
  private String translation;
  private Integer source_text_hash_code;
  private Boolean is_deleted;

  //transient fields
  private I_Tbl i_tbl_t = null;
  private I_Tbl_Fld i_tbl_fld_t = null;
  private C_Lang c_lang_t = null;
  private String i_tbl_fld_val;

  public I_Tbl_Fld_Trans() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "i_tbl_fld_trans", unique = true, nullable = false)
  public Integer getI_tbl_fld_trans() {
    return this.i_tbl_fld_trans;
  }

  public void setI_tbl_fld_trans(Integer i_tbl_fld_trans) {
    this.i_tbl_fld_trans = i_tbl_fld_trans;
  }

  @Column(name = "i_tbl", nullable = false)
  public Integer getI_tbl() {
    return this.i_tbl;
  }

  public void setI_tbl(Integer i_tbl) {
    this.i_tbl = i_tbl;
  }

  @Column(name = "rec_id", nullable = false)
  public Long getRec_id() {
    return this.rec_id;
  }

  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  @Column(name = "i_tbl_fld", nullable = false)
  public Integer getI_tbl_fld() {
    return this.i_tbl_fld;
  }

  public void setI_tbl_fld(Integer i_tbl_fld) {
    this.i_tbl_fld = i_tbl_fld;
  }

  @Column(name = "c_lang", nullable = false)
  public Integer getC_lang() {
    return this.c_lang;
  }

  public void setC_lang(Integer c_lang) {
    this.c_lang = c_lang;
  }

  
  @Column(name = "translation", nullable = false)
  public String getTranslation() {
    return this.translation;
  }

  public void setTranslation(String translation) {
    this.translation = translation;
  }

  @Column(name = "source_text_hash_code")
  public Integer getSource_text_hash_code() {
    return this.source_text_hash_code;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  public void setSource_text_hash_code(Integer source_text_hash_code) {
    this.source_text_hash_code = source_text_hash_code;
  }

  @Transient
  public I_Tbl getI_tbl_t() {
    if (this.i_tbl_t == null && this.getI_tbl() != null) {
      this.i_tbl_t = I_Tbl_Manager.getCI().get_rec(this.getI_tbl());
    }
    return this.i_tbl_t;
  }

  @Transient
  public I_Tbl getI_tbl_t_2(Session session_) {
    if (this.i_tbl_t == null && this.getI_tbl() != null) {
      this.i_tbl_t = I_Tbl_Manager.getCI().get_rec(session_, this.getI_tbl());
    }
    return this.i_tbl_t;
  }

  public void setI_tbl_t(I_Tbl i_tbl_t) {
    this.i_tbl_t = i_tbl_t;
    this.i_tbl = (this.i_tbl_t != null ? this.i_tbl_t.getI_tbl() : null);
  }

  @Transient
  public I_Tbl_Fld getI_tbl_fld_t() {
    if (this.i_tbl_fld_t == null && this.getI_tbl_fld() != null) {
      this.i_tbl_fld_t = I_Tbl_Fld_Manager.getCI().get_rec(this.getI_tbl_fld());
    }
    return this.i_tbl_fld_t;
  }

  @Transient
  public I_Tbl_Fld getI_tbl_fld_t_2(Session session_) {
    if (this.i_tbl_fld_t == null && this.getI_tbl_fld() != null) {
      this.i_tbl_fld_t = I_Tbl_Fld_Manager.getCI().get_rec(session_, this.getI_tbl_fld());
    }
    return this.i_tbl_fld_t;
  }

  public void setI_tbl_fld_t(I_Tbl_Fld i_tbl_fld_t) {
    this.i_tbl_fld_t = i_tbl_fld_t;
    this.i_tbl_fld = (this.i_tbl_fld_t != null ? this.i_tbl_fld_t.getI_tbl_fld() : null);
  }

  @Transient
  public C_Lang getC_lang_t() {
    if (this.c_lang_t == null && this.getC_lang() != null) {
      this.c_lang_t = C_Lang_Manager.getCI().get_rec(this.getC_lang());
    }
    return this.c_lang_t;
  }

  @Transient
  public C_Lang getC_lang_t_2(Session session_) {
    if (this.c_lang_t == null && this.getC_lang() != null) {
      this.c_lang_t = C_Lang_Manager.getCI().get_rec(session_, this.getC_lang());
    }
    return this.c_lang_t;
  }

  public void setC_lang_t(C_Lang c_lang_t) {
    this.c_lang_t = c_lang_t;
    this.c_lang = (this.c_lang_t != null ? this.c_lang_t.getC_lang() : null);
  }

  @Transient
  public String getI_tbl_fld_val() {
    if (getI_tbl() == null || getI_tbl_fld() == null) {
      return null;
    }
    if (i_tbl_fld_val == null) {
      i_tbl_fld_val = I_Tbl_Fld_Trans_Manager.get_tbl_fld_val(getI_tbl_t().getName(), getI_tbl_t().getPk_fld_name(), getRec_id(), getI_tbl_fld_t().getName());
    }
    return i_tbl_fld_val;
  }

  public void setI_tbl_fld_val(String i_tbl_fld_val) {
    this.i_tbl_fld_val = i_tbl_fld_val;
  }

  @Transient
  public String getShort_translation() {
    if (this.translation.length() < 30) {
      return this.translation;
    } else {
      return this.translation.substring(0, 30) + "...";
    }
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getI_tbl_fld_trans());
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final I_Tbl_Fld_Trans other = (I_Tbl_Fld_Trans) obj;
    if (!Objects.equals(this.getI_tbl_fld_trans(), other.getI_tbl_fld_trans())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getI_tbl_fld_trans();
  }

}
