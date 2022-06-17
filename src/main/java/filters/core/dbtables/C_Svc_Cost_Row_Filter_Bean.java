package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Svc_Cost_Row_Filter_Bean extends Abstract_Filter_Bean<C_Svc_Cost_Row> {

  public C_Svc_Cost_Row_Filter_Bean() {
    super(C_Svc_Cost_Row.class, "c_svc_cost_row", "desc");
    getSort_field_name_list().add(new SelectItem("c_svc_cost_row", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Svc_Cost_Row getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
