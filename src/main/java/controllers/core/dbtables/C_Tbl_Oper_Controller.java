package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;

@ManagedBean
@ViewScoped
public class C_Tbl_Oper_Controller extends Abstract_Controller<C_Tbl_Oper> {

  public C_Tbl_Oper_Controller() {
    super(C_Tbl_Oper.class, "c_tbl_oper_list.xhtml", false);
  }

  public C_Tbl_Oper getC_tbl_oper() {
    return getAbstract_entity();
  }



}
