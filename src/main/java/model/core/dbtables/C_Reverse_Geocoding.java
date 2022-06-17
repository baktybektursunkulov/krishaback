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
@Table(name="c_reverse_geocoding")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Reverse_Geocoding extends Abstract_Entity {

  //fields
  private Integer c_reverse_geocoding;
  private Double lat;
  private Double lon;
  private String lang;
  private String response;
  private Boolean is_deleted;

  //transient fields



  public C_Reverse_Geocoding() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_reverse_geocoding", unique=true, nullable=false)
  public Integer getC_reverse_geocoding() {
    return this.c_reverse_geocoding;
  }
  public void setC_reverse_geocoding(Integer c_reverse_geocoding) {
    this.c_reverse_geocoding = c_reverse_geocoding;
  }

  @Column(name="lat", nullable=false)
  public Double getLat() {
    return this.lat;
  }
  public void setLat(Double lat) {
    this.lat = lat;
  }

  @Column(name="lon", nullable=false)
  public Double getLon() {
    return this.lon;
  }
  public void setLon(Double lon) {
    this.lon = lon;
  }

  @Type(type="text")
  @Column(name="lang", nullable=false)
  public String getLang() {
    return this.lang;
  }
  public void setLang(String lang) {
    this.lang = lang;
  }

  @Type(type="text")
  @Column(name="response", nullable=false)
  public String getResponse() {
    return this.response;
  }
  public void setResponse(String response) {
    this.response = response;
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
    hash = 89 * hash + Objects.hashCode(this.getC_reverse_geocoding());
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
    final C_Reverse_Geocoding other = (C_Reverse_Geocoding) obj;
    if (!Objects.equals(this.getC_reverse_geocoding(), other.getC_reverse_geocoding())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_reverse_geocoding();
  }

} 
