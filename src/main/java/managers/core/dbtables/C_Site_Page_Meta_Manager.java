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
public class C_Site_Page_Meta_Manager extends Abstract_Controller_Manager<C_Site_Page_Meta> {

  private static C_Site_Page_Meta_Manager currentInstance = null;

  public static C_Site_Page_Meta_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Site_Page_Meta_Manager();
    }
    return currentInstance;
  }

  public C_Site_Page_Meta_Manager() {
    super(C_Site_Page_Meta.class);
  }

  public C_Site_Page_Meta get_c_site_page_meta_wo_creation(Session session_, Integer c_site_id_, Integer c_site_page_id_, Integer c_site_meta_id_) {
    Query q_ = session_.createQuery("from C_Site_Page_Meta where is_deleted=false and c_site=:c_site_id_ and c_site_page=:c_site_page_id_ and c_site_meta=:c_site_meta_id_");
    q_.setInteger("c_site_id_", c_site_id_);
    q_.setInteger("c_site_page_id_", c_site_page_id_);
    q_.setInteger("c_site_meta_id_", c_site_meta_id_);
  //q_.setCacheable(use_query_cache);
    List<C_Site_Page_Meta> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }
  
  public C_Site_Page_Meta get_c_site_page_meta_with_creation(Session session_, Integer c_site_id_, Integer c_site_page_id_, Integer c_site_meta_id_) {
    C_Site_Page_Meta res = null;

    res = get_c_site_page_meta_wo_creation(session_, c_site_id_, c_site_page_id_, c_site_meta_id_);
    if (res == null) {
      res = new C_Site_Page_Meta();
      res.setC_site(c_site_id_);
      res.setC_site_page(c_site_page_id_);
      res.setC_site_meta(c_site_meta_id_);
      res.setIs_deleted(false);
      C_Site_Page_Meta_Manager.getCI().insert_rec(session_, res);
    }

    return res;
  }  
}
