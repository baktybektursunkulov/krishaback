package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 
import model.ho.dbtables.Ho_Build_Type;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_Contact_Info_Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Contact_Info_Type_Repository extends JpaRepository<Ho_Contact_Info_Type, Integer> {

  @Query("select t.ho_contact_info_type as id, t.name as name from Ho_Contact_Info_Type t where t.is_deleted=false")
  List<HoAdCatResponse> find_all();
   @Query("select t.name as name from Ho_Contact_Info_Type t where t.is_deleted=false and t.ho_contact_info_type=:id_")
  String  find_by_id(@Param("id_") Integer id_);
    @Query("select t from Ho_Contact_Info_Type t where t.is_deleted=false")
  List<Ho_Contact_Info_Type> find_all1();
  
}

