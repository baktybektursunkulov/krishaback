package model.ho.dbtables;

import model.core.dbtables.*;
import beans.LocaleBean;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import gs.services.core.dbtables.C_Lang_Service;
//import java.util.Locale;
import managers.core.dbtables.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import others.core_lang_funcs;

@Entity
@Table(name = "ho_cat")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Ho_Cat extends Abstract_Entity {

  //fields
  private Integer ho_cat;
  private String name;
  private Boolean is_deleted;
  private Integer parent_id;
  private String page_title;
  private String plural_name;
  private String singular_name;
  private Integer order_num;
  private String opposite_verb_in_past;

  public Ho_Cat() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ho_cat", unique = true, nullable = false)
  public Integer getHo_cat() {
    return this.ho_cat;
  }

  public void setHo_cat(Integer ca_cat) {
    this.ho_cat = ca_cat;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonIgnore
  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name = "parent_id")
  public Integer getParent_id() {
    return parent_id;
  }

  public void setParent_id(Integer parent_id) {
    this.parent_id = parent_id;
  }
  @Column(name = "page_title")
  public String getPage_title() {
    return page_title;
  }

  public void setPage_title(String page_title) {
    this.page_title = page_title;
  }
  
  @Column(name = "plural_name")
   public String getPlural_name() {
    return plural_name;
  }

  public void setPlural_name(String plural_name) {
    this.plural_name = plural_name;
  }

  @Column(name = "singular_name")
  public String getSingular_name() {
    return singular_name;
  }

  public void setSingular_name(String singular_name) {
    this.singular_name = singular_name;
  }
  
  @Column(name = "order_num")
  public Integer getOrder_num() {
    return order_num;
  }

  public void setOrder_num(Integer order_num) {
    this.order_num = order_num;
  }

  @Column(name = "opposite_verb_in_past")
  public String getOpposite_verb_in_past() {
    return opposite_verb_in_past;
  }

  public void setOpposite_verb_in_past(String opposite_verb_in_past) {
    this.opposite_verb_in_past = opposite_verb_in_past;
  }
  
  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getHo_cat());
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
    final Ho_Cat other = (Ho_Cat) obj;
    if (!Objects.equals(this.getHo_cat(), other.getHo_cat())) {
      return false;
    }
    return true;
  }

  @JsonIgnore
  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_cat();
  }

}
