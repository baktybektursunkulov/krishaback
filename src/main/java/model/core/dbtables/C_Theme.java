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
@Table(name = "c_theme")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Theme extends Abstract_Entity {

  //fields
  private Integer c_theme;
  private String code;
  private String name;
  private Long c_img;
  private Boolean is_deleted;

  //transient fields
  private C_Img c_img_t = null;

  public C_Theme() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_theme", unique = true, nullable = false)
  public Integer getC_theme() {
    return this.c_theme;
  }

  public void setC_theme(Integer c_theme) {
    this.c_theme = c_theme;
  }

  
  @Column(name = "code", nullable = false)
  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_theme());
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
    final C_Theme other = (C_Theme) obj;
    if (!Objects.equals(this.getC_theme(), other.getC_theme())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_theme();
  }

  @Override
  public String toString() {
    return code;
  }
}
