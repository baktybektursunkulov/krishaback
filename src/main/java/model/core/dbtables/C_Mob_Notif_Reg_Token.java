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
@Table(name="c_mob_notif_reg_token")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Mob_Notif_Reg_Token extends Abstract_Entity {

  //fields
  private Integer c_mob_notif_reg_token;
  private String uuid;
  private String reg_token;
  private String platform;
  private String user_name;
  private Date reg_dt;
  private String sound;
  private Boolean is_show_notifications;
  private Boolean is_active;
  private Boolean is_reg_token_valid;
  private Integer c_mob_notif_app;

  //transient fields
  private C_Mob_Notif_App c_mob_notif_app_t = null;


  public C_Mob_Notif_Reg_Token() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_mob_notif_reg_token", unique=true, nullable=false)
  public Integer getC_mob_notif_reg_token() {
    return this.c_mob_notif_reg_token;
  }
  public void setC_mob_notif_reg_token(Integer c_mob_notif_reg_token) {
    this.c_mob_notif_reg_token = c_mob_notif_reg_token;
  }

  @Type(type="text")
  @Column(name="uuid", nullable=false)
  public String getUuid() {
    return this.uuid;
  }
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  @Type(type="text")
  @Column(name="reg_token", nullable=false)
  public String getReg_token() {
    return this.reg_token;
  }
  public void setReg_token(String reg_token) {
    this.reg_token = reg_token;
  }

  @Type(type="text")
  @Column(name="platform", nullable=false)
  public String getPlatform() {
    return this.platform;
  }
  public void setPlatform(String platform) {
    this.platform = platform;
  }

  @Type(type="text")
  @Column(name="user_name", nullable=false)
  public String getUser_name() {
    return this.user_name;
  }
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="reg_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getReg_dt() {
    return this.reg_dt;
  }
  public void setReg_dt(Date reg_dt) {
    this.reg_dt = reg_dt;
  }

  @Type(type="text")
  @Column(name="sound", nullable=false)
  public String getSound() {
    return this.sound;
  }
  public void setSound(String sound) {
    this.sound = sound;
  }

  @Column(name="is_show_notifications", nullable=false)
  public Boolean getIs_show_notifications() {
    return this.is_show_notifications;
  }
  public void setIs_show_notifications(Boolean is_show_notifications) {
    this.is_show_notifications = is_show_notifications;
  }

  @Column(name="is_active", nullable=false)
  public Boolean getIs_active() {
    return this.is_active;
  }
  public void setIs_active(Boolean is_active) {
    this.is_active = is_active;
  }

  @Column(name="is_reg_token_valid", nullable=false)
  public Boolean getIs_reg_token_valid() {
    return this.is_reg_token_valid;
  }
  public void setIs_reg_token_valid(Boolean is_reg_token_valid) {
    this.is_reg_token_valid = is_reg_token_valid;
  }

  @Column(name="c_mob_notif_app", nullable=false)
  public Integer getC_mob_notif_app() {
    return this.c_mob_notif_app;
  }
  public void setC_mob_notif_app(Integer c_mob_notif_app) {
    this.c_mob_notif_app = c_mob_notif_app;
  }











  @Transient
  public C_Mob_Notif_App getC_mob_notif_app_t() {
    if (this.c_mob_notif_app_t == null && this.getC_mob_notif_app() != null) {
      this.c_mob_notif_app_t = C_Mob_Notif_App_Manager.getCI().get_rec(this.getC_mob_notif_app()); 
    }
    return this.c_mob_notif_app_t;
  }
  @Transient
  public C_Mob_Notif_App getC_mob_notif_app_t_2(Session session_) {
    if (this.c_mob_notif_app_t == null && this.getC_mob_notif_app() != null) {
      this.c_mob_notif_app_t = C_Mob_Notif_App_Manager.getCI().get_rec(session_, this.getC_mob_notif_app()); 
    }
    return this.c_mob_notif_app_t;
  }
  public void setC_mob_notif_app_t(C_Mob_Notif_App c_mob_notif_app_t) {
    this.c_mob_notif_app_t = c_mob_notif_app_t;
    this.c_mob_notif_app = (this.c_mob_notif_app_t != null?this.c_mob_notif_app_t.getC_mob_notif_app():null);
  }


  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_mob_notif_reg_token());
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
    final C_Mob_Notif_Reg_Token other = (C_Mob_Notif_Reg_Token) obj;
    if (!Objects.equals(this.getC_mob_notif_reg_token(), other.getC_mob_notif_reg_token())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_mob_notif_reg_token();
  }

} 
