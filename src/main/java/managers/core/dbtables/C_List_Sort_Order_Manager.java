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
public class C_List_Sort_Order_Manager extends Abstract_Controller_Manager<C_List_Sort_Order> {

  private static C_List_Sort_Order_Manager currentInstance = null;
  private Integer id_asc = 1;
  private Integer id_desc = 2;

  public static C_List_Sort_Order_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_List_Sort_Order_Manager();
    }
    return currentInstance;
  }

  public Integer getId_asc() {
    return id_asc;
  }

  public void setId_asc(Integer id_asc) {
    this.id_asc = id_asc;
  }

  public Integer getId_desc() {
    return id_desc;
  }

  public void setId_desc(Integer id_desc) {
    this.id_desc = id_desc;
  }

  public C_List_Sort_Order_Manager() {
    super(C_List_Sort_Order.class);
  }

}
