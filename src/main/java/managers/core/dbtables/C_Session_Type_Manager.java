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
public class C_Session_Type_Manager extends Abstract_Controller_Manager<C_Session_Type> {

  private static C_Session_Type_Manager currentInstance = null;
  public static final Integer c_session_type_id__web = 1;
  public static final Integer c_session_type_id__mobile = 2;

  public static C_Session_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Session_Type_Manager();
    }
    return currentInstance;
  }

  public C_Session_Type_Manager() {
    super(C_Session_Type.class);
  }

}
