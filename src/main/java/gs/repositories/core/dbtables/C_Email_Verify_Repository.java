package gs.repositories.core.dbtables;

import model.core.dbtables.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface C_Email_Verify_Repository extends JpaRepository<C_Email_Verify, Integer> {

  @Query("select t from C_Email_Verify t where t.c_email_verify=:id_ ")
  Optional<C_Email_Verify> get_by_id(@Param("id_") Integer id_);

  @Query("select t from C_Email_Verify t where t.is_deleted=false and t.email=:email_ and t.verif_code=:verif_code_ and t.is_verified=0 ")
  Optional<C_Email_Verify> get_by_verif_code(@Param("email") String email_, @Param("verif_code") String verif_code_);

}
