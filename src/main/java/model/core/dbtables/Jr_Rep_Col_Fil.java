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
@Table(name="jr_rep_col_fil")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Col_Fil extends Abstract_Entity {

  //fields
  private Integer jr_rep_col_fil;
  private Integer jr_rep;
  private Integer order_num;
  private Integer jr_rep_tpl_col;
  private Integer jr_rep_col_fil_type;
  private Integer jr_rep_col_fil_type_op;
  private String start_val;
  private String final_val;

  //transient fields
  private Jr_Rep jr_rep_t = null;
  private Jr_Rep_Tpl_Col jr_rep_tpl_col_t = null;
  private Jr_Rep_Col_Fil_Type jr_rep_col_fil_type_t = null;
  private Jr_Rep_Col_Fil_Type_Op jr_rep_col_fil_type_op_t = null;


  public Jr_Rep_Col_Fil() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_rep_col_fil", unique=true, nullable=false)
  public Integer getJr_rep_col_fil() {
    return this.jr_rep_col_fil;
  }
  public void setJr_rep_col_fil(Integer jr_rep_col_fil) {
    this.jr_rep_col_fil = jr_rep_col_fil;
  }

  @Column(name="jr_rep", nullable=false)
  public Integer getJr_rep() {
    return this.jr_rep;
  }
  public void setJr_rep(Integer jr_rep) {
    this.jr_rep = jr_rep;
  }

  @Column(name="order_num", nullable=false)
  public Integer getOrder_num() {
    return this.order_num;
  }
  public void setOrder_num(Integer order_num) {
    this.order_num = order_num;
  }

  @Column(name="jr_rep_tpl_col", nullable=false)
  public Integer getJr_rep_tpl_col() {
    return this.jr_rep_tpl_col;
  }
  public void setJr_rep_tpl_col(Integer jr_rep_tpl_col) {
    this.jr_rep_tpl_col = jr_rep_tpl_col;
  }

  @Column(name="jr_rep_col_fil_type", nullable=false)
  public Integer getJr_rep_col_fil_type() {
    return this.jr_rep_col_fil_type;
  }
  public void setJr_rep_col_fil_type(Integer jr_rep_col_fil_type) {
    this.jr_rep_col_fil_type = jr_rep_col_fil_type;
  }

  @Column(name="jr_rep_col_fil_type_op", nullable=false)
  public Integer getJr_rep_col_fil_type_op() {
    return this.jr_rep_col_fil_type_op;
  }
  public void setJr_rep_col_fil_type_op(Integer jr_rep_col_fil_type_op) {
    this.jr_rep_col_fil_type_op = jr_rep_col_fil_type_op;
  }

  @Type(type="text")
  @Column(name="start_val", nullable=false)
  public String getStart_val() {
    return this.start_val;
  }
  public void setStart_val(String start_val) {
    this.start_val = start_val;
  }

  @Type(type="text")
  @Column(name="final_val")
  public String getFinal_val() {
    return this.final_val;
  }
  public void setFinal_val(String final_val) {
    this.final_val = final_val;
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
  public Jr_Rep_Col_Fil_Type getJr_rep_col_fil_type_t() {
    if (this.jr_rep_col_fil_type_t == null && this.getJr_rep_col_fil_type() != null) {
      this.jr_rep_col_fil_type_t = Jr_Rep_Col_Fil_Type_Manager.getCI().get_rec(this.getJr_rep_col_fil_type()); 
    }
    return this.jr_rep_col_fil_type_t;
  }
  @Transient
  public Jr_Rep_Col_Fil_Type getJr_rep_col_fil_type_t_2(Session session_) {
    if (this.jr_rep_col_fil_type_t == null && this.getJr_rep_col_fil_type() != null) {
      this.jr_rep_col_fil_type_t = Jr_Rep_Col_Fil_Type_Manager.getCI().get_rec(session_, this.getJr_rep_col_fil_type()); 
    }
    return this.jr_rep_col_fil_type_t;
  }
  public void setJr_rep_col_fil_type_t(Jr_Rep_Col_Fil_Type jr_rep_col_fil_type_t) {
    this.jr_rep_col_fil_type_t = jr_rep_col_fil_type_t;
    this.jr_rep_col_fil_type = (this.jr_rep_col_fil_type_t != null?this.jr_rep_col_fil_type_t.getJr_rep_col_fil_type():null);
  }

  @Transient
  public Jr_Rep_Col_Fil_Type_Op getJr_rep_col_fil_type_op_t() {
    if (this.jr_rep_col_fil_type_op_t == null && this.getJr_rep_col_fil_type_op() != null) {
      this.jr_rep_col_fil_type_op_t = Jr_Rep_Col_Fil_Type_Op_Manager.getCI().get_rec(this.getJr_rep_col_fil_type_op()); 
    }
    return this.jr_rep_col_fil_type_op_t;
  }
  @Transient
  public Jr_Rep_Col_Fil_Type_Op getJr_rep_col_fil_type_op_t_2(Session session_) {
    if (this.jr_rep_col_fil_type_op_t == null && this.getJr_rep_col_fil_type_op() != null) {
      this.jr_rep_col_fil_type_op_t = Jr_Rep_Col_Fil_Type_Op_Manager.getCI().get_rec(session_, this.getJr_rep_col_fil_type_op()); 
    }
    return this.jr_rep_col_fil_type_op_t;
  }
  public void setJr_rep_col_fil_type_op_t(Jr_Rep_Col_Fil_Type_Op jr_rep_col_fil_type_op_t) {
    this.jr_rep_col_fil_type_op_t = jr_rep_col_fil_type_op_t;
    this.jr_rep_col_fil_type_op = (this.jr_rep_col_fil_type_op_t != null?this.jr_rep_col_fil_type_op_t.getJr_rep_col_fil_type_op():null);
  }




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_col_fil());
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
    final Jr_Rep_Col_Fil other = (Jr_Rep_Col_Fil) obj;
    if (!Objects.equals(this.getJr_rep_col_fil(), other.getJr_rep_col_fil())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_col_fil();
  }

} 
