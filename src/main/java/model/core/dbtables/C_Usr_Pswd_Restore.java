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
@Table(name = "c_usr_pswd_restore")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Pswd_Restore extends Abstract_Entity {

  //fields
  private Integer c_usr_pswd_restore;
  private Integer c_proj;
  private Integer c_usr_type;
  private String usr_name;
  private String e_mail;
  private String code;
  private Date exp_dt;
  private Boolean is_used;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;
  private C_Usr_Type c_usr_type_t = null;

  public C_Usr_Pswd_Restore() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_pswd_restore", unique = true, nullable = false)
  public Integer getC_usr_pswd_restore() {
    return this.c_usr_pswd_restore;
  }

  public void setC_usr_pswd_restore(Integer c_usr_pswd_restore) {
    this.c_usr_pswd_restore = c_usr_pswd_restore;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  @Column(name = "c_usr_type", nullable = false)
  public Integer getC_usr_type() {
    return this.c_usr_type;
  }

  public void setC_usr_type(Integer c_usr_type) {
    this.c_usr_type = c_usr_type;
  }

  
  @Column(name = "usr_name", nullable = false)
  public String getUsr_name() {
    return this.usr_name;
  }

  public void setUsr_name(String usr_name) {
    this.usr_name = usr_name;
  }

  
  @Column(name = "e_mail", nullable = false)
  public String getE_mail() {
    return this.e_mail;
  }

  public void setE_mail(String e_mail) {
    this.e_mail = e_mail;
  }

  
  @Column(name = "code", nullable = false)
  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "exp_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getExp_dt() {
    return this.exp_dt;
  }

  public void setExp_dt(Date exp_dt) {
    this.exp_dt = exp_dt;
  }

  @Column(name = "is_used", nullable = false)
  public Boolean getIs_used() {
    return this.is_used;
  }

  public void setIs_used(Boolean is_used) {
    this.is_used = is_used;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Proj getC_proj_t() {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(this.getC_proj());
    }
    return this.c_proj_t;
  }

  @Transient
  public C_Proj getC_proj_t_2(Session session_) {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(session_, this.getC_proj());
    }
    return this.c_proj_t;
  }

  public void setC_proj_t(C_Proj c_proj_t) {
    this.c_proj_t = c_proj_t;
    this.c_proj = (this.c_proj_t != null ? this.c_proj_t.getC_proj() : null);
  }

  @Transient
  public C_Usr_Type getC_usr_type_t() {
    if (this.c_usr_type_t == null && this.getC_usr_type() != null) {
      this.c_usr_type_t = C_Usr_Type_Manager.getCI().get_rec(this.getC_usr_type());
    }
    return this.c_usr_type_t;
  }

  @Transient
  public C_Usr_Type getC_usr_type_t_2(Session session_) {
    if (this.c_usr_type_t == null && this.getC_usr_type() != null) {
      this.c_usr_type_t = C_Usr_Type_Manager.getCI().get_rec(session_, this.getC_usr_type());
    }
    return this.c_usr_type_t;
  }

  public void setC_usr_type_t(C_Usr_Type c_usr_type_t) {
    this.c_usr_type_t = c_usr_type_t;
    this.c_usr_type = (this.c_usr_type_t != null ? this.c_usr_type_t.getC_usr_type() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_pswd_restore());
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
    final C_Usr_Pswd_Restore other = (C_Usr_Pswd_Restore) obj;
    if (!Objects.equals(this.getC_usr_pswd_restore(), other.getC_usr_pswd_restore())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_pswd_restore();
  }

}
