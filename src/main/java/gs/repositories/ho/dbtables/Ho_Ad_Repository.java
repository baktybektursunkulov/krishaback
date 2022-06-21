package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 
import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_House_Shop_Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Ad_Repository extends CrudRepository<Ho_Ad, Integer> {

//  @Query("select t from Ho_Cat t")
//  List<Ho_Ad> find_all();
//  
  
//  public void insertProfile(String firstName, String lastName, int age) {
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("firstName", firstName);
//        params.addValue("lastName", lastName);
//        params.addValue("age", age);
//        jdbcTemplate.update(SQL_INSERT_PROFILE, params);
//    } 
//  
//  @Query ("select t from Ho_Ad t ")
//  List<Ho_Ad> ad_post();
//  
//  @Query ("insert into Ho_Ad (floor) values (:floor)")
//  Ho_Ad save1(@Param("floor") Integer floor);
//  
//  @Query("select t from Ho_Cat t where t.is_deleted=false and parent_id is null")
//  List<Ho_Ad> find_page_title();
//  
//  @Query("select t from Ho_Cat t where t.ho_cat=:id_ ")
//  Ho_Ad find_by_id(@Param("id_") Integer id_);
//  
//  @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=:parent_id order by order_num")
//  List<Ho_Ad> get_subcat_list(@Param("parent_id") Integer parent_id);
//  
//  @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=6 order by order_num")
//  List<Ho_Ad> get_seocontent_menu_list();
//  
//  @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=2 order by order_num")
//  List<Ho_Ad> get_sell_rent_cat();
//  
// @Query("select t from Ho_Cat t where  t.is_deleted=false and t.parent_id=:parent_id order by order_num")
//  List<Ho_Ad> get_sell_rent_subcat(@Param("parent_id") Integer parent_id);
}

