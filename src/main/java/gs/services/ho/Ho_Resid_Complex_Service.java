package gs.services.ho;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.repositories.ho.dbtables.Ho_Resid_Complex_Repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.ho.dbtables.Ho_Resid_Complex;

@Service
public class Ho_Resid_Complex_Service {

  @Autowired
  private Ho_Resid_Complex_Repository repository;
  public List<HoAdCatResponse> findall(){
    return repository.find_all();
  }
  public List<Ho_Resid_Complex> find_all1(){
    return repository.find_all1();
  }
  public  HoAdCatResponse find_by_name(String name_){
    return repository.find_by_name(name_);
  }
  public  String find_by_id(Integer id_){
    return repository.find_by_id(id_);
  }
}
