package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Tbl_Rec_Corr_By_Name_Manager extends Abstract_Controller_Manager<C_Tbl_Rec_Corr_By_Name> {

  private static C_Tbl_Rec_Corr_By_Name_Manager currentInstance = null;

  public static C_Tbl_Rec_Corr_By_Name_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Rec_Corr_By_Name_Manager();
    }
    return currentInstance;
  }

  public C_Tbl_Rec_Corr_By_Name_Manager() {
    super(C_Tbl_Rec_Corr_By_Name.class);
  }

}
