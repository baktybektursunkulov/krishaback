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
@Table(name="c_site_page_meta")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Site_Page_Meta extends Abstract_Entity {

  //fields
  private Integer c_site_page_meta;
  private Integer c_site;
  private Integer c_site_page;
  private Integer c_site_meta;
  private Boolean is_deleted;

  //transient fields
  private C_Site c_site_t = null;
  private C_Site_Page c_site_page_t = null;
  private C_Site_Meta c_site_meta_t = null;


  public C_Site_Page_Meta() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_site_page_meta", unique=true, nullable=false)
  public Integer getC_site_page_meta() {
    return this.c_site_page_meta;
  }
  public void setC_site_page_meta(Integer c_site_page_meta) {
    this.c_site_page_meta = c_site_page_meta;
  }

  @Column(name="c_site", nullable=false)
  public Integer getC_site() {
    return this.c_site;
  }
  public void setC_site(Integer c_site) {
    this.c_site = c_site;
  }

  @Column(name="c_site_page", nullable=false)
  public Integer getC_site_page() {
    return this.c_site_page;
  }
  public void setC_site_page(Integer c_site_page) {
    this.c_site_page = c_site_page;
  }

  @Column(name="c_site_meta", nullable=false)
  public Integer getC_site_meta() {
    return this.c_site_meta;
  }
  public void setC_site_meta(Integer c_site_meta) {
    this.c_site_meta = c_site_meta;
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
  public C_Site_Page getC_site_page_t() {
    if (this.c_site_page_t == null && this.getC_site_page() != null) {
      this.c_site_page_t = C_Site_Page_Manager.getCI().get_rec(this.getC_site_page()); 
    }
    return this.c_site_page_t;
  }
  @Transient
  public C_Site_Page getC_site_page_t_2(Session session_) {
    if (this.c_site_page_t == null && this.getC_site_page() != null) {
      this.c_site_page_t = C_Site_Page_Manager.getCI().get_rec(session_, this.getC_site_page()); 
    }
    return this.c_site_page_t;
  }
  public void setC_site_page_t(C_Site_Page c_site_page_t) {
    this.c_site_page_t = c_site_page_t;
    this.c_site_page = (this.c_site_page_t != null?this.c_site_page_t.getC_site_page():null);
  }

  @Transient
  public C_Site_Meta getC_site_meta_t() {
    if (this.c_site_meta_t == null && this.getC_site_meta() != null) {
      this.c_site_meta_t = C_Site_Meta_Manager.getCI().get_rec(this.getC_site_meta()); 
    }
    return this.c_site_meta_t;
  }
  @Transient
  public C_Site_Meta getC_site_meta_t_2(Session session_) {
    if (this.c_site_meta_t == null && this.getC_site_meta() != null) {
      this.c_site_meta_t = C_Site_Meta_Manager.getCI().get_rec(session_, this.getC_site_meta()); 
    }
    return this.c_site_meta_t;
  }
  public void setC_site_meta_t(C_Site_Meta c_site_meta_t) {
    this.c_site_meta_t = c_site_meta_t;
    this.c_site_meta = (this.c_site_meta_t != null?this.c_site_meta_t.getC_site_meta():null);
  }


  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_site_page_meta());
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
    final C_Site_Page_Meta other = (C_Site_Page_Meta) obj;
    if (!Objects.equals(this.getC_site_page_meta(), other.getC_site_page_meta())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_site_page_meta();
  }

} 
