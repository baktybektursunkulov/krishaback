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
@Table(name="c_proj_sender_email")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Proj_Sender_Email extends Abstract_Entity {

  //fields
  private Integer c_proj_sender_email;
  private Integer c_proj;
  private String sender_email;
  private String sender_name;
  private Boolean is_smtp_authorize;
  private Integer c_smtp_security;
  private Integer smtp_server_port;
  private String smtp_login;
  private String smtp_pswd;
  private String smtp_server;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;
  private C_Smtp_Security c_smtp_security_t = null;


  public C_Proj_Sender_Email() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_proj_sender_email", unique=true, nullable=false)
  public Integer getC_proj_sender_email() {
    return this.c_proj_sender_email;
  }
  public void setC_proj_sender_email(Integer c_proj_sender_email) {
    this.c_proj_sender_email = c_proj_sender_email;
  }

  @Column(name="c_proj", nullable=false)
  public Integer getC_proj() {
    return this.c_proj;
  }
  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  @Type(type="text")
  @Column(name="sender_email")
  public String getSender_email() {
    return this.sender_email;
  }
  public void setSender_email(String sender_email) {
    this.sender_email = sender_email;
  }

  @Type(type="text")
  @Column(name="sender_name")
  public String getSender_name() {
    return this.sender_name;
  }
  public void setSender_name(String sender_name) {
    this.sender_name = sender_name;
  }

  @Column(name="is_smtp_authorize")
  public Boolean getIs_smtp_authorize() {
    return this.is_smtp_authorize;
  }
  public void setIs_smtp_authorize(Boolean is_smtp_authorize) {
    this.is_smtp_authorize = is_smtp_authorize;
  }

  @Column(name="c_smtp_security", nullable=false)
  public Integer getC_smtp_security() {
    return this.c_smtp_security;
  }
  public void setC_smtp_security(Integer c_smtp_security) {
    this.c_smtp_security = c_smtp_security;
  }

  @Column(name="smtp_server_port")
  public Integer getSmtp_server_port() {
    return this.smtp_server_port;
  }
  public void setSmtp_server_port(Integer smtp_server_port) {
    this.smtp_server_port = smtp_server_port;
  }

  @Type(type="text")
  @Column(name="smtp_login")
  public String getSmtp_login() {
    return this.smtp_login;
  }
  public void setSmtp_login(String smtp_login) {
    this.smtp_login = smtp_login;
  }

  @Type(type="text")
  @Column(name="smtp_pswd")
  public String getSmtp_pswd() {
    return this.smtp_pswd;
  }
  public void setSmtp_pswd(String smtp_pswd) {
    this.smtp_pswd = smtp_pswd;
  }

  @Type(type="text")
  @Column(name="smtp_server")
  public String getSmtp_server() {
    return this.smtp_server;
  }
  public void setSmtp_server(String smtp_server) {
    this.smtp_server = smtp_server;
  }

  @Column(name="is_deleted", nullable=false)
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
    this.c_proj = (this.c_proj_t != null?this.c_proj_t.getC_proj():null);
  }




  @Transient
  public C_Smtp_Security getC_smtp_security_t() {
    if (this.c_smtp_security_t == null && this.getC_smtp_security() != null) {
      this.c_smtp_security_t = C_Smtp_Security_Manager.getCI().get_rec(this.getC_smtp_security()); 
    }
    return this.c_smtp_security_t;
  }
  @Transient
  public C_Smtp_Security getC_smtp_security_t_2(Session session_) {
    if (this.c_smtp_security_t == null && this.getC_smtp_security() != null) {
      this.c_smtp_security_t = C_Smtp_Security_Manager.getCI().get_rec(session_, this.getC_smtp_security()); 
    }
    return this.c_smtp_security_t;
  }
  public void setC_smtp_security_t(C_Smtp_Security c_smtp_security_t) {
    this.c_smtp_security_t = c_smtp_security_t;
    this.c_smtp_security = (this.c_smtp_security_t != null?this.c_smtp_security_t.getC_smtp_security():null);
  }







  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_proj_sender_email());
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
    final C_Proj_Sender_Email other = (C_Proj_Sender_Email) obj;
    if (!Objects.equals(this.getC_proj_sender_email(), other.getC_proj_sender_email())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_proj_sender_email();
  }

} 
