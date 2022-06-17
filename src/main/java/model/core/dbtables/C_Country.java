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
@Table(name = "c_country")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Country extends Abstract_Entity {

  //fields
  private Integer c_country;
  private String code;
  private String name;
  private Boolean is_deleted;
  private Integer c_cur;
  private Long flag_img;

  //transient fields
  private String name_translation;
  private C_Cur c_cur_t = null;
  private C_Img flag_img_t = null;
  public String dynamic_img_url;

  public C_Country() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_country", unique = true, nullable = false)
  public Integer getC_country() {
    return this.c_country;
  }

  public void setC_country(Integer c_country) {
    this.c_country = c_country;
  }

  
  @Column(name = "code", nullable = false)
  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "c_cur")
  public Integer getC_cur() {
    return this.c_cur;
  }

  public void setC_cur(Integer c_cur) {
    this.c_cur = c_cur;
  }

  @Column(name = "flag_img")
  public Long getFlag_img() {
    return this.flag_img;
  }

  public void setFlag_img(Long flag_img) {
    this.flag_img = flag_img;
  }

  @Transient
  public String getName_translation() {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(this.getClass().getSimpleName(), (Integer) getEntity_id(), "name", LocaleBean.getCurrentBean().getLanguageTag(), getName());
    }
    return name_translation;
  }

  public String getName_translation_2(String lang_) {
    if (lang_.equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(this.getClass().getSimpleName(), (Integer) getEntity_id(), "name", lang_, getName());
    }
    return name_translation;
  }

  public String getName_translation_3(Session session_, String lang_) {
    if (lang_.equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "name", lang_, getName());
    }
    return name_translation;
  }

  @Transient
  public C_Cur getC_cur_t() {
    if (this.c_cur_t == null && this.getC_cur() != null) {
      this.c_cur_t = C_Cur_Manager.getCI().get_rec(this.getC_cur());
    }
    return this.c_cur_t;
  }

  @Transient
  public C_Cur getC_cur_t_2(Session session_) {
    if (this.c_cur_t == null && this.getC_cur() != null) {
      this.c_cur_t = C_Cur_Manager.getCI().get_rec(session_, this.getC_cur());
    }
    return this.c_cur_t;
  }

  public void setC_cur_t(C_Cur c_cur_t) {
    this.c_cur_t = c_cur_t;
    this.c_cur = (this.c_cur_t != null ? this.c_cur_t.getC_cur() : null);
  }

  @Transient
  public C_Img getFlag_img_t() {
    if (this.flag_img_t == null && this.getFlag_img() != null) {
      this.flag_img_t = C_Img_Manager.getCI().get_rec(this.getFlag_img());
    }
    return this.flag_img_t;
  }

  @Transient
  public C_Img getFlag_img_t_2(Session session_) {
    if (this.flag_img_t == null && this.getFlag_img() != null) {
      this.flag_img_t = C_Img_Manager.getCI().get_rec(session_, this.getFlag_img());
    }
    return this.flag_img_t;
  }

  public void setFlag_img_t(C_Img flag_img_t) {
    this.flag_img_t = flag_img_t;
    this.flag_img = (this.flag_img_t != null ? this.flag_img_t.getC_img() : null);
  }

  @Transient
  public String getDynamic_img_url() {
    return dynamic_img_url;
  }

  public String getDynamic_img_url_2(int height_) {
    if (dynamic_img_url == null && flag_img != null) {
      dynamic_img_url = C_Img_Manager.getCI().get_img_url_by_height(flag_img, height_);
    }
    return dynamic_img_url;
  }
  
  public void setDynamic_img_url(String dynamic_img_url) {
    this.dynamic_img_url = dynamic_img_url;
  }
  
  
  

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_country());
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
    final C_Country other = (C_Country) obj;
    if (!Objects.equals(this.getC_country(), other.getC_country())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_country();
  }

  @Override
  public String toString() {
    return "C_Country{" + "c_country=" + c_country + ", code=" + code + ", name=" + name + ", is_deleted=" + is_deleted + '}';
  }

}
