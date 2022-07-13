
package model.ho.dbtables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import managers.core.dbtables.*;
import managers.ho.dbtables.*;
import org.hibernate.Session;
import model.core.dbtables.*;

@Entity
@Table(name="ho_ad")
@Proxy(lazy=false) 
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  
public class Ho_Ad extends Abstract_Entity {

  //fields
  private Integer ho_ad;
  private Integer c_country;
  private Integer ho_cat;
  private Integer room_cnt;
  private Double price;
  private Boolean is_pledged;
  private Integer ho_build_type;
  private Integer construction_year;
  private Integer floor;
  private Integer max_floor;
  private Double total_area;
  private Double living_area;
  private Double kitchen_area;
  private Boolean is_in_priv_hostel;
  private Integer c_loc;
  private Integer ho_resid_complex;
  private String street_name;
  private String house_num;
  private String intersection;
  private Boolean is_hide_house_num;
  private Double lat;
  private Double lon;
  private Integer ho_house_condition;
  private Integer ho_house_phone;
  private Integer ho_house_inet;
  private Integer ho_house_bathroom;
  private Integer ho_house_balcony;
  private Boolean is_balcony_glazed;
  private Integer ho_house_door;
  private Integer ho_house_parking;
  private Integer ho_house_furniture;
  private Integer ho_house_floor;
  private Double ceiling_height;
  private String txt;
  private Integer ho_contact_info_type;
  private String contact_name;
  private Boolean is_exch_possible;
  private Boolean is_agree_with_rules;
  private Date ins_dt;
  private Date publish_dt;
  private Integer ho_ad_status;
  private Boolean is_deleted;
  private Integer level_num;
  private Double land_area;
  private String how_area_fenced;
  private Integer ho_house_sewerage;
  private Integer ho_house_drink_water;
  private Integer ho_house_electricity;
  private Integer ho_house_heating;
  private Integer ho_house_gas;
  private String roofing;
  private String suburban_area_name;
  private Double house_area;
  private Integer ho_house_irrigation_water;
  private Integer ho_house_office_type;
  private String business_center_name;
  private Integer phone_lines_num;
  private String parking;
  private Boolean is_has_sep_entr_group;
  private Double adj_territory_area;
  private Integer ho_house_shop_type;
  private Integer ho_house_loc;
  private String shop_center_name;
  private Integer ho_house_indus_base_type;
  private Double territory_area;
  private Integer territory_area_unit;
  private Double production_area;
  private Double production_area_ceiling_height;
  private Double warehouse_area;
  private Double warehouse_ceiling_height;
  private Double office_area;
  private Boolean is_has_railway_siding;
  private Double max_power_consumption;
  private Boolean is_has_own_substation;
  private Integer ho_house_land_price;
  private Boolean is_divisible;
  private Integer ho_house_spec_purpose;
  private String title;
  private Boolean is_operating_business;
  private Integer ho_house_rent_period;
  private Long ho_usr;

  //transient fields
  private C_Country c_country_t = null;
  private Ho_Cat ho_cat_t = null;
  private Ho_Build_Type ho_build_type_t = null;
  private C_Loc c_loc_t = null;
  private Ho_Resid_Complex ho_resid_complex_t = null;
  private Ho_House_Condition ho_house_condition_t = null;
  private Ho_House_Phone ho_house_phone_t = null;
  private Ho_House_Inet ho_house_inet_t = null;
  private Ho_House_Bathroom ho_house_bathroom_t = null;
  private Ho_House_Balcony ho_house_balcony_t = null;
  private Ho_House_Door ho_house_door_t = null;
  private Ho_House_Parking ho_house_parking_t = null;
  private Ho_House_Furniture ho_house_furniture_t = null;
  private Ho_House_Floor ho_house_floor_t = null;
  private Ho_Contact_Info_Type ho_contact_info_type_t = null;
  private Ho_Ad_Status ho_ad_status_t = null;
  private Ho_House_Sewerage ho_house_sewerage_t = null;
  private Ho_House_Drink_Water ho_house_drink_water_t = null;
  private Ho_House_Electricity ho_house_electricity_t = null;
  private Ho_House_Heating ho_house_heating_t = null;
  private Ho_House_Gas ho_house_gas_t = null;
  private Ho_House_Irrigation_Water ho_house_irrigation_water_t = null;
  private Ho_House_Office_Type ho_house_office_type_t = null;
  private Ho_House_Shop_Type ho_house_shop_type_t = null;
  private Ho_House_Loc ho_house_loc_t = null;
  private Ho_House_Indus_Base_Type ho_house_indus_base_type_t = null;
  private C_Land_Area_Unit territory_area_unit_t = null;
  private Ho_House_Land_Price ho_house_land_price_t = null;
  private Ho_House_Spec_Purpose ho_house_spec_purpose_t = null;
  private Ho_House_Rent_Period ho_house_rent_period_t = null;
  private Ho_Usr ho_usr_t = null;



  public Ho_Ad() {

}

  //fields getter and setter methods
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ho_ad", unique=true, nullable=false)
  public Integer getHo_ad() {
    return this.ho_ad;
  }
  public void setHo_ad(Integer ho_ad) {
    this.ho_ad = ho_ad;
  }

  @Column(name="c_country", nullable=false)
  public Integer getC_country() {
    return this.c_country;
  }
  public void setC_country(Integer c_country) {
    this.c_country = c_country;
  }

  @Column(name="ho_cat", nullable=false)
  public Integer getHo_cat() {
    return this.ho_cat;
  }
  public void setHo_cat(Integer ho_cat) {
    this.ho_cat = ho_cat;
  }

  @Column(name="room_cnt")
  public Integer getRoom_cnt() {
    return this.room_cnt;
  }
  public void setRoom_cnt(Integer room_cnt) {
    this.room_cnt = room_cnt;
  }

  @Column(name="price")
  public Double getPrice() {
    return this.price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }

  @Column(name="is_pledged")
  public Boolean getIs_pledged() {
    return this.is_pledged;
  }
  public void setIs_pledged(Boolean is_pledged) {
    this.is_pledged = is_pledged;
  }

  @Column(name="ho_build_type")
  public Integer getHo_build_type() {
    return this.ho_build_type;
  }
  public void setHo_build_type(Integer ho_build_type) {
    this.ho_build_type = ho_build_type;
  }

  @Column(name="construction_year")
  public Integer getConstruction_year() {
    return this.construction_year;
  }
  public void setConstruction_year(Integer construction_year) {
    this.construction_year = construction_year;
  }

  @Column(name="floor")
  public Integer getFloor() {
    return this.floor;
  }
  public void setFloor(Integer floor) {
    this.floor = floor;
  }

  @Column(name="max_floor")
  public Integer getMax_floor() {
    return this.max_floor;
  }
  public void setMax_floor(Integer max_floor) {
    this.max_floor = max_floor;
  }

  @Column(name="total_area")
  public Double getTotal_area() {
    return this.total_area;
  }
  public void setTotal_area(Double total_area) {
    this.total_area = total_area;
  }

