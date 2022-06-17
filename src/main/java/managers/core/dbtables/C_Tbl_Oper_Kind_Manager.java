package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;

@ManagedBean
@ApplicationScoped
public class C_Tbl_Oper_Kind_Manager extends Abstract_Controller_Manager<C_Tbl_Oper_Kind> {

  private static C_Tbl_Oper_Kind_Manager currentInstance = null;

  public static C_Tbl_Oper_Kind_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Oper_Kind_Manager();
    }
    return currentInstance;
  }

  public C_Tbl_Oper_Kind_Manager() {
    super(C_Tbl_Oper_Kind.class);
  }

}
