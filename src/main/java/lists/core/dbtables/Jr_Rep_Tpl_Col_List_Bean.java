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
public class Jr_Rep_Tpl_Col_List_Bean extends Abstract_List_Bean<Jr_Rep_Tpl_Col> {

  public Jr_Rep_Tpl_Col_List_Bean() {
    super("Jr_Rep_Tpl_Col", (Jr_Rep_Tpl_Col_Filter_Bean) jsf_funcs.findBean("jr_Rep_Tpl_Col_Filter_Bean"));
  }

  public LazyDataModel<Jr_Rep_Tpl_Col> getConverted_rec_list() {
    return getRec_list();
  }
  
  public Jr_Rep_Tpl_Col_Filter_Bean getFilter_bean_wrapped() {
    return (Jr_Rep_Tpl_Col_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    if (getFilter_bean_wrapped().getFilter_entity().getJr_rep_tpl()!= null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", getFilter_bean_wrapped().getFilter_entity().getJr_rep_tpl().toString()));
    }
  }
  

}
