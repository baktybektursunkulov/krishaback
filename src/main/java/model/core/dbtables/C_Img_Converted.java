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
@Table(name = "c_img_converted")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Img_Converted extends Abstract_Entity {

  //fields
  private Long c_img_converted;
  private Long c_img;
  private Integer c_img_type;
  private Integer img_width;
  private Integer img_height;
  private Boolean is_deleted;
  private Long c_bin_file_body;

  //transient fields
  private C_Img c_img_t = null;
  private C_Img_Type c_img_type_t = null;
  private C_Bin_File_Body c_bin_file_body_t = null;

  public C_Img_Converted() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_img_converted", unique = true, nullable = false)
  public Long getC_img_converted() {
    return this.c_img_converted;
  }

  public void setC_img_converted(Long img_converted) {
    this.c_img_converted = img_converted;
  }

  @Column(name = "c_img", nullable = false)
  public Long getC_img() {
    return this.c_img;
  }

  public void setC_img(Long img) {
    this.c_img = img;
  }

  @Column(name = "c_img_type", nullable = false)
  public Integer getC_img_type() {
    return this.c_img_type;
  }

  public void setC_img_type(Integer img_type) {
    this.c_img_type = img_type;
  }

  @Column(name = "img_width", nullable = false)
  public Integer getImg_width() {
    return this.img_width;
  }

  public void setImg_width(Integer img_width) {
    this.img_width = img_width;
  }

  @Column(name = "img_height", nullable = false)
  public Integer getImg_height() {
    return this.img_height;
  }

  public void setImg_height(Integer img_height) {
    this.img_height = img_height;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "c_bin_file_body", nullable = false)
  public Long getC_bin_file_body() {
    return this.c_bin_file_body;
  }

  public void setC_bin_file_body(Long c_bin_file_body) {
    this.c_bin_file_body = c_bin_file_body;
  }

  @Transient
  public C_Bin_File_Body getC_bin_file_body_t() {
    if (this.c_bin_file_body_t == null && this.getC_bin_file_body() != null) {
      this.c_bin_file_body_t = C_Bin_File_Body_Manager.getCI().get_rec(this.getC_bin_file_body());
    }
    return this.c_bin_file_body_t;
  }

  @Transient
  public C_Bin_File_Body getC_bin_file_body_t_2(Session session_) {
    if (this.c_bin_file_body_t == null && this.getC_bin_file_body() != null) {
      this.c_bin_file_body_t = C_Bin_File_Body_Manager.getCI().get_rec(session_, this.getC_bin_file_body());
    }
    return this.c_bin_file_body_t;
  }

  public void setC_bin_file_body_t(C_Bin_File_Body bin_file_body_t) {
    this.c_bin_file_body_t = bin_file_body_t;
    this.c_bin_file_body = (this.c_bin_file_body_t != null ? this.c_bin_file_body_t.getC_bin_file_body() : null);
  }

  @Transient
  public C_Img getC_img_t() {
    if (this.c_img_t == null && this.getC_img() != null) {
      this.c_img_t = C_Img_Manager.getCI().get_rec(this.getC_img());
    }
    return this.c_img_t;
  }

  @Transient
  public C_Img getC_img_t_2(Session session_) {
    if (this.c_img_t == null && this.getC_img() != null) {
      this.c_img_t = C_Img_Manager.getCI().get_rec(session_, this.getC_img());
    }
    return this.c_img_t;
  }

  public void setC_img_t(C_Img img_t) {
    this.c_img_t = img_t;
    this.c_img = (this.c_img_t != null ? this.c_img_t.getC_img() : null);
  }

  @Transient
  public C_Img_Type getC_img_type_t() {
    if (this.c_img_type_t == null && this.getC_img_type() != null) {
      this.c_img_type_t = C_Img_Type_Manager.getCI().get_rec(this.getC_img_type());
    }
    return this.c_img_type_t;
  }

  @Transient
  public C_Img_Type getC_img_type_t_2(Session session_) {
    if (this.c_img_type_t == null && this.getC_img_type() != null) {
      this.c_img_type_t = C_Img_Type_Manager.getCI().get_rec(session_, this.getC_img_type());
    }
    return this.c_img_type_t;
  }

  public void setC_img_type_t(C_Img_Type img_type_t) {
    this.c_img_type_t = img_type_t;
    this.c_img_type = (this.c_img_type_t != null ? this.c_img_type_t.getC_img_type() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_img_converted());
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
    final C_Img_Converted other = (C_Img_Converted) obj;
    if (!Objects.equals(this.getC_img_converted(), other.getC_img_converted())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_img_converted();
  }

}
