package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Country_Filter_Bean extends Abstract_Filter_Bean<C_Country> {

  public C_Country_Filter_Bean() {
    super(C_Country.class, "c_country", "desc");
    getSort_field_name_list().add(new SelectItem("c_country", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_Country getFilter_entity_wrapped() {
    return getFilter_entity();
  }

  public C_Country getC_country() {
    return getFilter_entity();
  }

}
