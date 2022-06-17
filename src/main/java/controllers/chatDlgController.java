package controllers;

import gs.common.image.image_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import others.CustomLogger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class chatDlgController implements Serializable {
  private chatController chatController;

  public chatController getChatController() {
    return chatController;
  }

  public void setChatController(chatController chatController) {
    this.chatController = chatController;
  }
  
  

  public static chatDlgController getCurrentBean() {
    return jsf_funcs.findBean(other_funcs.getBeanName(chatDlgController.class));
  }

  public void openDialog(Integer initiator_c_tbl_id_, Long initiator_rec_id_, Integer opposite_c_tbl_id_, Long opposite_rec_id_, chatController chatController_) {
    try {
      chatController = chatController_;
      chatController.initialize(initiator_c_tbl_id_, initiator_rec_id_, opposite_c_tbl_id_, opposite_rec_id_);
      showDialog();
    } catch (Exception e) {
      CustomLogger.error(e);
      jsf_funcs.addErrorMessage(e);
    }
  }

  public void showDialog() {
    primefaces_funcs.executeJS("PF('wv_chat_dlg').show();");
  }

  public void hideDialog() {
    primefaces_funcs.executeJS("PF('wv_chat_dlg').hide();");
  }
}
