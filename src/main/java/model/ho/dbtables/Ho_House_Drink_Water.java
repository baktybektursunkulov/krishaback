package model.ho.dbtables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import managers.ho.dbtables.*;
import org.hibernate.Session;

@Entity
@Table(name="ho_house_drink_water")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Ho_House_Drink_Water extends Abstract_Entity {

  //fields
  private Integer ho_house_drink_water;
  private String code;
  private String name;
  private Boolean is_deleted;

  //transient fields



  public Ho_House_Drink_Water() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ho_house_drink_water", unique=true, nullable=false)
  public Integer getHo_house_drink_water() {
    return this.ho_house_drink_water;
  }
  public void setHo_house_drink_water(Integer ho_house_drink_water) {
    this.ho_house_drink_water = ho_house_drink_water;
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
    hash = 89 * hash + Objects.hashCode(this.getHo_house_drink_water());
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
    final Ho_House_Drink_Water other = (Ho_House_Drink_Water) obj;
    if (!Objects.equals(this.getHo_house_drink_water(), other.getHo_house_drink_water())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_house_drink_water();
  }

} 
