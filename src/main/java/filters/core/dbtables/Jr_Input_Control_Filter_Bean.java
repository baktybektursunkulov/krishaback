package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class Jr_Input_Control_Filter_Bean extends Abstract_Filter_Bean<Jr_Input_Control> {

  public Jr_Input_Control_Filter_Bean() {
    super(Jr_Input_Control.class, "jr_input_control", "desc");
    getSort_field_name_list().add(new SelectItem("jr_input_control", bundle_funcs.getBundleValue("Identifikator")));
  }

  public Jr_Input_Control getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
