package controllers.core.dbtables;

import beans.CUsrBean;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Jr_Input_Control_Controller extends Abstract_Controller<Jr_Input_Control> {

  public Jr_Input_Control_Controller() {
    super(Jr_Input_Control.class, "jr_input_control_list.xhtml", false);
  }

  public Jr_Input_Control getJr_input_control() {
    return getAbstract_entity();
  }

 @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setC_usr_t(CUsrBean.getCurrentBean().getLoggedCUsr());
  }
  
}
