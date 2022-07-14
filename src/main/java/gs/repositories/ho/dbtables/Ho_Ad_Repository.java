package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoCatResponse;
import gs.payload.response.horesponse.HoPhoneResponse;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 
import model.ho.dbtables.Ho_Ad;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_House_Balcony;
import model.ho.dbtables.Ho_House_Shop_Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Ad_Repository extends CrudRepository<Ho_Ad, Integer> {

  @Query("select t.ho_ad from Ho_Ad t where t.is_deleted=false and t.ho_cat=30 order by t.ho_ad")
  List<Integer> find_all();
  @Query( "select t from Ho_Ad t where t.ho_cat=:id_ and t.is_deleted=false order by t.ho_ad ")
  List<Ho_Ad> find(@Param("id_") Integer id_);
  @Query("select t from Ho_Ad t where t.is_deleted=false and t.ho_cat=20 order by t.ho_ad")
  List<Ho_Ad> findall();
}

