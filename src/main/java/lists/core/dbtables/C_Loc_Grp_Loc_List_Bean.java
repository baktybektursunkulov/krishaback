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
public class C_Loc_Grp_Loc_List_Bean extends Abstract_List_Bean<C_Loc_Grp_Loc> {

  public C_Loc_Grp_Loc_List_Bean() {
    super("C_Loc_Grp_Loc", (C_Loc_Grp_Loc_Filter_Bean) jsf_funcs.findBean("c_Loc_Grp_Loc_Filter_Bean"));
  }

  public LazyDataModel<C_Loc_Grp_Loc> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Loc_Grp_Loc> getConverted_rec_array_list() {
    return getRec_array_list();
  }

  public C_Loc_Grp_Loc_Filter_Bean getFilter_bean_wrapped() {
    return (C_Loc_Grp_Loc_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
    C_Loc_Grp_Loc filter_rec_ = getFilter_bean_wrapped().getFilter_entity_wrapped();
    if (filter_rec_.getC_loc_grp() != null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("t.c_loc_grp=" + filter_rec_.getC_loc_grp()));
    }
    if (filter_rec_.getC_loc() != null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("t.c_loc=" + filter_rec_.getC_loc()));
    }
  }

}
