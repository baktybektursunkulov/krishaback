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
@Table(name = "c_img_rotated")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Img_Rotated extends Abstract_Entity {

  //fields
  private Long c_img_rotated;
  private Long c_img_converted;
  private Integer rotate_angle;
  private Integer img_width;
  private Integer img_height;
  private Long c_bin_file_body;
  private Boolean is_deleted;

  //transient fields
  private C_Img_Converted c_img_converted_t = null;
  private C_Bin_File_Body c_bin_file_body_t = null;

  public C_Img_Rotated() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_img_rotated", unique = true, nullable = false)
  public Long getC_img_rotated() {
    return this.c_img_rotated;
  }

  public void setC_img_rotated(Long img_rotated) {
    this.c_img_rotated = img_rotated;
  }

  @Column(name = "c_img_converted", nullable = false)
  public Long getC_img_converted() {
    return this.c_img_converted;
  }

  public void setC_img_converted(Long img_converted) {
    this.c_img_converted = img_converted;
  }

  @Column(name = "rotate_angle", nullable = false)
  public Integer getRotate_angle() {
    return this.rotate_angle;
  }

  public void setRotate_angle(Integer rotate_angle) {
    this.rotate_angle = rotate_angle;
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

  @Column(name = "c_bin_file_body", nullable = false)
  public Long getC_bin_file_body() {
    return this.c_bin_file_body;
  }

  public void setC_bin_file_body(Long bin_file_body) {
    this.c_bin_file_body = bin_file_body;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Img_Converted getC_img_converted_t() {
    if (this.c_img_converted_t == null && this.getC_img_converted() != null) {
      this.c_img_converted_t = C_Img_Converted_Manager.getCI().get_rec(this.getC_img_converted());
    }
    return this.c_img_converted_t;
  }

  @Transient
  public C_Img_Converted getC_img_converted_t_2(Session session_) {
    if (this.c_img_converted_t == null && this.getC_img_converted() != null) {
      this.c_img_converted_t = C_Img_Converted_Manager.getCI().get_rec(session_, this.getC_img_converted());
    }
    return this.c_img_converted_t;
  }

  public void setC_img_converted_t(C_Img_Converted img_converted_t) {
    this.c_img_converted_t = img_converted_t;
    this.c_img_converted = (this.c_img_converted_t != null ? this.c_img_converted_t.getC_img_converted() : null);
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_img_rotated());
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
    final C_Img_Rotated other = (C_Img_Rotated) obj;
    if (!Objects.equals(this.getC_img_rotated(), other.getC_img_rotated())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_img_rotated();
  }

}
