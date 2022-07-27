
package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import java.util.List;
import model.ho.dbtables.Ho_House_Misc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface Ho_House_Misc_Repository extends JpaRepository<Ho_House_Misc, Integer>{
  @Query("select t.ho_house_misc as id , t.name as name from Ho_House_Misc t where t.is_deleted=false ")
  List<HoAdCatResponse> find_all();

  @Query("select t from Ho_House_Misc t where t.is_deleted=false and t.ho_house_misc=:id_ ")
  Ho_House_Misc find_by_id(@Param("id_") Integer id_);
}
