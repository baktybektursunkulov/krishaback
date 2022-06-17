package lists.core.dbtables;

import filters.core.dbtables.*;
import gs.common.model.db.SQL_Where_Condition;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class Jr_Rep_Tpl_Param_List_Bean extends Abstract_List_Bean<Jr_Rep_Tpl_Param> {

  public Jr_Rep_Tpl_Param_List_Bean() {
    super("Jr_Rep_Tpl_Param", (Jr_Rep_Tpl_Param_Filter_Bean) jsf_funcs.findBean("jr_Rep_Tpl_Param_Filter_Bean"));
  }

  public LazyDataModel<Jr_Rep_Tpl_Param> getConverted_rec_list() {
    return getRec_list();
  }

  public List<Jr_Rep_Tpl_Param> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public Jr_Rep_Tpl_Param_Filter_Bean getFilter_bean_wrapped() {
    return (Jr_Rep_Tpl_Param_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    if (getFilter_bean_wrapped().getFilter_entity_wrapped().getJr_rep_tpl()!= null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", getFilter_bean_wrapped().getFilter_entity_wrapped().getJr_rep_tpl().toString()));
    }
  }
  
  
}
