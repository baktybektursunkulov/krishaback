package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Order_Condition;
import gs.common.model.db.SQL_Where_Condition;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class C_Period_Type_Manager extends Abstract_Controller_Manager<C_Period_Type> {

  private static C_Period_Type_Manager currentInstance = null;

  public static C_Period_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Period_Type_Manager();
    }
    return currentInstance;
  }

  public C_Period_Type_Manager() {
    super(C_Period_Type.class);
  }

  public List<C_Period_Type> get_active_c_period_type_list() {
    return get_rec_list_5_c(new SQL_Where_Condition("is_deleted=false and is_active=true"), new SQL_Order_Condition("c_period_type", "asc"), true);
  }

  public List<C_Period_Type> get_c_period_type_list_for_c_obj_tariff() {
    return get_rec_list_5_c(new SQL_Where_Condition("is_deleted=false and code in ('day', 'month', 'year')"), new SQL_Order_Condition("c_period_type", "asc"), true);
  }

  public List<C_Period_Type> get_c_period_type_list_for_c_usr_tariff() {
    return get_rec_list_5_c(new SQL_Where_Condition("is_deleted=false and code in ('day', 'month', 'year')"), new SQL_Order_Condition("c_period_type", "asc"), true);
  }

  public List<C_Period_Type> get_c_period_type_list_for_rep_interval() {
    return get_rec_list_5_c(new SQL_Where_Condition("is_deleted=false and code in ('minute', 'hour', 'day', 'week', 'month', 'year')"), new SQL_Order_Condition("order_num", "asc"), true);
  }   
}
