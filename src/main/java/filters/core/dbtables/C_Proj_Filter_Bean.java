package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Proj_Filter_Bean extends Abstract_Filter_Bean<C_Proj> {

  public C_Proj_Filter_Bean() {
    super(C_Proj.class, "c_proj", "desc");
    getSort_field_name_list().add(new SelectItem("c_proj", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Proj getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
