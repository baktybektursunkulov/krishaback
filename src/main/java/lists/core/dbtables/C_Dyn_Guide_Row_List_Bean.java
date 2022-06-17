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
public class C_Dyn_Guide_Row_List_Bean extends Abstract_List_Bean<C_Dyn_Guide_Row> {

  public C_Dyn_Guide_Row_List_Bean() {
    super("C_Dyn_Guide_Row", (C_Dyn_Guide_Row_Filter_Bean) jsf_funcs.findBean("c_Dyn_Guide_Row_Filter_Bean"));
  }

  public LazyDataModel<C_Dyn_Guide_Row> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Dyn_Guide_Row> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public C_Dyn_Guide_Row_Filter_Bean getFilter_bean_wrapped() {
    return (C_Dyn_Guide_Row_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
    C_Dyn_Guide_Row filter_rec_ = getFilter_bean_wrapped().getFilter_entity_wrapped();
    if (filter_rec_.getC_dyn_guide()!= null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("t.c_dyn_guide=" + filter_rec_.getC_dyn_guide().toString()));
    }
    if (filter_rec_.getVal() != null && !filter_rec_.getVal().trim().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(trim(t.val)) like '%" + filter_rec_.getVal().trim().toLowerCase() + "%'"));
    }
  }

  
  @Override
  protected Object rec_list_getRowData(String rowKey) {
    List<C_Dyn_Guide_Row> list_ = (List<C_Dyn_Guide_Row>) getConverted_rec_list().getWrappedData();
    Integer value = Integer.valueOf(rowKey);
    for (C_Dyn_Guide_Row rec : list_) {
      if (rec.getC_dyn_guide_row().equals(value)) {
        return rec;
      }
    }
    return null;
  }
}
