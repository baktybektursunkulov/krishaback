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
@Table(name = "c_email_verify")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Email_Verify extends Abstract_Entity {

  //fields
  private Integer c_email_verify;
  private String email;
  private Date ins_dt;
  private Boolean is_verified;
  private Date verify_dt;
  private Boolean is_deleted;
  private String verif_code;

  //transient fields
  public C_Email_Verify() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_email_verify", unique = true, nullable = false)
  public Integer getC_email_verify() {
    return this.c_email_verify;
  }

  public void setC_email_verify(Integer c_email_verify) {
    this.c_email_verify = c_email_verify;
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

  @Column(name = "verif_code", nullable = false)
  public String getVerif_code() {
    return verif_code;
  }

  public void setVerif_code(String verif_code) {
    this.verif_code = verif_code;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_email_verify());
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
    final C_Email_Verify other = (C_Email_Verify) obj;
    if (!Objects.equals(this.getC_email_verify(), other.getC_email_verify())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_email_verify();
  }

}
