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
public class I_Tbl_Fld_List_Bean extends Abstract_List_Bean<I_Tbl_Fld> {

  public I_Tbl_Fld_List_Bean() {
    super("I_Tbl_Fld", (I_Tbl_Fld_Filter_Bean) jsf_funcs.findBean("i_Tbl_Fld_Filter_Bean"));
  }

  public LazyDataModel<I_Tbl_Fld> getConverted_rec_list() {
    return getRec_list();
  }

  public I_Tbl_Fld_Filter_Bean getFilter_bean_wrapped() {
    return (I_Tbl_Fld_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    if (getFilter_bean_wrapped().getFilter_entity().getI_tbl() != null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("i_tbl.i_tbl", "=", getFilter_bean_wrapped().getFilter_entity().getI_tbl().toString()));
    }
  }

}
