package filters.core.dbtables;

 import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.Jr_Rep_Tpl;

@ManagedBean
@SessionScoped
public class Jr_Rep_Tpl_Filter_Bean extends Abstract_Filter_Bean<Jr_Rep_Tpl> {

  public Jr_Rep_Tpl_Filter_Bean() {
    super(Jr_Rep_Tpl.class, "jr_rep_tpl", "desc");
    getSort_field_name_list().add(new SelectItem("jr_rep_tpl", bundle_funcs.getBundleValue("Identifikator")));
  }

  public Jr_Rep_Tpl getFilter_entity_wrapped() {
    return getFilter_entity();
  }
  
}
