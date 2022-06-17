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
public class C_Lang_List_Bean extends Abstract_List_Bean<C_Lang> {

  public C_Lang_List_Bean() {
    super("C_Lang", (C_Lang_Filter_Bean) jsf_funcs.findBean("c_Lang_Filter_Bean"));
  }

  public LazyDataModel<C_Lang> getConverted_rec_list() {
    return getRec_list();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
  }
}
