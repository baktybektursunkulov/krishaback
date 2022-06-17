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
@Table(name = "c_tbl_prop")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Tbl_Prop extends Abstract_Entity {

  //fields
  private Integer c_tbl_prop;
  private Integer c_tbl;
  private String code;
  private String name;
  private Integer c_java_data_type;
  private String default_val;
  private String note;
  private Boolean is_deleted;

  //transient fields
  private C_Tbl c_tbl_t = null;
  private C_Java_Data_Type c_java_data_type_t = null;

  public C_Tbl_Prop() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_tbl_prop", unique = true, nullable = false)
  public Integer getC_tbl_prop() {
    return this.c_tbl_prop;
  }

  public void setC_tbl_prop(Integer c_tbl_prop) {
    this.c_tbl_prop = c_tbl_prop;
  }

  @Column(name = "c_tbl", nullable = false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }

  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
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

  @Column(name = "c_java_data_type", nullable = false)
  public Integer getC_java_data_type() {
    return this.c_java_data_type;
  }

  public void setC_java_data_type(Integer c_java_data_type) {
    this.c_java_data_type = c_java_data_type;
  }

  
  @Column(name = "default_val")
  public String getDefault_val() {
    return this.default_val;
  }

  public void setDefault_val(String default_val) {
    this.default_val = default_val;
  }

  
  @Column(name = "note")
  public String getNote() {
    return this.note;
  }

  public void setNote(String note) {
    this.note = note;
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
  public C_Java_Data_Type getC_java_data_type_t() {
    if (this.c_java_data_type_t == null && this.getC_java_data_type() != null) {
      this.c_java_data_type_t = C_Java_Data_Type_Manager.getCI().get_rec(this.getC_java_data_type());
    }
    return this.c_java_data_type_t;
  }

  @Transient
  public C_Java_Data_Type getC_java_data_type_t_2(Session session_) {
    if (this.c_java_data_type_t == null && this.getC_java_data_type() != null) {
      this.c_java_data_type_t = C_Java_Data_Type_Manager.getCI().get_rec(session_, this.getC_java_data_type());
    }
    return this.c_java_data_type_t;
  }

  public void setC_java_data_type_t(C_Java_Data_Type c_java_data_type_t) {
    this.c_java_data_type_t = c_java_data_type_t;
    this.c_java_data_type = (this.c_java_data_type_t != null ? this.c_java_data_type_t.getC_java_data_type() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_prop());
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
    final C_Tbl_Prop other = (C_Tbl_Prop) obj;
    if (!Objects.equals(this.getC_tbl_prop(), other.getC_tbl_prop())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_prop();
  }

}
