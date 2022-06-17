package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Geocoding_Service_Manager extends Abstract_Controller_Manager<C_Geocoding_Service> {

  private static C_Geocoding_Service_Manager currentInstance = null;

  public static C_Geocoding_Service_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Geocoding_Service_Manager();
    }
    return currentInstance;
  }

  public C_Geocoding_Service_Manager() {
    super(C_Geocoding_Service.class);
  }

}
