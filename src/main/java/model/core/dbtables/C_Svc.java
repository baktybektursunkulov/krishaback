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
@Table(name = "c_svc")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Svc extends Abstract_Entity {

  //fields
  private Integer c_svc;
  private Integer c_proj;
  private String code;
  private String name;
  private String description;
  private Boolean is_on;
  private Integer max_qty;
  private Integer cost_period_type;
  private Boolean is_active;
  private Boolean has_qty;
  private Boolean has_cost;
  private Integer reset_qty;
  private Integer reset_period_type;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;
  private C_Period_Type cost_period_type_t = null;
  private C_Period_Type reset_period_type_t = null;

  public C_Svc() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_svc", unique = true, nullable = false)
  public Integer getC_svc() {
    return this.c_svc;
  }

  public void setC_svc(Integer c_svc) {
    this.c_svc = c_svc;
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

  
  @Column(name = "description")
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "is_on", nullable = false)
  public Boolean getIs_on() {
    return this.is_on;
  }

  public void setIs_on(Boolean is_on) {
    this.is_on = is_on;
  }

  @Column(name = "max_qty")
  public Integer getMax_qty() {
    return this.max_qty;
  }

  public void setMax_qty(Integer max_qty) {
    this.max_qty = max_qty;
  }

  @Column(name = "cost_period_type")
  public Integer getCost_period_type() {
    return this.cost_period_type;
  }

  public void setCost_period_type(Integer cost_period_type) {
    this.cost_period_type = cost_period_type;
  }

  @Column(name = "is_active", nullable = false)
  public Boolean getIs_active() {
    return this.is_active;
  }

  public void setIs_active(Boolean is_active) {
    this.is_active = is_active;
  }

  @Column(name = "has_qty", nullable = false)
  public Boolean getHas_qty() {
    return this.has_qty;
  }

  public void setHas_qty(Boolean has_qty) {
    this.has_qty = has_qty;
  }

  @Column(name = "has_cost", nullable = false)
  public Boolean getHas_cost() {
    return this.has_cost;
  }

  public void setHas_cost(Boolean has_cost) {
    this.has_cost = has_cost;
  }

  @Column(name = "reset_qty")
  public Integer getReset_qty() {
    return this.reset_qty;
  }

  public void setReset_qty(Integer reset_qty) {
    this.reset_qty = reset_qty;
  }

  @Column(name = "reset_period_type")
  public Integer getReset_period_type() {
    return this.reset_period_type;
  }

  public void setReset_period_type(Integer reset_period_type) {
    this.reset_period_type = reset_period_type;
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
  public C_Period_Type getCost_period_type_t() {
    if (this.cost_period_type_t == null && this.getCost_period_type() != null) {
      this.cost_period_type_t = C_Period_Type_Manager.getCI().get_rec(this.getCost_period_type());
    }
    return this.cost_period_type_t;
  }

  @Transient
  public C_Period_Type getCost_period_type_t_2(Session session_) {
    if (this.cost_period_type_t == null && this.getCost_period_type() != null) {
      this.cost_period_type_t = C_Period_Type_Manager.getCI().get_rec(session_, this.getCost_period_type());
    }
    return this.cost_period_type_t;
  }

  public void setCost_period_type_t(C_Period_Type cost_period_type_t) {
    this.cost_period_type_t = cost_period_type_t;
    this.cost_period_type = (this.cost_period_type_t != null ? this.cost_period_type_t.getC_period_type() : null);
  }

  @Transient
  public C_Period_Type getReset_period_type_t() {
    if (this.reset_period_type_t == null && this.getReset_period_type() != null) {
      this.reset_period_type_t = C_Period_Type_Manager.getCI().get_rec(this.getReset_period_type());
    }
    return this.reset_period_type_t;
  }

  @Transient
  public C_Period_Type getReset_period_type_t_2(Session session_) {
    if (this.reset_period_type_t == null && this.getReset_period_type() != null) {
      this.reset_period_type_t = C_Period_Type_Manager.getCI().get_rec(session_, this.getReset_period_type());
    }
    return this.reset_period_type_t;
  }

  public void setReset_period_type_t(C_Period_Type reset_period_type_t) {
    this.reset_period_type_t = reset_period_type_t;
    this.reset_period_type = (this.reset_period_type_t != null ? this.reset_period_type_t.getC_period_type() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_svc());
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
    final C_Svc other = (C_Svc) obj;
    if (!Objects.equals(this.getC_svc(), other.getC_svc())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_svc();
  }

}
