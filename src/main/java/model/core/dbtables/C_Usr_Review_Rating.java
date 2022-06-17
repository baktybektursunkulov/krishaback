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
@Table(name="c_usr_review_rating")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Review_Rating extends Abstract_Entity {

  //fields
  private Integer c_usr_review_rating;
  private Integer c_usr_review;
  private Integer c_usr_review_kind;
  private Integer rating;
  private Boolean is_deleted;

  //transient fields
  private C_Usr_Review c_usr_review_t = null;
  private C_Usr_Review_Kind c_usr_review_kind_t = null;



  public C_Usr_Review_Rating() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_usr_review_rating", unique=true, nullable=false)
  public Integer getC_usr_review_rating() {
    return this.c_usr_review_rating;
  }
  public void setC_usr_review_rating(Integer c_usr_review_rating) {
    this.c_usr_review_rating = c_usr_review_rating;
  }

  @Column(name="c_usr_review", nullable=false)
  public Integer getC_usr_review() {
    return this.c_usr_review;
  }
  public void setC_usr_review(Integer c_usr_review) {
    this.c_usr_review = c_usr_review;
  }

  @Column(name="c_usr_review_kind", nullable=false)
  public Integer getC_usr_review_kind() {
    return this.c_usr_review_kind;
  }
  public void setC_usr_review_kind(Integer c_usr_review_kind) {
    this.c_usr_review_kind = c_usr_review_kind;
  }

  @Column(name="rating", nullable=false)
  public Integer getRating() {
    return this.rating;
  }
  public void setRating(Integer rating) {
    this.rating = rating;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Usr_Review getC_usr_review_t() {
    if (this.c_usr_review_t == null && this.getC_usr_review() != null) {
      this.c_usr_review_t = C_Usr_Review_Manager.getCI().get_rec(this.getC_usr_review()); 
    }
    return this.c_usr_review_t;
  }
  @Transient
  public C_Usr_Review getC_usr_review_t_2(Session session_) {
    if (this.c_usr_review_t == null && this.getC_usr_review() != null) {
      this.c_usr_review_t = C_Usr_Review_Manager.getCI().get_rec(session_, this.getC_usr_review()); 
    }
    return this.c_usr_review_t;
  }
  public void setC_usr_review_t(C_Usr_Review c_usr_review_t) {
    this.c_usr_review_t = c_usr_review_t;
    this.c_usr_review = (this.c_usr_review_t != null?this.c_usr_review_t.getC_usr_review():null);
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
    hash = 89 * hash + Objects.hashCode(this.getC_usr_review_rating());
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
    final C_Usr_Review_Rating other = (C_Usr_Review_Rating) obj;
    if (!Objects.equals(this.getC_usr_review_rating(), other.getC_usr_review_rating())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_review_rating();
  }

} 
