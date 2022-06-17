package lists.core.dbtables;

import filters.core.dbtables.*;
import gs.common.model.db.SQL_Where_Condition;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class Jr_Rep_Tpl_List_Bean extends Abstract_List_Bean<Jr_Rep_Tpl> {

  public Jr_Rep_Tpl_List_Bean() {
    super("Jr_Rep_Tpl", (Jr_Rep_Tpl_Filter_Bean) jsf_funcs.findBean("jr_Rep_Tpl_Filter_Bean"));
  }

  public LazyDataModel<Jr_Rep_Tpl> getConverted_rec_list() {
    return getRec_list();
  }

  public Jr_Rep_Tpl_Filter_Bean getFilter_bean_wrapped() {
    return (Jr_Rep_Tpl_Filter_Bean) getFilter_bean();
  }
  
  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    if (getFilter_bean_wrapped().getFilter_entity_wrapped().getName()!= null && !getFilter_bean_wrapped().getFilter_entity_wrapped().getName().trim().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(name)", "like", "'%" +getFilter_bean_wrapped().getFilter_entity_wrapped().getName().toLowerCase().trim() + "%'"));
    }
  }
  
}
