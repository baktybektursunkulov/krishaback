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
@Table(name="c_translation")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Translation extends Abstract_Entity {

  //fields
  private Integer c_translation;
  private String source_lang;
  private String target_lang;
  private String txt;
  private String txt_format;
  private String translation;
  private Boolean is_deleted;

  //transient fields



  public C_Translation() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_translation", unique=true, nullable=false)
  public Integer getC_translation() {
    return this.c_translation;
  }
  public void setC_translation(Integer c_translation) {
    this.c_translation = c_translation;
  }

  @Type(type="text")
  @Column(name="source_lang", nullable=false)
  public String getSource_lang() {
    return this.source_lang;
  }
  public void setSource_lang(String source_lang) {
    this.source_lang = source_lang;
  }

  @Type(type="text")
  @Column(name="target_lang", nullable=false)
  public String getTarget_lang() {
    return this.target_lang;
  }
  public void setTarget_lang(String target_lang) {
    this.target_lang = target_lang;
  }

  @Type(type="text")
  @Column(name="txt", nullable=false)
  public String getTxt() {
    return this.txt;
  }
  public void setTxt(String txt) {
    this.txt = txt;
  }

  @Type(type="text")
  @Column(name="txt_format", nullable=false)
  public String getTxt_format() {
    return this.txt_format;
  }
  public void setTxt_format(String txt_format) {
    this.txt_format = txt_format;
  }

  @Type(type="text")
  @Column(name="translation", nullable=false)
  public String getTranslation() {
    return this.translation;
  }
  public void setTranslation(String translation) {
    this.translation = translation;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }









  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_translation());
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
    final C_Translation other = (C_Translation) obj;
    if (!Objects.equals(this.getC_translation(), other.getC_translation())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_translation();
  }

} 
