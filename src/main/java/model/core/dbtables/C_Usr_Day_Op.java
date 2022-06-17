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
@Table(name = "c_usr_day_op")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Usr_Day_Op extends Abstract_Entity {

  //fields
  private Integer c_usr_day_op;
  private Integer c_usr_day_op_kind;
  private Long c_usr;
  private Long c_usr_2;
  private Date oper_date;
  private Integer oper_day_cnt;
  private String oper_assign;
  private Date ins_dt;
  private Boolean is_confirmed;
  private Boolean is_deleted;

  //transient fields
  private C_Usr_Day_Op_Kind c_usr_day_op_kind_t = null;
  private C_Usr c_usr_t = null;
  private C_Usr c_usr_2_t = null;

  public C_Usr_Day_Op() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_day_op", unique = true, nullable = false)
  public Integer getC_usr_day_op() {
    return this.c_usr_day_op;
  }

  public void setC_usr_day_op(Integer c_usr_day_op) {
    this.c_usr_day_op = c_usr_day_op;
  }

  @Column(name = "c_usr_day_op_kind", nullable = false)
  public Integer getC_usr_day_op_kind() {
    return this.c_usr_day_op_kind;
  }

  public void setC_usr_day_op_kind(Integer c_usr_day_op_kind) {
    this.c_usr_day_op_kind = c_usr_day_op_kind;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name = "c_usr_2")
  public Long getC_usr_2() {
    return this.c_usr_2;
  }

  public void setC_usr_2(Long c_usr_2) {
    this.c_usr_2 = c_usr_2;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "oper_date", nullable = false, length = 10, columnDefinition = "DATE")
  public Date getOper_date() {
    return this.oper_date;
  }

  public void setOper_date(Date oper_date) {
    this.oper_date = oper_date;
  }

  @Column(name = "oper_day_cnt", nullable = false)
  public Integer getOper_day_cnt() {
    return this.oper_day_cnt;
  }

  public void setOper_day_cnt(Integer oper_day_cnt) {
    this.oper_day_cnt = oper_day_cnt;
  }

  
  @Column(name = "oper_assign")
  public String getOper_assign() {
    return this.oper_assign;
  }

  public void setOper_assign(String oper_assign) {
    this.oper_assign = oper_assign;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name = "is_confirmed", nullable = false)
  public Boolean getIs_confirmed() {
    return this.is_confirmed;
  }

  public void setIs_confirmed(Boolean is_confirmed) {
    this.is_confirmed = is_confirmed;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Usr_Day_Op_Kind getC_usr_day_op_kind_t() {
    if (this.c_usr_day_op_kind_t == null && this.getC_usr_day_op_kind() != null) {
      this.c_usr_day_op_kind_t = C_Usr_Day_Op_Kind_Manager.getCI().get_rec(this.getC_usr_day_op_kind());
    }
    return this.c_usr_day_op_kind_t;
  }

  @Transient
  public C_Usr_Day_Op_Kind getC_usr_day_op_kind_t_2(Session session_) {
    if (this.c_usr_day_op_kind_t == null && this.getC_usr_day_op_kind() != null) {
      this.c_usr_day_op_kind_t = C_Usr_Day_Op_Kind_Manager.getCI().get_rec(session_, this.getC_usr_day_op_kind());
    }
    return this.c_usr_day_op_kind_t;
  }

  public void setC_usr_day_op_kind_t(C_Usr_Day_Op_Kind c_usr_day_op_kind_t) {
    this.c_usr_day_op_kind_t = c_usr_day_op_kind_t;
    this.c_usr_day_op_kind = (this.c_usr_day_op_kind_t != null ? this.c_usr_day_op_kind_t.getC_usr_day_op_kind() : null);
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

  @Transient
  public C_Usr getC_usr_2_t() {
    if (this.c_usr_2_t == null && this.getC_usr_2() != null) {
      this.c_usr_2_t = C_Usr_Manager.getCI().get_rec(this.getC_usr_2());
    }
    return this.c_usr_2_t;
  }

  @Transient
  public C_Usr getC_usr_2_t_2(Session session_) {
    if (this.c_usr_2_t == null && this.getC_usr_2() != null) {
      this.c_usr_2_t = C_Usr_Manager.getCI().get_rec(session_, this.getC_usr_2());
    }
    return this.c_usr_2_t;
  }

  public void setC_usr_2_t(C_Usr c_usr_2_t) {
    this.c_usr_2_t = c_usr_2_t;
    this.c_usr_2 = (this.c_usr_2_t != null ? this.c_usr_2_t.getC_usr() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_day_op());
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
    final C_Usr_Day_Op other = (C_Usr_Day_Op) obj;
    if (!Objects.equals(this.getC_usr_day_op(), other.getC_usr_day_op())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_day_op();
  }

}
