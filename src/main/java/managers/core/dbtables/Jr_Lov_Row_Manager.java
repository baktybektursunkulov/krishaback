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
public class Jr_Lov_Row_Manager extends Abstract_Controller_Manager<Jr_Lov_Row> {

  private static Jr_Lov_Row_Manager currentInstance = null;

  public static Jr_Lov_Row_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Lov_Row_Manager();
    }
    return currentInstance;
  }

  public Jr_Lov_Row_Manager() {
    super(Jr_Lov_Row.class);
  }

  public List<Jr_Lov_Row> get_jr_lov_row_list(Integer jr_lov_id_) {
    return get_rec_list_5_c(new SQL_Where_Condition("jr_lov.jr_lov", "=", jr_lov_id_.toString()), new SQL_Order_Condition("jr_lov_row", "asc"), true);
  }

  public List<Jr_Lov_Row> get_jr_lov_row_list(Session session_, Integer jr_lov_id_) {
    return get_rec_list_5_1_c(session_, new SQL_Where_Condition("jr_lov.jr_lov", "=", jr_lov_id_.toString()), new SQL_Order_Condition("jr_lov_row", "asc"), true);
  } 
  
}
