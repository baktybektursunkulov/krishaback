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
public class C_Broker_Sender_Manager extends Abstract_Controller_Manager<C_Broker_Sender> {

  private static C_Broker_Sender_Manager currentInstance = null;

  public static C_Broker_Sender_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Broker_Sender_Manager();
    }
    return currentInstance;
  }

  public C_Broker_Sender_Manager() {
    super(C_Broker_Sender.class);
  }

  public C_Broker_Sender get_row_by_client_id(Session session_, String client_id_) {
    C_Broker_Sender res = null;
    Query q_ = session_.createQuery("from C_Broker_Sender t where t.is_deleted=false and client_id=:client_id_ order by 1 asc");
    q_.setString("client_id_", client_id_);
    List<C_Broker_Sender> list_ = q_.list();
    if (!list_.isEmpty()) {
      res = list_.get(0);
    } else {
      res = new C_Broker_Sender();
      res.setClient_id(client_id_);
      res.setIs_deleted(false);
      session_.save(res);
    }
    return res;
  }
}
