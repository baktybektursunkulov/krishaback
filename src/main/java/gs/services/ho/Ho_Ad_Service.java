package gs.services.ho;

import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.ho.dbtables.Ho_Ad_Repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gs.repositories.ho.dbtables.Ho_Cat_Repository;
import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_House_Shop_Type;

@Service
public class Ho_Ad_Service {

  @Autowired
  private Ho_Ad_Repository repository;
  
  public Ho_Ad saveOrUpdate(Ho_Ad ho_ad)  { 
    repository.save(ho_ad);
    return ho_ad;
}  
}
