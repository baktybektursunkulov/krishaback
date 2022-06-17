package lists.core.dbtables;

import filters.core.dbtables.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import gs.common.model.db.*;
import java.util.*;

@ManagedBean
@SessionScoped
public class C_Right_List_Bean extends Abstract_List_Bean<C_Right> {

  public C_Right_List_Bean() {
    super("C_Right", (C_Right_Filter_Bean) jsf_funcs.findBean("c_Right_Filter_Bean"));
  }

  public LazyDataModel<C_Right> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Right> getConverted_rec_array_list() {
    return getRec_array_list();
  }

  public C_Right_Filter_Bean getFilter_bean_wrapped() {
    return (C_Right_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    C_Right_Filter_Bean filter_bean_ = getFilter_bean_wrapped();
    if (filter_bean_.getFilter_entity().getC_right_kind() != null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("c_right_kind", "=", filter_bean_.getFilter_entity_wrapped().getC_right_kind().toString()));
    }
  }

}
