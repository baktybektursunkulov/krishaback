package gs.repositories.core.dbtables;

import java.util.List;
import model.core.dbtables.*;
import java.util.Optional; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface C_Lang_Repository extends JpaRepository<C_Lang, Integer> {

  @Query("select t from C_Lang t where t.c_lang=:id_ ")
  Optional<C_Lang> find_by_id(@Param("id_") Integer id_);

  @Query("select t from C_Lang t where t.is_deleted=false and t.code=:code_ ")
  Optional<C_Lang> find_by_code(@Param("code_") String code_);

  @Query("select l from C_Proj_Lang pl, C_Lang l where pl.is_deleted=false and pl.c_proj=:c_proj_id_ and pl.c_lang=l.c_lang ")
  List<C_Lang> find_all(@Param("c_proj_id_") Integer c_proj_id_);
  
}
