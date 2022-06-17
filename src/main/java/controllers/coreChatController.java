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
public class coreChatController extends chatController {
  public coreChatController getNewInstance() {
    return new coreChatController();
  }

  protected void do_after_send_message(Integer from_c_tbl_id_, Long from_rec_id_, Integer to_c_tbl_id_, Long to_rec_id_,
    Integer c_chat_msg_type_id_, String msg_txt_, Long reply_id_, Date dt_) {
    System.out.println("do_after_send_message");
  }
}
