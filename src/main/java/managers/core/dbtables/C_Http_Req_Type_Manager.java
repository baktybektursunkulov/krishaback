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
public class C_Http_Req_Type_Manager extends Abstract_Controller_Manager<C_Http_Req_Type> {

  private static C_Http_Req_Type_Manager currentInstance = null;
  private Integer id__unknown = 1; //Неизвестный
  private Integer id__paybox = 2; //paybox

  public static C_Http_Req_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Http_Req_Type_Manager();
    }
    return currentInstance;
  }

  public Integer getId__unknown() {
    return id__unknown;
  }

  public void setId__unknown(Integer id__unknown) {
    this.id__unknown = id__unknown;
  }

  public Integer getId__paybox() {
    return id__paybox;
  }

  public void setId__paybox(Integer id__paybox) {
    this.id__paybox = id__paybox;
  }

  public C_Http_Req_Type_Manager() {
    super(C_Http_Req_Type.class);
  }

}
