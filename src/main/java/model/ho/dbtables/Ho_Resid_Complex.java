package model.ho.dbtables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import managers.core.dbtables.C_Loc_Manager;
import model.core.dbtables.*;
import org.hibernate.Session;

@Entity
@Table(name="ho_resid_complex")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Ho_Resid_Complex extends Abstract_Entity {

  //fields
  private Integer ho_resid_complex;
  private Integer c_loc;
  private String name;
  private Boolean is_deleted;

  //transient fields
  private C_Loc c_loc_t = null;



  public Ho_Resid_Complex() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ho_resid_complex", unique=true, nullable=false)
  public Integer getHo_resid_complex() {
    return this.ho_resid_complex;
  }
  public void setHo_resid_complex(Integer ho_resid_complex) {
    this.ho_resid_complex = ho_resid_complex;
  }

  @Column(name="c_loc", nullable=false)
  public Integer getC_loc() {
    return this.c_loc;
  }
  public void setC_loc(Integer c_loc) {
    this.c_loc = c_loc;
  }

  @Type(type="text")
  @Column(name="name", nullable=false)
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Loc getC_loc_t() {
    if (this.c_loc_t == null && this.getC_loc() != null) {
      this.c_loc_t = C_Loc_Manager.getCI().get_rec(this.getC_loc()); 
    }
    return this.c_loc_t;
  }
  
  public void setC_loc_t(C_Loc c_loc_t) {
    this.c_loc_t = c_loc_t;
    this.c_loc = (this.c_loc_t != null?this.c_loc_t.getC_loc():null);
  }




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getHo_resid_complex());
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
    final Ho_Resid_Complex other = (Ho_Resid_Complex) obj;
    if (!Objects.equals(this.getHo_resid_complex(), other.getHo_resid_complex())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_resid_complex();
  }

} 
