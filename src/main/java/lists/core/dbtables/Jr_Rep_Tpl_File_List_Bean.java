package lists.core.dbtables;

import filters.core.dbtables.*;
import gs.common.model.db.SQL_Where_Condition;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class Jr_Rep_Tpl_File_List_Bean extends Abstract_List_Bean<Jr_Rep_Tpl_File> {

  public Jr_Rep_Tpl_File_List_Bean() {
    super("Jr_Rep_Tpl_File", (Jr_Rep_Tpl_File_Filter_Bean) jsf_funcs.findBean("jr_Rep_Tpl_File_Filter_Bean"));
  }

  public LazyDataModel<Jr_Rep_Tpl_File> getConverted_rec_list() {
    return getRec_list();
  }

  public List<Jr_Rep_Tpl_File> getConverted_rec_array_list() {
    return getRec_array_list();
  }

  public Jr_Rep_Tpl_File_Filter_Bean getFilter_bean_wrapped() {
    return (Jr_Rep_Tpl_File_Filter_Bean) getFilter_bean();
  }

  @Override
  protected boolean getIs_native_sql() {
    return true;
  }

  @Override
  protected Class getNative_sql_entity_class() {
    return Jr_Rep_Tpl_File.class;
  }
     
  @Override
  protected void add_left_sql_join_conditions(ArrayList<String> sql_join_condition_arr_) {
    sql_join_condition_arr_.add("Jr_Rep_Tpl rt");
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.jr_rep_tpl", "=", "rt.jr_rep_tpl"));
    if (getFilter_bean_wrapped().getFilter_entity().getJr_rep_tpl_t().getName() != null && !getFilter_bean_wrapped().getFilter_entity().getJr_rep_tpl_t().getName().trim().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(rt.name)", "like", "'%" + getFilter_bean_wrapped().getFilter_entity().getJr_rep_tpl_t().getName().trim().toLowerCase() + "%'"));
    }
  }

  public void download(Jr_Rep_Tpl_File jr_Rep_Tpl_File) {
    String js_str_ = "location.href='open_jr_rep_tpl_file?jr_rep_tpl_file_id=" + jr_Rep_Tpl_File.getJr_rep_tpl_file() + "&is_attachment=true';";
    primefaces_funcs.executeJS(js_str_);
  }

  @Override
  protected Object rec_list_getRowData(String rowKey) {
    List<Jr_Rep_Tpl_File> list_ = (List<Jr_Rep_Tpl_File>) getConverted_rec_list().getWrappedData();
    Integer value = Integer.valueOf(rowKey);

    for (Jr_Rep_Tpl_File rec : list_) {
      if (rec.getJr_rep_tpl_file().equals(value)) {
        return rec;
      }
    }

    return null;
  }
}
