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
@Table(name="c_broker_receiver")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Broker_Receiver extends Abstract_Entity {

  //fields
  private Integer c_broker_receiver;
  private String client_id;
  private Boolean is_deleted;

  //transient fields



  public C_Broker_Receiver() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_broker_receiver", unique=true, nullable=false)
  public Integer getC_broker_receiver() {
    return this.c_broker_receiver;
  }
  public void setC_broker_receiver(Integer c_broker_receiver) {
    this.c_broker_receiver = c_broker_receiver;
  }

  @Type(type="text")
  @Column(name="client_id", nullable=false)
  public String getClient_id() {
    return this.client_id;
  }
  public void setClient_id(String client_id) {
    this.client_id = client_id;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_broker_receiver());
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
    final C_Broker_Receiver other = (C_Broker_Receiver) obj;
    if (!Objects.equals(this.getC_broker_receiver(), other.getC_broker_receiver())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_broker_receiver();
  }

} 
