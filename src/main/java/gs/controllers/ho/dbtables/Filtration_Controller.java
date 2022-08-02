package gs.controllers.ho.dbtables;

import gs.payload.request.horequest.*;
import gs.payload.response.horesponse.*;
import gs.repositories.ho.dbtables.Ho_Ad_Repository_A1;
import gs.services.ho.*;
import io.swagger.annotations.Api;
import java.util.List;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filtration_cat")
@Api(tags = {"Filtration_Controller"})
@CrossOrigin(origins = "*", maxAge = 3600)
public class Filtration_Controller {

  @Autowired
  private Ho_Ad_Repository_A1 ho_ad_repository_a1;

  @PostMapping("/filters")
  private ResponseEntity<List<FiltrationResponse>> filters(@RequestBody FiltrationRequest filtrationrequest) {
    List<FiltrationResponse> res = get_list(filtrationrequest);

    return new ResponseEntity<>(res, HttpStatus.OK);
  }


  @PostMapping("/filters_cnt")
  private ResponseEntity<FiltrationCountResponse> filters_cnt(@RequestBody FiltrationRequest filtrationrequest) {
    FiltrationCountResponse res = new FiltrationCountResponse();
   // Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    List<FiltrationResponse> all = get_list(filtrationrequest);
      res.setCount(all.size());
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  public List<FiltrationResponse> get_list(FiltrationRequest filtrationrequest) {
      List<FiltrationResponse> res = ho_ad_repository_a1.filters(filtrationrequest.getCat_id(), filtrationrequest.getHo_build_type(), filtrationrequest.getRoom_cnt(), filtrationrequest.getNot_last_floor(),
      filtrationrequest.getNot_first_floor(), filtrationrequest.getPrice(), filtrationrequest.getMax_floor(), filtrationrequest.getMax_floor(),
      filtrationrequest.getConstruction_year(), filtrationrequest.getTotal_area(), filtrationrequest.getKitchen_area(),filtrationrequest.getLiving_area(),
      filtrationrequest.getLand_area(),filtrationrequest.getAdj_territory_area(),filtrationrequest.getWarehouse_area(),filtrationrequest.getMax_power_consumption(),filtrationrequest.getOffice_area(),
      filtrationrequest.getHas_photo(),filtrationrequest.getOwner(),filtrationrequest.getIs_in_priv_hostel(),filtrationrequest.getIs_has_railway_siding(),filtrationrequest.getIs_has_own_substation(),
      filtrationrequest.getIs_pledged(),filtrationrequest.getIs_exch_possible(),filtrationrequest.getIs_operating_business(),filtrationrequest.getIs_divisible(),filtrationrequest.getIs_has_sep_entr_group(),filtrationrequest.getHo_house_spec_purpose(),
      filtrationrequest.getTxt_has(),filtrationrequest.getHo_house_furniture(),filtrationrequest.getHo_house_inet(),filtrationrequest.getHo_house_bathroom(),filtrationrequest.getHo_house_condition(),filtrationrequest.getHo_house_phone(),filtrationrequest.getHo_house_rent_period(),
      filtrationrequest.getHo_house_electricity(),filtrationrequest.getHo_house_drink_water(),filtrationrequest.getHo_house_irrigation_water(),filtrationrequest.getHo_house_gas(),filtrationrequest.getHo_house_office_type(),
      filtrationrequest.getHo_house_shop_type(),filtrationrequest.getHo_house_loc(),filtrationrequest.getHo_house_indus_base_type(),filtrationrequest.getHo_house_field_activ(),filtrationrequest.getHo_house_sewerage());
    return res;
  }
}
