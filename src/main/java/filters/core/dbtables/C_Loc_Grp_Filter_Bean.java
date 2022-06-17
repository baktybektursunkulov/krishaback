package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Loc_Grp_Filter_Bean extends Abstract_Filter_Bean<C_Loc_Grp> {

  public C_Loc_Grp_Filter_Bean() {
    super(C_Loc_Grp.class, "c_loc_grp", "desc");
    getSort_field_name_list().add(new SelectItem("c_loc_grp", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Loc_Grp getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
