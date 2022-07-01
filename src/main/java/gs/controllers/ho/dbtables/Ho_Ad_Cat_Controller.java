/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gs.controllers.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoAdCatResponse;
import gs.services.core.dbtables.C_Lang_Service;
import gs.services.ho.Ho_Ad_Cat_Service;
import io.swagger.annotations.Api;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.core.dbtables.Country;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/ho_ad_cat")
@Api(tags = {"Ho_Ad_Cat_Controller"})
public class Ho_Ad_Cat_Controller {
  
  @Autowired
  Ho_Ad_Cat_Service ho_ad_cat_Service;
   @GetMapping(value = "/ho_build_type_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_build_type_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_build_type_repository(), HttpStatus.OK);
    }
  @GetMapping(value = "/ho_resid_complex_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_resid_complex_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_resid_complex_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_condition_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_condition_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_condition_repository(), HttpStatus.OK);
    }
   @GetMapping(value = "/ho_house_phone_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_phone_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_phone_repository(), HttpStatus.OK);
    }
   @GetMapping(value = "/ho_house_inet_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_inet_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_inet_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_bathroom_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_bathroom_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_bathroom_repository(), HttpStatus.OK);
    }
   @GetMapping(value = "/ho_house_balcony_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_balcony_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_balcony_repository(), HttpStatus.OK);
    }
   @GetMapping(value = "/ho_house_door_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_door_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_door_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_parking_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_parking_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_parking_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_furniture_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_furniture_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_furniture_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_floor_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_floor_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_floor_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_contact_info_type_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_contact_info_type_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_contact_info_type_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_sewerage_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_sewerage_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_sewerage_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_drink_water_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_drink_water_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_drink_water_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_electricity_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_electricity_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_electricity_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_heating_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_heating_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_heating_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_gas_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_gas_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_gas_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_irrigation_water_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_irrigation_water_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_irrigation_water_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_office_type_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_office_type_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_office_type_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_shop_type_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_shop_type_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_shop_type_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_indus_base_type_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_indus_base_type_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_indus_base_type_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_land_price_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_land_price_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_land_price_repository(), HttpStatus.OK);
    }
    @GetMapping(value = "/ho_house_spec_purpose_repository")
    public ResponseEntity<List<HoAdCatResponse>> ho_house_spec_purpose_repository() throws RuntimeException {
        return new ResponseEntity<>(ho_ad_cat_Service.ho_house_spec_purpose_repository(), HttpStatus.OK);
    }
  
    
}
