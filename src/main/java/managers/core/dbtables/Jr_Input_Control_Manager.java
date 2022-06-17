package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class Jr_Input_Control_Manager extends Abstract_Controller_Manager<Jr_Input_Control> {

  private static Jr_Input_Control_Manager currentInstance = null;

  public static Jr_Input_Control_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Input_Control_Manager();
    }
    return currentInstance;
  }

  public Jr_Input_Control_Manager() {
    super(Jr_Input_Control.class);
  }

}
