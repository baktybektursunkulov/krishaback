package controllers.core.dbtables;

import additional_classes.C_Loc_Collector;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Loc_Grp_Loc_Manager;
import others.CustomLogger;

@ManagedBean
@ViewScoped
public class C_Loc_Grp_Loc_Mass_Controller extends Abstract_Controller<C_Loc_Grp_Loc> {

  private List<C_Loc> avail_c_loc_list;
  private C_Loc_Collector rec;
  private List<C_Loc_Collector> recs;

  @PostConstruct
  public void init() {
    rec = new C_Loc_Collector();
    recs = new ArrayList<C_Loc_Collector>();
  }

  public C_Loc_Collector getRec() {
    return rec;
  }

  public void setRec(C_Loc_Collector rec) {
    this.rec = rec;
  }

  public List<C_Loc_Collector> getRecs() {
    return recs;
  }

  public void setRecs(List<C_Loc_Collector> recs) {
    this.recs = recs;
  }

  public List<C_Loc> getAvail_c_loc_list() {
    return avail_c_loc_list;
  }

  public void setAvail_c_loc_list(List<C_Loc> avail_c_loc_list) {
    this.avail_c_loc_list = avail_c_loc_list;
  }

  public void refresh_avail_c_loc_list() {
    avail_c_loc_list = C_Loc_Grp_Loc_Manager.getCI().get_avail_c_loc_list(getAbstract_entity().getC_loc_grp());
  }
  
  public C_Loc_Grp_Loc_Mass_Controller() {
    super(C_Loc_Grp_Loc.class, "c_loc_grp_loc_list.xhtml", false);
  }

  public static C_Loc_Grp_Loc_Mass_Controller getCurrentBean() {
    return jsf_funcs.findBean("c_Loc_Grp_Loc_Mass_Controller");
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

  public String massInsertRecAction() {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      C_Loc_Collector rec_;
      C_Loc_Grp_Loc new_rec_;
      C_Loc_Grp_Loc unique_rec_;
      for (int i = 0; i < recs.size(); i++) {
        rec_ = recs.get(i);
        new_rec_ = new C_Loc_Grp_Loc();
        new_rec_.setC_loc_grp_t(getAbstract_entity().getC_loc_grp_t_2(session_));
        new_rec_.setC_loc_t(rec_.getC_loc());
        new_rec_.setIs_deleted(false);

        unique_rec_ = C_Loc_Grp_Loc_Manager.getCI().get_unique_rec(session_, new_rec_.getC_loc_grp(), 
          new_rec_.getC_loc(), null);
        if (unique_rec_ != null) {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Analogichnaya_zapis_uzhe_sushchestvuyet") + ": "
            + C_Loc_Grp_Loc_Manager.getCI().get_unique_violation_exception_string(session_, new_rec_)));
          return null;
        }

        C_Loc_Grp_Loc_Manager.getCI().insert_rec(session_, new_rec_);
      }
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    } finally { 
      hibernate_funcs.commitAndClose(session_);
    }

    return "c_loc_grp_loc_list.xhtml?faces-redirect=true";
  }

  public String massReinit() {
    C_Loc_Collector old_rec = rec;
    rec = new C_Loc_Collector();
    rec.setC_loc(old_rec.getC_loc());
    return null;
  }

}
