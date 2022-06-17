package gs.controllers.ecom.dbtables;

import model.core.dbtables.C_Bin_File_Body;
import model.core.dbtables.Country;
import model.ecom.dbtables.Bin_File_Body;
import gs.services.core.dbtables.C_Bin_File_Body_Service;
import gs.services.core.dbtables.ICountryService;
import gs.services.ecom.dbtables.Bin_File_Body_Service;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bin_file_body")
@Api(tags = {"Bin_File_Body_Controller"})
public class Bin_File_Body_Controller {

  private Bin_File_Body_Service bin_File_Body_Service;

  public Bin_File_Body_Controller(Bin_File_Body_Service bin_File_Body_Service) {
    this.bin_File_Body_Service = bin_File_Body_Service;
  }

  @GetMapping(value = "/findAll")
  public ResponseEntity<List<Bin_File_Body>> findAll() throws RuntimeException {
    return new ResponseEntity<>(bin_File_Body_Service.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/migrate")
  public ResponseEntity<List<Bin_File_Body>> migrate() throws RuntimeException {
    return new ResponseEntity<>(bin_File_Body_Service.migrate(), HttpStatus.OK);
  }
}
