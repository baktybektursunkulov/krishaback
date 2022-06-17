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
@Table(name = "c_usr_log")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Usr_Log extends Abstract_Entity {

  //fields
  private Integer c_usr_log;
  private Long c_usr;
  private Integer c_usr_log_service;
  private Integer c_usr_log_type;
  private Date log_dt;
  private String log_host;
  private Boolean is_deleted;

  //transient fields
  private C_Usr c_usr_t = null;
  private C_Usr_Log_Service c_usr_log_service_t = null;
  private C_Usr_Log_Type c_usr_log_type_t = null;

  public C_Usr_Log() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_log", unique = true, nullable = false)
  public Integer getC_usr_log() {
    return this.c_usr_log;
  }

  public void setC_usr_log(Integer c_usr_log) {
    this.c_usr_log = c_usr_log;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name = "c_usr_log_service", nullable = false)
  public Integer getC_usr_log_service() {
    return this.c_usr_log_service;
  }

  public void setC_usr_log_service(Integer c_usr_log_service) {
    this.c_usr_log_service = c_usr_log_service;
  }

  @Column(name = "c_usr_log_type", nullable = false)
  public Integer getC_usr_log_type() {
    return this.c_usr_log_type;
  }

  public void setC_usr_log_type(Integer c_usr_log_type) {
    this.c_usr_log_type = c_usr_log_type;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "log_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getLog_dt() {
    return this.log_dt;
  }

  public void setLog_dt(Date log_dt) {
    this.log_dt = log_dt;
  }

  
  @Column(name = "log_host", nullable = false)
  public String getLog_host() {
    return this.log_host;
  }

  public void setLog_host(String log_host) {
    this.log_host = log_host;
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

  @Transient
  public C_Usr_Log_Type getC_usr_log_type_t() {
    if (this.c_usr_log_type_t == null && this.getC_usr_log_type() != null) {
      this.c_usr_log_type_t = C_Usr_Log_Type_Manager.getCI().get_rec(this.getC_usr_log_type());
    }
    return this.c_usr_log_type_t;
  }

  @Transient
  public C_Usr_Log_Type getC_usr_log_type_t_2(Session session_) {
    if (this.c_usr_log_type_t == null && this.getC_usr_log_type() != null) {
      this.c_usr_log_type_t = C_Usr_Log_Type_Manager.getCI().get_rec(session_, this.getC_usr_log_type());
    }
    return this.c_usr_log_type_t;
  }

  public void setC_usr_log_type_t(C_Usr_Log_Type c_usr_log_type_t) {
    this.c_usr_log_type_t = c_usr_log_type_t;
    this.c_usr_log_type = (this.c_usr_log_type_t != null ? this.c_usr_log_type_t.getC_usr_log_type() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_log());
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
    final C_Usr_Log other = (C_Usr_Log) obj;
    if (!Objects.equals(this.getC_usr_log(), other.getC_usr_log())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_log();
  }

}
