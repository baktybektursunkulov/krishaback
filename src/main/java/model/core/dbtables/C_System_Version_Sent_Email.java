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
@Table(name = "c_system_version_sent_email")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_System_Version_Sent_Email extends Abstract_Entity {

  //fields
  private Integer c_system_version_sent_email;
  private Integer c_system_version;
  private String receiver_email;
  private Integer c_email_out;
  private Boolean is_deleted;

  //transient fields
  private C_System_Version c_system_version_t = null;
  private C_Email_Out c_email_out_t = null;

  public C_System_Version_Sent_Email() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_system_version_sent_email", unique = true, nullable = false)
  public Integer getC_system_version_sent_email() {
    return this.c_system_version_sent_email;
  }

  public void setC_system_version_sent_email(Integer c_system_version_sent_email) {
    this.c_system_version_sent_email = c_system_version_sent_email;
  }

  @Column(name = "c_system_version", nullable = false)
  public Integer getC_system_version() {
    return this.c_system_version;
  }

  public void setC_system_version(Integer c_system_version) {
    this.c_system_version = c_system_version;
  }

  
  @Column(name = "receiver_email", nullable = false)
  public String getReceiver_email() {
    return this.receiver_email;
  }

  public void setReceiver_email(String receiver_email) {
    this.receiver_email = receiver_email;
  }

  @Column(name = "c_email_out", nullable = false)
  public Integer getC_email_out() {
    return this.c_email_out;
  }

  public void setC_email_out(Integer c_email_out) {
    this.c_email_out = c_email_out;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_System_Version getC_system_version_t() {
    if (this.c_system_version_t == null && this.getC_system_version() != null) {
      this.c_system_version_t = C_System_Version_Manager.getCI().get_rec(this.getC_system_version());
    }
    return this.c_system_version_t;
  }

  @Transient
  public C_System_Version getC_system_version_t_2(Session session_) {
    if (this.c_system_version_t == null && this.getC_system_version() != null) {
      this.c_system_version_t = C_System_Version_Manager.getCI().get_rec(session_, this.getC_system_version());
    }
    return this.c_system_version_t;
  }

  public void setC_system_version_t(C_System_Version c_system_version_t) {
    this.c_system_version_t = c_system_version_t;
    this.c_system_version = (this.c_system_version_t != null ? this.c_system_version_t.getC_system_version() : null);
  }

  @Transient
  public C_Email_Out getC_email_out_t() {
    if (this.c_email_out_t == null && this.getC_email_out() != null) {
      this.c_email_out_t = C_Email_Out_Manager.getCI().get_rec(this.getC_email_out());
    }
    return this.c_email_out_t;
  }

  @Transient
  public C_Email_Out getC_email_out_t_2(Session session_) {
    if (this.c_email_out_t == null && this.getC_email_out() != null) {
      this.c_email_out_t = C_Email_Out_Manager.getCI().get_rec(session_, this.getC_email_out());
    }
    return this.c_email_out_t;
  }

  public void setC_email_out_t(C_Email_Out c_email_out_t) {
    this.c_email_out_t = c_email_out_t;
    this.c_email_out = (this.c_email_out_t != null ? this.c_email_out_t.getC_email_out() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_system_version_sent_email());
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
    final C_System_Version_Sent_Email other = (C_System_Version_Sent_Email) obj;
    if (!Objects.equals(this.getC_system_version_sent_email(), other.getC_system_version_sent_email())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_system_version_sent_email();
  }

}
