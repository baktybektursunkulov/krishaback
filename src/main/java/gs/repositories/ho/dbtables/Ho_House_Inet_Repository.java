package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import java.util.List;
import model.ho.dbtables.Ho_House_Inet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_House_Inet_Repository extends JpaRepository<Ho_House_Inet, Integer> {

  @Query("select t.ho_house_inet as id, t.name as name  from Ho_House_Inet t where t.is_deleted=false ")
  List<HoAdCatResponse> find_all();

  @Query("select t from Ho_House_Inet t where t.is_deleted=false ")
  List<Ho_House_Inet> find_all1();

  @Query("select t.name as name from Ho_House_Inet t where t.ho_house_inet=:id_ and t.is_deleted=false ")
  String find_by_id(@Param("id_") Integer id_);

}
