package gs.repositories.core.dbtables;

import model.core.dbtables.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface C_Tz_Repository extends JpaRepository<C_Tz, Integer> {

  @Query("select t from C_Tz t where t.c_tz=:id_ ")
  Optional<C_Tz> find_by_id(@Param("id_") Integer id_);

  @Query("select t from C_Tz t where t.is_deleted=false and t.interval_in_min=:interval_in_min_ ")
  Optional<C_Tz> find_by_interval_in_min(@Param("interval_in_min_") Integer interval_in_min_);

}
