/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.repositories.core.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import java.util.List;
import model.core.dbtables.C_Tbl_Rec_Corr_By_Name;
import model.ho.dbtables.Ho_Build_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface C_Tbl_Rec_Corr_By_Name_Repository extends JpaRepository<C_Tbl_Rec_Corr_By_Name, Integer> {

  
  @Query("select t from C_Tbl_Rec_Corr_By_Name t where t.is_deleted=false ")
  List<C_Tbl_Rec_Corr_By_Name> find_all1();
  
  @Query("select t.rec_id as id, t.name as name from C_Tbl_Rec_Corr_By_Name t where t.is_deleted=false and t.name=:name_")
  HoAdCatResponse find_by_name(@Param("name_") String name_);

  
}