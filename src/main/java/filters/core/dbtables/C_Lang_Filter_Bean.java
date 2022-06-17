package filters.core.dbtables;

import gs.common.jsf.bundle_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class C_Lang_Filter_Bean extends Abstract_Filter_Bean {

  public C_Lang_Filter_Bean() {
    super("c_lang", "desc");
    getSort_field_name_list().add(new SelectItem("c_lang", bundle_funcs.getBundleValue("Identifikator")));
  }

}
