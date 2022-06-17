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
@Table(name = "c_usr_phone_num_verify")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Phone_Num_Verify extends Abstract_Entity {

  //fields
  private Integer c_usr_phone_num_verify;
  private String phone_num;
  private String pin_code;
  private Date ins_dt;
  private Boolean is_verified;
  private Date verify_dt;
  private Boolean is_deleted;

  //transient fields
  public C_Usr_Phone_Num_Verify() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_phone_num_verify", unique = true, nullable = false)
  public Integer getC_usr_phone_num_verify() {
    return this.c_usr_phone_num_verify;
  }

  public void setC_usr_phone_num_verify(Integer c_usr_phone_num_verify) {
    this.c_usr_phone_num_verify = c_usr_phone_num_verify;
  }

  
  @Column(name = "phone_num", nullable = false)
  public String getPhone_num() {
    return this.phone_num;
  }

  public void setPhone_num(String phone_num) {
    this.phone_num = phone_num;
  }

  
  @Column(name = "pin_code", nullable = false)
  public String getPin_code() {
    return this.pin_code;
  }

  public void setPin_code(String pin_code) {
    this.pin_code = pin_code;
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_phone_num_verify());
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
    final C_Usr_Phone_Num_Verify other = (C_Usr_Phone_Num_Verify) obj;
    if (!Objects.equals(this.getC_usr_phone_num_verify(), other.getC_usr_phone_num_verify())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_phone_num_verify();
  }

}
