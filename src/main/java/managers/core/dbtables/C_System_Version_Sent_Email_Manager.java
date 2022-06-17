package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Where_Condition;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class C_System_Version_Sent_Email_Manager extends Abstract_Controller_Manager<C_System_Version_Sent_Email> {

  private static C_System_Version_Sent_Email_Manager currentInstance = null;

  public static C_System_Version_Sent_Email_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_System_Version_Sent_Email_Manager();
    }
    return currentInstance;
  }

  public C_System_Version_Sent_Email_Manager() {
    super(C_System_Version_Sent_Email.class);
  }

  public boolean is_exists(Session session_, Integer system_version_id_, String reveiver_email_) {
    List<SQL_Where_Condition> sql_where_condition_list_ = new ArrayList();
    sql_where_condition_list_.add(new SQL_Where_Condition("is_deleted=false"));
    sql_where_condition_list_.add(new SQL_Where_Condition("c_system_version=" + system_version_id_));
    sql_where_condition_list_.add(new SQL_Where_Condition("lower(trim(reveiver_email))='" + reveiver_email_.trim().toLowerCase() + "'"));
    List<C_System_Version_Sent_Email> list_ = get_rec_list_10_1_c(session_, sql_where_condition_list_, true);
    return !list_.isEmpty();
  }   
}
