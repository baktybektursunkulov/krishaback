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
@Table(name="jr_input_control")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Input_Control extends Abstract_Entity {

  //fields
  private Integer jr_input_control;
  private Long c_usr;
  private Integer jr_input_control_type;
  private String code;
  private String name;
  private Boolean is_mandatory;
  private Boolean is_readonly;
  private Boolean is_visible;
  private Integer jr_query;
  private Integer jr_lov;

  //transient fields
  private C_Usr c_usr_t = null;
  private Jr_Input_Control_Type jr_input_control_type_t = null;
  private Jr_Query jr_query_t = null;
  private Jr_Lov jr_lov_t = null;


  public Jr_Input_Control() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="jr_input_control", unique=true, nullable=false)
  public Integer getJr_input_control() {
    return this.jr_input_control;
  }
  public void setJr_input_control(Integer jr_input_control) {
    this.jr_input_control = jr_input_control;
  }

  @Column(name="c_usr", nullable=false)
  public Long getC_usr() {
    return this.c_usr;
  }
  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name="jr_input_control_type", nullable=false)
  public Integer getJr_input_control_type() {
    return this.jr_input_control_type;
  }
  public void setJr_input_control_type(Integer jr_input_control_type) {
    this.jr_input_control_type = jr_input_control_type;
  }

  @Type(type="text")
  @Column(name="code", nullable=false)
  public String getCode() {
    return this.code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  @Type(type="text")
  @Column(name="name", nullable=false)
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Column(name="is_mandatory", nullable=false)
  public Boolean getIs_mandatory() {
    return this.is_mandatory;
  }
  public void setIs_mandatory(Boolean is_mandatory) {
    this.is_mandatory = is_mandatory;
  }

  @Column(name="is_readonly", nullable=false)
  public Boolean getIs_readonly() {
    return this.is_readonly;
  }
  public void setIs_readonly(Boolean is_readonly) {
    this.is_readonly = is_readonly;
  }

  @Column(name="is_visible", nullable=false)
  public Boolean getIs_visible() {
    return this.is_visible;
  }
  public void setIs_visible(Boolean is_visible) {
    this.is_visible = is_visible;
  }

  @Column(name="jr_query")
  public Integer getJr_query() {
    return this.jr_query;
  }
  public void setJr_query(Integer jr_query) {
    this.jr_query = jr_query;
  }

  @Column(name="jr_lov")
  public Integer getJr_lov() {
    return this.jr_lov;
  }
  public void setJr_lov(Integer jr_lov) {
    this.jr_lov = jr_lov;
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
    this.c_usr = (this.c_usr_t != null?this.c_usr_t.getC_usr():null);
  }

  @Transient
  public Jr_Input_Control_Type getJr_input_control_type_t() {
    if (this.jr_input_control_type_t == null && this.getJr_input_control_type() != null) {
      this.jr_input_control_type_t = Jr_Input_Control_Type_Manager.getCI().get_rec(this.getJr_input_control_type()); 
    }
    return this.jr_input_control_type_t;
  }
  @Transient
  public Jr_Input_Control_Type getJr_input_control_type_t_2(Session session_) {
    if (this.jr_input_control_type_t == null && this.getJr_input_control_type() != null) {
      this.jr_input_control_type_t = Jr_Input_Control_Type_Manager.getCI().get_rec(session_, this.getJr_input_control_type()); 
    }
    return this.jr_input_control_type_t;
  }
  public void setJr_input_control_type_t(Jr_Input_Control_Type jr_input_control_type_t) {
    this.jr_input_control_type_t = jr_input_control_type_t;
    this.jr_input_control_type = (this.jr_input_control_type_t != null?this.jr_input_control_type_t.getJr_input_control_type():null);
  }






  @Transient
  public Jr_Query getJr_query_t() {
    if (this.jr_query_t == null && this.getJr_query() != null) {
      this.jr_query_t = Jr_Query_Manager.getCI().get_rec(this.getJr_query()); 
    }
    return this.jr_query_t;
  }
  @Transient
  public Jr_Query getJr_query_t_2(Session session_) {
    if (this.jr_query_t == null && this.getJr_query() != null) {
      this.jr_query_t = Jr_Query_Manager.getCI().get_rec(session_, this.getJr_query()); 
    }
    return this.jr_query_t;
  }
  public void setJr_query_t(Jr_Query jr_query_t) {
    this.jr_query_t = jr_query_t;
    this.jr_query = (this.jr_query_t != null?this.jr_query_t.getJr_query():null);
  }

  @Transient
  public Jr_Lov getJr_lov_t() {
    if (this.jr_lov_t == null && this.getJr_lov() != null) {
      this.jr_lov_t = Jr_Lov_Manager.getCI().get_rec(this.getJr_lov()); 
    }
    return this.jr_lov_t;
  }
  @Transient
  public Jr_Lov getJr_lov_t_2(Session session_) {
    if (this.jr_lov_t == null && this.getJr_lov() != null) {
      this.jr_lov_t = Jr_Lov_Manager.getCI().get_rec(session_, this.getJr_lov()); 
    }
    return this.jr_lov_t;
  }
  public void setJr_lov_t(Jr_Lov jr_lov_t) {
    this.jr_lov_t = jr_lov_t;
    this.jr_lov = (this.jr_lov_t != null?this.jr_lov_t.getJr_lov():null);
  }


  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_input_control());
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
    final Jr_Input_Control other = (Jr_Input_Control) obj;
    if (!Objects.equals(this.getJr_input_control(), other.getJr_input_control())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_input_control();
  }

} 
