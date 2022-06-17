package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import org.hibernate.Session;
import gs.common.model.db.*;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Mob_Notif_App_Manager extends Abstract_Controller_Manager<C_Mob_Notif_App> {

  private static C_Mob_Notif_App_Manager currentInstance = null;

  public static C_Mob_Notif_App_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Mob_Notif_App_Manager();
    }
    return currentInstance;
  }

  public C_Mob_Notif_App_Manager() {
    super(C_Mob_Notif_App.class);
  }

  public C_Mob_Notif_App get_and_ins_if_not_exists(Session session_, String app_package_name_) {
    C_Mob_Notif_App res;
    res = my_get_last_rec(session_, app_package_name_);
    if (res == null) {
      res = new C_Mob_Notif_App();
      res.setApp_package_name(app_package_name_);
      res.setIs_deleted(false);
      res.setServer_key("");
      session_.save(res);      
    }
    return res;
  }

  public C_Mob_Notif_App my_get_last_rec(Session session_, String app_package_name_) {
    Query q_ = session_.createQuery("from C_Mob_Notif_App where app_package_name=:app_package_name_ order by 1 desc");
    q_.setString("app_package_name_", app_package_name_);
    q_.setMaxResults(1);
    List<C_Mob_Notif_App> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }   
}
