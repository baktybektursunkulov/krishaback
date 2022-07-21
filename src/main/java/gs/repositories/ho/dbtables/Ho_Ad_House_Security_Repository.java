/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.repositories.ho.dbtables;

import java.util.List;
import model.core.dbtables.C_Land_Area_Unit;
import model.ho.dbtables.Ho_Ad_House_Security;
import model.ho.dbtables.Ho_Ad_Phone_Num;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */

@Repository
public interface Ho_Ad_House_Security_Repository extends CrudRepository<Ho_Ad_House_Security, Integer> {
   @Query("select t from Ho_Ad_House_Security t where t.is_deleted=false and t.ho_ad=:id_")
  List<Ho_Ad_House_Security> find_by_id(@Param("id_") Integer id_);
}
