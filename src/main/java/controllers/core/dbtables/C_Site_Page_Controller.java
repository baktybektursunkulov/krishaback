package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;

@ManagedBean
@ViewScoped
public class C_Site_Page_Controller extends Abstract_Controller<C_Site_Page> {

  public C_Site_Page_Controller() {
    super(C_Site_Page.class, "c_site_page_list.xhtml", false);
  }

  public static C_Site_Page_Controller getCurrentBean() {
    return jsf_funcs.findBean(C_Site_Page_Controller.class);
  }
  

  public C_Site_Page getC_site_page() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setIs_deleted(false);
  }

  @Override
  protected void deleteRec(Session session_) {
    getAbstract_entity().setIs_deleted(true);
    session_.merge(getAbstract_entity());
  }


}
