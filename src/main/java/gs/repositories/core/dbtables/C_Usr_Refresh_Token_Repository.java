package gs.repositories.core.dbtables;

import model.core.dbtables.C_Usr_Refresh_Token;
import model.core.dbtables.C_Usr;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface C_Usr_Refresh_Token_Repository extends JpaRepository<C_Usr_Refresh_Token, Long> {

  @Query("select t from C_Usr_Refresh_Token t where t.is_deleted=false and t.refresh_token=:refresh_token_ ")
  Optional<C_Usr_Refresh_Token> find_by_refresh_token(@Param("refresh_token_") String refresh_token_);

  @Query("delete from C_Usr_Refresh_Token where c_usr=:c_usr_id_ ")
  @Modifying
  void del_by_c_usr_id(@Param("c_usr_id_") Long c_usr_id_);
  
  @Query("delete from C_Usr_Refresh_Token where refresh_token=:refresh_token_ ")
  @Modifying
  void del_by_refresh_token(@Param("refresh_token_") String refresh_token_);
  
}
