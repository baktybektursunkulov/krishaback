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
@Table(name="c_usr_contact")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Contact extends Abstract_Entity {

  //fields
  private Integer c_usr_contact;
  private Long c_usr;
  private Integer c_usr_contact_type;
  private String phone_num;
  private Boolean is_deleted;

  //transient fields
  private C_Usr c_usr_t = null;
  private C_Usr_Contact_Type c_usr_contact_type_t = null;


  public C_Usr_Contact() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_usr_contact", unique=true, nullable=false)
  public Integer getC_usr_contact() {
    return this.c_usr_contact;
  }
  public void setC_usr_contact(Integer c_usr_contact) {
    this.c_usr_contact = c_usr_contact;
  }

  @Column(name="c_usr", nullable=false)
  public Long getC_usr() {
    return this.c_usr;
  }
  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name="c_usr_contact_type", nullable=false)
  public Integer getC_usr_contact_type() {
    return this.c_usr_contact_type;
  }
  public void setC_usr_contact_type(Integer c_usr_contact_type) {
    this.c_usr_contact_type = c_usr_contact_type;
  }

  @Type(type="text")
  @Column(name="phone_num", nullable=false)
  public String getPhone_num() {
    return this.phone_num;
  }
  public void setPhone_num(String phone_num) {
    this.phone_num = phone_num;
  }

  @Column(name="is_deleted", nullable=false)
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
    this.c_usr = (this.c_usr_t != null?this.c_usr_t.getC_usr():null);
  }

  @Transient
  public C_Usr_Contact_Type getC_usr_contact_type_t() {
    if (this.c_usr_contact_type_t == null && this.getC_usr_contact_type() != null) {
      this.c_usr_contact_type_t = C_Usr_Contact_Type_Manager.getCI().get_rec(this.getC_usr_contact_type()); 
    }
    return this.c_usr_contact_type_t;
  }
  @Transient
  public C_Usr_Contact_Type getC_usr_contact_type_t_2(Session session_) {
    if (this.c_usr_contact_type_t == null && this.getC_usr_contact_type() != null) {
      this.c_usr_contact_type_t = C_Usr_Contact_Type_Manager.getCI().get_rec(session_, this.getC_usr_contact_type()); 
    }
    return this.c_usr_contact_type_t;
  }
  public void setC_usr_contact_type_t(C_Usr_Contact_Type c_usr_contact_type_t) {
    this.c_usr_contact_type_t = c_usr_contact_type_t;
    this.c_usr_contact_type = (this.c_usr_contact_type_t != null?this.c_usr_contact_type_t.getC_usr_contact_type():null);
  }




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_contact());
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
    final C_Usr_Contact other = (C_Usr_Contact) obj;
    if (!Objects.equals(this.getC_usr_contact(), other.getC_usr_contact())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_contact();
  }

} 
