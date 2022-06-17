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
@Table(name="c_jur_person_addr_type")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Jur_Person_Addr_Type extends Abstract_Entity {

  //fields
  private Integer c_jur_person_addr_type;
  private String code;
  private String name;
  private Boolean is_deleted;

  //transient fields



  public C_Jur_Person_Addr_Type() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_jur_person_addr_type", unique=true, nullable=false)
  public Integer getC_jur_person_addr_type() {
    return this.c_jur_person_addr_type;
  }
  public void setC_jur_person_addr_type(Integer c_jur_person_addr_type) {
    this.c_jur_person_addr_type = c_jur_person_addr_type;
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
    hash = 89 * hash + Objects.hashCode(this.getC_jur_person_addr_type());
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
    final C_Jur_Person_Addr_Type other = (C_Jur_Person_Addr_Type) obj;
    if (!Objects.equals(this.getC_jur_person_addr_type(), other.getC_jur_person_addr_type())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_jur_person_addr_type();
  }

} 
