package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 
import model.ho.dbtables.Ho_House_Room_Cnt_Filter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_House_Room_Cnt_Filter_Repository extends JpaRepository<Ho_House_Room_Cnt_Filter, Integer> {

  @Query("select t from Ho_House_Room_Cnt_Filter t where t.is_deleted=false")
  List<Ho_House_Room_Cnt_Filter> find_all();
  
//  @Query("select t from Ho_Cat t where t.is_deleted=false and parent_id is null")
//  List<Ho_Cat> find_page_title();
//  
//  @Query("select t from Ho_Cat t where t.ho_cat=:id_ ")
//  Ho_Cat find_by_id(@Param("id_") Integer id_);
//  
//  @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=:parent_id order by order_num")
//  List<Ho_Cat> get_subcat_list(@Param("parent_id") Integer parent_id);
//  
//  @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=6 order by order_num")
//  List<Ho_Cat> get_seocontent_menu_list();
//  
//  @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=2 order by order_num")
//  List<Ho_Cat> get_sell_rent_cat();
  
//  @Query("select t from Ho_Cat t where t.is_deleted=false and t.parent_id=:parent_id")
//  List<Ho_Cat> find_all_sub_prod_cat(@Param("parent_id") Integer parent_id);
}

