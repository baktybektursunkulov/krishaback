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
public class C_Length_Unit_Manager extends Abstract_Controller_Manager<C_Length_Unit> {

  private static C_Length_Unit_Manager currentInstance = null;
  //private C_Length_Unit base_c_length_unit = null;

  /*
  public C_Length_Unit getBase_c_length_unit() {
    if (base_c_length_unit == null) {
      base_c_length_unit = get_base_unit_row();
    }
    return base_c_length_unit;
  }

  public void setBase_c_length_unit(C_Length_Unit base_c_length_unit) {
    this.base_c_length_unit = base_c_length_unit;
  }

  public C_Length_Unit getBase_c_length_unit_2(Session session_) {
    if (base_c_length_unit == null) {
      base_c_length_unit = get_base_unit_row(session_);
    }
    return base_c_length_unit;
  }
  */
  
  public static C_Length_Unit_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Length_Unit_Manager();
    }
    return currentInstance;
  }

  public C_Length_Unit_Manager() {
    super(C_Length_Unit.class);
  }
/*
  public C_Length_Unit get_base_unit_row() {
    C_Length_Unit res;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_base_unit_row(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Length_Unit get_base_unit_row(Session session_) {
    Query q_ = session_.createQuery("from C_Length_Unit t where t.is_deleted=false and t.is_base_unit=true order by 1 asc ");
    q_.setMaxResults(1);
    List<C_Length_Unit> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }
*/
  public Double get_converted_val(C_Length_Unit from_c_length_, C_Length_Unit to_c_length_, Double val_) {
    Double res;
    res = val_ * (from_c_length_.getMultiplier_to_base_unit() / to_c_length_.getMultiplier_to_base_unit());
    return res;
  }
}
