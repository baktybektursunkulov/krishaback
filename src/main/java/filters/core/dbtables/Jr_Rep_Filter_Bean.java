package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.Jr_Rep;

@ManagedBean
@SessionScoped
public class Jr_Rep_Filter_Bean extends Abstract_Filter_Bean<Jr_Rep> {

  public Jr_Rep_Filter_Bean() {
    super(Jr_Rep.class, "jr_rep", "desc");
    getSort_field_name_list().add(new SelectItem("jr_rep", bundle_funcs.getBundleValue("Identifikator")));
  }

  public Jr_Rep getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
