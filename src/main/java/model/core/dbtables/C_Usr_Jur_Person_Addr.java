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
@Table(name="c_usr_jur_person_addr")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Jur_Person_Addr extends Abstract_Entity {

  //fields
  private Integer c_usr_jur_person_addr;
  private Integer c_usr_jur_person;
  private Integer c_jur_person_addr_type;
  private Integer c_country;
  private String city;
  private String address;
  private String postcode;
  private Boolean is_deleted;

  //transient fields
  private C_Usr_Jur_Person c_usr_jur_person_t = null;
  private C_Jur_Person_Addr_Type c_jur_person_addr_type_t = null;
  private C_Country c_country_t = null;



  public C_Usr_Jur_Person_Addr() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_usr_jur_person_addr", unique=true, nullable=false)
  public Integer getC_usr_jur_person_addr() {
    return this.c_usr_jur_person_addr;
  }
  public void setC_usr_jur_person_addr(Integer c_usr_jur_person_addr) {
    this.c_usr_jur_person_addr = c_usr_jur_person_addr;
  }

  @Column(name="c_usr_jur_person", nullable=false)
  public Integer getC_usr_jur_person() {
    return this.c_usr_jur_person;
  }
  public void setC_usr_jur_person(Integer c_usr_jur_person) {
    this.c_usr_jur_person = c_usr_jur_person;
  }

  @Column(name="c_jur_person_addr_type", nullable=false)
  public Integer getC_jur_person_addr_type() {
    return this.c_jur_person_addr_type;
  }
  public void setC_jur_person_addr_type(Integer c_jur_person_addr_type) {
    this.c_jur_person_addr_type = c_jur_person_addr_type;
  }

  @Column(name="c_country", nullable=false)
  public Integer getC_country() {
    return this.c_country;
  }
  public void setC_country(Integer c_country) {
    this.c_country = c_country;
  }

  @Type(type="text")
  @Column(name="city", nullable=false)
  public String getCity() {
    return this.city;
  }
  public void setCity(String city) {
    this.city = city;
  }

  @Type(type="text")
  @Column(name="address", nullable=false)
  public String getAddress() {
    return this.address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  @Type(type="text")
  @Column(name="postcode")
  public String getPostcode() {
    return this.postcode;
  }
  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Usr_Jur_Person getC_usr_jur_person_t() {
    if (this.c_usr_jur_person_t == null && this.getC_usr_jur_person() != null) {
      this.c_usr_jur_person_t = C_Usr_Jur_Person_Manager.getCI().get_rec(this.getC_usr_jur_person()); 
    }
    return this.c_usr_jur_person_t;
  }
  @Transient
  public C_Usr_Jur_Person getC_usr_jur_person_t_2(Session session_) {
    if (this.c_usr_jur_person_t == null && this.getC_usr_jur_person() != null) {
      this.c_usr_jur_person_t = C_Usr_Jur_Person_Manager.getCI().get_rec(session_, this.getC_usr_jur_person()); 
    }
    return this.c_usr_jur_person_t;
  }
  public void setC_usr_jur_person_t(C_Usr_Jur_Person c_usr_jur_person_t) {
    this.c_usr_jur_person_t = c_usr_jur_person_t;
    this.c_usr_jur_person = (this.c_usr_jur_person_t != null?this.c_usr_jur_person_t.getC_usr_jur_person():null);
  }

  @Transient
  public C_Jur_Person_Addr_Type getC_jur_person_addr_type_t() {
    if (this.c_jur_person_addr_type_t == null && this.getC_jur_person_addr_type() != null) {
      this.c_jur_person_addr_type_t = C_Jur_Person_Addr_Type_Manager.getCI().get_rec(this.getC_jur_person_addr_type()); 
    }
    return this.c_jur_person_addr_type_t;
  }
  @Transient
  public C_Jur_Person_Addr_Type getC_jur_person_addr_type_t_2(Session session_) {
    if (this.c_jur_person_addr_type_t == null && this.getC_jur_person_addr_type() != null) {
      this.c_jur_person_addr_type_t = C_Jur_Person_Addr_Type_Manager.getCI().get_rec(session_, this.getC_jur_person_addr_type()); 
    }
    return this.c_jur_person_addr_type_t;
  }
  public void setC_jur_person_addr_type_t(C_Jur_Person_Addr_Type c_jur_person_addr_type_t) {
    this.c_jur_person_addr_type_t = c_jur_person_addr_type_t;
    this.c_jur_person_addr_type = (this.c_jur_person_addr_type_t != null?this.c_jur_person_addr_type_t.getC_jur_person_addr_type():null);
  }

  @Transient
  public C_Country getC_country_t() {
    if (this.c_country_t == null && this.getC_country() != null) {
      this.c_country_t = C_Country_Manager.getCI().get_rec(this.getC_country()); 
    }
    return this.c_country_t;
  }
  @Transient
  public C_Country getC_country_t_2(Session session_) {
    if (this.c_country_t == null && this.getC_country() != null) {
      this.c_country_t = C_Country_Manager.getCI().get_rec(session_, this.getC_country()); 
    }
    return this.c_country_t;
  }
  public void setC_country_t(C_Country c_country_t) {
    this.c_country_t = c_country_t;
    this.c_country = (this.c_country_t != null?this.c_country_t.getC_country():null);
  }






  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_jur_person_addr());
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
    final C_Usr_Jur_Person_Addr other = (C_Usr_Jur_Person_Addr) obj;
    if (!Objects.equals(this.getC_usr_jur_person_addr(), other.getC_usr_jur_person_addr())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_jur_person_addr();
  }

} 
