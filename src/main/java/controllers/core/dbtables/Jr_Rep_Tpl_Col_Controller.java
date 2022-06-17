package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Jr_Rep_Tpl_Col_Controller extends Abstract_Controller<Jr_Rep_Tpl_Col> {

  public Jr_Rep_Tpl_Col_Controller() {
    super(Jr_Rep_Tpl_Col.class, "jr_rep_tpl_col_list.xhtml", false);
  }

  public Jr_Rep_Tpl_Col getJr_rep_tpl_col() {
    return getAbstract_entity();
  }

}
