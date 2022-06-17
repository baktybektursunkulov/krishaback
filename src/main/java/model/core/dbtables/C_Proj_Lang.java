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
@Table(name = "c_proj_lang")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Proj_Lang extends Abstract_Entity {

  //fields
  private Integer c_proj_lang;
  private Integer c_proj;
  private Integer c_lang;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;
  private C_Lang c_lang_t = null;

  public C_Proj_Lang() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_proj_lang", unique = true, nullable = false)
  public Integer getC_proj_lang() {
    return this.c_proj_lang;
  }

  public void setC_proj_lang(Integer c_proj_lang) {
    this.c_proj_lang = c_proj_lang;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  @Column(name = "c_lang", nullable = false)
  public Integer getC_lang() {
    return this.c_lang;
  }

  public void setC_lang(Integer c_lang) {
    this.c_lang = c_lang;
  }

  @Transient
  public C_Proj getC_proj_t() {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(this.getC_proj());
    }
    return this.c_proj_t;
  }

  @Transient
  public C_Proj getC_proj_t_2(Session session_) {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(session_, this.getC_proj());
    }
    return this.c_proj_t;
  }

  public void setC_proj_t(C_Proj c_proj_t) {
    this.c_proj_t = c_proj_t;
    this.c_proj = (this.c_proj_t != null ? this.c_proj_t.getC_proj() : null);
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
    this.c_lang = (this.c_lang_t != null ? this.c_lang_t.getC_lang() : null);
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_proj_lang());
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
    final C_Proj_Lang other = (C_Proj_Lang) obj;
    if (!Objects.equals(this.getC_proj_lang(), other.getC_proj_lang())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_proj_lang();
  }

}
