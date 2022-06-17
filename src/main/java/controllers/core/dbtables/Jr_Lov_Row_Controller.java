package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Jr_Lov_Row_Controller extends Abstract_Controller<Jr_Lov_Row> {

  public Jr_Lov_Row_Controller() {
    super(Jr_Lov_Row.class, "jr_lov_row_list.xhtml", false);
  }

  public Jr_Lov_Row getJr_lov_row() {
    return getAbstract_entity();
  }

}
