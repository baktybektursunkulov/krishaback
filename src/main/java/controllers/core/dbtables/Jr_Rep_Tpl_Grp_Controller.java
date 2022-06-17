package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Jr_Rep_Tpl_Grp_Controller extends Abstract_Controller<Jr_Rep_Tpl_Grp> {

  public Jr_Rep_Tpl_Grp_Controller() {
    super(Jr_Rep_Tpl_Grp.class, "jr_rep_tpl_grp_list.xhtml", false);
  }

  public Jr_Rep_Tpl_Grp getJr_rep_tpl_grp() {
    return getAbstract_entity();
  }

}
