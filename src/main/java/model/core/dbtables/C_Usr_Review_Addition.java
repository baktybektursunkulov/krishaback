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
@Table(name="c_usr_review_addition")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Review_Addition extends Abstract_Entity {

  //fields
  private Integer c_usr_review_addition;
  private Integer c_usr_review;
  private Long c_usr;
  private Integer c_lang;
  private String comments;
  private Date ins_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Usr_Review c_usr_review_t = null;
  private C_Usr c_usr_t = null;
  private C_Lang c_lang_t = null;



  public C_Usr_Review_Addition() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_usr_review_addition", unique=true, nullable=false)
  public Integer getC_usr_review_addition() {
    return this.c_usr_review_addition;
  }
  public void setC_usr_review_addition(Integer c_usr_review_addition) {
    this.c_usr_review_addition = c_usr_review_addition;
  }

  @Column(name="c_usr_review", nullable=false)
  public Integer getC_usr_review() {
    return this.c_usr_review;
  }
  public void setC_usr_review(Integer c_usr_review) {
    this.c_usr_review = c_usr_review;
  }

  @Column(name="c_usr", nullable=false)
  public Long getC_usr() {
    return this.c_usr;
  }
  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name="c_lang", nullable=false)
  public Integer getC_lang() {
    return this.c_lang;
  }
  public void setC_lang(Integer c_lang) {
    this.c_lang = c_lang;
  }

  @Type(type="text")
  @Column(name="comments", nullable=false)
  public String getComments() {
    return this.comments;
  }
  public void setComments(String comments) {
    this.comments = comments;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ins_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }
  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
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
  public C_Usr getC_usr_t() {
    if (this.c_usr_t == null && this.getC_usr() != null) {
      this.c_usr_t = C_Usr_Manager.getCI().get_rec(this.getC_usr()); 
    }
    return this.c_usr_t;
  }
  @Transient
  public C_Usr getC_usr_t_2(Session session_) {
    if (this.c_usr_t == null && this.getC_usr() != null) {
      this.c_usr_t = C_Usr_Manager.getCI().get_rec(session_, this.getC_usr()); 
    }
    return this.c_usr_t;
  }
  public void setC_usr_t(C_Usr c_usr_t) {
    this.c_usr_t = c_usr_t;
    this.c_usr = (this.c_usr_t != null?this.c_usr_t.getC_usr():null);
  }

  @Transient
  public C_Lang getC_lang_t() {
    if (this.c_lang_t == null && this.getC_lang() != null) {
      this.c_lang_t = C_Lang_Manager.getCI().get_rec(this.getC_lang()); 
    }
    return this.c_lang_t;
  }
  @Transient
  public C_Lang getC_lang_t_2(Session session_) {
    if (this.c_lang_t == null && this.getC_lang() != null) {
      this.c_lang_t = C_Lang_Manager.getCI().get_rec(session_, this.getC_lang()); 
    }
    return this.c_lang_t;
  }
  public void setC_lang_t(C_Lang c_lang_t) {
    this.c_lang_t = c_lang_t;
    this.c_lang = (this.c_lang_t != null?this.c_lang_t.getC_lang():null);
  }





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_review_addition());
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
    final C_Usr_Review_Addition other = (C_Usr_Review_Addition) obj;
    if (!Objects.equals(this.getC_usr_review_addition(), other.getC_usr_review_addition())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_review_addition();
  }

} 
