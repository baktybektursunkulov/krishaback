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
@Table(name="c_tbl_rec_img_moder")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Tbl_Rec_Img_Moder extends Abstract_Entity {

  //fields
  private Integer c_tbl_rec_img_moder;
  private Integer c_tbl;
  private Long rec_id;
  private Integer c_img_kind;
  private Long c_img;
  private Integer c_img_status;
  private String refuse_reason;
  private Boolean is_deleted;

  //transient fields
  private  C_Tbl c_tbl_t = null;
  private C_Img_Kind c_img_kind_t = null;
  private C_Img c_img_t = null;
  private C_Img_Status c_img_status_t = null;



  public C_Tbl_Rec_Img_Moder() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_tbl_rec_img_moder", unique=true, nullable=false)
  public Integer getC_tbl_rec_img_moder() {
    return this.c_tbl_rec_img_moder;
  }
  public void setC_tbl_rec_img_moder(Integer c_tbl_rec_img_moder) {
    this.c_tbl_rec_img_moder = c_tbl_rec_img_moder;
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

  @Column(name="c_img_kind", nullable=false)
  public Integer getC_img_kind() {
    return this.c_img_kind;
  }
  public void setC_img_kind(Integer c_img_kind) {
    this.c_img_kind = c_img_kind;
  }

  @Column(name="c_img", nullable=false)
  public Long getC_img() {
    return this.c_img;
  }
  public void setC_img(Long c_img) {
    this.c_img = c_img;
  }

  @Column(name="c_img_status", nullable=false)
  public Integer getC_img_status() {
    return this.c_img_status;
  }
  public void setC_img_status(Integer c_img_status) {
    this.c_img_status = c_img_status;
  }

  @Type(type="text")
  @Column(name="refuse_reason")
  public String getRefuse_reason() {
    return this.refuse_reason;
  }
  public void setRefuse_reason(String refuse_reason) {
    this.refuse_reason = refuse_reason;
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
  public C_Img_Kind getC_img_kind_t() {
    if (this.c_img_kind_t == null && this.getC_img_kind() != null) {
      this.c_img_kind_t = C_Img_Kind_Manager.getCI().get_rec(this.getC_img_kind()); 
    }
    return this.c_img_kind_t;
  }
//  @Transient
//  public  getC_img_kind_t_2(Session session_) {
//    if (this.c_img_kind_t == null && this.getC_img_kind() != null) {
//      this.c_img_kind_t = _Manager.getCI().get_rec(session_, this.getC_img_kind()); 
//    }
//    return this.c_img_kind_t;
//  }
  public void setC_img_kind_t(C_Img_Kind c_img_kind_t) {
    this.c_img_kind_t = c_img_kind_t;
    this.c_img_kind = (this.c_img_kind_t != null?this.c_img_kind_t.getC_img_kind():null);
  }

  @Transient
  public C_Img getC_img_t() {
    if (this.c_img_t == null && this.getC_img() != null) {
      this.c_img_t = C_Img_Manager.getCI().get_rec(this.getC_img()); 
    }
    return this.c_img_t;
  }
//  @Transient
//  public  getC_img_t_2(Session session_) {
//    if (this.c_img_t == null && this.getC_img() != null) {
//      this.c_img_t = _Manager.getCI().get_rec(session_, this.getC_img()); 
//    }
//    return this.c_img_t;
//  }
  public void setC_img_t(C_Img c_img_t) {
    this.c_img_t = c_img_t;
    this.c_img = (this.c_img_t != null?this.c_img_t.getC_img():null);
  }

  @Transient
  public C_Img_Status getC_img_status_t() {
    if (this.c_img_status_t == null && this.getC_img_status() != null) {
      this.c_img_status_t = C_Img_Status_Manager.getCI().get_rec(this.getC_img_status()); 
    }
    return this.c_img_status_t;
  }
//  @Transient
//  public  getC_img_status_t_2(Session session_) {
//    if (this.c_img_status_t == null && this.getC_img_status() != null) {
//      this.c_img_status_t = _Manager.getCI().get_rec(session_, this.getC_img_status()); 
//    }
//    return this.c_img_status_t;
//  }
  public void setC_img_status_t(C_Img_Status c_img_status_t) {
    this.c_img_status_t = c_img_status_t;
    this.c_img_status = (this.c_img_status_t != null?this.c_img_status_t.getC_img_status():null);
  }




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_rec_img_moder());
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
    final C_Tbl_Rec_Img_Moder other = (C_Tbl_Rec_Img_Moder) obj;
    if (!Objects.equals(this.getC_tbl_rec_img_moder(), other.getC_tbl_rec_img_moder())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_rec_img_moder();
  }

} 
