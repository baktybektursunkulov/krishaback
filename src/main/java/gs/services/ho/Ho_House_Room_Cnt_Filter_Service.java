package gs.services.ho;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gs.repositories.ho.dbtables.Ho_House_Room_Cnt_Filter_Repository;
import model.ho.dbtables.Ho_House_Room_Cnt_Filter;

@Service
public class Ho_House_Room_Cnt_Filter_Service {

  @Autowired
  private Ho_House_Room_Cnt_Filter_Repository repository;

  public List<Ho_House_Room_Cnt_Filter> find_all() {
    return repository.find_all();
  }

}
