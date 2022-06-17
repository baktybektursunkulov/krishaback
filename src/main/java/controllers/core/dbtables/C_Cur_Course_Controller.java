package controllers.core.dbtables;

import java.util.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;

@ManagedBean
@ViewScoped
public class C_Cur_Course_Controller extends Abstract_Controller<C_Cur_Course> {

  public C_Cur_Course_Controller() {
    super(C_Cur_Course.class, "c_cur_course_list.xhtml", false);
  }

  public C_Cur_Course getC_cur_course() {
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
