
package gs.services.ho;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.repositories.ho.dbtables.Ho_House_Inet_Repository;
import java.util.List;
import model.ho.dbtables.Ho_House_Inet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Ho_House_Inet_Service {
  @Autowired
  private Ho_House_Inet_Repository repository;
  public  String find_by_id(Integer id_){
    return repository.find_by_id(id_);
  }
   public List<HoAdCatResponse> findall(){
    return repository.find_all();
  }
  public List<Ho_House_Inet> find_all1(){
    return repository.find_all1();
  }
}
