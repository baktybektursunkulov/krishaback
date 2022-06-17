package gs.repositories.ad.dbtables;

import model.ad.dbtables.Ad_Cat;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ad_Cat_Repository extends JpaRepository<Ad_Cat, Integer> {

  @Query("select t from Ad_Cat t where t.is_deleted=false and parent_id is null")
  List<Ad_Cat> find_all();
  
  @Query("select t from Ad_Cat t where t.ad_cat=:id_ ")
  Ad_Cat find_by_id(@Param("id_") Integer id_);
  
  @Query("select t from Ad_Cat t where t.is_deleted=false and t.parent_id=:parent_id")
  List<Ad_Cat> find_all_sub_prod_cat(@Param("parent_id") Integer parent_id);
}

