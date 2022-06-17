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
@Table(name = "c_limit_log")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Limit_Log extends Abstract_Entity {

  //fields
  private Integer c_limit_log;
  private Integer c_limit;
  private String remote_ip;
  private Date ins_dt;
  private String usr_name;
  private Integer c_usr_log_service;
  private Boolean is_deleted;

  //transient fields
  private C_Limit c_limit_t = null;
  private C_Usr_Log_Service c_usr_log_service_t = null;

  public C_Limit_Log() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_limit_log", unique = true, nullable = false)
  public Integer getC_limit_log() {
    return this.c_limit_log;
  }

  public void setC_limit_log(Integer c_limit_log) {
    this.c_limit_log = c_limit_log;
  }

  @Column(name = "c_limit", nullable = false)
  public Integer getC_limit() {
    return this.c_limit;
  }

  public void setC_limit(Integer c_limit) {
    this.c_limit = c_limit;
  }

  
  @Column(name = "remote_ip", nullable = false)
  public String getRemote_ip() {
    return this.remote_ip;
  }

  public void setRemote_ip(String remote_ip) {
    this.remote_ip = remote_ip;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  
  @Column(name = "usr_name")
  public String getUsr_name() {
    return this.usr_name;
  }

  public void setUsr_name(String usr_name) {
    this.usr_name = usr_name;
  }

  @Column(name = "c_usr_log_service", nullable = false)
  public Integer getC_usr_log_service() {
    return this.c_usr_log_service;
  }

  public void setC_usr_log_service(Integer c_usr_log_service) {
    this.c_usr_log_service = c_usr_log_service;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Limit getC_limit_t() {
    if (this.c_limit_t == null && this.getC_limit() != null) {
      this.c_limit_t = C_Limit_Manager.getCI().get_rec(this.getC_limit());
    }
    return this.c_limit_t;
  }

  @Transient
  public C_Limit getC_limit_t_2(Session session_) {
    if (this.c_limit_t == null && this.getC_limit() != null) {
      this.c_limit_t = C_Limit_Manager.getCI().get_rec(session_, this.getC_limit());
    }
    return this.c_limit_t;
  }

  public void setC_limit_t(C_Limit c_limit_t) {
    this.c_limit_t = c_limit_t;
    this.c_limit = (this.c_limit_t != null ? this.c_limit_t.getC_limit() : null);
  }

  @Transient
  public C_Usr_Log_Service getC_usr_log_service_t() {
    if (this.c_usr_log_service_t == null && this.getC_usr_log_service() != null) {
      this.c_usr_log_service_t = C_Usr_Log_Service_Manager.getCI().get_rec(this.getC_usr_log_service());
    }
    return this.c_usr_log_service_t;
  }

  @Transient
  public C_Usr_Log_Service getC_usr_log_service_t_2(Session session_) {
    if (this.c_usr_log_service_t == null && this.getC_usr_log_service() != null) {
      this.c_usr_log_service_t = C_Usr_Log_Service_Manager.getCI().get_rec(session_, this.getC_usr_log_service());
    }
    return this.c_usr_log_service_t;
  }

  public void setC_usr_log_service_t(C_Usr_Log_Service c_usr_log_service_t) {
    this.c_usr_log_service_t = c_usr_log_service_t;
    this.c_usr_log_service = (this.c_usr_log_service_t != null ? this.c_usr_log_service_t.getC_usr_log_service() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_limit_log());
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
    final C_Limit_Log other = (C_Limit_Log) obj;
    if (!Objects.equals(this.getC_limit_log(), other.getC_limit_log())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_limit_log();
  }

}
