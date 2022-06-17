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
@Table(name = "c_email_out")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Email_Out extends Abstract_Entity {

  //fields
  private Integer c_email_out;
  private Integer c_proj;
  private Integer c_smtp_security;
  private Integer smtp_server_port;
  private String smtp_server;
  private Boolean is_smtp_authorize;
  private String smtp_login;
  private String smtp_pswd;
  private String sender_name;
  private String sender_email;
  private String receiver_email;
  private String cc;
  private String bcc;
  private String subject;
  private String body;
  private Boolean in_html_format;
  private String lang;
  private Date ins_dt;
  private Boolean is_sent;
  private Date sent_dt;
  private String sent_err_msg;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;
  private C_Smtp_Security c_smtp_security_t = null;

  public C_Email_Out() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_email_out", unique = true, nullable = false)
  public Integer getC_email_out() {
    return this.c_email_out;
  }

  public void setC_email_out(Integer c_email_out) {
    this.c_email_out = c_email_out;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  @Column(name = "c_smtp_security", nullable = false)
  public Integer getC_smtp_security() {
    return this.c_smtp_security;
  }

  public void setC_smtp_security(Integer c_smtp_security) {
    this.c_smtp_security = c_smtp_security;
  }

  @Column(name = "smtp_server_port", nullable = false)
  public Integer getSmtp_server_port() {
    return this.smtp_server_port;
  }

  public void setSmtp_server_port(Integer smtp_server_port) {
    this.smtp_server_port = smtp_server_port;
  }

  
  @Column(name = "smtp_server", nullable = false)
  public String getSmtp_server() {
    return this.smtp_server;
  }

  public void setSmtp_server(String smtp_server) {
    this.smtp_server = smtp_server;
  }

  @Column(name = "is_smtp_authorize", nullable = false)
  public Boolean getIs_smtp_authorize() {
    return this.is_smtp_authorize;
  }

  public void setIs_smtp_authorize(Boolean is_smtp_authorize) {
    this.is_smtp_authorize = is_smtp_authorize;
  }

  
  @Column(name = "smtp_login", nullable = false)
  public String getSmtp_login() {
    return this.smtp_login;
  }

  public void setSmtp_login(String smtp_login) {
    this.smtp_login = smtp_login;
  }

  
  @Column(name = "smtp_pswd", nullable = false)
  public String getSmtp_pswd() {
    return this.smtp_pswd;
  }

  public void setSmtp_pswd(String smtp_pswd) {
    this.smtp_pswd = smtp_pswd;
  }

  
  @Column(name = "sender_name", nullable = false)
  public String getSender_name() {
    return this.sender_name;
  }

  public void setSender_name(String sender_name) {
    this.sender_name = sender_name;
  }

  
  @Column(name = "sender_email", nullable = false)
  public String getSender_email() {
    return this.sender_email;
  }

  public void setSender_email(String sender_email) {
    this.sender_email = sender_email;
  }

  
  @Column(name = "receiver_email", nullable = false)
  public String getReceiver_email() {
    return this.receiver_email;
  }

  public void setReceiver_email(String receiver_email) {
    this.receiver_email = receiver_email;
  }

  
  @Column(name = "cc")
  public String getCc() {
    return this.cc;
  }

  public void setCc(String cc) {
    this.cc = cc;
  }

  
  @Column(name = "bcc")
  public String getBcc() {
    return this.bcc;
  }

  public void setBcc(String bcc) {
    this.bcc = bcc;
  }

  
  @Column(name = "subject", nullable = false)
  public String getSubject() {
    return this.subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Column(name = "body", nullable = false)
  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Column(name = "in_html_format", nullable = false)
  public Boolean getIn_html_format() {
    return this.in_html_format;
  }

  public void setIn_html_format(Boolean in_html_format) {
    this.in_html_format = in_html_format;
  }

  
  @Column(name = "lang", nullable = false)
  public String getLang() {
    return this.lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name = "is_sent", nullable = false)
  public Boolean getIs_sent() {
    return this.is_sent;
  }

  public void setIs_sent(Boolean is_sent) {
    this.is_sent = is_sent;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "sent_dt", length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getSent_dt() {
    return this.sent_dt;
  }

  public void setSent_dt(Date sent_dt) {
    this.sent_dt = sent_dt;
  }

  
  @Column(name = "sent_err_msg")
  public String getSent_err_msg() {
    return this.sent_err_msg;
  }

  public void setSent_err_msg(String sent_err_msg) {
    this.sent_err_msg = sent_err_msg;
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
    this.c_smtp_security = (this.c_smtp_security_t != null ? this.c_smtp_security_t.getC_smtp_security() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_email_out());
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
    final C_Email_Out other = (C_Email_Out) obj;
    if (!Objects.equals(this.getC_email_out(), other.getC_email_out())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_email_out();
  }

}
