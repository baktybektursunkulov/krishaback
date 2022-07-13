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
@Table(name="ho_ad_phone_num")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Ho_Ad_Phone_Num extends Abstract_Entity {

  //fields
  private Integer ho_ad_phone_num;
  private Integer ho_ad;
  private String phone_num;
  private Boolean is_deleted;

  //transient fields
  private  Ho_Ad ho_ad_t = null;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ho_ad_phone_num", unique=true, nullable=false)
  public Integer getHo_ad_phone_num() {
    return this.ho_ad_phone_num;
  }
  public void setHo_ad_phone_num(Integer ho_ad_phone_num) {
    this.ho_ad_phone_num = ho_ad_phone_num;
  }

  @Column(name="ho_ad", nullable=false)
  public Integer getHo_ad() {
    return this.ho_ad;
  }
  public void setHo_ad(Integer ho_ad) {
    this.ho_ad = ho_ad;
  }

  @Type(type="text")
  @Column(name="phone_num", nullable=false)
  public String getPhone_num() {
    return this.phone_num;
  }
  public void setPhone_num(String phone_num) {
    this.phone_num = phone_num;
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




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getHo_ad_phone_num());
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
    final Ho_Ad_Phone_Num other = (Ho_Ad_Phone_Num) obj;
    if (!Objects.equals(this.getHo_ad_phone_num(), other.getHo_ad_phone_num())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_ad_phone_num();
  }

} 
