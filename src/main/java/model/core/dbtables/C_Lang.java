package model.core.dbtables;

import beans.LocaleBean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import gs.services.core.dbtables.C_Lang_Service;
//import java.util.Locale;
import managers.core.dbtables.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import others.core_lang_funcs;

@Entity
@Table(name = "c_lang")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Lang extends Abstract_Entity {

  //fields
  private Integer c_lang;
  private String code;
  private String name;
  private Boolean is_deleted;

  //transient fields
//  private Locale locale;
  private String name_translation;

  @Autowired
  C_Lang_Service c_Lang_Service;
  
  public C_Lang() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_lang", unique = true, nullable = false)
  public Integer getC_lang() {
    return this.c_lang;
  }

  public void setC_lang(Integer c_lang) {
    this.c_lang = c_lang;
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

  @JsonIgnore
  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  /*
  @Transient
  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }
*/

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_lang());
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
    final C_Lang other = (C_Lang) obj;
    if (!Objects.equals(this.getC_lang(), other.getC_lang())) {
      return false;
    }
    return true;
  }

  @JsonIgnore
  @Transient
  public String getName_translation() {
    if (core_lang_funcs.get_lang(c_Lang_Service).equals("ru")) {
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

  @JsonIgnore
  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_lang();
  }

  @Override
  public String toString() {
    return "C_Lang{" + "c_lang=" + c_lang + ", code=" + code + ", name=" + name + ", is_deleted=" + is_deleted + ", name_translation=" + name_translation + '}';
  }

}
