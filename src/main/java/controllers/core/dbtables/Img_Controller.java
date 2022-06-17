package controllers.core.dbtables;

import java.io.ByteArrayInputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import managers.core.dbtables.C_Img_Manager;
import model.core.dbtables.*;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class Img_Controller extends Abstract_Controller<C_Img> {

  public Img_Controller() {
    super(C_Img.class, "img_list.xhtml");
  }

  public C_Img getImg() {
    return getAbstract_entity();
  }

  public StreamedContent getImgImageByImgId() {
    CustomLogger.log("getImgImageByImgId");
    StreamedContent res = null;

    if (FacesContext.getCurrentInstance().getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
      return new DefaultStreamedContent();
    } else {
      String img_id_ = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("img_id");
      if (img_id_ == null) {
        return null;
      }
      CustomLogger.log("img_id_=" + img_id_);
      C_Img img_ = C_Img_Manager.getCI().get_rec(Integer.valueOf(img_id_));
      res = new DefaultStreamedContent(new ByteArrayInputStream(img_.getC_bin_file_body_t().getFile_body()));
    }

    return res;
  }
  
}
