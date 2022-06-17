package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import managers.core.dbtables.Dc_Doc_Cont_Manager;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class Dc_Doc_Cont_Filter_Bean extends Abstract_Filter_Bean<Dc_Doc_Cont> {

  public Dc_Doc_Cont_Filter_Bean() {
    super(Dc_Doc_Cont.class, "dc_doc_cont", "desc");
    getSort_field_name_list().add(new SelectItem("dc_doc_cont", bundle_funcs.getBundleValue("Identifikator")));
  }

  public Dc_Doc_Cont getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
