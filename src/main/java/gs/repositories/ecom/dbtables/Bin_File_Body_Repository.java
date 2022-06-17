package gs.repositories.ecom.dbtables;

import model.core.dbtables.C_Bin_File_Body;
import model.ecom.dbtables.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface Bin_File_Body_Repository extends JpaRepository<Bin_File_Body, Long> {

  @Query("select t from Bin_File_Body t where t.bin_file_body=:id_ ")
  Optional<Bin_File_Body> find_by_id(@Param("id_") Long id_);

  @Override
  List<Bin_File_Body> findAll();

  @Query("delete from Bin_File_Body where bin_file_body=:id_ ")
  void del_by_id(@Param("id_") Long id_);
}
