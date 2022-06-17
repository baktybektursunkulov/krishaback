package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Order_Condition;
import gs.common.model.db.SQL_Where_Condition;
import java.util.List;
import org.hibernate.Session;

@ManagedBean
@ApplicationScoped
public class C_Email_Out_File_Manager extends Abstract_Controller_Manager<C_Email_Out_File> {

  private static C_Email_Out_File_Manager currentInstance = null;

  public static C_Email_Out_File_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Email_Out_File_Manager();
    }
    return currentInstance;
  }

  public C_Email_Out_File_Manager() {
    super(C_Email_Out_File.class);
  }

  public List<C_Email_Out_File> get_rec_list(Session session_, Integer c_email_out_id_) {
    return get_rec_list_5_1_c(session_, new SQL_Where_Condition("is_deleted=false and c_email_out=" + c_email_out_id_), new SQL_Order_Condition("c_email_out_file", "asc"), false);
  }   
}
