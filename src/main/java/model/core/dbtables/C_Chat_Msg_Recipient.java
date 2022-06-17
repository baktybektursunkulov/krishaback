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
@Table(name="c_chat_msg_recipient")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Chat_Msg_Recipient extends Abstract_Entity {

  //fields
  private Long c_chat_msg_recipient;
  private Long c_chat_msg;
  private Integer c_tbl;
  private Long rec_id;
  private Boolean is_read;
  private Date read_dt;
  private Boolean is_delivered;
  private Date deliver_dt;
  private Date ins_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Chat_Msg c_chat_msg_t = null;
  private C_Tbl c_tbl_t = null;



  public C_Chat_Msg_Recipient() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_chat_msg_recipient", unique=true, nullable=false)
  public Long getC_chat_msg_recipient() {
    return this.c_chat_msg_recipient;
  }
  public void setC_chat_msg_recipient(Long c_chat_msg_recipient) {
    this.c_chat_msg_recipient = c_chat_msg_recipient;
  }

  @Column(name="c_chat_msg", nullable=false)
  public Long getC_chat_msg() {
    return this.c_chat_msg;
  }
  public void setC_chat_msg(Long c_chat_msg) {
    this.c_chat_msg = c_chat_msg;
  }

  @Column(name="c_tbl", nullable=false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }
  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
  }

  @Column(name="rec_id", nullable=false)
  public Long getRec_id() {
    return this.rec_id;
  }
  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  @Column(name="is_read", nullable=false)
  public Boolean getIs_read() {
    return this.is_read;
  }
  public void setIs_read(Boolean is_read) {
    this.is_read = is_read;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="read_dt", length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getRead_dt() {
    return this.read_dt;
  }
  public void setRead_dt(Date read_dt) {
    this.read_dt = read_dt;
  }

  @Column(name="is_delivered", nullable=false)
  public Boolean getIs_delivered() {
    return this.is_delivered;
  }
  public void setIs_delivered(Boolean is_delivered) {
    this.is_delivered = is_delivered;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="deliver_dt", length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getDeliver_dt() {
    return this.deliver_dt;
  }
  public void setDeliver_dt(Date deliver_dt) {
    this.deliver_dt = deliver_dt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ins_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }
  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Chat_Msg getC_chat_msg_t() {
    if (this.c_chat_msg_t == null && this.getC_chat_msg() != null) {
      this.c_chat_msg_t = C_Chat_Msg_Manager.getCI().get_rec(this.getC_chat_msg()); 
    }
    return this.c_chat_msg_t;
  }
  @Transient
  public C_Chat_Msg getC_chat_msg_t_2(Session session_) {
    if (this.c_chat_msg_t == null && this.getC_chat_msg() != null) {
      this.c_chat_msg_t = C_Chat_Msg_Manager.getCI().get_rec(session_, this.getC_chat_msg()); 
    }
    return this.c_chat_msg_t;
  }
  public void setC_chat_msg_t(C_Chat_Msg c_chat_msg_t) {
    this.c_chat_msg_t = c_chat_msg_t;
    this.c_chat_msg = (this.c_chat_msg_t != null?this.c_chat_msg_t.getC_chat_msg():null);
  }

  @Transient
  public C_Tbl getC_tbl_t() {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(this.getC_tbl()); 
    }
    return this.c_tbl_t;
  }
  @Transient
  public C_Tbl getC_tbl_t_2(Session session_) {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(session_, this.getC_tbl()); 
    }
    return this.c_tbl_t;
  }
  public void setC_tbl_t(C_Tbl c_tbl_t) {
    this.c_tbl_t = c_tbl_t;
    this.c_tbl = (this.c_tbl_t != null?this.c_tbl_t.getC_tbl():null);
  }









  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_chat_msg_recipient());
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
    final C_Chat_Msg_Recipient other = (C_Chat_Msg_Recipient) obj;
    if (!Objects.equals(this.getC_chat_msg_recipient(), other.getC_chat_msg_recipient())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_chat_msg_recipient();
  }

} 
