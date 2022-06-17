package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class I_Plain_Txt_Filter_Bean extends Abstract_Filter_Bean<I_Plain_Txt> {

  public I_Plain_Txt_Filter_Bean() {
    super(I_Plain_Txt.class, "i_plain_txt", "desc");
    getSort_field_name_list().add(new SelectItem("i_plain_txt", bundle_funcs.getBundleValue("Identifikator")));
  }

  public I_Plain_Txt getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
