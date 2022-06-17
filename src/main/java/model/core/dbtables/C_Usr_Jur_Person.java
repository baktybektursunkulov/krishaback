package model.core.dbtables;

import gs.common.hibernate_funcs;
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
import others.CustomLogger;

@Entity
@Table(name = "c_usr_jur_person")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Jur_Person extends Abstract_Entity {

  //fields
  private Integer c_usr_jur_person;
  private Long c_usr;
  private Integer company_reg_country;
  private Integer c_business_form;
  private String company_name;
  private String iin_bin;
  private String phone_num;
  private String email;
  private String director_last_name;
  private String director_first_name;
  private String director_patronymic;
  private Boolean is_jur_and_fact_addr_same;
  private Boolean is_deleted;

  //transient fields
  private C_Usr c_usr_t = null;
  private C_Country company_reg_country_t = null;
  private C_Business_Form c_business_form_t = null;
  private C_Usr_Jur_Person_Addr jur_address_c_usr_jur_person_addr;
  private C_Usr_Jur_Person_Addr fact_address_c_usr_jur_person_addr;

  public C_Usr_Jur_Person() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_jur_person", unique = true, nullable = false)
  public Integer getC_usr_jur_person() {
    return this.c_usr_jur_person;
  }

  public void setC_usr_jur_person(Integer c_usr_jur_person) {
    this.c_usr_jur_person = c_usr_jur_person;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name = "company_reg_country")
  public Integer getCompany_reg_country() {
    return this.company_reg_country;
  }

  public void setCompany_reg_country(Integer company_reg_country) {
    this.company_reg_country = company_reg_country;
  }

  @Column(name = "c_business_form")
  public Integer getC_business_form() {
    return this.c_business_form;
  }

  public void setC_business_form(Integer c_business_form) {
    this.c_business_form = c_business_form;
  }

  
  @Column(name = "company_name", nullable = false)
  public String getCompany_name() {
    return this.company_name;
  }

  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  
  @Column(name = "iin_bin")
  public String getIin_bin() {
    return this.iin_bin;
  }

  public void setIin_bin(String iin_bin) {
    this.iin_bin = iin_bin;
  }

  
  @Column(name = "phone_num")
  public String getPhone_num() {
    return this.phone_num;
  }

  public void setPhone_num(String phone_num) {
    this.phone_num = phone_num;
  }

  
  @Column(name = "email")
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  
  @Column(name = "director_last_name")
  public String getDirector_last_name() {
    return this.director_last_name;
  }

  public void setDirector_last_name(String director_last_name) {
    this.director_last_name = director_last_name;
  }

  
  @Column(name = "director_first_name")
  public String getDirector_first_name() {
    return this.director_first_name;
  }

  public void setDirector_first_name(String director_first_name) {
    this.director_first_name = director_first_name;
  }

  
  @Column(name = "director_patronymic")
  public String getDirector_patronymic() {
    return this.director_patronymic;
  }

  public void setDirector_patronymic(String director_patronymic) {
    this.director_patronymic = director_patronymic;
  }

  @Column(name = "is_jur_and_fact_addr_same", nullable = false)
  public Boolean getIs_jur_and_fact_addr_same() {
    return this.is_jur_and_fact_addr_same;
  }

  public void setIs_jur_and_fact_addr_same(Boolean is_jur_and_fact_addr_same) {
    this.is_jur_and_fact_addr_same = is_jur_and_fact_addr_same;
  }

  @Column(name = "is_deleted", nullable = false)
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
    this.c_usr = (this.c_usr_t != null ? this.c_usr_t.getC_usr() : null);
  }

  @Transient
  public C_Country getCompany_reg_country_t() {
    if (this.company_reg_country_t == null && this.getCompany_reg_country() != null) {
      this.company_reg_country_t = C_Country_Manager.getCI().get_rec(this.getCompany_reg_country());
    }
    return this.company_reg_country_t;
  }

  @Transient
  public C_Country getCompany_reg_country_t_2(Session session_) {
    if (this.company_reg_country_t == null && this.getCompany_reg_country() != null) {
      this.company_reg_country_t = C_Country_Manager.getCI().get_rec(session_, this.getCompany_reg_country());
    }
    return this.company_reg_country_t;
  }

  public void setCompany_reg_country_t(C_Country company_reg_country_t) {
    this.company_reg_country_t = company_reg_country_t;
    this.company_reg_country = (this.company_reg_country_t != null ? this.company_reg_country_t.getC_country() : null);
  }

  @Transient
  public C_Business_Form getC_business_form_t() {
    if (this.c_business_form_t == null && this.getC_business_form() != null) {
      this.c_business_form_t = C_Business_Form_Manager.getCI().get_rec(this.getC_business_form());
    }
    return this.c_business_form_t;
  }

  @Transient
  public C_Business_Form getC_business_form_t_2(Session session_) {
    if (this.c_business_form_t == null && this.getC_business_form() != null) {
      this.c_business_form_t = C_Business_Form_Manager.getCI().get_rec(session_, this.getC_business_form());
    }
    return this.c_business_form_t;
  }

  public void setC_business_form_t(C_Business_Form c_business_form_t) {
    this.c_business_form_t = c_business_form_t;
    this.c_business_form = (this.c_business_form_t != null ? this.c_business_form_t.getC_business_form() : null);
  }

  @Transient
  public C_Usr_Jur_Person_Addr getJur_address_c_usr_jur_person_addr() {
    if (jur_address_c_usr_jur_person_addr == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        jur_address_c_usr_jur_person_addr = getJur_address_c_usr_jur_person_addr_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return jur_address_c_usr_jur_person_addr;
  }

  public void setJur_address_c_usr_jur_person_addr(C_Usr_Jur_Person_Addr jur_address_c_usr_jur_person_addr) {
    this.jur_address_c_usr_jur_person_addr = jur_address_c_usr_jur_person_addr;
  }

  @Transient
  public C_Usr_Jur_Person_Addr getJur_address_c_usr_jur_person_addr_2(Session session_) {
    if (jur_address_c_usr_jur_person_addr == null) {
      jur_address_c_usr_jur_person_addr = C_Usr_Jur_Person_Addr_Manager.getCI().get_row(session_, c_usr_jur_person, C_Jur_Person_Addr_Type_Manager.getCI().getId__jur_address());
    }
    return jur_address_c_usr_jur_person_addr;
  }

  @Transient
  public C_Usr_Jur_Person_Addr getFact_address_c_usr_jur_person_addr() {
    if (fact_address_c_usr_jur_person_addr == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        fact_address_c_usr_jur_person_addr = getFact_address_c_usr_jur_person_addr_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return fact_address_c_usr_jur_person_addr;
  }

  public void setFact_address_c_usr_jur_person_addr(C_Usr_Jur_Person_Addr fact_address_c_usr_jur_person_addr) {
    this.fact_address_c_usr_jur_person_addr = fact_address_c_usr_jur_person_addr;
  }

  @Transient
  public C_Usr_Jur_Person_Addr getFact_address_c_usr_jur_person_addr_2(Session session_) {
    if (fact_address_c_usr_jur_person_addr == null) {
      fact_address_c_usr_jur_person_addr = C_Usr_Jur_Person_Addr_Manager.getCI().get_row(session_, c_usr_jur_person, C_Jur_Person_Addr_Type_Manager.getCI().getId__fact_address());
    }
    return fact_address_c_usr_jur_person_addr;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_jur_person());
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
    final C_Usr_Jur_Person other = (C_Usr_Jur_Person) obj;
    if (!Objects.equals(this.getC_usr_jur_person(), other.getC_usr_jur_person())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_jur_person();
  }

}
