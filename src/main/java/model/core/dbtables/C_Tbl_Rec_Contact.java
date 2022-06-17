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
@Table(name = "c_tbl_rec_contact")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Tbl_Rec_Contact extends Abstract_Entity {

  //fields
  private Integer c_tbl_rec_contact;
  private Integer c_tbl;
  private Long rec_id;
  private Integer c_tbl_rec_contact_type;
  private String val;
  private Boolean is_deleted;

  //transient fields
  private C_Tbl c_tbl_t = null;
  private C_Tbl_Rec_Contact_Type c_tbl_rec_contact_type_t = null;

  public C_Tbl_Rec_Contact() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_tbl_rec_contact", unique = true, nullable = false)
  public Integer getC_tbl_rec_contact() {
    return this.c_tbl_rec_contact;
  }

  public void setC_tbl_rec_contact(Integer c_tbl_rec_contact) {
    this.c_tbl_rec_contact = c_tbl_rec_contact;
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

  @Column(name = "c_tbl_rec_contact_type", nullable = false)
  public Integer getC_tbl_rec_contact_type() {
    return this.c_tbl_rec_contact_type;
  }

  public void setC_tbl_rec_contact_type(Integer c_tbl_rec_contact_type) {
    this.c_tbl_rec_contact_type = c_tbl_rec_contact_type;
  }

  
  @Column(name = "val", nullable = false)
  public String getVal() {
    return this.val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  @Column(name = "is_deleted", nullable = false)
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

  @Transient
  public C_Tbl_Rec_Contact_Type getC_tbl_rec_contact_type_t() {
    if (this.c_tbl_rec_contact_type_t == null && this.getC_tbl_rec_contact_type() != null) {
      this.c_tbl_rec_contact_type_t = C_Tbl_Rec_Contact_Type_Manager.getCI().get_rec(this.getC_tbl_rec_contact_type());
    }
    return this.c_tbl_rec_contact_type_t;
  }

  @Transient
  public C_Tbl_Rec_Contact_Type getC_tbl_rec_contact_type_t_2(Session session_) {
    if (this.c_tbl_rec_contact_type_t == null && this.getC_tbl_rec_contact_type() != null) {
      this.c_tbl_rec_contact_type_t = C_Tbl_Rec_Contact_Type_Manager.getCI().get_rec(session_, this.getC_tbl_rec_contact_type());
    }
    return this.c_tbl_rec_contact_type_t;
  }

  public void setC_tbl_rec_contact_type_t(C_Tbl_Rec_Contact_Type c_tbl_rec_contact_type_t) {
    this.c_tbl_rec_contact_type_t = c_tbl_rec_contact_type_t;
    this.c_tbl_rec_contact_type = (this.c_tbl_rec_contact_type_t != null ? this.c_tbl_rec_contact_type_t.getC_tbl_rec_contact_type() : null);
  }

  @Transient
  public String getVal_for_whatsapp() {
    String res = val;
    if (res == null) {
      return null;
    }
    res = res.replace(" ", "");
    res = res.replace("(", "");
    res = res.replace(")", "");
    res = res.replace("-", "");
    res = res.replace("+", "");
    while (res.startsWith("0")) {
      res = res.substring(1);
    }    
    return res;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_rec_contact());
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
    final C_Tbl_Rec_Contact other = (C_Tbl_Rec_Contact) obj;
    if (!Objects.equals(this.getC_tbl_rec_contact(), other.getC_tbl_rec_contact())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_rec_contact();
  }

}
