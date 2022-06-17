package gs.controllers.core.dbtables;

import model.core.dbtables.*;
import gs.services.core.dbtables.*;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/c_lang")
@Api(tags = {"C_Lang_Controller"})
public class C_Lang_Controller {

  @Autowired
  C_Lang_Service c_Lang_Service;

  @Autowired
  C_Site_Service c_Site_Service;

  @GetMapping(value = "/find_all")
  public ResponseEntity<List<C_Lang>> find_all(HttpServletRequest httpServletRequest) throws RuntimeException {
    C_Site c_Site = c_Site_Service.get_c_site_from_request(httpServletRequest);
    return new ResponseEntity<>(c_Lang_Service.find_all(c_Site.getC_proj()), HttpStatus.OK);
  }

}
