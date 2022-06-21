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
@Table(name="c_land_area_unit")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Land_Area_Unit extends Abstract_Entity {

  //fields
  private Integer c_land_area_unit;
  private String code;
  private String name;
  private Boolean is_base_unit;
  private Double multiplier_to_base_unit;
  private Boolean is_deleted;

  //transient fields



  public C_Land_Area_Unit() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_land_area_unit", unique=true, nullable=false)
  public Integer getC_land_area_unit() {
    return this.c_land_area_unit;
  }
  public void setC_land_area_unit(Integer c_land_area_unit) {
    this.c_land_area_unit = c_land_area_unit;
  }

  @Type(type="text")
  @Column(name="code", nullable=false)
  public String getCode() {
    return this.code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  @Type(type="text")
  @Column(name="name", nullable=false)
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Column(name="is_base_unit", nullable=false)
  public Boolean getIs_base_unit() {
    return this.is_base_unit;
  }
  public void setIs_base_unit(Boolean is_base_unit) {
    this.is_base_unit = is_base_unit;
  }

  @Column(name="multiplier_to_base_unit", nullable=false)
  public Double getMultiplier_to_base_unit() {
    return this.multiplier_to_base_unit;
  }
  public void setMultiplier_to_base_unit(Double multiplier_to_base_unit) {
    this.multiplier_to_base_unit = multiplier_to_base_unit;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }








  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_land_area_unit());
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
    final C_Land_Area_Unit other = (C_Land_Area_Unit) obj;
    if (!Objects.equals(this.getC_land_area_unit(), other.getC_land_area_unit())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_land_area_unit();
  }

} 
