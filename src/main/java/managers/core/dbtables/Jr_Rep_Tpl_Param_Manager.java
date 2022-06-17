package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Order_Condition;
import gs.common.model.db.SQL_Where_Condition;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class Jr_Rep_Tpl_Param_Manager extends Abstract_Controller_Manager<Jr_Rep_Tpl_Param> {

  private static Jr_Rep_Tpl_Param_Manager currentInstance = null;

  public static Jr_Rep_Tpl_Param_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Rep_Tpl_Param_Manager();
    }
    return currentInstance;
  }

  public Jr_Rep_Tpl_Param_Manager() {
    super(Jr_Rep_Tpl_Param.class);
  }

  public List<Jr_Rep_Tpl_Param> get_jr_rep_tpl_param_list(Integer jr_rep_tpl_id_) {
    return get_rec_list_5_c(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()), new SQL_Order_Condition("order_num", "asc"), true);
  }

  public List<Jr_Rep_Tpl_Param> get_jr_rep_tpl_param_list(Session session_, Integer jr_rep_tpl_id_) {
    return get_rec_list_5_1_c(session_, new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()), new SQL_Order_Condition("order_num", "asc"), true);
  }

  public boolean is_jr_rep_tpl_has_period_params(Integer jr_rep_tpl_id_) {
    if (jr_rep_tpl_id_ == null) {
      return false;
    }
    List<SQL_Where_Condition> sql_where_condition_list_ = new ArrayList();
    sql_where_condition_list_.add(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()));
    sql_where_condition_list_.add(new SQL_Where_Condition("(code = 'begin_dt' or code='end_dt')"));
    List<Jr_Rep_Tpl_Param> list_ = get_rec_list_9_c(sql_where_condition_list_, new SQL_Order_Condition("jr_rep_tpl_param", "asc"), true);
    
    return (list_ != null && !list_.isEmpty());
  }
  
  public boolean is_jr_rep_tpl_has_period_params(Session session_, Integer jr_rep_tpl_id_) {
    if (jr_rep_tpl_id_ == null) {
      return false;
    }
    List<SQL_Where_Condition> sql_where_condition_list_ = new ArrayList();
    sql_where_condition_list_.add(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()));
    sql_where_condition_list_.add(new SQL_Where_Condition("(code = 'begin_dt' or code='end_dt')"));
    List<Jr_Rep_Tpl_Param> list_ = get_rec_list_9_1_c(session_, sql_where_condition_list_, new SQL_Order_Condition("jr_rep_tpl_param", "asc"), true);
    
    return (list_ != null && !list_.isEmpty());
  }

  public boolean is_jr_rep_tpl_has_obj_params(Integer jr_rep_tpl_id_) {
    if (jr_rep_tpl_id_ == null) {
      return false;
    }
    List<SQL_Where_Condition> sql_where_condition_list_ = new ArrayList();
    sql_where_condition_list_.add(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()));
    sql_where_condition_list_.add(new SQL_Where_Condition("(code = 'obj_id')"));
    List<Jr_Rep_Tpl_Param> list_ = get_rec_list_9_c(sql_where_condition_list_, new SQL_Order_Condition("jr_rep_tpl_param", "asc"), true);
    
    return (list_ != null && !list_.isEmpty());
  }

  public boolean is_jr_rep_tpl_has_obj_params(Session session_, Integer jr_rep_tpl_id_) {
    if (jr_rep_tpl_id_ == null) {
      return false;
    }
    List<SQL_Where_Condition> sql_where_condition_list_ = new ArrayList();
    sql_where_condition_list_.add(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()));
    sql_where_condition_list_.add(new SQL_Where_Condition("(code = 'obj_id')"));
    List<Jr_Rep_Tpl_Param> list_ = get_rec_list_9_1_c(session_, sql_where_condition_list_, new SQL_Order_Condition("jr_rep_tpl_param", "asc"), true);
    
    return (list_ != null && !list_.isEmpty());
  }

  public boolean is_jr_rep_tpl_has_add_params(Integer jr_rep_tpl_id_) {
    if (jr_rep_tpl_id_ == null) {
      return false;
    }
    List<SQL_Where_Condition> sql_where_condition_list_ = new ArrayList();
    sql_where_condition_list_.add(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()));
    sql_where_condition_list_.add(new SQL_Where_Condition("code not in ('obj_id', 'begin_dt', 'end_dt')"));
    sql_where_condition_list_.add(new SQL_Where_Condition("is_visible = true"));
    List<Jr_Rep_Tpl_Param> list_ = get_rec_list_9_c(sql_where_condition_list_, new SQL_Order_Condition("jr_rep_tpl_param", "asc"), true);
    
    return (list_ != null && !list_.isEmpty());
  }

  public boolean is_jr_rep_tpl_has_add_params(Session session_, Integer jr_rep_tpl_id_) {
    if (jr_rep_tpl_id_ == null) {
      return false;
    }
    List<SQL_Where_Condition> sql_where_condition_list_ = new ArrayList();
    sql_where_condition_list_.add(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()));
    sql_where_condition_list_.add(new SQL_Where_Condition("code not in ('obj_id', 'begin_dt', 'end_dt')"));
    sql_where_condition_list_.add(new SQL_Where_Condition("is_visible = true"));
    List<Jr_Rep_Tpl_Param> list_ = get_rec_list_9_1_c(session_, sql_where_condition_list_, new SQL_Order_Condition("jr_rep_tpl_param", "asc"), true);
    
    return (list_ != null && !list_.isEmpty());
  }  
}
