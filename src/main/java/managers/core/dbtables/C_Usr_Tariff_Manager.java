package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Usr_Tariff_Manager extends Abstract_Controller_Manager<C_Usr_Tariff> {

  private static C_Usr_Tariff_Manager currentInstance = null;

  public static C_Usr_Tariff_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Tariff_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Tariff_Manager() {
    super(C_Usr_Tariff.class);
  }

}
