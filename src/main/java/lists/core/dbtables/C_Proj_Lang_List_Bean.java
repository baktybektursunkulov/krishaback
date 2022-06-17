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
public class C_Proj_Lang_List_Bean extends Abstract_List_Bean<C_Proj_Lang> {

  public C_Proj_Lang_List_Bean() {
    super("C_Proj_Lang", (C_Proj_Lang_Filter_Bean) jsf_funcs.findBean("c_Proj_Lang_Filter_Bean"));
  }

  public LazyDataModel<C_Proj_Lang> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Proj_Lang> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public C_Proj_Lang_Filter_Bean getFilter_bean_wrapped() {
    return (C_Proj_Lang_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
    C_Proj_Lang filter_rec_ = getFilter_bean_wrapped().getFilter_entity_wrapped();
    if (filter_rec_.getC_proj()!= null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("t.c_proj=" + filter_rec_.getC_proj()));
    }
    if (filter_rec_.getC_lang()!= null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("t.c_lang=" + filter_rec_.getC_lang()));
    }
  }

  
  @Override
  protected Object rec_list_getRowData(String rowKey) {
    List<C_Proj_Lang> list_ = (List<C_Proj_Lang>) getConverted_rec_list().getWrappedData();
    Integer value = Integer.valueOf(rowKey);
    for (C_Proj_Lang rec : list_) {
      if (rec.getC_proj_lang().equals(value)) {
        return rec;
      }
    }
    return null;
  }
}
