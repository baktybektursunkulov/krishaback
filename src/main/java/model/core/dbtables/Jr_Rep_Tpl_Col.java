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
@Table(name="jr_rep_tpl_col")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Tpl_Col extends Abstract_Entity {

  //fields
  private Integer jr_rep_tpl_col;
  private Integer jr_rep_tpl;
  private String code;
  private String name;
  private Integer order_num;

  //transient fields
  private Jr_Rep_Tpl jr_rep_tpl_t = null;


  public Jr_Rep_Tpl_Col() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_rep_tpl_col", unique=true, nullable=false)
  public Integer getJr_rep_tpl_col() {
    return this.jr_rep_tpl_col;
  }
  public void setJr_rep_tpl_col(Integer jr_rep_tpl_col) {
    this.jr_rep_tpl_col = jr_rep_tpl_col;
  }

  @Column(name="jr_rep_tpl", nullable=false)
  public Integer getJr_rep_tpl() {
    return this.jr_rep_tpl;
  }
  public void setJr_rep_tpl(Integer jr_rep_tpl) {
    this.jr_rep_tpl = jr_rep_tpl;
  }

  @Type(type="text")
  @Column(name="code", nullable=false)
  public String getCode() {
    return this.code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  @Type(type="text")
  @Column(name="name", nullable=false)
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Column(name="order_num", nullable=false)
  public Integer getOrder_num() {
    return this.order_num;
  }
  public void setOrder_num(Integer order_num) {
    this.order_num = order_num;
  }


  @Transient
  public Jr_Rep_Tpl getJr_rep_tpl_t() {
    if (this.jr_rep_tpl_t == null && this.getJr_rep_tpl() != null) {
      this.jr_rep_tpl_t = Jr_Rep_Tpl_Manager.getCI().get_rec(this.getJr_rep_tpl()); 
    }
    return this.jr_rep_tpl_t;
  }
  @Transient
  public Jr_Rep_Tpl getJr_rep_tpl_t_2(Session session_) {
    if (this.jr_rep_tpl_t == null && this.getJr_rep_tpl() != null) {
      this.jr_rep_tpl_t = Jr_Rep_Tpl_Manager.getCI().get_rec(session_, this.getJr_rep_tpl()); 
    }
    return this.jr_rep_tpl_t;
  }
  public void setJr_rep_tpl_t(Jr_Rep_Tpl jr_rep_tpl_t) {
    this.jr_rep_tpl_t = jr_rep_tpl_t;
    this.jr_rep_tpl = (this.jr_rep_tpl_t != null?this.jr_rep_tpl_t.getJr_rep_tpl():null);
  }





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_tpl_col());
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
    final Jr_Rep_Tpl_Col other = (Jr_Rep_Tpl_Col) obj;
    if (!Objects.equals(this.getJr_rep_tpl_col(), other.getJr_rep_tpl_col())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_tpl_col();
  }

} 
