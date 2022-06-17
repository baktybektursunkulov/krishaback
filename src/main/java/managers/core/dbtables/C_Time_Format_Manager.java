package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Time_Format_Manager extends Abstract_Controller_Manager<C_Time_Format> {

  private static C_Time_Format_Manager currentInstance = null;

  public static C_Time_Format_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Time_Format_Manager();
    }
    return currentInstance;
  }

  public C_Time_Format_Manager() {
    super(C_Time_Format.class);
  }

}
