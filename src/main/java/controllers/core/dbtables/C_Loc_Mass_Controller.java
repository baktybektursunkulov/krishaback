package controllers.core.dbtables;

import additional_classes.C_Loc_Mass_Add_Collector;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Geocoding_Manager;
import managers.core.dbtables.C_Loc_Manager;
import others.CustomLogger;

@ManagedBean
@ViewScoped
public class C_Loc_Mass_Controller extends Abstract_Controller<C_Loc> {

  private C_Loc_Mass_Add_Collector rec;
  private List<C_Loc_Mass_Add_Collector> recs;

  @PostConstruct
  public void init() {
    rec = new C_Loc_Mass_Add_Collector();
    recs = new ArrayList<C_Loc_Mass_Add_Collector>();
  }

 public C_Loc_Mass_Add_Collector getRec() {
    return rec;
  }

  public void setRec(C_Loc_Mass_Add_Collector rec) {
    this.rec = rec;
  }

  public List<C_Loc_Mass_Add_Collector> getRecs() {
    return recs;
  }

  public void setRecs(List<C_Loc_Mass_Add_Collector> recs) {
    this.recs = recs;
  }
  
  public C_Loc_Mass_Controller() {
    super(C_Loc.class, "c_loc_list.xhtml", false);
  }

  public static C_Loc_Mass_Controller getCurrentBean() {
    return jsf_funcs.findBean(other_funcs.getBeanName(C_Loc_Mass_Controller.class));
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

  public String massInsertRecAction() {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      C_Loc_Mass_Add_Collector rec_;
      C_Loc new_rec_;
      C_Loc unique_rec_;
      for (int i = 0; i < recs.size(); i++) {
        rec_ = recs.get(i);
        new_rec_ = C_Loc_Manager.getCI().get_new_row_with_default_vals(session_);
        new_rec_.setParent_id(getAbstract_entity().getParent_id());
        new_rec_.setName(rec_.getName());

        unique_rec_ = C_Loc_Manager.getCI().get_unique_rec(session_, new_rec_.getParent_id(), 
          new_rec_.getName(), null);
        if (unique_rec_ != null) {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Analogichnaya_zapis_uzhe_sushchestvuyet") + ": "
            + C_Loc_Manager.getCI().get_unique_violation_exception_string(session_, new_rec_)));
          return null;
        }

        C_Loc_Manager.getCI().insert_rec(session_, new_rec_);
      }
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    } finally {
      hibernate_funcs.commitAndClose(session_);
    }

    return "c_loc_list.xhtml?faces-redirect=true";
  }

  public String massReinit() {
    C_Loc_Mass_Add_Collector old_rec = rec;
    rec = new C_Loc_Mass_Add_Collector();
    rec.setName(old_rec.getName());
    return null;
  }

  
}
