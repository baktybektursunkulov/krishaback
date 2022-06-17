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
import model.core.dbutil.CoreSessionFactoryUtil;

@ManagedBean
@ApplicationScoped
public class C_Site_Img_Manager extends Abstract_Controller_Manager<C_Site_Img> {
  
  private static C_Site_Img_Manager currentInstance = null;
  
  public static C_Site_Img_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Site_Img_Manager();
    }
    return currentInstance;
  }
  
  public C_Site_Img_Manager() {
    super(C_Site_Img.class);
  }
  
  public C_Site_Img get_c_site_img(Session session_, Integer c_site_id_, Integer c_site_img_type_id_) {
    Query q_ = session_.createQuery("select t from C_Site_Img t where t.c_site=:c_site_id_ and t.c_site_img_type=:c_site_img_type_id_ and t.is_deleted=false");
    q_.setInteger("c_site_id_", c_site_id_);
    q_.setInteger("c_site_img_type_id_", c_site_img_type_id_);
    List<C_Site_Img> list_ = q_.list();
    if (list_.size() > 0) {
      return list_.get(0);
    }
    return null;
  }
  
  public C_Site_Img get_c_site_img(Integer c_site_id_, Integer c_site_img_type_id_) {
    C_Site_Img res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.getTransaction().begin();
      res = get_c_site_img(session_, c_site_id_, c_site_img_type_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }  
  
}
