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
public class I_Plain_Txt_List_Bean extends Abstract_List_Bean<I_Plain_Txt> {

  public I_Plain_Txt_List_Bean() {
    super("I_Plain_Txt", (I_Plain_Txt_Filter_Bean) jsf_funcs.findBean("i_Plain_Txt_Filter_Bean"));
  }

  public LazyDataModel<I_Plain_Txt> getConverted_rec_list() {
    return getRec_list();
  }

  public List<I_Plain_Txt> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public I_Plain_Txt_Filter_Bean getFilter_bean_wrapped() {
    return (I_Plain_Txt_Filter_Bean) getFilter_bean();
  }
  
}
