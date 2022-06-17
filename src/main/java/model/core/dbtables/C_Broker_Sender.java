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
@Table(name="c_broker_sender")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Broker_Sender extends Abstract_Entity {

  //fields
  private Integer c_broker_sender;
  private String client_id;
  private Boolean is_deleted;

  //transient fields



  public C_Broker_Sender() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_broker_sender", unique=true, nullable=false)
  public Integer getC_broker_sender() {
    return this.c_broker_sender;
  }
  public void setC_broker_sender(Integer c_broker_sender) {
    this.c_broker_sender = c_broker_sender;
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
    hash = 89 * hash + Objects.hashCode(this.getC_broker_sender());
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
    final C_Broker_Sender other = (C_Broker_Sender) obj;
    if (!Objects.equals(this.getC_broker_sender(), other.getC_broker_sender())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_broker_sender();
  }

} 
