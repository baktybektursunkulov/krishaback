package gs.services.core.dbtables;

import model.core.dbtables.*;
import gs.repositories.core.dbtables.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class C_Usr_Status_Service {

  public Integer id__active = 1;
  public Integer id__blocked = 2;
  public Integer id__under_consideration = 3;

  @Autowired
  private C_Usr_Type_Repository repository;

}
