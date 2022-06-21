/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gs.repositories.ho.dbtables;

import java.util.List;
import model.ho.dbtables.Ho_Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface Ho_Usr_Repository extends JpaRepository<Ho_Usr, Integer> {

  @Query("select t from Ho_Usr t where is_deleted=false")
  List<Ho_Usr> find_all();

  @Query("select t from Ho_Usr t where t.is_deleted=false and t.c_usr=:c_usr_id_ ")
  Ho_Usr find_rec_by_c_usr_id(@Param("c_usr_id_") Long c_usr_id_);

}
