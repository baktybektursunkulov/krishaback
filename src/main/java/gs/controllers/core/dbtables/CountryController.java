package gs.controllers.core.dbtables;

import model.core.dbtables.Country;
import gs.services.core.dbtables.ICountryService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/country")
@Api(tags = {"CountryController"})
public class CountryController {

    private ICountryService countryService;

    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Country> save(@RequestBody Country request) throws RuntimeException {
        return new ResponseEntity<>(countryService.save(request), HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Country>> findAll() throws RuntimeException {
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/findById")
    public ResponseEntity<Country> findById(@RequestParam Integer id) throws RuntimeException {
        return new ResponseEntity<>(countryService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/deleteById")
    public ResponseEntity<List<Country>> deleteById(@RequestParam Integer id) throws RuntimeException {
        return new ResponseEntity<>(countryService.delete(id), HttpStatus.OK);
    }
}
