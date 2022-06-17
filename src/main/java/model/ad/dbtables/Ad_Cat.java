package model.ad.dbtables;

import model.core.dbtables.*;
import beans.LocaleBean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import gs.services.core.dbtables.C_Lang_Service;
//import java.util.Locale;
import managers.core.dbtables.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import others.core_lang_funcs;

@Entity
@Table(name = "ad_cat")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ad_Cat extends Abstract_Entity {

  //fields
  private Integer ad_cat;
  private String name;
  private Boolean is_deleted;
  private Integer parent_id;

  public Ad_Cat() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ad_cat", unique = true, nullable = false)
  public Integer getAd_cat() {
    return this.ad_cat;
  }

  public void setAd_cat(Integer ca_cat) {
    this.ad_cat = ca_cat;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonIgnore
  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "parent_id")
  public Integer getParent_id() {
    return parent_id;
  }

  public void setParent_id(Integer parent_id) {
    this.parent_id = parent_id;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getAd_cat());
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
    final Ad_Cat other = (Ad_Cat) obj;
    if (!Objects.equals(this.getAd_cat(), other.getAd_cat())) {
      return false;
    }
    return true;
  }

  @JsonIgnore
  @Transient
  @Override
  public Serializable getEntity_id() {
    return getAd_cat();
  }

}
