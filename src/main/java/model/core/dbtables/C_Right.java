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
@Table(name = "c_right")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Right extends Abstract_Entity {

  //fields
  private Integer c_right;
  private Integer c_right_kind;
  private String code;
  private String name;
  private String description;
  private Boolean is_active;
  private Integer order_num;
  private Boolean is_deleted;

  //transient fields
  private C_Right_Kind c_right_kind_t = null;

  public C_Right() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_right", unique = true, nullable = false)
  public Integer getC_right() {
    return this.c_right;
  }

  public void setC_right(Integer c_right) {
    this.c_right = c_right;
  }

  @Column(name = "c_right_kind", nullable = false)
  public Integer getC_right_kind() {
    return this.c_right_kind;
  }

  public void setC_right_kind(Integer c_right_kind) {
    this.c_right_kind = c_right_kind;
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

  
  @Column(name = "description")
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "is_active", nullable = false)
  public Boolean getIs_active() {
    return this.is_active;
  }

  public void setIs_active(Boolean is_active) {
    this.is_active = is_active;
  }

  @Column(name = "order_num", nullable = false)
  public Integer getOrder_num() {
    return this.order_num;
  }

  public void setOrder_num(Integer order_num) {
    this.order_num = order_num;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Right_Kind getC_right_kind_t() {
    if (this.c_right_kind_t == null && this.getC_right_kind() != null) {
      this.c_right_kind_t = C_Right_Kind_Manager.getCI().get_rec(this.getC_right_kind());
    }
    return this.c_right_kind_t;
  }

  @Transient
  public C_Right_Kind getC_right_kind_t_2(Session session_) {
    if (this.c_right_kind_t == null && this.getC_right_kind() != null) {
      this.c_right_kind_t = C_Right_Kind_Manager.getCI().get_rec(session_, this.getC_right_kind());
    }
    return this.c_right_kind_t;
  }

  public void setC_right_kind_t(C_Right_Kind c_right_kind_t) {
    this.c_right_kind_t = c_right_kind_t;
    this.c_right_kind = (this.c_right_kind_t != null ? this.c_right_kind_t.getC_right_kind() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_right());
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
    final C_Right other = (C_Right) obj;
    if (!Objects.equals(this.getC_right(), other.getC_right())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_right();
  }

}
