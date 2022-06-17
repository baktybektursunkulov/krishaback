package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class Jr_Lov_Row_Filter_Bean extends Abstract_Filter_Bean<Jr_Lov_Row> {

  public Jr_Lov_Row_Filter_Bean() {
    super(Jr_Lov_Row.class, "jr_lov_row", "desc");
    getSort_field_name_list().add(new SelectItem("jr_lov_row", bundle_funcs.getBundleValue("Identifikator")));
  }

  public Jr_Lov_Row getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
