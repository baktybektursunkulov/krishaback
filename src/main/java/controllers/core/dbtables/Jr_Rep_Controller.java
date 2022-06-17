package controllers.core.dbtables;

import beans.CUsrBean;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;
import managers.core.dbtables.Jr_Rep_Manager;
import managers.core.dbtables.C_Usr_Manager;

@ManagedBean
@ViewScoped
public class Jr_Rep_Controller extends Abstract_Controller<Jr_Rep> {

  public Jr_Rep_Controller() {
    super(Jr_Rep.class, "jr_rep_list.xhtml", false);
  }

  public Jr_Rep getJr_rep() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    Jr_Rep_Manager.load_default_vals(getJr_rep());
    System.out.println("afterLoadDefaultRec getJr_rep()=" + getJr_rep());
    getAbstract_entity().setCreator_usr_t(CUsrBean.getCurrentBean().getLoggedCUsr());
  }

  

  
}
