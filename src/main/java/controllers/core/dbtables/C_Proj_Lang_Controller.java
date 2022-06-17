package controllers.core.dbtables;

import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Loc_Manager;
import managers.core.dbtables.C_Proj_Lang_Manager;

@ManagedBean
@ViewScoped
public class C_Proj_Lang_Controller extends Abstract_Controller<C_Proj_Lang> {

  private List<C_Lang> avail_c_lang_list;

  public List<C_Lang> getAvail_c_lang_list() {
    return avail_c_lang_list;
  }

  public void setAvail_c_lang_list(List<C_Lang> avail_c_lang_list) {
    this.avail_c_lang_list = avail_c_lang_list;
  }

  public void refresh_avail_c_lang_list() {
    avail_c_lang_list = C_Proj_Lang_Manager.getCI().get_avail_c_lang_list(getAbstract_entity().getC_proj());
  }

  public C_Proj_Lang_Controller() {
    super(C_Proj_Lang.class, "c_proj_lang_list.xhtml", false);
  }

  public C_Proj_Lang getC_proj_lang() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec(Session session_) {
    getAbstract_entity().setIs_deleted(false);
    refresh_avail_c_lang_list();
  }

  @Override
  protected void deleteRec(Session session_) {
    getAbstract_entity().setIs_deleted(true);
    session_.merge(getAbstract_entity());
  }

  @Override
  protected void beforeInsertAndUpdateRec(Session session_) {
    C_Proj_Lang rec_ = C_Proj_Lang_Manager.getCI().get_unique_rec(session_, getAbstract_entity().getC_proj(), getAbstract_entity().getC_lang(), (Integer) getAbstract_entity().getEntity_id());
    if (rec_ != null) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Analogichnaya_zapis_uzhe_sushchestvuyet")));
    }
  }

}
