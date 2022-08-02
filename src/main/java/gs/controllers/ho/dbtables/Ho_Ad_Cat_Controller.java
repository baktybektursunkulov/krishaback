package gs.controllers.ho.dbtables;

import gs.payload.response.horesponse.*;
import gs.services.ho.Ho_Ad_Cat_Service;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/ho_ad_cat")
@Api(tags = {"Ho_Ad_Cat_Controller"})
public class Ho_Ad_Cat_Controller {

  @Autowired
  Ho_Ad_Cat_Service ho_ad_cat_Service;

  @GetMapping(value = "/ho_build_type")
  public ResponseEntity<List<HoAdCatResponse>> ho_build_type() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_build_type(), HttpStatus.OK);
  }

   @GetMapping(value = "/ho_house_rent_period")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_rent_period() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_rent_period(), HttpStatus.OK);
  }
  
  @GetMapping(value = "/ho_house_alloc_type")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_alloc_type() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_alloc_type(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_field_activ")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_field_activ() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_field_activ(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_misc")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_misc() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_misc(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_commun")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_commun() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_commun(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_security")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_security_() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_security(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_loc")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_loc() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_loc(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_resid_complex")
  public ResponseEntity<List<HoAdCatResponse>> ho_resid_complex() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_resid_complex(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_condition")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_condition() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_condition(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_phone")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_phone() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_phone(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_inet")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_inet() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_inet(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_bathroom")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_bathroom() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_bathroom(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_balcony")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_balcony() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_balcony(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_door")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_door() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_door(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_parking")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_parking() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_parking(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_furniture")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_furniture() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_furniture(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_floor")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_floor() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_floor(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_contact_info_type")
  public ResponseEntity<List<HoAdCatResponse>> ho_contact_info_type() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_contact_info_type(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_sewerage")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_sewerage() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_sewerage(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_drink_water")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_drink_water() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_drink_water(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_electricity")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_electricity() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_electricity(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_heating")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_heating() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_heating(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_gas")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_gas() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_gas(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_irrigation_water")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_irrigation_water() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_irrigation_water(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_office_type")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_office_type() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_office_type(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_shop_type")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_shop_type() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_shop_type(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_indus_base_type")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_indus_base_type() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_indus_base_type(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_land_price")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_land_price() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_land_price(), HttpStatus.OK);
  }

  @GetMapping(value = "/ho_house_spec_purpose")
  public ResponseEntity<List<HoAdCatResponse>> ho_house_spec_purpose() throws RuntimeException {
    return new ResponseEntity<>(ho_ad_cat_Service.ho_house_spec_purpose(), HttpStatus.OK);
  }

}
