package model.core.dbtables;

import gs.common.Consts;
import gs.common.date_time_funcs;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
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
import java.util.Calendar;
import others.CustomLogger;
import others.core_chat_funcs;

@Entity
@Table(name = "c_chat")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Chat extends Abstract_Entity {

  //fields
  private Integer c_chat;
  private Integer creator_c_tbl;
  private Long creator_rec_id;
  private Boolean is_group_chat;
  private String name_for_group_chat;
  private Long c_img;
  private Date ins_dt;
  private Boolean is_deleted;
  private Long last_c_chat_msg;

  //transient fields
  private C_Tbl creator_c_tbl_t = null;
  private C_Img img_t = null;
  private C_Chat_Msg last_c_chat_msg_t = null;
  private C_Chat_Cli initiator_chat_cli;
  private C_Chat_Cli opposite_chat_cli;
  private String last_msg_dt_str;

  public C_Chat() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_chat", unique = true, nullable = false)
  public Integer getC_chat() {
    return this.c_chat;
  }

  public void setC_chat(Integer c_chat) {
    this.c_chat = c_chat;
  }

  @Column(name = "creator_c_tbl", nullable = false)
  public Integer getCreator_c_tbl() {
    return this.creator_c_tbl;
  }

  public void setCreator_c_tbl(Integer creator_c_tbl) {
    this.creator_c_tbl = creator_c_tbl;
  }

  @Column(name = "creator_rec_id", nullable = false)
  public Long getCreator_rec_id() {
    return this.creator_rec_id;
  }

  public void setCreator_rec_id(Long creator_rec_id) {
    this.creator_rec_id = creator_rec_id;
  }

  @Column(name = "is_group_chat", nullable = false)
  public Boolean getIs_group_chat() {
    return this.is_group_chat;
  }

  public void setIs_group_chat(Boolean is_group_chat) {
    this.is_group_chat = is_group_chat;
  }

  
  @Column(name = "name_for_group_chat")
  public String getName_for_group_chat() {
    return this.name_for_group_chat;
  }

  public void setName_for_group_chat(String name_for_group_chat) {
    this.name_for_group_chat = name_for_group_chat;
  }

  @Column(name = "c_img")
  public Long getC_img() {
    return this.c_img;
  }

  public void setC_img(Long img) {
    this.c_img = img;
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

  @Column(name = "last_c_chat_msg")
  public Long getLast_c_chat_msg() {
    return this.last_c_chat_msg;
  }

  public void setLast_c_chat_msg(Long last_c_chat_msg) {
    this.last_c_chat_msg = last_c_chat_msg;
  }

  @Transient
  public C_Tbl getCreator_c_tbl_t() {
    if (this.creator_c_tbl_t == null && this.getCreator_c_tbl() != null) {
      this.creator_c_tbl_t = C_Tbl_Manager.getCI().get_rec(this.getCreator_c_tbl());
    }
    return this.creator_c_tbl_t;
  }

  @Transient
  public C_Tbl getCreator_c_tbl_t_2(Session session_) {
    if (this.creator_c_tbl_t == null && this.getCreator_c_tbl() != null) {
      this.creator_c_tbl_t = C_Tbl_Manager.getCI().get_rec(session_, this.getCreator_c_tbl());
    }
    return this.creator_c_tbl_t;
  }

  public void setCreator_c_tbl_t(C_Tbl creator_c_tbl_t) {
    this.creator_c_tbl_t = creator_c_tbl_t;
    this.creator_c_tbl = (this.creator_c_tbl_t != null ? this.creator_c_tbl_t.getC_tbl() : null);
  }

  @Transient
  public C_Img getImg_t() {
    if (this.img_t == null && this.getC_img() != null) {
      this.img_t = C_Img_Manager.getCI().get_rec(this.getC_img());
    }
    return this.img_t;
  }

  @Transient
  public C_Img getImg_t_2(Session session_) {
    if (this.img_t == null && this.getC_img() != null) {
      this.img_t = C_Img_Manager.getCI().get_rec(session_, this.getC_img());
    }
    return this.img_t;
  }

  public void setImg_t(C_Img img_t) {
    this.img_t = img_t;
    this.c_img = (this.img_t != null ? this.img_t.getC_img() : null);
  }

  @Transient
  public C_Chat_Msg getLast_c_chat_msg_t() {
    if (this.last_c_chat_msg_t == null && this.getLast_c_chat_msg() != null) {
      this.last_c_chat_msg_t = C_Chat_Msg_Manager.getCI().get_rec(this.getLast_c_chat_msg());
    }
    return this.last_c_chat_msg_t;
  }

  @Transient
  public C_Chat_Msg getLast_c_chat_msg_t_2(Session session_) {
    if (this.last_c_chat_msg_t == null && this.getLast_c_chat_msg() != null) {
      this.last_c_chat_msg_t = C_Chat_Msg_Manager.getCI().get_rec(session_, this.getLast_c_chat_msg());
    }
    return this.last_c_chat_msg_t;
  }

  public void setLast_c_chat_msg_t(C_Chat_Msg last_c_chat_msg_t) {
    this.last_c_chat_msg_t = last_c_chat_msg_t;
    this.last_c_chat_msg = (this.last_c_chat_msg_t != null ? this.last_c_chat_msg_t.getC_chat_msg() : null);
  }
  
  public void setLast_c_chat_msg_t_2(C_Chat_Msg last_c_chat_msg_t) {
    this.last_c_chat_msg_t = last_c_chat_msg_t;
  }

  @Transient
  public C_Chat_Cli getInitiator_chat_cli() {
    return initiator_chat_cli;
  }

  public void setInitiator_chat_cli(C_Chat_Cli initiator_chat_cli) {
    this.initiator_chat_cli = initiator_chat_cli;
  }

  public C_Chat_Cli getInitiator_chat_cli_2(Session session_, Integer initiator_c_tbl_id_, Long initiator_rec_id_) {
    if (initiator_chat_cli == null) {
      initiator_chat_cli = C_Chat_Cli_Manager.getCI().get_initiator_row_for_indiv_chat(session_, getC_chat(), initiator_c_tbl_id_, initiator_rec_id_);
    }
    return initiator_chat_cli;
  }

  @Transient
  public C_Chat_Cli getOpposite_chat_cli() {
    return opposite_chat_cli;
  }

  public void setOpposite_chat_cli(C_Chat_Cli opposite_chat_cli) {
    this.opposite_chat_cli = opposite_chat_cli;
  }

  public C_Chat_Cli getOpposite_chat_cli_2(Session session_, Integer initiator_c_tbl_id_, Long initiator_rec_id_) {
    if (opposite_chat_cli == null) {
      opposite_chat_cli = C_Chat_Cli_Manager.getCI().get_opposite_row_for_indiv_chat(session_, getC_chat(), initiator_c_tbl_id_, initiator_rec_id_);
    }
    return opposite_chat_cli;
  }

  @Transient
  public String getLast_msg_dt_str() {
    if (last_msg_dt_str == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        last_msg_dt_str = getLast_msg_dt_str_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return last_msg_dt_str;
  }

  public void setLast_msg_dt_str(String last_msg_dt_str) {
    this.last_msg_dt_str = last_msg_dt_str;
  }

  @Transient
  public String getLast_msg_dt_str_2(Session session_) {
    if (last_msg_dt_str == null) {
      if (getLast_c_chat_msg_t_2(session_) == null) {
        last_msg_dt_str = "";
      } else {
        last_msg_dt_str = core_chat_funcs.getCI().get_chat_dt_str(getLast_c_chat_msg_t_2(session_).getSent_dt());
      }
    }
    return last_msg_dt_str;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_chat());
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
    final C_Chat other = (C_Chat) obj;
    if (!Objects.equals(this.getC_chat(), other.getC_chat())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_chat();
  }

}
