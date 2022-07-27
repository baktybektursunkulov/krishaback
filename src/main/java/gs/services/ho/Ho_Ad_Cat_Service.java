package gs.services.ho;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.repositories.ho.dbtables.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ho_Ad_Cat_Service {

  @Autowired
  private Ho_House_Field_Activ_Repository ho_house_field_activ_repository;
  @Autowired
  private Ho_House_Alloc_Type_Repository ho_house_alloc_type_repository;
  @Autowired
  private Ho_House_Commun_Repository ho_house_commun_repository;
  @Autowired
  private Ho_House_Misc_Repository ho_house_misc_repository;
  @Autowired
  private Ho_House_Loc_Repository ho_house_loc_repository;
  @Autowired
  private Ho_House_Security_Repository ho_house_security_repository;
  @Autowired
  private Ho_Build_Type_Repository ho_build_type_repository;
  @Autowired
  private Ho_Resid_Complex_Repository ho_resid_complex_repository;
  @Autowired
  private Ho_House_Condition_Repository ho_house_condition_repository;
  @Autowired
  private Ho_House_Phone_Repository ho_house_phone_repository;
  @Autowired
  private Ho_House_Inet_Repository ho_house_inet_repository;
  @Autowired
  private Ho_House_Bathroom_Repository ho_house_bathroom_repository;
  @Autowired
  private Ho_House_Balcony_Repository ho_house_balcony_repository;
  @Autowired
  private Ho_House_Door_Repository ho_house_door_repository;
  @Autowired
  private Ho_House_Parking_Repository ho_house_parking_repository;
  @Autowired
  private Ho_House_Furniture_Repository ho_house_furniture_repository;
  @Autowired
  private Ho_House_Floor_Repository ho_house_floor_repository;
  @Autowired
  private Ho_Contact_Info_Type_Repository ho_contact_info_type_repository;
  @Autowired
  private Ho_House_Sewerage_Repository ho_house_sewerage_repository;
  @Autowired
  private Ho_House_Drink_Water_Repository ho_house_drink_water_repository;
  @Autowired
  private Ho_House_Electricity_Repository ho_house_electricity_repository;
  @Autowired
  private Ho_House_Heating_Repository ho_house_heating_repository;
  @Autowired
  private Ho_House_Gas_Repository ho_house_gas_repository;
  @Autowired
  private Ho_House_Irrigation_Water_Repository ho_house_irrigation_water_repository;
  @Autowired
  private Ho_House_Office_Type_Repository ho_house_office_type_repository;
  @Autowired
  private Ho_House_Shop_Type_Repository ho_house_shop_type_repository;
  @Autowired
  private Ho_House_Indus_Base_Type_Repository ho_house_indus_base_type_repository;
  @Autowired
  private Ho_House_Land_Price_Repository ho_house_land_price_repository;
  @Autowired
  private Ho_House_Spec_Purpose_Repository ho_house_spec_purpose_repository;

  public List<HoAdCatResponse> ho_house_alloc_type() {
    return ho_house_alloc_type_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_field_activ() {
    return ho_house_field_activ_repository.find_all();
  }

  public List<HoAdCatResponse> ho_build_type() {
    return ho_build_type_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_loc() {
    return ho_house_loc_repository.find_all();
  }

  public List<HoAdCatResponse> ho_resid_complex() {
    return ho_resid_complex_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_misc() {
    return ho_house_misc_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_security() {
    return ho_house_security_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_commun() {
    return ho_house_commun_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_condition() {
    return ho_house_condition_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_phone() {
    return ho_house_phone_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_inet() {
    return ho_house_inet_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_bathroom() {
    return ho_house_bathroom_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_balcony() {
    return ho_house_balcony_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_door() {
    return ho_house_door_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_parking() {
    return ho_house_parking_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_furniture() {
    return ho_house_furniture_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_floor() {
    return ho_house_floor_repository.find_all();
  }

  public List<HoAdCatResponse> ho_contact_info_type() {
    return ho_contact_info_type_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_sewerage() {
    return ho_house_sewerage_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_drink_water() {
    return ho_house_drink_water_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_electricity() {
    return ho_house_electricity_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_heating() {
    return ho_house_heating_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_gas() {
    return ho_house_gas_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_irrigation_water() {
    return ho_house_irrigation_water_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_office_type() {
    return ho_house_office_type_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_shop_type() {
    return ho_house_shop_type_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_indus_base_type() {
    return ho_house_indus_base_type_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_land_price() {
    return ho_house_land_price_repository.find_all();
  }

  public List<HoAdCatResponse> ho_house_spec_purpose() {
    return ho_house_spec_purpose_repository.find_all();
  }
}
