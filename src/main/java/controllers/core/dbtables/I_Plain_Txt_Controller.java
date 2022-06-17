package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class I_Plain_Txt_Controller extends Abstract_Controller<I_Plain_Txt> {

  public I_Plain_Txt_Controller() {
    super(I_Plain_Txt.class, "i_plain_txt_list.xhtml", false);
  }

  public I_Plain_Txt getI_plain_txt() {
    return getAbstract_entity();
  }

}
