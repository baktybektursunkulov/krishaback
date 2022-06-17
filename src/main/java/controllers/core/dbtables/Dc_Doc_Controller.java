package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Dc_Doc_Controller extends Abstract_Controller<Dc_Doc> {

  public Dc_Doc_Controller() {
    super(Dc_Doc.class, "dc_doc_list.xhtml", false);
  }

  public Dc_Doc getDc_doc() {
    return getAbstract_entity();
  }

}
