package controllers;

import gs.common.hibernate_funcs;
import gs.common.image.image_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import managers.core.dbtables.C_Chat_Manager;
import managers.core.dbtables.C_Tbl_Manager;
import model.core.dbtables.*;
import org.hibernate.Session;
import others.CustomLogger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class testChatController implements Serializable {
  private coreChatController coreChatController;

  public coreChatController getCoreChatController() {
    return coreChatController;
  }

  public void setCoreChatController(coreChatController coreChatController) {
    this.coreChatController = coreChatController;
  }

  
  

  public static testChatController getCurrentBean() {
    return jsf_funcs.findBean(other_funcs.getBeanName(testChatController.class));
  }

  public void execute_before_page_load() throws Exception {
    //Template1RequestBean.getCurrentBean().execute_before_page_load();
    if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
      return;
    }
    Map<String, String> request_parameter_map_ = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    String initiator_c_tbl_id_str_ = (request_parameter_map_.get("initiator_c_tbl_id"));
    String initiator_rec_id_str_ = (request_parameter_map_.get("initiator_rec_id"));

    String opposite_c_tbl_id_str_ = (request_parameter_map_.get("opposite_c_tbl_id"));
    String opposite_rec_id_str_ = (request_parameter_map_.get("opposite_rec_id"));
    Integer opposite_c_tbl_id_ = (opposite_c_tbl_id_str_ == null ? null : Integer.valueOf(opposite_c_tbl_id_str_));
    Long opposite_rec_id_ = (opposite_rec_id_str_ == null ? null : Long.valueOf(opposite_rec_id_str_));

    //chatController.getCurrentBean().initialize(C_Tbl_Manager.getCI().getC_tbl_id__ec_cus(), Long.valueOf(7));
    coreChatController = new coreChatController();
    coreChatController.initialize(Integer.valueOf(initiator_c_tbl_id_str_), Long.valueOf(initiator_rec_id_str_),
      opposite_c_tbl_id_, opposite_rec_id_);
  }

}
