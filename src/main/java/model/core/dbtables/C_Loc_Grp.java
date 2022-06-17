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
@Table(name = "c_loc_grp")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Loc_Grp extends Abstract_Entity {

  //fields
  private Integer c_loc_grp;
  private Integer c_country;
  private String name;
  private Boolean is_deleted;

  //transient fields
  private C_Country c_country_t = null;

  public C_Loc_Grp() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_loc_grp", unique = true, nullable = false)
  public Integer getC_loc_grp() {
    return this.c_loc_grp;
  }

  public void setC_loc_grp(Integer c_loc_grp) {
    this.c_loc_grp = c_loc_grp;
  }

  @Column(name = "c_country", nullable = false)
  public Integer getC_country() {
    return c_country;
  }

  public void setC_country(Integer c_country) {
    this.c_country = c_country;
  }

  
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_loc_grp());
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
    final C_Loc_Grp other = (C_Loc_Grp) obj;
    if (!Objects.equals(this.getC_loc_grp(), other.getC_loc_grp())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_loc_grp();
  }

}
