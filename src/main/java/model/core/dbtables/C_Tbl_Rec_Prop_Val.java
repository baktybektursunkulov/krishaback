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
@Table(name = "c_tbl_rec_prop_val")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Tbl_Rec_Prop_Val extends Abstract_Entity {

  //fields
  private Integer c_tbl_rec_prop_val;
  private Integer c_tbl;
  private Long rec_id;
  private Integer c_tbl_prop;
  private String prop_val;
  private Integer int_prop_val;
  private Boolean is_deleted;

  //transient fields
  private C_Tbl c_tbl_t = null;
  private C_Tbl_Prop c_tbl_prop_t = null;

  public C_Tbl_Rec_Prop_Val() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_tbl_rec_prop_val", unique = true, nullable = false)
  public Integer getC_tbl_rec_prop_val() {
    return this.c_tbl_rec_prop_val;
  }

  public void setC_tbl_rec_prop_val(Integer c_tbl_rec_prop_val) {
    this.c_tbl_rec_prop_val = c_tbl_rec_prop_val;
  }

  @Column(name = "c_tbl", nullable = false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }

  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
  }

  @Column(name = "rec_id", nullable = false)
  public Long getRec_id() {
    return this.rec_id;
  }

  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  @Column(name = "c_tbl_prop", nullable = false)
  public Integer getC_tbl_prop() {
    return this.c_tbl_prop;
  }

  public void setC_tbl_prop(Integer c_tbl_prop) {
    this.c_tbl_prop = c_tbl_prop;
  }

  
  @Column(name = "prop_val")
  public String getProp_val() {
    return this.prop_val;
  }

  public void setProp_val(String prop_val) {
    this.prop_val = prop_val;
  }

  @Column(name = "int_prop_val")
  public Integer getInt_prop_val() {
    return this.int_prop_val;
  }

  public void setInt_prop_val(Integer int_prop_val) {
    this.int_prop_val = int_prop_val;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Tbl getC_tbl_t() {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(this.getC_tbl());
    }
    return this.c_tbl_t;
  }

  @Transient
  public C_Tbl getC_tbl_t_2(Session session_) {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(session_, this.getC_tbl());
    }
    return this.c_tbl_t;
  }

  public void setC_tbl_t(C_Tbl c_tbl_t) {
    this.c_tbl_t = c_tbl_t;
    this.c_tbl = (this.c_tbl_t != null ? this.c_tbl_t.getC_tbl() : null);
  }

  @Transient
  public C_Tbl_Prop getC_tbl_prop_t() {
    if (this.c_tbl_prop_t == null && this.getC_tbl_prop() != null) {
      this.c_tbl_prop_t = C_Tbl_Prop_Manager.getCI().get_rec(this.getC_tbl_prop());
    }
    return this.c_tbl_prop_t;
  }

  @Transient
  public C_Tbl_Prop getC_tbl_prop_t_2(Session session_) {
    if (this.c_tbl_prop_t == null && this.getC_tbl_prop() != null) {
      this.c_tbl_prop_t = C_Tbl_Prop_Manager.getCI().get_rec(session_, this.getC_tbl_prop());
    }
    return this.c_tbl_prop_t;
  }

  public void setC_tbl_prop_t(C_Tbl_Prop c_tbl_prop_t) {
    this.c_tbl_prop_t = c_tbl_prop_t;
    this.c_tbl_prop = (this.c_tbl_prop_t != null ? this.c_tbl_prop_t.getC_tbl_prop() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_rec_prop_val());
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
    final C_Tbl_Rec_Prop_Val other = (C_Tbl_Rec_Prop_Val) obj;
    if (!Objects.equals(this.getC_tbl_rec_prop_val(), other.getC_tbl_rec_prop_val())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_rec_prop_val();
  }

}
