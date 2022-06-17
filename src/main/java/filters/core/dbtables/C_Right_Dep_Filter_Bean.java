package filters.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;

@ManagedBean
@SessionScoped
public class C_Right_Dep_Filter_Bean extends Abstract_Filter_Bean<C_Right_Dep> {

  private C_Right_Dep filter_c_right_dep = new C_Right_Dep();
  private C_Right_Kind c_right_kind = new C_Right_Kind();
  private C_Right_Kind dep_c_right_kind = new C_Right_Kind();
     
  public C_Right_Dep_Filter_Bean() {
    super(C_Right_Dep.class, "c_right_dep", "desc");
    getSort_field_name_list().add(new SelectItem("c_right_dep", bundle_funcs.getBundleValue("Identifikator")));
    getSort_field_name_list().add(new SelectItem("c_right.name", bundle_funcs.getBundleValue("Pravo")));
    getSort_field_name_list().add(new SelectItem("dep_right.name", bundle_funcs.getBundleValue("Zavisimoe_pravo")));     
  }

  public C_Right_Dep getFilter_entity_wrapped() {
    return getFilter_entity();
  }
  
  public C_Right_Dep getFilter_c_right_dep() {
    return filter_c_right_dep;
  }

  public void setFilter_c_right_dep(C_Right_Dep filter_c_right_dep) {
    this.filter_c_right_dep = filter_c_right_dep;
  }

  public C_Right_Kind getC_right_kind() {
    return c_right_kind;
  }

  public void setC_right_kind(C_Right_Kind c_right_kind) {
    this.c_right_kind = c_right_kind;
  }

  public C_Right_Kind getDep_c_right_kind() {
    return dep_c_right_kind;
  }

  public void setDep_c_right_kind(C_Right_Kind dep_c_right_kind) {
    this.dep_c_right_kind = dep_c_right_kind;
  }   
}
