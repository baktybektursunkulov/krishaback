package gs.repositories.ho.dbtables;

import gs.payload.response.horesponse.HoAdCatResponse;
import gs.payload.response.horesponse.HoCatResponse;
import gs.repositories.core.dbtables.*;
import java.util.List;
import java.util.Optional; 
import model.ho.dbtables.Ho_Build_Type;
import model.ho.dbtables.Ho_Cat;
import model.ho.dbtables.Ho_Resid_Complex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_Resid_Complex_Repository extends JpaRepository<Ho_Resid_Complex, Integer> {

  @Query("select t.ho_resid_complex as id, t.name as name  from Ho_Resid_Complex t where t.is_deleted=false ")
  List<HoAdCatResponse> find_all();
  
  @Query("select t from Ho_Resid_Complex t where t.is_deleted=false ")
  List<Ho_Resid_Complex> find_all1();
  
}

