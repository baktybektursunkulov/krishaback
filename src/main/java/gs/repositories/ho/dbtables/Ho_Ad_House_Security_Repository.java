/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.repositories.ho.dbtables;

import model.ho.dbtables.Ho_Ad_House_Security;
import model.ho.dbtables.Ho_Ad_Phone_Num;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */

@Repository
public interface Ho_Ad_House_Security_Repository extends CrudRepository<Ho_Ad_House_Security, Integer> {
  
}
