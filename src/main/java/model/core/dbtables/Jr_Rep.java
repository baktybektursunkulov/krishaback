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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import managers.core.dbtables.*;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Session;
import org.json.simple.JSONValue;

@Entity
@Table(name = "jr_rep")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep extends Abstract_Entity {

  //fields
  private Integer jr_rep;
  private Long creator_usr;
  private String name;
  private Integer jr_rep_tpl;
  private Integer order_num;
  private String title;
  private Boolean is_display_report_title;
  private Boolean is_display_total;
  private Boolean is_display_row_num;
  private Boolean is_title_on_new_page;
  private Boolean is_summary_on_new_page;
  private Boolean is_summary_with_page_head_foot;
  private Boolean is_float_column_footer;
  private Boolean is_ignore_pagination;
  private Boolean is_create_bookmarks;
  private Integer page_width;
  private Integer page_height;
  private Integer page_top_margin;
  private Integer page_left_margin;
  private Integer page_bottom_margin;
  private Integer page_right_margin;
  private Integer jr_rep_page_orient;
  private String date_format_pattern;
  private String time_format_pattern;
  private String date_time_format_pattern;
  private Integer c_speed_unit;
  private Integer c_distance_unit;
  private Integer c_volume_unit;
  private Boolean is_grp_by_dates;
  private Boolean is_add_total;
  private Boolean is_deleted;
  private Date ins_dt;

  //transient fields
  private C_Usr creator_usr_t = null;
  private Jr_Rep_Tpl jr_rep_tpl_t = null;
  private Jr_Rep_Page_Orient jr_rep_page_orient_t = null;
  private C_Speed_Unit c_speed_unit_t = null;
  private C_Distance_Unit c_distance_unit_t = null;
  private C_Volume_Unit c_volume_unit_t = null;

  private String name_translation;
  private List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list;

  public Jr_Rep() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "jr_rep", unique = true, nullable = false)
  public Integer getJr_rep() {
    return this.jr_rep;
  }

  public void setJr_rep(Integer jr_rep) {
    this.jr_rep = jr_rep;
  }

  @Column(name = "creator_usr", nullable = false)
  public Long getCreator_usr() {
    return this.creator_usr;
  }

  public void setCreator_usr(Long creator_usr) {
    this.creator_usr = creator_usr;
  }

  
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "jr_rep_tpl", nullable = false)
  public Integer getJr_rep_tpl() {
    return this.jr_rep_tpl;
  }

  public void setJr_rep_tpl(Integer jr_rep_tpl) {
    this.jr_rep_tpl = jr_rep_tpl;
  }

  @Column(name = "order_num", nullable = false)
  public Integer getOrder_num() {
    return this.order_num;
  }

  public void setOrder_num(Integer order_num) {
    this.order_num = order_num;
  }

  
  @Column(name = "title", nullable = false)
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(name = "is_display_report_title", nullable = false)
  public Boolean getIs_display_report_title() {
    return this.is_display_report_title;
  }

  public void setIs_display_report_title(Boolean is_display_report_title) {
    this.is_display_report_title = is_display_report_title;
  }

  @Column(name = "is_display_total", nullable = false)
  public Boolean getIs_display_total() {
    return this.is_display_total;
  }

  public void setIs_display_total(Boolean is_display_total) {
    this.is_display_total = is_display_total;
  }

  @Column(name = "is_display_row_num", nullable = false)
  public Boolean getIs_display_row_num() {
    return this.is_display_row_num;
  }

  public void setIs_display_row_num(Boolean is_display_row_num) {
    this.is_display_row_num = is_display_row_num;
  }

  @Column(name = "is_title_on_new_page", nullable = false)
  public Boolean getIs_title_on_new_page() {
    return this.is_title_on_new_page;
  }

  public void setIs_title_on_new_page(Boolean is_title_on_new_page) {
    this.is_title_on_new_page = is_title_on_new_page;
  }

  @Column(name = "is_summary_on_new_page", nullable = false)
  public Boolean getIs_summary_on_new_page() {
    return this.is_summary_on_new_page;
  }

  public void setIs_summary_on_new_page(Boolean is_summary_on_new_page) {
    this.is_summary_on_new_page = is_summary_on_new_page;
  }

  @Column(name = "is_summary_with_page_head_foot", nullable = false)
  public Boolean getIs_summary_with_page_head_foot() {
    return this.is_summary_with_page_head_foot;
  }

  public void setIs_summary_with_page_head_foot(Boolean is_summary_with_page_head_foot) {
    this.is_summary_with_page_head_foot = is_summary_with_page_head_foot;
  }

  @Column(name = "is_float_column_footer", nullable = false)
  public Boolean getIs_float_column_footer() {
    return this.is_float_column_footer;
  }

  public void setIs_float_column_footer(Boolean is_float_column_footer) {
    this.is_float_column_footer = is_float_column_footer;
  }

  @Column(name = "is_ignore_pagination", nullable = false)
  public Boolean getIs_ignore_pagination() {
    return this.is_ignore_pagination;
  }

  public void setIs_ignore_pagination(Boolean is_ignore_pagination) {
    this.is_ignore_pagination = is_ignore_pagination;
  }

  @Column(name = "is_create_bookmarks", nullable = false)
  public Boolean getIs_create_bookmarks() {
    return this.is_create_bookmarks;
  }

  public void setIs_create_bookmarks(Boolean is_create_bookmarks) {
    this.is_create_bookmarks = is_create_bookmarks;
  }

  @Column(name = "page_width", nullable = false)
  public Integer getPage_width() {
    return this.page_width;
  }

  public void setPage_width(Integer page_width) {
    this.page_width = page_width;
  }

  @Column(name = "page_height", nullable = false)
  public Integer getPage_height() {
    return this.page_height;
  }

  public void setPage_height(Integer page_height) {
    this.page_height = page_height;
  }

  @Column(name = "page_top_margin", nullable = false)
  public Integer getPage_top_margin() {
    return this.page_top_margin;
  }

  public void setPage_top_margin(Integer page_top_margin) {
    this.page_top_margin = page_top_margin;
  }

  @Column(name = "page_left_margin", nullable = false)
  public Integer getPage_left_margin() {
    return this.page_left_margin;
  }

  public void setPage_left_margin(Integer page_left_margin) {
    this.page_left_margin = page_left_margin;
  }

  @Column(name = "page_bottom_margin", nullable = false)
  public Integer getPage_bottom_margin() {
    return this.page_bottom_margin;
  }

  public void setPage_bottom_margin(Integer page_bottom_margin) {
    this.page_bottom_margin = page_bottom_margin;
  }

  @Column(name = "page_right_margin", nullable = false)
  public Integer getPage_right_margin() {
    return this.page_right_margin;
  }

  public void setPage_right_margin(Integer page_right_margin) {
    this.page_right_margin = page_right_margin;
  }

  @Column(name = "jr_rep_page_orient", nullable = false)
  public Integer getJr_rep_page_orient() {
    return this.jr_rep_page_orient;
  }

  public void setJr_rep_page_orient(Integer jr_rep_page_orient) {
    this.jr_rep_page_orient = jr_rep_page_orient;
  }

  
  @Column(name = "date_format_pattern", nullable = false)
  public String getDate_format_pattern() {
    return this.date_format_pattern;
  }

  public void setDate_format_pattern(String date_format_pattern) {
    this.date_format_pattern = date_format_pattern;
  }

  
  @Column(name = "time_format_pattern", nullable = false)
  public String getTime_format_pattern() {
    return this.time_format_pattern;
  }

  public void setTime_format_pattern(String time_format_pattern) {
    this.time_format_pattern = time_format_pattern;
  }

  
  @Column(name = "date_time_format_pattern", nullable = false)
  public String getDate_time_format_pattern() {
    return this.date_time_format_pattern;
  }

  public void setDate_time_format_pattern(String date_time_format_pattern) {
    this.date_time_format_pattern = date_time_format_pattern;
  }

  @Column(name = "c_speed_unit", nullable = false)
  public Integer getC_speed_unit() {
    return this.c_speed_unit;
  }

  public void setC_speed_unit(Integer c_speed_unit) {
    this.c_speed_unit = c_speed_unit;
  }

  @Column(name = "c_distance_unit", nullable = false)
  public Integer getC_distance_unit() {
    return this.c_distance_unit;
  }

  public void setC_distance_unit(Integer c_distance_unit) {
    this.c_distance_unit = c_distance_unit;
  }

  @Column(name = "c_volume_unit", nullable = false)
  public Integer getC_volume_unit() {
    return this.c_volume_unit;
  }

  public void setC_volume_unit(Integer c_volume_unit) {
    this.c_volume_unit = c_volume_unit;
  }

  @Column(name = "is_grp_by_dates", nullable = false)
  public Boolean getIs_grp_by_dates() {
    return this.is_grp_by_dates;
  }

  public void setIs_grp_by_dates(Boolean is_grp_by_dates) {
    this.is_grp_by_dates = is_grp_by_dates;
  }

  @Column(name = "is_add_total", nullable = false)
  public Boolean getIs_add_total() {
    return this.is_add_total;
  }

  public void setIs_add_total(Boolean is_add_total) {
    this.is_add_total = is_add_total;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Transient
  public C_Usr getCreator_usr_t() {
    if (this.creator_usr_t == null && this.getCreator_usr() != null) {
      this.creator_usr_t = C_Usr_Manager.getCI().get_rec(this.getCreator_usr());
    }
    return this.creator_usr_t;
  }

  @Transient
  public C_Usr getCreator_usr_t_2(Session session_) {
    if (this.creator_usr_t == null && this.getCreator_usr() != null) {
      this.creator_usr_t = C_Usr_Manager.getCI().get_rec(session_, this.getCreator_usr());
    }
    return this.creator_usr_t;
  }

  public void setCreator_usr_t(C_Usr creator_usr_t) {
    this.creator_usr_t = creator_usr_t;
    this.creator_usr = (this.creator_usr_t != null ? this.creator_usr_t.getC_usr() : null);
  }

  @Transient
  public Jr_Rep_Tpl getJr_rep_tpl_t() {
    if (this.jr_rep_tpl_t == null && this.getJr_rep_tpl() != null) {
      this.jr_rep_tpl_t = Jr_Rep_Tpl_Manager.getCI().get_rec(this.getJr_rep_tpl());
    }
    return this.jr_rep_tpl_t;
  }

  @Transient
  public Jr_Rep_Tpl getJr_rep_tpl_t_2(Session session_) {
    if (this.jr_rep_tpl_t == null && this.getJr_rep_tpl() != null) {
      this.jr_rep_tpl_t = Jr_Rep_Tpl_Manager.getCI().get_rec(session_, this.getJr_rep_tpl());
    }
    return this.jr_rep_tpl_t;
  }

  public void setJr_rep_tpl_t(Jr_Rep_Tpl jr_rep_tpl_t) {
    this.jr_rep_tpl_t = jr_rep_tpl_t;
    this.jr_rep_tpl = (this.jr_rep_tpl_t != null ? this.jr_rep_tpl_t.getJr_rep_tpl() : null);
  }

  @Transient
  public Jr_Rep_Page_Orient getJr_rep_page_orient_t() {
    if (this.jr_rep_page_orient_t == null && this.getJr_rep_page_orient() != null) {
      this.jr_rep_page_orient_t = Jr_Rep_Page_Orient_Manager.getCI().get_rec(this.getJr_rep_page_orient());
    }
    return this.jr_rep_page_orient_t;
  }

  @Transient
  public Jr_Rep_Page_Orient getJr_rep_page_orient_t_2(Session session_) {
    if (this.jr_rep_page_orient_t == null && this.getJr_rep_page_orient() != null) {
      this.jr_rep_page_orient_t = Jr_Rep_Page_Orient_Manager.getCI().get_rec(session_, this.getJr_rep_page_orient());
    }
    return this.jr_rep_page_orient_t;
  }

  public void setJr_rep_page_orient_t(Jr_Rep_Page_Orient jr_rep_page_orient_t) {
    this.jr_rep_page_orient_t = jr_rep_page_orient_t;
    this.jr_rep_page_orient = (this.jr_rep_page_orient_t != null ? this.jr_rep_page_orient_t.getJr_rep_page_orient() : null);
  }

  @Transient
  public C_Speed_Unit getC_speed_unit_t() {
    if (this.c_speed_unit_t == null && this.getC_speed_unit() != null) {
      this.c_speed_unit_t = C_Speed_Unit_Manager.getCI().get_rec(this.getC_speed_unit());
    }
    return this.c_speed_unit_t;
  }

  @Transient
  public C_Speed_Unit getC_speed_unit_t_2(Session session_) {
    if (this.c_speed_unit_t == null && this.getC_speed_unit() != null) {
      this.c_speed_unit_t = C_Speed_Unit_Manager.getCI().get_rec(session_, this.getC_speed_unit());
    }
    return this.c_speed_unit_t;
  }

  public void setC_speed_unit_t(C_Speed_Unit c_speed_unit_t) {
    this.c_speed_unit_t = c_speed_unit_t;
    this.c_speed_unit = (this.c_speed_unit_t != null ? this.c_speed_unit_t.getC_speed_unit() : null);
  }

  @Transient
  public C_Distance_Unit getC_distance_unit_t() {
    if (this.c_distance_unit_t == null && this.getC_distance_unit() != null) {
      this.c_distance_unit_t = C_Distance_Unit_Manager.getCI().get_rec(this.getC_distance_unit());
    }
    return this.c_distance_unit_t;
  }

  @Transient
  public C_Distance_Unit getC_distance_unit_t_2(Session session_) {
    if (this.c_distance_unit_t == null && this.getC_distance_unit() != null) {
      this.c_distance_unit_t = C_Distance_Unit_Manager.getCI().get_rec(session_, this.getC_distance_unit());
    }
    return this.c_distance_unit_t;
  }

  public void setC_distance_unit_t(C_Distance_Unit c_distance_unit_t) {
    this.c_distance_unit_t = c_distance_unit_t;
    this.c_distance_unit = (this.c_distance_unit_t != null ? this.c_distance_unit_t.getC_distance_unit() : null);
  }

  @Transient
  public C_Volume_Unit getC_volume_unit_t() {
    if (this.c_volume_unit_t == null && this.getC_volume_unit() != null) {
      this.c_volume_unit_t = C_Volume_Unit_Manager.getCI().get_rec(this.getC_volume_unit());
    }
    return this.c_volume_unit_t;
  }

  @Transient
  public C_Volume_Unit getC_volume_unit_t_2(Session session_) {
    if (this.c_volume_unit_t == null && this.getC_volume_unit() != null) {
      this.c_volume_unit_t = C_Volume_Unit_Manager.getCI().get_rec(session_, this.getC_volume_unit());
    }
    return this.c_volume_unit_t;
  }

  public void setC_volume_unit_t(C_Volume_Unit c_volume_unit_t) {
    this.c_volume_unit_t = c_volume_unit_t;
    this.c_volume_unit = (this.c_volume_unit_t != null ? this.c_volume_unit_t.getC_volume_unit() : null);
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
  public List<Jr_Rep_Tpl_Param> getJr_rep_tpl_param_list() {
    return jr_rep_tpl_param_list;
  }

  public void setJr_rep_tpl_param_list(List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list) {
    this.jr_rep_tpl_param_list = jr_rep_tpl_param_list;
  }

  public JSONObject toJSONObject(Session gtsc_session_, C_Usr c_usr_, String lang_) {
    Map obj_ = new LinkedHashMap();
    obj_.put("id", getJr_rep());

    obj_.put("name", name);
    obj_.put("order_num", order_num);
    obj_.put("title", title);
    obj_.put("is_display_report_title", is_display_report_title);
    obj_.put("is_display_total", is_display_total);
    obj_.put("is_display_row_num", is_display_row_num);
    obj_.put("is_title_on_new_page", is_title_on_new_page);
    obj_.put("is_summary_on_new_page", is_summary_on_new_page);
    obj_.put("is_summary_with_page_head_foot", is_summary_with_page_head_foot);
    obj_.put("is_float_column_footer", is_float_column_footer);
    obj_.put("is_ignore_pagination", is_ignore_pagination);
    obj_.put("is_create_bookmarks", is_create_bookmarks);
    obj_.put("page_width", page_width);
    obj_.put("page_height", page_height);
    obj_.put("page_top_margin", page_top_margin);
    obj_.put("page_left_margin", page_left_margin);
    obj_.put("page_bottom_margin", page_bottom_margin);
    obj_.put("page_right_margin", page_right_margin);
    obj_.put("date_format_pattern", date_format_pattern);
    obj_.put("time_format_pattern", time_format_pattern);
    obj_.put("date_time_format_pattern", date_time_format_pattern);
    obj_.put("speed_unit_name", getC_speed_unit_t_2(gtsc_session_).getName_translation_3(gtsc_session_, lang_));
    obj_.put("speed_unit_multiplier_to_base_unit", getC_speed_unit_t_2(gtsc_session_).getMultiplier_to_base_unit());
    obj_.put("distance_unit_name", getC_distance_unit_t_2(gtsc_session_).getName_translation_3(gtsc_session_, lang_));
    obj_.put("distance_unit_multiplier_to_base_unit", getC_distance_unit_t_2(gtsc_session_).getMultiplier_to_base_unit());
    obj_.put("volume_unit_name", getC_volume_unit_t_2(gtsc_session_).getName_translation_3(gtsc_session_, lang_));
    obj_.put("volume_unit_multiplier_to_base_unit", getC_volume_unit_t_2(gtsc_session_).getMultiplier_to_base_unit());
    obj_.put("is_grp_by_dates", is_grp_by_dates);
    obj_.put("is_add_total", is_add_total);
    return new JSONObject(obj_);
  }

  public String toJSONString(Session gtsc_session_, C_Usr c_usr_, String lang_) {
    return JSONValue.toJSONString(toJSONObject(gtsc_session_, c_usr_, lang_));
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep());
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
    final Jr_Rep other = (Jr_Rep) obj;
    if (!Objects.equals(this.getJr_rep(), other.getJr_rep())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep();
  }

}
