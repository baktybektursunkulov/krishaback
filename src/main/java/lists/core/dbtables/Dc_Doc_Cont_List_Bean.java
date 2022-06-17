package lists.core.dbtables;

import filters.core.dbtables.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import java.util.List;

@ManagedBean
@SessionScoped
public class Dc_Doc_Cont_List_Bean extends Abstract_List_Bean<Dc_Doc_Cont> {

  public Dc_Doc_Cont_List_Bean() {
    super("Dc_Doc_Cont", (Dc_Doc_Cont_Filter_Bean) jsf_funcs.findBean("dc_Doc_Cont_Filter_Bean"));
  }

  public LazyDataModel<Dc_Doc_Cont> getConverted_rec_list() {
    return getRec_list();
  }

  public List<Dc_Doc_Cont> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public Dc_Doc_Cont_Filter_Bean getFilter_bean_wrapped() {
    return (Dc_Doc_Cont_Filter_Bean) getFilter_bean();
  }
  
}
