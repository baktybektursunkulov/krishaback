package lists.core.dbtables;

import filters.core.dbtables.*;
import gs.common.jsf.bundle_funcs;
import gs.common.model.db.SQL_Where_Condition;
import gs.common.jsf.jsf_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Lang_Manager;
import managers.core.dbtables.I_Tbl_Fld_Manager;
import managers.core.dbtables.I_Tbl_Fld_Trans_Manager;
import managers.core.dbtables.I_Tbl_Manager;
import model.core.dbtables.*;
import org.primefaces.model.LazyDataModel;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class I_Tbl_Fld_Trans_List_Bean extends Abstract_List_Bean<I_Tbl_Fld_Trans> {

  public I_Tbl_Fld_Trans_List_Bean() {
    super("I_Tbl_Fld_Trans", (I_Tbl_Fld_Trans_Filter_Bean) jsf_funcs.findBean("i_Tbl_Fld_Trans_Filter_Bean"));
  }

  public LazyDataModel<I_Tbl_Fld_Trans> getConverted_rec_list() {
    return getRec_list();
  }

  public I_Tbl_Fld_Trans_Filter_Bean getFilter_bean_wrapped() {
    return (I_Tbl_Fld_Trans_Filter_Bean) getFilter_bean();
  }

  @Override
  protected void add_sql_where_conditions(ArrayList<SQL_Where_Condition> sql_where_condition_arr_) {
    if (getFilter_bean_wrapped().getFilter_entity().getI_tbl() != null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("i_tbl.i_tbl", "=", getFilter_bean_wrapped().getFilter_entity().getI_tbl().toString()));
    }
    if (getFilter_bean_wrapped().getFilter_entity().getI_tbl_fld() != null) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("i_tbl_fld.i_tbl_fld", "=", getFilter_bean_wrapped().getFilter_entity().getI_tbl_fld().toString()));
    }
    if (getFilter_bean_wrapped().getFilter_entity().getTranslation()!= null && !getFilter_bean_wrapped().getFilter_entity().getTranslation().trim().isEmpty()) {
      sql_where_condition_arr_.add(new SQL_Where_Condition("lower(translation)", "like ", "'%" + getFilter_bean_wrapped().getFilter_entity().getTranslation().toLowerCase() + "%'"));
    }
  }

  public void show_not_translated_rows() {
    CustomLogger.log("show_not_translated_rows()");
    try {
      String message_ = "";
      List<I_Tbl> i_tbl_list_ = I_Tbl_Manager.getCI().get_i_tbl_list();
      List<C_Lang> c_lang_list_ = C_Lang_Manager.getCI().get_c_lang_list();
      List<Long> rec_id_list_;
      List<I_Tbl_Fld> i_tbl_fld_list_;
      I_Tbl_Fld_Trans i_tbl_fld_trans_;
      for (int i = 0; i < i_tbl_list_.size(); i++) {
        i_tbl_fld_list_ = I_Tbl_Fld_Manager.getCI().get_i_tbl_fld_list(i_tbl_list_.get(i).getI_tbl());
        for (int j = 0; j < i_tbl_fld_list_.size(); j++) {
          for (int k = 0; k < c_lang_list_.size(); k++) {
            rec_id_list_ = I_Tbl_Fld_Trans_Manager.getCI().get_available_rec_id_list(i_tbl_list_.get(i), i_tbl_fld_list_.get(j), c_lang_list_.get(k));
            for (int z = 0; z < rec_id_list_.size(); z++) {
              i_tbl_fld_trans_ = I_Tbl_Fld_Trans_Manager.getCI().get_tbl_fld_translation_rec(i_tbl_list_.get(i).getI_tbl(), rec_id_list_.get(z), i_tbl_fld_list_.get(j).getI_tbl_fld(), c_lang_list_.get(k).getCode());
              if (i_tbl_fld_trans_ == null || i_tbl_fld_trans_.getTranslation().isEmpty()) {
                message_ = message_ + "table_name=" + i_tbl_list_.get(i).getName() + ", table_field_name=" + i_tbl_fld_list_.get(j).getName() + ", lang=" + c_lang_list_.get(k).getCode() + ", rec_id=" + rec_id_list_.get(z) + "<br/>";
              }
            }
          }
        }
      }
      CustomLogger.log("message_=" + message_);
      //primefaces_funcs.executeJS("alert('" + message_ + "');");
      primefaces_funcs.showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, bundle_funcs.getBundleValue("Soobshhenie"), message_));
    } catch (Exception e) {
      CustomLogger.error(e);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(gs.common.other_funcs.stack2string(e)));
    }
  }
}
