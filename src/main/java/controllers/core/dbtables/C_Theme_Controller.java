package controllers.core.dbtables;

import java.io.ByteArrayInputStream;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import managers.core.dbtables.C_Theme_Manager;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class C_Theme_Controller extends Abstract_Controller<C_Theme> {

  public C_Theme_Controller() {
    super(C_Theme.class, "c_theme_list.xhtml", false);
  }

  public C_Theme getC_theme() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getC_theme().setC_img_t(new C_Img());
  }

  @Override
  protected void afterLoadRec() {
    if (getC_theme().getC_img() == null) {
      getC_theme().setC_img_t(new C_Img());
    }
  }

  @Override
  protected void afterLoadCopyRec() {
    getC_theme().setC_img_t(new C_Img());
  }

  @Override
  protected void beforeInsertRec(Session session_) {
    try {
      getC_theme().setC_img_t(getC_theme().getC_img_t_2(session_).getCreatedImg(session_));
    } catch (Exception ex) {
      CustomLogger.error(ex);
    }
  }

  @Override
  protected void beforeUpdateRec(Session session_) {
    try {
      getC_theme().setC_img_t(getC_theme().getC_img_t_2(session_).getCreatedImg(session_));
    } catch (Exception ex) {
      CustomLogger.error(ex);
    }
  }

  public StreamedContent getThemeImage() {
    CustomLogger.log("getThemeImage");
    StreamedContent res = null;

    if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
      return new DefaultStreamedContent();
    } else {
      String c_theme_id_ = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("c_theme_id");
      if (c_theme_id_ == null) {
        return null;
      }
      CustomLogger.log("c_theme_id_=" + c_theme_id_);
      C_Theme c_theme_ = C_Theme_Manager.getCI().get_rec_2(Integer.valueOf(c_theme_id_));
      res = new DefaultStreamedContent(new ByteArrayInputStream(c_theme_.getC_img_t().getC_bin_file_body_t().getFile_body()));
    }

    return res;
  }

}