  @Column(name="living_area")
  public Double getLiving_area() {
    return this.living_area;
  }
  public void setLiving_area(Double living_area) {
    this.living_area = living_area;
  }

  @Column(name="kitchen_area")
  public Double getKitchen_area() {
    return this.kitchen_area;
  }
  public void setKitchen_area(Double kitchen_area) {
    this.kitchen_area = kitchen_area;
  }

  @Column(name="is_in_priv_hostel")
  public Boolean getIs_in_priv_hostel() {
    return this.is_in_priv_hostel;
  }
  public void setIs_in_priv_hostel(Boolean is_in_priv_hostel) {
    this.is_in_priv_hostel = is_in_priv_hostel;
  }

  @Column(name="c_loc", nullable=false)
  public Integer getC_loc() {
    return this.c_loc;
  }
  public void setC_loc(Integer c_loc) {
    this.c_loc = c_loc;
  }

  @Column(name="ho_resid_complex")
  public Integer getHo_resid_complex() {
    return this.ho_resid_complex;
  }
  public void setHo_resid_complex(Integer ho_resid_complex) {
    this.ho_resid_complex = ho_resid_complex;
  }

  @Type(type="text")
  @Column(name="street_name")
  public String getStreet_name() {
    return this.street_name;
  }
  public void setStreet_name(String street_name) {
    this.street_name = street_name;
  }

  @Type(type="text")
  @Column(name="house_num")
  public String getHouse_num() {
    return this.house_num;
  }
  public void setHouse_num(String house_num) {
    this.house_num = house_num;
  }

  @Type(type="text")
  @Column(name="intersection")
  public String getIntersection() {
    return this.intersection;
  }
  public void setIntersection(String intersection) {
    this.intersection = intersection;
  }

  @Column(name="is_hide_house_num")
  public Boolean getIs_hide_house_num() {
    return this.is_hide_house_num;
  }
  public void setIs_hide_house_num(Boolean is_hide_house_num) {
    this.is_hide_house_num = is_hide_house_num;
  }

  @Column(name="lat")
  public Double getLat() {
    return this.lat;
  }
  public void setLat(Double lat) {
    this.lat = lat;
  }

  @Column(name="lon")
  public Double getLon() {
    return this.lon;
  }
  public void setLon(Double lon) {
    this.lon = lon;
  }

  @Column(name="ho_house_condition")
  public Integer getHo_house_condition() {
    return this.ho_house_condition;
  }
  public void setHo_house_condition(Integer ho_house_condition) {
    this.ho_house_condition = ho_house_condition;
  }

  @Column(name="ho_house_phone")
  public Integer getHo_house_phone() {
    return this.ho_house_phone;
  }
  public void setHo_house_phone(Integer ho_house_phone) {
    this.ho_house_phone = ho_house_phone;
  }

  @Column(name="ho_house_inet")
  public Integer getHo_house_inet() {
    return this.ho_house_inet;
  }
  public void setHo_house_inet(Integer ho_house_inet) {
    this.ho_house_inet = ho_house_inet;
  }

  @Column(name="ho_house_bathroom")
  public Integer getHo_house_bathroom() {
    return this.ho_house_bathroom;
  }
  public void setHo_house_bathroom(Integer ho_house_bathroom) {
    this.ho_house_bathroom = ho_house_bathroom;
  }

  @Column(name="ho_house_balcony")
  public Integer getHo_house_balcony() {
    return this.ho_house_balcony;
  }
  public void setHo_house_balcony(Integer ho_house_balcony) {
    this.ho_house_balcony = ho_house_balcony;
  }

  @Column(name="is_balcony_glazed")
  public Boolean getIs_balcony_glazed() {
    return this.is_balcony_glazed;
  }
  public void setIs_balcony_glazed(Boolean is_balcony_glazed) {
    this.is_balcony_glazed = is_balcony_glazed;
  }

  @Column(name="ho_house_door")
  public Integer getHo_house_door() {
    return this.ho_house_door;
  }
  public void setHo_house_door(Integer ho_house_door) {
    this.ho_house_door = ho_house_door;
  }

  @Column(name="ho_house_parking")
  public Integer getHo_house_parking() {
    return this.ho_house_parking;
  }
  public void setHo_house_parking(Integer ho_house_parking) {
    this.ho_house_parking = ho_house_parking;
  }

  @Column(name="ho_house_furniture")
  public Integer getHo_house_furniture() {
    return this.ho_house_furniture;
  }
  public void setHo_house_furniture(Integer ho_house_furniture) {
    this.ho_house_furniture = ho_house_furniture;
  }

  @Column(name="ho_house_floor")
  public Integer getHo_house_floor() {
    return this.ho_house_floor;
  }
  public void setHo_house_floor(Integer ho_house_floor) {
    this.ho_house_floor = ho_house_floor;
  }

  @Column(name="ceiling_height")
  public Double getCeiling_height() {
    return this.ceiling_height;
  }
  public void setCeiling_height(Double ceiling_height) {
    this.ceiling_height = ceiling_height;
  }

  @Type(type="text")
  @Column(name="txt")
  public String getTxt() {
    return this.txt;
  }
  public void setTxt(String txt) {
    this.txt = txt;
  }

  @Column(name="ho_contact_info_type")
  public Integer getHo_contact_info_type() {
    return this.ho_contact_info_type;
  }
  public void setHo_contact_info_type(Integer ho_contact_info_type) {
    this.ho_contact_info_type = ho_contact_info_type;
  }

  @Type(type="text")
  @Column(name="contact_name")
  public String getContact_name() {
    return this.contact_name;
  }
  public void setContact_name(String contact_name) {
    this.contact_name = contact_name;
  }

  @Column(name="is_exch_possible")
  public Boolean getIs_exch_possible() {
    return this.is_exch_possible;
  }
  public void setIs_exch_possible(Boolean is_exch_possible) {
    this.is_exch_possible = is_exch_possible;
  }

