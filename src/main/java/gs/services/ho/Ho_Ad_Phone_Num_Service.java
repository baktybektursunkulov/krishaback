package gs.services.ho;

import gs.repositories.ho.dbtables.*;
import java.util.List;
import model.ho.dbtables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Ho_Ad_Phone_Num_Service {
  @Autowired
  private Ho_Ad_Phone_Num_Repository repository;
  public  List<Ho_Ad_Phone_Num> find_by_id(Integer id_){
    return repository.find_by_id(id_);
  }
 
}
