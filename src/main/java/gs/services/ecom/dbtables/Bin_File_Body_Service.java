package gs.services.ecom.dbtables;

import model.ecom.dbtables.Bin_File_Body;
import gs.repositories.core.dbtables.*;
import gs.repositories.ecom.dbtables.Bin_File_Body_Repository;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import model.core.dbtables.C_Bin_File_Body;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Bin_File_Body_Service {

  @Autowired
  private Bin_File_Body_Repository bin_File_Body_Repository;

  @Autowired
  private C_Bin_File_Body_Repository c_Bin_File_Body_Repository;

  /*
  public Bin_File_Body store(MultipartFile file) throws IOException {
    //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Bin_File_Body Bin_File_Body = new Bin_File_Body(file.getBytes());

    return bin_File_Body_Repository.save(Bin_File_Body);
  }
   */
  public Bin_File_Body store_2(Long id_, byte[] byte_arr_) throws IOException {
    //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Bin_File_Body Bin_File_Body = new Bin_File_Body(id_, byte_arr_);

    return bin_File_Body_Repository.save(Bin_File_Body);
  }

  public Bin_File_Body getFile(Long id) {
    return bin_File_Body_Repository.findById(id).get();
  }

  public Stream<Bin_File_Body> getAllFiles() {
    return bin_File_Body_Repository.findAll().stream();
  }

  public List<Bin_File_Body> findAll() {
    return bin_File_Body_Repository.findAll();
  }

  public List<Bin_File_Body> migrate() {
    List<Bin_File_Body> bin_File_Bodys = bin_File_Body_Repository.findAll();
    C_Bin_File_Body c_Bin_File_Body;
    int i = 0;
    for (Bin_File_Body bin_File_Body : bin_File_Bodys) {
      c_Bin_File_Body = new C_Bin_File_Body(bin_File_Body.getBin_file_body(), bin_File_Body.getFile_body());
      c_Bin_File_Body_Repository.save(c_Bin_File_Body);
      System.out.println(i++);
    }
    bin_File_Bodys.clear();
    return bin_File_Bodys;
  }

}
