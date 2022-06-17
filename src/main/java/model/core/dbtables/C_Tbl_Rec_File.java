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
@Table(name = "c_tbl_rec_file")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Tbl_Rec_File extends Abstract_Entity {

  //fields
  private Integer c_tbl_rec_file;
  private Integer c_tbl;
  private Long rec_id;
  private String file_name;
  private Date ins_dt;
  private String user_name;
  private Boolean is_manually_added;
  private Boolean is_deleted;
  private Long c_bin_file_body;

  //transient fields
  private C_Tbl c_tbl_t = null;
  private C_Bin_File_Body c_bin_file_body_t = null;

  public C_Tbl_Rec_File() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_tbl_rec_file", unique = true, nullable = false)
  public Integer getC_tbl_rec_file() {
    return this.c_tbl_rec_file;
  }

  public void setC_tbl_rec_file(Integer c_tbl_rec_file) {
    this.c_tbl_rec_file = c_tbl_rec_file;
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

  
  @Column(name = "file_name", nullable = false)
  public String getFile_name() {
    return this.file_name;
  }

  public void setFile_name(String file_name) {
    this.file_name = file_name;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  
  @Column(name = "user_name", nullable = false)
  public String getUser_name() {
    return this.user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  @Column(name = "is_manually_added", nullable = false)
  public Boolean getIs_manually_added() {
    return this.is_manually_added;
  }

  public void setIs_manually_added(Boolean is_manually_added) {
    this.is_manually_added = is_manually_added;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "c_bin_file_body", nullable = false)
  public Long getC_bin_file_body() {
    return this.c_bin_file_body;
  }

  public void setC_bin_file_body(Long c_bin_file_body) {
    this.c_bin_file_body = c_bin_file_body;
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
  public C_Bin_File_Body getBin_file_body_t() {
    if (this.c_bin_file_body_t == null && this.getC_bin_file_body() != null) {
      this.c_bin_file_body_t = C_Bin_File_Body_Manager.getCI().get_rec(this.getC_bin_file_body());
    }
    return this.c_bin_file_body_t;
  }

  @Transient
  public C_Bin_File_Body getC_bin_file_body_t_2(Session session_) {
    if (this.c_bin_file_body_t == null && this.getC_bin_file_body() != null) {
      this.c_bin_file_body_t = C_Bin_File_Body_Manager.getCI().get_rec(session_, this.getC_bin_file_body());
    }
    return this.c_bin_file_body_t;
  }

  public void setC_bin_file_body_t(C_Bin_File_Body bin_file_body_t) {
    this.c_bin_file_body_t = bin_file_body_t;
    this.c_bin_file_body = (this.c_bin_file_body_t != null ? this.c_bin_file_body_t.getC_bin_file_body() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_rec_file());
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
    final C_Tbl_Rec_File other = (C_Tbl_Rec_File) obj;
    if (!Objects.equals(this.getC_tbl_rec_file(), other.getC_tbl_rec_file())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_rec_file();
  }

}
