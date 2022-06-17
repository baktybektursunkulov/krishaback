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
public class C_Weight_Unit_Manager extends Abstract_Controller_Manager<C_Weight_Unit> {

  private static C_Weight_Unit_Manager currentInstance = null;

  public static C_Weight_Unit_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Weight_Unit_Manager();
    }
    return currentInstance;
  }

  public C_Weight_Unit_Manager() {
    super(C_Weight_Unit.class);
  }

  public Double get_converted_val(C_Weight_Unit from_, C_Weight_Unit to_, Double val_) {
    Double res;
    res = val_ * (from_.getMultiplier_to_base_unit() / to_.getMultiplier_to_base_unit());
    return res;
  }
  
}
