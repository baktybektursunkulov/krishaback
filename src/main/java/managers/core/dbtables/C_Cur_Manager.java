package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Cur_Manager extends Abstract_Controller_Manager<C_Cur> {

  private static C_Cur_Manager currentInstance = null;

  public static C_Cur_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Cur_Manager();
    }
    return currentInstance;
  }

  public C_Cur_Manager() {
    super(C_Cur.class);
  }

}
