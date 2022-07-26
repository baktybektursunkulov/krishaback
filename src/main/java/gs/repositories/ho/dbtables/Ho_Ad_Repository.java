package gs.repositories.ho.dbtables;
import java.util.List;
import model.ho.dbtables.Ho_Ad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Ad_Repository extends JpaRepository<Ho_Ad, Integer> {

  @Query("select t.ho_ad from Ho_Ad t where t.is_deleted=false and t.ho_cat=30 order by t.ho_ad")
  List<Integer> find_all();
  
  @Query("select t from Ho_Ad t where t.ho_cat=:id_ and t.is_deleted=false order by t.ho_ad ")
  List<Ho_Ad> find(@Param("id_") Integer id_);
  
  @Query(value="select * from Ho_Ad  where Ho_Ad.ho_cat=?1 and Ho_Ad.is_deleted=false order by Ho_Ad.ho_ad limit ?2 offset ?3",nativeQuery=true)
  List<Ho_Ad> pagination(@Param("id_") Integer id_,Integer limit,Integer offset);
  
  @Query("select t from Ho_Ad t where t.is_deleted=false and t.ho_cat=20 order by t.ho_ad")
  List<Ho_Ad> findall();
  
  @Query( "select t from Ho_Ad t where t.ho_ad=:id_ and t.is_deleted=false ")
  Ho_Ad find_by_id(@Param("id_") Integer id_);
  
  @Query("select count(t.ho_ad) from Ho_Ad t where t.is_deleted=false and t.ho_cat=:id_")
  Integer countofcat(@Param("id_") Integer id_);
 
}

