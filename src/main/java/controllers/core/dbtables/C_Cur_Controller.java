package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;

@ManagedBean
@ViewScoped
public class C_Cur_Controller extends Abstract_Controller<C_Cur> {

  public C_Cur_Controller() {
    super(C_Cur.class, "c_cur_list.xhtml", false);
  }

  public C_Cur getC_cur() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setIs_deleted(false);
  }

  @Override
  protected void deleteRec(Session session_) {
    getAbstract_entity().setIs_deleted(true);
    session_.merge(getAbstract_entity());
  }

}
