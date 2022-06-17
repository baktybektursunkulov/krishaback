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
@Table(name="jr_rep_col")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Col extends Abstract_Entity {

  //fields
  private Integer jr_rep_col;
  private Integer jr_rep;
  private Integer jr_rep_tpl_col;
  private Integer order_num;

  //transient fields
  private Jr_Rep jr_rep_t = null;
  private Jr_Rep_Tpl_Col jr_rep_tpl_col_t = null;


  public Jr_Rep_Col() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_rep_col", unique=true, nullable=false)
  public Integer getJr_rep_col() {
    return this.jr_rep_col;
  }
  public void setJr_rep_col(Integer jr_rep_col) {
    this.jr_rep_col = jr_rep_col;
  }

  @Column(name="jr_rep", nullable=false)
  public Integer getJr_rep() {
    return this.jr_rep;
  }
  public void setJr_rep(Integer jr_rep) {
    this.jr_rep = jr_rep;
  }

  @Column(name="jr_rep_tpl_col", nullable=false)
  public Integer getJr_rep_tpl_col() {
    return this.jr_rep_tpl_col;
  }
  public void setJr_rep_tpl_col(Integer jr_rep_tpl_col) {
    this.jr_rep_tpl_col = jr_rep_tpl_col;
  }

  @Column(name="order_num", nullable=false)
  public Integer getOrder_num() {
    return this.order_num;
  }
  public void setOrder_num(Integer order_num) {
    this.order_num = order_num;
  }


  @Transient
  public Jr_Rep getJr_rep_t() {
    if (this.jr_rep_t == null && this.getJr_rep() != null) {
      this.jr_rep_t = Jr_Rep_Manager.getCI().get_rec(this.getJr_rep()); 
    }
    return this.jr_rep_t;
  }
  @Transient
  public Jr_Rep getJr_rep_t_2(Session session_) {
    if (this.jr_rep_t == null && this.getJr_rep() != null) {
      this.jr_rep_t = Jr_Rep_Manager.getCI().get_rec(session_, this.getJr_rep()); 
    }
    return this.jr_rep_t;
  }
  public void setJr_rep_t(Jr_Rep jr_rep_t) {
    this.jr_rep_t = jr_rep_t;
    this.jr_rep = (this.jr_rep_t != null?this.jr_rep_t.getJr_rep():null);
  }

  @Transient
  public Jr_Rep_Tpl_Col getJr_rep_tpl_col_t() {
    if (this.jr_rep_tpl_col_t == null && this.getJr_rep_tpl_col() != null) {
      this.jr_rep_tpl_col_t = Jr_Rep_Tpl_Col_Manager.getCI().get_rec(this.getJr_rep_tpl_col()); 
    }
    return this.jr_rep_tpl_col_t;
  }
  @Transient
  public Jr_Rep_Tpl_Col getJr_rep_tpl_col_t_2(Session session_) {
    if (this.jr_rep_tpl_col_t == null && this.getJr_rep_tpl_col() != null) {
      this.jr_rep_tpl_col_t = Jr_Rep_Tpl_Col_Manager.getCI().get_rec(session_, this.getJr_rep_tpl_col()); 
    }
    return this.jr_rep_tpl_col_t;
  }
  public void setJr_rep_tpl_col_t(Jr_Rep_Tpl_Col jr_rep_tpl_col_t) {
    this.jr_rep_tpl_col_t = jr_rep_tpl_col_t;
    this.jr_rep_tpl_col = (this.jr_rep_tpl_col_t != null?this.jr_rep_tpl_col_t.getJr_rep_tpl_col():null);
  }



  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_col());
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
    final Jr_Rep_Col other = (Jr_Rep_Col) obj;
    if (!Objects.equals(this.getJr_rep_col(), other.getJr_rep_col())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_col();
  }

} 
