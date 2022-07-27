package gs.services.ho;

import gs.repositories.ho.dbtables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Ho_Ad_Status_Service {
  @Autowired
  private Ho_Ad_Status_Repository repository;
  public  String find_by_id(Integer id_){
    return repository.find_by_id(id_);
  }
 
}
