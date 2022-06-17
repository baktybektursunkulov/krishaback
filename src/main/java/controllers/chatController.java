package controllers;

import filters.core.dbtables.Abstract_Filter_Bean;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.model.db.SQL_Where_Condition;
import gs.common.other_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import managers.core.dbtables.C_Chat_Manager;
import managers.core.dbtables.C_Chat_Msg_Type_Manager;
import managers.core.dbtables.C_Chat_Party_Status_Manager;
import model.core.dbtables.*;
import org.hibernate.Session;
import others.CustomLogger;
import others.core_chat_funcs;
import java.util.Date;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import lists.core.dbtables.Abstract_List_Bean;
import managers.core.dbtables.C_Chat_Cli_Manager;
import managers.core.dbtables.C_Chat_Msg_Manager;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.primefaces.model.LazyDataModel;

@ManagedBean
@ViewScoped
public class chatController implements Serializable {

  private Integer initiator_c_tbl_id;
  private Long initiator_rec_id;

  private List<C_Chat> c_chat_list;
  private C_Chat selected_c_chat;
  private List<C_Chat> filtered_c_chat_list;
  private String msg_txt;

  private C_Chat prev_selected_c_chat;
  private Long last_c_chat_msg_id;
  private C_Chat_Msg_List_Bean c_chat_msg_list_bean;
  private C_Chat_Msg_Filter_Bean c_chat_msg_filter_bean;

  public Integer getInitiator_c_tbl_id() {
    return initiator_c_tbl_id;
  }

  public void setInitiator_c_tbl_id(Integer initiator_c_tbl_id) {
    this.initiator_c_tbl_id = initiator_c_tbl_id;
  }

  public Long getInitiator_rec_id() {
    return initiator_rec_id;
  }

  public void setInitiator_rec_id(Long initiator_rec_id) {
    this.initiator_rec_id = initiator_rec_id;
  }

  public List<C_Chat> getC_chat_list() {
    return c_chat_list;
  }

  public void setC_chat_list(List<C_Chat> c_chat_list) {
    this.c_chat_list = c_chat_list;
  }

  public C_Chat getSelected_c_chat() {
    return selected_c_chat;
  }

  public void setSelected_c_chat(C_Chat selected_c_chat) {
    this.selected_c_chat = selected_c_chat;
  }

  public List<C_Chat> getFiltered_c_chat_list() {
    return filtered_c_chat_list;
  }

  public void setFiltered_c_chat_list(List<C_Chat> filtered_c_chat_list) {
    this.filtered_c_chat_list = filtered_c_chat_list;
  }

  public String getMsg_txt() {
    return msg_txt;
  }

  public void setMsg_txt(String msg_txt) {
    this.msg_txt = msg_txt;
  }

  public C_Chat_Msg_List_Bean getC_chat_msg_list_bean() {
    return c_chat_msg_list_bean;
  }

  public void setC_chat_msg_list_bean(C_Chat_Msg_List_Bean c_chat_msg_list_bean) {
    this.c_chat_msg_list_bean = c_chat_msg_list_bean;
  }

  public C_Chat_Msg_Filter_Bean getC_chat_msg_filter_bean() {
    return c_chat_msg_filter_bean;
  }

  public void setC_chat_msg_filter_bean(C_Chat_Msg_Filter_Bean c_chat_msg_filter_bean) {
    this.c_chat_msg_filter_bean = c_chat_msg_filter_bean;
  }

  public static chatController getCurrentBean() {
    return jsf_funcs.findBean(other_funcs.getBeanName(chatController.class));
  }

  public void initialize(Integer initiator_c_tbl_id_, Long initiator_rec_id_, Integer opposite_c_tbl_id_, Long opposite_rec_id_) {
    this.initiator_c_tbl_id = initiator_c_tbl_id_;
    this.initiator_rec_id = initiator_rec_id_;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      if (opposite_c_tbl_id_ != null && opposite_rec_id_ != null) {
        C_Chat_Manager.getCI().get_row_for_indiv_chat_or_ins(session_, initiator_c_tbl_id_, initiator_rec_id_, opposite_c_tbl_id_, opposite_rec_id_);
        C_Chat c_Chat;
        refresh_c_chat_list(session_);
        for (int i = 0; i < c_chat_list.size(); i++) {
          c_Chat = c_chat_list.get(i);
          if (c_Chat.getOpposite_chat_cli().getC_tbl().equals(opposite_c_tbl_id_) && c_Chat.getOpposite_chat_cli().getRec_id().equals(opposite_rec_id_)) {
            setSelected_c_chat(c_Chat);
            on_select_c_chat_2(session_);
            primefaces_funcs.executeJS("var el_ = document.getElementById('id_form_chat_body:id_ita_msg_txt'); if (el_) {el_.focus();};");
            break;
          }
        }
      } else {
        refresh_c_chat_list(session_);
      }
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }

