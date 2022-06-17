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
@Table(name="c_usr_addr")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Addr extends Abstract_Entity {

  //fields
  private Integer c_usr_addr;
  private Long c_usr;
  private Integer c_addr_type;
  private String full_name;
  private String address_1;
  private String address_2;
  private String city;
  private String postcode;
  private String region;
  private Integer c_country;
  private String phone_num;
  private Boolean is_deleted;

  //transient fields
  private C_Usr c_usr_t = null;
  private C_Addr_Type c_addr_type_t = null;
  private C_Country c_country_t = null;


  public C_Usr_Addr() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_usr_addr", unique=true, nullable=false)
  public Integer getC_usr_addr() {
    return this.c_usr_addr;
  }
  public void setC_usr_addr(Integer c_usr_addr) {
    this.c_usr_addr = c_usr_addr;
  }

  @Column(name="c_usr", nullable=false)
  public Long getC_usr() {
    return this.c_usr;
  }
  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name="c_addr_type", nullable=false)
  public Integer getC_addr_type() {
    return this.c_addr_type;
  }
  public void setC_addr_type(Integer c_addr_type) {
    this.c_addr_type = c_addr_type;
  }

  @Type(type="text")
  @Column(name="full_name", nullable=false)
  public String getFull_name() {
    return this.full_name;
  }
  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  @Type(type="text")
  @Column(name="address_1", nullable=false)
  public String getAddress_1() {
    return this.address_1;
  }
  public void setAddress_1(String address_1) {
    this.address_1 = address_1;
  }

  @Type(type="text")
  @Column(name="address_2")
  public String getAddress_2() {
    return this.address_2;
  }
  public void setAddress_2(String address_2) {
    this.address_2 = address_2;
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
  @Column(name="postcode")
  public String getPostcode() {
    return this.postcode;
  }
  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  @Type(type="text")
  @Column(name="region")
  public String getRegion() {
    return this.region;
  }
  public void setRegion(String region) {
    this.region = region;
  }

  @Column(name="c_country", nullable=false)
  public Integer getC_country() {
    return this.c_country;
  }
  public void setC_country(Integer c_country) {
    this.c_country = c_country;
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
  public C_Addr_Type getC_addr_type_t() {
    if (this.c_addr_type_t == null && this.getC_addr_type() != null) {
      this.c_addr_type_t = C_Addr_Type_Manager.getCI().get_rec(this.getC_addr_type()); 
    }
    return this.c_addr_type_t;
  }
  @Transient
  public C_Addr_Type getC_addr_type_t_2(Session session_) {
    if (this.c_addr_type_t == null && this.getC_addr_type() != null) {
      this.c_addr_type_t = C_Addr_Type_Manager.getCI().get_rec(session_, this.getC_addr_type()); 
    }
    return this.c_addr_type_t;
  }
  public void setC_addr_type_t(C_Addr_Type c_addr_type_t) {
    this.c_addr_type_t = c_addr_type_t;
    this.c_addr_type = (this.c_addr_type_t != null?this.c_addr_type_t.getC_addr_type():null);
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
    hash = 89 * hash + Objects.hashCode(this.getC_usr_addr());
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
    final C_Usr_Addr other = (C_Usr_Addr) obj;
    if (!Objects.equals(this.getC_usr_addr(), other.getC_usr_addr())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_addr();
  }

} 
