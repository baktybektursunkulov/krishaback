package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class I_Tbl_Controller extends Abstract_Controller<I_Tbl> {

  public I_Tbl_Controller() {
    super(I_Tbl.class, "i_tbl_list.xhtml", false);
  }

  public I_Tbl getI_tbl() {
    return getAbstract_entity();
  }

}
