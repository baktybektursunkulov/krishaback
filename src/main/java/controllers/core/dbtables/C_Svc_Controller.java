package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;

@ManagedBean
@ViewScoped
public class C_Svc_Controller extends Abstract_Controller<C_Svc> {

  public C_Svc_Controller() {
    super(C_Svc.class, "c_svc_list.xhtml", false);
  }

  public C_Svc getC_svc() {
    return getAbstract_entity();
  }



}
