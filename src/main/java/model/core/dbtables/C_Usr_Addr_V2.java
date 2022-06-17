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
@Table(name = "c_usr_addr_v2")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Addr_V2 extends Abstract_Entity {

  //fields
  private Integer c_usr_addr_v2;
  private Long c_usr;
  private Integer c_addr_type;
  private String full_name;
  private String phone_num;
  private String address_1;
  private String address_2;
  private Integer c_loc;
  private String postcode;
  private String comments;
  private Boolean is_default;
  private Boolean is_deleted;
  private Integer c_country;

  //transient fields
  private C_Usr c_usr_t = null;
  private C_Addr_Type c_addr_type_t = null;
  private C_Loc c_loc_t = null;
  private C_Country c_country_t = null;

  public C_Usr_Addr_V2() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_addr_v2", unique = true, nullable = false)
  public Integer getC_usr_addr_v2() {
    return this.c_usr_addr_v2;
  }

  public void setC_usr_addr_v2(Integer c_usr_addr_v2) {
    this.c_usr_addr_v2 = c_usr_addr_v2;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name = "c_addr_type", nullable = false)
  public Integer getC_addr_type() {
    return this.c_addr_type;
  }

  public void setC_addr_type(Integer c_addr_type) {
    this.c_addr_type = c_addr_type;
  }

  
  @Column(name = "full_name", nullable = false)
  public String getFull_name() {
    return this.full_name;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  
  @Column(name = "phone_num", nullable = false)
  public String getPhone_num() {
    return this.phone_num;
  }

  public void setPhone_num(String phone_num) {
    this.phone_num = phone_num;
  }

  
  @Column(name = "address_1", nullable = false)
  public String getAddress_1() {
    return this.address_1;
  }

  public void setAddress_1(String address_1) {
    this.address_1 = address_1;
  }

  
  @Column(name = "address_2")
  public String getAddress_2() {
    return this.address_2;
  }

  public void setAddress_2(String address_2) {
    this.address_2 = address_2;
  }

  @Column(name = "c_loc", nullable = false)
  public Integer getC_loc() {
    return this.c_loc;
  }

  public void setC_loc(Integer c_loc) {
    this.c_loc = c_loc;
  }

  
  @Column(name = "postcode")
  public String getPostcode() {
    return this.postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  
  @Column(name = "comments")
  public String getComments() {
    return this.comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  @Column(name = "is_default", nullable = false)
  public Boolean getIs_default() {
    return this.is_default;
  }

  public void setIs_default(Boolean is_default) {
    this.is_default = is_default;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "c_country", nullable = false)
  public Integer getC_country() {
    return this.c_country;
  }

  public void setC_country(Integer c_country) {
    this.c_country = c_country;
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
    this.c_usr = (this.c_usr_t != null ? this.c_usr_t.getC_usr() : null);
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
    this.c_addr_type = (this.c_addr_type_t != null ? this.c_addr_type_t.getC_addr_type() : null);
  }

  @Transient
  public C_Loc getC_loc_t() {
    if (this.c_loc_t == null && this.getC_loc() != null) {
      this.c_loc_t = C_Loc_Manager.getCI().get_rec(this.getC_loc());
    }
    return this.c_loc_t;
  }

  @Transient
  public C_Loc getC_loc_t_2(Session session_) {
    if (this.c_loc_t == null && this.getC_loc() != null) {
      this.c_loc_t = C_Loc_Manager.getCI().get_rec(session_, this.getC_loc());
    }
    return this.c_loc_t;
  }

  public void setC_loc_t(C_Loc c_loc_t) {
    this.c_loc_t = c_loc_t;
    this.c_loc = (this.c_loc_t != null ? this.c_loc_t.getC_loc() : null);
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
    this.c_country = (this.c_country_t != null ? this.c_country_t.getC_country() : null);
  }

  @Transient
  public String getC_loc_t__name() {
    return getC_loc_t() == null ? "" : getC_loc_t().getName();
  }

  public void setC_loc_t__name(String c_loc_t__name) {
  }

  @Transient
  public String getC_loc_t__calc_full_name() {
    return getC_loc_t() == null ? "" : getC_loc_t().getCalc_full_name();
  }

  public void setC_loc_t__calc_full_name(String c_loc_t__calc_full_name) {
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_addr_v2());
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
    final C_Usr_Addr_V2 other = (C_Usr_Addr_V2) obj;
    if (!Objects.equals(this.getC_usr_addr_v2(), other.getC_usr_addr_v2())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_addr_v2();
  }

}
