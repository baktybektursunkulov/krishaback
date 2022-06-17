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
public class Jr_Lov_List_Bean extends Abstract_List_Bean<Jr_Lov> {

  public Jr_Lov_List_Bean() {
    super("Jr_Lov", (Jr_Lov_Filter_Bean) jsf_funcs.findBean("jr_Lov_Filter_Bean"));
  }

  public LazyDataModel<Jr_Lov> getConverted_rec_list() {
    return getRec_list();
  }

  public List<Jr_Lov> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public Jr_Lov_Filter_Bean getFilter_bean_wrapped() {
    return (Jr_Lov_Filter_Bean) getFilter_bean();
  }
  
}
