package controllers.core.dbtables;

import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Geocoding_Manager;
import managers.core.dbtables.C_Loc_Manager;

@ManagedBean
@ViewScoped
public class C_Loc_Controller extends Abstract_Controller<C_Loc> {

  public C_Loc_Controller() {
    super(C_Loc.class, "c_loc_list.xhtml", false);
  }

  public static C_Loc_Controller getCurrentBean() {
    return jsf_funcs.findBean("c_Loc_Controller");
  }

  public C_Loc getC_loc() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec(Session session_) {
    setAbstract_entity(C_Loc_Manager.getCI().get_new_row_with_default_vals(session_));
  }

  @Override
  protected void deleteRec(Session session_) {
    getAbstract_entity().setIs_deleted(true);
    session_.merge(getAbstract_entity());
  }

  @Override
  protected void beforeInsertAndUpdateRec(Session session_) {
    if (getAbstract_entity().getName() != null) {
      getAbstract_entity().setName(getAbstract_entity().getName().trim());
    }
    C_Loc rec_ = C_Loc_Manager.getCI().get_unique_rec(session_, getAbstract_entity().getParent_id(), getAbstract_entity().getName(), getAbstract_entity().getC_loc());
    if (rec_ != null) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Analogichnaya_zapis_uzhe_sushchestvuyet")));
    }
  }

  @Override
  protected void afterInsertAndUpdateAndDeleteRec(Session session_) {
    C_Loc_Manager.getCI().update_c_loc_is_grp(session_, getOld_abstract_entity());
    C_Loc_Manager.getCI().update_c_loc_is_grp(session_, getAbstract_entity());
  }

  @Override
  protected void afterInsertAndUpdateRec() {
    if (getIsAddMode()) {
      C_Loc_Manager.getCI().update_c_loc__lat_lon(getAbstract_entity());
    } else if (getIsEditMode()) {
      if (!getOld_abstract_entity().getName().equals(getAbstract_entity().getName())) {
        C_Loc_Manager.getCI().update_c_loc__lat_lon(getAbstract_entity());
      }
    }
  }

  @Override
  protected Boolean getIsLoadOldAbsractEntity() {
    return true;
  }

}
