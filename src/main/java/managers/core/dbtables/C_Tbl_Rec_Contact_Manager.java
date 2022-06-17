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
public class C_Tbl_Rec_Contact_Manager extends Abstract_Controller_Manager<C_Tbl_Rec_Contact> {

  private static C_Tbl_Rec_Contact_Manager currentInstance = null;

  public static C_Tbl_Rec_Contact_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Rec_Contact_Manager();
    }
    return currentInstance;
  }

  public C_Tbl_Rec_Contact_Manager() {
    super(C_Tbl_Rec_Contact.class);
  }

  public List<C_Tbl_Rec_Contact> get_row_list_for_select(Session session_, Integer ec_store_id_) {
    Query q_ = session_.createQuery("from C_Tbl_Rec_Contact t where t.is_deleted=false and t.c_tbl=:c_tbl_id_ and t.rec_id=:ec_store_id_ order by 1 asc");
    q_.setInteger("c_tbl_id_", C_Tbl_Manager.getCI().getC_tbl_id__ec_store());
    q_.setLong("ec_store_id_", ec_store_id_.longValue());
    List<C_Tbl_Rec_Contact> list_ = q_.list();
    return list_;    
  }
  
  public List<C_Tbl_Rec_Contact> get_row_list_for_select(Integer ec_store_id_) {
    List<C_Tbl_Rec_Contact> res = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row_list_for_select(session_, ec_store_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }
  
}
