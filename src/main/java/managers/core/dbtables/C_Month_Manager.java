package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Month_Manager extends Abstract_Controller_Manager<C_Month> {

  private static C_Month_Manager currentInstance = null;

  public static C_Month_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Month_Manager();
    }
    return currentInstance;
  }

  public C_Month_Manager() {
    super(C_Month.class);
  }

}
