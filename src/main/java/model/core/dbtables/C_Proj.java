package model.core.dbtables;

import gs.common.hibernate_funcs;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import java.util.List;
import managers.core.dbtables.*;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import others.CustomLogger;

@Entity
@Table(name = "c_proj")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Proj extends Abstract_Entity {

  //fields
  private Integer c_proj;
  private String code;
  private String name;
  private String admin_email;
  private String cus_fields;
  private Boolean is_deleted;
  private Integer def_c_country;
  private Integer def_c_lang;
  private Integer def_c_cur;

  //transient fields
  private C_Country def_c_country_t = null;
  private C_Lang def_c_lang_t = null;
  private C_Cur def_c_cur_t = null;
  private JSONObject cus_fields_json_object;
  private List<C_Lang> proj_lang_list;

  public C_Proj() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_proj", unique = true, nullable = false)
  public Integer getC_proj() {
    return this.c_proj;
  }

  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
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

  
  @Column(name = "admin_email", nullable = false)
  public String getAdmin_email() {
    return this.admin_email;
  }

  public void setAdmin_email(String admin_email) {
    this.admin_email = admin_email;
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

  @Column(name = "def_c_country")
  public Integer getDef_c_country() {
    return this.def_c_country;
  }

  public void setDef_c_country(Integer def_c_country) {
    this.def_c_country = def_c_country;
  }

  @Column(name = "def_c_lang")
  public Integer getDef_c_lang() {
    return this.def_c_lang;
  }

  public void setDef_c_lang(Integer def_c_lang) {
    this.def_c_lang = def_c_lang;
  }

  @Column(name = "def_c_cur")
  public Integer getDef_c_cur() {
    return this.def_c_cur;
  }

  public void setDef_c_cur(Integer def_c_cur) {
    this.def_c_cur = def_c_cur;
  }

  @Transient
  public C_Country getDef_c_country_t() {
    if (this.def_c_country_t == null && this.getDef_c_country() != null) {
      this.def_c_country_t = C_Country_Manager.getCI().get_rec(this.getDef_c_country());
    }
    return this.def_c_country_t;
  }

  @Transient
  public C_Country getDef_c_country_t_2(Session session_) {
    if (this.def_c_country_t == null && this.getDef_c_country() != null) {
      this.def_c_country_t = C_Country_Manager.getCI().get_rec(session_, this.getDef_c_country());
    }
    return this.def_c_country_t;
  }

  public void setDef_c_country_t(C_Country def_c_country_t) {
    this.def_c_country_t = def_c_country_t;
    this.def_c_country = (this.def_c_country_t != null ? this.def_c_country_t.getC_country() : null);
  }

  @Transient
  public C_Lang getDef_c_lang_t() {
    if (this.def_c_lang_t == null && this.getDef_c_lang() != null) {
      this.def_c_lang_t = C_Lang_Manager.getCI().get_rec(this.getDef_c_lang());
    }
    return this.def_c_lang_t;
  }

  @Transient
  public C_Lang getDef_c_lang_t_2(Session session_) {
    if (this.def_c_lang_t == null && this.getDef_c_lang() != null) {
      this.def_c_lang_t = C_Lang_Manager.getCI().get_rec(session_, this.getDef_c_lang());
    }
    return this.def_c_lang_t;
  }

  public void setDef_c_lang_t(C_Lang def_c_lang_t) {
    this.def_c_lang_t = def_c_lang_t;
    this.def_c_lang = (this.def_c_lang_t != null ? this.def_c_lang_t.getC_lang() : null);
  }

  @Transient
  public C_Cur getDef_c_cur_t() {
    if (this.def_c_cur_t == null && this.getDef_c_cur() != null) {
      this.def_c_cur_t = C_Cur_Manager.getCI().get_rec(this.getDef_c_cur());
    }
    return this.def_c_cur_t;
  }

  @Transient
  public C_Cur getDef_c_cur_t_2(Session session_) {
    if (this.def_c_cur_t == null && this.getDef_c_cur() != null) {
      this.def_c_cur_t = C_Cur_Manager.getCI().get_rec(session_, this.getDef_c_cur());
    }
    return this.def_c_cur_t;
  }

  public void setDef_c_cur_t(C_Cur def_c_cur_t) {
    this.def_c_cur_t = def_c_cur_t;
    this.def_c_cur = (this.def_c_cur_t != null ? this.def_c_cur_t.getC_cur() : null);
  }

  @Transient
  public JSONObject getCus_fields_json_object() {
    if (cus_fields_json_object == null) {
      if (getCus_fields() == null) {
        cus_fields_json_object = new JSONObject();
      } else {
        try {
          cus_fields_json_object = new JSONObject(getCus_fields());
        } catch (Exception e) {
          cus_fields_json_object = new JSONObject();
        }
      }
    }
    return cus_fields_json_object;
  }

  public void setCus_fields_json_object(JSONObject cus_fields_json_object) {
    this.cus_fields_json_object = cus_fields_json_object;
  }

  @Transient
  public List<C_Lang> getProj_lang_list() {
    if (proj_lang_list == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        proj_lang_list = getProj_lang_list_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return proj_lang_list;
  }

  public void setProj_lang_list(List<C_Lang> proj_lang_list) {
    this.proj_lang_list = proj_lang_list;
  }

  @Transient
  public List<C_Lang> getProj_lang_list_2(Session session_) {
    if (proj_lang_list == null) {
      proj_lang_list = C_Proj_Lang_Manager.getCI().get_proj_lang_list(session_, c_proj);
    }
    return proj_lang_list;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_proj());
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
    final C_Proj other = (C_Proj) obj;
    if (!Objects.equals(this.getC_proj(), other.getC_proj())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_proj();
  }

}
