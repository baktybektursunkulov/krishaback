package lists.core.dbtables;

import beans.LocaleBean;
import controllers.core.dbtables.C_Loc_Controller;
import controllers.core.dbtables.C_Loc_Grp_Loc_Controller;
import controllers.core.dbtables.C_Loc_Grp_Loc_Mass_Controller;
import controllers.core.dbtables.C_Loc_Mass_Controller;
import filters.core.dbtables.C_Loc_Filter_Bean;
import filters.core.dbtables.*;
import gs.common.hibernate_funcs;
import gs.common.jsf.bundle_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import gs.common.model.db.*;
import gs.common.other_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Loc_Manager;
import model.core.dbtables.C_Loc;
import model.core.dbtables.C_File;
import org.hibernate.Session;
import org.primefaces.PrimeFaces;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class C_Choose_Loc_Dlg_List_Bean extends Abstract_List_Bean<C_Loc> {

  String target_for_dlg = "";
  private String lang;
  List<C_Loc> list_1;
  List<C_Loc> list_2;
  List<C_Loc> list_3;
  List<C_Loc> list_4;
  List<C_Loc> list_5;
  List<C_Loc> list_6;
  C_Loc list_1_selected_record;
  C_Loc list_2_selected_record;
  C_Loc list_3_selected_record;
  C_Loc list_4_selected_record;
  C_Loc list_5_selected_record;
  C_Loc list_6_selected_record;

  private Boolean is_show_tab_quick_search = true;
  private Boolean is_show_tab_manual_select = true;
  private Integer active_tab_index = 0;
  private Integer parent_id = null;

  public C_Choose_Loc_Dlg_List_Bean() {
    super("C_Loc", (C_Choose_Loc_Dlg_Filter_Bean) jsf_funcs.findBean("c_Choose_Loc_Dlg_Filter_Bean"));
  }

  public static C_Choose_Loc_Dlg_List_Bean getCurrentBean() {
    return jsf_funcs.findBean("c_Choose_Loc_Dlg_List_Bean");
  }

  public LazyDataModel<C_Loc> getConverted_rec_list() {
    return getRec_list();
  }

  public List<C_Loc> getConverted_rec_array_list() {
    return getRec_array_list();
  }

  public C_Choose_Loc_Dlg_Filter_Bean getFilter_bean_wrapped() {
    return (C_Choose_Loc_Dlg_Filter_Bean) getFilter_bean();
  }

  public String getTarget_for_dlg() {
    return target_for_dlg;
  }

  public void setTarget_for_dlg(String target_for_dlg) {
    this.target_for_dlg = target_for_dlg;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public List<C_Loc> getList_1() {
    return list_1;
  } 

  public void setList_1(List<C_Loc> list_1) {
    this.list_1 = list_1;
  }

  public List<C_Loc> getList_2() {
    return list_2;
  }

  public void setList_2(List<C_Loc> list_2) {
    this.list_2 = list_2;
  }

  public List<C_Loc> getList_3() {
    return list_3;
  }

  public void setList_3(List<C_Loc> list_3) {
    this.list_3 = list_3;
  }

  public C_Loc getList_1_selected_record() {
    return list_1_selected_record;
  }

  public void setList_1_selected_record(C_Loc list_1_selected_record) {
    this.list_1_selected_record = list_1_selected_record;
  }

  public C_Loc getList_2_selected_record() {
    return list_2_selected_record;
  }

  public void setList_2_selected_record(C_Loc list_2_selected_record) {
    this.list_2_selected_record = list_2_selected_record;
  }

  public C_Loc getList_3_selected_record() {
    return list_3_selected_record;
  }

  public void setList_3_selected_record(C_Loc list_3_selected_record) {
    this.list_3_selected_record = list_3_selected_record;
  }

  public List<C_Loc> getList_4() {
    return list_4;
  }

  public void setList_4(List<C_Loc> list_4) {
    this.list_4 = list_4;
  }

  public List<C_Loc> getList_5() {
    return list_5;
  }

  public void setList_5(List<C_Loc> list_5) {
    this.list_5 = list_5;
  }

  public List<C_Loc> getList_6() {
    return list_6;
  }

  public void setList_6(List<C_Loc> list_6) {
    this.list_6 = list_6;
  }

  public C_Loc getList_4_selected_record() {
    return list_4_selected_record;
  }

  public void setList_4_selected_record(C_Loc list_4_selected_record) {
    this.list_4_selected_record = list_4_selected_record;
  }

  public C_Loc getList_5_selected_record() {
    return list_5_selected_record;
  }

  public void setList_5_selected_record(C_Loc list_5_selected_record) {
    this.list_5_selected_record = list_5_selected_record;
  }

  public C_Loc getList_6_selected_record() {
    return list_6_selected_record;
  }

  public void setList_6_selected_record(C_Loc list_6_selected_record) {
    this.list_6_selected_record = list_6_selected_record;
  }

  public Boolean getIs_show_tab_quick_search() {
    return is_show_tab_quick_search;
  }

  public void setIs_show_tab_quick_search(Boolean is_show_tab_quick_search) {
    this.is_show_tab_quick_search = is_show_tab_quick_search;
  }

  public Boolean getIs_show_tab_manual_select() {
    return is_show_tab_manual_select;
  }

  public void setIs_show_tab_manual_select(Boolean is_show_tab_manual_select) {
    this.is_show_tab_manual_select = is_show_tab_manual_select;
  }

  public Integer getActive_tab_index() {
    return active_tab_index;
  }

  public void setActive_tab_index(Integer active_tab_index) {
    this.active_tab_index = active_tab_index;
  }

  public Integer getParent_id() {
    return parent_id;
  }

  public void setParent_id(Integer parent_id) {
    this.parent_id = parent_id;
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    sql_where_condition_arr_.add(new SQL_Where_Condition("t.is_deleted=false"));
    C_Loc filter_rec_ = getFilter_bean_wrapped().getFilter_entity_wrapped();
    /*
    if (filter_rec_.getParent_id()!= null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("t.parent_id=" + filter_rec_.getParent_id().toString()));
    }
     */
    if (filter_rec_.getName() != null && !filter_rec_.getName().trim().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(trim(t.name)) like '%" + filter_rec_.getName().trim().toLowerCase() + "%'"));
      //} else {
      //sql_where_condition_arr_.add(new SQL_Where_Condition("0=1"));
    }
    /*
    if (filter_rec_.getDescription()!= null && !filter_rec_.getDescription().trim().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(trim(t.description)) like '%" + filter_rec_.getDescription().trim().toLowerCase() + "%'"));
    }
     */
  }

  @Override
  protected Object rec_list_getRowData(String rowKey) {
    List<C_Loc> list_ = (List<C_Loc>) getConverted_rec_list().getWrappedData();
    Integer value = Integer.valueOf(rowKey);
    for (C_Loc rec : list_) {
      if (rec.getC_loc().equals(value)) {
        return rec;
      }
    }
    return null;
  }

  @Override
  protected void afterLoad(List<C_Loc> rec_list_) {
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      for (int i = 0; i < rec_list_.size(); i++) {
        rec_list_.get(i).getName_translation_3(session_, lang);
        rec_list_.get(i).getCalc_full_name_translation_2(session_, lang, "->");
      }
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
  }

  public void open_dialog() {
    lang = LocaleBean.getCurrentBean().getLanguageTag();
    //C_Choose_Loc_Dlg_Filter_Bean.getCurrentBean().getFilter_entity_wrapped().setName("");
    setSelected_record(null);
    setList_1(null);
    setList_1_selected_record(null);
    setList_2(null);
    setList_2_selected_record(null);
    setList_3(null);
    setList_3_selected_record(null);
    setList_4(null);
    setList_4_selected_record(null);
    setList_5(null);
    setList_5_selected_record(null);
    setList_6(null);
    setList_6_selected_record(null);
    /*
    if (!is_show_tab_quick_search && active_tab_index.equals(0)) {
      active_tab_index = 1;
    }
     */
    List<C_Loc> list_ = C_Loc_Manager.getCI().get_child_list_for_select(getParent_id(), lang);
    setList_1(list_);
    //PrimeFaces.current().dialog().openDynamic("/common/c_choose_loc_for_dlg.xhtml", primefaces_funcs.get_primefaces_dynamic_dialog_standart_options(), null);
    primefaces_funcs.executeJS("PF('wv_choose_loc_dlg').show();");
  }

  public void open_dialog_2(Boolean is_show_tab_quick_search_, Boolean is_show_tab_manual_select_, Integer active_tab_index_, Integer parent_id_) {
    this.is_show_tab_quick_search = is_show_tab_quick_search_;
    this.is_show_tab_manual_select = is_show_tab_manual_select_;
    this.active_tab_index = active_tab_index_;
    this.parent_id = parent_id_;
    open_dialog();
  }

  public void open_dialog_3(Boolean is_show_tab_quick_search_, Boolean is_show_tab_manual_select_, Integer active_tab_index_, Integer parent_id_, String target_for_dlg_) {
    this.target_for_dlg = target_for_dlg_;
    open_dialog_2(is_show_tab_quick_search_, is_show_tab_manual_select_, active_tab_index_, parent_id_);
  }
  
  public void handle_return_dialog(C_Loc rec_) {
    //C_Loc rec_ = (C_Loc) event.getObject();
    //System.out.println("rec_=" + rec_);
    if (rec_ != null) {
      if (getTarget_for_dlg().equals("c_loc_list.xhtml")) {
        C_Loc_Filter_Bean.getCurrentBean().getFilter_entity_wrapped().setParent_id_t(rec_);
        primefaces_funcs.updateElement("id_form_filtr:id_parent_id");
      } else if (getTarget_for_dlg().equals("c_loc_add_edit.xhtml")) {
        C_Loc_Controller.getCurrentBean().getC_loc().setParent_id_t(rec_);
        primefaces_funcs.updateElement("id_form:id_parent_id");
      } else if (getTarget_for_dlg().equals("c_loc_grp_loc_list.xhtml")) {
        C_Loc_Grp_Loc_Filter_Bean.getCurrentBean().getFilter_entity_wrapped().setC_loc_t(rec_);
        primefaces_funcs.updateElement("id_form_filtr:id_c_loc");
      } else if (getTarget_for_dlg().equals("c_loc_grp_loc_add_edit.xhtml")) {
        C_Loc_Grp_Loc_Controller.getCurrentBean().getC_loc_grp_loc().setC_loc_t(rec_);
        primefaces_funcs.updateElement("id_form:id_c_loc");
      } else if (getTarget_for_dlg().equals("c_loc_grp_loc_mass_add.xhtml")) {
        C_Loc_Grp_Loc_Mass_Controller.getCurrentBean().getRec().setC_loc(rec_);
        primefaces_funcs.updateElement("id_form:id_c_loc");
      } else if (getTarget_for_dlg().equals("c_loc_mass_add.xhtml")) {
        C_Loc_Mass_Controller.getCurrentBean().getAbstract_entity().setParent_id_t(rec_);
        primefaces_funcs.updateElement("id_form:id_parent_id");
      } else {
        handle_return_dialog_addition(rec_);
      }
    }
  }

  protected void handle_return_dialog_addition(C_Loc rec_) {

  }

  public void selectRecFromDialog() {
    if (getSelected_record() == null) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Zapis_ne_vybrana")));
      return;
    }
    handle_return_dialog(getSelected_record());
    primefaces_funcs.executeJS("PF('wv_choose_loc_dlg').hide();");
    //PrimeFaces.current().dialog().closeDynamic(getSelected_record());
  }

  public void closeDialog() {
    // PrimeFaces.current().dialog().closeDynamic(null);
    primefaces_funcs.executeJS("PF('wv_choose_loc_dlg').hide();");
  }

  public void onTabChange(TabChangeEvent event) {
    Tab activeTab = event.getTab();
    if (activeTab.getId().equals("id_tab_manual_select")) {
      if (getList_1() == null) {
        setList_1(C_Loc_Manager.getCI().get_child_list_for_select(null, lang));
      }
    }
  }

  public void list_1_on_select() {
    if (getList_1_selected_record() != null) {
      setSelected_record(getList_1_selected_record());
      setList_2(C_Loc_Manager.getCI().get_child_list_for_select(getSelected_record().getC_loc(), lang));
      setList_3(null);
      setList_4(null);
      setList_5(null);
      setList_6(null);
    }
  }

  public void list_2_on_select() {
    if (getList_2_selected_record() != null) {
      setSelected_record(getList_2_selected_record());
      setList_3(C_Loc_Manager.getCI().get_child_list_for_select(getSelected_record().getC_loc(), lang));
      setList_4(null);
      setList_5(null);
      setList_6(null);
    }
  }

  public void list_3_on_select() {
    if (getList_3_selected_record() != null) {
      setSelected_record(getList_3_selected_record());
      setList_4(C_Loc_Manager.getCI().get_child_list_for_select(getSelected_record().getC_loc(), lang));
      setList_5(null);
      setList_6(null);
    }
  }

  public void list_4_on_select() {
    if (getList_4_selected_record() != null) {
      setSelected_record(getList_4_selected_record());
      setList_5(C_Loc_Manager.getCI().get_child_list_for_select(getSelected_record().getC_loc(), lang));
      setList_6(null);
    }
  }

  public void list_5_on_select() {
    if (getList_5_selected_record() != null) {
      setSelected_record(getList_5_selected_record());
      setList_6(C_Loc_Manager.getCI().get_child_list_for_select(getSelected_record().getC_loc(), lang));
    }
  }

  public void list_6_on_select() {
    if (getList_6_selected_record() != null) {
      setSelected_record(getList_6_selected_record());
    }
  }

  public void list_1_on_click() {
    if (getList_1_selected_record() != null) {
      setSelected_record(getList_1_selected_record());
    }
  }

  public void list_2_on_click() {
    if (getList_2_selected_record() != null) {
      setSelected_record(getList_2_selected_record());
    }
  }

  public void list_3_on_click() {
    if (getList_3_selected_record() != null) {
      setSelected_record(getList_3_selected_record());
    }
  }

  public void list_4_on_click() {
    if (getList_4_selected_record() != null) {
      setSelected_record(getList_4_selected_record());
    }
  }

  public void list_5_on_click() {
    if (getList_5_selected_record() != null) {
      setSelected_record(getList_5_selected_record());
    }
  }

  public void list_6_on_click() {
    if (getList_6_selected_record() != null) {
      setSelected_record(getList_6_selected_record());
    }
  }

}
