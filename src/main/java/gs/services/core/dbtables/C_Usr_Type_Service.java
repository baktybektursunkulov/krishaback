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
public class C_Usr_Type_Service {

  public Integer id__admin = 1;
  public Integer id__user = 2;
  public Integer id__seller = 3;
  public Integer id__customer = 5;

  @Autowired
  private C_Usr_Type_Repository repository;

}
