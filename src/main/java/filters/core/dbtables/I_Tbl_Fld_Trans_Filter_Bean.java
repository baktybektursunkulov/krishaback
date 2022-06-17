package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import java.util.List;
import managers.core.dbtables.I_Tbl_Fld_Manager;
import model.core.dbtables.I_Tbl;
import model.core.dbtables.I_Tbl_Fld;
import model.core.dbtables.I_Tbl_Fld_Trans;

@ManagedBean
@SessionScoped
public class I_Tbl_Fld_Trans_Filter_Bean extends Abstract_Filter_Bean<I_Tbl_Fld_Trans> {

  private List<I_Tbl_Fld> i_tbl_fld_list;

  public List<I_Tbl_Fld> getI_tbl_fld_list() {
    return i_tbl_fld_list;
  }

  public void setI_tbl_fld_list(List<I_Tbl_Fld> i_tbl_fld_list) {
    this.i_tbl_fld_list = i_tbl_fld_list;
  }

  public I_Tbl_Fld_Trans_Filter_Bean() {
    super(I_Tbl_Fld_Trans.class, "i_tbl_fld_trans", "desc");
    getSort_field_name_list().add(new SelectItem("i_tbl_fld_trans", bundle_funcs.getBundleValue("Identifikator")));
  }

  public I_Tbl_Fld_Trans getFilter_entity_wrapped() {
    return getFilter_entity();
  }

  public void refresh_i_tbl_fld_list() {
    if (getFilter_entity_wrapped().getI_tbl() == null) {
      i_tbl_fld_list = null;
    } else {
      i_tbl_fld_list = I_Tbl_Fld_Manager.getCI().get_i_tbl_fld_list(getFilter_entity_wrapped().getI_tbl());
    }
  }

}
