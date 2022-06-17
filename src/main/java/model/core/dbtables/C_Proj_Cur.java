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
@Table(name = "c_proj_cur")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Proj_Cur extends Abstract_Entity {

  //fields
  private Integer c_proj_cur;
  private Integer c_proj;
  private Integer c_cur;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;
  private C_Cur c_cur_t = null;

  public C_Proj_Cur() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_proj_cur", unique = true, nullable = false)
  public Integer getC_proj_cur() {
    return this.c_proj_cur;
  }

  public void setC_proj_cur(Integer c_proj_cur) {
    this.c_proj_cur = c_proj_cur;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  @Column(name = "c_cur", nullable = false)
  public Integer getC_cur() {
    return this.c_cur;
  }

  public void setC_cur(Integer c_cur) {
    this.c_cur = c_cur;
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

  @Transient
  public C_Cur getC_cur_t() {
    if (this.c_cur_t == null && this.getC_cur() != null) {
      this.c_cur_t = C_Cur_Manager.getCI().get_rec(this.getC_cur());
    }
    return this.c_cur_t;
  }

  @Transient
  public C_Cur getC_cur_t_2(Session session_) {
    if (this.c_cur_t == null && this.getC_cur() != null) {
      this.c_cur_t = C_Cur_Manager.getCI().get_rec(session_, this.getC_cur());
    }
    return this.c_cur_t;
  }

  public void setC_cur_t(C_Cur c_cur_t) {
    this.c_cur_t = c_cur_t;
    this.c_cur = (this.c_cur_t != null ? this.c_cur_t.getC_cur() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_proj_cur());
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
    final C_Proj_Cur other = (C_Proj_Cur) obj;
    if (!Objects.equals(this.getC_proj_cur(), other.getC_proj_cur())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_proj_cur();
  }

}
