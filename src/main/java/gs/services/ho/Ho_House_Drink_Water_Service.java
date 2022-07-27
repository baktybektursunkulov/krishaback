
package gs.services.ho;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.repositories.ho.dbtables.Ho_House_Drink_Water_Repository;
import java.util.List;
import model.ho.dbtables.Ho_House_Drink_Water;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Ho_House_Drink_Water_Service {
  @Autowired
  private Ho_House_Drink_Water_Repository repository;
  public  String find_by_id(Integer id_){
    return repository.find_by_id(id_);
  }
   public List<HoAdCatResponse> findall(){
    return repository.find_all();
  }
  public List<Ho_House_Drink_Water> find_all1(){
    return repository.find_all1();
  }
}
