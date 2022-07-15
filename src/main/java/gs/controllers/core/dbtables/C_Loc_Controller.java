package gs.controllers.core.dbtables;

import gs.common.additional_classes.GoogleGeocodeResult;
import gs.common.google_geocode_funcs;
import gs.payload.response.C_Loc_Response;
import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoCLocResponse;
import gs.payload.response.horesponse.HoSellRentResponse;
import gs.repositories.core.dbtables.C_Loc_Repository;
import gs.services.core.dbtables.C_Loc_Service;
import model.core.dbtables.Country;
import gs.services.core.dbtables.ICountryService;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import model.core.dbtables.C_Loc;
import model.ho.dbtables.Ho_Cat;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/c_loc")
@Api(tags = {"CountryController"})
public class C_Loc_Controller {
   
  @Autowired
  private C_Loc_Repository c_loc_repository;
  
  @PostMapping("/update_c_loc")
  private void update(@RequestBody C_Loc c_loc){
    List<C_Loc> c_loc1=c_loc_repository.findall(3);
    for(C_Loc c_loc2:c_loc1){
      c_loc.setC_loc(c_loc2.getC_loc());
      c_loc.setParent_id(c_loc2.getParent_id());
      c_loc.setName(c_loc2.getName());
      c_loc.setIs_country(c_loc2.getIs_country());
      c_loc.setIs_region(c_loc2.getIs_region());
      c_loc.setIs_city(c_loc2.getIs_city());
      c_loc.setIs_aul(c_loc2.getIs_aul());
      c_loc.setIs_village(c_loc2.getIs_village());
      c_loc.setIs_grp(c_loc2.getIs_grp());
      c_loc.setIs_settlement(c_loc2.getIs_settlement());
      c_loc.setIs_station(c_loc2.getIs_station());
      c_loc_repository.save(c_loc);
     
    }
  }
    @GetMapping(value = "/findById")
    public ResponseEntity<List<HoCLocResponse>> findById(@Valid @RequestParam Integer id, HttpServletRequest httpServletRequest) throws RuntimeException {
        return new ResponseEntity<>(c_loc_repository.find_by_id(id), HttpStatus.OK);
    }
   @GetMapping(value = "/get_loc")
  public ResponseEntity<List<C_Loc_Response>> get_loc(@Valid @RequestParam Integer id, HttpServletRequest httpServletRequest) throws RuntimeException {
    List<C_Loc_Response> loc_list = new ArrayList();
    List<C_Loc> c_locs = c_loc_repository.c_loc_all(id);
    List<C_Loc> c_city = c_loc_repository.c_city(id);
    c_city.addAll(c_locs);
    for (C_Loc c_loc : c_city) {
      List<C_Loc> ho_cat1 = c_loc_repository.findall(c_loc.getC_loc());
      boolean trf = true;
      if (ho_cat1.isEmpty()) {
        trf = false;
      }
      loc_list.add(new C_Loc_Response(c_loc.getC_loc(),
        c_loc.getName(), trf,String.valueOf(c_loc.getLat()),String.valueOf(c_loc.getLon())));
    }
    return new ResponseEntity<>(loc_list, HttpStatus.OK);
  }
}
