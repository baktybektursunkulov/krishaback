package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 
import model.ho.dbtables.Ho_Build_Type;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_House_Balcony;
import model.ho.dbtables.Ho_House_Indus_Base_Type;
import model.ho.dbtables.Ho_House_Inet;
import model.ho.dbtables.Ho_House_Sewerage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_House_Indus_Base_Type_Repository extends JpaRepository<Ho_House_Indus_Base_Type, Integer> {

  @Query("select t.ho_house_indus_base_type as id, t.name as name  from Ho_House_Indus_Base_Type t where t.is_deleted=false")
  List<HoAdCatResponse> find_all();
  
  @Query("select t from Ho_House_Indus_Base_Type t where t.is_deleted=false ")
  List<Ho_House_Indus_Base_Type> find_all1();
   @Query("select t from Ho_House_Indus_Base_Type t where t.is_deleted=false and t.ho_house_indus_base_type=:id_ ")
  Ho_House_Indus_Base_Type find_by_id(@Param("id_") Integer id_);
   @Query("select t.name as name from Ho_House_Indus_Base_Type t where t.is_deleted=false and t.ho_house_indus_base_type=:id_ ")
  String find_by_id1(@Param("id_") Integer id_);
  
}

