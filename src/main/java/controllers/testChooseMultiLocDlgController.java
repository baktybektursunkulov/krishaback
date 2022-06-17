package controllers;

import gs.common.hibernate_funcs;
import gs.common.image.image_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import managers.core.dbtables.C_Chat_Manager;
import managers.core.dbtables.C_Loc_Manager;
import managers.core.dbtables.C_Tbl_Manager;
import model.core.dbtables.*;
import org.hibernate.Session;
import others.CustomLogger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class testChooseMultiLocDlgController implements Serializable {
  private coreChooseMultiLocDlgController coreChooseMultiLocDlgController;

  public coreChooseMultiLocDlgController getCoreChooseMultiLocDlgController() {
    return coreChooseMultiLocDlgController;
  }

  public void setCoreChooseMultiLocDlgController(coreChooseMultiLocDlgController coreChooseMultiLocDlgController) {
    this.coreChooseMultiLocDlgController = coreChooseMultiLocDlgController;
  }

  

  
  

  public static testChooseMultiLocDlgController getCurrentBean() {
    return jsf_funcs.findBean(other_funcs.getBeanName(testChooseMultiLocDlgController.class));
  }

  public void execute_before_page_load() throws Exception {
    //Template1RequestBean.getCurrentBean().execute_before_page_load();
    if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
      return;
    }

    //chatController.getCurrentBean().initialize(C_Tbl_Manager.getCI().getC_tbl_id__ec_cus(), Long.valueOf(7));
    coreChooseMultiLocDlgController = new coreChooseMultiLocDlgController();
    coreChooseMultiLocDlgController.initialize();
  }

  
  public void openDialog() {
    List<C_Loc> all_selected_record_list_ = new ArrayList();
    //all_selected_record_list_.add(C_Loc_Manager.getCI().get_rec(2));
    //all_selected_record_list_.add(C_Loc_Manager.getCI().get_rec(47));    
    
    List<C_Loc> disabled_c_loc_list_  = new ArrayList();
    disabled_c_loc_list_.add(C_Loc_Manager.getCI().get_rec(2));
    coreChooseMultiLocDlgController.getC_Choose_Multi_Loc_Dlg_List_Bean().open_dialog_3(false, true, 0, 1, "target_for_dlg_", disabled_c_loc_list_, all_selected_record_list_);
  }
}
