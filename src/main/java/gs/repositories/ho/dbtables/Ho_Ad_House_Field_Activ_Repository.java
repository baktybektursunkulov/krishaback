package gs.repositories.ho.dbtables;

import java.util.List;
import model.ho.dbtables.Ho_Ad_House_Field_Activ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Ad_House_Field_Activ_Repository extends CrudRepository<Ho_Ad_House_Field_Activ, Integer> {
   @Query("select t from Ho_Ad_House_Field_Activ t where t.is_deleted=false and t.ho_ad=:id_")
  List<Ho_Ad_House_Field_Activ> find_by_id(@Param("id_") Integer id_);
}
