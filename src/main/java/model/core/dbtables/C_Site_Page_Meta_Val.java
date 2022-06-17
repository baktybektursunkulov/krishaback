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
@Table(name="c_site_page_meta_val")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Site_Page_Meta_Val extends Abstract_Entity {

  //fields
  private Integer c_site_page_meta_val;
  private Integer c_site_page_meta;
  private String val;
  private Boolean is_deleted;
  private String val_in_html;

  //transient fields
  private C_Site_Page_Meta c_site_page_meta_t = null;


  public C_Site_Page_Meta_Val() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_site_page_meta_val", unique=true, nullable=false)
  public Integer getC_site_page_meta_val() {
    return this.c_site_page_meta_val;
  }
  public void setC_site_page_meta_val(Integer c_site_page_meta_val) {
    this.c_site_page_meta_val = c_site_page_meta_val;
  }

  @Column(name="c_site_page_meta", nullable=false)
  public Integer getC_site_page_meta() {
    return this.c_site_page_meta;
  }
  public void setC_site_page_meta(Integer c_site_page_meta) {
    this.c_site_page_meta = c_site_page_meta;
  }

  @Type(type="text")
  @Column(name="val", nullable=false)
  public String getVal() {
    return this.val;
  }
  public void setVal(String val) {
    this.val = val;
  }
  
  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }
 
  @Type(type="text")
  @Column(name="val_in_html")
  public String getVal_in_html() {
    return this.val_in_html;
  }
  public void setVal_in_html(String val_in_html) {
    this.val_in_html = val_in_html;
  }   

  @Transient
  public C_Site_Page_Meta getC_site_page_meta_t() {
    if (this.c_site_page_meta_t == null && this.getC_site_page_meta() != null) {
      this.c_site_page_meta_t = C_Site_Page_Meta_Manager.getCI().get_rec(this.getC_site_page_meta()); 
    }
    return this.c_site_page_meta_t;
  }
  @Transient
  public C_Site_Page_Meta getC_site_page_meta_t_2(Session session_) {
    if (this.c_site_page_meta_t == null && this.getC_site_page_meta() != null) {
      this.c_site_page_meta_t = C_Site_Page_Meta_Manager.getCI().get_rec(session_, this.getC_site_page_meta()); 
    }
    return this.c_site_page_meta_t;
  }
  public void setC_site_page_meta_t(C_Site_Page_Meta c_site_page_meta_t) {
    this.c_site_page_meta_t = c_site_page_meta_t;
    this.c_site_page_meta = (this.c_site_page_meta_t != null?this.c_site_page_meta_t.getC_site_page_meta():null);
  }



  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_site_page_meta_val());
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
    final C_Site_Page_Meta_Val other = (C_Site_Page_Meta_Val) obj;
    if (!Objects.equals(this.getC_site_page_meta_val(), other.getC_site_page_meta_val())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_site_page_meta_val();
  }

} 
