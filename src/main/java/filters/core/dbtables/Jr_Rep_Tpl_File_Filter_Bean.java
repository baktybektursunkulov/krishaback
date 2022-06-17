package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class Jr_Rep_Tpl_File_Filter_Bean extends Abstract_Filter_Bean<Jr_Rep_Tpl_File> {

  public Jr_Rep_Tpl_File_Filter_Bean() {
    super(Jr_Rep_Tpl_File.class, "jr_rep_tpl_file", "desc");
    getFilter_entity().setJr_rep_tpl_t(new Jr_Rep_Tpl()); 
    getSort_field_name_list().add(new SelectItem("jr_rep_tpl_file", bundle_funcs.getBundleValue("Identifikator")));
  }

  public Jr_Rep_Tpl_File getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
