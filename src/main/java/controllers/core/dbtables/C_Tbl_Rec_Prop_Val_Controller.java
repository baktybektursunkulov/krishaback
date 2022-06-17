package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;

@ManagedBean
@ViewScoped
public class C_Tbl_Rec_Prop_Val_Controller extends Abstract_Controller<C_Tbl_Rec_Prop_Val> {

  public C_Tbl_Rec_Prop_Val_Controller() {
    super(C_Tbl_Rec_Prop_Val.class, "c_tbl_rec_prop_val_list.xhtml", false);
  }
 
  public C_Tbl_Rec_Prop_Val getC_tbl_rec_prop_val() {
    return getAbstract_entity();
  }



}
