package lists.core.dbtables;

import filters.core.dbtables.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import gs.common.model.db.*;
import java.util.*;

@ManagedBean
@SessionScoped
public class C_Svc_List_Bean extends Abstract_List_Bean<C_Svc> {

  public C_Svc_List_Bean() {
    super("C_Svc", (C_Svc_Filter_Bean) jsf_funcs.findBean("c_Svc_Filter_Bean"));
  }

  public LazyDataModel<C_Svc> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Svc> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public C_Svc_Filter_Bean getFilter_bean_wrapped() {
    return (C_Svc_Filter_Bean) getFilter_bean();
  }


  
}
