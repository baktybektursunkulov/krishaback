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
public class C_Addr_Type_Manager extends Abstract_Controller_Manager<C_Addr_Type> {

  private static C_Addr_Type_Manager currentInstance = null;
  private Integer c_addr_type_id__shipping_address = 1;// Адрес доставки
  private Integer c_addr_type_id__billing_address = 2;// Платежный адрес
  private Integer c_addr_type_id__mailing_address = 3;// Почтовый адрес
  private Integer c_addr_type_id__permanent_live_address = 4;// Постоянный адрес проживания

  public static C_Addr_Type_Manager getCurrentInstance() {
    return currentInstance;
  }

  public static void setCurrentInstance(C_Addr_Type_Manager currentInstance) {
    C_Addr_Type_Manager.currentInstance = currentInstance;
  }

  public Integer getC_addr_type_id__shipping_address() {
    return c_addr_type_id__shipping_address;
  }

  public void setC_addr_type_id__shipping_address(Integer c_addr_type_id__shipping_address) {
    this.c_addr_type_id__shipping_address = c_addr_type_id__shipping_address;
  }

  public Integer getC_addr_type_id__billing_address() {
    return c_addr_type_id__billing_address;
  }

  public void setC_addr_type_id__billing_address(Integer c_addr_type_id__billing_address) {
    this.c_addr_type_id__billing_address = c_addr_type_id__billing_address;
  }

  public Integer getC_addr_type_id__mailing_address() {
    return c_addr_type_id__mailing_address;
  }

  public void setC_addr_type_id__mailing_address(Integer c_addr_type_id__mailing_address) {
    this.c_addr_type_id__mailing_address = c_addr_type_id__mailing_address;
  }

  public Integer getC_addr_type_id__permanent_live_address() {
    return c_addr_type_id__permanent_live_address;
  }

  public void setC_addr_type_id__permanent_live_address(Integer c_addr_type_id__permanent_live_address) {
    this.c_addr_type_id__permanent_live_address = c_addr_type_id__permanent_live_address;
  }

  public static C_Addr_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Addr_Type_Manager();
    }
    return currentInstance;
  }

  public C_Addr_Type_Manager() {
    super(C_Addr_Type.class);
  }

}
