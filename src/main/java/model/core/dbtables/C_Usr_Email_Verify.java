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
@Table(name = "c_usr_email_verify")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Email_Verify extends Abstract_Entity {

  //fields
  private Integer c_usr_email_verify;
  private Long c_usr;
  private String email;
  private Date ins_dt;
  private Boolean is_verified;
  private Date verify_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Usr c_usr_t = null;

  public C_Usr_Email_Verify() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_email_verify", unique = true, nullable = false)
  public Integer getC_usr_email_verify() {
    return this.c_usr_email_verify;
  }

  public void setC_usr_email_verify(Integer c_usr_email_verify) {
    this.c_usr_email_verify = c_usr_email_verify;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  
  @Column(name = "email", nullable = false)
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name = "is_verified", nullable = false)
  public Boolean getIs_verified() {
    return this.is_verified;
  }

  public void setIs_verified(Boolean is_verified) {
    this.is_verified = is_verified;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "verify_dt", length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getVerify_dt() {
    return this.verify_dt;
  }

  public void setVerify_dt(Date verify_dt) {
    this.verify_dt = verify_dt;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
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
    hash = 89 * hash + Objects.hashCode(this.getC_usr_email_verify());
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
    final C_Usr_Email_Verify other = (C_Usr_Email_Verify) obj;
    if (!Objects.equals(this.getC_usr_email_verify(), other.getC_usr_email_verify())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_email_verify();
  }

}
