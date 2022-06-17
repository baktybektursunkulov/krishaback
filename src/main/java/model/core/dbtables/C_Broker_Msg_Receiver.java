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
@Table(name="c_broker_msg_receiver")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Broker_Msg_Receiver extends Abstract_Entity {

  //fields
  private Integer c_broker_msg_receiver;
  private Integer c_broker_msg;
  private Integer c_broker_receiver;
  private Date receive_dt;
  private String receive_err_msg;

  //transient fields
  private C_Broker_Msg c_broker_msg_t = null;
  private C_Broker_Receiver c_broker_receiver_t = null;



  public C_Broker_Msg_Receiver() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_broker_msg_receiver", unique=true, nullable=false)
  public Integer getC_broker_msg_receiver() {
    return this.c_broker_msg_receiver;
  }
  public void setC_broker_msg_receiver(Integer c_broker_msg_receiver) {
    this.c_broker_msg_receiver = c_broker_msg_receiver;
  }

  @Column(name="c_broker_msg", nullable=false)
  public Integer getC_broker_msg() {
    return this.c_broker_msg;
  }
  public void setC_broker_msg(Integer c_broker_msg) {
    this.c_broker_msg = c_broker_msg;
  }

  @Column(name="c_broker_receiver", nullable=false)
  public Integer getC_broker_receiver() {
    return this.c_broker_receiver;
  }
  public void setC_broker_receiver(Integer c_broker_receiver) {
    this.c_broker_receiver = c_broker_receiver;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="receive_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getReceive_dt() {
    return this.receive_dt;
  }
  public void setReceive_dt(Date receive_dt) {
    this.receive_dt = receive_dt;
  }

  @Type(type="text")
  @Column(name="receive_err_msg")
  public String getReceive_err_msg() {
    return this.receive_err_msg;
  }
  public void setReceive_err_msg(String receive_err_msg) {
    this.receive_err_msg = receive_err_msg;
  }


  @Transient
  public C_Broker_Msg getC_broker_msg_t() {
    if (this.c_broker_msg_t == null && this.getC_broker_msg() != null) {
      this.c_broker_msg_t = C_Broker_Msg_Manager.getCI().get_rec(this.getC_broker_msg()); 
    }
    return this.c_broker_msg_t;
  }
  @Transient
  public C_Broker_Msg getC_broker_msg_t_2(Session session_) {
    if (this.c_broker_msg_t == null && this.getC_broker_msg() != null) {
      this.c_broker_msg_t = C_Broker_Msg_Manager.getCI().get_rec(session_, this.getC_broker_msg()); 
    }
    return this.c_broker_msg_t;
  }
  public void setC_broker_msg_t(C_Broker_Msg c_broker_msg_t) {
    this.c_broker_msg_t = c_broker_msg_t;
    this.c_broker_msg = (this.c_broker_msg_t != null?this.c_broker_msg_t.getC_broker_msg():null);
  }

  @Transient
  public C_Broker_Receiver getC_broker_receiver_t() {
    if (this.c_broker_receiver_t == null && this.getC_broker_receiver() != null) {
      this.c_broker_receiver_t = C_Broker_Receiver_Manager.getCI().get_rec(this.getC_broker_receiver()); 
    }
    return this.c_broker_receiver_t;
  }
  @Transient
  public C_Broker_Receiver getC_broker_receiver_t_2(Session session_) {
    if (this.c_broker_receiver_t == null && this.getC_broker_receiver() != null) {
      this.c_broker_receiver_t = C_Broker_Receiver_Manager.getCI().get_rec(session_, this.getC_broker_receiver()); 
    }
    return this.c_broker_receiver_t;
  }
  public void setC_broker_receiver_t(C_Broker_Receiver c_broker_receiver_t) {
    this.c_broker_receiver_t = c_broker_receiver_t;
    this.c_broker_receiver = (this.c_broker_receiver_t != null?this.c_broker_receiver_t.getC_broker_receiver():null);
  }




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_broker_msg_receiver());
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
    final C_Broker_Msg_Receiver other = (C_Broker_Msg_Receiver) obj;
    if (!Objects.equals(this.getC_broker_msg_receiver(), other.getC_broker_msg_receiver())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_broker_msg_receiver();
  }

} 
