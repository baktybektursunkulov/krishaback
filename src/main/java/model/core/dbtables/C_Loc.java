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
import java.util.List;
import managers.core.dbtables.*;
import org.hibernate.Session;
import others.CustomLogger;

@Entity
@Table(name = "c_loc")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Loc extends Abstract_Entity {

  //fields
  private Integer c_loc;
  private Integer parent_id;
  private String name;
  private Boolean is_country;
  private Boolean is_region;
  private Boolean is_city;
  private Integer c_country;
  private Boolean is_deleted;
  private Boolean is_village;
  private Boolean is_settlement;
  private Boolean is_station;
  private Boolean is_aul;
  private Boolean is_grp;
  private Double lat;
  private Double lon;
  private Double ne_lat;
  private Double ne_lon;
  private Double sw_lat;
  private Double sw_lon;
  
  //transient fields
  private C_Loc parent_id_t = null;
  private C_Country c_country_t = null;
  String calc_full_name = null;
  private String name_translation;
  private String calc_full_name_translation;
  private List<C_Loc> child_list;
  private Boolean has_childs;
  private Boolean has_selected_childs;

  public C_Loc() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_loc", unique = true, nullable = false)
  public Integer getC_loc() {
    return this.c_loc;
  }

  public void setC_loc(Integer c_loc) {
    this.c_loc = c_loc;
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

  @Column(name = "is_country", nullable = false)
  public Boolean getIs_country() {
    return this.is_country;
  }

  public void setIs_country(Boolean is_country) {
    this.is_country = is_country;
  }

  @Column(name = "is_region", nullable = false)
  public Boolean getIs_region() {
    return this.is_region;
  }

  public void setIs_region(Boolean is_region) {
    this.is_region = is_region;
  }

  @Column(name = "is_city", nullable = false)
  public Boolean getIs_city() {
    return this.is_city;
  }

  public void setIs_city(Boolean is_city) {
    this.is_city = is_city;
  }

  @Column(name = "c_country", nullable = true)
  public Integer getC_country() {
    return this.c_country;
  }

  public void setC_country(Integer c_country) {
    this.c_country = c_country;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "is_village", nullable = false)
  public Boolean getIs_village() {
    return this.is_village;
  }

  public void setIs_village(Boolean is_village) {
    this.is_village = is_village;
  }

  @Column(name = "is_settlement", nullable = false)
  public Boolean getIs_settlement() {
    return this.is_settlement;
  }

  public void setIs_settlement(Boolean is_settlement) {
    this.is_settlement = is_settlement;
  }

  @Column(name = "is_station", nullable = false)
  public Boolean getIs_station() {
    return this.is_station;
  }

  public void setIs_station(Boolean is_station) {
    this.is_station = is_station;
  }

  @Column(name = "is_aul", nullable = false)
  public Boolean getIs_aul() {
    return this.is_aul;
  }

  public void setIs_aul(Boolean is_aul) {
    this.is_aul = is_aul;
  }

  @Column(name = "is_grp", nullable = false)
  public Boolean getIs_grp() {
    return this.is_grp;
  }

  public void setIs_grp(Boolean is_grp) {
    this.is_grp = is_grp;
  }

  @Column(name = "lat")
  public Double getLat() {
    return this.lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  @Column(name = "lon")
  public Double getLon() {
    return this.lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }

  @Column(name = "ne_lat")
  public Double getNe_lat() {
    return this.ne_lat;
  }

  public void setNe_lat(Double ne_lat) {
    this.ne_lat = ne_lat;
  }

  @Column(name = "ne_lon")
  public Double getNe_lon() {
    return this.ne_lon;
  }

  public void setNe_lon(Double ne_lon) {
    this.ne_lon = ne_lon;
  }

  @Column(name = "sw_lat")
  public Double getSw_lat() {
    return this.sw_lat;
  }

  public void setSw_lat(Double sw_lat) {
    this.sw_lat = sw_lat;
  }

  @Column(name = "sw_lon")
  public Double getSw_lon() {
    return this.sw_lon;
  }

  public void setSw_lon(Double sw_lon) {
    this.sw_lon = sw_lon;
  }

  @Transient
  public C_Loc getParent_id_t() {
    if (this.parent_id_t == null && this.getParent_id() != null) {
      this.parent_id_t = C_Loc_Manager.getCI().get_rec(this.getParent_id());
    }
    return this.parent_id_t;
  }

  @Transient
  public C_Loc getParent_id_t_2(Session session_) {
    if (this.parent_id_t == null && this.getParent_id() != null) {
      this.parent_id_t = C_Loc_Manager.getCI().get_rec(session_, this.getParent_id());
    }
    return this.parent_id_t;
  }

  public void setParent_id_t(C_Loc parent_id_t) {
    this.parent_id_t = parent_id_t;
    this.parent_id = (this.parent_id_t != null ? this.parent_id_t.getC_loc() : null);
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
  public String getCalc_full_name() {
    if (calc_full_name == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        calc_full_name = getCalc_full_name_2(session_, "->");
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return calc_full_name;
  }

  @Transient
  public String getCalc_full_name_2(Session session_, String symbol_) {
    if (calc_full_name == null) {
      calc_full_name = getName();
      C_Loc c_loc_ = getParent_id_t_2(session_);
      while (c_loc_ != null) {
        calc_full_name = c_loc_.getName() + " " + symbol_ + " " + calc_full_name;
        c_loc_ = c_loc_.getParent_id_t_2(session_);
      }
    }
    return calc_full_name;
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
  public String getCalc_full_name_translation() {
    if (calc_full_name_translation == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        calc_full_name_translation = getCalc_full_name_translation_2(session_, LocaleBean.getCurrentBean().getLanguageTag(), "->");
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return calc_full_name_translation;
  }

  @Transient
  public String getCalc_full_name_translation_2(Session session_, String lang_, String symbol_) {
    if (calc_full_name_translation == null) {
      calc_full_name_translation = getName_translation_3(session_, lang_);
      C_Loc parent_rec_ = getParent_id_t_2(session_);
      while (parent_rec_ != null) {
        calc_full_name_translation = parent_rec_.getName_translation_3(session_, lang_) + " " + symbol_ + " " + calc_full_name_translation;
        parent_rec_ = parent_rec_.getParent_id_t_2(session_);
      }
      //calc_full_name = getC_proj_t().getName() + " | " + calc_full_name;
    }
    return calc_full_name_translation;
  }

  @Transient
  public String getParent_id_t__calc_full_name() {
    return getParent_id_t() == null ? "" : getParent_id_t().getCalc_full_name();
  }

  public void setParent_id_t__calc_full_name() {
  }

  @Transient
  public String getParent_id_t__name() {
    return getParent_id_t() == null ? "" : getParent_id_t().getName();
  }

  public void setParent_id_t__name(String parent_id_t__name) {
  }

  @Transient
  public List<C_Loc> getChild_list_2(Session session_) {
    if (child_list == null) {
      child_list = C_Loc_Manager.getCI().get_child_list(session_, getC_loc());
    }
    return child_list;
  }

  @Transient
  public Boolean getHas_childs() {
    if (has_childs == null) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        has_childs = getHas_childs_2(session_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }
    return has_childs;
  }

  public void setHas_childs(Boolean has_childs) {
    this.has_childs = has_childs;
  }

  @Transient
  public Boolean getHas_childs_2(Session session_) {
    if (has_childs == null) {
      has_childs = C_Loc_Manager.getCI().has_childs(session_, getC_loc());
    }
    return has_childs;
  }

  @Transient
  public Boolean getHas_selected_childs() {
    return has_selected_childs;
  }

  public void setHas_selected_childs(Boolean has_selected_childs) {
    this.has_selected_childs = has_selected_childs;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_loc());
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
    final C_Loc other = (C_Loc) obj;
    if (!Objects.equals(this.getC_loc(), other.getC_loc())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_loc();
  }

  @Override
  public String toString() {
    return "C_Loc{" + "c_loc=" + c_loc + ", parent_id=" + parent_id + ", name=" + name + ", is_country=" + is_country + ", is_region=" + is_region + ", is_city=" + is_city + ", c_country=" + c_country + ", is_deleted=" + is_deleted + ", is_village=" + is_village + ", is_settlement=" + is_settlement + ", is_station=" + is_station + ", is_aul=" + is_aul + ", is_grp=" + is_grp + ", lat=" + lat + ", lon=" + lon + ", parent_id_t=" + parent_id_t + ", c_country_t=" + c_country_t + ", calc_full_name=" + calc_full_name + ", name_translation=" + name_translation + ", calc_full_name_translation=" + calc_full_name_translation + '}';
  }

}
