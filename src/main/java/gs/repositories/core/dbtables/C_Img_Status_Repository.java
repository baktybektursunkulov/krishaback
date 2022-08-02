package gs.repositories.core.dbtables;

import model.core.dbtables.C_Img_Status;
import model.core.dbtables.C_Tbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface C_Img_Status_Repository extends JpaRepository<C_Img_Status, Integer> {
  public final static Integer id__moderation = 1;
  public final static Integer id__approved = 2;
  public final static Integer id__refused = 3;
}
