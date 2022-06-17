package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Res_Bundle_Base_Manager extends Abstract_Controller_Manager<C_Res_Bundle_Base> {

  private static C_Res_Bundle_Base_Manager currentInstance = null;

  public static C_Res_Bundle_Base_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Res_Bundle_Base_Manager();
    }
    return currentInstance;
  }

  public C_Res_Bundle_Base_Manager() {
    super(C_Res_Bundle_Base.class);
  }

}
