package controllers.core.dbtables;

import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Dyn_Guide_Manager;
import managers.core.dbtables.C_Dyn_Guide_Row_Manager;

@ManagedBean
@ViewScoped
public class C_Dyn_Guide_Row_Controller extends Abstract_Controller<C_Dyn_Guide_Row> {

  public C_Dyn_Guide_Row_Controller() {
    super(C_Dyn_Guide_Row.class, "c_dyn_guide_row_list.xhtml", false);
  }

  public C_Dyn_Guide_Row getC_dyn_guide_row() {
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
    C_Dyn_Guide_Row rec_ = C_Dyn_Guide_Row_Manager.getCI().get_unique_rec(session_, getAbstract_entity().getC_dyn_guide(), getAbstract_entity().getVal(), getAbstract_entity().getC_dyn_guide_row());
    if (rec_ != null) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Analogichnaya_zapis_uzhe_sushchestvuyet")));
    }
  }

}
