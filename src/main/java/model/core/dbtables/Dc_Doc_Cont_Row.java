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
@Table(name = "dc_doc_cont_row")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Dc_Doc_Cont_Row extends Abstract_Entity {

  //fields
  private Integer dc_doc_cont_row;
  private Integer dc_doc_cont;
  private Integer parent_id;
  private String name;
  private String url;
  private String content_txt;
  private Boolean is_internal;
  private Integer order_num;
  private Boolean is_active;
  private Boolean is_deleted;

  //transient fields
  private Dc_Doc_Cont dc_doc_cont_t = null;
  private Dc_Doc_Cont_Row parent_id_t = null;

  //transient
  private String name_translation;
  private String content_txt_translation;
  private Boolean is_content_txt_match = false;
  private Dc_Doc_Cont_Row locate_after_row;

  public Dc_Doc_Cont_Row() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dc_doc_cont_row", unique = true, nullable = false)
  public Integer getDc_doc_cont_row() {
    return this.dc_doc_cont_row;
  }

  public void setDc_doc_cont_row(Integer dc_doc_cont_row) {
    this.dc_doc_cont_row = dc_doc_cont_row;
  }

  @Column(name = "dc_doc_cont", nullable = false)
  public Integer getDc_doc_cont() {
    return this.dc_doc_cont;
  }

  public void setDc_doc_cont(Integer dc_doc_cont) {
    this.dc_doc_cont = dc_doc_cont;
  }

  @Column(name = "parent_id")
  public Integer getParent_id() {
    return this.parent_id;
  }

  public void setParent_id(Integer parent_id) {
    this.parent_id = parent_id;
  }

  
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  
  @Column(name = "url", nullable = false)
  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  
  @Column(name = "content_txt", nullable = false)
  public String getContent_txt() {
    return this.content_txt;
  }

  public void setContent_txt(String content_txt) {
    this.content_txt = content_txt;
  }

  @Column(name = "is_internal", nullable = false)
  public Boolean getIs_internal() {
    return this.is_internal;
  }

  public void setIs_internal(Boolean is_internal) {
    this.is_internal = is_internal;
  }

  @Column(name = "order_num", nullable = false)
  public Integer getOrder_num() {
    return this.order_num;
  }

  public void setOrder_num(Integer order_num) {
    this.order_num = order_num;
  }

  @Column(name = "is_active", nullable = false)
  public Boolean getIs_active() {
    return this.is_active;
  }

  public void setIs_active(Boolean is_active) {
    this.is_active = is_active;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public Dc_Doc_Cont getDc_doc_cont_t() {
    if (this.dc_doc_cont_t == null && this.getDc_doc_cont() != null) {
      this.dc_doc_cont_t = Dc_Doc_Cont_Manager.getCI().get_rec(this.getDc_doc_cont());
    }
    return this.dc_doc_cont_t;
  }

  @Transient
  public Dc_Doc_Cont getDc_doc_cont_t_2(Session session_) {
    if (this.dc_doc_cont_t == null && this.getDc_doc_cont() != null) {
      this.dc_doc_cont_t = Dc_Doc_Cont_Manager.getCI().get_rec(session_, this.getDc_doc_cont());
    }
    return this.dc_doc_cont_t;
  }

  public void setDc_doc_cont_t(Dc_Doc_Cont dc_doc_cont_t) {
    this.dc_doc_cont_t = dc_doc_cont_t;
    this.dc_doc_cont = (this.dc_doc_cont_t != null ? this.dc_doc_cont_t.getDc_doc_cont() : null);
  }

  @Transient
  public Dc_Doc_Cont_Row getParent_id_t() {
    if (this.parent_id_t == null && this.getParent_id() != null) {
      this.parent_id_t = Dc_Doc_Cont_Row_Manager.getCI().get_rec(this.getParent_id());
    }
    return this.parent_id_t;
  }

  @Transient
  public Dc_Doc_Cont_Row getParent_id_t_2(Session session_) {
    if (this.parent_id_t == null && this.getParent_id() != null) {
      this.parent_id_t = Dc_Doc_Cont_Row_Manager.getCI().get_rec(session_, this.getParent_id());
    }
    return this.parent_id_t;
  }

  public void setParent_id_t(Dc_Doc_Cont_Row parent_id_t) {
    this.parent_id_t = parent_id_t;
    this.parent_id = (this.parent_id_t != null ? this.parent_id_t.getDc_doc_cont_row() : null);
  }

  @Transient
  public String getName_translation() {
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
  public String getName_translation_2(Session session_) {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "name", LocaleBean.getCurrentBean().getLanguageTag(), getName());
    }
    return name_translation;
  }

  @Transient
  public String getName_translation_3(Session session_, String lang_) {
    if (lang_.equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "name", lang_, getName());
    }
    return name_translation;
  }

  @Transient
  public String getContent_txt_translation() {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      content_txt_translation = getContent_txt();
    } else {
      content_txt_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(this.getClass().getSimpleName(), (Integer) getEntity_id(), "content_txt", LocaleBean.getCurrentBean().getLanguageTag(), getContent_txt());
    }
    return content_txt_translation;
  }

  public void setContent_txt_translation(String content_txt_translation) {
    this.content_txt_translation = content_txt_translation;
  }

  @Transient
  public String getContent_txt_translation_2(Session session_) {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      content_txt_translation = getContent_txt();
    } else {
      content_txt_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "content_txt", LocaleBean.getCurrentBean().getLanguageTag(), getContent_txt());
    }
    return content_txt_translation;
  }

  @Transient
  public String getContent_txt_translation_3(Session session_, String lang_) {
    if (lang_.equals("ru")) {
      content_txt_translation = getContent_txt();
    } else {
      content_txt_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer) getEntity_id(), "content_txt", lang_, getContent_txt());
    }
    return content_txt_translation;
  }

  @Transient
  public Boolean getIs_content_txt_match() {
    return is_content_txt_match;
  }

  public void setIs_content_txt_match(Boolean is_content_txt_match) {
    this.is_content_txt_match = is_content_txt_match;
  }

  @Transient
  public Dc_Doc_Cont_Row getLocate_after_row() {
    return locate_after_row;
  }

  public void setLocate_after_row(Dc_Doc_Cont_Row locate_after_row) {
    this.locate_after_row = locate_after_row;
  }

  @Transient
  public String getAbsolute_url() {
    if (getParent_id_t() != null) {
      return getParent_id_t().getAbsolute_url() + "/" + url;
    } else {
      return url;
    }
  }

  @Transient
  public String getShort_content_txt() {
    if (this.content_txt.length() < 30) {
      return this.content_txt;
    } else {
      return this.content_txt.substring(0, 30) + "...";
    }
  }

  @Transient
  public Integer getTree_level() {
    Integer res = 0;
    Dc_Doc_Cont_Row tmp_rec_ = this;
    while (tmp_rec_.getParent_id_t() != null) {
      res = res + 1;
      tmp_rec_ = tmp_rec_.getParent_id_t();
    }
    return res;
  }

  @Transient
  public String getTree_name() {
    String res = "";
    for (int i = 0; i < getTree_level(); i++) {
      res = res + "--";
    }
    res = res + getName();
    return res;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getDc_doc_cont_row());
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
    final Dc_Doc_Cont_Row other = (Dc_Doc_Cont_Row) obj;
    if (!Objects.equals(this.getDc_doc_cont_row(), other.getDc_doc_cont_row())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getDc_doc_cont_row();
  }

}
