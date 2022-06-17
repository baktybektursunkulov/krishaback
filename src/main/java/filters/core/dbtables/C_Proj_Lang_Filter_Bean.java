package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Proj_Lang_Filter_Bean extends Abstract_Filter_Bean<C_Proj_Lang> {

  public C_Proj_Lang_Filter_Bean() {
    super(C_Proj_Lang.class, "c_proj_lang", "desc");
    getSort_field_name_list().add(new SelectItem("c_proj_lang", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Proj_Lang getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
