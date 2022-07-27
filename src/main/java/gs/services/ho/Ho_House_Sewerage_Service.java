
package gs.services.ho;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.repositories.ho.dbtables.Ho_House_Sewerage_Repository;
import java.util.List;
import model.ho.dbtables.Ho_House_Sewerage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Ho_House_Sewerage_Service {
  @Autowired
  private Ho_House_Sewerage_Repository repository;
  public  String find_by_id(Integer id_){
    return repository.find_by_id(id_);
  }
   public List<HoAdCatResponse> findall(){
    return repository.find_all();
  }
  public List<Ho_House_Sewerage> find_all1(){
    return repository.find_all1();
  }
}
