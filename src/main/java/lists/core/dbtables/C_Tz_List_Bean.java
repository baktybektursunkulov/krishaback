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
public class C_Tz_List_Bean extends Abstract_List_Bean<C_Tz> {

  public C_Tz_List_Bean() {
    super("C_Tz", (C_Tz_Filter_Bean) jsf_funcs.findBean("c_Tz_Filter_Bean"));
  }

  public LazyDataModel<C_Tz> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Tz> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public C_Tz_Filter_Bean getFilter_bean_wrapped() {
    return (C_Tz_Filter_Bean) getFilter_bean();
  }
  
}
