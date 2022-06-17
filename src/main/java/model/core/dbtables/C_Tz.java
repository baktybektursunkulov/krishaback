package model.core.dbtables;

import beans.LocaleBean;
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
@Table(name = "c_tz")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Tz extends Abstract_Entity {

  //fields
  private Integer c_tz;
  private String name;
  private Integer interval_in_min;
  private Boolean is_deleted;

  //transient fields
  private String name_translation;

  public C_Tz() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_tz", unique = true, nullable = false)
  public Integer getC_tz() {
    return this.c_tz;
  }

  public void setC_tz(Integer c_tz) {
    this.c_tz = c_tz;
  }

  
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "interval_in_min", nullable = false)
  public Integer getInterval_in_min() {
    return this.interval_in_min;
  }

  public void setInterval_in_min(Integer interval_in_min) {
    this.interval_in_min = interval_in_min;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public String getName_translation() throws Exception {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(this.getClass().getSimpleName(), (Integer) getEntity_id(), "name", LocaleBean.getCurrentBean().getLanguageTag(), getName());
    }
    return name_translation;
  }

  public void setName_translation(String name_translation) {
    this.name_translation = name_translation;
  }

  @Transient
  public String getShort_name_translation() throws Exception {
    String res = getName_translation();
    if (res != null && res.length() > 80) {
      res = res.substring(0, 80) + "...";
    }
    return res;
  }

  @Transient
  public String getShortName() {
    String res = "";
    int hour_ = getInterval_in_min() / 60;
    if (hour_ == 0) {
      res = "";
    } else if (hour_ > 0) {
      res = "+";
    } else if (hour_ < 0) {
      res = "-";
    }
    res = res + (String.valueOf(Math.abs(hour_)).length() == 1 ? "0" + Math.abs(hour_) : Math.abs(hour_));
    int minute_ = getInterval_in_min() % 60;
    res = res + ":" + (String.valueOf(minute_).length() == 1 ? "0" + minute_ : minute_);
    return res;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_tz());
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
    final C_Tz other = (C_Tz) obj;
    if (!Objects.equals(this.getC_tz(), other.getC_tz())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_tz();
  }

}
