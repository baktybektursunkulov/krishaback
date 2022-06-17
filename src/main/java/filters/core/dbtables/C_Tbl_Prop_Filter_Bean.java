package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Tbl_Prop_Filter_Bean extends Abstract_Filter_Bean<C_Tbl_Prop> {

  public C_Tbl_Prop_Filter_Bean() {
    super(C_Tbl_Prop.class, "c_tbl_prop", "desc");
    getSort_field_name_list().add(new SelectItem("c_tbl_prop", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Tbl_Prop getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
