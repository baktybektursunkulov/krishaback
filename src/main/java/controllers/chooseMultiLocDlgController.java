package controllers;

import additional_classes.C_Choose_Multi_Loc_Rec;
import beans.LocaleBean;
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
import model.core.dbtables.*;
import org.hibernate.Session;
import others.CustomLogger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import lists.core.dbtables.Abstract_List_Bean;
import managers.core.dbtables.C_Loc_Manager;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.LazyDataModel;

@ManagedBean
@ViewScoped
public class chooseMultiLocDlgController implements Serializable {

  private C_Choose_Multi_Loc_Dlg_List_Bean c_Choose_Multi_Loc_Dlg_List_Bean;
  private C_Choose_Multi_Loc_Dlg_Filter_Bean c_Choose_Multi_Loc_Dlg_Filter_Bean;

  public C_Choose_Multi_Loc_Dlg_List_Bean getC_Choose_Multi_Loc_Dlg_List_Bean() {
    return c_Choose_Multi_Loc_Dlg_List_Bean;
  }

  public void setC_Choose_Multi_Loc_Dlg_List_Bean(C_Choose_Multi_Loc_Dlg_List_Bean c_Choose_Multi_Loc_Dlg_List_Bean) {
    this.c_Choose_Multi_Loc_Dlg_List_Bean = c_Choose_Multi_Loc_Dlg_List_Bean;
  }

  public C_Choose_Multi_Loc_Dlg_Filter_Bean getC_Choose_Multi_Loc_Dlg_Filter_Bean() {
    return c_Choose_Multi_Loc_Dlg_Filter_Bean;
  }

  public void setC_Choose_Multi_Loc_Dlg_Filter_Bean(C_Choose_Multi_Loc_Dlg_Filter_Bean c_Choose_Multi_Loc_Dlg_Filter_Bean) {
    this.c_Choose_Multi_Loc_Dlg_Filter_Bean = c_Choose_Multi_Loc_Dlg_Filter_Bean;
  }

  public void initialize() {
    c_Choose_Multi_Loc_Dlg_Filter_Bean = new chooseMultiLocDlgController.C_Choose_Multi_Loc_Dlg_Filter_Bean();
    c_Choose_Multi_Loc_Dlg_List_Bean = new chooseMultiLocDlgController.C_Choose_Multi_Loc_Dlg_List_Bean();
  }

  public static chooseMultiLocDlgController getCurrentBean() {
    return jsf_funcs.findBean(other_funcs.getBeanName(chooseMultiLocDlgController.class));
  }

  public void handle_return_dialog(List<C_Loc> rec_list_) {
    //C_Loc rec_ = (C_Loc) event.getObject();
    //System.out.println("rec_=" + rec_);
    if (rec_list_ != null) {
      if (this.c_Choose_Multi_Loc_Dlg_List_Bean.getTarget_for_dlg().equals("c_loc_list.xhtml")) {
        /*
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
         */
      } else {
        handle_return_dialog_addition(rec_list_);
      }
    }
  }

  protected void handle_return_dialog_addition(List<C_Loc> rec_list_) {

  }

