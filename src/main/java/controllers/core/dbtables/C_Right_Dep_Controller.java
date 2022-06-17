package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;

@ManagedBean
@ViewScoped
public class C_Right_Dep_Controller extends Abstract_Controller<C_Right_Dep> {
  private C_Right_Kind c_right_kind = new C_Right_Kind();
  private C_Right_Kind dep_c_right_kind = new C_Right_Kind();
   
  public C_Right_Dep_Controller() {
    super(C_Right_Dep.class, "c_right_dep_list.xhtml", false);
  }

  public C_Right_Dep getC_right_dep() {
    return getAbstract_entity();
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

  @Override
  protected void afterLoadRec() {
    setC_right_kind(getC_right_dep().getC_right_t().getC_right_kind_t());
    setDep_c_right_kind(getC_right_dep().getDep_right_t().getC_right_kind_t());
  } 

}
