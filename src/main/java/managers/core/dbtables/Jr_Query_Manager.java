package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class Jr_Query_Manager extends Abstract_Controller_Manager<Jr_Query> {

  private static Jr_Query_Manager currentInstance = null;

  public static Jr_Query_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Query_Manager();
    }
    return currentInstance;
  }

  public Jr_Query_Manager() {
    super(Jr_Query.class);
  }

}
