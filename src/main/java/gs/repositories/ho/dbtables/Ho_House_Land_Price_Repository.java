package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 
import model.ho.dbtables.Ho_Build_Type;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_House_Balcony;
import model.ho.dbtables.Ho_House_Inet;
import model.ho.dbtables.Ho_House_Land_Price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_House_Land_Price_Repository extends JpaRepository<Ho_House_Land_Price, Integer> {

  @Query("select t.ho_house_land_price as id, t.name as name  from Ho_House_Land_Price t where t.is_deleted=false ")
  List<HoAdCatResponse> find_all();
  @Query("select t from Ho_House_Land_Price t where t.is_deleted=false ")
  List<Ho_House_Land_Price> find_all1();
}

