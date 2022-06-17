package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;

@ManagedBean
@ViewScoped 
public class C_Usr_Controller extends Abstract_Controller<C_Usr> {

  public C_Usr_Controller() {
    super(C_Usr.class, "c_usr_list.xhtml", false);
  }
 
  public C_Usr getC_usr() {
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

  @Override
  protected void beforeInsertRec(Session session_) {
    getAbstract_entity().setIns_dt(new Date());
  }

}
