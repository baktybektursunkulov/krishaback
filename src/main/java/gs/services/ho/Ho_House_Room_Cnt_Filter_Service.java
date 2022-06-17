package gs.services.ho;

import gs.payload.response.horesponse.HoCatResponse;
import gs.services.ad.*;
import model.ad.dbtables.Ad_Cat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gs.repositories.ad.dbtables.Ad_Cat_Repository;
import gs.repositories.ho.dbtables.Ho_Cat_Repository;
import gs.repositories.ho.dbtables.Ho_House_Room_Cnt_Filter_Repository;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_House_Room_Cnt_Filter;

@Service
public class Ho_House_Room_Cnt_Filter_Service {

  @Autowired
  private Ho_House_Room_Cnt_Filter_Repository repository;
  

  public List<Ho_House_Room_Cnt_Filter> find_all() {
    return repository.find_all();
  }
  
//  public List<Ho_Cat> find_page_title() {
//    return repository.find_page_title();
//  }
////  public List<Ho_Cat> find_all_sub_prod_cat(Integer id) {
////    return repository.find_all_sub_prod_cat(id);
////  }
//  public Ho_Cat find_by_id(Integer id) {
//    return repository.find_by_id(id);
//  }
//  public List<Ho_Cat> get_subcat_list(Integer id) {
//    return repository.get_subcat_list(id);
//  }
//  public List<Ho_Cat> get_seocontent_menu_list(){
//    return repository.get_seocontent_menu_list();
//  }
//  
//  public List<Ho_Cat> get_sell_rent_cat(){
//    return repository.get_sell_rent_cat();
//  }
}
