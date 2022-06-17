package controllers.core.dbtables;

import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Loc_Grp_Manager;
import managers.core.dbtables.C_Loc_Manager;

@ManagedBean
@ViewScoped
public class C_Loc_Grp_Controller extends Abstract_Controller<C_Loc_Grp> {

  public C_Loc_Grp_Controller() {
    super(C_Loc_Grp.class, "c_loc_grp_list.xhtml", false);
  }

  public C_Loc_Grp getC_loc_grp() {
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

  @Override
  protected void beforeInsertAndUpdateRec(Session session_) {
    C_Loc_Grp rec_ = C_Loc_Grp_Manager.getCI().get_unique_rec(session_, getAbstract_entity().getName(), getAbstract_entity().getC_loc_grp());
    if (rec_ != null) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Analogichnaya_zapis_uzhe_sushchestvuyet")));
    }
  }

}
