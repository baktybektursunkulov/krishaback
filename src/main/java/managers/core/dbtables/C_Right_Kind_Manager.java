package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Right_Kind_Manager extends Abstract_Controller_Manager<C_Right_Kind> {

  private static C_Right_Kind_Manager currentInstance = null;

  public static C_Right_Kind_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Right_Kind_Manager();
    }
    return currentInstance;
  }

  public C_Right_Kind_Manager() {
    super(C_Right_Kind.class);
  }

}
