package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class Jr_Rep_Tpl_Param_Filter_Bean extends Abstract_Filter_Bean<Jr_Rep_Tpl_Param> {

  public Jr_Rep_Tpl_Param_Filter_Bean() {
    super(Jr_Rep_Tpl_Param.class, "jr_rep_tpl_param", "desc");
    getSort_field_name_list().add(new SelectItem("jr_rep_tpl_param", bundle_funcs.getBundleValue("Identifikator")));
    getSort_field_name_list().add(new SelectItem("code", bundle_funcs.getBundleValue("Kod")));
  }

  public Jr_Rep_Tpl_Param getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
