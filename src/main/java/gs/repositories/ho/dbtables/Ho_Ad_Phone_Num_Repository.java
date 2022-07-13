
package gs.repositories.ho.dbtables;

import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Ad_Phone_Num;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Ho_Ad_Phone_Num_Repository  extends CrudRepository<Ho_Ad_Phone_Num, Integer>{
  
}
