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
@Table(name="jr_rep_page_orient")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Page_Orient extends Abstract_Entity {

  //fields
  private Integer jr_rep_page_orient;
  private String code;
  private String name;

  //transient fields


  public Jr_Rep_Page_Orient() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_rep_page_orient", unique=true, nullable=false)
  public Integer getJr_rep_page_orient() {
    return this.jr_rep_page_orient;
  }
  public void setJr_rep_page_orient(Integer jr_rep_page_orient) {
    this.jr_rep_page_orient = jr_rep_page_orient;
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
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_page_orient());
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
    final Jr_Rep_Page_Orient other = (Jr_Rep_Page_Orient) obj;
    if (!Objects.equals(this.getJr_rep_page_orient(), other.getJr_rep_page_orient())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_page_orient();
  }

} 
