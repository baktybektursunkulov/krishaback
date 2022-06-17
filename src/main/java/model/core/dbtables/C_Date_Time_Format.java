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
@Table(name = "c_date_time_format")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Date_Time_Format extends Abstract_Entity {

  //fields
  private Integer c_date_time_format;
  private String pattern;
  private String example;
  private Boolean is_deleted;

  //transient fields
  public C_Date_Time_Format() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_date_time_format", unique = true, nullable = false)
  public Integer getC_date_time_format() {
    return this.c_date_time_format;
  }

  public void setC_date_time_format(Integer c_date_time_format) {
    this.c_date_time_format = c_date_time_format;
  }

  
  @Column(name = "pattern", nullable = false)
  public String getPattern() {
    return this.pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  
  @Column(name = "example", nullable = false)
  public String getExample() {
    return this.example;
  }

  public void setExample(String example) {
    this.example = example;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_date_time_format());
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
    final C_Date_Time_Format other = (C_Date_Time_Format) obj;
    if (!Objects.equals(this.getC_date_time_format(), other.getC_date_time_format())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_date_time_format();
  }

}
