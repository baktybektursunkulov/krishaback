package model.core.dbtables;

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
@Table(name = "c_sms_out")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Sms_Out extends Abstract_Entity {

  //fields
  private Integer c_sms_out;
  private Integer c_proj;
  private String phone_number;
  private String msg_txt;
  private Boolean is_with_feedback;
  private Date ins_dt;
  private Boolean is_sent;
  private Date sent_dt;
  private String sent_err_msg;
  private String api_msg_id;
  private Double api_cost;
  private Integer api_cost_cur;
  private String cus_fields;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;
  private C_Cur api_cost_cur_t = null;

  public C_Sms_Out() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_sms_out", unique = true, nullable = false)
  public Integer getC_sms_out() {
    return this.c_sms_out;
  }

  public void setC_sms_out(Integer c_sms_out) {
    this.c_sms_out = c_sms_out;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  
  @Column(name = "phone_number", nullable = false)
  public String getPhone_number() {
    return this.phone_number;
  }

  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
  }

  
  @Column(name = "msg_txt", nullable = false)
  public String getMsg_txt() {
    return this.msg_txt;
  }

  public void setMsg_txt(String msg_txt) {
    this.msg_txt = msg_txt;
  }

  @Column(name = "is_with_feedback", nullable = false)
  public Boolean getIs_with_feedback() {
    return this.is_with_feedback;
  }

  public void setIs_with_feedback(Boolean is_with_feedback) {
    this.is_with_feedback = is_with_feedback;
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

  
  @Column(name = "api_msg_id")
  public String getApi_msg_id() {
    return this.api_msg_id;
  }

  public void setApi_msg_id(String api_msg_id) {
    this.api_msg_id = api_msg_id;
  }

  @Column(name = "api_cost")
  public Double getApi_cost() {
    return this.api_cost;
  }

  public void setApi_cost(Double api_cost) {
    this.api_cost = api_cost;
  }

  @Column(name = "api_cost_cur")
  public Integer getApi_cost_cur() {
    return this.api_cost_cur;
  }

  public void setApi_cost_cur(Integer api_cost_cur) {
    this.api_cost_cur = api_cost_cur;
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
  public C_Cur getApi_cost_cur_t() {
    if (this.api_cost_cur_t == null && this.getApi_cost_cur() != null) {
      this.api_cost_cur_t = C_Cur_Manager.getCI().get_rec(this.getApi_cost_cur());
    }
    return this.api_cost_cur_t;
  }

  @Transient
  public C_Cur getApi_cost_cur_t_2(Session session_) {
    if (this.api_cost_cur_t == null && this.getApi_cost_cur() != null) {
      this.api_cost_cur_t = C_Cur_Manager.getCI().get_rec(session_, this.getApi_cost_cur());
    }
    return this.api_cost_cur_t;
  }

  public void setApi_cost_cur_t(C_Cur api_cost_cur_t) {
    this.api_cost_cur_t = api_cost_cur_t;
    this.api_cost_cur = (this.api_cost_cur_t != null ? this.api_cost_cur_t.getC_cur() : null);
  }

  public JSONObject toJSONObject(Session session_, C_Usr c_usr_, String lang_) {
    Map obj_ = new LinkedHashMap();
    obj_.put("phone_number", getPhone_number());
    obj_.put("msg_txt", getMsg_txt());
    if (getSent_dt() != null) {
      Date new_sent_dt_ = C_Usr_Manager.getCI().getUsrTimeFromGMT0600TZ(c_usr_, getSent_dt());
      obj_.put("sent_dt", json_funcs.jsonDateTimeToStr(new_sent_dt_));
    } else {
      obj_.put("sent_dt", null);
    }
    obj_.put("sent_err_msg", getSent_err_msg() == null ? "" : getSent_err_msg());
    return new JSONObject(obj_);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_sms_out());
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
    final C_Sms_Out other = (C_Sms_Out) obj;
    if (!Objects.equals(this.getC_sms_out(), other.getC_sms_out())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_sms_out();
  }

}
