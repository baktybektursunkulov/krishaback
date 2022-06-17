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
@Table(name = "c_distance_unit")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Distance_Unit extends Abstract_Entity {

  //fields
  private Integer c_distance_unit;
  private String code;
  private String name;
  private Boolean is_base_unit;
  private Double multiplier_to_base_unit;
  private Boolean is_deleted;

  //transient fields
  private String name_translation;

  public C_Distance_Unit() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_distance_unit", unique = true, nullable = false)
  public Integer getC_distance_unit() {
    return this.c_distance_unit;
  }

  public void setC_distance_unit(Integer c_distance_unit) {
    this.c_distance_unit = c_distance_unit;
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

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
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

  public void setName_translation(String name_translation) {
    this.name_translation = name_translation;
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_distance_unit());
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
    final C_Distance_Unit other = (C_Distance_Unit) obj;
    if (!Objects.equals(this.getC_distance_unit(), other.getC_distance_unit())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_distance_unit();
  }

}
