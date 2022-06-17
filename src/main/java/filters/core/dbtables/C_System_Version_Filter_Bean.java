package filters.core.dbtables;

 import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;

@ManagedBean
@SessionScoped
public class C_System_Version_Filter_Bean extends Abstract_Filter_Bean {

  public C_System_Version_Filter_Bean() {
    super("c_system_version", "desc");
    getSort_field_name_list().add(new SelectItem("c_system_version", bundle_funcs.getBundleValue("Identifikator")));
  }

}
