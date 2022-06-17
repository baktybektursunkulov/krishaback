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
@Table(name = "c_usr_day_op_kind")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Usr_Day_Op_Kind extends Abstract_Entity {

  //fields
  private Integer c_usr_day_op_kind;
  private String code;
  private String name;
  private Boolean is_deleted;

  //transient fields
  public C_Usr_Day_Op_Kind() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_day_op_kind", unique = true, nullable = false)
  public Integer getC_usr_day_op_kind() {
    return this.c_usr_day_op_kind;
  }

  public void setC_usr_day_op_kind(Integer c_usr_day_op_kind) {
    this.c_usr_day_op_kind = c_usr_day_op_kind;
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
    hash = 89 * hash + Objects.hashCode(this.getC_usr_day_op_kind());
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
    final C_Usr_Day_Op_Kind other = (C_Usr_Day_Op_Kind) obj;
    if (!Objects.equals(this.getC_usr_day_op_kind(), other.getC_usr_day_op_kind())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_day_op_kind();
  }

}
