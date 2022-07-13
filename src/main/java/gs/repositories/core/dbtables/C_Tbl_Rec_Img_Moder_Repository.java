/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gs.repositories.core.dbtables;

import java.util.List;
import java.util.Optional;
import model.core.dbtables.C_Img;
import model.core.dbtables.C_Tbl_Rec_Img_Moder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface C_Tbl_Rec_Img_Moder_Repository extends JpaRepository<C_Tbl_Rec_Img_Moder, Long> {

  @Query(value="select t from C_Tbl_Rec_Img_Moder t where t.c_tbl=12 and t.rec_id=:id_ and t.c_img_kind=1 and t.c_img_status=2 and t.is_deleted=false order by t.c_tbl_rec_img_moder asc")
  List<C_Tbl_Rec_Img_Moder> find_all(@Param("id_") Long id_);

  @Query(" select count(t.c_tbl_rec_img_moder) from C_Tbl_Rec_Img_Moder t where t.c_tbl=12 and t.rec_id=:id_ and t.c_img_kind=2 and t.c_img_status=2 and t.is_deleted=false")
  Integer find_all_small(@Param("id_") Long id_);

}
