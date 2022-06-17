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
public class C_Jur_Person_Addr_Type_Manager extends Abstract_Controller_Manager<C_Jur_Person_Addr_Type> {

  private static C_Jur_Person_Addr_Type_Manager currentInstance = null;
  private Integer id__jur_address = 1; // Юридический адрес
  private Integer id__fact_address = 2; // Фактический адрес

  public static C_Jur_Person_Addr_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Jur_Person_Addr_Type_Manager();
    }
    return currentInstance;
  }

  public Integer getId__jur_address() {
    return id__jur_address;
  }

  public void setId__jur_address(Integer id__jur_address) {
    this.id__jur_address = id__jur_address;
  }

  public Integer getId__fact_address() {
    return id__fact_address;
  }

  public void setId__fact_address(Integer id__fact_address) {
    this.id__fact_address = id__fact_address;
  }

  public C_Jur_Person_Addr_Type_Manager() {
    super(C_Jur_Person_Addr_Type.class);
  }

}
