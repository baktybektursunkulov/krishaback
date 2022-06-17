package model.core.dbtables;

import beans.LocaleBean;
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
@Table(name = "c_tbl_rec_contact_type")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Tbl_Rec_Contact_Type extends Abstract_Entity {

  //fields
  private Integer c_tbl_rec_contact_type;
  private String code;
  private String name;
  private Boolean is_deleted;

  //transient fields
  private String name_translation;

  public C_Tbl_Rec_Contact_Type() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_tbl_rec_contact_type", unique = true, nullable = false)
  public Integer getC_tbl_rec_contact_type() {
    return this.c_tbl_rec_contact_type;
  }

  public void setC_tbl_rec_contact_type(Integer c_tbl_rec_contact_type) {
    this.c_tbl_rec_contact_type = c_tbl_rec_contact_type;
  }

  
  @Column(name = "code", nullable = false)
  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public String getName_translation() {
    if (name_translation == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        name_translation = getName_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return name_translation;
  }

  public String getName_translation_2(Session session_) {
    return getName_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
  }

  public String getName_translation_3(Session session_, String lang_) {
    if (name_translation == null) {
      if (lang_.equals("ru")) {
        name_translation = getName();
      } else {
        name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "name", lang_, getName());
      }
    }
    return name_translation;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tbl_rec_contact_type());
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
    final C_Tbl_Rec_Contact_Type other = (C_Tbl_Rec_Contact_Type) obj;
    if (!Objects.equals(this.getC_tbl_rec_contact_type(), other.getC_tbl_rec_contact_type())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tbl_rec_contact_type();
  }

}
