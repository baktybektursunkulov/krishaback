package controllers.core.dbtables;

import filters.core.dbtables.Jr_Rep_Tpl_Col_Filter_Bean;
import java.util.List;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import managers.core.dbtables.Jr_Rep_Col_Fil_Type_Op_Manager;
import managers.core.dbtables.Jr_Rep_Tpl_Col_Manager;

@ManagedBean
@ViewScoped
public class Jr_Rep_Col_Fil_Controller extends Abstract_Controller<Jr_Rep_Col_Fil> {

  List<Jr_Rep_Tpl_Col> jr_rep_tpl_col_list;
  List<Jr_Rep_Col_Fil_Type_Op> jr_rep_col_fil_type_op_list;
  
  public Jr_Rep_Col_Fil_Controller() {
    super(Jr_Rep_Col_Fil.class, "jr_rep_col_fil_list.xhtml", false);
  }

  public Jr_Rep_Col_Fil getJr_rep_col_fil() {
    return getAbstract_entity();
  }

  public List<Jr_Rep_Tpl_Col> getJr_rep_tpl_col_list() {
    return jr_rep_tpl_col_list;
  }

  public void setJr_rep_tpl_col_list(List<Jr_Rep_Tpl_Col> jr_rep_tpl_col_list) {
    this.jr_rep_tpl_col_list = jr_rep_tpl_col_list;
  }

  public List<Jr_Rep_Col_Fil_Type_Op> getJr_rep_col_fil_type_op_list() {
    return jr_rep_col_fil_type_op_list;
  }

  public void setJr_rep_col_fil_type_op_list(List<Jr_Rep_Col_Fil_Type_Op> jr_rep_col_fil_type_op_list) {
    this.jr_rep_col_fil_type_op_list = jr_rep_col_fil_type_op_list;
  }

  
  
  public void refresh_jr_rep_tpl_col_list() {
    if (getJr_rep_col_fil().getJr_rep() != null && getJr_rep_col_fil().getJr_rep_t().getJr_rep_tpl() != null) {
      jr_rep_tpl_col_list = Jr_Rep_Tpl_Col_Manager.getCI().get_jr_rep_tpl_col_list(getJr_rep_col_fil().getJr_rep_t().getJr_rep_tpl_t().getJr_rep_tpl());
    } else {
      jr_rep_tpl_col_list = null;
    }
  }

  public void refresh_jr_rep_col_fil_type_op_list() {
    if (getJr_rep_col_fil().getJr_rep_col_fil_type() != null && getJr_rep_col_fil().getJr_rep_col_fil_type_t().getJr_rep_col_fil_type() != null) {
      jr_rep_col_fil_type_op_list = Jr_Rep_Col_Fil_Type_Op_Manager.getCI().get_jr_rep_col_fil_type_op_list(getJr_rep_col_fil().getJr_rep_col_fil_type_t().getJr_rep_col_fil_type());
    } else {
      jr_rep_col_fil_type_op_list = null;
    }
  }
  
  @Override
  protected void afterLoadRec() {
    refresh_jr_rep_tpl_col_list();
    refresh_jr_rep_col_fil_type_op_list();
  }
  
}
