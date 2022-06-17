package gs.model.core.dbtables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import java.util.Locale;
import lombok.Data;
import org.hibernate.Session;

@Entity
@Table(name = "c_lang")
public class C_Lang extends Abstract_Entity {

  //fields
  private Integer c_lang;
  private String code;
  private String name;
  private Boolean is_deleted;

  //transient fields
  private Locale locale;
  private String name_translation;

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

  @Type(type = "text")
  @Column(name = "code", nullable = false)
  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Type(type = "text")
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

  @Transient
  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

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

  public String getName_translation_2(String lang_) {
    if (lang_.equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(this.getClass().getSimpleName(), (Integer) getEntity_id(), "name", lang_, getName());
    }
    return name_translation;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_lang();
  }

  @Override
  public String toString() {
    return "C_Lang{" + "c_lang=" + c_lang + ", code=" + code + ", name=" + name + ", is_deleted=" + is_deleted + ", locale=" + locale + ", name_translation=" + name_translation + '}';
  }

}
