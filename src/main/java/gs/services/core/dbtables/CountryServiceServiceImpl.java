package gs.services.core.dbtables;

import model.core.dbtables.Country;
import gs.repositories.core.dbtables.CountryRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.cache.annotation.Caching;

@Service
public class CountryServiceServiceImpl implements ICountryService {

  private static final String REDIS_CACHE_VALUE = "country";
  private static final String REDIS_CACHE_VALUE_ALL = REDIS_CACHE_VALUE + "_all";

  private CountryRepository countryRepository;

  public CountryServiceServiceImpl(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @Override
  @Caching(
    put = {
      @CachePut(value = REDIS_CACHE_VALUE, key = "#country.id")},
    evict = {
      @CacheEvict(value = REDIS_CACHE_VALUE_ALL, allEntries = true)}
  )
  public Country save(Country country) {
    return countryRepository.save(country);
  }

  @Override
  @Cacheable(value = REDIS_CACHE_VALUE, key = "#id")
  public Country findById(Integer id) {
    return countryRepository.findFirstById(id);
  }

  @Override
  @Caching(
    evict = {
      @CacheEvict(value = REDIS_CACHE_VALUE, key = "#id"),
      @CacheEvict(value = REDIS_CACHE_VALUE_ALL, allEntries = true)
    }
  )
  public List<Country> delete(Integer id) {
    countryRepository.deleteById(id);
    return countryRepository.findAll();
  }

  @Override
  @Cacheable(value = REDIS_CACHE_VALUE_ALL)
  public List<Country> findAll() {
    return countryRepository.findAll();
  }
}
