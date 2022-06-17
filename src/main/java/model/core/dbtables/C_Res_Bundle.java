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
@Table(name = "c_res_bundle")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Res_Bundle extends Abstract_Entity {

  //fields
  private Integer c_res_bundle;
  private Integer c_res_bundle_base;
  private Integer c_lang;
  private String key;
  private String val;
  private Integer source_text_hash_code;
  private Boolean is_deleted;

  //transient fields
  private C_Res_Bundle_Base c_res_bundle_base_t = null;
  private C_Lang c_lang_t = null;

  public C_Res_Bundle() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_res_bundle", unique = true, nullable = false)
  public Integer getC_res_bundle() {
    return this.c_res_bundle;
  }

  public void setC_res_bundle(Integer c_res_bundle) {
    this.c_res_bundle = c_res_bundle;
  }

  @Column(name = "c_res_bundle_base", nullable = false)
  public Integer getC_res_bundle_base() {
    return this.c_res_bundle_base;
  }

  public void setC_res_bundle_base(Integer c_res_bundle_base) {
    this.c_res_bundle_base = c_res_bundle_base;
  }

  @Column(name = "c_lang", nullable = false)
  public Integer getC_lang() {
    return this.c_lang;
  }

  public void setC_lang(Integer c_lang) {
    this.c_lang = c_lang;
  }

  
  @Column(name = "key", nullable = false)
  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  
  @Column(name = "val", nullable = false)
  public String getVal() {
    return this.val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  @Column(name = "source_text_hash_code")
  public Integer getSource_text_hash_code() {
    return this.source_text_hash_code;
  }

  public void setSource_text_hash_code(Integer source_text_hash_code) {
    this.source_text_hash_code = source_text_hash_code;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Res_Bundle_Base getC_res_bundle_base_t() {
    if (this.c_res_bundle_base_t == null && this.getC_res_bundle_base() != null) {
      this.c_res_bundle_base_t = C_Res_Bundle_Base_Manager.getCI().get_rec(this.getC_res_bundle_base());
    }
    return this.c_res_bundle_base_t;
  }

  @Transient
  public C_Res_Bundle_Base getC_res_bundle_base_t_2(Session session_) {
    if (this.c_res_bundle_base_t == null && this.getC_res_bundle_base() != null) {
      this.c_res_bundle_base_t = C_Res_Bundle_Base_Manager.getCI().get_rec(session_, this.getC_res_bundle_base());
    }
    return this.c_res_bundle_base_t;
  }

  public void setC_res_bundle_base_t(C_Res_Bundle_Base c_res_bundle_base_t) {
    this.c_res_bundle_base_t = c_res_bundle_base_t;
    this.c_res_bundle_base = (this.c_res_bundle_base_t != null ? this.c_res_bundle_base_t.getC_res_bundle_base() : null);
  }

  @Transient
  public C_Lang getC_lang_t() {
    if (this.c_lang_t == null && this.getC_lang() != null) {
      this.c_lang_t = C_Lang_Manager.getCI().get_rec(this.getC_lang());
    }
    return this.c_lang_t;
  }

  @Transient
  public C_Lang getC_lang_t_2(Session session_) {
    if (this.c_lang_t == null && this.getC_lang() != null) {
      this.c_lang_t = C_Lang_Manager.getCI().get_rec(session_, this.getC_lang());
    }
    return this.c_lang_t;
  }

  public void setC_lang_t(C_Lang c_lang_t) {
    this.c_lang_t = c_lang_t;
    this.c_lang = (this.c_lang_t != null ? this.c_lang_t.getC_lang() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_res_bundle());
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
    final C_Res_Bundle other = (C_Res_Bundle) obj;
    if (!Objects.equals(this.getC_res_bundle(), other.getC_res_bundle())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_res_bundle();
  }

}
