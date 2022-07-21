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
@Query("select t from C_Loc t where t.parent_id=:id_ and is_deleted=false order by t.c_loc")
  List<C_Loc> findall(@Param("id_") Integer id_);
  @Query("select t.c_loc as id, t.name as name from C_Loc t where t.parent_id=:id_ and is_deleted=false order by name")
  List<HoCLocResponse> find_by_id(@Param("id_") Integer id_);
  @Query("select t.name as name from C_Loc t where t.c_loc=:id_ and is_deleted=false")
  String find_by_Id(@Param("id_") Integer id_);
  @Query("select t from C_Loc t where t.c_loc=:id_ and is_deleted=false ")
  C_Loc find_all(@Param("id_") Integer id_);
   @Query("select t from C_Loc t where t.parent_id=:id_ and is_deleted=false and t.is_city=false order by name ")
  List<C_Loc> c_loc_all(@Param("id_") Integer id_);
  @Query("select t from C_Loc t where t.parent_id=:id_ and is_deleted=false and t.is_city=true order by name ")
  List<C_Loc> c_city(@Param("id_") Integer id_);
  
}
