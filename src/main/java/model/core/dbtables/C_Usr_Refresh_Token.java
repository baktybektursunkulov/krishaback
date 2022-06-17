package model.core.dbtables;

import gs.common.model.db.Abstract_Entity;
import gs.repositories.core.dbtables.C_Usr_Repository;
import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;

@Entity
@Table(name = "c_usr_refresh_token")
public class C_Usr_Refresh_Token extends Abstract_Entity {

  private Long c_usr_refresh_token;
  private Long c_usr;
  private String refresh_token;
  private Instant exp_dt;
  private Boolean is_deleted;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_usr_refresh_token", unique = true, nullable = false)
  public Long getC_usr_refresh_token() {
    return c_usr_refresh_token;
  }

  public void setC_usr_refresh_token(Long c_usr_refresh_token) {
    this.c_usr_refresh_token = c_usr_refresh_token;
  }

  @Column(name = "c_usr", nullable = false)
  public Long getC_usr() {
    return c_usr;
  }

  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Column(name = "refresh_token", nullable = false)
  public String getRefresh_token() {
    return refresh_token;
  }

  public void setRefresh_token(String refresh_token) {
    this.refresh_token = refresh_token;
  }

  @Column(name = "exp_dt", nullable = false)
  public Instant getExp_dt() {
    return exp_dt;
  }

  public void setExp_dt(Instant exp_dt) {
    this.exp_dt = exp_dt;
  }

  @Column(name = "is_deleted")
  public Boolean getIs_deleted() {
    return is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  public C_Usr_Refresh_Token() {
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_refresh_token();
  }
}
