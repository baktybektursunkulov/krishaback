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
@Table(name="jr_rep_col_fil_type")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Col_Fil_Type extends Abstract_Entity {

  //fields
  private Integer jr_rep_col_fil_type;
  private String code;
  private String name;

  //transient fields


  public Jr_Rep_Col_Fil_Type() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_rep_col_fil_type", unique=true, nullable=false)
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





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_col_fil_type());
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
    final Jr_Rep_Col_Fil_Type other = (Jr_Rep_Col_Fil_Type) obj;
    if (!Objects.equals(this.getJr_rep_col_fil_type(), other.getJr_rep_col_fil_type())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_col_fil_type();
  }

} 
