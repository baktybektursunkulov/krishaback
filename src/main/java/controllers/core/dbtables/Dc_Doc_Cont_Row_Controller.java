package controllers.core.dbtables;

import filters.core.dbtables.Dc_Doc_Cont_Row_Filter_Bean;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lists.core.dbtables.Dc_Doc_Cont_Row_List_Bean;
import managers.core.dbtables.Dc_Doc_Cont_Row_Manager;
import org.hibernate.Session;import gs.common.hibernate_funcs;

@ManagedBean
@ViewScoped
public class Dc_Doc_Cont_Row_Controller extends Abstract_Controller<Dc_Doc_Cont_Row> {

  public Dc_Doc_Cont_Row_Controller() {
    super(Dc_Doc_Cont_Row.class, "dc_doc_cont_row_list.xhtml", false);
  }

  public Dc_Doc_Cont_Row getDc_doc_cont_row() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setDc_doc_cont(Dc_Doc_Cont_Row_List_Bean.getCurrentBean().getFilter_bean_wrapped().getFilter_entity_wrapped().getDc_doc_cont());
    getAbstract_entity().setIs_active(true);
  }

  @Override
  protected void afterLoadDefaultAndLoadRec() {
    getAbstract_entity().setLocate_after_row(null);
  }

  @Override
  protected void beforeInsertRec(Session session_) {
    getAbstract_entity().setOrder_num(Dc_Doc_Cont_Row_Manager.getCI().get_max_order_num(session_,
      getAbstract_entity().getDc_doc_cont_t().getDc_doc_cont(), getAbstract_entity().getParent_id() == null ? null : getAbstract_entity().getParent_id_t_2(session_).getDc_doc_cont_row()) + 1);
  }

  @Override
  protected void afterInsertAndUpdateRec(Session session_) {
    if (getAbstract_entity().getLocate_after_row() != null) {
      Dc_Doc_Cont_Row_Manager.getCI().inc_order_num(session_, getAbstract_entity().getLocate_after_row());
      getAbstract_entity().setOrder_num(getAbstract_entity().getLocate_after_row().getOrder_num());
      session_.merge(getAbstract_entity());
    }
  }

}
