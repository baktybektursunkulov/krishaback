/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name="c_tbl_rec_corr_by_name")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Tbl_Rec_Corr_By_Name extends Abstract_Entity {

  //fields
  private Integer c_tbl_rec_corr_by_name;
  private Integer c_tbl;
  private String name;
  private Long rec_id;
  private Boolean is_deleted;

  //transient fields
    private C_Tbl c_tbl_t = null;



  public C_Tbl_Rec_Corr_By_Name() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_tbl_rec_corr_by_name", unique=true, nullable=false)
  public Integer getC_tbl_rec_corr_by_name() {
    return this.c_tbl_rec_corr_by_name;
  }
  public void setC_tbl_rec_corr_by_name(Integer c_tbl_rec_corr_by_name) {
    this.c_tbl_rec_corr_by_name = c_tbl_rec_corr_by_name;
  }

  @Column(name="c_tbl", nullable=false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }
  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
  }

  @Type(type="text")
  @Column(name="name", nullable=false)
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Column(name="rec_id", nullable=false)
  public Long getRec_id() {
    return this.rec_id;
  }
  public void setRec_id(Long rec_id) {
    this.rec_id = rec_id;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
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





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_rec_corr_by_name());
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
    final C_Tbl_Rec_Corr_By_Name other = (C_Tbl_Rec_Corr_By_Name) obj;
    if (!Objects.equals(this.getC_tbl_rec_corr_by_name(), other.getC_tbl_rec_corr_by_name())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_rec_corr_by_name();
  }

} 
