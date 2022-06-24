package gs.controllers.core.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoCLocResponse;
import gs.repositories.core.dbtables.C_Loc_Repository;
import gs.services.core.dbtables.C_Loc_Service;
import model.core.dbtables.Country;
import gs.services.core.dbtables.ICountryService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/c_loc")
@Api(tags = {"CountryController"})
public class C_Loc_Controller {
   
  @Autowired
  private C_Loc_Repository c_loc_repository;
  
    @GetMapping(value = "/findById")
    public ResponseEntity<List<HoCLocResponse>> findById(@Valid @RequestParam Integer id, HttpServletRequest httpServletRequest) throws RuntimeException {
        return new ResponseEntity<>(c_loc_repository.find_by_id(id), HttpStatus.OK);
    }

   
}
