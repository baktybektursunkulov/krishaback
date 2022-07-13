/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.repositories.core.dbtables;

import model.core.dbtables.C_Bin_File_Body;
import model.core.dbtables.C_Img;
import model.core.dbtables.C_Tbl_Rec_Img_Moder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface C_Img_Repository extends JpaRepository<C_Img, Long> {
  @Query("select t from C_Img t where t.c_img=:id_ and  t.is_deleted=false")
  C_Img find_all(@Param("id_") Long id_);
}
