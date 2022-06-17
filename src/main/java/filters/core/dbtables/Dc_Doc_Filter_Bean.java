package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class Dc_Doc_Filter_Bean extends Abstract_Filter_Bean<Dc_Doc> {

  public Dc_Doc_Filter_Bean() {
    super(Dc_Doc.class, "dc_doc", "desc");
    getSort_field_name_list().add(new SelectItem("dc_doc", bundle_funcs.getBundleValue("Identifikator")));
  }

  public Dc_Doc getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
