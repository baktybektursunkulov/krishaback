package controllers.core.dbtables;

import beans.CUsrBean;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Jr_Lov_Controller extends Abstract_Controller<Jr_Lov> {

  public Jr_Lov_Controller() {
    super(Jr_Lov.class, "jr_lov_list.xhtml", false);
  }

  public Jr_Lov getJr_lov() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setC_usr_t(CUsrBean.getCurrentBean().getLoggedCUsr());
  }
  
}
