package controllers.core.dbtables;

import filters.core.dbtables.C_Loc_Grp_Loc_Filter_Bean;
import gs.common.jsf.jsf_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import managers.core.dbtables.C_Loc_Grp_Loc_Manager;

@ManagedBean
@ViewScoped
public class C_Loc_Grp_Loc_Controller extends Abstract_Controller<C_Loc_Grp_Loc> {

  private List<C_Loc> avail_c_loc_list;

  public List<C_Loc> getAvail_c_loc_list() {
    return avail_c_loc_list;
  }

  public void setAvail_c_loc_list(List<C_Loc> avail_c_loc_list) {
    this.avail_c_loc_list = avail_c_loc_list;
  }

  public void refresh_avail_c_loc_list() {
    avail_c_loc_list = C_Loc_Grp_Loc_Manager.getCI().get_avail_c_loc_list(getAbstract_entity().getC_loc_grp());
  }
  
  public C_Loc_Grp_Loc_Controller() {
    super(C_Loc_Grp_Loc.class, "c_loc_grp_loc_list.xhtml", false);
  }

  public static C_Loc_Grp_Loc_Controller getCurrentBean() {
    return jsf_funcs.findBean("c_Loc_Grp_Loc_Controller");
  }
  
  public C_Loc_Grp_Loc getC_loc_grp_loc() {
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
