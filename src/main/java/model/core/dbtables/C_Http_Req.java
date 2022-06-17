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
@Table(name = "c_http_req")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Http_Req extends Abstract_Entity {

  //fields
  private Integer c_http_req;
  private Integer c_http_req_type;
  private String req_url;
  private String req_body;
  private String req_params;
  private String req_headers;
  private String res_body;
  private Integer res_code;
  private Boolean is_in_req;
  private Date ins_dt;
  private Boolean is_deleted;

  //transient fields
  private C_Http_Req_Type c_http_req_type_t = null;

  public C_Http_Req() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "c_http_req", unique = true, nullable = false)
  public Integer getC_http_req() {
    return this.c_http_req;
  }

  public void setC_http_req(Integer c_http_req) {
    this.c_http_req = c_http_req;
  }

  @Column(name = "c_http_req_type", nullable = false)
  public Integer getC_http_req_type() {
    return this.c_http_req_type;
  }

  public void setC_http_req_type(Integer c_http_req_type) {
    this.c_http_req_type = c_http_req_type;
  }

  
  @Column(name = "req_url", nullable = false)
  public String getReq_url() {
    return this.req_url;
  }

  public void setReq_url(String req_url) {
    this.req_url = req_url;
  }

  
  @Column(name = "req_body")
  public String getReq_body() {
    return this.req_body;
  }

  public void setReq_body(String req_body) {
    this.req_body = req_body;
  }

  
  @Column(name = "req_params")
  public String getReq_params() {
    return this.req_params;
  }

  public void setReq_params(String req_params) {
    this.req_params = req_params;
  }

  
  @Column(name = "req_headers")
  public String getReq_headers() {
    return this.req_headers;
  }

  public void setReq_headers(String req_headers) {
    this.req_headers = req_headers;
  }

  
  @Column(name = "res_body")
  public String getRes_body() {
    return this.res_body;
  }

  public void setRes_body(String res_body) {
    this.res_body = res_body;
  }

  @Column(name = "res_code")
  public Integer getRes_code() {
    return this.res_code;
  }

  public void setRes_code(Integer res_code) {
    this.res_code = res_code;
  }

  @Column(name = "is_in_req", nullable = false)
  public Boolean getIs_in_req() {
    return this.is_in_req;
  }

  public void setIs_in_req(Boolean is_in_req) {
    this.is_in_req = is_in_req;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ins_dt", nullable = false, length = 19, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }

  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public C_Http_Req_Type getC_http_req_type_t() {
    if (this.c_http_req_type_t == null && this.getC_http_req_type() != null) {
      this.c_http_req_type_t = C_Http_Req_Type_Manager.getCI().get_rec(this.getC_http_req_type());
    }
    return this.c_http_req_type_t;
  }

  @Transient
  public C_Http_Req_Type getC_http_req_type_t_2(Session session_) {
    if (this.c_http_req_type_t == null && this.getC_http_req_type() != null) {
      this.c_http_req_type_t = C_Http_Req_Type_Manager.getCI().get_rec(session_, this.getC_http_req_type());
    }
    return this.c_http_req_type_t;
  }

  public void setC_http_req_type_t(C_Http_Req_Type c_http_req_type_t) {
    this.c_http_req_type_t = c_http_req_type_t;
    this.c_http_req_type = (this.c_http_req_type_t != null ? this.c_http_req_type_t.getC_http_req_type() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_http_req());
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
    final C_Http_Req other = (C_Http_Req) obj;
    if (!Objects.equals(this.getC_http_req(), other.getC_http_req())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_http_req();
  }

}
