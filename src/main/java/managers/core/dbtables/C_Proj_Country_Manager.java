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
public class C_Proj_Country_Manager extends Abstract_Controller_Manager<C_Proj_Country> {

  private static C_Proj_Country_Manager currentInstance = null;

  public static C_Proj_Country_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Proj_Country_Manager();
    }
    return currentInstance;
  }

  public C_Proj_Country_Manager() {
    super(C_Proj_Country.class);
  }

  
  public List<C_Country> get_proj_country_list(Session session_, Integer c_proj_id_) {
    Query q_ = session_.createQuery("select c from C_Proj_Country t, C_Country c where t.is_deleted=false and t.c_country = c.c_country and t.c_proj=:c_proj_id_ and c.is_deleted=false order by c.code");
    q_.setInteger("c_proj_id_", c_proj_id_);
    List<C_Country> list_ = q_.list();
    return list_;
  }

  public C_Country get_c_country(Session session_, Integer c_proj_id_, String country_code_) {
    Query q_ = session_.createQuery("select c from C_Proj_Country t, C_Country c where t.is_deleted=false and t.c_country = c.c_country and t.c_proj=:c_proj_id_ and c.is_deleted=false and lower(trim(c.code))=:country_code_ order by 1 asc");
    q_.setInteger("c_proj_id_", c_proj_id_);
    q_.setString("country_code_", country_code_.trim().toLowerCase());
    q_.setMaxResults(1);
    List<C_Country> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }
  
  public C_Proj_Country get_row(Session session_, Integer c_proj_id_, Integer c_country_id_) {
    Query q_ = session_.createQuery("select t from C_Proj_Country t where t.is_deleted=false and t.c_proj=:c_proj_id_ and t.c_country=:c_country_id_ order by 1 asc");
    q_.setInteger("c_proj_id_", c_proj_id_);
    q_.setInteger("c_country_id_", c_country_id_);
    q_.setMaxResults(1);
    List<C_Proj_Country> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }
  
}
