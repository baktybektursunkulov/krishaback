package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;

@ManagedBean
@ViewScoped
public class C_Right_Controller extends Abstract_Controller<C_Right> {

  public C_Right_Controller() {
    super(C_Right.class, "c_right_list.xhtml", false);
  }

  public C_Right getC_right() {
    return getAbstract_entity();
  }



}
