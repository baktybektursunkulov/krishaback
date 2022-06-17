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
@Table(name = "dc_doc_cont")
@Proxy(lazy = false)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Dc_Doc_Cont extends Abstract_Entity {

  //fields
  private Integer dc_doc_cont;
  private Integer dc_doc;
  private String code;
  private String name;
  private Boolean is_deleted;

  //transient fields
  private Dc_Doc dc_doc_t = null;

  public Dc_Doc_Cont() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dc_doc_cont", unique = true, nullable = false)
  public Integer getDc_doc_cont() {
    return this.dc_doc_cont;
  }

  public void setDc_doc_cont(Integer dc_doc_cont) {
    this.dc_doc_cont = dc_doc_cont;
  }

  @Column(name = "dc_doc", nullable = false)
  public Integer getDc_doc() {
    return this.dc_doc;
  }

  public void setDc_doc(Integer dc_doc) {
    this.dc_doc = dc_doc;
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

  @Column(name = "is_deleted", nullable = false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }

  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Transient
  public Dc_Doc getDc_doc_t() {
    if (this.dc_doc_t == null && this.getDc_doc() != null) {
      this.dc_doc_t = Dc_Doc_Manager.getCI().get_rec(this.getDc_doc());
    }
    return this.dc_doc_t;
  }

  @Transient
  public Dc_Doc getDc_doc_t_2(Session session_) {
    if (this.dc_doc_t == null && this.getDc_doc() != null) {
      this.dc_doc_t = Dc_Doc_Manager.getCI().get_rec(session_, this.getDc_doc());
    }
    return this.dc_doc_t;
  }

  public void setDc_doc_t(Dc_Doc dc_doc_t) {
    this.dc_doc_t = dc_doc_t;
    this.dc_doc = (this.dc_doc_t != null ? this.dc_doc_t.getDc_doc() : null);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getDc_doc_cont());
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
    final Dc_Doc_Cont other = (Dc_Doc_Cont) obj;
    if (!Objects.equals(this.getDc_doc_cont(), other.getDc_doc_cont())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getDc_doc_cont();
  }

}
