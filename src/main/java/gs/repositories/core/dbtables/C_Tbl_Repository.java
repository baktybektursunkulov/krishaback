package gs.repositories.core.dbtables;

import model.core.dbtables.C_Tbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface C_Tbl_Repository extends JpaRepository<C_Tbl, Integer> {
  public final static Integer id__ho_ad = 12;
}
