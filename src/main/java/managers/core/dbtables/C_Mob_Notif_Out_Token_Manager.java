package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class C_Mob_Notif_Out_Token_Manager extends Abstract_Controller_Manager<C_Mob_Notif_Out_Token> {

  private static C_Mob_Notif_Out_Token_Manager currentInstance = null;

  public static C_Mob_Notif_Out_Token_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Mob_Notif_Out_Token_Manager();
    }
    return currentInstance;
  }

  public C_Mob_Notif_Out_Token_Manager() {
    super(C_Mob_Notif_Out_Token.class);
  }

  public C_Mob_Notif_Out_Token my_get_last_rec(Session core_session_, Integer c_mob_notif_out_id_, String reg_token_) {
    Query q_ = core_session_.createQuery("from C_Mob_Notif_Out_Token where c_mob_notif_out=:c_mob_notif_out_id_ and reg_token=:reg_token_ order by 1 desc");
    q_.setInteger("c_mob_notif_out_id_", c_mob_notif_out_id_);
    q_.setString("reg_token_", reg_token_);
    q_.setMaxResults(1);
    List<C_Mob_Notif_Out_Token> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public boolean my_is_exists_rec(Session core_session_, Integer c_mob_notif_out_id_, String reg_token_) {
    return (my_get_last_rec(core_session_, c_mob_notif_out_id_, reg_token_) != null);
  }   
}
