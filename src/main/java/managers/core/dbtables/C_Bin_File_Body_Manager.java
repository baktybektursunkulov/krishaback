package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Bin_File_Body_Manager extends Abstract_Controller_Manager<C_Bin_File_Body> {

  private static C_Bin_File_Body_Manager currentInstance = null;

  public static C_Bin_File_Body_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Bin_File_Body_Manager();
    }
    return currentInstance;
  }

  public C_Bin_File_Body_Manager() {
    super(C_Bin_File_Body.class);
  }

  public Long ins_row(Session session_, byte[] byte_arr_) {
    C_Bin_File_Body bin_File_Body = new C_Bin_File_Body();
    bin_File_Body.setFile_body(byte_arr_);
    session_.save(bin_File_Body);
    return bin_File_Body.getC_bin_file_body();
  }
}
