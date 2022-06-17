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
@Table(name="jr_rep_col_sort")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Col_Sort extends Abstract_Entity {

  //fields
  private Integer jr_rep_col_sort;
  private Integer jr_rep;
  private Integer jr_rep_tpl_col;
  private Integer jr_rep_sort_order;
  private Integer order_num;

  //transient fields
  private Jr_Rep jr_rep_t = null;
  private Jr_Rep_Tpl_Col jr_rep_tpl_col_t = null;
  private Jr_Rep_Sort_Order jr_rep_sort_order_t = null;


  public Jr_Rep_Col_Sort() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_rep_col_sort", unique=true, nullable=false)
  public Integer getJr_rep_col_sort() {
    return this.jr_rep_col_sort;
  }
  public void setJr_rep_col_sort(Integer jr_rep_col_sort) {
    this.jr_rep_col_sort = jr_rep_col_sort;
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

  @Column(name="jr_rep_sort_order", nullable=false)
  public Integer getJr_rep_sort_order() {
    return this.jr_rep_sort_order;
  }
  public void setJr_rep_sort_order(Integer jr_rep_sort_order) {
    this.jr_rep_sort_order = jr_rep_sort_order;
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

  @Transient
  public Jr_Rep_Sort_Order getJr_rep_sort_order_t() {
    if (this.jr_rep_sort_order_t == null && this.getJr_rep_sort_order() != null) {
      this.jr_rep_sort_order_t = Jr_Rep_Sort_Order_Manager.getCI().get_rec(this.getJr_rep_sort_order()); 
    }
    return this.jr_rep_sort_order_t;
  }
  @Transient
  public Jr_Rep_Sort_Order getJr_rep_sort_order_t_2(Session session_) {
    if (this.jr_rep_sort_order_t == null && this.getJr_rep_sort_order() != null) {
      this.jr_rep_sort_order_t = Jr_Rep_Sort_Order_Manager.getCI().get_rec(session_, this.getJr_rep_sort_order()); 
    }
    return this.jr_rep_sort_order_t;
  }
  public void setJr_rep_sort_order_t(Jr_Rep_Sort_Order jr_rep_sort_order_t) {
    this.jr_rep_sort_order_t = jr_rep_sort_order_t;
    this.jr_rep_sort_order = (this.jr_rep_sort_order_t != null?this.jr_rep_sort_order_t.getJr_rep_sort_order():null);
  }



  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_col_sort());
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
    final Jr_Rep_Col_Sort other = (Jr_Rep_Col_Sort) obj;
    if (!Objects.equals(this.getJr_rep_col_sort(), other.getJr_rep_col_sort())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_col_sort();
  }

} 
