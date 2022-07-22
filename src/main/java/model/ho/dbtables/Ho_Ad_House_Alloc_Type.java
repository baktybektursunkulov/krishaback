package model.ho.dbtables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import managers.ho.dbtables.*;
import org.hibernate.Session;

@Entity
@Table(name="ho_ad_house_alloc_type")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Ho_Ad_House_Alloc_Type extends Abstract_Entity {

  //fields
  private Integer ho_ad_house_alloc_type;
  private Integer ho_ad;
  private Integer ho_house_alloc_type;
  private Boolean is_deleted;

  //transient fields
  private Ho_Ad ho_ad_t = null;
  private Ho_House_Alloc_Type ho_house_alloc_type_t = null;



  public Ho_Ad_House_Alloc_Type() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ho_ad_house_alloc_type", unique=true, nullable=false)
  public Integer getHo_ad_house_alloc_type() {
    return this.ho_ad_house_alloc_type;
  }
  public void setHo_ad_house_alloc_type(Integer ho_ad_house_alloc_type) {
    this.ho_ad_house_alloc_type = ho_ad_house_alloc_type;
  }

  @Column(name="ho_ad", nullable=false)
  public Integer getHo_ad() {
    return this.ho_ad;
  }
  public void setHo_ad(Integer ho_ad) {
    this.ho_ad = ho_ad;
  }

  @Column(name="ho_house_alloc_type", nullable=false)
  public Integer getHo_house_alloc_type() {
    return this.ho_house_alloc_type;
  }
  public void setHo_house_alloc_type(Integer ho_house_alloc_type) {
    this.ho_house_alloc_type = ho_house_alloc_type;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public Ho_Ad getHo_ad_t() {
    if (this.ho_ad_t == null && this.getHo_ad() != null) {
      this.ho_ad_t = Ho_Ad_Manager.getCI().get_rec(this.getHo_ad()); 
    }
    return this.ho_ad_t;
  }
  @Transient
  public Ho_Ad getHo_ad_t_2(Session session_) {
    if (this.ho_ad_t == null && this.getHo_ad() != null) {
      this.ho_ad_t = Ho_Ad_Manager.getCI().get_rec(session_, this.getHo_ad()); 
    }
    return this.ho_ad_t;
  }
  public void setHo_ad_t(Ho_Ad ho_ad_t) {
    this.ho_ad_t = ho_ad_t;
    this.ho_ad = (this.ho_ad_t != null?this.ho_ad_t.getHo_ad():null);
  }

  @Transient
  public Ho_House_Alloc_Type getHo_house_alloc_type_t() {
    if (this.ho_house_alloc_type_t == null && this.getHo_house_alloc_type() != null) {
      this.ho_house_alloc_type_t = Ho_House_Alloc_Type_Manager.getCI().get_rec(this.getHo_house_alloc_type()); 
    }
    return this.ho_house_alloc_type_t;
  }
  @Transient
  public Ho_House_Alloc_Type getHo_house_alloc_type_t_2(Session session_) {
    if (this.ho_house_alloc_type_t == null && this.getHo_house_alloc_type() != null) {
      this.ho_house_alloc_type_t = Ho_House_Alloc_Type_Manager.getCI().get_rec(session_, this.getHo_house_alloc_type()); 
    }
    return this.ho_house_alloc_type_t;
  }
  public void setHo_house_alloc_type_t(Ho_House_Alloc_Type ho_house_alloc_type_t) {
    this.ho_house_alloc_type_t = ho_house_alloc_type_t;
    this.ho_house_alloc_type = (this.ho_house_alloc_type_t != null?this.ho_house_alloc_type_t.getHo_house_alloc_type():null);
  }



  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getHo_ad_house_alloc_type());
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
    final Ho_Ad_House_Alloc_Type other = (Ho_Ad_House_Alloc_Type) obj;
    if (!Objects.equals(this.getHo_ad_house_alloc_type(), other.getHo_ad_house_alloc_type())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_ad_house_alloc_type();
  }

} 
