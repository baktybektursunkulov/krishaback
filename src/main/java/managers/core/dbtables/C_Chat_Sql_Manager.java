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
public class C_Chat_Sql_Manager extends Abstract_Controller_Manager<C_Chat_Sql> {

  private static C_Chat_Sql_Manager currentInstance = null;

  public static C_Chat_Sql_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Chat_Sql_Manager();
    }
    return currentInstance;
  }

  public C_Chat_Sql_Manager() {
    super(C_Chat_Sql.class);
  }

  public C_Chat_Sql get_row(Session session_, Integer c_tbl_id_) {
    Query q_ = session_.createQuery("from C_Chat_Sql t where t.is_deleted=false and t.c_tbl=:c_tbl_id_ order by 1 asc");
    q_.setMaxResults(1);
    q_.setInteger("c_tbl_id_", c_tbl_id_);
    List<C_Chat_Sql> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public String get_name(Session session_, Integer c_tbl_id_, Long rec_id_) {
    C_Chat_Sql c_Chat_Sql = get_row(session_, c_tbl_id_);
    Query q_ = session_.createSQLQuery(c_Chat_Sql.getName_sql());
    q_.setLong("rec_id_", rec_id_);
    List<String> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public Long get_img_id(Session session_, Integer c_tbl_id_, Long rec_id_) {
    C_Chat_Sql c_Chat_Sql = get_row(session_, c_tbl_id_);
    if (c_Chat_Sql.getImg_sql() == null || c_Chat_Sql.getImg_sql().trim().isEmpty()) {
      return null;
    }
    Query q_ = session_.createSQLQuery(c_Chat_Sql.getImg_sql());
    q_.setLong("rec_id_", rec_id_);
    List<Long> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

}
