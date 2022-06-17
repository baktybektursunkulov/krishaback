package controllers.core.dbtables;

import beans.CUsrBean;
import beans.CUsrLoginBean;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Jr_Query_Controller extends Abstract_Controller<Jr_Query> {

  public Jr_Query_Controller() {
    super(Jr_Query.class, "jr_query_list.xhtml", false);
  }

  public Jr_Query getJr_query() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setC_usr_t(CUsrBean.getCurrentBean().getLoggedCUsr());
  }

  
}
