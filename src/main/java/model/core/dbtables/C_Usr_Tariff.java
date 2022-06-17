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
@Table(name="c_usr_tariff")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class C_Usr_Tariff extends Abstract_Entity {

  //fields
  private Integer c_usr_tariff;
  private Long creator_usr;
  private String name;
  private Boolean is_turn_on_bal_acc;
  private Boolean is_block_by_bal;
  private Double block_bal;
  private Boolean is_limit_by_bal;
  private Double limit_bal;
  private Boolean is_turn_on_day_acc;
  private Boolean is_block_by_days;
  private Integer block_days;
  private Boolean has_free_period;
  private Integer free_period_qty;
  private Integer free_period_type;
  private Boolean block_on_exp_free_period;
  private String description;
  private Boolean chg_tariff_on_exp_free_period;
  private Integer exp_free_period_c_usr_tariff;
  private Integer bal_decimal_places_cnt;
  private String bal_currency;
  private Boolean bal_currency_in_front;
  private Integer c_cur;
  private Boolean is_deleted;
  private String custom_fields;

  //transient fields
  private C_Usr creator_usr_t = null;
  private C_Period_Type free_period_type_t = null;
  private C_Usr_Tariff exp_free_period_c_usr_tariff_t = null;
  private C_Cur c_cur_t = null;


  public C_Usr_Tariff() {

  }

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="c_usr_tariff", unique=true, nullable=false)
  public Integer getC_usr_tariff() {
    return this.c_usr_tariff;
  }
  public void setC_usr_tariff(Integer c_usr_tariff) {
    this.c_usr_tariff = c_usr_tariff;
  }

  @Column(name="creator_usr", nullable=false)
  public Long getCreator_usr() {
    return this.creator_usr;
  }
  public void setCreator_usr(Long creator_usr) {
    this.creator_usr = creator_usr;
  }

  @Type(type="text")
  @Column(name="name", nullable=false)
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Column(name="is_turn_on_bal_acc", nullable=false)
  public Boolean getIs_turn_on_bal_acc() {
    return this.is_turn_on_bal_acc;
  }
  public void setIs_turn_on_bal_acc(Boolean is_turn_on_bal_acc) {
    this.is_turn_on_bal_acc = is_turn_on_bal_acc;
  }

  @Column(name="is_block_by_bal", nullable=false)
  public Boolean getIs_block_by_bal() {
    return this.is_block_by_bal;
  }
  public void setIs_block_by_bal(Boolean is_block_by_bal) {
    this.is_block_by_bal = is_block_by_bal;
  }

  @Column(name="block_bal", nullable=false)
  public Double getBlock_bal() {
    return this.block_bal;
  }
  public void setBlock_bal(Double block_bal) {
    this.block_bal = block_bal;
  }

  @Column(name="is_limit_by_bal", nullable=false)
  public Boolean getIs_limit_by_bal() {
    return this.is_limit_by_bal;
  }
  public void setIs_limit_by_bal(Boolean is_limit_by_bal) {
    this.is_limit_by_bal = is_limit_by_bal;
  }

  @Column(name="limit_bal", nullable=false)
  public Double getLimit_bal() {
    return this.limit_bal;
  }
  public void setLimit_bal(Double limit_bal) {
    this.limit_bal = limit_bal;
  }

  @Column(name="is_turn_on_day_acc", nullable=false)
  public Boolean getIs_turn_on_day_acc() {
    return this.is_turn_on_day_acc;
  }
  public void setIs_turn_on_day_acc(Boolean is_turn_on_day_acc) {
    this.is_turn_on_day_acc = is_turn_on_day_acc;
  }

  @Column(name="is_block_by_days", nullable=false)
  public Boolean getIs_block_by_days() {
    return this.is_block_by_days;
  }
  public void setIs_block_by_days(Boolean is_block_by_days) {
    this.is_block_by_days = is_block_by_days;
  }

  @Column(name="block_days", nullable=false)
  public Integer getBlock_days() {
    return this.block_days;
  }
  public void setBlock_days(Integer block_days) {
    this.block_days = block_days;
  }

  @Column(name="has_free_period", nullable=false)
  public Boolean getHas_free_period() {
    return this.has_free_period;
  }
  public void setHas_free_period(Boolean has_free_period) {
    this.has_free_period = has_free_period;
  }

  @Column(name="free_period_qty", nullable=false)
  public Integer getFree_period_qty() {
    return this.free_period_qty;
  }
  public void setFree_period_qty(Integer free_period_qty) {
    this.free_period_qty = free_period_qty;
  }

  @Column(name="free_period_type")
  public Integer getFree_period_type() {
    return this.free_period_type;
  }
  public void setFree_period_type(Integer free_period_type) {
    this.free_period_type = free_period_type;
  }

  @Column(name="block_on_exp_free_period", nullable=false)
  public Boolean getBlock_on_exp_free_period() {
    return this.block_on_exp_free_period;
  }
  public void setBlock_on_exp_free_period(Boolean block_on_exp_free_period) {
    this.block_on_exp_free_period = block_on_exp_free_period;
  }

  @Type(type="text")
  @Column(name="description")
  public String getDescription() {
    return this.description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name="chg_tariff_on_exp_free_period", nullable=false)
  public Boolean getChg_tariff_on_exp_free_period() {
    return this.chg_tariff_on_exp_free_period;
  }
  public void setChg_tariff_on_exp_free_period(Boolean chg_tariff_on_exp_free_period) {
    this.chg_tariff_on_exp_free_period = chg_tariff_on_exp_free_period;
  }

  @Column(name="exp_free_period_c_usr_tariff")
  public Integer getExp_free_period_c_usr_tariff() {
    return this.exp_free_period_c_usr_tariff;
  }
  public void setExp_free_period_c_usr_tariff(Integer exp_free_period_c_usr_tariff) {
    this.exp_free_period_c_usr_tariff = exp_free_period_c_usr_tariff;
  }

  @Column(name="bal_decimal_places_cnt", nullable=false)
  public Integer getBal_decimal_places_cnt() {
    return this.bal_decimal_places_cnt;
  }
  public void setBal_decimal_places_cnt(Integer bal_decimal_places_cnt) {
    this.bal_decimal_places_cnt = bal_decimal_places_cnt;
  }

  @Type(type="text")
  @Column(name="bal_currency", nullable=false)
  public String getBal_currency() {
    return this.bal_currency;
  }
  public void setBal_currency(String bal_currency) {
    this.bal_currency = bal_currency;
  }

  @Column(name="bal_currency_in_front", nullable=false)
  public Boolean getBal_currency_in_front() {
    return this.bal_currency_in_front;
  }
  public void setBal_currency_in_front(Boolean bal_currency_in_front) {
    this.bal_currency_in_front = bal_currency_in_front;
  }

  @Column(name="c_cur", nullable=false)
  public Integer getC_cur() {
    return this.c_cur;
  }
  public void setC_cur(Integer c_cur) {
    this.c_cur = c_cur;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Type(type="text")
  @Column(name="custom_fields")
  public String getCustom_fields() {
    return this.custom_fields;
  }
  public void setCustom_fields(String custom_fields) {
    this.custom_fields = custom_fields;
  }


  @Transient
  public C_Usr getCreator_usr_t() {
    if (this.creator_usr_t == null && this.getCreator_usr() != null) {
      this.creator_usr_t = C_Usr_Manager.getCI().get_rec(this.getCreator_usr()); 
    }
    return this.creator_usr_t;
  }
  @Transient
  public C_Usr getCreator_usr_t_2(Session session_) {
    if (this.creator_usr_t == null && this.getCreator_usr() != null) {
      this.creator_usr_t = C_Usr_Manager.getCI().get_rec(session_, this.getCreator_usr()); 
    }
    return this.creator_usr_t;
  }
  public void setCreator_usr_t(C_Usr creator_usr_t) {
    this.creator_usr_t = creator_usr_t;
    this.creator_usr = (this.creator_usr_t != null?this.creator_usr_t.getC_usr():null);
  }












  @Transient
  public C_Period_Type getFree_period_type_t() {
    if (this.free_period_type_t == null && this.getFree_period_type() != null) {
      this.free_period_type_t = C_Period_Type_Manager.getCI().get_rec(this.getFree_period_type()); 
    }
    return this.free_period_type_t;
  }
  @Transient
  public C_Period_Type getFree_period_type_t_2(Session session_) {
    if (this.free_period_type_t == null && this.getFree_period_type() != null) {
      this.free_period_type_t = C_Period_Type_Manager.getCI().get_rec(session_, this.getFree_period_type()); 
    }
    return this.free_period_type_t;
  }
  public void setFree_period_type_t(C_Period_Type free_period_type_t) {
    this.free_period_type_t = free_period_type_t;
    this.free_period_type = (this.free_period_type_t != null?this.free_period_type_t.getC_period_type():null);
  }




  @Transient
  public C_Usr_Tariff getExp_free_period_c_usr_tariff_t() {
    if (this.exp_free_period_c_usr_tariff_t == null && this.getExp_free_period_c_usr_tariff() != null) {
      this.exp_free_period_c_usr_tariff_t = C_Usr_Tariff_Manager.getCI().get_rec(this.getExp_free_period_c_usr_tariff()); 
    }
    return this.exp_free_period_c_usr_tariff_t;
  }
  @Transient
  public C_Usr_Tariff getExp_free_period_c_usr_tariff_t_2(Session session_) {
    if (this.exp_free_period_c_usr_tariff_t == null && this.getExp_free_period_c_usr_tariff() != null) {
      this.exp_free_period_c_usr_tariff_t = C_Usr_Tariff_Manager.getCI().get_rec(session_, this.getExp_free_period_c_usr_tariff()); 
    }
    return this.exp_free_period_c_usr_tariff_t;
  }
  public void setExp_free_period_c_usr_tariff_t(C_Usr_Tariff exp_free_period_c_usr_tariff_t) {
    this.exp_free_period_c_usr_tariff_t = exp_free_period_c_usr_tariff_t;
    this.exp_free_period_c_usr_tariff = (this.exp_free_period_c_usr_tariff_t != null?this.exp_free_period_c_usr_tariff_t.getExp_free_period_c_usr_tariff():null);
  }




  @Transient
  public C_Cur getC_cur_t() {
    if (this.c_cur_t == null && this.getC_cur() != null) {
      this.c_cur_t = C_Cur_Manager.getCI().get_rec(this.getC_cur()); 
    }
    return this.c_cur_t;
  }
  @Transient
  public C_Cur getC_cur_t_2(Session session_) {
    if (this.c_cur_t == null && this.getC_cur() != null) {
      this.c_cur_t = C_Cur_Manager.getCI().get_rec(session_, this.getC_cur()); 
    }
    return this.c_cur_t;
  }
  public void setC_cur_t(C_Cur c_cur_t) {
    this.c_cur_t = c_cur_t;
    this.c_cur = (this.c_cur_t != null?this.c_cur_t.getC_cur():null);
  }




  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getC_usr_tariff());
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
    final C_Usr_Tariff other = (C_Usr_Tariff) obj;
    if (!Objects.equals(this.getC_usr_tariff(), other.getC_usr_tariff())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getC_usr_tariff();
  }

} 
