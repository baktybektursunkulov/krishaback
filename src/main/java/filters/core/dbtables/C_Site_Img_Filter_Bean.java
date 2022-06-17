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
public class C_Site_Img_Filter_Bean extends Abstract_Filter_Bean<C_Site_Img> {

  public C_Site_Img_Filter_Bean() {
    super(C_Site_Img.class, "c_site_img", "desc");
    getSort_field_name_list().add(new SelectItem("c_site_img", bundle_funcs.getBundleValue("Identifikator")));
  }

  public static C_Site_Img_Filter_Bean getCurrentBean() {
    return jsf_funcs.findBean(C_Site_Img_Filter_Bean.class);
  }

  public C_Site_Img getFilter_entity_wrapped() {
    return getFilter_entity();
  }
}
