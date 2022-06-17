package filters.core.dbtables;

 import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;

@ManagedBean
@SessionScoped
public class Jr_Rep_Tpl_Grp_Filter_Bean extends Abstract_Filter_Bean {

  public Jr_Rep_Tpl_Grp_Filter_Bean() {
    super("jr_rep_tpl_grp", "desc");
    getSort_field_name_list().add(new SelectItem("jr_rep_tpl_grp", bundle_funcs.getBundleValue("Identifikator")));
  }

}
