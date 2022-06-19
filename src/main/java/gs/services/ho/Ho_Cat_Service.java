package gs.services.ho;

import gs.payload.response.horesponse.HoCatResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gs.repositories.ho.dbtables.Ho_Cat_Repository;
import model.ho.dbtables.Ho_Cat;

@Service
public class Ho_Cat_Service {

  @Autowired
  private Ho_Cat_Repository repository;

  public List<Ho_Cat> find_all() {
    return repository.find_all();
  }
  public List<Ho_Cat> find_page_title() {
    return repository.find_page_title();
  }
   public List<Ho_Cat> get_sell_rent_subcat(Integer id) {
    return repository.get_sell_rent_subcat(id);
  }
  public Ho_Cat find_by_id(Integer id) {
    return repository.find_by_id(id);
  }
  public List<Ho_Cat> get_subcat_list(Integer id) {
    return repository.get_subcat_list(id);
  }
  public List<Ho_Cat> get_seocontent_menu_list(){
    return repository.get_seocontent_menu_list();
  }
  
  public List<Ho_Cat> get_sell_rent_cat(){
    return repository.get_sell_rent_cat();
  }
}
