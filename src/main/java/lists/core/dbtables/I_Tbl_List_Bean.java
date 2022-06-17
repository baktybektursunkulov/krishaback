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
public class I_Tbl_List_Bean extends Abstract_List_Bean<I_Tbl> {

  public I_Tbl_List_Bean() {
    super("I_Tbl", (I_Tbl_Filter_Bean) jsf_funcs.findBean("i_Tbl_Filter_Bean"));
  }

  public LazyDataModel<I_Tbl> getConverted_rec_list() {
    return getRec_list();
  }

  public I_Tbl_Filter_Bean getFilter_bean_wrapped() {
    return (I_Tbl_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    if (getFilter_bean_wrapped().getFilter_entity().getName() != null && !getFilter_bean_wrapped().getFilter_entity().getName().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(name)", "like", "'%" + getFilter_bean_wrapped().getFilter_entity().getName().toLowerCase() + "%'"));
    }
  }

}
