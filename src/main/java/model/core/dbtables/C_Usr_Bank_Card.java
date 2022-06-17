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
@Table(name="c_usr_bank_card")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class C_Usr_Bank_Card extends Abstract_Entity {

  //fields
  private Integer c_usr_bank_card;
  private Long c_usr;
  private String card_num;
  private String cardholder_name;
  private Integer valid_month;
  private Integer valid_year;
  private Date ins_dt;
  private Boolean is_verified;
  private Boolean is_deleted;
  private String cvv;
  private Boolean is_primary;

  //transient fields
  private C_Usr c_usr_t = null;


  public C_Usr_Bank_Card() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_usr_bank_card", unique=true, nullable=false)
  public Integer getC_usr_bank_card() {
    return this.c_usr_bank_card;
  }
  public void setC_usr_bank_card(Integer c_usr_bank_card) {
    this.c_usr_bank_card = c_usr_bank_card;
  }

  @Column(name="c_usr", nullable=false)
  public Long getC_usr() {
    return this.c_usr;
  }
  public void setC_usr(Long c_usr) {
    this.c_usr = c_usr;
  }

  @Type(type="text")
  @Column(name="card_num", nullable=false)
  public String getCard_num() {
    return this.card_num;
  }
  public void setCard_num(String card_num) {
    this.card_num = card_num;
  }

  @Type(type="text")
  @Column(name="cardholder_name", nullable=false)
  public String getCardholder_name() {
    return this.cardholder_name;
  }
  public void setCardholder_name(String cardholder_name) {
    this.cardholder_name = cardholder_name;
  }

  @Column(name="valid_month", nullable=false)
  public Integer getValid_month() {
    return this.valid_month;
  }
  public void setValid_month(Integer valid_month) {
    this.valid_month = valid_month;
  }

  @Column(name="valid_year", nullable=false)
  public Integer getValid_year() {
    return this.valid_year;
  }
  public void setValid_year(Integer valid_year) {
    this.valid_year = valid_year;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ins_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }
  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Column(name="is_verified", nullable=false)
  public Boolean getIs_verified() {
    return this.is_verified;
  }
  public void setIs_verified(Boolean is_verified) {
    this.is_verified = is_verified;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Type(type="text")
  @Column(name="cvv", nullable=false)
  public String getCvv() {
    return this.cvv;
  }
  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  @Column(name="is_primary", nullable=false)
  public Boolean getIs_primary() {
    return this.is_primary;
  }
  public void setIs_primary(Boolean is_primary) {
    this.is_primary = is_primary;
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
    this.c_usr = (this.c_usr_t != null?this.c_usr_t.getC_usr():null);
  }











  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_bank_card());
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
    final C_Usr_Bank_Card other = (C_Usr_Bank_Card) obj;
    if (!Objects.equals(this.getC_usr_bank_card(), other.getC_usr_bank_card())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_bank_card();
  }

} 
