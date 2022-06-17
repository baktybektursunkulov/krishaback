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
@Table(name = "c_usr_nat_person")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Nat_Person extends Abstract_Entity {

  //fields
  private Integer c_usr_nat_person;
  private Long c_usr;
  private String first_name;
  private String last_name;
  private String patronymic;
  private Date birth_date;
  private Integer c_gender;
  private String full_name;
  private Integer c_id_doc_kind;
  private String id_doc_num;
  private Date id_doc_issue_date;
  private Date id_exp_date;
  private Integer citizen_country;
  private Boolean is_deleted;

  //transient fields
  private C_Usr c_usr_t = null;
  private C_Gender c_gender_t = null;
  private C_Id_Doc_Kind c_id_doc_kind_t = null;
  private C_Country citizen_country_t = null;

  public C_Usr_Nat_Person() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_nat_person", unique = true, nullable = false)
  public Integer getC_usr_nat_person() {
    return this.c_usr_nat_person;
  }

  public void setC_usr_nat_person(Integer c_usr_nat_person) {
    this.c_usr_nat_person = c_usr_nat_person;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  
  @Column(name = "first_name")
  public String getFirst_name() {
    return this.first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  
  @Column(name = "last_name")
  public String getLast_name() {
    return this.last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  
  @Column(name = "patronymic")
  public String getPatronymic() {
    return this.patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "birth_date", length = 10, columnDefinition = "DATE")
  public Date getBirth_date() {
    return this.birth_date;
  }

  public void setBirth_date(Date birth_date) {
    this.birth_date = birth_date;
  }

  @Column(name = "c_gender")
  public Integer getC_gender() {
    return this.c_gender;
  }

  public void setC_gender(Integer c_gender) {
    this.c_gender = c_gender;
  }

  
  @Column(name = "full_name")
  public String getFull_name() {
    return this.full_name;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  @Column(name = "c_id_doc_kind")
  public Integer getC_id_doc_kind() {
    return this.c_id_doc_kind;
  }

  public void setC_id_doc_kind(Integer c_id_doc_kind) {
    this.c_id_doc_kind = c_id_doc_kind;
  }

  
  @Column(name = "id_doc_num")
  public String getId_doc_num() {
    return this.id_doc_num;
  }

  public void setId_doc_num(String id_doc_num) {
    this.id_doc_num = id_doc_num;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "id_doc_issue_date", length = 10, columnDefinition = "DATE")
  public Date getId_doc_issue_date() {
    return this.id_doc_issue_date;
  }

  public void setId_doc_issue_date(Date id_doc_issue_date) {
    this.id_doc_issue_date = id_doc_issue_date;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "id_exp_date", length = 10, columnDefinition = "DATE")
  public Date getId_exp_date() {
    return this.id_exp_date;
  }

  public void setId_exp_date(Date id_exp_date) {
    this.id_exp_date = id_exp_date;
  }

  @Column(name = "citizen_country")
  public Integer getCitizen_country() {
    return this.citizen_country;
  }

  public void setCitizen_country(Integer citizen_country) {
    this.citizen_country = citizen_country;
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
  public C_Gender getC_gender_t() {
    if (this.c_gender_t == null && this.getC_gender() != null) {
      this.c_gender_t = C_Gender_Manager.getCI().get_rec(this.getC_gender());
    }
    return this.c_gender_t;
  }

  @Transient
  public C_Gender getC_gender_t_2(Session session_) {
    if (this.c_gender_t == null && this.getC_gender() != null) {
      this.c_gender_t = C_Gender_Manager.getCI().get_rec(session_, this.getC_gender());
    }
    return this.c_gender_t;
  }

  public void setC_gender_t(C_Gender c_gender_t) {
    this.c_gender_t = c_gender_t;
    this.c_gender = (this.c_gender_t != null ? this.c_gender_t.getC_gender() : null);
  }

  @Transient
  public C_Id_Doc_Kind getC_id_doc_kind_t() {
    if (this.c_id_doc_kind_t == null && this.getC_id_doc_kind() != null) {
      this.c_id_doc_kind_t = C_Id_Doc_Kind_Manager.getCI().get_rec(this.getC_id_doc_kind());
    }
    return this.c_id_doc_kind_t;
  }

  @Transient
  public C_Id_Doc_Kind getC_id_doc_kind_t_2(Session session_) {
    if (this.c_id_doc_kind_t == null && this.getC_id_doc_kind() != null) {
      this.c_id_doc_kind_t = C_Id_Doc_Kind_Manager.getCI().get_rec(session_, this.getC_id_doc_kind());
    }
    return this.c_id_doc_kind_t;
  }

  public void setC_id_doc_kind_t(C_Id_Doc_Kind c_id_doc_kind_t) {
    this.c_id_doc_kind_t = c_id_doc_kind_t;
    this.c_id_doc_kind = (this.c_id_doc_kind_t != null ? this.c_id_doc_kind_t.getC_id_doc_kind() : null);
  }

  @Transient
  public C_Country getCitizen_country_t() {
    if (this.citizen_country_t == null && this.getCitizen_country() != null) {
      this.citizen_country_t = C_Country_Manager.getCI().get_rec(this.getCitizen_country());
    }
    return this.citizen_country_t;
  }

  @Transient
  public C_Country getCitizen_country_t_2(Session session_) {
    if (this.citizen_country_t == null && this.getCitizen_country() != null) {
      this.citizen_country_t = C_Country_Manager.getCI().get_rec(session_, this.getCitizen_country());
    }
    return this.citizen_country_t;
  }

  public void setCitizen_country_t(C_Country citizen_country_t) {
    this.citizen_country_t = citizen_country_t;
    this.citizen_country = (this.citizen_country_t != null ? this.citizen_country_t.getC_country() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_nat_person());
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
    final C_Usr_Nat_Person other = (C_Usr_Nat_Person) obj;
    if (!Objects.equals(this.getC_usr_nat_person(), other.getC_usr_nat_person())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_nat_person();
  }

}
