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
@Table(name="ho_ad_house_misc")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Ho_Ad_House_Misc extends Abstract_Entity {

  //fields
  private Integer ho_ad_house_misc;
  private Integer ho_ad;
  private Integer ho_house_misc;
  private Boolean is_deleted;

  //transient fields
  private Ho_Ad ho_ad_t = null;
  private Ho_House_Misc ho_house_misc_t = null;



  public Ho_Ad_House_Misc() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ho_ad_house_misc", unique=true, nullable=false)
  public Integer getHo_ad_house_misc() {
    return this.ho_ad_house_misc;
  }
  public void setHo_ad_house_misc(Integer ho_ad_house_misc) {
    this.ho_ad_house_misc = ho_ad_house_misc;
  }

  @Column(name="ho_ad", nullable=false)
  public Integer getHo_ad() {
    return this.ho_ad;
  }
  public void setHo_ad(Integer ho_ad) {
    this.ho_ad = ho_ad;
  }

  @Column(name="ho_house_misc", nullable=false)
  public Integer getHo_house_misc() {
    return this.ho_house_misc;
  }
  public void setHo_house_misc(Integer ho_house_misc) {
    this.ho_house_misc = ho_house_misc;
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
    if (this.ho_ad_t == null && this.getHo_ad_t() != null) {
      this.ho_ad_t = Ho_Ad_Manager.getCI().get_rec(this.getHo_ad()); 
    }
    return this.ho_ad_t;
  }
//  @Transient
//  public  getHo_ad_t_2(Session session_) {
//    if (this.ho_ad_t == null && this.getHo_ad() != null) {
//      this.ho_ad_t = _Manager.getCI().get_rec(session_, this.getHo_ad()); 
//    }
//    return this.ho_ad_t;
//  }
   public void setHo_ad_t( Ho_Ad ho_ad_t) {
    this.ho_ad_t = ho_ad_t;
    this.ho_ad = (this.ho_ad_t != null?this.ho_ad_t.getHo_ad():null);
  }

  @Transient
  public Ho_House_Misc getHo_house_misc_t() {
    if (this.ho_house_misc_t == null && this.getHo_house_misc() != null) {
      this.ho_house_misc_t = Ho_House_Misc_Manager.getCI().get_rec(this.getHo_house_misc()); 
    }
    return this.ho_house_misc_t;
  }
//  @Transient
//  public  getHo_house_misc_t_2(Session session_Ho_House_Misc) {
//    if (this.ho_house_misc_t == null && this.getHo_house_misc() != null) {
//      this.ho_house_misc_t = Ho_House_Misc_Manager.getCI().get_rec(session_, this.getHo_house_misc()); 
//    }
//    return this.ho_house_misc_t;
//  }
  public void setHo_house_misc_t(Ho_House_Misc ho_house_misc_t) {
    this.ho_house_misc_t = ho_house_misc_t;
    this.ho_house_misc = (this.ho_house_misc_t != null?this.ho_house_misc_t.getHo_house_misc():null);
  }



  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getHo_ad_house_misc());
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
    final Ho_Ad_House_Misc other = (Ho_Ad_House_Misc) obj;
    if (!Objects.equals(this.getHo_ad_house_misc(), other.getHo_ad_house_misc())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_ad_house_misc();
  }

} 
