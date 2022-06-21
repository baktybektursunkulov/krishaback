package gs.repositories.core.dbtables;

import java.util.List;
import model.core.dbtables.C_Usr;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface C_Usr_Repository extends JpaRepository<C_Usr, Long> {
  
  @Query("select t from C_Usr t")
  List<C_Usr> find_all();
  
  @Query("select t from C_Usr t where t.c_usr=:id_ ")
  Optional<C_Usr> find_by_id(@Param("id_") Long id_);

  @Query("select t from C_Usr t where t.is_deleted=false and t.c_proj=:c_proj_id_ and t.c_usr_type=:c_usr_type_id_ and t.name=:name_ ")
  Optional<C_Usr> find_by_name(
    @Param("c_proj_id_") Integer c_proj_id_,
    @Param("c_usr_type_id_") Integer c_usr_type_id_,
    @Param("name_") String name_);

  @Query("select t from C_Usr t where t.is_deleted=false and t.c_proj=:c_proj_id_ and t.c_usr_type=:c_usr_type_id_ and t.email=:email_ ")
  Optional<C_Usr> find_by_email(
    @Param("c_proj_id_") Integer c_proj_id_,
    @Param("c_usr_type_id_") Integer c_usr_type_id_,
    @Param("email_") String email_);

}
