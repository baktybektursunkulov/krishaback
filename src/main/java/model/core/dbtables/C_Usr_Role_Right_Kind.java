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
@Table(name="c_usr_role_right_kind")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Role_Right_Kind extends Abstract_Entity {

  //fields
  private Integer c_usr_role_right_kind;
  private Integer c_usr_role;
  private Integer c_right_kind;
  private Boolean is_allow;
  private Boolean is_deleted;

  //transient fields
  private C_Usr_Role c_usr_role_t = null;
  private C_Right_Kind c_right_kind_t = null;



  public C_Usr_Role_Right_Kind() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_usr_role_right_kind", unique=true, nullable=false)
  public Integer getC_usr_role_right_kind() {
    return this.c_usr_role_right_kind;
  }
  public void setC_usr_role_right_kind(Integer c_usr_role_right_kind) {
    this.c_usr_role_right_kind = c_usr_role_right_kind;
  }

  @Column(name="c_usr_role", nullable=false)
  public Integer getC_usr_role() {
    return this.c_usr_role;
  }
  public void setC_usr_role(Integer c_usr_role) {
    this.c_usr_role = c_usr_role;
  }

  @Column(name="c_right_kind", nullable=false)
  public Integer getC_right_kind() {
    return this.c_right_kind;
  }
  public void setC_right_kind(Integer c_right_kind) {
    this.c_right_kind = c_right_kind;
  }

  @Column(name="is_allow", nullable=false)
  public Boolean getIs_allow() {
    return this.is_allow;
  }
  public void setIs_allow(Boolean is_allow) {
    this.is_allow = is_allow;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Usr_Role getC_usr_role_t() {
    if (this.c_usr_role_t == null && this.getC_usr_role() != null) {
      this.c_usr_role_t = C_Usr_Role_Manager.getCI().get_rec(this.getC_usr_role()); 
    }
    return this.c_usr_role_t;
  }
  @Transient
  public C_Usr_Role getC_usr_role_t_2(Session session_) {
    if (this.c_usr_role_t == null && this.getC_usr_role() != null) {
      this.c_usr_role_t = C_Usr_Role_Manager.getCI().get_rec(session_, this.getC_usr_role()); 
    }
    return this.c_usr_role_t;
  }
  public void setC_usr_role_t(C_Usr_Role c_usr_role_t) {
    this.c_usr_role_t = c_usr_role_t;
    this.c_usr_role = (this.c_usr_role_t != null?this.c_usr_role_t.getC_usr_role():null);
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
    this.c_right_kind = (this.c_right_kind_t != null?this.c_right_kind_t.getC_right_kind():null);
  }




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_role_right_kind());
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
    final C_Usr_Role_Right_Kind other = (C_Usr_Role_Right_Kind) obj;
    if (!Objects.equals(this.getC_usr_role_right_kind(), other.getC_usr_role_right_kind())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_role_right_kind();
  }

} 
