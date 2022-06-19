package managers.ho.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.ho.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;
import managers.core.dbtables.Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class Ho_Contact_Info_Type_Manager extends Abstract_Controller_Manager<Ho_Contact_Info_Type> {

  private static Ho_Contact_Info_Type_Manager currentInstance = null;

  public static Ho_Contact_Info_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Ho_Contact_Info_Type_Manager();
    }
    return currentInstance;
  }

  public Ho_Contact_Info_Type_Manager() {
    super(Ho_Contact_Info_Type.class);
  }

}
