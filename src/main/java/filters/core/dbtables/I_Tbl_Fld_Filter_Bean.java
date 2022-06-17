package filters.core.dbtables;

 import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.I_Tbl;
import model.core.dbtables.I_Tbl_Fld;

@ManagedBean
@SessionScoped
public class I_Tbl_Fld_Filter_Bean extends Abstract_Filter_Bean<I_Tbl_Fld> {

  public I_Tbl_Fld_Filter_Bean() {
    super(I_Tbl_Fld.class, "i_tbl_fld", "desc");
    getSort_field_name_list().add(new SelectItem("i_tbl_fld", bundle_funcs.getBundleValue("Identifikator")));
  }

   public I_Tbl_Fld getFilter_entity_wrapped() {
    return getFilter_entity();
  }

}
