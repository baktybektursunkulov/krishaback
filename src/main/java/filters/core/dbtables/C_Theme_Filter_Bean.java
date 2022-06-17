package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Theme_Filter_Bean extends Abstract_Filter_Bean<C_Theme> {

  public C_Theme_Filter_Bean() {
    super(C_Theme.class, "c_theme", "desc");
    getSort_field_name_list().add(new SelectItem("c_theme", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Theme getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
