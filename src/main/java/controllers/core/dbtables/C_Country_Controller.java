package controllers.core.dbtables;

import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Country_Manager;
import managers.core.dbtables.C_Loc_Manager;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class C_Country_Controller extends Abstract_Controller<C_Country> {

  public C_Country_Controller() {
    super(C_Country.class, "c_country_list.xhtml", false);
  }

  public C_Country getC_country() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setIs_deleted(false);
  }

  @Override
  protected void afterLoadRec() {
    if (getAbstract_entity().getFlag_img() == null) {
      getAbstract_entity().setFlag_img_t(new C_Img());
    }
  }

  @Override
  protected void afterLoadCopyRec() {
    getAbstract_entity().setFlag_img_t(new C_Img());
  }

  @Override
  protected void deleteRec(Session session_) {
    getAbstract_entity().setIs_deleted(true);
    session_.merge(getAbstract_entity());
  }

  @Override
  protected void beforeInsertAndUpdateRec(Session session_) {
    try {
      C_Country rec_ = C_Country_Manager.getCI().get_unique_rec_by_code(session_, getAbstract_entity().getCode(), getAbstract_entity().getC_country());
      if (rec_ != null) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Analogichnaya_zapis_uzhe_sushchestvuyet")));
      }
      rec_ = C_Country_Manager.getCI().get_unique_rec_by_name(session_, getAbstract_entity().getName(), getAbstract_entity().getC_country());
      if (rec_ != null) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Analogichnaya_zapis_uzhe_sushchestvuyet")));
      }
      if (getAbstract_entity().getFlag_img_t_2(session_) != null) {
        getAbstract_entity().setFlag_img_t(getAbstract_entity().getFlag_img_t_2(session_).getCreatedImg(session_));
      } else {
        getAbstract_entity().setFlag_img_t(null);
      }
    } catch (Exception ex) {
      jsf_funcs.addErrorMessage(ex);
    }
  }

}
