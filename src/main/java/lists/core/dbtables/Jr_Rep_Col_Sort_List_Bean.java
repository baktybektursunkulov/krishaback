package lists.core.dbtables;

import filters.core.dbtables.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;

@ManagedBean
@SessionScoped
public class Jr_Rep_Col_Sort_List_Bean extends Abstract_List_Bean<Jr_Rep_Col_Sort> {

  public Jr_Rep_Col_Sort_List_Bean() {
    super("Jr_Rep_Col_Sort", (Jr_Rep_Col_Sort_Filter_Bean) jsf_funcs.findBean("jr_Rep_Col_Sort_Filter_Bean"));
  }

  public LazyDataModel<Jr_Rep_Col_Sort> getConverted_rec_list() {
    return getRec_list();
  }

}
