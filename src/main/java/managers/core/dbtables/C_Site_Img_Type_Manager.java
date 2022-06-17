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
public class C_Site_Img_Type_Manager extends Abstract_Controller_Manager<C_Site_Img_Type> {

  private static C_Site_Img_Type_Manager currentInstance = null;
  public static final int const_c_site_img_type__logo = 1;
  public static final int const_c_site_img_type__favicon = 2;
  public static final int const_c_site_img_type__entry_logo = 3;

  public static C_Site_Img_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Site_Img_Type_Manager();
    }
    return currentInstance;
  }

  public C_Site_Img_Type_Manager() {
    super(C_Site_Img_Type.class);
  }

}
