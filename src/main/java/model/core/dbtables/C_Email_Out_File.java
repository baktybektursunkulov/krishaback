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
@Table(name = "c_email_out_file")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Email_Out_File extends Abstract_Entity {

  //fields
  private Integer c_email_out_file;
  private Integer c_email_out;
  private String content_type;
  private String file_name;
  private Long c_bin_file_body;
  private Boolean is_deleted;

  //transient fields
  private C_Email_Out c_email_out_t = null;
  private C_Bin_File_Body c_bin_file_body_t = null;

  public C_Email_Out_File() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_email_out_file", unique = true, nullable = false)
  public Integer getC_email_out_file() {
    return this.c_email_out_file;
  }

  public void setC_email_out_file(Integer c_email_out_file) {
    this.c_email_out_file = c_email_out_file;
  }

  @Column(name = "c_email_out", nullable = false)
  public Integer getC_email_out() {
    return this.c_email_out;
  }

  public void setC_email_out(Integer c_email_out) {
    this.c_email_out = c_email_out;
  }

  
  @Column(name = "content_type", nullable = false)
  public String getContent_type() {
    return this.content_type;
  }

  public void setContent_type(String content_type) {
    this.content_type = content_type;
  }

  
  @Column(name = "file_name", nullable = false)
  public String getFile_name() {
    return this.file_name;
  }

  public void setFile_name(String file_name) {
    this.file_name = file_name;
  }

  @Column(name = "c_bin_file_body", nullable = false)
  public Long getC_bin_file_body() {
    return this.c_bin_file_body;
  }

  public void setC_bin_file_body(Long c_bin_file_body) {
    this.c_bin_file_body = c_bin_file_body;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Email_Out getC_email_out_t() {
    if (this.c_email_out_t == null && this.getC_email_out() != null) {
      this.c_email_out_t = C_Email_Out_Manager.getCI().get_rec(this.getC_email_out());
    }
    return this.c_email_out_t;
  }

  @Transient
  public C_Email_Out getC_email_out_t_2(Session session_) {
    if (this.c_email_out_t == null && this.getC_email_out() != null) {
      this.c_email_out_t = C_Email_Out_Manager.getCI().get_rec(session_, this.getC_email_out());
    }
    return this.c_email_out_t;
  }

  public void setC_email_out_t(C_Email_Out c_email_out_t) {
    this.c_email_out_t = c_email_out_t;
    this.c_email_out = (this.c_email_out_t != null ? this.c_email_out_t.getC_email_out() : null);
  }

  @Transient
  public C_Bin_File_Body getBin_file_body_t() {
    if (this.c_bin_file_body_t == null && this.getC_bin_file_body() != null) {
      this.c_bin_file_body_t = C_Bin_File_Body_Manager.getCI().get_rec(this.getC_bin_file_body());
    }
    return this.c_bin_file_body_t;
  }

  @Transient
  public C_Bin_File_Body getBin_file_body_t_2(Session session_) {
    if (this.c_bin_file_body_t == null && this.getC_bin_file_body() != null) {
      this.c_bin_file_body_t = C_Bin_File_Body_Manager.getCI().get_rec(session_, this.getC_bin_file_body());
    }
    return this.c_bin_file_body_t;
  }

  public void setBin_file_body_t(C_Bin_File_Body bin_file_body_t) {
    this.c_bin_file_body_t = bin_file_body_t;
    this.c_bin_file_body = (this.c_bin_file_body_t != null ? this.c_bin_file_body_t.getC_bin_file_body() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_email_out_file());
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
    final C_Email_Out_File other = (C_Email_Out_File) obj;
    if (!Objects.equals(this.getC_email_out_file(), other.getC_email_out_file())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_email_out_file();
  }

}
