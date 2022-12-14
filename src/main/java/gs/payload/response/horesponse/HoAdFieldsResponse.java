package gs.payload.response.horesponse;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data public class HoAdFieldsResponse {
 private Integer ho_ad;
  private Integer c_country;
  private Integer room_cnt;
  private String ho_build_type;
  private Integer construction_year;
  private Integer floor;
  private Integer max_floor;
  private Double total_area;
  private Double living_area;
  private Double kitchen_area;
  private Boolean is_in_priv_hostel;
  private String c_loc;
  private String ho_resid_complex;
  private String street_name;
  private String house_num;
  private String intersection;
  private Boolean is_hide_house_num;
  private Double lat;
  private Double lon;
  private String ho_house_condition;
  private String ho_house_phone;
  private String ho_house_inet;
  private String ho_house_bathroom;
  private String ho_house_balcony;
  private Boolean is_balcony_glazed;
  private String ho_house_door;
  private String ho_house_parking;
  private String ho_house_furniture;
  private String ho_house_floor;
  private Double ceiling_height;
  private String ho_contact_info_type;
  private String contact_name;
  private Boolean is_exch_possible;
  private Boolean is_agree_with_rules;
  private Integer ho_ad_status;
  private Boolean is_deleted;
  private Integer level_num;
  private Double land_area;
  private String how_area_fenced;
  private String ho_house_sewerage;
  private String ho_house_drink_water;
  private String ho_house_electricity;
  private String ho_house_heating;
  private String ho_house_gas;
  private String roofing;
  private String suburban_area_name;
  private Double house_area;
  private String ho_house_irrigation_water;
  private String ho_house_office_type;
  private String business_center_name;
  private Integer phone_lines_num;
  private String parking;
  private Boolean is_has_sep_entr_group;
  private Double adj_territory_area;
  private String ho_house_shop_type;
  private String ho_house_loc;
  private String shop_center_name;
  private String ho_house_indus_base_type;
  private Double territory_area;
  private String territory_area_unit;
  private Double production_area;
  private Double production_area_ceiling_height;
  private Double warehouse_area;
  private Double warehouse_ceiling_height;
  private Double office_area;
  private Boolean is_has_railway_siding;
  private Double max_power_consumption;
  private Boolean is_has_own_substation;
  private String ho_house_land_price;
  private Boolean is_divisible;
  private String ho_house_spec_purpose;
  private String title;
  private Boolean is_operating_business;
  private String ho_house_rent_period;
  private Long ho_usr;
  private List<String> security;
  private List<String> commun;
  private List<String> loc;
  private List<String> misc;
  private List<String> alloc_type;
  private List<String> field_activ;

  public HoAdFieldsResponse(Integer ho_ad, Integer c_country, Integer room_cnt, String ho_build_type, Integer construction_year, Integer floor, Integer max_floor, Double total_area, Double living_area, Double kitchen_area, Boolean is_in_priv_hostel, String c_loc, String ho_resid_complex, String street_name, String house_num, String intersection, Boolean is_hide_house_num, Double lat, Double lon, String ho_house_condition, String ho_house_phone, String ho_house_inet, String ho_house_bathroom, String ho_house_balcony, Boolean is_balcony_glazed, String ho_house_door, String ho_house_parking, String ho_house_furniture, String ho_house_floor, Double ceiling_height, String ho_contact_info_type, String contact_name, Boolean is_exch_possible, Boolean is_agree_with_rules, Integer ho_ad_status, Boolean is_deleted, Integer level_num, Double land_area, String how_area_fenced, String ho_house_sewerage, String ho_house_drink_water, String ho_house_electricity, String ho_house_heating, String ho_house_gas, String roofing, String suburban_area_name, Double house_area, String ho_house_irrigation_water, String ho_house_office_type, String business_center_name, Integer phone_lines_num, String parking, Boolean is_has_sep_entr_group, Double adj_territory_area, String ho_house_shop_type, String ho_house_loc, String shop_center_name, String ho_house_indus_base_type, Double territory_area, String territory_area_unit, Double production_area, Double production_area_ceiling_height, Double warehouse_area, Double warehouse_ceiling_height, Double office_area, Boolean is_has_railway_siding, Double max_power_consumption, Boolean is_has_own_substation, String ho_house_land_price, Boolean is_divisible, String ho_house_spec_purpose, String title, Boolean is_operating_business, String ho_house_rent_period, Long ho_usr, List<String> security, List<String> commun, List<String> loc, List<String> misc, List<String> alloc_type, List<String> field_activ) {
    this.ho_ad = ho_ad;
    this.c_country = c_country;
    this.room_cnt = room_cnt;
    this.ho_build_type = ho_build_type;
    this.construction_year = construction_year;
    this.floor = floor;
    this.max_floor = max_floor;
    this.total_area = total_area;
    this.living_area = living_area;
    this.kitchen_area = kitchen_area;
    this.is_in_priv_hostel = is_in_priv_hostel;
    this.c_loc = c_loc;
    this.ho_resid_complex = ho_resid_complex;
    this.street_name = street_name;
    this.house_num = house_num;
    this.intersection = intersection;
    this.is_hide_house_num = is_hide_house_num;
    this.lat = lat;
    this.lon = lon;
    this.ho_house_condition = ho_house_condition;
    this.ho_house_phone = ho_house_phone;
    this.ho_house_inet = ho_house_inet;
    this.ho_house_bathroom = ho_house_bathroom;
    this.ho_house_balcony = ho_house_balcony;
    this.is_balcony_glazed = is_balcony_glazed;
    this.ho_house_door = ho_house_door;
    this.ho_house_parking = ho_house_parking;
    this.ho_house_furniture = ho_house_furniture;
    this.ho_house_floor = ho_house_floor;
    this.ceiling_height = ceiling_height;
    this.ho_contact_info_type = ho_contact_info_type;
    this.contact_name = contact_name;
    this.is_exch_possible = is_exch_possible;
    this.is_agree_with_rules = is_agree_with_rules;
    this.ho_ad_status = ho_ad_status;
    this.is_deleted = is_deleted;
    this.level_num = level_num;
    this.land_area = land_area;
    this.how_area_fenced = how_area_fenced;
    this.ho_house_sewerage = ho_house_sewerage;
    this.ho_house_drink_water = ho_house_drink_water;
    this.ho_house_electricity = ho_house_electricity;
    this.ho_house_heating = ho_house_heating;
    this.ho_house_gas = ho_house_gas;
    this.roofing = roofing;
    this.suburban_area_name = suburban_area_name;
    this.house_area = house_area;
    this.ho_house_irrigation_water = ho_house_irrigation_water;
    this.ho_house_office_type = ho_house_office_type;
    this.business_center_name = business_center_name;
    this.phone_lines_num = phone_lines_num;
    this.parking = parking;
    this.is_has_sep_entr_group = is_has_sep_entr_group;
    this.adj_territory_area = adj_territory_area;
    this.ho_house_shop_type = ho_house_shop_type;
    this.ho_house_loc = ho_house_loc;
    this.shop_center_name = shop_center_name;
    this.ho_house_indus_base_type = ho_house_indus_base_type;
    this.territory_area = territory_area;
    this.territory_area_unit = territory_area_unit;
    this.production_area = production_area;
    this.production_area_ceiling_height = production_area_ceiling_height;
    this.warehouse_area = warehouse_area;
    this.warehouse_ceiling_height = warehouse_ceiling_height;
    this.office_area = office_area;
    this.is_has_railway_siding = is_has_railway_siding;
    this.max_power_consumption = max_power_consumption;
    this.is_has_own_substation = is_has_own_substation;
    this.ho_house_land_price = ho_house_land_price;
    this.is_divisible = is_divisible;
    this.ho_house_spec_purpose = ho_house_spec_purpose;
    this.title = title;
    this.is_operating_business = is_operating_business;
    this.ho_house_rent_period = ho_house_rent_period;
    this.ho_usr = ho_usr;
    this.security = security;
    this.commun = commun;
    this.loc = loc;
    this.misc = misc;
    this.alloc_type = alloc_type;
    this.field_activ = field_activ;
  }


}
