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
@Table(name="c_chat_party_status")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Chat_Party_Status extends Abstract_Entity {

  //fields
  private Integer c_chat_party_status;
  private Integer c_tbl;
  private Long rec_id;
  private Date last_visit_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Tbl c_tbl_t = null;



  public C_Chat_Party_Status() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_chat_party_status", unique=true, nullable=false)
  public Integer getC_chat_party_status() {
    return this.c_chat_party_status;
  }
  public void setC_chat_party_status(Integer c_chat_party_status) {
    this.c_chat_party_status = c_chat_party_status;
  }

  @Column(name="c_tbl", nullable=false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }
  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
  }

  @Column(name="rec_id", nullable=false)
  public Long getRec_id() {
    return this.rec_id;
  }
  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="last_visit_dt", length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getLast_visit_dt() {
    return this.last_visit_dt;
  }
  public void setLast_visit_dt(Date last_visit_dt) {
    this.last_visit_dt = last_visit_dt;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Tbl getC_tbl_t() {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(this.getC_tbl()); 
    }
    return this.c_tbl_t;
  }
  @Transient
  public C_Tbl getC_tbl_t_2(Session session_) {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(session_, this.getC_tbl()); 
    }
    return this.c_tbl_t;
  }
  public void setC_tbl_t(C_Tbl c_tbl_t) {
    this.c_tbl_t = c_tbl_t;
    this.c_tbl = (this.c_tbl_t != null?this.c_tbl_t.getC_tbl():null);
  }





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_chat_party_status());
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
    final C_Chat_Party_Status other = (C_Chat_Party_Status) obj;
    if (!Objects.equals(this.getC_chat_party_status(), other.getC_chat_party_status())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_chat_party_status();
  }

} 
