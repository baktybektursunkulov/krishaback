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
@Table(name = "c_cons")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Cons extends Abstract_Entity {

  //fields
  private Integer c_cons;
  private Integer c_proj;
  private String code;
  private String name;
  private String val;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;

  public C_Cons() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_cons", unique = true, nullable = false)
  public Integer getC_cons() {
    return this.c_cons;
  }

  public void setC_cons(Integer c_cons) {
    this.c_cons = c_cons;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
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

  
  @Column(name = "val", nullable = false)
  public String getVal() {
    return this.val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Proj getC_proj_t() {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(this.getC_proj());
    }
    return this.c_proj_t;
  }

  @Transient
  public C_Proj getC_proj_t_2(Session session_) {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(session_, this.getC_proj());
    }
    return this.c_proj_t;
  }

  public void setC_proj_t(C_Proj c_proj_t) {
    this.c_proj_t = c_proj_t;
    this.c_proj = (this.c_proj_t != null ? this.c_proj_t.getC_proj() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_cons());
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
    final C_Cons other = (C_Cons) obj;
    if (!Objects.equals(this.getC_cons(), other.getC_cons())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_cons();
  }

}
