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
@Table(name="c_mob_notif_out_token")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Mob_Notif_Out_Token extends Abstract_Entity {

  //fields
  private Integer c_mob_notif_out_token;
  private Integer c_mob_notif_out;
  private String uuid;
  private String reg_token;
  private String platform;
  private String user_name;
  private String sound;
  private Date ins_dt;
  private Boolean is_sent;
  private Date sent_dt;
  private String sent_err_msg;

  //transient fields
  private C_Mob_Notif_Out c_mob_notif_out_t = null;


  public C_Mob_Notif_Out_Token() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_mob_notif_out_token", unique=true, nullable=false)
  public Integer getC_mob_notif_out_token() {
    return this.c_mob_notif_out_token;
  }
  public void setC_mob_notif_out_token(Integer c_mob_notif_out_token) {
    this.c_mob_notif_out_token = c_mob_notif_out_token;
  }

  @Column(name="c_mob_notif_out", nullable=false)
  public Integer getC_mob_notif_out() {
    return this.c_mob_notif_out;
  }
  public void setC_mob_notif_out(Integer c_mob_notif_out) {
    this.c_mob_notif_out = c_mob_notif_out;
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

  @Type(type="text")
  @Column(name="sound", nullable=false)
  public String getSound() {
    return this.sound;
  }
  public void setSound(String sound) {
    this.sound = sound;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ins_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }
  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name="is_sent", nullable=false)
  public Boolean getIs_sent() {
    return this.is_sent;
  }
  public void setIs_sent(Boolean is_sent) {
    this.is_sent = is_sent;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="sent_dt", length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getSent_dt() {
    return this.sent_dt;
  }
  public void setSent_dt(Date sent_dt) {
    this.sent_dt = sent_dt;
  }

  @Type(type="text")
  @Column(name="sent_err_msg")
  public String getSent_err_msg() {
    return this.sent_err_msg;
  }
  public void setSent_err_msg(String sent_err_msg) {
    this.sent_err_msg = sent_err_msg;
  }


  @Transient
  public C_Mob_Notif_Out getC_mob_notif_out_t() {
    if (this.c_mob_notif_out_t == null && this.getC_mob_notif_out() != null) {
      this.c_mob_notif_out_t = C_Mob_Notif_Out_Manager.getCI().get_rec(this.getC_mob_notif_out()); 
    }
    return this.c_mob_notif_out_t;
  }
  @Transient
  public C_Mob_Notif_Out getC_mob_notif_out_t_2(Session session_) {
    if (this.c_mob_notif_out_t == null && this.getC_mob_notif_out() != null) {
      this.c_mob_notif_out_t = C_Mob_Notif_Out_Manager.getCI().get_rec(session_, this.getC_mob_notif_out()); 
    }
    return this.c_mob_notif_out_t;
  }
  public void setC_mob_notif_out_t(C_Mob_Notif_Out c_mob_notif_out_t) {
    this.c_mob_notif_out_t = c_mob_notif_out_t;
    this.c_mob_notif_out = (this.c_mob_notif_out_t != null?this.c_mob_notif_out_t.getC_mob_notif_out():null);
  }











  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_mob_notif_out_token());
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
    final C_Mob_Notif_Out_Token other = (C_Mob_Notif_Out_Token) obj;
    if (!Objects.equals(this.getC_mob_notif_out_token(), other.getC_mob_notif_out_token())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_mob_notif_out_token();
  }

} 
