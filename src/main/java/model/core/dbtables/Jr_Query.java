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
@Table(name="jr_query")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Query extends Abstract_Entity {

  //fields
  private Integer jr_query;
  private Long c_usr;
  private String code;
  private String name;
  private String query_string;

  //transient fields
  private C_Usr c_usr_t = null;


  public Jr_Query() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_query", unique=true, nullable=false)
  public Integer getJr_query() {
    return this.jr_query;
  }
  public void setJr_query(Integer jr_query) {
    this.jr_query = jr_query;
  }

  @Column(name="c_usr", nullable=false)
  public Long getC_usr() {
    return this.c_usr;
  }
  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
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

  @Type(type="text")
  @Column(name="query_string", nullable=false)
  public String getQuery_string() {
    return this.query_string;
  }
  public void setQuery_string(String query_string) {
    this.query_string = query_string;
  }


  @Transient
  public C_Usr getC_usr_t() {
    if (this.c_usr_t == null && this.getC_usr() != null) {
      this.c_usr_t = C_Usr_Manager.getCI().get_rec(this.getC_usr()); 
    }
    return this.c_usr_t;
  }
  @Transient
  public C_Usr getC_usr_t_2(Session session_) {
    if (this.c_usr_t == null && this.getC_usr() != null) {
      this.c_usr_t = C_Usr_Manager.getCI().get_rec(session_, this.getC_usr()); 
    }
    return this.c_usr_t;
  }
  public void setC_usr_t(C_Usr c_usr_t) {
    this.c_usr_t = c_usr_t;
    this.c_usr = (this.c_usr_t != null?this.c_usr_t.getC_usr():null);
  }





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_query());
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
    final Jr_Query other = (Jr_Query) obj;
    if (!Objects.equals(this.getJr_query(), other.getJr_query())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_query();
  }

} 
