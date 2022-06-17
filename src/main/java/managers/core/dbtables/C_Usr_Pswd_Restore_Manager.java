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
import model.core.dbutil.CoreSessionFactoryUtil;

@ManagedBean
@ApplicationScoped
public class C_Usr_Pswd_Restore_Manager extends Abstract_Controller_Manager<C_Usr_Pswd_Restore> {

  private static C_Usr_Pswd_Restore_Manager currentInstance = null;

  public static C_Usr_Pswd_Restore_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Pswd_Restore_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Pswd_Restore_Manager() {
    super(C_Usr_Pswd_Restore.class);
  }

  public C_Usr_Pswd_Restore get_row(Integer c_proj_id_, Integer c_usr_type_id_, String usr_name_, String code_) {
    C_Usr_Pswd_Restore res;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_row(session_, c_proj_id_, c_usr_type_id_, usr_name_, code_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public C_Usr_Pswd_Restore get_row(Session session_, Integer c_proj_id_, Integer c_usr_type_id_, String usr_name_, String code_) {
    Query q_ = session_.createQuery("from C_Usr_Pswd_Restore t where t.is_deleted=false and t.is_used=false and t.c_proj=:c_proj_id_ and t.c_usr_type=:c_usr_type_id_ and t.usr_name=:usr_name_ and t.code=:code_ ");
    q_.setInteger("c_proj_id_", c_proj_id_);
    q_.setInteger("c_usr_type_id_", c_usr_type_id_);
    q_.setString("usr_name_", usr_name_);
    q_.setString("code_", code_);
    List<C_Usr_Pswd_Restore> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

}