    c_chat_msg_filter_bean = new C_Chat_Msg_Filter_Bean();
    c_chat_msg_list_bean = new C_Chat_Msg_List_Bean();

    //setSelected_c_chat(c_chat_list.get(0));
  }

  public void refresh_c_chat_list(Session session_) {
    c_chat_list = C_Chat_Manager.getCI().get_row_list(session_, initiator_c_tbl_id, initiator_rec_id);
    C_Chat c_Chat;
    for (int i = 0; i < c_chat_list.size(); i++) {
      c_Chat = c_chat_list.get(i);
      refresh_c_chat(session_, c_Chat);
    }
    last_c_chat_msg_id = C_Chat_Msg_Manager.getCI().get_long_max_id_and_is_not_deleted(session_);
  }

  public void refresh_c_chat(Session session_, C_Chat c_Chat) {
    c_Chat.getLast_c_chat_msg_t_2(session_);

    C_Chat_Cli initiator_c_chat_cli_;
    C_Chat_Cli opposite_c_chat_cli_;
    initiator_c_chat_cli_ = c_Chat.getInitiator_chat_cli_2(session_, initiator_c_tbl_id, initiator_rec_id);
    initiator_c_chat_cli_.getName_2(session_);
    initiator_c_chat_cli_.getImg_id_2(session_);
    initiator_c_chat_cli_.getImg_url_2(session_);

    opposite_c_chat_cli_ = c_Chat.getOpposite_chat_cli_2(session_, initiator_c_tbl_id, initiator_rec_id);
    opposite_c_chat_cli_.getName_2(session_);
    opposite_c_chat_cli_.getImg_id_2(session_);
    opposite_c_chat_cli_.getImg_url_2(session_);
    opposite_c_chat_cli_.getC_chat_party_status_2(session_);
  }

  public void refresh_selected_c_chat(Session session_) {
    if (selected_c_chat == null) {
      return;
    }
    C_Chat new_c_chat_ = C_Chat_Manager.getCI().get_rec(session_, getSelected_c_chat().getC_chat());
    refresh_c_chat(session_, new_c_chat_);
    c_chat_list.set(c_chat_list.indexOf(getSelected_c_chat()), new_c_chat_);
    setSelected_c_chat(new_c_chat_);
  }

  public void send_message() {
    if (getMsg_txt().trim().isEmpty()) {
      return;
    }
    if (getSelected_c_chat() == null) {
      return;
    }
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      Date dt_ = new Date();
      core_chat_funcs.getCI().send_message(session_, getInitiator_c_tbl_id(), getInitiator_rec_id(), getSelected_c_chat().getOpposite_chat_cli().getC_tbl(),
        getSelected_c_chat().getOpposite_chat_cli().getRec_id(), C_Chat_Msg_Type_Manager.getCI().getC_id__text(), getMsg_txt(), null, dt_);
      refresh_selected_c_chat(session_);
      //primefaces_funcs.executeJS("document.getElementById('id_form_chat_body:id_cb_after_success_send_msg').click();");
      primefaces_funcs.executeJS("rc_after_success_send_msg();");
      //primefaces_funcs.updateElement("id_form_chat_body:id_dl_chat_msg");
      //primefaces_funcs.updateElement("id_form_chat_body:id_ita_msg_txt");
      //primefaces_funcs.updateElement("@(.sc_chat_data_" + getSelected_c_chat().getC_chat().toString() + ")");      
      hibernate_funcs.commitAndClose(session_);
      do_after_send_message(getInitiator_c_tbl_id(), getInitiator_rec_id(), getSelected_c_chat().getOpposite_chat_cli().getC_tbl(),
        getSelected_c_chat().getOpposite_chat_cli().getRec_id(), C_Chat_Msg_Type_Manager.getCI().getC_id__text(), getMsg_txt(), null, dt_);
      setMsg_txt("");
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  protected void do_after_send_message(Integer from_c_tbl_id_, Long from_rec_id_, Integer to_c_tbl_id_, Long to_rec_id_,
    Integer c_chat_msg_type_id_, String msg_txt_, Long reply_id_, Date dt_) {

  }

  public void on_select_c_chat() {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      on_select_c_chat_2(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public void on_select_c_chat_2(Session session_) {
    if (getSelected_c_chat() == null) {
      return;
    }

    if (prev_selected_c_chat != null) {
      if (!prev_selected_c_chat.equals(getSelected_c_chat())) {
        setMsg_txt("");
      }
    }
    prev_selected_c_chat = getSelected_c_chat();

    C_Chat_Cli_Manager.getCI().set_is_read(session_, getSelected_c_chat(), getSelected_c_chat().getInitiator_chat_cli(), getSelected_c_chat().getOpposite_chat_cli(), new Date());
    refresh_selected_c_chat(session_);
  }

  public void check_new_messages() {
    //Integer old_hash_code_ = c_chat_list.hashCode();
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      C_Chat_Party_Status_Manager.getCI().set_last_visit_dt(session_, initiator_c_tbl_id, initiator_rec_id, new Date());

      boolean need_refresh_ = false;
      List<C_Chat_Msg> c_chat_msg_list_ = C_Chat_Msg_Manager.getCI().get_row_list_for_monitoring(session_, initiator_c_tbl_id, initiator_rec_id, last_c_chat_msg_id, 1);
      if (!c_chat_msg_list_.isEmpty()) {
        need_refresh_ = true;
      } else {
        if (selected_c_chat != null) {
          if (selected_c_chat.getLast_c_chat_msg_t() != null) {
            if (selected_c_chat.getLast_c_chat_msg_t().getSender_c_tbl().equals(initiator_c_tbl_id) && selected_c_chat.getLast_c_chat_msg_t().getSender_rec_id().equals(initiator_rec_id)) {
              String old_icon_url_ = selected_c_chat.getLast_c_chat_msg_t().getIcon_url();
              selected_c_chat.setLast_c_chat_msg_t_2(null);
              String new_icon_url_ = selected_c_chat.getLast_c_chat_msg_t_2(session_).getIcon_url();
              if (!old_icon_url_.equals(new_icon_url_)) {
                need_refresh_ = true;
              }
            }
          }
        }
      }

      if (need_refresh_) {
        refresh_c_chat_list(session_);
        refresh_selected_c_chat(session_);
        if (selected_c_chat != null) {
          on_select_c_chat_2(session_);
        }
        //if (!old_hash_code_.equals(c_chat_list.hashCode())) {
        primefaces_funcs.executeJS("rc_after_success_check_new_messages();");
        //} 
      }

      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public class C_Chat_Msg_List_Bean extends Abstract_List_Bean<C_Chat_Msg> {

    public C_Chat_Msg_List_Bean() {
      super("C_Chat_Msg", c_chat_msg_filter_bean);
    }

    public LazyDataModel<C_Chat_Msg> getConverted_rec_list() {
      return getRec_list();
    }

    public List<C_Chat_Msg> getConverted_rec_array_list() {
      return getRec_array_list();
    }

    public C_Chat_Msg_Filter_Bean getFilter_bean_wrapped() {
      return (C_Chat_Msg_Filter_Bean) getFilter_bean();
    }

    @Override
    protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
      C_Chat selected_c_chat_ = getSelected_c_chat();
      if (selected_c_chat_ == null) {
        sql_where_condition_arr_.add(new SQL_Where_Condition("0=1"));
      } else {
        sql_where_condition_arr_.add(new SQL_Where_Condition("t.c_chat=" + selected_c_chat_.getC_chat().toString()));
      }
    }

    @Override
    protected Object rec_list_getRowData(String rowKey) {
      List<C_Chat_Msg> list_ = (List<C_Chat_Msg>) getConverted_rec_list().getWrappedData();
      Integer value = Integer.valueOf(rowKey);
      for (C_Chat_Msg rec : list_) {
        if (rec.getC_chat_msg().equals(value)) {
          return rec;
        }
      }
      return null;
    }

    @Override
    protected void error(Exception e) {
      CustomLogger.error(e);
    }

    @Override
    protected Session getOpenedSession() {
      return CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    }

    @Override
    protected Session getCurrentSession() {
      return CoreSessionFactoryUtil.getSessionFactoryUtilInstance().getCurrentSession();
    }

    @Override
    protected void deleteRec(Session session_, C_Chat_Msg rec_) {
      rec_.setIs_deleted(true);
      session_.merge(rec_);
    }

  }

  public class C_Chat_Msg_Filter_Bean extends Abstract_Filter_Bean<C_Chat_Msg> {

    public C_Chat_Msg_Filter_Bean() {
      super(C_Chat_Msg.class, "sent_dt", "desc");
      getSort_field_name_list().add(new SelectItem("c_chat_msg", bundle_funcs.getBundleValue("Identifikator")));
    }

    public C_Chat_Msg getFilter_entity_wrapped() {
      return getFilter_entity();
    }

    public C_Chat_Msg getC_chat_msg() {
      return getFilter_entity();
    }

  }

}
