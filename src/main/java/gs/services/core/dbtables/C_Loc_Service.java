package gs.services.core.dbtables;

import gs.payload.response.horesponse.HoCLocResponse;
import model.core.dbtables.*;
import gs.repositories.core.dbtables.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class C_Loc_Service {

  @Autowired
  private C_Loc_Repository c_loc_repository;

//  public Optional<HoCLocResponse> findbyid(Long id) {
//    return c_loc_repository.findById(id);
//  }
}
