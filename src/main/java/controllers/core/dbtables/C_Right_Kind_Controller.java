package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;

@ManagedBean
@ViewScoped
public class C_Right_Kind_Controller extends Abstract_Controller<C_Right_Kind> {

  public C_Right_Kind_Controller() {
    super(C_Right_Kind.class, "c_right_kind_list.xhtml", false);
  }

  public C_Right_Kind getC_right_kind() {
    return getAbstract_entity();
  }



}
