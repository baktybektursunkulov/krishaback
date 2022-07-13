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
@Table(name="ho_ad_house_loc")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Ho_Ad_House_Loc extends Abstract_Entity {

  //fields
  private Integer ho_ad_house_loc;
  private Integer ho_ad;
  private Integer ho_house_loc;
  private Boolean is_deleted;

  //transient fields
  private Ho_Ad ho_ad_t = null;
  private Ho_House_Loc ho_house_loc_t = null;



  public Ho_Ad_House_Loc() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ho_ad_house_loc", unique=true, nullable=false)
  public Integer getHo_ad_house_loc() {
    return this.ho_ad_house_loc;
  }
  public void setHo_ad_house_loc(Integer ho_ad_house_loc) {
    this.ho_ad_house_loc = ho_ad_house_loc;
  }

  @Column(name="ho_ad", nullable=false)
  public Integer getHo_ad() {
    return this.ho_ad;
  }
  public void setHo_ad(Integer ho_ad) {
    this.ho_ad = ho_ad;
  }

  @Column(name="ho_house_loc", nullable=false)
  public Integer getHo_house_loc() {
    return this.ho_house_loc;
  }
  public void setHo_house_loc(Integer ho_house_loc) {
    this.ho_house_loc = ho_house_loc;
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
//  @Transient
//  public  getHo_ad_t_2(Session session_) {
//    if (this.ho_ad_t == null && this.getHo_ad() != null) {
//      this.ho_ad_t = _Manager.getCI().get_rec(session_, this.getHo_ad()); 
//    }
//    return this.ho_ad_t;
//  }
  public void setHo_ad_t(Ho_Ad ho_ad_t) {
    this.ho_ad_t = ho_ad_t;
    this.ho_ad = (this.ho_ad_t != null?this.ho_ad_t.getHo_ad():null);
  }

  @Transient
  public Ho_House_Loc getHo_house_loc_t() {
    if (this.ho_house_loc_t == null && this.getHo_house_loc() != null) {
      this.ho_house_loc_t = Ho_House_Loc_Manager.getCI().get_rec(this.getHo_house_loc()); 
    }
    return this.ho_house_loc_t;
  }
//  @Transient
//  public  getHo_house_loc_t_2(Session session_) {
//    if (this.ho_house_loc_t == null && this.getHo_house_loc() != null) {
//      this.ho_house_loc_t = _Manager.getCI().get_rec(session_, this.getHo_house_loc()); 
//    }
//    return this.ho_house_loc_t;
//  }
  public void setHo_house_loc_t(Ho_House_Loc ho_house_loc_t) {
    this.ho_house_loc_t = ho_house_loc_t;
    this.ho_house_loc = (this.ho_house_loc_t != null?this.ho_house_loc_t.getHo_house_loc():null);
  }



  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getHo_ad_house_loc());
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
    final Ho_Ad_House_Loc other = (Ho_Ad_House_Loc) obj;
    if (!Objects.equals(this.getHo_ad_house_loc(), other.getHo_ad_house_loc())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_ad_house_loc();
  }

} 
