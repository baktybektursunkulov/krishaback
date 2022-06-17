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
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(name = "c_system_version")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_System_Version extends Abstract_Entity {

  //fields
  private Integer c_system_version;
  private Integer c_proj;
  private Integer major_version;
  private Integer minor_version;
  private String changes_text;
  private Boolean is_published;
  private Date change_date;
  private Boolean is_sent_to_subscribed_users;
  private String cus_fields;
  private Boolean is_deleted;
  
  //transient fields
  private C_Proj c_proj_t = null;
  private String changes_text_translation; 

  public C_System_Version() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_system_version", unique = true, nullable = false)
  public Integer getC_system_version() {
    return this.c_system_version;
  }

  public void setC_system_version(Integer c_system_version) {
    this.c_system_version = c_system_version;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  @Column(name = "major_version", nullable = false)
  public Integer getMajor_version() {
    return this.major_version;
  }

  public void setMajor_version(Integer major_version) {
    this.major_version = major_version;
  }

  @Column(name = "minor_version", nullable = false)
  public Integer getMinor_version() {
    return this.minor_version;
  }

  public void setMinor_version(Integer minor_version) {
    this.minor_version = minor_version;
  }

  
  @Column(name = "changes_text", nullable = false)
  public String getChanges_text() {
    return this.changes_text;
  }

  public void setChanges_text(String changes_text) {
    this.changes_text = changes_text;
  }

  @Column(name = "is_published", nullable = false)
  public Boolean getIs_published() {
    return this.is_published;
  }

  public void setIs_published(Boolean is_published) {
    this.is_published = is_published;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "change_date", nullable = false, length = 10, columnDefinition = "DATE")
  public Date getChange_date() {
    return this.change_date;
  }

  public void setChange_date(Date change_date) {
    this.change_date = change_date;
  }

  @Column(name = "is_sent_to_subscribed_users", nullable = false)
  public Boolean getIs_sent_to_subscribed_users() {
    return this.is_sent_to_subscribed_users;
  }

  public void setIs_sent_to_subscribed_users(Boolean is_sent_to_subscribed_users) {
    this.is_sent_to_subscribed_users = is_sent_to_subscribed_users;
  }

  @Column(name = "cus_fields")
  public String getCus_fields() {
    return this.cus_fields;
  }

  public void setCus_fields(String cus_fields) {
    this.cus_fields = cus_fields;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }
  
  @Transient
  public C_Proj getC_proj_t() {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(this.getC_proj());
    }
    return this.c_proj_t;
  }

  @Transient
  public C_Proj getC_proj_t_2(Session session_) {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(session_, this.getC_proj());
    }
    return this.c_proj_t;
  }

  public void setC_proj_t(C_Proj c_proj_t) {
    this.c_proj_t = c_proj_t;
    this.c_proj = (this.c_proj_t != null ? this.c_proj_t.getC_proj() : null);
  }

  @Transient
  public String getVersion() {
    return getMajor_version() + "." + (getMinor_version() <= 9 ? "0" : "") + getMinor_version();
  }

  @Transient
  public String getChanges_text_translation() throws Exception {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      changes_text_translation = getChanges_text();
    } else {
      changes_text_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(this.getClass().getSimpleName(), getC_system_version().longValue(), "changes_text", LocaleBean.getCurrentBean().getLanguageTag(), getChanges_text());
    }
    changes_text_translation = C_System_Version_Manager.getCI().getFilledText(changes_text_translation);
    return changes_text_translation;
  }

  public void setChanges_text_translation(String changes_text_translation) {
    this.changes_text_translation = changes_text_translation;
  }

  @Transient
  public String getChanges_text_translation_2(String lang_) throws Exception {
    if (lang_.equals("ru")) {
      changes_text_translation = getChanges_text();
    } else {
      changes_text_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(this.getClass().getSimpleName(), getC_system_version().longValue(), "changes_text", lang_, getChanges_text());
    }
    return changes_text_translation;
  }

  @Transient
  public String getChanges_text_translation_3(Session session_, String lang_, C_Site c_site_) throws Exception {
    if (lang_.equals("ru")) {
      changes_text_translation = getChanges_text();
    } else {
      changes_text_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), getC_system_version().longValue(), "changes_text", lang_, getChanges_text());
    }
    changes_text_translation = C_System_Version_Manager.getCI().getFilledText(c_site_, null, changes_text_translation);
    return changes_text_translation;
  } 
  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_system_version());
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
    final C_System_Version other = (C_System_Version) obj;
    if (!Objects.equals(this.getC_system_version(), other.getC_system_version())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_system_version();
  }

}
