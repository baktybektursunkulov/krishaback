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
public class C_Usr_Bank_Card_Manager extends Abstract_Controller_Manager<C_Usr_Bank_Card> {

  private static C_Usr_Bank_Card_Manager currentInstance = null;

  public static C_Usr_Bank_Card_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Bank_Card_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Bank_Card_Manager() {
    super(C_Usr_Bank_Card.class);
  }

}
