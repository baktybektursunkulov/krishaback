package gs.repositories.ho.dbtables;

import model.ho.dbtables.Ho_Ad_Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Ad_Status_Repository extends JpaRepository<Ho_Ad_Status, Integer> {

  @Query("select t.name as name from Ho_Ad_Status t where t.ho_ad_status=:id_ and t.is_deleted=false ")
  String find_by_id(@Param("id_") Integer id_);

}
