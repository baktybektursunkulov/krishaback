package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.Date;
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
public class C_Mob_Notif_Reg_Token_Manager extends Abstract_Controller_Manager<C_Mob_Notif_Reg_Token> {

  private static C_Mob_Notif_Reg_Token_Manager currentInstance = null;

  public static C_Mob_Notif_Reg_Token_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Mob_Notif_Reg_Token_Manager();
    }
    return currentInstance;
  }

  public C_Mob_Notif_Reg_Token_Manager() {
    super(C_Mob_Notif_Reg_Token.class);
  }

  public void my_ins_rec(Session session_, String uuid_, String reg_token_, String platform_, String user_name_, String sound_, Boolean is_show_notifications_, Boolean is_active_,
    String app_package_name_, C_Usr logged_c_usr_) {
    C_Mob_Notif_Reg_Token old_rec_ = my_get_last_rec(session_, uuid_);
    if (old_rec_ == null) {
      C_Mob_Notif_Reg_Token new_rec_ = new C_Mob_Notif_Reg_Token();
      new_rec_.setUuid(uuid_);
      new_rec_.setReg_token(reg_token_);
      new_rec_.setPlatform(platform_);
      new_rec_.setUser_name(user_name_);
      new_rec_.setReg_dt(new Date());
      new_rec_.setSound(sound_);
      new_rec_.setIs_show_notifications(is_show_notifications_);
      new_rec_.setIs_active(is_active_);
      new_rec_.setIs_reg_token_valid(true);
      new_rec_.setC_mob_notif_app_t(C_Mob_Notif_App_Manager.getCI().get_and_ins_if_not_exists(session_, app_package_name_));
      C_Mob_Notif_Reg_Token_Manager.getCI().insert_rec(session_, new_rec_);
      C_Tbl_Oper_Manager.insert_object_his(session_, "c_mob_notif_reg_token", new_rec_.getC_mob_notif_reg_token(), "insert", new_rec_.toString(), logged_c_usr_);
    } else {
      old_rec_.setReg_token(reg_token_);
      old_rec_.setPlatform(platform_);
      old_rec_.setUser_name(user_name_);
      old_rec_.setSound(sound_);
      old_rec_.setIs_show_notifications(is_show_notifications_);
      old_rec_.setIs_active(is_active_);
      old_rec_.setC_mob_notif_app_t(C_Mob_Notif_App_Manager.getCI().get_and_ins_if_not_exists(session_, app_package_name_));
      C_Mob_Notif_Reg_Token_Manager.getCI().merge_rec(session_, old_rec_);
      C_Tbl_Oper_Manager.insert_object_his(session_, "c_mob_notif_reg_token", old_rec_.getC_mob_notif_reg_token(), "update", old_rec_.toString(), logged_c_usr_);
    }
  }

  public C_Mob_Notif_Reg_Token my_get_last_rec(Session session_, String uuid_) {
    Query q_ = session_.createQuery("from C_Mob_Notif_Reg_Token where uuid=:uuid_ order by 1 desc");
    q_.setString("uuid_", uuid_);
    q_.setMaxResults(1);
    List<C_Mob_Notif_Reg_Token> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public List<C_Mob_Notif_Reg_Token> my_get_rec_list_by_user_name(Session session_, String user_name_) {
    Query q_ = session_.createQuery("from C_Mob_Notif_Reg_Token where user_name=:user_name_ order by 1 desc");
    q_.setString("user_name_", user_name_);
    List<C_Mob_Notif_Reg_Token> list_ = q_.list();
    return list_;
  }  
}
