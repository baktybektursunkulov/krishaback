package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class C_Tz_Controller extends Abstract_Controller<C_Tz> {

  public C_Tz_Controller() {
    super(C_Tz.class, "c_tz_list.xhtml", false);
  }

  public C_Tz getC_tz() {
    return getAbstract_entity();
  }

}
