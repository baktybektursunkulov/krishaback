package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class File_Type_Manager extends Abstract_Controller_Manager<C_File_Type> {

  private static File_Type_Manager currentInstance = null;

  public static File_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new File_Type_Manager();
    }
    return currentInstance;
  }

  public File_Type_Manager() {
    super(C_File_Type.class);
  }

}
