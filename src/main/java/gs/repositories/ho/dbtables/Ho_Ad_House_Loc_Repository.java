/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.repositories.ho.dbtables;

import model.ho.dbtables.Ho_Ad_House_Loc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface Ho_Ad_House_Loc_Repository extends JpaRepository<Ho_Ad_House_Loc,Integer> {
  
}
