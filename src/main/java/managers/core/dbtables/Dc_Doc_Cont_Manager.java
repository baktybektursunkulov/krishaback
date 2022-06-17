package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class Dc_Doc_Cont_Manager extends Abstract_Controller_Manager<Dc_Doc_Cont> {

  private static Dc_Doc_Cont_Manager currentInstance = null;

  public static Dc_Doc_Cont_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Dc_Doc_Cont_Manager();
    }
    return currentInstance;
  }

  public Dc_Doc_Cont_Manager() {
    super(Dc_Doc_Cont.class);
  }

}
