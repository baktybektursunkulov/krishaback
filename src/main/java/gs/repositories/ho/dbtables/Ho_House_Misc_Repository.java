/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import java.util.List;
import model.ho.dbtables.Ho_House_Commun;
import model.ho.dbtables.Ho_House_Misc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface Ho_House_Misc_Repository extends JpaRepository<Ho_House_Misc, Integer>{
  @Query("select t.ho_house_misc as id , t.name as name from Ho_House_Misc t where t.is_deleted=false ")
  List<HoAdCatResponse> find_all();
}
