package gs.services.ad;

import model.ad.dbtables.Ad_Cat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gs.repositories.ad.dbtables.Ad_Cat_Repository;

@Service
public class Ad_Cat_Service {

  @Autowired
  private Ad_Cat_Repository repository;

  public List<Ad_Cat> find_all() {
    return repository.find_all();
  }
  public List<Ad_Cat> find_all_sub_prod_cat(Integer id) {
    return repository.find_all_sub_prod_cat(id);
  }
  public Ad_Cat find_by_id(Integer id) {
    return repository.find_by_id(id);
  }
}
