package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class I_Html_Txt_Filter_Bean extends Abstract_Filter_Bean<I_Html_Txt> {

  public I_Html_Txt_Filter_Bean() {
    super(I_Html_Txt.class, "i_html_txt", "desc");
    getSort_field_name_list().add(new SelectItem("i_html_txt", bundle_funcs.getBundleValue("Identifikator")));
  }

  public I_Html_Txt getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
