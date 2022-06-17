package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class Jr_Lov_Manager extends Abstract_Controller_Manager<Jr_Lov> {

  private static Jr_Lov_Manager currentInstance = null;

  public static Jr_Lov_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Lov_Manager();
    }
    return currentInstance;
  }

  public Jr_Lov_Manager() {
    super(Jr_Lov.class);
  }

}
