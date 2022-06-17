package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class C_Tbl_Prop_Controller extends Abstract_Controller<C_Tbl_Prop> {

  public C_Tbl_Prop_Controller() {
    super(C_Tbl_Prop.class, "c_tbl_prop_list.xhtml", false);
  }

  public C_Tbl_Prop getC_tbl_prop() {
    return getAbstract_entity();
  }

}
