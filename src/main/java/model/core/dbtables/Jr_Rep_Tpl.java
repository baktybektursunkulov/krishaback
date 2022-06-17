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
@Table(name = "jr_rep_tpl")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Jr_Rep_Tpl extends Abstract_Entity {

  //fields
  private Integer jr_rep_tpl;
  private Long c_usr;
  private Integer jr_rep_tpl_grp;
  private String code;
  private String name;
  private String report_path;
  private Boolean is_support_only_html;

  //transient fields
  private C_Usr c_usr_t = null;
  private Jr_Rep_Tpl_Grp jr_rep_tpl_grp_t = null;
  private List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list;
  private String name_translation;

  public Jr_Rep_Tpl() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "jr_rep_tpl", unique = true, nullable = false)
  public Integer getJr_rep_tpl() {
    return this.jr_rep_tpl;
  }

  public void setJr_rep_tpl(Integer jr_rep_tpl) {
    this.jr_rep_tpl = jr_rep_tpl;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return this.c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name = "jr_rep_tpl_grp", nullable = false)
  public Integer getJr_rep_tpl_grp() {
    return this.jr_rep_tpl_grp;
  }

  public void setJr_rep_tpl_grp(Integer jr_rep_tpl_grp) {
    this.jr_rep_tpl_grp = jr_rep_tpl_grp;
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

  
  @Column(name = "report_path", nullable = false)
  public String getReport_path() {
    return this.report_path;
  }

  public void setReport_path(String report_path) {
    this.report_path = report_path;
  }

  @Column(name = "is_support_only_html", nullable = false)
  public Boolean getIs_support_only_html() {
    return this.is_support_only_html;
  }

  public void setIs_support_only_html(Boolean is_support_only_html) {
    this.is_support_only_html = is_support_only_html;
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
  public Jr_Rep_Tpl_Grp getJr_rep_tpl_grp_t() {
    if (this.jr_rep_tpl_grp_t == null && this.getJr_rep_tpl_grp() != null) {
      this.jr_rep_tpl_grp_t = Jr_Rep_Tpl_Grp_Manager.getCI().get_rec(this.getJr_rep_tpl_grp());
    }
    return this.jr_rep_tpl_grp_t;
  }

  @Transient
  public Jr_Rep_Tpl_Grp getJr_rep_tpl_grp_t_2(Session session_) {
    if (this.jr_rep_tpl_grp_t == null && this.getJr_rep_tpl_grp() != null) {
      this.jr_rep_tpl_grp_t = Jr_Rep_Tpl_Grp_Manager.getCI().get_rec(session_, this.getJr_rep_tpl_grp());
    }
    return this.jr_rep_tpl_grp_t;
  }

  public void setJr_rep_tpl_grp_t(Jr_Rep_Tpl_Grp jr_rep_tpl_grp_t) {
    this.jr_rep_tpl_grp_t = jr_rep_tpl_grp_t;
    this.jr_rep_tpl_grp = (this.jr_rep_tpl_grp_t != null ? this.jr_rep_tpl_grp_t.getJr_rep_tpl_grp() : null);
  }

  @Transient
  public List<Jr_Rep_Tpl_Param> getJr_rep_tpl_param_list() {
    return jr_rep_tpl_param_list;
  }

  public void setJr_rep_tpl_param_list(List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list) {
    this.jr_rep_tpl_param_list = jr_rep_tpl_param_list;
  }

  @Transient
  public String getName_translation() {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(this.getClass().getSimpleName(), (Integer)getEntity_id(), "name", LocaleBean.getCurrentBean().getLanguageTag(), getName());
    }
    return name_translation;
  }

  @Transient
  public String getName_translation_2(Session session_) {
    if (LocaleBean.getCurrentBean().getLanguageTag().equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer)getEntity_id(), "name", LocaleBean.getCurrentBean().getLanguageTag(), getName());
    }
    return name_translation;
  }

  @Transient
  public String getName_translation_3(Session session_, String lang_) {
    if (lang_.equals("ru")) {
      name_translation = getName();
    } else {
      name_translation = I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, this.getClass().getSimpleName(), (Integer)getEntity_id(), "name", lang_, getName());
    }
    return name_translation;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getJr_rep_tpl());
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
    final Jr_Rep_Tpl other = (Jr_Rep_Tpl) obj;
    if (!Objects.equals(this.getJr_rep_tpl(), other.getJr_rep_tpl())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getJr_rep_tpl();
  }

}
