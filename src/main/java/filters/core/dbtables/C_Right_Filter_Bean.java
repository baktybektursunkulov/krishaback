package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Right_Filter_Bean extends Abstract_Filter_Bean<C_Right> {

  public C_Right_Filter_Bean() {
    super(C_Right.class, "c_right", "desc");
    getSort_field_name_list().add(new SelectItem("c_right", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Right getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
