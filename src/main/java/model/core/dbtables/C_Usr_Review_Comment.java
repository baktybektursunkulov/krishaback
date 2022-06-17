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
@Table(name = "c_usr_review_comment")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Review_Comment extends Abstract_Entity {

  //fields
  private Integer c_usr_review_comment;
  private Integer c_usr_review;
  private String comments;
  private Date ins_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Usr_Review c_usr_review_t = null;

  public C_Usr_Review_Comment() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_review_comment", unique = true, nullable = false)
  public Integer getC_usr_review_comment() {
    return this.c_usr_review_comment;
  }

  public void setC_usr_review_comment(Integer c_usr_review_comment) {
    this.c_usr_review_comment = c_usr_review_comment;
  }

  @Column(name = "c_usr_review", nullable = false)
  public Integer getC_usr_review() {
    return this.c_usr_review;
  }

  public void setC_usr_review(Integer c_usr_review) {
    this.c_usr_review = c_usr_review;
  }

  
  @Column(name = "comments", nullable = false)
  public String getComments() {
    return this.comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name = "is_deleted", nullable = false)
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
    this.c_usr_review = (this.c_usr_review_t != null ? this.c_usr_review_t.getC_usr_review() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_review_comment());
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
    final C_Usr_Review_Comment other = (C_Usr_Review_Comment) obj;
    if (!Objects.equals(this.getC_usr_review_comment(), other.getC_usr_review_comment())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_review_comment();
  }

}
