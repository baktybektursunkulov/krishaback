package model.core.dbtables;

import beans.LocaleBean;
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
@Table(name = "i_html_txt")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class I_Html_Txt extends Abstract_Entity {

  //fields
  private Integer i_html_txt;
  private Integer c_proj;
  private String code;
  private String txt;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;
  private String txt_translation;

  public I_Html_Txt() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "i_html_txt", unique = true, nullable = false)
  public Integer getI_html_txt() {
    return this.i_html_txt;
  }

  public void setI_html_txt(Integer i_html_txt) {
    this.i_html_txt = i_html_txt;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  
  @Column(name = "code", nullable = false)
  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  
  @Column(name = "txt", nullable = false)
  public String getTxt() {
    return this.txt;
  }

  public void setTxt(String txt) {
    this.txt = txt;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Proj getC_proj_t() {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(this.getC_proj());
    }
    return this.c_proj_t;
  }

  @Transient
  public C_Proj getC_proj_t_2(Session session_) {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(session_, this.getC_proj());
    }
    return this.c_proj_t;
  }

  public void setC_proj_t(C_Proj c_proj_t) {
    this.c_proj_t = c_proj_t;
    this.c_proj = (this.c_proj_t != null ? this.c_proj_t.getC_proj() : null);
  }

  @Transient
  public String getShort_txt() {
    if (this.txt.length() < 30) {
      return this.txt;
    } else {
      return this.txt.substring(0, 30) + "...";
    }
  }

  @Transient
  public String getTxt_translation() {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      txt_translation = getTxt();
    } else {
      txt_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(this.getClass().getSimpleName(), (Integer) getEntity_id(), "txt", LocaleBean.getCurrentBean().getLanguageTag(), getTxt());
    }
    return txt_translation;
  }

  @Transient
  public String getTxt_translation_2(Session session_) {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      txt_translation = getTxt();
    } else {
      txt_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "txt", LocaleBean.getCurrentBean().getLanguageTag(), getTxt());
    }
    return txt_translation;
  }

  @Transient
  public String getTxt_translation_3(Session session_, String lang_) {
    if (lang_.equals("ru")) {
      txt_translation = getTxt();
    } else {
      txt_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "txt", lang_, getTxt());
    }
    return txt_translation;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getI_html_txt());
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
    final I_Html_Txt other = (I_Html_Txt) obj;
    if (!Objects.equals(this.getI_html_txt(), other.getI_html_txt())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getI_html_txt();
  }

}
