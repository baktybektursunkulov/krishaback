package model.ho.dbtables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import managers.ho.dbtables.*;
import org.hibernate.Session;
import model.core.dbtables.*;
import managers.core.dbtables.*;

@Entity
@Table(name="ho_usr")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Ho_Usr extends Abstract_Entity {

  //fields
  private Long ho_usr;
  private Long c_usr;
  private Integer ho_contact_info_type;
  private String contact_name;
  private String main_phone_num;
  private Integer c_loc;
  private Boolean is_notif_when_publish;
  private Boolean is_notif_when_refuse;
  private Boolean is_notif_when_remove;
  private Boolean is_notif_when_new_msg;
  private Boolean is_deleted;

  //transient fields
  private C_Usr c_usr_t = null;
  private Ho_Contact_Info_Type ho_contact_info_type_t = null;
  private C_Loc c_loc_t = null;



  public Ho_Usr() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ho_usr", unique=true, nullable=false)
  public Long getHo_usr() {
    return this.ho_usr;
  }
  public void setHo_usr(Long ho_usr) {
    this.ho_usr = ho_usr;
  }

  @Column(name="c_usr", nullable=false)
  public Long getC_usr() {
    return this.c_usr;
  }
  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name="ho_contact_info_type")
  public Integer getHo_contact_info_type() {
    return this.ho_contact_info_type;
  }
  public void setHo_contact_info_type(Integer ho_contact_info_type) {
    this.ho_contact_info_type = ho_contact_info_type;
  }

  @Type(type="text")
  @Column(name="contact_name")
  public String getContact_name() {
    return this.contact_name;
  }
  public void setContact_name(String contact_name) {
    this.contact_name = contact_name;
  }

  @Type(type="text")
  @Column(name="main_phone_num")
  public String getMain_phone_num() {
    return this.main_phone_num;
  }
  public void setMain_phone_num(String main_phone_num) {
    this.main_phone_num = main_phone_num;
  }

  @Column(name="c_loc")
  public Integer getC_loc() {
    return this.c_loc;
  }
  public void setC_loc(Integer c_loc) {
    this.c_loc = c_loc;
  }

  @Column(name="is_notif_when_publish", nullable=false)
  public Boolean getIs_notif_when_publish() {
    return this.is_notif_when_publish;
  }
  public void setIs_notif_when_publish(Boolean is_notif_when_publish) {
    this.is_notif_when_publish = is_notif_when_publish;
  }

  @Column(name="is_notif_when_refuse", nullable=false)
  public Boolean getIs_notif_when_refuse() {
    return this.is_notif_when_refuse;
  }
  public void setIs_notif_when_refuse(Boolean is_notif_when_refuse) {
    this.is_notif_when_refuse = is_notif_when_refuse;
  }

  @Column(name="is_notif_when_remove", nullable=false)
  public Boolean getIs_notif_when_remove() {
    return this.is_notif_when_remove;
  }
  public void setIs_notif_when_remove(Boolean is_notif_when_remove) {
    this.is_notif_when_remove = is_notif_when_remove;
  }

  @Column(name="is_notif_when_new_msg", nullable=false)
  public Boolean getIs_notif_when_new_msg() {
    return this.is_notif_when_new_msg;
  }
  public void setIs_notif_when_new_msg(Boolean is_notif_when_new_msg) {
    this.is_notif_when_new_msg = is_notif_when_new_msg;
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
//  @Transient
//  public C_Usr getC_usr_t_2(Session session_) {
//    if (this.c_usr_t == null && this.getC_usr() != null) {
//      this.c_usr_t = C_Usr_Manager.getCI().get_rec(session_, this.getC_usr()); 
//    }
//    return this.c_usr_t;
//  }
  public void setC_usr_t(C_Usr c_usr_t) {
    this.c_usr_t = c_usr_t;
    this.c_usr = (this.c_usr_t != null?this.c_usr_t.getC_usr():null);
  }

  @Transient
  public Ho_Contact_Info_Type getHo_contact_info_type_t() {
    if (this.ho_contact_info_type_t == null && this.getHo_contact_info_type() != null) {
      this.ho_contact_info_type_t = Ho_Contact_Info_Type_Manager.getCI().get_rec(this.getHo_contact_info_type()); 
    }
    return this.ho_contact_info_type_t;
  }
   public Ho_Contact_Info_Type getHo_contact_info_type_t_2(Session session_) {
    if (this.ho_contact_info_type_t == null && this.getHo_contact_info_type() != null) {
      this.ho_contact_info_type_t = Ho_Contact_Info_Type_Manager.getCI().get_rec(session_, this.getHo_contact_info_type()); 
    }
    return this.ho_contact_info_type_t;
  }
   
//   @Transient
//  public Ho_Contact_Info_Type getHo_contact_info_type_t_2(Session session_) {
//    if (this.ho_contact_info_type_t == null && this.getHo_contact_info_type() != null) {
//      this.ho_contact_info_type_t = Ho_Contact_Info_Type_Manager.getCI().get_rec(session_, this.getHo_contact_info_type()); 
//    }
//    return this.ho_contact_info_type_t;
//  }
  public void setHo_contact_info_type_t(Ho_Contact_Info_Type ho_contact_info_type_t) {
    this.ho_contact_info_type_t = ho_contact_info_type_t;
    this.ho_contact_info_type = (this.ho_contact_info_type_t != null?this.ho_contact_info_type_t.getHo_contact_info_type():null);
  }



  @Transient
  public C_Loc getC_loc_t() {
    if (this.c_loc_t == null && this.getC_loc() != null) {
      this.c_loc_t = C_Loc_Manager.getCI().get_rec(this.getC_loc()); 
    }
    return this.c_loc_t;
  }
  
//  @Transient
//  public C_Loc getC_loc_t_2(Session session_) {
//    if (this.c_loc_t == null && this.getC_loc() != null) {
//      this.c_loc_t = C_Loc_Manager.getCI().get_rec(session_, this.getC_loc()); 
//    }
//    return this.c_loc_t;
//  }
  public void setC_loc_t(C_Loc c_loc_t) {
    this.c_loc_t = c_loc_t;
    this.c_loc = (this.c_loc_t != null?this.c_loc_t.getC_loc():null);
  }







  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getHo_usr());
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
    final Ho_Usr other = (Ho_Usr) obj;
    if (!Objects.equals(this.getHo_usr(), other.getHo_usr())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_usr();
  }

} 
