package gs.repositories.ho.dbtables;

import java.util.List;
import model.ho.dbtables.Ho_House_Room_Cnt_Filter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Ho_House_Room_Cnt_Filter_Repository extends JpaRepository<Ho_House_Room_Cnt_Filter, Integer> {

  @Query("select t from Ho_House_Room_Cnt_Filter t where t.is_deleted=false")
  List<Ho_House_Room_Cnt_Filter> find_all();
  }

