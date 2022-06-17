package gs.repositories.core.dbtables;

import model.core.dbtables.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface C_Bin_File_Body_Repository extends JpaRepository<C_Bin_File_Body, Long> {

  @Query("select t from C_Bin_File_Body t where t.c_bin_file_body=:id_ ")
  Optional<C_Bin_File_Body> find_by_id(@Param("id_") Long id_);

  @Override
  List<C_Bin_File_Body> findAll();

  @Query("delete from C_Bin_File_Body where c_bin_file_body=:id_ ")
  void del_by_id(@Param("id_") Long id_);
}
