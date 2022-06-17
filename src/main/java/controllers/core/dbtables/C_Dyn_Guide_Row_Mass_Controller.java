package controllers.core.dbtables;

import additional_classes.C_Dyn_Guide_Row_Collector;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Dyn_Guide_Manager;
import managers.core.dbtables.C_Dyn_Guide_Row_Manager;
import managers.core.dbtables.C_Dyn_Guide_Row_Manager;
import others.CustomLogger;

@ManagedBean
@ViewScoped
public class C_Dyn_Guide_Row_Mass_Controller extends Abstract_Controller<C_Dyn_Guide_Row> {
  private C_Dyn_Guide_Row_Collector rec;
  private List<C_Dyn_Guide_Row_Collector> recs;

  @PostConstruct
  public void init() {
    rec = new C_Dyn_Guide_Row_Collector();
    recs = new ArrayList<C_Dyn_Guide_Row_Collector>();
  }

    public C_Dyn_Guide_Row_Collector getRec() {
    return rec;
  }

  public void setRec(C_Dyn_Guide_Row_Collector rec) {
    this.rec = rec;
  }

  public List<C_Dyn_Guide_Row_Collector> getRecs() {
    return recs;
  }

  public void setRecs(List<C_Dyn_Guide_Row_Collector> recs) {
    this.recs = recs;
  }

  public C_Dyn_Guide_Row_Mass_Controller() {
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

  public String massInsertRecAction() {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      C_Dyn_Guide_Row_Collector rec_;
      C_Dyn_Guide_Row new_rec_;
      C_Dyn_Guide_Row unique_rec_;
      for (int i = 0; i < recs.size(); i++) {
        rec_ = recs.get(i);
        new_rec_ = new C_Dyn_Guide_Row();
        new_rec_.setC_dyn_guide_t(getAbstract_entity().getC_dyn_guide_t_2(session_));
        new_rec_.setVal(rec_.getVal());
        new_rec_.setIs_deleted(false);

        unique_rec_ = C_Dyn_Guide_Row_Manager.getCI().get_unique_rec(session_, new_rec_.getC_dyn_guide(), 
          new_rec_.getVal(), null);
        if (unique_rec_ != null) {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Analogichnaya_zapis_uzhe_sushchestvuyet") + ": "
            + C_Dyn_Guide_Row_Manager.getCI().get_unique_violation_exception_string(session_, new_rec_)));
          return null;
        }

        C_Dyn_Guide_Row_Manager.getCI().insert_rec(session_, new_rec_);
      }
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    } finally {
      hibernate_funcs.commitAndClose(session_);
    }

    return "c_dyn_guide_row_list.xhtml?faces-redirect=true";
  }

  public String massReinit() {
    C_Dyn_Guide_Row_Collector old_rec = rec;
    rec = new C_Dyn_Guide_Row_Collector();
    return null;
  }
  
}
