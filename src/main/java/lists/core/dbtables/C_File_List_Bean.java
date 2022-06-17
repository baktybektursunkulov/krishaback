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
public class C_File_List_Bean extends Abstract_List_Bean<C_File> {

  public C_File_List_Bean() {
    super("C_File", (C_File_Filter_Bean) jsf_funcs.findBean(C_File_Filter_Bean.class));
  }

  public LazyDataModel<C_File> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_File> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public C_File_Filter_Bean getFilter_bean_wrapped() {
    return (C_File_Filter_Bean) getFilter_bean();
  }
  
}
