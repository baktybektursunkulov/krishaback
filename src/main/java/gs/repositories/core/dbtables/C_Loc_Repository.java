package gs.repositories.core.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoCLocResponse;
import model.core.dbtables.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface C_Loc_Repository extends JpaRepository<C_Loc, Long> {

  @Query("select t.c_loc as id, t.name as name from C_Loc t where t.parent_id=:id_ and is_deleted=false order by name")
  List<HoCLocResponse> find_by_id(@Param("id_") Integer id_);

}
