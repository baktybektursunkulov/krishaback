package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;

@ManagedBean
@SessionScoped
public class C_Site_Page_Filter_Bean extends Abstract_Filter_Bean<C_Site_Page> {

  public C_Site_Page_Filter_Bean() {
    super(C_Site_Page.class, "c_site_page", "desc");
    getSort_field_name_list().add(new SelectItem("c_site_page", bundle_funcs.getBundleValue("Identifikator")));
  }

  public static C_Site_Page_Filter_Bean getCurrentBean() {
    return jsf_funcs.findBean(C_Site_Page_Filter_Bean.class);
  }

  public C_Site_Page getFilter_entity_wrapped() {
    return getFilter_entity();
  }

  public C_Site_Page getC_site_page() {
    return getFilter_entity();
  }

}
