package controllers.core.dbtables;

import beans.CUsrBean;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Jr_Rep_Tpl_Controller extends Abstract_Controller<Jr_Rep_Tpl> {

  public Jr_Rep_Tpl_Controller() {
    super(Jr_Rep_Tpl.class, "jr_rep_tpl_list.xhtml", false);
  }

  public Jr_Rep_Tpl getJr_rep_tpl() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setC_usr_t(CUsrBean.getCurrentBean().getLoggedCUsr());
  }

}
