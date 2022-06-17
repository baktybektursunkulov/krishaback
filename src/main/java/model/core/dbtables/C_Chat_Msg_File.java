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
@Table(name="c_chat_msg_file")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Chat_Msg_File extends Abstract_Entity {

  //fields
  private Long c_chat_msg_file;
  private Long c_chat_msg;
  private Boolean is_file;
  private Long c_file;
  private Boolean is_img;
  private Long c_img;
  private Date ins_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Chat_Msg c_chat_msg_t = null;
  private C_File c_file_t = null;
  private C_Img c_img_t = null;



  public C_Chat_Msg_File() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_chat_msg_file", unique=true, nullable=false)
  public Long getC_chat_msg_file() {
    return this.c_chat_msg_file;
  }
  public void setC_chat_msg_file(Long c_chat_msg_file) {
    this.c_chat_msg_file = c_chat_msg_file;
  }

  @Column(name="c_chat_msg", nullable=false)
  public Long getC_chat_msg() {
    return this.c_chat_msg;
  }
  public void setC_chat_msg(Long c_chat_msg) {
    this.c_chat_msg = c_chat_msg;
  }

  @Column(name="is_file", nullable=false)
  public Boolean getIs_file() {
    return this.is_file;
  }
  public void setIs_file(Boolean is_file) {
    this.is_file = is_file;
  }

  @Column(name="c_file")
  public Long getC_file() {
    return this.c_file;
  }
  public void setC_file(Long c_file) {
    this.c_file = c_file;
  }

  @Column(name="is_img", nullable=false)
  public Boolean getIs_img() {
    return this.is_img;
  }
  public void setIs_img(Boolean is_img) {
    this.is_img = is_img;
  }

  @Column(name="c_img")
  public Long getC_img() {
    return this.c_img;
  }
  public void setC_img(Long c_img) {
    this.c_img = c_img;
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
  public C_File getC_file_t() {
    if (this.c_file_t == null && this.getC_file() != null) {
      this.c_file_t = C_File_Manager.getCI().get_rec(this.getC_file()); 
    }
    return this.c_file_t;
  }
  @Transient
  public C_File getC_file_t_2(Session session_) {
    if (this.c_file_t == null && this.getC_file() != null) {
      this.c_file_t = C_File_Manager.getCI().get_rec(session_, this.getC_file()); 
    }
    return this.c_file_t;
  }
  public void setC_file_t(C_File c_file_t) {
    this.c_file_t = c_file_t;
    this.c_file = (this.c_file_t != null?this.c_file_t.getC_file():null);
  }


  @Transient
  public C_Img getImg_t() {
    if (this.c_img_t == null && this.getC_img() != null) {
      this.c_img_t = C_Img_Manager.getCI().get_rec(this.getC_img()); 
    }
    return this.c_img_t;
  }
  @Transient
  public C_Img getImg_t_2(Session session_) {
    if (this.c_img_t == null && this.getC_img() != null) {
      this.c_img_t = C_Img_Manager.getCI().get_rec(session_, this.getC_img()); 
    }
    return this.c_img_t;
  }
  public void setImg_t(C_Img img_t) {
    this.c_img_t = img_t;
    this.c_img = (this.c_img_t != null?this.c_img_t.getC_img():null);
  }




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_chat_msg_file());
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
    final C_Chat_Msg_File other = (C_Chat_Msg_File) obj;
    if (!Objects.equals(this.getC_chat_msg_file(), other.getC_chat_msg_file())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_chat_msg_file();
  }

} 
