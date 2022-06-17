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
@Table(name="c_tbl_rec_img")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Tbl_Rec_Img extends Abstract_Entity {

  //fields
  private Integer c_tbl_rec_img;
  private Integer c_tbl;
  private Long rec_id;
  private Long c_img;
  private Boolean is_deleted;

  //transient fields
  private C_Tbl c_tbl_t = null;
  private C_Img img_t = null;



  public C_Tbl_Rec_Img() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_tbl_rec_img", unique=true, nullable=false)
  public Integer getC_tbl_rec_img() {
    return this.c_tbl_rec_img;
  }
  public void setC_tbl_rec_img(Integer c_tbl_rec_img) {
    this.c_tbl_rec_img = c_tbl_rec_img;
  }

  @Column(name="c_tbl", nullable=false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }
  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
  }

  @Column(name="rec_id", nullable=false)
  public Long getRec_id() {
    return this.rec_id;
  }
  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  @Column(name="c_img", nullable=false)
  public Long getC_img() {
    return this.c_img;
  }
  public void setC_img(Long img) {
    this.c_img = img;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Tbl getC_tbl_t() {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(this.getC_tbl()); 
    }
    return this.c_tbl_t;
  }
  @Transient
  public C_Tbl getC_tbl_t_2(Session session_) {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(session_, this.getC_tbl()); 
    }
    return this.c_tbl_t;
  }
  public void setC_tbl_t(C_Tbl c_tbl_t) {
    this.c_tbl_t = c_tbl_t;
    this.c_tbl = (this.c_tbl_t != null?this.c_tbl_t.getC_tbl():null);
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
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_rec_img());
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
    final C_Tbl_Rec_Img other = (C_Tbl_Rec_Img) obj;
    if (!Objects.equals(this.getC_tbl_rec_img(), other.getC_tbl_rec_img())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_rec_img();
  }

} 
