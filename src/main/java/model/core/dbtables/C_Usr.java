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
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;

@Entity
@Table(name = "c_usr")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Usr extends Abstract_Entity {

  //fields
  private Long c_usr;
  private Integer c_proj;
  private Integer c_usr_type;
  private String name;
  private String pswd;
  private String pswd_salt;
  private Long creator_usr;
  private Boolean can_change_pswd;
  private Boolean is_on;
  private String email;
  private Integer c_tz;
  private String our_note;
  private Date ins_dt;
  private Date sale_date;
  private Boolean is_subscribed_to_sys_news;
  private Boolean is_self_registered;
  private Integer c_usr_status;
  private String phone_num;
  private String cus_fields;
  private Boolean is_deleted;
  private Boolean is_email_verified;
  private Boolean is_phone_num_verified;
  private Integer c_usr_person_type;
  private String contact_person_fio;
  private Integer c_country;
  private Integer current_c_lang;

  private Set<C_Usr_Role> c_usr_roles = new HashSet<>();

  //transient fields
  private C_Proj c_proj_t = null;
  private C_Usr_Type c_usr_type_t = null;
  private C_Usr creator_usr_t = null;
  private C_Tz c_tz_t = null;
  private C_Usr_Status c_usr_status_t = null;
  private C_Usr_Tariff c_usr_tariff_t = null;
  private C_Usr_Person_Type c_usr_person_type_t = null;
  private C_Country c_country_t = null;
  private C_Usr_Role c_usr_role_t = null;
  private C_Tbl_Rec_Rating main_c_tbl_rec_rating;
  private C_Lang current_c_lang_t = null;
  private C_Usr_Jur_Person c_usr_jur_person;

  public C_Usr() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr", unique = true, nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  @Column(name = "c_usr_type", nullable = false)
  public Integer getC_usr_type() {
    return this.c_usr_type;
  }

  public void setC_usr_type(Integer c_usr_type) {
    this.c_usr_type = c_usr_type;
  }

  
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  
  @Column(name = "pswd", nullable = false)
  public String getPswd() {
    return this.pswd;
  }

  public void setPswd(String pswd) {
    this.pswd = pswd;
  }

  
  @Column(name = "pswd_salt", nullable = false)
  public String getPswd_salt() {
    return this.pswd_salt;
  }

  public void setPswd_salt(String pswd_salt) {
    this.pswd_salt = pswd_salt;
  }

  @Column(name = "creator_usr")
  public Long getCreator_usr() {
    return this.creator_usr;
  }

  public void setCreator_usr(Long creator_usr) {
    this.creator_usr = creator_usr;
  }

  @Column(name = "can_change_pswd", nullable = false)
  public Boolean getCan_change_pswd() {
    return this.can_change_pswd;
  }

  public void setCan_change_pswd(Boolean can_change_pswd) {
    this.can_change_pswd = can_change_pswd;
  }

  @Column(name = "is_on", nullable = false)
  public Boolean getIs_on() {
    return this.is_on;
  }

  public void setIs_on(Boolean is_on) {
    this.is_on = is_on;
  }

  
  @Column(name = "email", nullable = false)
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "c_tz", nullable = false)
  public Integer getC_tz() {
    return this.c_tz;
  }

  public void setC_tz(Integer c_tz) {
    this.c_tz = c_tz;
  }

  
  @Column(name = "our_note", nullable = true)
  public String getOur_note() {
    return this.our_note;
  }

  public void setOur_note(String our_note) {
    this.our_note = our_note;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "sale_date", length = 10, columnDefinition = "DATE")
  public Date getSale_date() {
    return this.sale_date;
  }

  public void setSale_date(Date sale_date) {
    this.sale_date = sale_date;
  }

  @Column(name = "is_subscribed_to_sys_news", nullable = false)
  public Boolean getIs_subscribed_to_sys_news() {
    return this.is_subscribed_to_sys_news;
  }

  public void setIs_subscribed_to_sys_news(Boolean is_subscribed_to_sys_news) {
    this.is_subscribed_to_sys_news = is_subscribed_to_sys_news;
  }

  @Column(name = "is_self_registered", nullable = false)
  public Boolean getIs_self_registered() {
    return this.is_self_registered;
  }

  public void setIs_self_registered(Boolean is_self_registered) {
    this.is_self_registered = is_self_registered;
  }

  @Column(name = "c_usr_status", nullable = false)
  public Integer getC_usr_status() {
    return this.c_usr_status;
  }

  public void setC_usr_status(Integer c_usr_status) {
    this.c_usr_status = c_usr_status;
  }

  
  @Column(name = "phone_num")
  public String getPhone_num() {
    return this.phone_num;
  }

  public void setPhone_num(String phone_num) {
    this.phone_num = phone_num;
  }

  @Column(name = "cus_fields")
  public String getCus_fields() {
    return this.cus_fields;
  }

  public void setCus_fields(String cus_fields) {
    this.cus_fields = cus_fields;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "is_email_verified", nullable = false)
  public Boolean getIs_email_verified() {
    return this.is_email_verified;
  }

  public void setIs_email_verified(Boolean is_email_verified) {
    this.is_email_verified = is_email_verified;
  }

  @Column(name = "is_phone_num_verified", nullable = false)
  public Boolean getIs_phone_num_verified() {
    return this.is_phone_num_verified;
  }

  public void setIs_phone_num_verified(Boolean is_phone_num_verified) {
    this.is_phone_num_verified = is_phone_num_verified;
  }

  @Column(name = "c_usr_person_type")
  public Integer getC_usr_person_type() {
    return this.c_usr_person_type;
  }

  public void setC_usr_person_type(Integer c_usr_person_type) {
    this.c_usr_person_type = c_usr_person_type;
  }

  
  @Column(name = "contact_person_fio")
  public String getContact_person_fio() {
    return this.contact_person_fio;
  }

  public void setContact_person_fio(String contact_person_fio) {
    this.contact_person_fio = contact_person_fio;
  }

  @Column(name = "c_country", nullable = false)
  public Integer getC_country() {
    return this.c_country;
  }

  public void setC_country(Integer c_country) {
    this.c_country = c_country;
  }

  @Column(name = "current_c_lang")
  public Integer getCurrent_c_lang() {
    return this.current_c_lang;
  }

  public void setCurrent_c_lang(Integer current_c_lang) {
    this.current_c_lang = current_c_lang;
  }

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "c_lt_usr_role",
    joinColumns = @JoinColumn(name = "c_usr"),
    inverseJoinColumns = @JoinColumn(name = "c_usr_role"))
  public Set<C_Usr_Role> getC_usr_roles() {
    return c_usr_roles;
  }

  public void setC_usr_roles(Set<C_Usr_Role> c_usr_roles) {
    this.c_usr_roles = c_usr_roles;
  }

  @Transient
  public C_Proj getC_proj_t() {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(this.getC_proj());
    }
    return this.c_proj_t;
  }

  @Transient
  public C_Proj getC_proj_t_2(Session session_) {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(session_, this.getC_proj());
    }
    return this.c_proj_t;
  }

  public void setC_proj_t(C_Proj c_proj_t) {
    this.c_proj_t = c_proj_t;
    this.c_proj = (this.c_proj_t != null ? this.c_proj_t.getC_proj() : null);
  }

  @Transient
  public C_Usr_Type getC_usr_type_t() {
    if (this.c_usr_type_t == null && this.getC_usr_type() != null) {
      this.c_usr_type_t = C_Usr_Type_Manager.getCI().get_rec(this.getC_usr_type());
    }
    return this.c_usr_type_t;
  }

  @Transient
  public C_Usr_Type getC_usr_type_t_2(Session session_) {
    if (this.c_usr_type_t == null && this.getC_usr_type() != null) {
      this.c_usr_type_t = C_Usr_Type_Manager.getCI().get_rec(session_, this.getC_usr_type());
    }
    return this.c_usr_type_t;
  }

  public void setC_usr_type_t(C_Usr_Type c_usr_type_t) {
    this.c_usr_type_t = c_usr_type_t;
    this.c_usr_type = (this.c_usr_type_t != null ? this.c_usr_type_t.getC_usr_type() : null);
  }

  @Transient
  public C_Usr getCreator_usr_t() {
    if (this.creator_usr_t == null && this.getCreator_usr() != null) {
      this.creator_usr_t = C_Usr_Manager.getCI().get_rec(this.getCreator_usr());
    }
    return this.creator_usr_t;
  }

  @Transient
  public C_Usr getCreator_usr_t_2(Session session_) {
    if (this.creator_usr_t == null && this.getCreator_usr() != null) {
      this.creator_usr_t = C_Usr_Manager.getCI().get_rec(session_, this.getCreator_usr());
    }
    return this.creator_usr_t;
  }

  public void setCreator_usr_t(C_Usr creator_usr_t) {
    this.creator_usr_t = creator_usr_t;
    this.creator_usr = (this.creator_usr_t != null ? this.creator_usr_t.getC_usr() : null);
  }

  @Transient
  public C_Tz getC_tz_t() {
    if (this.c_tz_t == null && this.getC_tz() != null) {
      this.c_tz_t = C_Tz_Manager.getCI().get_rec(this.getC_tz());
    }
    return this.c_tz_t;
  }

  @Transient
  public C_Tz getC_tz_t_2(Session session_) {
    if (this.c_tz_t == null && this.getC_tz() != null) {
      this.c_tz_t = C_Tz_Manager.getCI().get_rec(session_, this.getC_tz());
    }
    return this.c_tz_t;
  }

  public void setC_tz_t(C_Tz c_tz_t) {
    this.c_tz_t = c_tz_t;
    this.c_tz = (this.c_tz_t != null ? this.c_tz_t.getC_tz() : null);
  }

  @Transient
  public C_Usr_Status getC_usr_status_t() {
    if (this.c_usr_status_t == null && this.getC_usr_status() != null) {
      this.c_usr_status_t = C_Usr_Status_Manager.getCI().get_rec(this.getC_usr_status());
    }
    return this.c_usr_status_t;
  }

  @Transient
  public C_Usr_Status getC_usr_status_t_2(Session session_) {
    if (this.c_usr_status_t == null && this.getC_usr_status() != null) {
      this.c_usr_status_t = C_Usr_Status_Manager.getCI().get_rec(session_, this.getC_usr_status());
    }
    return this.c_usr_status_t;
  }

  public void setC_usr_status_t(C_Usr_Status c_usr_status_t) {
    this.c_usr_status_t = c_usr_status_t;
    this.c_usr_status = (this.c_usr_status_t != null ? this.c_usr_status_t.getC_usr_status() : null);
  }

  @Transient
  public Boolean getIs_blocked() {
    if (getC_usr_status() == null) {
      return false;
    }
    return getC_usr_status().equals(C_Usr_Status_Manager.getCI().getId__blocked());
  }

  @Transient
  public Boolean getIs_moderator() {
    if (getC_usr_roles() == null) {
      return false;
    }
    return getC_usr_roles().contains(new C_Usr_Role(C_Usr_Role_Manager.getCI().getId_code__moderator()));
  }

  @Transient
  public C_Usr_Person_Type getC_usr_person_type_t() {
    if (this.c_usr_person_type_t == null && this.getC_usr_person_type() != null) {
      this.c_usr_person_type_t = C_Usr_Person_Type_Manager.getCI().get_rec(this.getC_usr_person_type());
    }
    return this.c_usr_person_type_t;
  }

  @Transient
  public C_Usr_Person_Type getC_usr_person_type_t_2(Session session_) {
    if (this.c_usr_person_type_t == null && this.getC_usr_person_type() != null) {
      this.c_usr_person_type_t = C_Usr_Person_Type_Manager.getCI().get_rec(session_, this.getC_usr_person_type());
    }
    return this.c_usr_person_type_t;
  }

  public void setC_usr_person_type_t(C_Usr_Person_Type c_usr_person_type_t) {
    this.c_usr_person_type_t = c_usr_person_type_t;
    this.c_usr_person_type = (this.c_usr_person_type_t != null ? this.c_usr_person_type_t.getC_usr_person_type() : null);
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
  public C_Tbl_Rec_Rating getMain_c_tbl_rec_rating() {
    if (main_c_tbl_rec_rating == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        main_c_tbl_rec_rating = getMain_c_tbl_rec_rating_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return main_c_tbl_rec_rating;
  }

  public C_Tbl_Rec_Rating getMain_c_tbl_rec_rating_2(Session session_) {
    if (main_c_tbl_rec_rating == null) {
      main_c_tbl_rec_rating = C_Tbl_Rec_Rating_Manager.getCI().get_row(session_, C_Tbl_Manager.getCI().getC_tbl_id__c_usr(), this.getC_usr().longValue(), C_Usr_Review_Kind_Manager.getCI().getC_usr_review_kind_id__main());
    }
    return main_c_tbl_rec_rating;
  }

  public void setMain_c_tbl_rec_rating(C_Tbl_Rec_Rating main_c_tbl_rec_rating) {
    this.main_c_tbl_rec_rating = main_c_tbl_rec_rating;
  }

  @Transient
  public C_Lang getCurrent_c_lang_t() {
    if (this.current_c_lang_t == null && this.getCurrent_c_lang() != null) {
      this.current_c_lang_t = C_Lang_Manager.getCI().get_rec(this.getCurrent_c_lang());
    }
    return this.current_c_lang_t;
  }

  @Transient
  public C_Lang getCurrent_c_lang_t_2(Session session_) {
    if (this.current_c_lang_t == null && this.getCurrent_c_lang() != null) {
      this.current_c_lang_t = C_Lang_Manager.getCI().get_rec(session_, this.getCurrent_c_lang());
    }
    return this.current_c_lang_t;
  }

  public void setCurrent_c_lang_t(C_Lang current_c_lang_t) {
    this.current_c_lang_t = current_c_lang_t;
    this.current_c_lang = (this.current_c_lang_t != null ? this.current_c_lang_t.getC_lang() : null);
  }

  @Transient
  public C_Usr_Jur_Person getC_usr_jur_person() {
    if (c_usr_jur_person == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        c_usr_jur_person = getC_usr_jur_person_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return c_usr_jur_person;
  }

  public void setC_usr_jur_person(C_Usr_Jur_Person c_usr_jur_person) {
    this.c_usr_jur_person = c_usr_jur_person;
  }

  public C_Usr_Jur_Person getC_usr_jur_person_2(Session session_) {
    if (c_usr_jur_person == null) {
      c_usr_jur_person = C_Usr_Jur_Person_Manager.getCI().get_row(session_, c_usr);
    }
    return c_usr_jur_person;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr());
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
    final C_Usr other = (C_Usr) obj;
    if (!Objects.equals(this.getC_usr(), other.getC_usr())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr();
  }

}
