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
@Table(name = "i_tbl_fld")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class I_Tbl_Fld extends Abstract_Entity {

  //fields
  private Integer i_tbl_fld;
  private Integer i_tbl;
  private String name;
  private Boolean is_html_format;
  private Boolean is_deleted;

  //transient fields
  private I_Tbl i_tbl_t = null;

  public I_Tbl_Fld() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "i_tbl_fld", unique = true, nullable = false)
  public Integer getI_tbl_fld() {
    return this.i_tbl_fld;
  }

  public void setI_tbl_fld(Integer i_tbl_fld) {
    this.i_tbl_fld = i_tbl_fld;
  }

  @Column(name = "i_tbl", nullable = false)
  public Integer getI_tbl() {
    return this.i_tbl;
  }

  public void setI_tbl(Integer i_tbl) {
    this.i_tbl = i_tbl;
  }

  
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "is_html_format", nullable = false)
  public Boolean getIs_html_format() {
    return this.is_html_format;
  }

  public void setIs_html_format(Boolean is_html_format) {
    this.is_html_format = is_html_format;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public I_Tbl getI_tbl_t() {
    if (this.i_tbl_t == null && this.getI_tbl() != null) {
      this.i_tbl_t = I_Tbl_Manager.getCI().get_rec(this.getI_tbl());
    }
    return this.i_tbl_t;
  }

  @Transient
  public I_Tbl getI_tbl_t_2(Session session_) {
    if (this.i_tbl_t == null && this.getI_tbl() != null) {
      this.i_tbl_t = I_Tbl_Manager.getCI().get_rec(session_, this.getI_tbl());
    }
    return this.i_tbl_t;
  }

  public void setI_tbl_t(I_Tbl i_tbl_t) {
    this.i_tbl_t = i_tbl_t;
    this.i_tbl = (this.i_tbl_t != null ? this.i_tbl_t.getI_tbl() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getI_tbl_fld());
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
    final I_Tbl_Fld other = (I_Tbl_Fld) obj;
    if (!Objects.equals(this.getI_tbl_fld(), other.getI_tbl_fld())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getI_tbl_fld();
  }

}
