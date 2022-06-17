package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Volume_Unit_Manager extends Abstract_Controller_Manager<C_Volume_Unit> {

  private static C_Volume_Unit_Manager currentInstance = null;

  public static C_Volume_Unit_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Volume_Unit_Manager();
    }
    return currentInstance;
  }

  public C_Volume_Unit_Manager() {
    super(C_Volume_Unit.class);
  }

}
