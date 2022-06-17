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
@Table(name="c_geocoding")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Geocoding extends Abstract_Entity {

  //fields
  private Integer c_geocoding;
  private String address;
  private Double response_lat;
  private Double response_lon;
  private Double response_view_ne_lat;
  private Double response_view_ne_lon;
  private Double response_view_sw_lat;
  private Double response_view_sw_lon;
  private String response_json;
  private Boolean is_deleted;

  //transient fields



  public C_Geocoding() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_geocoding", unique=true, nullable=false)
  public Integer getC_geocoding() {
    return this.c_geocoding;
  }
  public void setC_geocoding(Integer c_geocoding) {
    this.c_geocoding = c_geocoding;
  }

  @Type(type="text")
  @Column(name="address", nullable=false)
  public String getAddress() {
    return this.address;
  }
  public void setAddress(String address) {
    this.address = address;
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

  @Column(name="response_view_ne_lat", nullable=false)
  public Double getResponse_view_ne_lat() {
    return this.response_view_ne_lat;
  }
  public void setResponse_view_ne_lat(Double response_view_ne_lat) {
    this.response_view_ne_lat = response_view_ne_lat;
  }

  @Column(name="response_view_ne_lon", nullable=false)
  public Double getResponse_view_ne_lon() {
    return this.response_view_ne_lon;
  }
  public void setResponse_view_ne_lon(Double response_view_ne_lon) {
    this.response_view_ne_lon = response_view_ne_lon;
  }

  @Column(name="response_view_sw_lat", nullable=false)
  public Double getResponse_view_sw_lat() {
    return this.response_view_sw_lat;
  }
  public void setResponse_view_sw_lat(Double response_view_sw_lat) {
    this.response_view_sw_lat = response_view_sw_lat;
  }

  @Column(name="response_view_sw_lon", nullable=false)
  public Double getResponse_view_sw_lon() {
    return this.response_view_sw_lon;
  }
  public void setResponse_view_sw_lon(Double response_view_sw_lon) {
    this.response_view_sw_lon = response_view_sw_lon;
  }

  @Type(type="text")
  @Column(name="response_json", nullable=false)
  public String getResponse_json() {
    return this.response_json;
  }
  public void setResponse_json(String response_json) {
    this.response_json = response_json;
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
    hash = 89 * hash + Objects.hashCode(this.getC_geocoding());
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
    final C_Geocoding other = (C_Geocoding) obj;
    if (!Objects.equals(this.getC_geocoding(), other.getC_geocoding())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_geocoding();
  }

} 
