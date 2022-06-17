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
@Table(name="c_site_img")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Site_Img extends Abstract_Entity {

  //fields
  private Integer c_site_img;
  private Integer c_site;
  private Integer c_site_img_type;
  private Long c_img;
  private Boolean is_deleted;

  //transient fields
  private C_Site c_site_t = null;
  private C_Site_Img_Type c_site_img_type_t = null;
  private C_Img img_t = null;



  public C_Site_Img() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_site_img", unique=true, nullable=false)
  public Integer getC_site_img() {
    return this.c_site_img;
  }
  public void setC_site_img(Integer c_site_img) {
    this.c_site_img = c_site_img;
  }

  @Column(name="c_site", nullable=false)
  public Integer getC_site() {
    return this.c_site;
  }
  public void setC_site(Integer c_site) {
    this.c_site = c_site;
  }

  @Column(name="c_site_img_type", nullable=false)
  public Integer getC_site_img_type() {
    return this.c_site_img_type;
  }
  public void setC_site_img_type(Integer c_site_img_type) {
    this.c_site_img_type = c_site_img_type;
  }

  @Column(name="c_img", nullable=false)
  public Long getC_img() {
    return this.c_img;
  }
  public void setC_img(Long c_img) {
    this.c_img = c_img;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Site getC_site_t() {
    if (this.c_site_t == null && this.getC_site() != null) {
      this.c_site_t = C_Site_Manager.getCI().get_rec(this.getC_site()); 
    }
    return this.c_site_t;
  }
  @Transient
  public C_Site getC_site_t_2(Session session_) {
    if (this.c_site_t == null && this.getC_site() != null) {
      this.c_site_t = C_Site_Manager.getCI().get_rec(session_, this.getC_site()); 
    }
    return this.c_site_t;
  }
  public void setC_site_t(C_Site c_site_t) {
    this.c_site_t = c_site_t;
    this.c_site = (this.c_site_t != null?this.c_site_t.getC_site():null);
  }

  @Transient
  public C_Site_Img_Type getC_site_img_type_t() {
    if (this.c_site_img_type_t == null && this.getC_site_img_type() != null) {
      this.c_site_img_type_t = C_Site_Img_Type_Manager.getCI().get_rec(this.getC_site_img_type()); 
    }
    return this.c_site_img_type_t;
  }
  @Transient
  public C_Site_Img_Type getC_site_img_type_t_2(Session session_) {
    if (this.c_site_img_type_t == null && this.getC_site_img_type() != null) {
      this.c_site_img_type_t = C_Site_Img_Type_Manager.getCI().get_rec(session_, this.getC_site_img_type()); 
    }
    return this.c_site_img_type_t;
  }
  public void setC_site_img_type_t(C_Site_Img_Type c_site_img_type_t) {
    this.c_site_img_type_t = c_site_img_type_t;
    this.c_site_img_type = (this.c_site_img_type_t != null?this.c_site_img_type_t.getC_site_img_type():null);
  }

  @Transient
  public C_Img getImg_t() {
    if (this.img_t == null && this.getC_img() != null) {
      this.img_t = C_Img_Manager.getCI().get_rec(this.getC_img()); 
    }
    return this.img_t;
  }
  @Transient
  public C_Img getImg_t_2(Session session_) {
    if (this.img_t == null && this.getC_img() != null) {
      this.img_t = C_Img_Manager.getCI().get_rec(session_, this.getC_img()); 
    }
    return this.img_t;
  }
  public void setImg_t(C_Img img_t) {
    this.img_t = img_t;
    this.c_img = (this.img_t != null?this.img_t.getC_img():null);
  }



  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_site_img());
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
    final C_Site_Img other = (C_Site_Img) obj;
    if (!Objects.equals(this.getC_site_img(), other.getC_site_img())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_site_img();
  }

} 
