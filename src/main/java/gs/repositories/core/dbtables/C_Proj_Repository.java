package gs.repositories.core.dbtables;

import model.core.dbtables.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface C_Proj_Repository extends JpaRepository<C_Proj, Integer> {

}
