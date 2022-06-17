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
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Session;

@Entity
@Table(name = "c_site")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Site extends Abstract_Entity {

  //fields
  private Integer c_site;
  private Long c_usr;
  private String domain;
  private String title;
  private String copyright_text;
  private Integer c_theme;
  private String copyright_url;
  private String javascript_text;
  private String css_text;
  private Boolean use_https;
  private String custom_fields;
  private Boolean is_deleted;
  private Integer c_proj;
  private String terms_of_use_content;
  private String footer_content;
  private Boolean is_show_terms_of_use;
  private Integer c_country;

  //transient fields
  private C_Usr c_usr_t = null;
  private C_Theme c_theme_t = null;
  private C_Proj c_proj_t = null;
  private String footer_content_translation;
  private String terms_of_use_content_translation;
  private JSONObject custom_fields_json_object;
  private C_Country c_country_t = null;

  public C_Site() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_site", unique = true, nullable = false)
  public Integer getC_site() {
    return this.c_site;
  }

  public void setC_site(Integer c_site) {
    this.c_site = c_site;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  
  @Column(name = "domain", nullable = false)
  public String getDomain() {
    return this.domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  
  @Column(name = "title", nullable = false)
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  
  @Column(name = "copyright_text", nullable = false)
  public String getCopyright_text() {
    return this.copyright_text;
  }

  public void setCopyright_text(String copyright_text) {
    this.copyright_text = copyright_text;
  }

  @Column(name = "c_theme", nullable = false)
  public Integer getC_theme() {
    return this.c_theme;
  }

  public void setC_theme(Integer c_theme) {
    this.c_theme = c_theme;
  }

  
  @Column(name = "copyright_url")
  public String getCopyright_url() {
    return this.copyright_url;
  }

  public void setCopyright_url(String copyright_url) {
    this.copyright_url = copyright_url;
  }

  
  @Column(name = "javascript_text")
  public String getJavascript_text() {
    return this.javascript_text;
  }

  public void setJavascript_text(String javascript_text) {
    this.javascript_text = javascript_text;
  }

  
  @Column(name = "css_text")
  public String getCss_text() {
    return this.css_text;
  }

  public void setCss_text(String css_text) {
    this.css_text = css_text;
  }

  @Column(name = "use_https", nullable = false)
  public Boolean getUse_https() {
    return this.use_https;
  }

  public void setUse_https(Boolean use_https) {
    this.use_https = use_https;
  }

  @Column(name = "custom_fields")
  public String getCustom_fields() {
    return this.custom_fields;
  }

  public void setCustom_fields(String custom_fields) {
    this.custom_fields = custom_fields;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "c_proj", nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  
  @Column(name = "terms_of_use_content")
  public String getTerms_of_use_content() {
    return this.terms_of_use_content;
  }

  public void setTerms_of_use_content(String terms_of_use_content) {
    this.terms_of_use_content = terms_of_use_content;
  }

  
  @Column(name = "footer_content")
  public String getFooter_content() {
    return this.footer_content;
  }

  public void setFooter_content(String footer_content) {
    this.footer_content = footer_content;
  }

  @Column(name = "is_show_terms_of_use")
  public Boolean getIs_show_terms_of_use() {
    return this.is_show_terms_of_use;
  }

  public void setIs_show_terms_of_use(Boolean is_show_terms_of_use) {
    this.is_show_terms_of_use = is_show_terms_of_use;
  }

  @Column(name = "c_country")
  public Integer getC_country() {
    return c_country;
  }

  public void setC_country(Integer c_country) {
    this.c_country = c_country;
  }

  @Transient
  public C_Usr getC_usr_t() {
    if (this.c_usr_t == null && this.getC_usr() != null) {
      this.c_usr_t = C_Usr_Manager.getCI().get_rec(this.getC_usr());
    }
    return this.c_usr_t;
  }

  @Transient
  public C_Usr getC_usr_t_2(Session session_) {
    if (this.c_usr_t == null && this.getC_usr() != null) {
      this.c_usr_t = C_Usr_Manager.getCI().get_rec(session_, this.getC_usr());
    }
    return this.c_usr_t;
  }

  public void setC_usr_t(C_Usr c_usr_t) {
    this.c_usr_t = c_usr_t;
    this.c_usr = (this.c_usr_t != null ? this.c_usr_t.getC_usr() : null);
  }

  @Transient
  public C_Theme getC_theme_t() {
    if (this.c_theme_t == null && this.getC_theme() != null) {
      this.c_theme_t = C_Theme_Manager.getCI().get_rec(this.getC_theme());
    }
    return this.c_theme_t;
  }

  @Transient
  public C_Theme getC_theme_t_2(Session session_) {
    if (this.c_theme_t == null && this.getC_theme() != null) {
      this.c_theme_t = C_Theme_Manager.getCI().get_rec(session_, this.getC_theme());
    }
    return this.c_theme_t;
  }

  public void setC_theme_t(C_Theme c_theme_t) {
    this.c_theme_t = c_theme_t;
    this.c_theme = (this.c_theme_t != null ? this.c_theme_t.getC_theme() : null);
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
  public C_Country getC_country_t() {
    if (this.c_country_t == null && this.getC_country() != null) {
      this.c_country_t = C_Country_Manager.getCI().get_rec(this.getC_country());
    }
    return this.c_country_t;
  }

  @Transient
  public C_Country getC_country_t_2(Session session_) {
    if (this.c_country_t == null && this.getC_country() != null) {
      this.c_country_t = C_Country_Manager.getCI().get_rec(session_, this.getC_country());
    }
    return this.c_country_t;
  }

  public void setC_country_t(C_Country c_country_t) {
    this.c_country_t = c_country_t;
    this.c_country = (this.c_country_t != null ? this.c_country_t.getC_country() : null);
  }

  
  @Transient
  public String getFooter_content_translation_2(Session session_) {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      footer_content_translation = getFooter_content();
    } else {
      footer_content_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "footer_content", LocaleBean.getCurrentBean().getLanguageTag(),
        getFooter_content());
    }
    return footer_content_translation;
  }

  @Transient
  public String getTerms_of_use_content_translation_2(Session session_) {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      terms_of_use_content_translation = getTerms_of_use_content();
    } else {
      terms_of_use_content_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "terms_of_use_content", LocaleBean.getCurrentBean().getLanguageTag(),
        getTerms_of_use_content());
    }
    return terms_of_use_content_translation;
  }

  @Transient
  public JSONObject getCustom_fields_json_object() {
    if (custom_fields_json_object == null) {
      try {
        custom_fields_json_object = new JSONObject(getCustom_fields() == null ? "{}" : getCustom_fields());
      } catch (Exception e) {
        custom_fields_json_object = new JSONObject();
      }
    }
    return custom_fields_json_object;
  }

  public void setCustom_fields_json_object(JSONObject custom_fields_json_object) {
    this.custom_fields_json_object = custom_fields_json_object;
  }

  @Transient
  public Boolean getIs_deploy_website_pass_checks() {
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_site());
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
    final C_Site other = (C_Site) obj;
    if (!Objects.equals(this.getC_site(), other.getC_site())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_site();
  }

}
