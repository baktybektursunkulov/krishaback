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
@Table(name="ho_house_floor")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Ho_House_Floor extends Abstract_Entity {

  //fields
  private Integer ho_house_floor;
  private String code;
  private String name;
  private Boolean is_deleted;

  //transient fields



  public Ho_House_Floor() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ho_house_floor", unique=true, nullable=false)
  public Integer getHo_house_floor() {
    return this.ho_house_floor;
  }
  public void setHo_house_floor(Integer ho_house_floor) {
    this.ho_house_floor = ho_house_floor;
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
    hash = 89 * hash + Objects.hashCode(this.getHo_house_floor());
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
    final Ho_House_Floor other = (Ho_House_Floor) obj;
    if (!Objects.equals(this.getHo_house_floor(), other.getHo_house_floor())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_house_floor();
  }

} 
