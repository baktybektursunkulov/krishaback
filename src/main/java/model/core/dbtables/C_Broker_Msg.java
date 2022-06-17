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
@Table(name="c_broker_msg")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Broker_Msg extends Abstract_Entity {

  //fields
  private Integer c_broker_msg;
  private Integer c_broker_sender;
  private String subject;
  private String body;
  private String params;
  private Date ins_dt;
  private Boolean is_sent;
  private Date sent_dt;
  private String sent_err_msg;
  private Boolean is_deleted;

  //transient fields
  private C_Broker_Sender c_broker_sender_t = null;



  public C_Broker_Msg() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_broker_msg", unique=true, nullable=false)
  public Integer getC_broker_msg() {
    return this.c_broker_msg;
  }
  public void setC_broker_msg(Integer c_broker_msg) {
    this.c_broker_msg = c_broker_msg;
  }

  @Column(name="c_broker_sender", nullable=false)
  public Integer getC_broker_sender() {
    return this.c_broker_sender;
  }
  public void setC_broker_sender(Integer c_broker_sender) {
    this.c_broker_sender = c_broker_sender;
  }

  @Type(type="text")
  @Column(name="subject", nullable=false)
  public String getSubject() {
    return this.subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Type(type="text")
  @Column(name="body", nullable=false)
  public String getBody() {
    return this.body;
  }
  public void setBody(String body) {
    this.body = body;
  }

  @Column(name="params")
  public String getParams() {
    return this.params;
  }
  public void setParams(String params) {
    this.params = params;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ins_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }
  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name="is_sent", nullable=false)
  public Boolean getIs_sent() {
    return this.is_sent;
  }
  public void setIs_sent(Boolean is_sent) {
    this.is_sent = is_sent;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="sent_dt", length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getSent_dt() {
    return this.sent_dt;
  }
  public void setSent_dt(Date sent_dt) {
    this.sent_dt = sent_dt;
  }

  @Type(type="text")
  @Column(name="sent_err_msg")
  public String getSent_err_msg() {
    return this.sent_err_msg;
  }
  public void setSent_err_msg(String sent_err_msg) {
    this.sent_err_msg = sent_err_msg;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Broker_Sender getC_broker_sender_t() {
    if (this.c_broker_sender_t == null && this.getC_broker_sender() != null) {
      this.c_broker_sender_t = C_Broker_Sender_Manager.getCI().get_rec(this.getC_broker_sender()); 
    }
    return this.c_broker_sender_t;
  }
  @Transient
  public C_Broker_Sender getC_broker_sender_t_2(Session session_) {
    if (this.c_broker_sender_t == null && this.getC_broker_sender() != null) {
      this.c_broker_sender_t = C_Broker_Sender_Manager.getCI().get_rec(session_, this.getC_broker_sender()); 
    }
    return this.c_broker_sender_t;
  }
  public void setC_broker_sender_t(C_Broker_Sender c_broker_sender_t) {
    this.c_broker_sender_t = c_broker_sender_t;
    this.c_broker_sender = (this.c_broker_sender_t != null?this.c_broker_sender_t.getC_broker_sender():null);
  }










  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_broker_msg());
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
    final C_Broker_Msg other = (C_Broker_Msg) obj;
    if (!Objects.equals(this.getC_broker_msg(), other.getC_broker_msg())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_broker_msg();
  }

} 
