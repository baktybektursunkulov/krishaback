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
@Table(name="c_tbl_rec_review_cnt")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Tbl_Rec_Review_Cnt extends Abstract_Entity {

  //fields
  private Integer c_tbl_rec_review_cnt;
  private Integer c_tbl;
  private Long rec_id;
  private Integer c_usr_review_kind;
  private Integer rating_val;
  private Integer month_cnt;
  private Integer review_cnt;
  private Boolean is_deleted;

  //transient fields
  private C_Tbl c_tbl_t = null;
  private C_Usr_Review_Kind c_usr_review_kind_t = null;



  public C_Tbl_Rec_Review_Cnt() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_tbl_rec_review_cnt", unique=true, nullable=false)
  public Integer getC_tbl_rec_review_cnt() {
    return this.c_tbl_rec_review_cnt;
  }
  public void setC_tbl_rec_review_cnt(Integer c_tbl_rec_review_cnt) {
    this.c_tbl_rec_review_cnt = c_tbl_rec_review_cnt;
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

  @Column(name="c_usr_review_kind", nullable=false)
  public Integer getC_usr_review_kind() {
    return this.c_usr_review_kind;
  }
  public void setC_usr_review_kind(Integer c_usr_review_kind) {
    this.c_usr_review_kind = c_usr_review_kind;
  }

  @Column(name="rating_val", nullable=false)
  public Integer getRating_val() {
    return this.rating_val;
  }
  public void setRating_val(Integer rating_val) {
    this.rating_val = rating_val;
  }

  @Column(name="month_cnt", nullable=false)
  public Integer getMonth_cnt() {
    return this.month_cnt;
  }
  public void setMonth_cnt(Integer month_cnt) {
    this.month_cnt = month_cnt;
  }

  @Column(name="review_cnt", nullable=false)
  public Integer getReview_cnt() {
    return this.review_cnt;
  }
  public void setReview_cnt(Integer review_cnt) {
    this.review_cnt = review_cnt;
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
  public C_Usr_Review_Kind getC_usr_review_kind_t() {
    if (this.c_usr_review_kind_t == null && this.getC_usr_review_kind() != null) {
      this.c_usr_review_kind_t = C_Usr_Review_Kind_Manager.getCI().get_rec(this.getC_usr_review_kind()); 
    }
    return this.c_usr_review_kind_t;
  }
  @Transient
  public C_Usr_Review_Kind getC_usr_review_kind_t_2(Session session_) {
    if (this.c_usr_review_kind_t == null && this.getC_usr_review_kind() != null) {
      this.c_usr_review_kind_t = C_Usr_Review_Kind_Manager.getCI().get_rec(session_, this.getC_usr_review_kind()); 
    }
    return this.c_usr_review_kind_t;
  }
  public void setC_usr_review_kind_t(C_Usr_Review_Kind c_usr_review_kind_t) {
    this.c_usr_review_kind_t = c_usr_review_kind_t;
    this.c_usr_review_kind = (this.c_usr_review_kind_t != null?this.c_usr_review_kind_t.getC_usr_review_kind():null);
  }






  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_rec_review_cnt());
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
    final C_Tbl_Rec_Review_Cnt other = (C_Tbl_Rec_Review_Cnt) obj;
    if (!Objects.equals(this.getC_tbl_rec_review_cnt(), other.getC_tbl_rec_review_cnt())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_rec_review_cnt();
  }

} 
