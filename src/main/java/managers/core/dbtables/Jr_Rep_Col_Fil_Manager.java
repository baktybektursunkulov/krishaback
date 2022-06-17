package managers.core.dbtables;

import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class Jr_Rep_Col_Fil_Manager extends Abstract_Controller_Manager<Jr_Rep_Col_Fil> {

  private static Jr_Rep_Col_Fil_Manager currentInstance = null;

  public static Jr_Rep_Col_Fil_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Rep_Col_Fil_Manager();
    }
    return currentInstance;
  }

  public Jr_Rep_Col_Fil_Manager() {
    super(Jr_Rep_Col_Fil.class);
  }

  public List<Jr_Rep_Col_Fil> get_jr_rep_col_fil_list(Integer jr_rep_id_) {
    Transaction tx = null;
    List<Jr_Rep_Col_Fil> res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from Jr_Rep_Col_Fil where jr_rep.jr_rep=:jr_rep_id_ order by order_num asc");
    //q_.setCacheable(use_query_cache);
      q_.setInteger("jr_rep_id_", jr_rep_id_);
      res = q_.list();
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }  
}
