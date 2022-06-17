package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.Jr_Rep_Col;
import model.core.dbtables.Jr_Rep_Tpl_Col;

@ManagedBean
@SessionScoped
public class Jr_Rep_Tpl_Col_Filter_Bean extends Abstract_Filter_Bean<Jr_Rep_Tpl_Col> {

  public Jr_Rep_Tpl_Col_Filter_Bean() {
    super(Jr_Rep_Tpl_Col.class, "jr_rep_tpl_col", "desc");
    getSort_field_name_list().add(new SelectItem("jr_rep_tpl_col", bundle_funcs.getBundleValue("Identifikator")));
  }

  public Jr_Rep_Tpl_Col getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
