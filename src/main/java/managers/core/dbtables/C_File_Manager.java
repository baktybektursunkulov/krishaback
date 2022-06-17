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
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_File_Manager extends Abstract_Controller_Manager<C_File> {

  private static C_File_Manager currentInstance = null;

  public static C_File_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_File_Manager();
    }
    return currentInstance;
  }

  public C_File_Manager() {
    super(C_File.class);
  }

  public static Boolean is_file_exists(Long c_file_id_) {
    Boolean res = false;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = is_file_exists(session_, c_file_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public static boolean is_file_exists(Session session_, Long c_file_id_) {
    Query q_ = session_.createQuery("select count(1) from C_File where c_file=:c_file_id_");
    q_.setLong("c_file_id_", c_file_id_);
    //q_.setCacheable(use_query_cache);
    List<Long> list_ = q_.list();
    return list_.get(0) > 0;
  }

  public String get_file_name(Session session_, Long c_file_id_) {
    Query q_ = session_.createQuery("select file_name from C_File where c_file=:c_file_id_");
    q_.setLong("c_file_id_", c_file_id_);
    q_.setCacheable(use_query_cache);
    List<String> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    } else {
      return null;
    }
  }

  public String get_file_name(Long file_id_) {
    String res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_file_name(session_, file_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

}
