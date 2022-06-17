package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class I_Html_Txt_Controller extends Abstract_Controller<I_Html_Txt> {

  public I_Html_Txt_Controller() {
    super(I_Html_Txt.class, "i_html_txt_list.xhtml", false);
  }

  public I_Html_Txt getI_html_txt() {
    return getAbstract_entity();
  }

}
