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
@Table(name = "c_loc_grp_loc")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Loc_Grp_Loc extends Abstract_Entity {

  //fields
  private Integer c_loc_grp_loc;
  private Integer c_loc_grp;
  private Integer c_loc;
  private Boolean is_deleted;

  //transient fields
  private C_Loc_Grp c_loc_grp_t = null;
  private C_Loc c_loc_t = null;

  public C_Loc_Grp_Loc() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_loc_grp_loc", unique = true, nullable = false)
  public Integer getC_loc_grp_loc() {
    return this.c_loc_grp_loc;
  }

  public void setC_loc_grp_loc(Integer c_loc_grp_loc) {
    this.c_loc_grp_loc = c_loc_grp_loc;
  }

  @Column(name = "c_loc_grp", nullable = false)
  public Integer getC_loc_grp() {
    return this.c_loc_grp;
  }

  public void setC_loc_grp(Integer c_loc_grp) {
    this.c_loc_grp = c_loc_grp;
  }

  @Column(name = "c_loc", nullable = false)
  public Integer getC_loc() {
    return this.c_loc;
  }

  public void setC_loc(Integer c_loc) {
    this.c_loc = c_loc;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Loc_Grp getC_loc_grp_t() {
    if (this.c_loc_grp_t == null && this.getC_loc_grp() != null) {
      this.c_loc_grp_t = C_Loc_Grp_Manager.getCI().get_rec(this.getC_loc_grp());
    }
    return this.c_loc_grp_t;
  }

  @Transient
  public C_Loc_Grp getC_loc_grp_t_2(Session session_) {
    if (this.c_loc_grp_t == null && this.getC_loc_grp() != null) {
      this.c_loc_grp_t = C_Loc_Grp_Manager.getCI().get_rec(session_, this.getC_loc_grp());
    }
    return this.c_loc_grp_t;
  }

  public void setC_loc_grp_t(C_Loc_Grp c_loc_grp_t) {
    this.c_loc_grp_t = c_loc_grp_t;
    this.c_loc_grp = (this.c_loc_grp_t != null ? this.c_loc_grp_t.getC_loc_grp() : null);
  }

  @Transient
  public C_Loc getC_loc_t() {
    if (this.c_loc_t == null && this.getC_loc() != null) {
      this.c_loc_t = C_Loc_Manager.getCI().get_rec(this.getC_loc());
    }
    return this.c_loc_t;
  }

  @Transient
  public C_Loc getC_loc_t_2(Session session_) {
    if (this.c_loc_t == null && this.getC_loc() != null) {
      this.c_loc_t = C_Loc_Manager.getCI().get_rec(session_, this.getC_loc());
    }
    return this.c_loc_t;
  }

  public void setC_loc_t(C_Loc c_loc_t) {
    this.c_loc_t = c_loc_t;
    this.c_loc = (this.c_loc_t != null ? this.c_loc_t.getC_loc() : null);
  }

  @Transient
  public String getC_loc_t__name() {
    return getC_loc_t() == null ? "" : getC_loc_t().getName();
  }

  public void setC_loc_t__name(String c_loc__name) {
  }

  @Transient
  public String getC_loc_t__calc_full_name() {
    return getC_loc_t() == null ? "" : getC_loc_t().getCalc_full_name();
  }

  public void setC_loc_t__calc_full_name(String c_loc__calc_full_name) {
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_loc_grp_loc());
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
    final C_Loc_Grp_Loc other = (C_Loc_Grp_Loc) obj;
    if (!Objects.equals(this.getC_loc_grp_loc(), other.getC_loc_grp_loc())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_loc_grp_loc();
  }

}
