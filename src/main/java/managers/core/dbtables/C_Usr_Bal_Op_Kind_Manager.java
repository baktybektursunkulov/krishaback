package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class C_Usr_Bal_Op_Kind_Manager extends Abstract_Controller_Manager<C_Usr_Bal_Op_Kind> {

  private static C_Usr_Bal_Op_Kind_Manager currentInstance = null;

  public static C_Usr_Bal_Op_Kind_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Bal_Op_Kind_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Bal_Op_Kind_Manager() {
    super(C_Usr_Bal_Op_Kind.class);
  }

  public static C_Usr_Bal_Op_Kind get_bal_increase_c_usr_bal_op_kind(Session session_) {
    return (C_Usr_Bal_Op_Kind) session_.load(C_Usr_Bal_Op_Kind.class, 1);// Пополнение баланса
  }

  public static C_Usr_Bal_Op_Kind get_bal_decrease_c_usr_bal_op_kind(Session session_) {
    return (C_Usr_Bal_Op_Kind) session_.load(C_Usr_Bal_Op_Kind.class, 2);// Снятие баланса
  }  
}
