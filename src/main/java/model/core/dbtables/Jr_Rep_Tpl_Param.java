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
import java.util.List;
import managers.core.dbtables.*;
import org.hibernate.Session;

@Entity
@Table(name = "jr_rep_tpl_param")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Tpl_Param extends Abstract_Entity {

  //fields
  private Integer jr_rep_tpl_param;
  private Integer jr_rep_tpl;
  private String code;
  private String name;
  private Integer c_java_data_type;
  private Integer order_num;
  private Integer jr_input_control;
  private Boolean is_readonly;
  private Boolean is_required;
  private Boolean is_visible;
  private String default_val;

  //transient fields
  private Jr_Rep_Tpl jr_rep_tpl_t = null;
  private C_Java_Data_Type c_java_data_type_t = null;
  private Jr_Input_Control jr_input_control_t = null;
  private Object default_value;
  private Object value;
  private List list_value;
  private String name_translation;

  public Jr_Rep_Tpl_Param() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "jr_rep_tpl_param", unique = true, nullable = false)
  public Integer getJr_rep_tpl_param() {
    return this.jr_rep_tpl_param;
  }

  public void setJr_rep_tpl_param(Integer jr_rep_tpl_param) {
    this.jr_rep_tpl_param = jr_rep_tpl_param;
  }

  @Column(name = "jr_rep_tpl", nullable = false)
  public Integer getJr_rep_tpl() {
    return this.jr_rep_tpl;
  }

  public void setJr_rep_tpl(Integer jr_rep_tpl) {
    this.jr_rep_tpl = jr_rep_tpl;
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

  @Column(name = "c_java_data_type", nullable = false)
  public Integer getC_java_data_type() {
    return this.c_java_data_type;
  }

  public void setC_java_data_type(Integer c_java_data_type) {
    this.c_java_data_type = c_java_data_type;
  }

  @Column(name = "order_num", nullable = false)
  public Integer getOrder_num() {
    return this.order_num;
  }

  public void setOrder_num(Integer order_num) {
    this.order_num = order_num;
  }

  @Column(name = "jr_input_control")
  public Integer getJr_input_control() {
    return this.jr_input_control;
  }

  public void setJr_input_control(Integer jr_input_control) {
    this.jr_input_control = jr_input_control;
  }

  @Column(name = "is_readonly", nullable = false)
  public Boolean getIs_readonly() {
    return this.is_readonly;
  }

  public void setIs_readonly(Boolean is_readonly) {
    this.is_readonly = is_readonly;
  }

  @Column(name = "is_required", nullable = false)
  public Boolean getIs_required() {
    return this.is_required;
  }

  public void setIs_required(Boolean is_required) {
    this.is_required = is_required;
  }

  @Column(name = "is_visible", nullable = false)
  public Boolean getIs_visible() {
    return this.is_visible;
  }

  public void setIs_visible(Boolean is_visible) {
    this.is_visible = is_visible;
  }

  
  @Column(name = "default_val", nullable = false)
  public String getDefault_val() {
    return this.default_val;
  }

  public void setDefault_val(String default_val) {
    this.default_val = default_val;
  }

  @Transient
  public Object getDefault_value() {
    return default_value;
  }

  public void setDefault_value(Object default_value) {
    this.default_value = default_value;
  }

  @Transient
  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  @Transient
  public List getList_value() {
    return list_value;
  }

  public void setList_value(List list_value) {
    this.list_value = list_value;
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
  public C_Java_Data_Type getC_java_data_type_t() {
    if (this.c_java_data_type_t == null && this.getC_java_data_type() != null) {
      this.c_java_data_type_t = C_Java_Data_Type_Manager.getCI().get_rec(this.getC_java_data_type());
    }
    return this.c_java_data_type_t;
  }

  @Transient
  public C_Java_Data_Type getC_java_data_type_t_2(Session session_) {
    if (this.c_java_data_type_t == null && this.getC_java_data_type() != null) {
      this.c_java_data_type_t = C_Java_Data_Type_Manager.getCI().get_rec(session_, this.getC_java_data_type());
    }
    return this.c_java_data_type_t;
  }

  public void setC_java_data_type_t(C_Java_Data_Type c_java_data_type_t) {
    this.c_java_data_type_t = c_java_data_type_t;
    this.c_java_data_type = (this.c_java_data_type_t != null ? this.c_java_data_type_t.getC_java_data_type() : null);
  }

  @Transient
  public Jr_Input_Control getJr_input_control_t() {
    if (this.jr_input_control_t == null && this.getJr_input_control() != null) {
      this.jr_input_control_t = Jr_Input_Control_Manager.getCI().get_rec(this.getJr_input_control());
    }
    return this.jr_input_control_t;
  }

  @Transient
  public Jr_Input_Control getJr_input_control_t_2(Session session_) {
    if (this.jr_input_control_t == null && this.getJr_input_control() != null) {
      this.jr_input_control_t = Jr_Input_Control_Manager.getCI().get_rec(session_, this.getJr_input_control());
    }
    return this.jr_input_control_t;
  }

  public void setJr_input_control_t(Jr_Input_Control jr_input_control_t) {
    this.jr_input_control_t = jr_input_control_t;
    this.jr_input_control = (this.jr_input_control_t != null ? this.jr_input_control_t.getJr_input_control() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_tpl_param());
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
    final Jr_Rep_Tpl_Param other = (Jr_Rep_Tpl_Param) obj;
    if (!Objects.equals(this.getJr_rep_tpl_param(), other.getJr_rep_tpl_param())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_tpl_param();
  }

}
