package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Speed_Unit_Manager extends Abstract_Controller_Manager<C_Speed_Unit> {

  private static C_Speed_Unit_Manager currentInstance = null;

  public static C_Speed_Unit_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Speed_Unit_Manager();
    }
    return currentInstance;
  }

  public C_Speed_Unit_Manager() {
    super(C_Speed_Unit.class);
  }

}
