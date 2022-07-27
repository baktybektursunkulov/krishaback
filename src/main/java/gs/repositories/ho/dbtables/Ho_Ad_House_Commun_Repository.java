package gs.repositories.ho.dbtables;

import java.util.List;
import model.ho.dbtables.Ho_Ad_House_Commun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Ad_House_Commun_Repository extends JpaRepository<Ho_Ad_House_Commun, Integer> {

  @Query("select t from Ho_Ad_House_Commun t where t.ho_ad=:id_ and t.is_deleted=false ")
  List<Ho_Ad_House_Commun> find_by_id(@Param("id_") Integer id_);
}
