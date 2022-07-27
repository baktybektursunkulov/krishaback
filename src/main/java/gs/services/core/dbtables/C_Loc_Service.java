package gs.services.core.dbtables;

import gs.payload.response.horesponse.*;
import model.core.dbtables.*;
import gs.repositories.core.dbtables.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class C_Loc_Service {

  @Autowired
  private C_Loc_Repository c_loc_repository;
}
