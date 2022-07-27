/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import java.util.List;
import model.ho.dbtables.Ho_House_Field_Activ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_House_Field_Activ_Repository extends JpaRepository<Ho_House_Field_Activ, Integer> {

  @Query("select t.ho_house_field_activ as id , t.name as name from Ho_House_Field_Activ t where t.is_deleted=false ")
  List<HoAdCatResponse> find_all();

  @Query("select t from Ho_House_Field_Activ t where t.is_deleted=false ")
  List<Ho_House_Field_Activ> find_all1();

  @Query("select t from Ho_House_Field_Activ t where t.is_deleted=false and t.ho_house_field_activ=:id_ ")
  Ho_House_Field_Activ find_by_id(@Param("id_") Integer id_);
}
