package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Dc_Doc_Cont_Controller extends Abstract_Controller<Dc_Doc_Cont> {

  public Dc_Doc_Cont_Controller() {
    super(Dc_Doc_Cont.class, "dc_doc_cont_list.xhtml", false);
  }

  public Dc_Doc_Cont getDc_doc_cont() {
    return getAbstract_entity();
  }

}
