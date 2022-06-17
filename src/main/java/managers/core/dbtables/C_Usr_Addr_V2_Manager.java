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
public class C_Usr_Addr_V2_Manager extends Abstract_Controller_Manager<C_Usr_Addr_V2> {

  private static C_Usr_Addr_V2_Manager currentInstance = null;

  public static C_Usr_Addr_V2_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Addr_V2_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Addr_V2_Manager() {
    super(C_Usr_Addr_V2.class);
  }

  public List<C_Usr_Addr_V2> get_row_list(Session session_, Long c_usr_id_, Integer c_addr_type_id_) {
    Query q_= session_.createQuery("from C_Usr_Addr_V2 t where t.is_deleted=false and t.c_usr=:c_usr_id_ and t.c_addr_type=:c_addr_type_id_ ");
    q_.setLong("c_usr_id_", c_usr_id_);
    q_.setInteger("c_addr_type_id_", c_addr_type_id_);
    return q_.list();    
  }
  
  public void set_is_default(Session session_, Long c_usr_id_, Integer c_addr_type_id_, Integer c_usr_addr_v2_id_) {
    Query q_ = session_.createQuery("update C_Usr_Addr_V2 set is_default=true where is_deleted=false and c_usr=:c_usr_id_ and c_addr_type=:c_addr_type_id_ and c_usr_addr_v2=:c_usr_addr_v2_id_ ");
    q_.setLong("c_usr_id_", c_usr_id_);
    q_.setInteger("c_addr_type_id_", c_addr_type_id_);
    q_.setInteger("c_usr_addr_v2_id_", c_usr_addr_v2_id_);
    q_.executeUpdate();
    
    q_ = session_.createQuery("update C_Usr_Addr_V2 set is_default=false where is_deleted=false and c_usr=:c_usr_id_ and c_addr_type=:c_addr_type_id_ and c_usr_addr_v2<>:c_usr_addr_v2_id_ ");
    q_.setLong("c_usr_id_", c_usr_id_);
    q_.setInteger("c_addr_type_id_", c_addr_type_id_);
    q_.setInteger("c_usr_addr_v2_id_", c_usr_addr_v2_id_);
    q_.executeUpdate();
  }
  
  public C_Usr_Addr_V2 get_default_row(Session session_, Long c_usr_id_, Integer c_addr_type_id_) {
    Query q_= session_.createQuery("from C_Usr_Addr_V2 t where t.is_deleted=false and t.c_usr=:c_usr_id_ and t.c_addr_type=:c_addr_type_id_ and t.is_default=true order by 1 asc");
    q_.setLong("c_usr_id_", c_usr_id_);
    q_.setInteger("c_addr_type_id_", c_addr_type_id_);
    q_.setMaxResults(1);
    List<C_Usr_Addr_V2> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }
  
  public C_Usr_Addr_V2 get_last_row(Session session_, Long c_usr_id_, Integer c_addr_type_id_) {
    Query q_= session_.createQuery("from C_Usr_Addr_V2 t where t.is_deleted=false and t.c_usr=:c_usr_id_ and t.c_addr_type=:c_addr_type_id_ order by 1 desc");
    q_.setLong("c_usr_id_", c_usr_id_);
    q_.setInteger("c_addr_type_id_", c_addr_type_id_);
    q_.setMaxResults(1);
    List<C_Usr_Addr_V2> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }
  
}
