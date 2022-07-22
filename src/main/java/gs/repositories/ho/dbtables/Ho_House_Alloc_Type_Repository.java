/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import java.util.List;
import model.ho.dbtables.Ho_House_Alloc_Type;
import model.ho.dbtables.Ho_House_Field_Activ;
import model.ho.dbtables.Ho_House_Security;
import model.ho.dbtables.Ho_House_Sewerage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */

@Repository
public interface Ho_House_Alloc_Type_Repository extends JpaRepository<Ho_House_Alloc_Type, Integer> {

  @Query("select t.ho_house_alloc_type as id , t.name as name from Ho_House_Alloc_Type t where t.is_deleted=false ")
  List<HoAdCatResponse> find_all();
   @Query("select t from Ho_House_Alloc_Type t where t.is_deleted=false ")
  List<Ho_House_Alloc_Type> find_all1();
  @Query("select t from Ho_House_Alloc_Type t where t.is_deleted=false and t.ho_house_alloc_type=:id_ ")
  Ho_House_Alloc_Type find_by_id(@Param("id_") Integer id_);
}
