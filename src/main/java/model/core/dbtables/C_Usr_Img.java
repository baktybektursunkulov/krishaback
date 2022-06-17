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
@Table(name = "c_usr_img")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Img extends Abstract_Entity {

  //fields
  private Integer c_usr_img;
  private Long c_usr;
  private Integer c_usr_img_type;
  private Long c_img;
  private Boolean is_deleted;

  //transient fields
  private C_Usr c_usr_t = null;
  private C_Usr_Img_Type c_usr_img_type_t = null;
  private C_Img c_img_t = null;

  public C_Usr_Img() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_img", unique = true, nullable = false)
  public Integer getC_usr_img() {
    return this.c_usr_img;
  }

  public void setC_usr_img(Integer c_usr_img) {
    this.c_usr_img = c_usr_img;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name = "c_usr_img_type", nullable = false)
  public Integer getC_usr_img_type() {
    return this.c_usr_img_type;
  }

  public void setC_usr_img_type(Integer c_usr_img_type) {
    this.c_usr_img_type = c_usr_img_type;
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
    this.c_usr = (this.c_usr_t != null ? this.c_usr_t.getC_usr() : null);
  }

  @Transient
  public C_Usr_Img_Type getC_usr_img_type_t() {
    if (this.c_usr_img_type_t == null && this.getC_usr_img_type() != null) {
      this.c_usr_img_type_t = C_Usr_Img_Type_Manager.getCI().get_rec(this.getC_usr_img_type());
    }
    return this.c_usr_img_type_t;
  }

  @Transient
  public C_Usr_Img_Type getC_usr_img_type_t_2(Session session_) {
    if (this.c_usr_img_type_t == null && this.getC_usr_img_type() != null) {
      this.c_usr_img_type_t = C_Usr_Img_Type_Manager.getCI().get_rec(session_, this.getC_usr_img_type());
    }
    return this.c_usr_img_type_t;
  }

  public void setC_usr_img_type_t(C_Usr_Img_Type c_usr_img_type_t) {
    this.c_usr_img_type_t = c_usr_img_type_t;
    this.c_usr_img_type = (this.c_usr_img_type_t != null ? this.c_usr_img_type_t.getC_usr_img_type() : null);
  }

  @Transient
  public C_Img getImg_t() {
    if (this.c_img_t == null && this.getC_img() != null) {
      this.c_img_t = C_Img_Manager.getCI().get_rec(this.getC_img());
    }
    return this.c_img_t;
  }

  @Transient
  public C_Img getImg_t_2(Session session_) {
    if (this.c_img_t == null && this.getC_img() != null) {
      this.c_img_t = C_Img_Manager.getCI().get_rec(session_, this.getC_img());
    }
    return this.c_img_t;
  }

  public void setImg_t(C_Img img_t) {
    this.c_img_t = img_t;
    this.c_img = (this.c_img_t != null ? this.c_img_t.getC_img() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_img());
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
    final C_Usr_Img other = (C_Usr_Img) obj;
    if (!Objects.equals(this.getC_usr_img(), other.getC_usr_img())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_img();
  }

}
