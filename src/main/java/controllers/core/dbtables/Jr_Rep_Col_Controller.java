package controllers.core.dbtables;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import managers.core.dbtables.Jr_Rep_Tpl_Col_Manager;
import model.core.dbtables.*;

@ManagedBean
@ViewScoped
public class Jr_Rep_Col_Controller extends Abstract_Controller<Jr_Rep_Col> {

  List<Jr_Rep_Tpl_Col> jr_rep_tpl_col_list;

  public Jr_Rep_Col_Controller() {
    super(Jr_Rep_Col.class, "jr_rep_col_list.xhtml", false);
  }

  public Jr_Rep_Col getJr_rep_col() {
    return getAbstract_entity();
  }

  public List<Jr_Rep_Tpl_Col> getJr_rep_tpl_col_list() {
    return jr_rep_tpl_col_list;
  }

  public void setJr_rep_tpl_col_list(List<Jr_Rep_Tpl_Col> jr_rep_tpl_col_list) {
    this.jr_rep_tpl_col_list = jr_rep_tpl_col_list;
  }

  public void refresh_jr_rep_tpl_col_list() {
    if (getJr_rep_col().getJr_rep() != null && getJr_rep_col().getJr_rep_t().getJr_rep_tpl() != null) {
      jr_rep_tpl_col_list = Jr_Rep_Tpl_Col_Manager.getCI().get_jr_rep_tpl_col_list(getJr_rep_col().getJr_rep_t().getJr_rep_tpl_t().getJr_rep_tpl());
    } else {
      jr_rep_tpl_col_list = null;
    }
  }

  @Override
  protected void afterLoadRec() {
    refresh_jr_rep_tpl_col_list();
  }

  
}
