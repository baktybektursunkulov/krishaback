package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Tbl_Rec_Prop_Val_Filter_Bean extends Abstract_Filter_Bean<C_Tbl_Rec_Prop_Val> {

  public C_Tbl_Rec_Prop_Val_Filter_Bean() {
    super(C_Tbl_Rec_Prop_Val.class, "c_tbl_rec_prop_val", "desc");
    getSort_field_name_list().add(new SelectItem("c_tbl_rec_prop_val", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Tbl_Rec_Prop_Val getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
