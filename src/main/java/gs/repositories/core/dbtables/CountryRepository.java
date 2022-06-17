package gs.repositories.core.dbtables;

import model.core.dbtables.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findFirstById(Integer id);

    @Override
    List<Country> findAll();

    @Override
    void deleteById(Integer integer);
}
