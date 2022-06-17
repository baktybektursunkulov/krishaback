package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped; 
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import managers.core.dbtables.Dc_Doc_Cont_Manager;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class Dc_Doc_Cont_Row_Filter_Bean extends Abstract_Filter_Bean<Dc_Doc_Cont_Row> {

  public Dc_Doc_Cont_Row_Filter_Bean() {
    super(Dc_Doc_Cont_Row.class, "dc_doc_cont_row", "desc");
    getSort_field_name_list().add(new SelectItem("dc_doc_cont_row", bundle_funcs.getBundleValue("Identifikator")));
    getFilter_entity_wrapped().setDc_doc_cont_t(Dc_Doc_Cont_Manager.getCI().get_rec_2(1));
  }

  public Dc_Doc_Cont_Row getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
