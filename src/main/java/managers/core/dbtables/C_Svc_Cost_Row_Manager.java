package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Svc_Cost_Row_Manager extends Abstract_Controller_Manager<C_Svc_Cost_Row> {

  private static C_Svc_Cost_Row_Manager currentInstance = null;

  public static C_Svc_Cost_Row_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Svc_Cost_Row_Manager();
    }
    return currentInstance;
  }

  public C_Svc_Cost_Row_Manager() {
    super(C_Svc_Cost_Row.class);
  }

}
