package controllers.core.dbtables;

import gs.common.model.db.Abstract_Entity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import managers.core.dbtables.I_Tbl_Fld_Manager;
import managers.core.dbtables.I_Tbl_Fld_Trans_Manager;
import model.core.dbtables.*;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import gs.common.hibernate_funcs;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ViewScoped
public class I_Tbl_Fld_Trans_Controller extends Abstract_Controller<I_Tbl_Fld_Trans> {

  List<I_Tbl_Fld> i_tbl_fld_list;
  List<I_Tbl_Fld_Trans> i_tbl_fld_trans_list;
  List<Long> rec_id_list;

  public List<I_Tbl_Fld> getI_tbl_fld_list() {
    return i_tbl_fld_list;
  }

  public void setI_tbl_fld_list(List<I_Tbl_Fld> i_tbl_fld_list) {
    this.i_tbl_fld_list = i_tbl_fld_list;
  }

  public List<I_Tbl_Fld_Trans> getI_tbl_fld_trans_list() {
    return i_tbl_fld_trans_list;
  }

  public void setI_tbl_fld_trans_list(List<I_Tbl_Fld_Trans> i_tbl_fld_trans_list) {
    this.i_tbl_fld_trans_list = i_tbl_fld_trans_list;
  }

  public List<Long> getRec_id_list() {
    return rec_id_list;
  }

  public void setRec_id_list(List<Long> rec_id_list) {
    this.rec_id_list = rec_id_list;
  }

  @Override
  protected void afterLoadRec() {
    try {
      refresh_i_tbl_fld_list();
      refresh_i_tbl_fld_val();
      refresh_translation();
      refresh_rec_id_list();
    } catch (Exception ex) {
      Logger.getLogger(I_Tbl_Fld_Trans_Controller.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  protected void afterInsertAndUpdateAndDeleteRec(Session session_) {
    //I_Tbl_Fld_Trans_Manager.getCI().refresh_i_tbl_fld_trans_map(session_);
  }

  public void refresh_i_tbl_fld_list() {
    if (getI_tbl_fld_trans().getI_tbl() == null) {
      i_tbl_fld_list = null;
    } else {
      i_tbl_fld_list = I_Tbl_Fld_Manager.getCI().get_i_tbl_fld_list(getI_tbl_fld_trans().getI_tbl_t().getI_tbl());
    }
  }

  public I_Tbl_Fld_Trans_Controller() {
    super(I_Tbl_Fld_Trans.class, "i_tbl_fld_trans_list.xhtml", false);
  }

  public I_Tbl_Fld_Trans getI_tbl_fld_trans() {
    return getAbstract_entity();
  }

  public void refresh_i_tbl_fld_trans_list() throws Exception {
    if (getI_tbl_fld_trans().getI_tbl() == null || getI_tbl_fld_trans().getI_tbl_fld() == null || getI_tbl_fld_trans().getC_lang() == null) {
      i_tbl_fld_trans_list = null;
    } else {
      i_tbl_fld_trans_list = I_Tbl_Fld_Trans_Manager.getCI().get_i_tbl_fld_trans_list_for_mass_add(getI_tbl_fld_trans().getI_tbl_t(),
        getI_tbl_fld_trans().getI_tbl_fld_t(), getI_tbl_fld_trans().getC_lang_t());
    }
  }

  public String saveMassAdd() {
    try {
      Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      Transaction tx_ = null;
      try {
        tx_ = session_.beginTransaction();

        I_Tbl_Fld_Trans rec_;
        for (int i = 0; i < getI_tbl_fld_trans_list().size(); i++) {
          rec_ = getI_tbl_fld_trans_list().get(i);
          I_Tbl_Fld_Trans_Manager.getCI().set_tbl_fld_translation(session_, rec_.getI_tbl_t(), rec_.getRec_id(), rec_.getI_tbl_fld_t(), rec_.getC_lang_t(), rec_.getTranslation(),
            I_Tbl_Fld_Trans_Manager.get_tbl_fld_val(session_, rec_.getI_tbl_t().getName(), rec_.getI_tbl_t().getPk_fld_name(), rec_.getRec_id(), rec_.getI_tbl_fld_t().getName()));
        }

        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        if (tx_ != null) {
          hibernate_funcs.rollbackAndClose(session_);
        }
        throw e;
      }
    } catch (Exception e) {
      CustomLogger.error(e);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(gs.common.other_funcs.stack2string(e)));
      return null;
    }

    return "i_tbl_fld_trans_list.xhtml?faces-redirect=true";
  }

  public void refresh_rec_id_list() {
    if (getI_tbl_fld_trans().getI_tbl() == null || getI_tbl_fld_trans().getI_tbl_fld() == null || getI_tbl_fld_trans().getC_lang() == null) {
      rec_id_list = null;
    } else if (getIsAddMode()) {
      rec_id_list = I_Tbl_Fld_Trans_Manager.getCI().get_available_rec_id_list(getI_tbl_fld_trans().getI_tbl_t(),
        getI_tbl_fld_trans().getI_tbl_fld_t(), getI_tbl_fld_trans().getC_lang_t());
    } else {
      rec_id_list = I_Tbl_Fld_Trans_Manager.getCI().get_all_rec_id_list(getI_tbl_fld_trans().getI_tbl_t(),
        getI_tbl_fld_trans().getI_tbl_fld_t(), getI_tbl_fld_trans().getC_lang_t());
    }
  }

  public void refresh_i_tbl_fld_val() {
    if (getI_tbl_fld_trans().getI_tbl() == null || getI_tbl_fld_trans().getI_tbl_fld() == null || getI_tbl_fld_trans().getC_lang() == null) {
      getI_tbl_fld_trans().setI_tbl_fld_val("");
    } else {
      String translation_in_ru_ = I_Tbl_Fld_Trans_Manager.get_tbl_fld_val(getI_tbl_fld_trans().getI_tbl_t().getName(), getI_tbl_fld_trans().getI_tbl_t().getPk_fld_name(), getI_tbl_fld_trans().getRec_id(), getI_tbl_fld_trans().getI_tbl_fld_t().getName());
      getI_tbl_fld_trans().setI_tbl_fld_val(translation_in_ru_);
    }
  }

  public void refresh_translation() throws Exception {
    if (getI_tbl_fld_trans().getI_tbl() == null || getI_tbl_fld_trans().getI_tbl_fld() == null || getI_tbl_fld_trans().getC_lang() == null) {
      getI_tbl_fld_trans().setTranslation("");
    } else {
      String translation_in_ru_ = I_Tbl_Fld_Trans_Manager.get_tbl_fld_val(getI_tbl_fld_trans().getI_tbl_t().getName(), getI_tbl_fld_trans().getI_tbl_t().getPk_fld_name(), getI_tbl_fld_trans().getRec_id(), getI_tbl_fld_trans().getI_tbl_fld_t().getName());
      getI_tbl_fld_trans().setTranslation(I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(getI_tbl_fld_trans().getI_tbl_t().getName(), getI_tbl_fld_trans().getRec_id(),
        getI_tbl_fld_trans().getI_tbl_fld_t().getName(), getI_tbl_fld_trans().getC_lang_t().getCode(),
        translation_in_ru_));
    }
  }

}
