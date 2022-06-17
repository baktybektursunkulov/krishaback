package model.core.dbtables;

import gs.common.Consts;
import gs.common.json_funcs;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import java.util.LinkedHashMap;
import java.util.Map;
import managers.core.dbtables.*;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Session;

@Entity
@Table(name = "c_mob_notif_out")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Mob_Notif_Out extends Abstract_Entity {

  //fields
  private Integer c_mob_notif_out;
  private Integer c_proj;
  private Long c_usr;
  private String title;
  private String txt;
  private Date ins_dt;
  private Boolean is_sent;
  private Date sent_dt;
  private String sent_err_msg;
  private String custom_fields;

  //transient fields
  private C_Proj c_proj_t = null;
  private C_Usr c_usr_t = null;

  public C_Mob_Notif_Out() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_mob_notif_out", unique = true, nullable = false)
  public Integer getC_mob_notif_out() {
    return this.c_mob_notif_out;
  }

  public void setC_mob_notif_out(Integer c_mob_notif_out) {
    this.c_mob_notif_out = c_mob_notif_out;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  
  @Column(name = "title", nullable = false)
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  
  @Column(name = "txt", nullable = false)
  public String getTxt() {
    return this.txt;
  }

  public void setTxt(String txt) {
    this.txt = txt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name = "is_sent", nullable = false)
  public Boolean getIs_sent() {
    return this.is_sent;
  }

  public void setIs_sent(Boolean is_sent) {
    this.is_sent = is_sent;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "sent_dt", length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getSent_dt() {
    return this.sent_dt;
  }

  public void setSent_dt(Date sent_dt) {
    this.sent_dt = sent_dt;
  }

  
  @Column(name = "sent_err_msg")
  public String getSent_err_msg() {
    return this.sent_err_msg;
  }

  public void setSent_err_msg(String sent_err_msg) {
    this.sent_err_msg = sent_err_msg;
  }

  
  @Column(name = "custom_fields")
  public String getCustom_fields() {
    return this.custom_fields;
  }

  public void setCustom_fields(String custom_fields) {
    this.custom_fields = custom_fields;
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

  public JSONObject toJSONObject(Session gtsc_session_, C_Usr c_usr_) {
    Map obj_ = new LinkedHashMap();
    obj_.put("id", getC_mob_notif_out());
    obj_.put("usr_id", getC_usr());
    obj_.put("title", getTitle());
    obj_.put("txt", getTxt());
    Date dt_ = C_Usr_Manager.getCI().getUsrTimeFromGMT0600TZ(c_usr_, getIns_dt());
    obj_.put("dt_", json_funcs.jsonDateTimeToStr(dt_));
    obj_.put("dt_str", Consts.sdfddMMyyyyHHmmss().format(dt_));
    return new JSONObject(obj_);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_mob_notif_out());
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
    final C_Mob_Notif_Out other = (C_Mob_Notif_Out) obj;
    if (!Objects.equals(this.getC_mob_notif_out(), other.getC_mob_notif_out())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_mob_notif_out();
  }

}
