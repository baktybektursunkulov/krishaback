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
public class C_Bin_File_Body_Service {

  @Autowired
  private C_Bin_File_Body_Repository c_Bin_File_Body_Repository;

  /*
  public C_Bin_File_Body store(MultipartFile file) throws IOException {
    //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    C_Bin_File_Body C_Bin_File_Body = new C_Bin_File_Body(file.getBytes());

    return c_Bin_File_Body_Repository.save(C_Bin_File_Body);
  }
*/

  public C_Bin_File_Body store_2(Long id_, byte[] byte_arr_) throws IOException {
    //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    C_Bin_File_Body C_Bin_File_Body = new C_Bin_File_Body(id_, byte_arr_);

    return c_Bin_File_Body_Repository.save(C_Bin_File_Body);
  }
  
  public C_Bin_File_Body getFile(Long id) {
    return c_Bin_File_Body_Repository.findById(id).get();
  }

  public Stream<C_Bin_File_Body> getAllFiles() {
    return c_Bin_File_Body_Repository.findAll().stream();
  }
  
  public List<C_Bin_File_Body> findAll() {
    return c_Bin_File_Body_Repository.findAll();
  }
}
