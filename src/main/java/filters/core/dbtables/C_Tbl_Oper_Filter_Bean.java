package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Tbl_Oper_Filter_Bean extends Abstract_Filter_Bean<C_Tbl_Oper> {

  public C_Tbl_Oper_Filter_Bean() {
    super(C_Tbl_Oper.class, "c_tbl_oper", "desc");
    getSort_field_name_list().add(new SelectItem("c_tbl_oper", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Tbl_Oper getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
