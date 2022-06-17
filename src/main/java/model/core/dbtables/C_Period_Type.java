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
@Table(name = "c_period_type")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Period_Type extends Abstract_Entity {

  //fields
  private Integer c_period_type;
  private String code;
  private String name;
  private Boolean is_active;
  private String name_in_genitive;
  private Integer order_num;
  private Boolean is_deleted;

  //transient fields
  private String name_translation;
  private String name_in_genitive_translation;

  public C_Period_Type() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_period_type", unique = true, nullable = false)
  public Integer getC_period_type() {
    return this.c_period_type;
  }

  public void setC_period_type(Integer c_period_type) {
    this.c_period_type = c_period_type;
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

  @Column(name = "is_active", nullable = false)
  public Boolean getIs_active() {
    return this.is_active;
  }

  public void setIs_active(Boolean is_active) {
    this.is_active = is_active;
  }

  
  @Column(name = "name_in_genitive", nullable = false)
  public String getName_in_genitive() {
    return this.name_in_genitive;
  }

  public void setName_in_genitive(String name_in_genitive) {
    this.name_in_genitive = name_in_genitive;
  }

  @Column(name = "order_num", nullable = false)
  public Integer getOrder_num() {
    return this.order_num;
  }

  public void setOrder_num(Integer order_num) {
    this.order_num = order_num;
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

  @Transient
  public String getName_in_genitive_translation() {
    if (name_in_genitive_translation == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        name_in_genitive_translation = getName_in_genitive_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return name_in_genitive_translation;
  }

  public String getName_in_genitive_translation_2(Session session_) {
    return getName_in_genitive_translation_3(session_, LocaleBean.getCurrentBean().getLanguageTag());
  }

  public String getName_in_genitive_translation_3(Session session_, String lang_) {
    if (name_in_genitive_translation == null) {
      if (lang_.equals("ru")) {
        name_in_genitive_translation = getName_in_genitive();
      } else {
        name_in_genitive_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "name_in_genitive", lang_, getName_in_genitive());
      }
    }
    return name_in_genitive_translation;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_period_type());
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
    final C_Period_Type other = (C_Period_Type) obj;
    if (!Objects.equals(this.getC_period_type(), other.getC_period_type())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_period_type();
  }

}
