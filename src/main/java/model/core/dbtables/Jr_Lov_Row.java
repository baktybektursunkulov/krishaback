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
@Table(name="jr_lov_row")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Lov_Row extends Abstract_Entity {

  //fields
  private Integer jr_lov_row;
  private Integer jr_lov;
  private String name;
  private String val;

  //transient fields
  private Jr_Lov jr_lov_t = null;


  public Jr_Lov_Row() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_lov_row", unique=true, nullable=false)
  public Integer getJr_lov_row() {
    return this.jr_lov_row;
  }
  public void setJr_lov_row(Integer jr_lov_row) {
    this.jr_lov_row = jr_lov_row;
  }

  @Column(name="jr_lov", nullable=false)
  public Integer getJr_lov() {
    return this.jr_lov;
  }
  public void setJr_lov(Integer jr_lov) {
    this.jr_lov = jr_lov;
  }

  @Type(type="text")
  @Column(name="name", nullable=false)
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Type(type="text")
  @Column(name="val", nullable=false)
  public String getVal() {
    return this.val;
  }
  public void setVal(String val) {
    this.val = val;
  }


  @Transient
  public Jr_Lov getJr_lov_t() {
    if (this.jr_lov_t == null && this.getJr_lov() != null) {
      this.jr_lov_t = Jr_Lov_Manager.getCI().get_rec(this.getJr_lov()); 
    }
    return this.jr_lov_t;
  }
  @Transient
  public Jr_Lov getJr_lov_t_2(Session session_) {
    if (this.jr_lov_t == null && this.getJr_lov() != null) {
      this.jr_lov_t = Jr_Lov_Manager.getCI().get_rec(session_, this.getJr_lov()); 
    }
    return this.jr_lov_t;
  }
  public void setJr_lov_t(Jr_Lov jr_lov_t) {
    this.jr_lov_t = jr_lov_t;
    this.jr_lov = (this.jr_lov_t != null?this.jr_lov_t.getJr_lov():null);
  }




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_lov_row());
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
    final Jr_Lov_Row other = (Jr_Lov_Row) obj;
    if (!Objects.equals(this.getJr_lov_row(), other.getJr_lov_row())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_lov_row();
  }

} 
