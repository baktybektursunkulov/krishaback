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
public class C_Tbl_Prop_List_Bean extends Abstract_List_Bean<C_Tbl_Prop> {

  public C_Tbl_Prop_List_Bean() {
    super("C_Tbl_Prop", (C_Tbl_Prop_Filter_Bean) jsf_funcs.findBean("c_Tbl_Prop_Filter_Bean"));
  }

  public LazyDataModel<C_Tbl_Prop> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Tbl_Prop> getConverted_rec_array_list() {
    return getRec_array_list();
  }
  
  public C_Tbl_Prop_Filter_Bean getFilter_bean_wrapped() {
    return (C_Tbl_Prop_Filter_Bean) getFilter_bean();
  }
  
}
