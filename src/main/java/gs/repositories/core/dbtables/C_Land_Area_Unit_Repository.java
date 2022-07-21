
package gs.repositories.core.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import java.util.List;
import model.core.dbtables.C_Land_Area_Unit;
import model.ho.dbtables.Ho_House_Balcony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

  @Repository
public interface C_Land_Area_Unit_Repository extends JpaRepository<C_Land_Area_Unit, Integer> {
   @Query("select t from C_Land_Area_Unit t where t.is_deleted=false")
  List<C_Land_Area_Unit> find_all1();
   @Query("select t.name as name from C_Land_Area_Unit t where t.is_deleted=false and t.c_land_area_unit=:id_ ")
  String find_by_id(@Param("id_") Integer id_);
  
}
