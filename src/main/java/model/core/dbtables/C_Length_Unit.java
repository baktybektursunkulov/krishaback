package model.core.dbtables;

import beans.LocaleBean;
import gs.common.hibernate_funcs;
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
import others.CustomLogger;

@Entity
@Table(name = "c_length_unit")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Length_Unit extends Abstract_Entity {

  //fields
  private Integer c_length_unit;
  private String code;
  private String name;
  private Boolean is_deleted;
  private String short_name;
  private Boolean is_base_unit;
  private Double multiplier_to_base_unit;

  //transient fields
  private String name_translation;
  private String short_name_translation;

  public C_Length_Unit() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_length_unit", unique = true, nullable = false)
  public Integer getC_length_unit() {
    return this.c_length_unit;
  }

  public void setC_length_unit(Integer c_length_unit) {
    this.c_length_unit = c_length_unit;
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

  
  @Column(name = "short_name", nullable = false)
  public String getShort_name() {
    return this.short_name;
  }

  public void setShort_name(String short_name) {
    this.short_name = short_name;
  }

  @Column(name = "is_base_unit", nullable = false)
  public Boolean getIs_base_unit() {
    return this.is_base_unit;
  }

  public void setIs_base_unit(Boolean is_base_unit) {
    this.is_base_unit = is_base_unit;
  }

  @Column(name = "multiplier_to_base_unit", nullable = false)
  public Double getMultiplier_to_base_unit() {
    return this.multiplier_to_base_unit;
  }

  public void setMultiplier_to_base_unit(Double multiplier_to_base_unit) {
    this.multiplier_to_base_unit = multiplier_to_base_unit;
  }

  @Transient
  public String getName_translation() {
    if (name_translation == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        name_translation = getName_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return name_translation;
  }

  public String getName_translation_2(Session session_) {
    return getName_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
  }

  public String getName_translation_3(Session session_, String lang_) {
    if (name_translation == null) {
      if (lang_.equals("ru")) {
        name_translation = getName();
      } else {
        name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "name", lang_, getName());
      }
    }
    return name_translation;
  }

  @Transient
  public String getShort_name_translation() {
    if (short_name_translation == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        short_name_translation = getShort_name_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return short_name_translation;
  }

  public String getShort_name_translation_2(Session session_) {
    return getShort_name_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
  }

  public String getShort_name_translation_3(Session session_, String lang_) {
    if (short_name_translation == null) {
      if (lang_.equals("ru")) {
        short_name_translation = getShort_name();
      } else {
        short_name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "short_name", lang_, getShort_name());
      }
    }
    return short_name_translation;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_length_unit());
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
    final C_Length_Unit other = (C_Length_Unit) obj;
    if (!Objects.equals(this.getC_length_unit(), other.getC_length_unit())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_length_unit();
  }

}