  @Column(name="is_agree_with_rules", nullable=false)
  public Boolean getIs_agree_with_rules() {
    return this.is_agree_with_rules;
  }
  public void setIs_agree_with_rules(Boolean is_agree_with_rules) {
    this.is_agree_with_rules = is_agree_with_rules;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ins_dt", nullable=false, length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getIns_dt() {
    return this.ins_dt;
  }
  public void setIns_dt(Date ins_dt) {
    this.ins_dt = ins_dt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="publish_dt", length = 19, columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
  public Date getPublish_dt() {
    return this.publish_dt;
  }
  public void setPublish_dt(Date publish_dt) {
    this.publish_dt = publish_dt;
  }

  @Column(name="ho_ad_status", nullable=false)
  public Integer getHo_ad_status() {
    return this.ho_ad_status;
  }
  public void setHo_ad_status(Integer ho_ad_status) {
    this.ho_ad_status = ho_ad_status;
  }

  @Column(name="is_deleted", nullable=false)
  public Boolean getIs_deleted() {
    return this.is_deleted;
  }
  public void setIs_deleted(Boolean is_deleted) {
    this.is_deleted = is_deleted;
  }

  @Column(name="level_num")
  public Integer getLevel_num() {
    return this.level_num;
  }
  public void setLevel_num(Integer level_num) {
    this.level_num = level_num;
  }

  @Column(name="land_area")
  public Double getLand_area() {
    return this.land_area;
  }
  public void setLand_area(Double land_area) {
    this.land_area = land_area;
  }

  @Type(type="text")
  @Column(name="how_area_fenced")
  public String getHow_area_fenced() {
    return this.how_area_fenced;
  }
  public void setHow_area_fenced(String how_area_fenced) {
    this.how_area_fenced = how_area_fenced;
  }

  @Column(name="ho_house_sewerage")
  public Integer getHo_house_sewerage() {
    return this.ho_house_sewerage;
  }
  public void setHo_house_sewerage(Integer ho_house_sewerage) {
    this.ho_house_sewerage = ho_house_sewerage;
  }

  @Column(name="ho_house_drink_water")
  public Integer getHo_house_drink_water() {
    return this.ho_house_drink_water;
  }
  public void setHo_house_drink_water(Integer ho_house_drink_water) {
    this.ho_house_drink_water = ho_house_drink_water;
  }

  @Column(name="ho_house_electricity")
  public Integer getHo_house_electricity() {
    return this.ho_house_electricity;
  }
  public void setHo_house_electricity(Integer ho_house_electricity) {
    this.ho_house_electricity = ho_house_electricity;
  }

  @Column(name="ho_house_heating")
  public Integer getHo_house_heating() {
    return this.ho_house_heating;
  }
  public void setHo_house_heating(Integer ho_house_heating) {
    this.ho_house_heating = ho_house_heating;
  }

  @Column(name="ho_house_gas")
  public Integer getHo_house_gas() {
    return this.ho_house_gas;
  }
  public void setHo_house_gas(Integer ho_house_gas) {
    this.ho_house_gas = ho_house_gas;
  }

  @Type(type="text")
  @Column(name="roofing")
  public String getRoofing() {
    return this.roofing;
  }
  public void setRoofing(String roofing) {
    this.roofing = roofing;
  }

  @Type(type="text")
  @Column(name="suburban_area_name")
  public String getSuburban_area_name() {
    return this.suburban_area_name;
  }
  public void setSuburban_area_name(String suburban_area_name) {
    this.suburban_area_name = suburban_area_name;
  }

  @Column(name="house_area")
  public Double getHouse_area() {
    return this.house_area;
  }
  public void setHouse_area(Double house_area) {
    this.house_area = house_area;
  }

  @Column(name="ho_house_irrigation_water")
  public Integer getHo_house_irrigation_water() {
    return this.ho_house_irrigation_water;
  }
  public void setHo_house_irrigation_water(Integer ho_house_irrigation_water) {
    this.ho_house_irrigation_water = ho_house_irrigation_water;
  }

  @Column(name="ho_house_office_type")
  public Integer getHo_house_office_type() {
    return this.ho_house_office_type;
  }
  public void setHo_house_office_type(Integer ho_house_office_type) {
    this.ho_house_office_type = ho_house_office_type;
  }

  @Type(type="text")
  @Column(name="business_center_name")
  public String getBusiness_center_name() {
    return this.business_center_name;
  }
  public void setBusiness_center_name(String business_center_name) {
    this.business_center_name = business_center_name;
  }

  @Column(name="phone_lines_num")
  public Integer getPhone_lines_num() {
    return this.phone_lines_num;
  }
  public void setPhone_lines_num(Integer phone_lines_num) {
    this.phone_lines_num = phone_lines_num;
  }

  @Type(type="text")
  @Column(name="parking")
  public String getParking() {
    return this.parking;
  }
  public void setParking(String parking) {
    this.parking = parking;
  }

  @Column(name="is_has_sep_entr_group")
  public Boolean getIs_has_sep_entr_group() {
    return this.is_has_sep_entr_group;
  }
  public void setIs_has_sep_entr_group(Boolean is_has_sep_entr_group) {
    this.is_has_sep_entr_group = is_has_sep_entr_group;
  }

  @Column(name="adj_territory_area")
  public Double getAdj_territory_area() {
    return this.adj_territory_area;
  }
  public void setAdj_territory_area(Double adj_territory_area) {
    this.adj_territory_area = adj_territory_area;
  }

  @Column(name="ho_house_shop_type")
  public Integer getHo_house_shop_type() {
    return this.ho_house_shop_type;
  }
  public void setHo_house_shop_type(Integer ho_house_shop_type) {
    this.ho_house_shop_type = ho_house_shop_type;
  }

  @Column(name="ho_house_loc")
  public Integer getHo_house_loc() {
    return this.ho_house_loc;
  }
  public void setHo_house_loc(Integer ho_house_loc) {
    this.ho_house_loc = ho_house_loc;
  }

  @Type(type="text")
  @Column(name="shop_center_name")
  public String getShop_center_name() {
    return this.shop_center_name;
  }
  public void setShop_center_name(String shop_center_name) {
    this.shop_center_name = shop_center_name;
  }

  @Column(name="ho_house_indus_base_type")
  public Integer getHo_house_indus_base_type() {
    return this.ho_house_indus_base_type;
  }
  public void setHo_house_indus_base_type(Integer ho_house_indus_base_type) {
    this.ho_house_indus_base_type = ho_house_indus_base_type;
  }

  @Column(name="territory_area")
  public Double getTerritory_area() {
    return this.territory_area;
  }
  public void setTerritory_area(Double territory_area) {
    this.territory_area = territory_area;
  }

  @Column(name="territory_area_unit")
  public Integer getTerritory_area_unit() {
    return this.territory_area_unit;
  }
  public void setTerritory_area_unit(Integer territory_area_unit) {
    this.territory_area_unit = territory_area_unit;
  }

  @Column(name="production_area")
  public Double getProduction_area() {
    return this.production_area;
  }
  public void setProduction_area(Double production_area) {
    this.production_area = production_area;
  }

  @Column(name="production_area_ceiling_height")
  public Double getProduction_area_ceiling_height() {
    return this.production_area_ceiling_height;
  }
  public void setProduction_area_ceiling_height(Double production_area_ceiling_height) {
    this.production_area_ceiling_height = production_area_ceiling_height;
  }

  @Column(name="warehouse_area")
  public Double getWarehouse_area() {
    return this.warehouse_area;
  }
  public void setWarehouse_area(Double warehouse_area) {
    this.warehouse_area = warehouse_area;
  }

  @Column(name="warehouse_ceiling_height")
  public Double getWarehouse_ceiling_height() {
    return this.warehouse_ceiling_height;
  }
  public void setWarehouse_ceiling_height(Double warehouse_ceiling_height) {
    this.warehouse_ceiling_height = warehouse_ceiling_height;
  }

  @Column(name="office_area")
  public Double getOffice_area() {
    return this.office_area;
  }
  public void setOffice_area(Double office_area) {
    this.office_area = office_area;
  }

  @Column(name="is_has_railway_siding")
  public Boolean getIs_has_railway_siding() {
    return this.is_has_railway_siding;
  }
  public void setIs_has_railway_siding(Boolean is_has_railway_siding) {
    this.is_has_railway_siding = is_has_railway_siding;
  }

  @Column(name="max_power_consumption")
  public Double getMax_power_consumption() {
    return this.max_power_consumption;
  }
  public void setMax_power_consumption(Double max_power_consumption) {
    this.max_power_consumption = max_power_consumption;
  }

  @Column(name="is_has_own_substation")
  public Boolean getIs_has_own_substation() {
    return this.is_has_own_substation;
  }
  public void setIs_has_own_substation(Boolean is_has_own_substation) {
    this.is_has_own_substation = is_has_own_substation;
  }

  @Column(name="ho_house_land_price")
  public Integer getHo_house_land_price() {
    return this.ho_house_land_price;
  }
  public void setHo_house_land_price(Integer ho_house_land_price) {
    this.ho_house_land_price = ho_house_land_price;
  }

  @Column(name="is_divisible")
  public Boolean getIs_divisible() {
    return this.is_divisible;
  }
  public void setIs_divisible(Boolean is_divisible) {
    this.is_divisible = is_divisible;
  }

  @Column(name="ho_house_spec_purpose")
  public Integer getHo_house_spec_purpose() {
    return this.ho_house_spec_purpose;
  }
  public void setHo_house_spec_purpose(Integer ho_house_spec_purpose) {
    this.ho_house_spec_purpose = ho_house_spec_purpose;
  }

  @Type(type="text")
  @Column(name="title")
  public String getTitle() {
    return this.title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  @Column(name="is_operating_business")
  public Boolean getIs_operating_business() {
    return this.is_operating_business;
  }
  public void setIs_operating_business(Boolean is_operating_business) {
    this.is_operating_business = is_operating_business;
  }

  @Column(name="ho_house_rent_period")
  public Integer getHo_house_rent_period() {
    return this.ho_house_rent_period;
  }
  public void setHo_house_rent_period(Integer ho_house_rent_period) {
    this.ho_house_rent_period = ho_house_rent_period;
  }

  @Column(name="ho_usr", nullable=false)
  public Long getHo_usr() {
    return this.ho_usr;
  }
  public void setHo_usr(Long ho_usr) {
    this.ho_usr = ho_usr;
  }


  @Transient
  public C_Country getC_country_t() {
    if (this.c_country_t == null && this.getC_country() != null) {
      this.c_country_t = C_Country_Manager.getCI().get_rec(this.getC_country()); 
    }
    return this.c_country_t;
  }
//  @Transient
//  public C_Country getC_country_t_2(Session session_) {
//    if (this.c_country_t == null && this.getC_country() != null) {
//      this.c_country_t = C_Country_Manager.getCI().get_rec(session_, this.getC_country()); 
//    }
//    return this.c_country_t;
//  }
  public void setC_country_t(C_Country c_country_t) {
    this.c_country_t = c_country_t;
    this.c_country = (this.c_country_t != null?this.c_country_t.getC_country():null);
  }

  @Transient
  public Ho_Cat getHo_cat_t() {
    if (this.ho_cat_t == null && this.getHo_cat() != null) {
      this.ho_cat_t = Ho_Cat_Manager.getCI().get_rec(this.getHo_cat()); 
    }
    return this.ho_cat_t;
  }
//  @Transient
//  public Ho_Cat getHo_cat_t_2(Session session_) {
//    if (this.ho_cat_t == null && this.getHo_cat() != null) {
//      this.ho_cat_t = Ho_Cat_Manager.getCI().get_rec(session_, this.getHo_cat()); 
//    }
//    return this.ho_cat_t;
//  }
  public void setHo_cat_t(Ho_Cat ho_cat_t) {
    this.ho_cat_t = ho_cat_t;
    this.ho_cat = (this.ho_cat_t != null?this.ho_cat_t.getHo_cat():null);
  }




  @Transient
  public Ho_Build_Type getHo_build_type_t() {
    if (this.ho_build_type_t == null && this.getHo_build_type() != null) {
      this.ho_build_type_t = Ho_Build_Type_Manager.getCI().get_rec(this.getHo_build_type()); 
    }
    return this.ho_build_type_t;
  }
//  @Transient
//  public Ho_Build_Type getHo_build_type_t_2(Session session_) {
//    if (this.ho_build_type_t == null && this.getHo_build_type() != null) {
//      this.ho_build_type_t = Ho_Build_Type_Manager.getCI().get_rec(session_, this.getHo_build_type()); 
//    }
//    return this.ho_build_type_t;
//  }
  public void setHo_build_type_t(Ho_Build_Type ho_build_type_t) {
    this.ho_build_type_t = ho_build_type_t;
    this.ho_build_type = (this.ho_build_type_t != null?this.ho_build_type_t.getHo_build_type():null);
  }








  @Transient
  public C_Loc getC_loc_t() {
    if (this.c_loc_t == null && this.getC_loc() != null) {
      this.c_loc_t = C_Loc_Manager.getCI().get_rec(this.getC_loc()); 
    }
    return this.c_loc_t;
  }
//  @Transient
//  public C_Loc getC_loc_t_2(Session session_) {
//    if (this.c_loc_t == null && this.getC_loc() != null) {
//      this.c_loc_t = C_Loc_Manager.getCI().get_rec(session_, this.getC_loc()); 
//    }
//    return this.c_loc_t;
//  }
  public void setC_loc_t(C_Loc c_loc_t) {
    this.c_loc_t = c_loc_t;
    this.c_loc = (this.c_loc_t != null?this.c_loc_t.getC_loc():null);
  }

  @Transient
  public Ho_Resid_Complex getHo_resid_complex_t() {
    if (this.ho_resid_complex_t == null && this.getHo_resid_complex() != null) {
      this.ho_resid_complex_t = Ho_Resid_Complex_Manager.getCI().get_rec(this.getHo_resid_complex()); 
    }
    return this.ho_resid_complex_t;
  }
//  @Transient
//  public Ho_Resid_Complex getHo_resid_complex_t_2(Session session_) {
//    if (this.ho_resid_complex_t == null && this.getHo_resid_complex() != null) {
//      this.ho_resid_complex_t = Ho_Resid_Complex_Manager.getCI().get_rec(session_, this.getHo_resid_complex()); 
//    }
//    return this.ho_resid_complex_t;
//  }
  public void setHo_resid_complex_t(Ho_Resid_Complex ho_resid_complex_t) {
    this.ho_resid_complex_t = ho_resid_complex_t;
    this.ho_resid_complex = (this.ho_resid_complex_t != null?this.ho_resid_complex_t.getHo_resid_complex():null);
  }







  @Transient
  public Ho_House_Condition getHo_house_condition_t() {
    if (this.ho_house_condition_t == null && this.getHo_house_condition() != null) {
      this.ho_house_condition_t = Ho_House_Condition_Manager.getCI().get_rec(this.getHo_house_condition()); 
    }
    return this.ho_house_condition_t;
  }
//  @Transient
//  public Ho_House_Condition getHo_house_condition_t_2(Session session_) {
//    if (this.ho_house_condition_t == null && this.getHo_house_condition() != null) {
//      this.ho_house_condition_t = Ho_House_Condition_Manager.getCI().get_rec(session_, this.getHo_house_condition()); 
//    }
//    return this.ho_house_condition_t;
//  }
  public void setHo_house_condition_t(Ho_House_Condition ho_house_condition_t) {
    this.ho_house_condition_t = ho_house_condition_t;
    this.ho_house_condition = (this.ho_house_condition_t != null?this.ho_house_condition_t.getHo_house_condition():null);
  }

  @Transient
  public Ho_House_Phone getHo_house_phone_t() {
    if (this.ho_house_phone_t == null && this.getHo_house_phone() != null) {
      this.ho_house_phone_t = Ho_House_Phone_Manager.getCI().get_rec(this.getHo_house_phone()); 
    }
    return this.ho_house_phone_t;
  }
//  @Transient
//  public Ho_House_Phone getHo_house_phone_t_2(Session session_) {
//    if (this.ho_house_phone_t == null && this.getHo_house_phone() != null) {
//      this.ho_house_phone_t = Ho_House_Phone_Manager.getCI().get_rec(session_, this.getHo_house_phone()); 
//    }
//    return this.ho_house_phone_t;
//  }
  public void setHo_house_phone_t(Ho_House_Phone ho_house_phone_t) {
    this.ho_house_phone_t = ho_house_phone_t;
    this.ho_house_phone = (this.ho_house_phone_t != null?this.ho_house_phone_t.getHo_house_phone():null);
  }

  @Transient
  public Ho_House_Inet getHo_house_inet_t() {
    if (this.ho_house_inet_t == null && this.getHo_house_inet() != null) {
      this.ho_house_inet_t = Ho_House_Inet_Manager.getCI().get_rec(this.getHo_house_inet()); 
    }
    return this.ho_house_inet_t;
  }
//  @Transient
//  public Ho_House_Inet getHo_house_inet_t_2(Session session_) {
//    if (this.ho_house_inet_t == null && this.getHo_house_inet() != null) {
//      this.ho_house_inet_t = Ho_House_Inet_Manager.getCI().get_rec(session_, this.getHo_house_inet()); 
//    }
//    return this.ho_house_inet_t;
//  }
  public void setHo_house_inet_t(Ho_House_Inet ho_house_inet_t) {
    this.ho_house_inet_t = ho_house_inet_t;
    this.ho_house_inet = (this.ho_house_inet_t != null?this.ho_house_inet_t.getHo_house_inet():null);
  }

  @Transient
  public Ho_House_Bathroom getHo_house_bathroom_t() {
    if (this.ho_house_bathroom_t == null && this.getHo_house_bathroom() != null) {
      this.ho_house_bathroom_t = Ho_House_Bathroom_Manager.getCI().get_rec(this.getHo_house_bathroom()); 
    }
    return this.ho_house_bathroom_t;
  }
//  @Transient
//  public Ho_House_Bathroom getHo_house_bathroom_t_2(Session session_) {
//    if (this.ho_house_bathroom_t == null && this.getHo_house_bathroom() != null) {
//      this.ho_house_bathroom_t = Ho_House_Bathroom_Manager.getCI().get_rec(session_, this.getHo_house_bathroom()); 
//    }
//    return this.ho_house_bathroom_t;
//  }
  public void setHo_house_bathroom_t(Ho_House_Bathroom ho_house_bathroom_t) {
    this.ho_house_bathroom_t = ho_house_bathroom_t;
    this.ho_house_bathroom = (this.ho_house_bathroom_t != null?this.ho_house_bathroom_t.getHo_house_bathroom():null);
  }

  @Transient
  public Ho_House_Balcony getHo_house_balcony_t() {
    if (this.ho_house_balcony_t == null && this.getHo_house_balcony() != null) {
      this.ho_house_balcony_t = Ho_House_Balcony_Manager.getCI().get_rec(this.getHo_house_balcony()); 
    }
    return this.ho_house_balcony_t;
  }
//  @Transient
//  public Ho_House_Balcony getHo_house_balcony_t_2(Session session_) {
//    if (this.ho_house_balcony_t == null && this.getHo_house_balcony() != null) {
//      this.ho_house_balcony_t = Ho_House_Balcony_Manager.getCI().get_rec(session_, this.getHo_house_balcony()); 
//    }
//    return this.ho_house_balcony_t;
//  }
  public void setHo_house_balcony_t(Ho_House_Balcony ho_house_balcony_t) {
    this.ho_house_balcony_t = ho_house_balcony_t;
    this.ho_house_balcony = (this.ho_house_balcony_t != null?this.ho_house_balcony_t.getHo_house_balcony():null);
  }


  @Transient
  public Ho_House_Door getHo_house_door_t() {
    if (this.ho_house_door_t == null && this.getHo_house_door() != null) {
      this.ho_house_door_t = Ho_House_Door_Manager.getCI().get_rec(this.getHo_house_door()); 
    }
    return this.ho_house_door_t;
  }
//  @Transient
//  public Ho_House_Door getHo_house_door_t_2(Session session_) {
//    if (this.ho_house_door_t == null && this.getHo_house_door() != null) {
//      this.ho_house_door_t = Ho_House_Door_Manager.getCI().get_rec(session_, this.getHo_house_door()); 
//    }
//    return this.ho_house_door_t;
//  }
  public void setHo_house_door_t(Ho_House_Door ho_house_door_t) {
    this.ho_house_door_t = ho_house_door_t;
    this.ho_house_door = (this.ho_house_door_t != null?this.ho_house_door_t.getHo_house_door():null);
  }

  @Transient
  public Ho_House_Parking getHo_house_parking_t() {
    if (this.ho_house_parking_t == null && this.getHo_house_parking() != null) {
      this.ho_house_parking_t = Ho_House_Parking_Manager.getCI().get_rec(this.getHo_house_parking()); 
    }
    return this.ho_house_parking_t;
  }
//  @Transient
//  public Ho_House_Parking getHo_house_parking_t_2(Session session_) {
//    if (this.ho_house_parking_t == null && this.getHo_house_parking() != null) {
//      this.ho_house_parking_t = Ho_House_Parking_Manager.getCI().get_rec(session_, this.getHo_house_parking()); 
//    }
//    return this.ho_house_parking_t;
//  }
  public void setHo_house_parking_t(Ho_House_Parking ho_house_parking_t) {
    this.ho_house_parking_t = ho_house_parking_t;
    this.ho_house_parking = (this.ho_house_parking_t != null?this.ho_house_parking_t.getHo_house_parking():null);
  }

  @Transient
  public Ho_House_Furniture getHo_house_furniture_t() {
    if (this.ho_house_furniture_t == null && this.getHo_house_furniture() != null) {
      this.ho_house_furniture_t = Ho_House_Furniture_Manager.getCI().get_rec(this.getHo_house_furniture()); 
    }
    return this.ho_house_furniture_t;
  }
//  @Transient
//  public Ho_House_Furniture getHo_house_furniture_t_2(Session session_) {
//    if (this.ho_house_furniture_t == null && this.getHo_house_furniture() != null) {
//      this.ho_house_furniture_t = Ho_House_Furniture_Manager.getCI().get_rec(session_, this.getHo_house_furniture()); 
//    }
//    return this.ho_house_furniture_t;
//  }
  public void setHo_house_furniture_t(Ho_House_Furniture ho_house_furniture_t) {
    this.ho_house_furniture_t = ho_house_furniture_t;
    this.ho_house_furniture = (this.ho_house_furniture_t != null?this.ho_house_furniture_t.getHo_house_furniture():null);
  }

  @Transient
  public Ho_House_Floor getHo_house_floor_t() {
    if (this.ho_house_floor_t == null && this.getHo_house_floor() != null) {
      this.ho_house_floor_t = Ho_House_Floor_Manager.getCI().get_rec(this.getHo_house_floor()); 
    }
    return this.ho_house_floor_t;
  }
//  @Transient
//  public Ho_House_Floor getHo_house_floor_t_2(Session session_) {
//    if (this.ho_house_floor_t == null && this.getHo_house_floor() != null) {
//      this.ho_house_floor_t = Ho_House_Floor_Manager.getCI().get_rec(session_, this.getHo_house_floor()); 
//    }
//    return this.ho_house_floor_t;
//  }
  public void setHo_house_floor_t(Ho_House_Floor ho_house_floor_t) {
    this.ho_house_floor_t = ho_house_floor_t;
    this.ho_house_floor = (this.ho_house_floor_t != null?this.ho_house_floor_t.getHo_house_floor():null);
  }



  @Transient
  public Ho_Contact_Info_Type getHo_contact_info_type_t() {
    if (this.ho_contact_info_type_t == null && this.getHo_contact_info_type() != null) {
      this.ho_contact_info_type_t = Ho_Contact_Info_Type_Manager.getCI().get_rec(this.getHo_contact_info_type()); 
    }
    return this.ho_contact_info_type_t;
  }
//  @Transient
//  public Ho_Contact_Info_Type getHo_contact_info_type_t_2(Session session_) {
//    if (this.ho_contact_info_type_t == null && this.getHo_contact_info_type() != null) {
//      this.ho_contact_info_type_t = Ho_Contact_Info_Type_Manager.getCI().get_rec(session_, this.getHo_contact_info_type()); 
//    }
//    return this.ho_contact_info_type_t;
//  }
  public void setHo_contact_info_type_t(Ho_Contact_Info_Type ho_contact_info_type_t) {
    this.ho_contact_info_type_t = ho_contact_info_type_t;
    this.ho_contact_info_type = (this.ho_contact_info_type_t != null?this.ho_contact_info_type_t.getHo_contact_info_type():null);
  }






  @Transient
  public Ho_Ad_Status getHo_ad_status_t() {
    if (this.ho_ad_status_t == null && this.getHo_ad_status() != null) {
      this.ho_ad_status_t = Ho_Ad_Status_Manager.getCI().get_rec(this.getHo_ad_status()); 
    }
    return this.ho_ad_status_t;
  }
//  @Transient
//  public Ho_Ad_Status getHo_ad_status_t_2(Session session_) {
//    if (this.ho_ad_status_t == null && this.getHo_ad_status() != null) {
//      this.ho_ad_status_t = Ho_Ad_Status_Manager.getCI().get_rec(session_, this.getHo_ad_status()); 
//    }
//    return this.ho_ad_status_t;
//  }
  public void setHo_ad_status_t(Ho_Ad_Status ho_ad_status_t) {
    this.ho_ad_status_t = ho_ad_status_t;
    this.ho_ad_status = (this.ho_ad_status_t != null?this.ho_ad_status_t.getHo_ad_status():null);
  }





  @Transient
  public Ho_House_Sewerage getHo_house_sewerage_t() {
    if (this.ho_house_sewerage_t == null && this.getHo_house_sewerage() != null) {
      this.ho_house_sewerage_t = Ho_House_Sewerage_Manager.getCI().get_rec(this.getHo_house_sewerage()); 
    }
    return this.ho_house_sewerage_t;
  }
//  @Transient
//  public Ho_House_Sewerage getHo_house_sewerage_t_2(Session session_) {
//    if (this.ho_house_sewerage_t == null && this.getHo_house_sewerage() != null) {
//      this.ho_house_sewerage_t = Ho_House_Sewerage_Manager.getCI().get_rec(session_, this.getHo_house_sewerage()); 
//    }
//    return this.ho_house_sewerage_t;
//  }
  public void setHo_house_sewerage_t(Ho_House_Sewerage ho_house_sewerage_t) {
    this.ho_house_sewerage_t = ho_house_sewerage_t;
    this.ho_house_sewerage = (this.ho_house_sewerage_t != null?this.ho_house_sewerage_t.getHo_house_sewerage():null);
  }

  @Transient
  public Ho_House_Drink_Water getHo_house_drink_water_t() {
    if (this.ho_house_drink_water_t == null && this.getHo_house_drink_water() != null) {
      this.ho_house_drink_water_t = Ho_House_Drink_Water_Manager.getCI().get_rec(this.getHo_house_drink_water()); 
    }
    return this.ho_house_drink_water_t;
  }
//  @Transient
//  public Ho_House_Drink_Water getHo_house_drink_water_t_2(Session session_) {
//    if (this.ho_house_drink_water_t == null && this.getHo_house_drink_water() != null) {
//      this.ho_house_drink_water_t = Ho_House_Drink_Water_Manager.getCI().get_rec(session_, this.getHo_house_drink_water()); 
//    }
//    return this.ho_house_drink_water_t;
//  }
  public void setHo_house_drink_water_t(Ho_House_Drink_Water ho_house_drink_water_t) {
    this.ho_house_drink_water_t = ho_house_drink_water_t;
    this.ho_house_drink_water = (this.ho_house_drink_water_t != null?this.ho_house_drink_water_t.getHo_house_drink_water():null);
  }

  @Transient
  public Ho_House_Electricity getHo_house_electricity_t() {
    if (this.ho_house_electricity_t == null && this.getHo_house_electricity() != null) {
      this.ho_house_electricity_t = Ho_House_Electricity_Manager.getCI().get_rec(this.getHo_house_electricity()); 
    }
    return this.ho_house_electricity_t;
  }
//  @Transient
//  public Ho_House_Electricity getHo_house_electricity_t_2(Session session_) {
//    if (this.ho_house_electricity_t == null && this.getHo_house_electricity() != null) {
//      this.ho_house_electricity_t = Ho_House_Electricity_Manager.getCI().get_rec(session_, this.getHo_house_electricity()); 
//    }
//    return this.ho_house_electricity_t;
//  }
  public void setHo_house_electricity_t(Ho_House_Electricity ho_house_electricity_t) {
    this.ho_house_electricity_t = ho_house_electricity_t;
    this.ho_house_electricity = (this.ho_house_electricity_t != null?this.ho_house_electricity_t.getHo_house_electricity():null);
  }

  @Transient
  public Ho_House_Heating getHo_house_heating_t() {
    if (this.ho_house_heating_t == null && this.getHo_house_heating() != null) {
      this.ho_house_heating_t = Ho_House_Heating_Manager.getCI().get_rec(this.getHo_house_heating()); 
    }
    return this.ho_house_heating_t;
  }
//  @Transient
//  public Ho_House_Heating getHo_house_heating_t_2(Session session_) {
//    if (this.ho_house_heating_t == null && this.getHo_house_heating() != null) {
//      this.ho_house_heating_t = Ho_House_Heating_Manager.getCI().get_rec(session_, this.getHo_house_heating()); 
//    }
//    return this.ho_house_heating_t;
//  }
  public void setHo_house_heating_t(Ho_House_Heating ho_house_heating_t) {
    this.ho_house_heating_t = ho_house_heating_t;
    this.ho_house_heating = (this.ho_house_heating_t != null?this.ho_house_heating_t.getHo_house_heating():null);
  }

  @Transient
  public Ho_House_Gas getHo_house_gas_t() {
    if (this.ho_house_gas_t == null && this.getHo_house_gas() != null) {
      this.ho_house_gas_t = Ho_House_Gas_Manager.getCI().get_rec(this.getHo_house_gas()); 
    }
    return this.ho_house_gas_t;
  }
//  @Transient
//  public Ho_House_Gas getHo_house_gas_t_2(Session session_) {
//    if (this.ho_house_gas_t == null && this.getHo_house_gas() != null) {
//      this.ho_house_gas_t = Ho_House_Gas_Manager.getCI().get_rec(session_, this.getHo_house_gas()); 
//    }
//    return this.ho_house_gas_t;
//  }
  public void setHo_house_gas_t(Ho_House_Gas ho_house_gas_t) {
    this.ho_house_gas_t = ho_house_gas_t;
    this.ho_house_gas = (this.ho_house_gas_t != null?this.ho_house_gas_t.getHo_house_gas():null);
  }




  @Transient
  public Ho_House_Irrigation_Water getHo_house_irrigation_water_t() {
    if (this.ho_house_irrigation_water_t == null && this.getHo_house_irrigation_water() != null) {
      this.ho_house_irrigation_water_t = Ho_House_Irrigation_Water_Manager.getCI().get_rec(this.getHo_house_irrigation_water()); 
    }
    return this.ho_house_irrigation_water_t;
  }
//  @Transient
//  public Ho_House_Irrigation_Water getHo_house_irrigation_water_t_2(Session session_) {
//    if (this.ho_house_irrigation_water_t == null && this.getHo_house_irrigation_water() != null) {
//      this.ho_house_irrigation_water_t = Ho_House_Irrigation_Water_Manager.getCI().get_rec(session_, this.getHo_house_irrigation_water()); 
//    }
//    return this.ho_house_irrigation_water_t;
//  }
  public void setHo_house_irrigation_water_t(Ho_House_Irrigation_Water ho_house_irrigation_water_t) {
    this.ho_house_irrigation_water_t = ho_house_irrigation_water_t;
    this.ho_house_irrigation_water = (this.ho_house_irrigation_water_t != null?this.ho_house_irrigation_water_t.getHo_house_irrigation_water():null);
  }

  @Transient
  public Ho_House_Office_Type getHo_house_office_type_t() {
    if (this.ho_house_office_type_t == null && this.getHo_house_office_type() != null) {
      this.ho_house_office_type_t = Ho_House_Office_Type_Manager.getCI().get_rec(this.getHo_house_office_type()); 
    }
    return this.ho_house_office_type_t;
  }
//  @Transient
//  public Ho_House_Office_Type getHo_house_office_type_t_2(Session session_) {
//    if (this.ho_house_office_type_t == null && this.getHo_house_office_type() != null) {
//      this.ho_house_office_type_t = Ho_House_Office_Type_Manager.getCI().get_rec(session_, this.getHo_house_office_type()); 
//    }
//    return this.ho_house_office_type_t;
//  }
  public void setHo_house_office_type_t(Ho_House_Office_Type ho_house_office_type_t) {
    this.ho_house_office_type_t = ho_house_office_type_t;
    this.ho_house_office_type = (this.ho_house_office_type_t != null?this.ho_house_office_type_t.getHo_house_office_type():null);
  }






  @Transient
  public Ho_House_Shop_Type getHo_house_shop_type_t() {
    if (this.ho_house_shop_type_t == null && this.getHo_house_shop_type() != null) {
      this.ho_house_shop_type_t = Ho_House_Shop_Type_Manager.getCI().get_rec(this.getHo_house_shop_type()); 
    }
    return this.ho_house_shop_type_t;
  }
//  @Transient
//  public Ho_House_Shop_Type getHo_house_shop_type_t_2(Session session_) {
//    if (this.ho_house_shop_type_t == null && this.getHo_house_shop_type() != null) {
//      this.ho_house_shop_type_t = Ho_House_Shop_Type_Manager.getCI().get_rec(session_, this.getHo_house_shop_type()); 
//    }
//    return this.ho_house_shop_type_t;
//  }
  public void setHo_house_shop_type_t(Ho_House_Shop_Type ho_house_shop_type_t) {
    this.ho_house_shop_type_t = ho_house_shop_type_t;
    this.ho_house_shop_type = (this.ho_house_shop_type_t != null?this.ho_house_shop_type_t.getHo_house_shop_type():null);
  }

  @Transient
  public Ho_House_Loc getHo_house_loc_t() {
    if (this.ho_house_loc_t == null && this.getHo_house_loc() != null) {
      this.ho_house_loc_t = Ho_House_Loc_Manager.getCI().get_rec(this.getHo_house_loc()); 
    }
    return this.ho_house_loc_t;
  }
//  @Transient
//  public Ho_House_Loc getHo_house_loc_t_2(Session session_) {
//    if (this.ho_house_loc_t == null && this.getHo_house_loc() != null) {
//      this.ho_house_loc_t = Ho_House_Loc_Manager.getCI().get_rec(session_, this.getHo_house_loc()); 
//    }
//    return this.ho_house_loc_t;
//  }
  public void setHo_house_loc_t(Ho_House_Loc ho_house_loc_t) {
    this.ho_house_loc_t = ho_house_loc_t;
    this.ho_house_loc = (this.ho_house_loc_t != null?this.ho_house_loc_t.getHo_house_loc():null);
  }


  @Transient
  public Ho_House_Indus_Base_Type getHo_house_indus_base_type_t() {
    if (this.ho_house_indus_base_type_t == null && this.getHo_house_indus_base_type() != null) {
      this.ho_house_indus_base_type_t = Ho_House_Indus_Base_Type_Manager.getCI().get_rec(this.getHo_house_indus_base_type()); 
    }
    return this.ho_house_indus_base_type_t;
  }
//  @Transient
//  public Ho_House_Indus_Base_Type getHo_house_indus_base_type_t_2(Session session_) {
//    if (this.ho_house_indus_base_type_t == null && this.getHo_house_indus_base_type() != null) {
//      this.ho_house_indus_base_type_t = Ho_House_Indus_Base_Type_Manager.getCI().get_rec(session_, this.getHo_house_indus_base_type()); 
//    }
//    return this.ho_house_indus_base_type_t;
//  }
  public void setHo_house_indus_base_type_t(Ho_House_Indus_Base_Type ho_house_indus_base_type_t) {
    this.ho_house_indus_base_type_t = ho_house_indus_base_type_t;
    this.ho_house_indus_base_type = (this.ho_house_indus_base_type_t != null?this.ho_house_indus_base_type_t.getHo_house_indus_base_type():null);
  }


  @Transient
  public C_Land_Area_Unit getTerritory_area_unit_t() {
    if (this.territory_area_unit_t == null && this.getTerritory_area_unit() != null) {
      this.territory_area_unit_t = C_Land_Area_Unit_Manager.getCI().get_rec(this.getTerritory_area_unit()); 
    }
    return this.territory_area_unit_t;
  }
//  @Transient
//  public C_Land_Area_Unit getTerritory_area_unit_t_2(Session session_) {
//    if (this.territory_area_unit_t == null && this.getTerritory_area_unit() != null) {
//      this.territory_area_unit_t = C_Land_Area_Unit_Manager.getCI().get_rec(session_, this.getTerritory_area_unit()); 
//    }
//    return this.territory_area_unit_t;
//  }
  public void setTerritory_area_unit_t(C_Land_Area_Unit territory_area_unit_t) {
    this.territory_area_unit_t = territory_area_unit_t;
    this.territory_area_unit = (this.territory_area_unit_t != null?this.territory_area_unit_t.getC_land_area_unit():null);
  }









  @Transient
  public Ho_House_Land_Price getHo_house_land_price_t() {
    if (this.ho_house_land_price_t == null && this.getHo_house_land_price() != null) {
      this.ho_house_land_price_t = Ho_House_Land_Price_Manager.getCI().get_rec(this.getHo_house_land_price()); 
    }
    return this.ho_house_land_price_t;
  }
//  @Transient
//  public Ho_House_Land_Price getHo_house_land_price_t_2(Session session_) {
//    if (this.ho_house_land_price_t == null && this.getHo_house_land_price() != null) {
//      this.ho_house_land_price_t = Ho_House_Land_Price_Manager.getCI().get_rec(session_, this.getHo_house_land_price()); 
//    }
//    return this.ho_house_land_price_t;
//  }
  public void setHo_house_land_price_t(Ho_House_Land_Price ho_house_land_price_t) {
    this.ho_house_land_price_t = ho_house_land_price_t;
    this.ho_house_land_price = (this.ho_house_land_price_t != null?this.ho_house_land_price_t.getHo_house_land_price():null);
  }


  @Transient
  public Ho_House_Spec_Purpose getHo_house_spec_purpose_t() {
    if (this.ho_house_spec_purpose_t == null && this.getHo_house_spec_purpose() != null) {
      this.ho_house_spec_purpose_t = Ho_House_Spec_Purpose_Manager.getCI().get_rec(this.getHo_house_spec_purpose()); 
    }
    return this.ho_house_spec_purpose_t;
  }
//  @Transient
//  public Ho_House_Spec_Purpose getHo_house_spec_purpose_t_2(Session session_) {
//    if (this.ho_house_spec_purpose_t == null && this.getHo_house_spec_purpose() != null) {
//      this.ho_house_spec_purpose_t = Ho_House_Spec_Purpose_Manager.getCI().get_rec(session_, this.getHo_house_spec_purpose()); 
//    }
//    return this.ho_house_spec_purpose_t;
//  }
  public void setHo_house_spec_purpose_t(Ho_House_Spec_Purpose ho_house_spec_purpose_t) {
    this.ho_house_spec_purpose_t = ho_house_spec_purpose_t;
    this.ho_house_spec_purpose = (this.ho_house_spec_purpose_t != null?this.ho_house_spec_purpose_t.getHo_house_spec_purpose():null);
  }



  @Transient
  public Ho_House_Rent_Period getHo_house_rent_period_t() {
    if (this.ho_house_rent_period_t == null && this.getHo_house_rent_period() != null) {
      this.ho_house_rent_period_t = Ho_House_Rent_Period_Manager.getCI().get_rec(this.getHo_house_rent_period()); 
    }
    return this.ho_house_rent_period_t;
  }
//  @Transient
//  public Ho_House_Rent_Period getHo_house_rent_period_t_2(Session session_) {
//    if (this.ho_house_rent_period_t == null && this.getHo_house_rent_period() != null) {
//      this.ho_house_rent_period_t = Ho_House_Rent_Period_Manager.getCI().get_rec(session_, this.getHo_house_rent_period()); 
//    }
//    return this.ho_house_rent_period_t;
//  }
  public void setHo_house_rent_period_t(Ho_House_Rent_Period ho_house_rent_period_t) {
    this.ho_house_rent_period_t = ho_house_rent_period_t;
    this.ho_house_rent_period = (this.ho_house_rent_period_t != null?this.ho_house_rent_period_t.getHo_house_rent_period():null);
  }

  @Transient
  public Ho_Usr getHo_usr_t() {
    if (this.ho_usr_t == null && this.getHo_usr() != null) {
      this.ho_usr_t = Ho_Usr_Manager.getCI().get_rec(this.getHo_usr()); 
    }
    return this.ho_usr_t;
  }
  @Transient
//  @Hint
//  public Ho_Usr getHo_usr_t2(Session session_) {
//    if (this.ho_usr_t == null && this.getHo_usr() != null) {
//      this.ho_usr_t = Ho_Usr_Manager.getCI().get_rec(session_, this.getHo_usr()); 
//    }
//    return this.ho_usr_t;
//  }


  public void setHo_usr_t(Ho_Usr ho_usr_t) {
    this.ho_usr_t = ho_usr_t;
    this.ho_usr = (this.ho_usr_t != null?this.ho_usr_t.getHo_usr():null);
  }


  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.getHo_ad());
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
    final Ho_Ad other = (Ho_Ad) obj;
    if (!Objects.equals(this.getHo_ad(), other.getHo_ad())) {
      return false;
    }
    return true;
  }

  @Transient
  @Override
  public Serializable getEntity_id() {
    return getHo_ad();
  }

} 
