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
@Table(name="c_mob_notif_app")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Mob_Notif_App extends Abstract_Entity {

  //fields
  private Integer c_mob_notif_app;
  private Integer c_proj;
  private String app_package_name;
  private String server_key;
  private Boolean is_deleted;

  //transient fields
  private C_Proj c_proj_t = null;


  public C_Mob_Notif_App() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_mob_notif_app", unique=true, nullable=false)
  public Integer getC_mob_notif_app() {
    return this.c_mob_notif_app;
  }
  public void setC_mob_notif_app(Integer c_mob_notif_app) {
    this.c_mob_notif_app = c_mob_notif_app;
  }

  @Column(name="c_proj", nullable=false)
  public Integer getC_proj() {
    return this.c_proj;
  }
  public void setC_proj(Integer c_proj) {
    this.c_proj = c_proj;
  }

  @Type(type="text")
  @Column(name="app_package_name", nullable=false)
  public String getApp_package_name() {
    return this.app_package_name;
  }
  public void setApp_package_name(String app_package_name) {
    this.app_package_name = app_package_name;
  }

  @Type(type="text")
  @Column(name="server_key", nullable=false)
  public String getServer_key() {
    return this.server_key;
  }
  public void setServer_key(String server_key) {
    this.server_key = server_key;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Proj getC_proj_t() {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(this.getC_proj()); 
    }
    return this.c_proj_t;
  }
  @Transient
  public C_Proj getC_proj_t_2(Session session_) {
    if (this.c_proj_t == null && this.getC_proj() != null) {
      this.c_proj_t = C_Proj_Manager.getCI().get_rec(session_, this.getC_proj()); 
    }
    return this.c_proj_t;
  }
  public void setC_proj_t(C_Proj c_proj_t) {
    this.c_proj_t = c_proj_t;
    this.c_proj = (this.c_proj_t != null?this.c_proj_t.getC_proj():null);
  }





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_mob_notif_app());
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
    final C_Mob_Notif_App other = (C_Mob_Notif_App) obj;
    if (!Objects.equals(this.getC_mob_notif_app(), other.getC_mob_notif_app())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_mob_notif_app();
  }

} 
