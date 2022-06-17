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
@Table(name = "c_chat_msg")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Chat_Msg extends Abstract_Entity {

  //fields
  private Long c_chat_msg;
  private Integer c_chat;
  private Integer c_chat_msg_type;
  private Integer sender_c_tbl;
  private Long sender_rec_id;
  private String msg_txt;
  private Boolean is_delivered;
  private Date deliver_dt;
  private Boolean is_read;
  private Date read_dt;
  private Long reply_id;
  private Date ins_dt;
  private Boolean is_deleted;
  private Boolean is_sent;
  private Date sent_dt;

  //transient fields
  private C_Chat c_chat_t = null;
  private C_Chat_Msg_Type c_chat_msg_type_t = null;
  private C_Tbl sender_c_tbl_t = null;
  private C_Chat_Msg reply_id_t = null;
  private String icon_url;

  public C_Chat_Msg() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_chat_msg", unique = true, nullable = false)
  public Long getC_chat_msg() {
    return this.c_chat_msg;
  }

  public void setC_chat_msg(Long c_chat_msg) {
    this.c_chat_msg = c_chat_msg;
  }

  @Column(name = "c_chat", nullable = false)
  public Integer getC_chat() {
    return this.c_chat;
  }

  public void setC_chat(Integer c_chat) {
    this.c_chat = c_chat;
  }

  @Column(name = "c_chat_msg_type", nullable = false)
  public Integer getC_chat_msg_type() {
    return this.c_chat_msg_type;
  }

  public void setC_chat_msg_type(Integer c_chat_msg_type) {
    this.c_chat_msg_type = c_chat_msg_type;
  }

  @Column(name = "sender_c_tbl", nullable = false)
  public Integer getSender_c_tbl() {
    return this.sender_c_tbl;
  }

  public void setSender_c_tbl(Integer sender_c_tbl) {
    this.sender_c_tbl = sender_c_tbl;
  }

  @Column(name = "sender_rec_id", nullable = false)
  public Long getSender_rec_id() {
    return this.sender_rec_id;
  }

  public void setSender_rec_id(Long sender_rec_id) {
    this.sender_rec_id = sender_rec_id;
  }

  
  @Column(name = "msg_txt", nullable = false)
  public String getMsg_txt() {
    return this.msg_txt;
  }

  public void setMsg_txt(String msg_txt) {
    this.msg_txt = msg_txt;
  }

  @Column(name = "is_delivered", nullable = false)
  public Boolean getIs_delivered() {
    return this.is_delivered;
  }

  public void setIs_delivered(Boolean is_delivered) {
    this.is_delivered = is_delivered;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "deliver_dt", length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getDeliver_dt() {
    return this.deliver_dt;
  }

  public void setDeliver_dt(Date deliver_dt) {
    this.deliver_dt = deliver_dt;
  }

  @Column(name = "is_read", nullable = false)
  public Boolean getIs_read() {
    return this.is_read;
  }

  public void setIs_read(Boolean is_read) {
    this.is_read = is_read;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "read_dt", length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getRead_dt() {
    return this.read_dt;
  }

  public void setRead_dt(Date read_dt) {
    this.read_dt = read_dt;
  }

  @Column(name = "reply_id")
  public Long getReply_id() {
    return this.reply_id;
  }

  public void setReply_id(Long reply_id) {
    this.reply_id = reply_id;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "is_sent", nullable = false)
  public Boolean getIs_sent() {
    return this.is_sent;
  }

  public void setIs_sent(Boolean is_sent) {
    this.is_sent = is_sent;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "sent_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getSent_dt() {
    return this.sent_dt;
  }

  public void setSent_dt(Date sent_dt) {
    this.sent_dt = sent_dt;
  }

  @Transient
  public C_Chat getC_chat_t() {
    if (this.c_chat_t == null && this.getC_chat() != null) {
      this.c_chat_t = C_Chat_Manager.getCI().get_rec(this.getC_chat());
    }
    return this.c_chat_t;
  }

  @Transient
  public C_Chat getC_chat_t_2(Session session_) {
    if (this.c_chat_t == null && this.getC_chat() != null) {
      this.c_chat_t = C_Chat_Manager.getCI().get_rec(session_, this.getC_chat());
    }
    return this.c_chat_t;
  }

  public void setC_chat_t(C_Chat c_chat_t) {
    this.c_chat_t = c_chat_t;
    this.c_chat = (this.c_chat_t != null ? this.c_chat_t.getC_chat() : null);
  }

  @Transient
  public C_Chat_Msg_Type getC_chat_msg_type_t() {
    if (this.c_chat_msg_type_t == null && this.getC_chat_msg_type() != null) {
      this.c_chat_msg_type_t = C_Chat_Msg_Type_Manager.getCI().get_rec(this.getC_chat_msg_type());
    }
    return this.c_chat_msg_type_t;
  }

  @Transient
  public C_Chat_Msg_Type getC_chat_msg_type_t_2(Session session_) {
    if (this.c_chat_msg_type_t == null && this.getC_chat_msg_type() != null) {
      this.c_chat_msg_type_t = C_Chat_Msg_Type_Manager.getCI().get_rec(session_, this.getC_chat_msg_type());
    }
    return this.c_chat_msg_type_t;
  }

  public void setC_chat_msg_type_t(C_Chat_Msg_Type c_chat_msg_type_t) {
    this.c_chat_msg_type_t = c_chat_msg_type_t;
    this.c_chat_msg_type = (this.c_chat_msg_type_t != null ? this.c_chat_msg_type_t.getC_chat_msg_type() : null);
  }

  @Transient
  public C_Tbl getSender_c_tbl_t() {
    if (this.sender_c_tbl_t == null && this.getSender_c_tbl() != null) {
      this.sender_c_tbl_t = C_Tbl_Manager.getCI().get_rec(this.getSender_c_tbl());
    }
    return this.sender_c_tbl_t;
  }

  @Transient
  public C_Tbl getSender_c_tbl_t_2(Session session_) {
    if (this.sender_c_tbl_t == null && this.getSender_c_tbl() != null) {
      this.sender_c_tbl_t = C_Tbl_Manager.getCI().get_rec(session_, this.getSender_c_tbl());
    }
    return this.sender_c_tbl_t;
  }

  public void setSender_c_tbl_t(C_Tbl sender_c_tbl_t) {
    this.sender_c_tbl_t = sender_c_tbl_t;
    this.sender_c_tbl = (this.sender_c_tbl_t != null ? this.sender_c_tbl_t.getC_tbl() : null);
  }

  @Transient
  public C_Chat_Msg getReply_id_t() {
    if (this.reply_id_t == null && this.getReply_id() != null) {
      this.reply_id_t = C_Chat_Msg_Manager.getCI().get_rec(this.getReply_id());
    }
    return this.reply_id_t;
  }

  @Transient
  public C_Chat_Msg getReply_id_t_2(Session session_) {
    if (this.reply_id_t == null && this.getReply_id() != null) {
      this.reply_id_t = C_Chat_Msg_Manager.getCI().get_rec(session_, this.getReply_id());
    }
    return this.reply_id_t;
  }

  public void setReply_id_t(C_Chat_Msg reply_id_t) {
    this.reply_id_t = reply_id_t;
    this.reply_id = (this.reply_id_t != null ? this.reply_id_t.getC_chat_msg() : null);
  }

  @Transient
  public String getIcon_url() {
    if (icon_url == null) {
      if (getIs_read()) {
        icon_url = "wa_read_17x11.png";
      } else if (getIs_delivered()) {
        icon_url = "wa_delivered_17x11.png";
      } else if (getIs_sent()) {
        icon_url = "wa_sent_17x11.png";
      } else {
        icon_url = "";
      }
    }
    return icon_url;
  }

  public void setIcon_url(String icon_url) {
    this.icon_url = icon_url;
  }

  @Transient
  public String getProcessed_msg_txt() {
    if (msg_txt==null)  {
      return "";
    } else {
      return msg_txt.replace("\n", "<br/>");
    }
  }
  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_chat_msg());
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
    final C_Chat_Msg other = (C_Chat_Msg) obj;
    if (!Objects.equals(this.getC_chat_msg(), other.getC_chat_msg())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_chat_msg();
  }

}
