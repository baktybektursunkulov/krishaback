package filters.core.dbtables;

 import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;

@ManagedBean
@SessionScoped
public class Jr_Rep_Col_Sort_Filter_Bean extends Abstract_Filter_Bean {

  public Jr_Rep_Col_Sort_Filter_Bean() {
    super("jr_rep_col_sort", "desc");
    getSort_field_name_list().add(new SelectItem("jr_rep_col_sort", bundle_funcs.getBundleValue("Identifikator")));
  }

}