  public void selectRecListFromDialog() {
    if (this.c_Choose_Multi_Loc_Dlg_List_Bean.getAll_selected_record_list() == null || this.c_Choose_Multi_Loc_Dlg_List_Bean.getAll_selected_record_list().isEmpty()) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(bundle_funcs.getBundleValue("Не_выбраны_записи")));
      return;
    }
    handle_return_dialog(this.c_Choose_Multi_Loc_Dlg_List_Bean.getAll_selected_record_list());
    primefaces_funcs.executeJS("PF('wv_choose_multi_loc_dlg').hide();");
    //PrimeFaces.current().dialog().closeDynamic(getSelected_record());
  }

  public class C_Choose_Multi_Loc_Dlg_List_Bean extends Abstract_List_Bean<C_Loc> {

    String target_for_dlg = "";
    private String lang;
    private List<C_Choose_Multi_Loc_Rec> c_choose_multi_loc_rec_list;

    private Boolean is_show_tab_quick_search = true;
    private Boolean is_show_tab_manual_select = true;
    private Integer active_tab_index = 0;
    private Integer parent_id = null;
    private List<C_Loc> disabled_c_loc_list;

    private List<C_Loc> all_selected_record_list = new ArrayList();

    public C_Choose_Multi_Loc_Dlg_List_Bean() {
      super("C_Loc", (C_Choose_Multi_Loc_Dlg_Filter_Bean) jsf_funcs.findBean(C_Choose_Multi_Loc_Dlg_Filter_Bean.class));
    }

    public LazyDataModel<C_Loc> getConverted_rec_list() {
      return getRec_list();
    }

    public List<C_Loc> getConverted_rec_array_list() {
      return getRec_array_list();
    }

    public C_Choose_Multi_Loc_Dlg_Filter_Bean getFilter_bean_wrapped() {
      return (C_Choose_Multi_Loc_Dlg_Filter_Bean) getFilter_bean();
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

    public List<C_Choose_Multi_Loc_Rec> getC_choose_multi_loc_rec_list() {
      return c_choose_multi_loc_rec_list;
    }

    public void setC_choose_multi_loc_rec_list(List<C_Choose_Multi_Loc_Rec> c_choose_multi_loc_rec_list) {
      this.c_choose_multi_loc_rec_list = c_choose_multi_loc_rec_list;
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

    public List<C_Loc> getDisabled_c_loc_list() {
      return disabled_c_loc_list;
    }

    public void setDisabled_c_loc_list(List<C_Loc> disabled_c_loc_list) {
      this.disabled_c_loc_list = disabled_c_loc_list;
    }

    public List<C_Loc> getAll_selected_record_list() {
      return all_selected_record_list;
    }

    public void setAll_selected_record_list(List<C_Loc> all_selected_record_list) {
      this.all_selected_record_list = all_selected_record_list;
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
      //C_Choose_Multi_Loc_Dlg_Filter_Bean.getCurrentBean().getFilter_entity_wrapped().setName("");
      setSelected_record(null);
      c_choose_multi_loc_rec_list = new ArrayList(6);
      for (int i = 0; i < 6; i++) {
        c_choose_multi_loc_rec_list.add(new C_Choose_Multi_Loc_Rec());
      }
      /*
    if (!is_show_tab_quick_search && active_tab_index.equals(0)) {
      active_tab_index = 1;
    }
       */
      C_Choose_Multi_Loc_Rec c_Choose_Multi_Loc_Rec;
      c_Choose_Multi_Loc_Rec = new C_Choose_Multi_Loc_Rec();
      c_Choose_Multi_Loc_Rec.list = C_Loc_Manager.getCI().get_child_list_for_select(getParent_id(), lang);
      C_Loc_Manager.getCI().fill_has_childs(c_Choose_Multi_Loc_Rec.list);
      if (getParent_id() == null) {
        c_Choose_Multi_Loc_Rec.parent = null;
      } else {
        c_Choose_Multi_Loc_Rec.parent = C_Loc_Manager.getCI().get_rec(getParent_id());
      }
      c_choose_multi_loc_rec_list.set(0, c_Choose_Multi_Loc_Rec);
      refresh_all_list_selected_record_list();
      //PrimeFaces.current().dialog().openDynamic("/common/c_choose_multi_loc_for_dlg.xhtml", primefaces_funcs.get_primefaces_dynamic_dialog_standart_options(), null);
      primefaces_funcs.executeJS("PF('wv_choose_multi_loc_dlg').show();");
    }

    public void open_dialog_2(Boolean is_show_tab_quick_search_, Boolean is_show_tab_manual_select_, Integer active_tab_index_, Integer parent_id_,
      List<C_Loc> disabled_c_loc_list_, List<C_Loc> all_selected_record_list_) {
      this.is_show_tab_quick_search = is_show_tab_quick_search_;
      this.is_show_tab_manual_select = is_show_tab_manual_select_;
      this.active_tab_index = active_tab_index_;
      this.parent_id = parent_id_;
      this.disabled_c_loc_list = disabled_c_loc_list_;
      if (this.disabled_c_loc_list == null) {
        this.disabled_c_loc_list = new ArrayList();
      }
      this.all_selected_record_list = all_selected_record_list_;
      if (this.all_selected_record_list == null) {
        this.all_selected_record_list = new ArrayList();
      }
      open_dialog();
    }

    public void open_dialog_3(Boolean is_show_tab_quick_search_, Boolean is_show_tab_manual_select_, Integer active_tab_index_, Integer parent_id_, String target_for_dlg_,
      List<C_Loc> disabled_c_loc_list_, List<C_Loc> all_selected_record_list_) {
      this.target_for_dlg = target_for_dlg_;
      open_dialog_2(is_show_tab_quick_search_, is_show_tab_manual_select_, active_tab_index_, parent_id_, disabled_c_loc_list_, all_selected_record_list_);
    }

    public void closeDialog() {
      // PrimeFaces.current().dialog().closeDynamic(null);
      primefaces_funcs.executeJS("PF('wv_choose_multi_loc_dlg').hide();");
    }

    public void onTabChange(TabChangeEvent event) {
      Tab activeTab = event.getTab();
      if (activeTab.getId().equals("id_tab_manual_select")) {
        C_Choose_Multi_Loc_Rec c_Choose_Multi_Loc_Rec = new C_Choose_Multi_Loc_Rec();
        c_Choose_Multi_Loc_Rec.list = C_Loc_Manager.getCI().get_child_list_for_select(null, lang);
        C_Loc_Manager.getCI().fill_has_childs(c_Choose_Multi_Loc_Rec.list);
        if (getParent_id() == null) {
          c_Choose_Multi_Loc_Rec.parent = null;
        } else {
          c_Choose_Multi_Loc_Rec.parent = C_Loc_Manager.getCI().get_rec(getParent_id());
        }
        c_choose_multi_loc_rec_list.set(0, c_Choose_Multi_Loc_Rec);
      }
    }

    public void list_on_select(C_Loc rec_, int num_) {
      if (num_ > c_choose_multi_loc_rec_list.size() - 1) {
        return;
      }
      c_choose_multi_loc_rec_list.get(num_).setList_active_record(rec_);
      c_choose_multi_loc_rec_list.get(num_ + 1).parent = rec_;
      c_choose_multi_loc_rec_list.get(num_ + 1).list = C_Loc_Manager.getCI().get_child_list_for_select(rec_.getC_loc(), lang);
      c_choose_multi_loc_rec_list.get(num_ + 1).list_selected_record_list = get_selected_record_list(c_choose_multi_loc_rec_list.get(num_ + 1).list);
      C_Loc_Manager.getCI().fill_has_childs(c_choose_multi_loc_rec_list.get(num_ + 1).list);
      for (int i = num_ + 2; i < c_choose_multi_loc_rec_list.size(); i++) {
        c_choose_multi_loc_rec_list.get(i).list = null;
      }
      refresh_has_selected_childs();
    }

    public void refresh_has_selected_childs() {
      C_Choose_Multi_Loc_Rec c_Choose_Multi_Loc_Rec;
      C_Loc c_Loc;
      C_Loc all_selected_record_;
      for (int i = 0; i < c_choose_multi_loc_rec_list.size(); i++) {
        c_Choose_Multi_Loc_Rec = c_choose_multi_loc_rec_list.get(i);
        if (c_Choose_Multi_Loc_Rec.list != null) {
          for (int j = 0; j < c_Choose_Multi_Loc_Rec.list.size(); j++) {
            c_Loc = c_Choose_Multi_Loc_Rec.list.get(j);
            c_Loc.setHas_selected_childs(false);
            for (int k = 0; k < all_selected_record_list.size(); k++) {
              all_selected_record_ = all_selected_record_list.get(k);
              if (all_selected_record_.getParent_id() != null) {
                if (all_selected_record_.getParent_id().equals(c_Loc.getC_loc())) {
                  c_Loc.setHas_selected_childs(true);
                  break;
                }
              }
            }
          }
        }
      }

    }

    public String selected_record_list_str() {
      String res = "";
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        List<C_Loc> list_ = getAll_selected_record_list();
        for (int i = 0; i < list_.size(); i++) {
          if (i > 0) {
            res = res + ", ";
          }
          res = res + list_.get(i).getName_translation_3(session_, lang);
        }
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
      return res;
    }

    public void select_all(List<C_Loc> list_selected_record_list_, List<C_Loc> list_) {
      if (list_selected_record_list_ == null) {
        list_selected_record_list_ = new ArrayList();
      }
      C_Loc c_Loc;
      for (int i = 0; i < list_.size(); i++) {
        c_Loc = list_.get(i);
        if (!is_c_loc_disabled(c_Loc)) {
          list_selected_record_list_.add(c_Loc);
        }
      }
      //list_selected_record_list_.addAll(list_);
      add_to_all_selected_record_list_2(list_selected_record_list_);
      refresh_all_list_selected_record_list();
    }

    public void deselect_all(List<C_Loc> list_selected_record_list_) {
      List<C_Loc> list_ = new ArrayList();
      if (list_selected_record_list_ != null) {
        C_Loc c_Loc;
        for (int i = 0; i < list_selected_record_list_.size(); i++) {
          c_Loc = list_selected_record_list_.get(i);
          if (!is_c_loc_disabled(c_Loc)) {
            list_.add(c_Loc);
          }
        }
      }
      remove_from_all_selected_record_list_2(list_);
      list_selected_record_list_ = new ArrayList();
      refresh_all_list_selected_record_list();
    }

    public void add_to_all_selected_record_list(Session session_, C_Loc c_Loc) {
      if (!all_selected_record_list.contains(c_Loc)) {
        all_selected_record_list.add(c_Loc);
        List<C_Loc> child_list_ = c_Loc.getChild_list_2(session_);
        for (int i = 0; i < child_list_.size(); i++) {
          add_to_all_selected_record_list(session_, child_list_.get(i));
        }
      }
    }

    public void add_to_all_selected_record_list_2(List<C_Loc> c_loc_list_) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        add_to_all_selected_record_list_2(session_, c_loc_list_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }

    public void add_to_all_selected_record_list_2(Session session_, List<C_Loc> c_loc_list_) {
      C_Loc c_Loc;
      for (int i = 0; i < c_loc_list_.size(); i++) {
        c_Loc = c_loc_list_.get(i);
        add_to_all_selected_record_list(session_, c_Loc);
      }
    }

    public void remove_from_all_selected_record_list(Session session_, C_Loc c_Loc) {
      if (all_selected_record_list.contains(c_Loc)) {
        all_selected_record_list.remove(c_Loc);
        List<C_Loc> child_list_ = c_Loc.getChild_list_2(session_);
        for (int i = 0; i < child_list_.size(); i++) {
          remove_from_all_selected_record_list(session_, child_list_.get(i));
        }
      }
    }

    public void remove_from_all_selected_record_list_2(List<C_Loc> c_loc_list_) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        remove_from_all_selected_record_list_2(session_, c_loc_list_);
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
    }

    public void remove_from_all_selected_record_list_2(Session session_, List<C_Loc> c_loc_list_) {
      C_Loc c_Loc;
      for (int i = 0; i < c_loc_list_.size(); i++) {
        c_Loc = c_loc_list_.get(i);
        remove_from_all_selected_record_list(session_, c_Loc);
      }
    }

    public List<C_Loc> get_selected_record_list(List<C_Loc> c_loc_list_) {
      List<C_Loc> res = new ArrayList();
      C_Loc c_Loc;
      if (c_loc_list_ != null) {
        for (int i = 0; i < c_loc_list_.size(); i++) {
          c_Loc = c_loc_list_.get(i);
          if (all_selected_record_list.contains(c_Loc)) {
            res.add(c_Loc);
          }
        }
      }
      return res;
    }

    public void onChangeCheckbox(List<C_Loc> list_, List<C_Loc> selected_record_list_) {
      Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
      try {
        session_.beginTransaction();
        add_to_all_selected_record_list_2(session_, selected_record_list_);
        C_Loc c_Loc;
        for (int i = 0; i < list_.size(); i++) {
          c_Loc = list_.get(i);
          if (!selected_record_list_.contains(c_Loc)) {
            remove_from_all_selected_record_list(session_, c_Loc);
          }
        }
        /*
        if (!list_.isEmpty()) {
          if (list_.size() == selected_record_list_.size()) {
            if (list_.get(0).getParent_id() != null) {
              add_to_all_selected_record_list(session_, list_.get(0).getParent_id_t());
            }
          } else {
            if (list_.get(0).getParent_id() != null) {
              remove_from_all_selected_record_list(session_, list_.get(0).getParent_id_t());
            }
          }
        }
         */
        hibernate_funcs.commitAndClose(session_);
      } catch (Exception e) {
        CustomLogger.error(e);
        hibernate_funcs.rollbackAndClose(session_);
        throw e;
      }
      refresh_all_list_selected_record_list();
    }

    public void refresh_all_list_selected_record_list() {
      for (C_Choose_Multi_Loc_Rec c_Choose_Multi_Loc_Rec : c_choose_multi_loc_rec_list) {
        c_Choose_Multi_Loc_Rec.list_selected_record_list = get_selected_record_list(c_Choose_Multi_Loc_Rec.list);
      }
      refresh_has_selected_childs();
    }

    public Boolean is_c_loc_disabled(C_Loc c_Loc) {
      return disabled_c_loc_list.contains(c_Loc);
    }
  }

  public class C_Choose_Multi_Loc_Dlg_Filter_Bean extends Abstract_Filter_Bean<C_Loc> {

    public C_Choose_Multi_Loc_Dlg_Filter_Bean() {
      super(C_Loc.class, "name", "asc");
      getSort_field_name_list().add(new SelectItem("c_loc", bundle_funcs.getBundleValue("Identifikator")));
      getSort_field_name_list().add(new SelectItem("name", bundle_funcs.getBundleValue("Imya")));
    }

    public C_Loc getFilter_entity_wrapped() {
      return getFilter_entity();
    }
  }
}
