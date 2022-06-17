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
@Table(name="c_session")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Session extends Abstract_Entity {

  //fields
  private Long c_session;
  private Integer c_session_type;
  private String session_id;
  private Date ins_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Session_Type c_session_type_t = null;



  public C_Session() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_session", unique=true, nullable=false)
  public Long getC_session() {
    return this.c_session;
  }
  public void setC_session(Long c_session) {
    this.c_session = c_session;
  }

  @Column(name="c_session_type", nullable=false)
  public Integer getC_session_type() {
    return this.c_session_type;
  }
  public void setC_session_type(Integer c_session_type) {
    this.c_session_type = c_session_type;
  }

  @Type(type="text")
  @Column(name="session_id", nullable=false)
  public String getSession_id() {
    return this.session_id;
  }
  public void setSession_id(String session_id) {
    this.session_id = session_id;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ins_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }
  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Session_Type getC_session_type_t() {
    if (this.c_session_type_t == null && this.getC_session_type() != null) {
      this.c_session_type_t = C_Session_Type_Manager.getCI().get_rec(this.getC_session_type()); 
    }
    return this.c_session_type_t;
  }
  @Transient
  public C_Session_Type getC_session_type_t_2(Session session_) {
    if (this.c_session_type_t == null && this.getC_session_type() != null) {
      this.c_session_type_t = C_Session_Type_Manager.getCI().get_rec(session_, this.getC_session_type()); 
    }
    return this.c_session_type_t;
  }
  public void setC_session_type_t(C_Session_Type c_session_type_t) {
    this.c_session_type_t = c_session_type_t;
    this.c_session_type = (this.c_session_type_t != null?this.c_session_type_t.getC_session_type():null);
  }





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_session());
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
    final C_Session other = (C_Session) obj;
    if (!Objects.equals(this.getC_session(), other.getC_session())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_session();
  }

} 
