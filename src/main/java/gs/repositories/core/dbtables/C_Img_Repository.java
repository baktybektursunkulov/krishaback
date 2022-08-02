package gs.repositories.core.dbtables;

import java.util.List;
import model.core.dbtables.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface C_Img_Repository extends JpaRepository<C_Img, Long> {
  @Query("select t from C_Img t where t.c_img=:id_ and  t.is_deleted=false")
  C_Img find_all(@Param("id_") Long id_);
  
  @Query(" select t.c_tbl_rec_img_moder from C_Tbl_Rec_Img_Moder t where t.c_tbl=12 and t.rec_id=:id_ and t.c_img_kind=2 and t.c_img_status=2 and t.is_deleted=false")
  List<Integer> find_small_pictures(@Param("id_") Long id_);
}
