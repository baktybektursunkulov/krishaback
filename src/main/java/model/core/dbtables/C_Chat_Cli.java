package model.core.dbtables;

import gs.common.hibernate_funcs;
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

@Entity
@Table(name = "c_chat_cli")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Chat_Cli extends Abstract_Entity {

  //fields
  private Integer c_chat_cli;
  private Integer c_chat;
  private Integer c_tbl;
  private Long rec_id;
  private Boolean is_admin;
  private Integer unread_msg_cnt;
  private Date ins_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Chat c_chat_t = null;
  private C_Tbl c_tbl_t = null;
  private String name;
  private Long img_id;
  private String img_url;
  private C_Chat_Party_Status c_chat_party_status;

  public C_Chat_Cli() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_chat_cli", unique = true, nullable = false)
  public Integer getC_chat_cli() {
    return this.c_chat_cli;
  }

  public void setC_chat_cli(Integer c_chat_cli) {
    this.c_chat_cli = c_chat_cli;
  }

  @Column(name = "c_chat", nullable = false)
  public Integer getC_chat() {
    return this.c_chat;
  }

  public void setC_chat(Integer c_chat) {
    this.c_chat = c_chat;
  }

  @Column(name = "c_tbl", nullable = false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }

  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
  }

  @Column(name = "rec_id", nullable = false)
  public Long getRec_id() {
    return this.rec_id;
  }

  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  @Column(name = "is_admin", nullable = false)
  public Boolean getIs_admin() {
    return this.is_admin;
  }

  public void setIs_admin(Boolean is_admin) {
    this.is_admin = is_admin;
  }

  @Column(name = "unread_msg_cnt", nullable = false)
  public Integer getUnread_msg_cnt() {
    return this.unread_msg_cnt;
  }

  public void setUnread_msg_cnt(Integer unread_msg_cnt) {
    this.unread_msg_cnt = unread_msg_cnt;
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
    this.c_tbl = (this.c_tbl_t != null ? this.c_tbl_t.getC_tbl() : null);
  }

  @Transient
  public String getName() {
    if (name == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        name = getName_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Transient
  public String getName_2(Session session_) {
    if (name == null) {
      name = C_Chat_Sql_Manager.getCI().get_name(session_, getC_tbl(), getRec_id());
    }
    return name;
  }

  @Transient
  public Long getImg_id() {
    if (img_id == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        img_id = getImg_id_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return img_id;
  }

  public void setImg_id(Long img_id) {
    this.img_id = img_id;
  }

  @Transient
  public Long getImg_id_2(Session session_) {
    if (img_id == null) {
      img_id = C_Chat_Sql_Manager.getCI().get_img_id(session_, getC_tbl(), getRec_id());
    }
    return img_id;
  }

  @Transient
  public String getImg_url() {
    return img_url;
  }

  public void setImg_url(String img_url) {
    this.img_url = img_url;
  }

  @Transient
  public String getImg_url_2(Session session_) {
    if (img_url == null) {
      Long img_id_ = getImg_id_2(session_);
      if (img_id_ == null) {
        img_url = C_Img_Manager.getCI().get_empty_img_url_by_min_2(session_, 46, 46);
      } else {
        img_url = C_Img_Manager.getCI().get_img_url_by_min_2(session_, img_id_, 46, 46);
      }
    }
    return img_url;
  }

  @Transient
  public C_Chat_Party_Status getC_chat_party_status() {
    if (c_chat_party_status == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        c_chat_party_status = getC_chat_party_status_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return c_chat_party_status;
  }

  public void setC_chat_party_status(C_Chat_Party_Status c_chat_party_status) {
    this.c_chat_party_status = c_chat_party_status;
  }

  @Transient
  public C_Chat_Party_Status getC_chat_party_status_2(Session session_) {
    if (c_chat_party_status == null) {
      c_chat_party_status = C_Chat_Party_Status_Manager.getCI().get_or_ins_row(session_, c_tbl, rec_id);
    }
    return c_chat_party_status;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_chat_cli());
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
    final C_Chat_Cli other = (C_Chat_Cli) obj;
    if (!Objects.equals(this.getC_chat_cli(), other.getC_chat_cli())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_chat_cli();
  }

}
