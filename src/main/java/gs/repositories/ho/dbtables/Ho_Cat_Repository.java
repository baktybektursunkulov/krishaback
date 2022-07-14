package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 
import model.ho.dbtables.Ho_Cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Cat_Repository extends JpaRepository<Ho_Cat, Integer> {
  @Query("select t.ho_cat from Ho_Cat t where t.is_deleted=false and parent_id=:id_ order by t.ho_cat")
  List<Integer>ho_cat_sell(@Param("id_") Integer id_);
  
   @Query("select t.ho_cat from Ho_Cat t where t.is_deleted=false and parent_id=:id_ and t.order_num=:order_num_ order by t.ho_cat")
  List<Integer>ho_cat_sell_rent(@Param("id_") Integer id_,@Param("order_num_") Integer order_num_);
  
  @Query("select t from Ho_Cat t where t.is_deleted=false and parent_id is null")
  List<Ho_Cat> find_all();
  
  @Query("select t from Ho_Cat t where t.is_deleted=false and parent_id is null")
  List<Ho_Cat> find_page_title();
  
  @Query("select t from Ho_Cat t where t.ho_cat=:id_ ")
  Ho_Cat find_by_id(@Param("id_") Integer id_);
  
  @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=:parent_id order by order_num")
  List<Ho_Cat> get_subcat_list(@Param("parent_id") Integer parent_id);
  
  @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=6 order by order_num")
  List<Ho_Cat> get_seocontent_menu_list();
  
  @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=2 order by order_num")
  List<Ho_Cat> get_sell_rent_cat();
  
 @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=:parent_id order by order_num")
  List<Ho_Cat> get_sell_rent_subcat(@Param("parent_id") Integer parent_id);
}

