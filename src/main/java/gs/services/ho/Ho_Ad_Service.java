package gs.services.ho;

import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.ho.dbtables.Ho_Ad;

@Service
public class Ho_Ad_Service {

  @Autowired
  private Ho_Ad_Repository repository;
  
  public Ho_Ad saveOrUpdate(Ho_Ad ho_ad)  { 
    repository.save(ho_ad);
    return ho_ad;
}  
  public List<Integer> find_all()  { 
    return repository.find_all();
}
  public void update(Ho_Ad ho_ad, int id) {
    repository.save(ho_ad);
  }
  public List<Ho_Ad> find(Integer id){
    return repository.find(id);
  }
    public List<Ho_Ad> pagination(Integer id,Integer limit,Integer offset){
    return repository.pagination(id,limit,offset);
  }
  public Ho_Ad find_by_id(Integer id){
    return repository.find_by_id(id);
  }
  
  public Integer countofcat(Integer id){
    return repository.countofcat(id);
  }
}
