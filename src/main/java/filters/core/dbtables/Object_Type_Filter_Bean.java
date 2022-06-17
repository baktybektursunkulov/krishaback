package filters.core.dbtables;

 import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;

@ManagedBean
@SessionScoped
public class Object_Type_Filter_Bean extends Abstract_Filter_Bean {

  public Object_Type_Filter_Bean() {
    super("object_type", "desc");
    getSort_field_name_list().add(new SelectItem("object_type", bundle_funcs.getBundleValue("Identifikator")));
  }

}
