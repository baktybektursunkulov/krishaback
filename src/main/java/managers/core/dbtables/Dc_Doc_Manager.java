package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class Dc_Doc_Manager extends Abstract_Controller_Manager<Dc_Doc> {

  private static Dc_Doc_Manager currentInstance = null;

  public static Dc_Doc_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Dc_Doc_Manager();
    }
    return currentInstance;
  }

  public Dc_Doc_Manager() {
    super(Dc_Doc.class);
  }

}
