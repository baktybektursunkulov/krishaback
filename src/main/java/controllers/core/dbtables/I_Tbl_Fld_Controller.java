package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class I_Tbl_Fld_Controller extends Abstract_Controller<I_Tbl_Fld> {

  public I_Tbl_Fld_Controller() {
    super(I_Tbl_Fld.class, "i_tbl_fld_list.xhtml", false);
  }

  public I_Tbl_Fld getI_tbl_fld() {
    return getAbstract_entity();
  }

}
