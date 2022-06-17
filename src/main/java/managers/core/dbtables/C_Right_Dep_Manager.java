package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Right_Dep_Manager extends Abstract_Controller_Manager<C_Right_Dep> {

  private static C_Right_Dep_Manager currentInstance = null;

  public static C_Right_Dep_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Right_Dep_Manager();
    }
    return currentInstance;
  }

  public C_Right_Dep_Manager() {
    super(C_Right_Dep.class);
  }

}
