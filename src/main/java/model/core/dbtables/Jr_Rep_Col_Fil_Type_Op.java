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
@Table(name="jr_rep_col_fil_type_op")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Col_Fil_Type_Op extends Abstract_Entity {

  //fields
  private Integer jr_rep_col_fil_type_op;
  private Integer jr_rep_col_fil_type;
  private String code;
  private String name;

  //transient fields
  private Jr_Rep_Col_Fil_Type jr_rep_col_fil_type_t = null;


  public Jr_Rep_Col_Fil_Type_Op() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_rep_col_fil_type_op", unique=true, nullable=false)
  public Integer getJr_rep_col_fil_type_op() {
    return this.jr_rep_col_fil_type_op;
  }
  public void setJr_rep_col_fil_type_op(Integer jr_rep_col_fil_type_op) {
    this.jr_rep_col_fil_type_op = jr_rep_col_fil_type_op;
  }

  @Column(name="jr_rep_col_fil_type", nullable=false)
  public Integer getJr_rep_col_fil_type() {
    return this.jr_rep_col_fil_type;
  }
  public void setJr_rep_col_fil_type(Integer jr_rep_col_fil_type) {
    this.jr_rep_col_fil_type = jr_rep_col_fil_type;
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




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_col_fil_type_op());
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
    final Jr_Rep_Col_Fil_Type_Op other = (Jr_Rep_Col_Fil_Type_Op) obj;
    if (!Objects.equals(this.getJr_rep_col_fil_type_op(), other.getJr_rep_col_fil_type_op())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_col_fil_type_op();
  }

} 
