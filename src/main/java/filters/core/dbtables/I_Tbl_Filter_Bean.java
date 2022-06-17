package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.I_Tbl;

@ManagedBean
@SessionScoped
public class I_Tbl_Filter_Bean extends Abstract_Filter_Bean<I_Tbl> {

  public I_Tbl_Filter_Bean() {
    super(I_Tbl.class, "i_tbl", "desc");
    getSort_field_name_list().add(new SelectItem("i_tbl", bundle_funcs.getBundleValue("Identifikator")));
  }

  public I_Tbl getFilter_entity_wrapped() {
    return getFilter_entity();
  }

}
