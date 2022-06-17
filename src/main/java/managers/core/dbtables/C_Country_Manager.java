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
public class C_Country_Manager extends Abstract_Controller_Manager<C_Country> {

  private static C_Country_Manager currentInstance = null;
  private C_Country not_known_c_country;  
  private String code__not_known = "not_known";

  public static C_Country_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Country_Manager();
    }
    return currentInstance;
  }

  public C_Country_Manager() {
    super(C_Country.class);
  }

  public C_Country getNot_known_c_country() {
    if (not_known_c_country == null) {
      not_known_c_country = C_Country_Manager.getCI().get_rec_by_code(code__not_known);
    }
    return not_known_c_country;
  }

  public C_Country getNot_known_c_country_2(Session session_) {
    if (not_known_c_country == null) {
      not_known_c_country = C_Country_Manager.getCI().get_rec_by_code(session_, code__not_known);
    }
    return not_known_c_country;
  }

  public void setNot_known_c_country(C_Country not_known_c_country) {
    this.not_known_c_country = not_known_c_country;
  }
  
  

  public C_Country get_unique_rec_by_code(Session session_, String code_, Integer exclude_id_) {
    Query q_ = session_.createQuery("from C_Country where "
      + " lower(trim(code))=:code_ "
      + (exclude_id_ == null ? "" : "and c_country<>:exclude_id_") + " and is_deleted=false ");
    q_.setString("code_", code_.trim().toLowerCase());
    if (exclude_id_ != null) {
      q_.setInteger("exclude_id_", exclude_id_);
    }
    List<C_Country> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }
  
  public C_Country get_unique_rec_by_name(Session session_, String name_, Integer exclude_id_) {
    Query q_ = session_.createQuery("from C_Country where "
      + " lower(trim(name))=:name_ "
      + (exclude_id_ == null ? "" : "and c_country<>:exclude_id_") + " and is_deleted=false ");
    q_.setString("name_", name_.trim().toLowerCase());
    if (exclude_id_ != null) {
      q_.setInteger("exclude_id_", exclude_id_);
    }
    List<C_Country> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    }
    return null;
  }

}
