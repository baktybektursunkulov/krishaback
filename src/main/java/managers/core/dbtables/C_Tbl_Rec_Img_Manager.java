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
public class C_Tbl_Rec_Img_Manager extends Abstract_Controller_Manager<C_Tbl_Rec_Img> {

  private static C_Tbl_Rec_Img_Manager currentInstance = null;

  public static C_Tbl_Rec_Img_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Rec_Img_Manager();
    }
    return currentInstance;
  }

  public C_Tbl_Rec_Img_Manager() {
    super(C_Tbl_Rec_Img.class);
  }

  public List<C_Tbl_Rec_Img> get_row_list(Session session_, Integer c_tbl_id_, Long rec_id_) {
    Query q_ = session_.createQuery("from C_Tbl_Rec_Img t where t.is_deleted=false and t.c_tbl=:c_tbl_id_ and t.rec_id=:rec_id_ order by 1 asc ");
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    q_.setLong("rec_id_", rec_id_);
    return q_.list();
  }

}
