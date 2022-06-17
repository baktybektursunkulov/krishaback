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
@Table(name = "c_smtp_security")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Smtp_Security extends Abstract_Entity {

  //fields
  private Integer c_smtp_security;
  private String code;
  private String name;
  private Boolean is_deleted;

  //transient fields
  public C_Smtp_Security() {

  }

  //fields getter and setter methods
  @Id
  @Column(name = "c_smtp_security", unique = true, nullable = false)
  public Integer getC_smtp_security() {
    return this.c_smtp_security;
  }

  public void setC_smtp_security(Integer c_smtp_security) {
    this.c_smtp_security = c_smtp_security;
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_smtp_security());
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
    final C_Smtp_Security other = (C_Smtp_Security) obj;
    if (!Objects.equals(this.getC_smtp_security(), other.getC_smtp_security())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_smtp_security();
  }

}
