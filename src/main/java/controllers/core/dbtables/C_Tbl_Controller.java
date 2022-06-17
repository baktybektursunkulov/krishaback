package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;

@ManagedBean
@ViewScoped
public class C_Tbl_Controller extends Abstract_Controller<C_Tbl> {

  public C_Tbl_Controller() {
    super(C_Tbl.class, "c_tbl_list.xhtml", false);
  }

  public C_Tbl getC_tbl() {
    return getAbstract_entity();
  }



}
