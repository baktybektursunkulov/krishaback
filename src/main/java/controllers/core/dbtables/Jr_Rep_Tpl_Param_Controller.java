package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Jr_Rep_Tpl_Param_Controller extends Abstract_Controller<Jr_Rep_Tpl_Param> {

  public Jr_Rep_Tpl_Param_Controller() {
    super(Jr_Rep_Tpl_Param.class, "jr_rep_tpl_param_list.xhtml", false);
  }

  public Jr_Rep_Tpl_Param getJr_rep_tpl_param() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setDefault_val("");
  }
  
}
