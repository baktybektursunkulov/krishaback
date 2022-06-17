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
@Table(name = "c_svc_cost_row")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Svc_Cost_Row extends Abstract_Entity {

  //fields
  private Integer c_svc_cost_row;
  private Integer c_svc;
  private Integer qty;
  private Double cost;
  private Boolean is_deleted;

  //transient fields
  private C_Svc c_svc_t = null;

  public C_Svc_Cost_Row() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_svc_cost_row", unique = true, nullable = false)
  public Integer getC_svc_cost_row() {
    return this.c_svc_cost_row;
  }

  public void setC_svc_cost_row(Integer c_svc_cost_row) {
    this.c_svc_cost_row = c_svc_cost_row;
  }

  @Column(name = "c_svc", nullable = false)
  public Integer getC_svc() {
    return this.c_svc;
  }

  public void setC_svc(Integer c_svc) {
    this.c_svc = c_svc;
  }

  @Column(name = "qty", nullable = false)
  public Integer getQty() {
    return this.qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  @Column(name = "cost", nullable = false)
  public Double getCost() {
    return this.cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Svc getC_svc_t() {
    if (this.c_svc_t == null && this.getC_svc() != null) {
      this.c_svc_t = C_Svc_Manager.getCI().get_rec(this.getC_svc());
    }
    return this.c_svc_t;
  }

  @Transient
  public C_Svc getC_svc_t_2(Session session_) {
    if (this.c_svc_t == null && this.getC_svc() != null) {
      this.c_svc_t = C_Svc_Manager.getCI().get_rec(session_, this.getC_svc());
    }
    return this.c_svc_t;
  }

  public void setC_svc_t(C_Svc c_svc_t) {
    this.c_svc_t = c_svc_t;
    this.c_svc = (this.c_svc_t != null ? this.c_svc_t.getC_svc() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_svc_cost_row());
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
    final C_Svc_Cost_Row other = (C_Svc_Cost_Row) obj;
    if (!Objects.equals(this.getC_svc_cost_row(), other.getC_svc_cost_row())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_svc_cost_row();
  }

}
