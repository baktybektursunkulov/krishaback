package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Order_Condition;
import gs.common.model.db.SQL_Where_Condition;
import java.util.List;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class C_Svc_Manager extends Abstract_Controller_Manager<C_Svc> {

  private static C_Svc_Manager currentInstance = null;

  public static C_Svc_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Svc_Manager();
    }
    return currentInstance;
  }

  public C_Svc_Manager() {
    super(C_Svc.class);
  }

  public List<C_Svc> get_active_rec_list_sorted_by_name() {
    return get_rec_list_5_c(new SQL_Where_Condition("is_deleted=false and is_active=true"), new SQL_Order_Condition("name", "asc"), true);
  }

  public List<C_Svc> get_active_rec_list_sorted_by_name_2(Session session_) {
    return get_rec_list_5_1_c(session_, new SQL_Where_Condition("is_deleted=false and is_active=true"), new SQL_Order_Condition("name", "asc"), true);
  }   
}
