package controllers;

import gs.common.hibernate_funcs;
import gs.common.image.image_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import managers.core.dbtables.C_Chat_Manager;
import managers.core.dbtables.C_Chat_Msg_Type_Manager;
import managers.core.dbtables.C_Chat_Party_Status_Manager;
import model.core.dbtables.*;
import org.hibernate.Session;
import others.CustomLogger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import others.core_chat_funcs;
import java.util.Date;
import javax.faces.bean.ViewScoped;
import managers.core.dbtables.C_Chat_Cli_Manager;
import managers.core.dbtables.C_Chat_Msg_Manager;

@ManagedBean
@ViewScoped
public class coreChooseMultiLocDlgController extends chooseMultiLocDlgController {
  public coreChooseMultiLocDlgController getNewInstance() {
    return new coreChooseMultiLocDlgController();
  }

}
