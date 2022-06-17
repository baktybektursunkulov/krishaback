package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class Jr_Rep_Tpl_Manager extends Abstract_Controller_Manager<Jr_Rep_Tpl> {

  private static Jr_Rep_Tpl_Manager currentInstance = null;

  public static Jr_Rep_Tpl_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Rep_Tpl_Manager();
    }
    return currentInstance;
  }

  public Jr_Rep_Tpl_Manager() {
    super(Jr_Rep_Tpl.class);
  }

}
