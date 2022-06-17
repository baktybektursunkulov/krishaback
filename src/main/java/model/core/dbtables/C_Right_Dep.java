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
@Table(name = "c_right_dep")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Right_Dep extends Abstract_Entity {

  //fields
  private Integer c_right_dep;
  private Integer c_right;
  private Integer dep_right;
  private Boolean is_deleted;

  //transient fields
  private C_Right c_right_t = null;
  private C_Right dep_right_t = null;

  public C_Right_Dep() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_right_dep", unique = true, nullable = false)
  public Integer getC_right_dep() {
    return this.c_right_dep;
  }

  public void setC_right_dep(Integer c_right_dep) {
    this.c_right_dep = c_right_dep;
  }

  @Column(name = "c_right", nullable = false)
  public Integer getC_right() {
    return this.c_right;
  }

  public void setC_right(Integer c_right) {
    this.c_right = c_right;
  }

  @Column(name = "dep_right", nullable = false)
  public Integer getDep_right() {
    return this.dep_right;
  }

  public void setDep_right(Integer dep_right) {
    this.dep_right = dep_right;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Right getC_right_t() {
    if (this.c_right_t == null && this.getC_right() != null) {
      this.c_right_t = C_Right_Manager.getCI().get_rec(this.getC_right());
    }
    return this.c_right_t;
  }

  @Transient
  public C_Right getC_right_t_2(Session session_) {
    if (this.c_right_t == null && this.getC_right() != null) {
      this.c_right_t = C_Right_Manager.getCI().get_rec(session_, this.getC_right());
    }
    return this.c_right_t;
  }

  public void setC_right_t(C_Right c_right_t) {
    this.c_right_t = c_right_t;
    this.c_right = (this.c_right_t != null ? this.c_right_t.getC_right() : null);
  }

  @Transient
  public C_Right getDep_right_t() {
    if (this.dep_right_t == null && this.getDep_right() != null) {
      this.dep_right_t = C_Right_Manager.getCI().get_rec(this.getDep_right());
    }
    return this.dep_right_t;
  }

  @Transient
  public C_Right getDep_right_t_2(Session session_) {
    if (this.dep_right_t == null && this.getDep_right() != null) {
      this.dep_right_t = C_Right_Manager.getCI().get_rec(session_, this.getDep_right());
    }
    return this.dep_right_t;
  }

  public void setDep_right_t(C_Right dep_right_t) {
    this.dep_right_t = dep_right_t;
    this.dep_right = (this.dep_right_t != null ? this.dep_right_t.getC_right() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_right_dep());
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
    final C_Right_Dep other = (C_Right_Dep) obj;
    if (!Objects.equals(this.getC_right_dep(), other.getC_right_dep())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_right_dep();
  }

}
