package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_File_Filter_Bean extends Abstract_Filter_Bean<C_File> {

  public C_File_Filter_Bean() {
    super(C_File.class, "c_file", "desc");
    getSort_field_name_list().add(new SelectItem("c_file", bundle_funcs.getBundleValue("Identifikator")));
  }

  public C_File getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
