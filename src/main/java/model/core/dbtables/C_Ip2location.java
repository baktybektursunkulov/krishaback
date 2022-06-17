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
@Table(name="c_ip2location")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Ip2location extends Abstract_Entity {

  //fields
  private Integer c_ip2location;
  private String ip;
  private String response_country_code;
  private Double response_lat;
  private Double response_lon;
  private String response_json;
  private Date ins_dt;
  private Boolean is_deleted;

  //transient fields



  public C_Ip2location() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_ip2location", unique=true, nullable=false)
  public Integer getC_ip2location() {
    return this.c_ip2location;
  }
  public void setC_ip2location(Integer c_ip2location) {
    this.c_ip2location = c_ip2location;
  }

  @Type(type="text")
  @Column(name="ip", nullable=false)
  public String getIp() {
    return this.ip;
  }
  public void setIp(String ip) {
    this.ip = ip;
  }

  @Type(type="text")
  @Column(name="response_country_code", nullable=false)
  public String getResponse_country_code() {
    return this.response_country_code;
  }
  public void setResponse_country_code(String response_country_code) {
    this.response_country_code = response_country_code;
  }

  @Column(name="response_lat", nullable=false)
  public Double getResponse_lat() {
    return this.response_lat;
  }
  public void setResponse_lat(Double response_lat) {
    this.response_lat = response_lat;
  }

  @Column(name="response_lon", nullable=false)
  public Double getResponse_lon() {
    return this.response_lon;
  }
  public void setResponse_lon(Double response_lon) {
    this.response_lon = response_lon;
  }

  @Type(type="text")
  @Column(name="response_json", nullable=false)
  public String getResponse_json() {
    return this.response_json;
  }
  public void setResponse_json(String response_json) {
    this.response_json = response_json;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ins_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }
  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
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
    hash = 89 * hash + Objects.hashCode(this.getC_ip2location());
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
    final C_Ip2location other = (C_Ip2location) obj;
    if (!Objects.equals(this.getC_ip2location(), other.getC_ip2location())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_ip2location();
  }

} 
