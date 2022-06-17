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
@Table(name = "c_geocoding_service")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Geocoding_Service extends Abstract_Entity {

  //fields
  private Integer c_geocoding_service;
  private String url_pattern;
  private Boolean is_deleted;

  //transient fields
  public C_Geocoding_Service() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_geocoding_service", unique = true, nullable = false)
  public Integer getC_geocoding_service() {
    return this.c_geocoding_service;
  }

  public void setC_geocoding_service(Integer c_geocoding_service) {
    this.c_geocoding_service = c_geocoding_service;
  }

  
  @Column(name = "url_pattern", nullable = false)
  public String getUrl_pattern() {
    return this.url_pattern;
  }

  public void setUrl_pattern(String url_pattern) {
    this.url_pattern = url_pattern;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_geocoding_service());
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
    final C_Geocoding_Service other = (C_Geocoding_Service) obj;
    if (!Objects.equals(this.getC_geocoding_service(), other.getC_geocoding_service())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_geocoding_service();
  }

}
