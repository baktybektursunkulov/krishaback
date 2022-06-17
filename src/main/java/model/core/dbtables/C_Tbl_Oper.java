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
@Table(name = "c_tbl_oper")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Tbl_Oper extends Abstract_Entity {

  //fields
  private Integer c_tbl_oper;
  private Integer c_tbl;
  private Integer c_tbl_oper_kind;
  private Long rec_id;
  private Date oper_dt;
  private Long c_usr;
  private String changes_txt;
  private Boolean is_deleted;

  //transient fields
  private C_Tbl c_tbl_t = null;
  private C_Tbl_Oper_Kind c_tbl_oper_kind_t = null;
  private C_Usr c_usr_t = null;

  public C_Tbl_Oper() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_tbl_oper", unique = true, nullable = false)
  public Integer getC_tbl_oper() {
    return this.c_tbl_oper;
  }

  public void setC_tbl_oper(Integer c_tbl_oper) {
    this.c_tbl_oper = c_tbl_oper;
  }

  @Column(name = "c_tbl", nullable = false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }

  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
  }

  @Column(name = "c_tbl_oper_kind", nullable = false)
  public Integer getC_tbl_oper_kind() {
    return this.c_tbl_oper_kind;
  }

  public void setC_tbl_oper_kind(Integer c_tbl_oper_kind) {
    this.c_tbl_oper_kind = c_tbl_oper_kind;
  }

  @Column(name = "rec_id", nullable = false)
  public Long getRec_id() {
    return this.rec_id;
  }

  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "oper_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getOper_dt() {
    return this.oper_dt;
  }

  public void setOper_dt(Date oper_dt) {
    this.oper_dt = oper_dt;
  }

  @Column(name = "c_usr", nullable = true)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  
  @Column(name = "changes_txt")
  public String getChanges_txt() {
    return this.changes_txt;
  }

  public void setChanges_txt(String changes_txt) {
    this.changes_txt = changes_txt;
  }

  @Column(name = "is_deleted", nullable = false)
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
    this.c_tbl = (this.c_tbl_t != null ? this.c_tbl_t.getC_tbl() : null);
  }

  @Transient
  public C_Tbl_Oper_Kind getC_tbl_oper_kind_t() {
    if (this.c_tbl_oper_kind_t == null && this.getC_tbl_oper_kind() != null) {
      this.c_tbl_oper_kind_t = C_Tbl_Oper_Kind_Manager.getCI().get_rec(this.getC_tbl_oper_kind());
    }
    return this.c_tbl_oper_kind_t;
  }

  @Transient
  public C_Tbl_Oper_Kind getC_tbl_oper_kind_t_2(Session session_) {
    if (this.c_tbl_oper_kind_t == null && this.getC_tbl_oper_kind() != null) {
      this.c_tbl_oper_kind_t = C_Tbl_Oper_Kind_Manager.getCI().get_rec(session_, this.getC_tbl_oper_kind());
    }
    return this.c_tbl_oper_kind_t;
  }

  public void setC_tbl_oper_kind_t(C_Tbl_Oper_Kind c_tbl_oper_kind_t) {
    this.c_tbl_oper_kind_t = c_tbl_oper_kind_t;
    this.c_tbl_oper_kind = (this.c_tbl_oper_kind_t != null ? this.c_tbl_oper_kind_t.getC_tbl_oper_kind() : null);
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
    this.c_usr = (this.c_usr_t != null ? this.c_usr_t.getC_usr() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_oper());
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
    final C_Tbl_Oper other = (C_Tbl_Oper) obj;
    if (!Objects.equals(this.getC_tbl_oper(), other.getC_tbl_oper())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_oper();
  }

}
