package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Loc_Grp_Loc_Filter_Bean extends Abstract_Filter_Bean<C_Loc_Grp_Loc> {

  public C_Loc_Grp_Loc_Filter_Bean() {
    super(C_Loc_Grp_Loc.class, "c_loc_grp_loc", "desc");
    getSort_field_name_list().add(new SelectItem("c_loc_grp_loc", bundle_funcs.getBundleValue("Identifikator")));
  }

  public static C_Loc_Grp_Loc_Filter_Bean getCurrentBean() {
    return jsf_funcs.findBean("c_Loc_Grp_Loc_Filter_Bean");
  }
  
  public C_Loc_Grp_Loc getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
