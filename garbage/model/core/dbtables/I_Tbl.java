package gs.model.core.dbtables;

import gs.common.hibernate_funcs;
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
import others.CustomLogger;

@Entity
@Table(name = "i_tbl")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class I_Tbl extends Abstract_Entity {

  //fields
  private Integer i_tbl;
  private String name;
  private String pk_fld_name;
  private Boolean has_fld_is_deleted;

  //transient fields
  public I_Tbl() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "i_tbl", unique = true, nullable = false)
  public Integer getI_tbl() {
    return this.i_tbl;
  }

  public void setI_tbl(Integer i_tbl) {
    this.i_tbl = i_tbl;
  }

  @Type(type = "text")
  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Type(type = "text")
  @Column(name = "pk_fld_name", nullable = false)
  public String getPk_fld_name() {
    return this.pk_fld_name;
  }

  public void setPk_fld_name(String pk_fld_name) {
    this.pk_fld_name = pk_fld_name;
  }

  @Column(name = "has_fld_is_deleted", nullable = false)
  public Boolean getHas_fld_is_deleted() {
    return this.has_fld_is_deleted;
  }

  public void setHas_fld_is_deleted(Boolean has_fld_is_deleted) {
    this.has_fld_is_deleted = has_fld_is_deleted;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getI_tbl());
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
    final I_Tbl other = (I_Tbl) obj;
    if (!Objects.equals(this.getI_tbl(), other.getI_tbl())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getI_tbl();
  }

}
