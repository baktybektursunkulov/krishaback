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
@Table(name = "c_usr_review_img")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Review_Img extends Abstract_Entity {

  //fields
  private Integer c_usr_review_img;
  private Integer c_usr_review;
  private Long c_img;
  private Boolean is_deleted;

  //transient fields
  private C_Usr_Review c_usr_review_t = null;
  private C_Img img_t = null;
  private String filmstrip_img_url;
  private String img_url;

  public C_Usr_Review_Img() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_review_img", unique = true, nullable = false)
  public Integer getC_usr_review_img() {
    return this.c_usr_review_img;
  }

  public void setC_usr_review_img(Integer c_usr_review_img) {
    this.c_usr_review_img = c_usr_review_img;
  }

  @Column(name = "c_usr_review", nullable = false)
  public Integer getC_usr_review() {
    return this.c_usr_review;
  }

  public void setC_usr_review(Integer c_usr_review) {
    this.c_usr_review = c_usr_review;
  }

  @Column(name = "c_img", nullable = false)
  public Long getC_img() {
    return this.c_img;
  }

  public void setC_img(Long img) {
    this.c_img = img;
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
    this.c_img = (this.img_t != null ? this.img_t.getC_img() : null);
  }

  @Transient
  public String getFilmstrip_img_url() {
    if (filmstrip_img_url == null) {
      filmstrip_img_url = C_Usr_Review_Img_Manager.getCI().get_img_url_for_filmstrip(getC_usr_review_img());
    }
    return filmstrip_img_url;
  }

  public void setFilmstrip_img_url(String filmstrip_img_url) {
    this.filmstrip_img_url = filmstrip_img_url;
  }

  @Transient
  public String getImg_url() {
    if (img_url == null) {
      img_url = C_Usr_Review_Img_Manager.getCI().get_img_url(getC_usr_review_img(), 400, 400);
    }
    return img_url;
  }

  public void setImg_url(String img_url) {
    this.img_url = img_url;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_review_img());
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
    final C_Usr_Review_Img other = (C_Usr_Review_Img) obj;
    if (!Objects.equals(this.getC_usr_review_img(), other.getC_usr_review_img())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_review_img();
  }

}
