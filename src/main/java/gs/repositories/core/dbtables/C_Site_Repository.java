package gs.repositories.core.dbtables;

import model.core.dbtables.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface C_Site_Repository extends JpaRepository<C_Site, Integer> {

  @Query("select t from C_Site t where t.c_site=:id_ ")
  Optional<C_Site> find_by_id(@Param("id_") Integer id_);

  @Query("select t from C_Site t where t.is_deleted=false and t.domain=:domain_ ")
  Optional<C_Site> find_by_domain(@Param("domain_") String domain_);

}
