package lists.core.dbtables;

import beans.CacheBean;
import filters.core.dbtables.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import java.util.List;

@ManagedBean
@SessionScoped
public class C_System_Version_List_Bean extends Abstract_List_Bean<C_System_Version> {

  public C_System_Version_List_Bean() {
    super("C_System_Version", (C_System_Version_Filter_Bean) jsf_funcs.findBean("c_System_Version_Filter_Bean"));
  }

  public LazyDataModel<C_System_Version> getConverted_rec_list() {
    return getRec_list();
  }

  @Override
  protected void afterLoad(List<C_System_Version> rec_list_) {
    CacheBean.getCacheBean().refresh_current_version();
  }

}
