package gs.services.core.dbtables;

import model.core.dbtables.Country;

import java.util.List;

public interface ICountryService {
    Country save(Country country);
    List<Country> findAll();
    Country findById(Integer id);
    List<Country> delete(Integer id);
}
