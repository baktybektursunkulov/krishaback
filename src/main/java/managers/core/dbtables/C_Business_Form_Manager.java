package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Business_Form_Manager extends Abstract_Controller_Manager<C_Business_Form> {

  private static C_Business_Form_Manager currentInstance = null;

  public static C_Business_Form_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Business_Form_Manager();
    }
    return currentInstance;
  }

  public C_Business_Form_Manager() {
    super(C_Business_Form.class);
  }

}
