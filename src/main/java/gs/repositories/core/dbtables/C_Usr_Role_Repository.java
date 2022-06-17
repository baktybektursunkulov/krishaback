package gs.repositories.core.dbtables;

import model.core.dbtables.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface C_Usr_Role_Repository extends JpaRepository<C_Usr_Role, Integer> {

  @Query("select t from C_Usr_Role t where t.c_usr_role=:id_ ")
  Optional<C_Usr_Role> find_by_id(@Param("id_") Integer id_);

  @Query("select t from C_Usr_Role t where t.is_deleted=false and t.code=:code_ ")
  Optional<C_Usr_Role> find_by_code(@Param("code_") String code_);

}
