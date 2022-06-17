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
@Table(name="jr_input_control_type")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Input_Control_Type extends Abstract_Entity {

  //fields
  private Integer jr_input_control_type;
  private String code;
  private String name;

  //transient fields


  public Jr_Input_Control_Type() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_input_control_type", unique=true, nullable=false)
  public Integer getJr_input_control_type() {
    return this.jr_input_control_type;
  }
  public void setJr_input_control_type(Integer jr_input_control_type) {
    this.jr_input_control_type = jr_input_control_type;
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
    hash = 89 * hash + Objects.hashCode(this.getJr_input_control_type());
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
    final Jr_Input_Control_Type other = (Jr_Input_Control_Type) obj;
    if (!Objects.equals(this.getJr_input_control_type(), other.getJr_input_control_type())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_input_control_type();
  }

} 
