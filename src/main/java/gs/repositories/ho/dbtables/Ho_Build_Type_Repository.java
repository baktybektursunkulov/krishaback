package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 
import model.ho.dbtables.Ho_Build_Type;
import model.ho.dbtables.Ho_Cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Build_Type_Repository extends JpaRepository<Ho_Build_Type, Integer> {

  @Query("select t.name as name,t.ho_build_type as id from Ho_Build_Type t where t.is_deleted=false ")
  List<HoAdCatResponse> find_all();
  
  @Query("select t from Ho_Build_Type t where t.is_deleted=false ")
  List<Ho_Build_Type> find_all1();
    @Query("select t.name as name from Ho_Build_Type t where t.ho_build_type=:id_ and t.is_deleted=false ")
  String find_by_id(@Param("id_") Integer id_);
  
}

