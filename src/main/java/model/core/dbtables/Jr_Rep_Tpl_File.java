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
@Table(name = "jr_rep_tpl_file")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Tpl_File extends Abstract_Entity {

  //fields
  private Integer jr_rep_tpl_file;
  private Integer jr_rep_tpl;
  private Date change_dt;
  private String file_name;
  private Long c_bin_file_body;

  //transient fields
  private Jr_Rep_Tpl jr_rep_tpl_t = null;
  private C_Bin_File_Body c_bin_file_body_t = null;

  public Jr_Rep_Tpl_File() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "jr_rep_tpl_file", unique = true, nullable = false)
  public Integer getJr_rep_tpl_file() {
    return this.jr_rep_tpl_file;
  }

  public void setJr_rep_tpl_file(Integer jr_rep_tpl_file) {
    this.jr_rep_tpl_file = jr_rep_tpl_file;
  }

  @Column(name = "jr_rep_tpl", nullable = false)
  public Integer getJr_rep_tpl() {
    return this.jr_rep_tpl;
  }

  public void setJr_rep_tpl(Integer jr_rep_tpl) {
    this.jr_rep_tpl = jr_rep_tpl;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "change_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getChange_dt() {
    return this.change_dt;
  }

  public void setChange_dt(Date change_dt) {
    this.change_dt = change_dt;
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

  @Transient
  public Jr_Rep_Tpl getJr_rep_tpl_t() {
    if (this.jr_rep_tpl_t == null && this.getJr_rep_tpl() != null) {
      this.jr_rep_tpl_t = Jr_Rep_Tpl_Manager.getCI().get_rec(this.getJr_rep_tpl());
    }
    return this.jr_rep_tpl_t;
  }

  @Transient
  public Jr_Rep_Tpl getJr_rep_tpl_t_2(Session session_) {
    if (this.jr_rep_tpl_t == null && this.getJr_rep_tpl() != null) {
      this.jr_rep_tpl_t = Jr_Rep_Tpl_Manager.getCI().get_rec(session_, this.getJr_rep_tpl());
    }
    return this.jr_rep_tpl_t;
  }

  public void setJr_rep_tpl_t(Jr_Rep_Tpl jr_rep_tpl_t) {
    this.jr_rep_tpl_t = jr_rep_tpl_t;
    this.jr_rep_tpl = (this.jr_rep_tpl_t != null ? this.jr_rep_tpl_t.getJr_rep_tpl() : null);
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

  public void setBin_file_body_t(C_Bin_File_Body c_bin_file_body_t) {
    this.c_bin_file_body_t = c_bin_file_body_t;
    this.c_bin_file_body = (this.c_bin_file_body_t != null ? this.c_bin_file_body_t.getC_bin_file_body() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_tpl_file());
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
    final Jr_Rep_Tpl_File other = (Jr_Rep_Tpl_File) obj;
    if (!Objects.equals(this.getJr_rep_tpl_file(), other.getJr_rep_tpl_file())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_tpl_file();
  }

}
