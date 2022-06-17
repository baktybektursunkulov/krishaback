package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Text_Match_Mode_Manager extends Abstract_Controller_Manager<C_Text_Match_Mode> {

  private static C_Text_Match_Mode_Manager currentInstance = null;

  public static C_Text_Match_Mode_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Text_Match_Mode_Manager();
    }
    return currentInstance;
  }

  public C_Text_Match_Mode_Manager() {
    super(C_Text_Match_Mode.class);
  }

}
