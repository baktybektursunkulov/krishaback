package gs.payload.request.horequest;

import gs.payload.response.horesponse.FiltrationFieldsResponse;
import java.util.List;
import lombok.Data;

@Data
public class FiltrationRequest {

  private Integer cat_id;
  private List<Integer> room_cnt;
  private List<Integer> ho_build_type;
  private Boolean not_last_floor;
  private Boolean not_first_floor;
  private FiltrationFieldsResponse price;
  private FiltrationFieldsResponse floor;
  private FiltrationFieldsResponse max_floor;
  private FiltrationFieldsResponse construction_year;
  private FiltrationFieldsResponse total_area;
  private FiltrationFieldsResponse kitchen_area;
  private FiltrationFieldsResponse living_area;
  private FiltrationFieldsResponse land_area;
  private FiltrationFieldsResponse adj_territory_area;
  private FiltrationFieldsResponse warehouse_area;
  private FiltrationFieldsResponse max_power_consumption;
  private FiltrationFieldsResponse office_area;
  private Boolean has_photo;
  private Boolean owner;
  private Boolean is_in_priv_hostel;
  private Boolean is_has_railway_siding;
  private Boolean is_has_own_substation;
  private Boolean is_pledged;
  private Boolean is_exch_possible;
  private Boolean is_operating_business;
  private Boolean is_divisible;
  private Boolean is_has_sep_entr_group; 
  private Integer ho_house_spec_purpose;
  private String txt_has;
  private List<Integer> ho_house_furniture;
  private List<Integer> ho_house_inet;
  private List<Integer> ho_house_bathroom;
  private List<Integer> ho_house_condition;
  private List<Integer> ho_house_phone;
  private List<Integer> ho_house_rent_period;
  private List<Integer> ho_house_electricity;
  private List<Integer> ho_house_drink_water;
  private List<Integer> ho_house_irrigation_water;
  private List<Integer> ho_house_gas;
  private List<Integer> ho_house_office_type;
  private List<Integer> ho_house_shop_type;
  private List<Integer> ho_house_loc;
  private List<Integer> ho_house_indus_base_type;
  private List<Integer> ho_house_field_activ;
  private List<Integer> ho_house_sewerage;
}
