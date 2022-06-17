package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Dyn_Guide_Row_Filter_Bean extends Abstract_Filter_Bean<C_Dyn_Guide_Row> {

  public C_Dyn_Guide_Row_Filter_Bean() {
    super(C_Dyn_Guide_Row.class, "c_dyn_guide_row", "desc");
    getSort_field_name_list().add(new SelectItem("c_dyn_guide_row", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Dyn_Guide_Row getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
