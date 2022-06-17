package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;

@ManagedBean
@ViewScoped
public class C_Svc_Cost_Row_Controller extends Abstract_Controller<C_Svc_Cost_Row> {

  public C_Svc_Cost_Row_Controller() {
    super(C_Svc_Cost_Row.class, "c_svc_cost_row_list.xhtml", false);
  }

  public C_Svc_Cost_Row getC_svc_cost_row() {
    return getAbstract_entity();
  }



}
