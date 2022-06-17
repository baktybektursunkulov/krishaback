package gs.controllers.core.dbtables;

import model.core.dbtables.C_Bin_File_Body;
import gs.services.core.dbtables.C_Bin_File_Body_Service;
import gs.services.core.dbtables.ICountryService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/c_bin_file_body")
@Api(tags = {"C_Bin_File_Body_Controller"})
public class C_Bin_File_Body_Controller {

    private C_Bin_File_Body_Service c_Bin_File_Body_Service;

    public C_Bin_File_Body_Controller(C_Bin_File_Body_Service c_Bin_File_Body_Service) {
        this.c_Bin_File_Body_Service = c_Bin_File_Body_Service;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<C_Bin_File_Body>> findAll() throws RuntimeException {
        return new ResponseEntity<>(c_Bin_File_Body_Service.findAll(), HttpStatus.OK);
    }

}
