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
@Table(name="c_chat_sql")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Chat_Sql extends Abstract_Entity {

  //fields
  private Integer c_chat_sql;
  private Integer c_tbl;
  private String name_sql;
  private String img_sql;
  private Boolean is_deleted;

  //transient fields
  private C_Tbl c_tbl_t = null;



  public C_Chat_Sql() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_chat_sql", unique=true, nullable=false)
  public Integer getC_chat_sql() {
    return this.c_chat_sql;
  }
  public void setC_chat_sql(Integer c_chat_sql) {
    this.c_chat_sql = c_chat_sql;
  }

  @Column(name="c_tbl", nullable=false)
  public Integer getC_tbl() {
    return this.c_tbl;
  }
  public void setC_tbl(Integer c_tbl) {
    this.c_tbl = c_tbl;
  }

  @Type(type="text")
  @Column(name="name_sql", nullable=false)
  public String getName_sql() {
    return this.name_sql;
  }
  public void setName_sql(String name_sql) {
    this.name_sql = name_sql;
  }

  @Type(type="text")
  @Column(name="img_sql")
  public String getImg_sql() {
    return this.img_sql;
  }
  public void setImg_sql(String img_sql) {
    this.img_sql = img_sql;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }


  @Transient
  public C_Tbl getC_tbl_t() {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(this.getC_tbl()); 
    }
    return this.c_tbl_t;
  }
  @Transient
  public C_Tbl getC_tbl_t_2(Session session_) {
    if (this.c_tbl_t == null && this.getC_tbl() != null) {
      this.c_tbl_t = C_Tbl_Manager.getCI().get_rec(session_, this.getC_tbl()); 
    }
    return this.c_tbl_t;
  }
  public void setC_tbl_t(C_Tbl c_tbl_t) {
    this.c_tbl_t = c_tbl_t;
    this.c_tbl = (this.c_tbl_t != null?this.c_tbl_t.getC_tbl():null);
  }





  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_chat_sql());
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
    final C_Chat_Sql other = (C_Chat_Sql) obj;
    if (!Objects.equals(this.getC_chat_sql(), other.getC_chat_sql())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_chat_sql();
  }

} 
