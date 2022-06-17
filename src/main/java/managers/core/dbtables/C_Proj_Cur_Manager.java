package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Proj_Cur_Manager extends Abstract_Controller_Manager<C_Proj_Cur> {

  private static C_Proj_Cur_Manager currentInstance = null;

  public static C_Proj_Cur_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Proj_Cur_Manager();
    }
    return currentInstance;
  }

  public C_Proj_Cur_Manager() {
    super(C_Proj_Cur.class);
  }

  public List<C_Cur> get_proj_cur_list(Session session_, Integer c_proj_id_) {
    Query q_ = session_.createQuery("select c from C_Proj_Cur t, C_Cur c where t.is_deleted=false and t.c_cur = c.c_cur and t.c_proj=:c_proj_id_ and c.is_deleted=false order by c.code");
    q_.setInteger("c_proj_id_", c_proj_id_);
    List<C_Cur> list_ = q_.list();
    return list_;
  }
  
}
