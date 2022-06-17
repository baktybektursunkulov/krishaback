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
public class C_Usr_Review_Img_Manager extends Abstract_Controller_Manager<C_Usr_Review_Img> {

  private static C_Usr_Review_Img_Manager currentInstance = null;

  public static C_Usr_Review_Img_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Usr_Review_Img_Manager();
    }
    return currentInstance;
  }

  public C_Usr_Review_Img_Manager() {
    super(C_Usr_Review_Img.class);
  }

  public List<C_Usr_Review_Img> get_row_list(Session session_, Integer c_usr_review_id_) {
    Query q_ = session_.createQuery("from C_Usr_Review_Img t where t.is_deleted=false and t.c_usr_review=:c_usr_review_id_ order by 1 asc ");
    q_.setInteger("c_usr_review_id_", c_usr_review_id_);
    return q_.list();
  }

  public String get_img_url_for_filmstrip(Session session_, Integer c_usr_review_img_id_) {
    C_Usr_Review_Img rec_ = C_Usr_Review_Img_Manager.getCI().get_rec(session_, c_usr_review_img_id_);
    if (rec_ != null) {
      return "get_img_converted_by_max_w_and_h?img_id=" + rec_.getC_img() + "&img_type_code=png&img_max_width=50&img_max_height=50&v=" + C_Img_Manager.getCI().get_img_version(session_, rec_.getC_img());
    } else {
      return "";
    }
  }

  public String get_img_url_for_filmstrip(Integer c_usr_review_img_id_) {
    String res = "";
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_img_url_for_filmstrip(session_, c_usr_review_img_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public String get_img_url(Session session_, Integer c_usr_review_img_id_, Integer img_max_width_, Integer img_max_height_) {
    C_Usr_Review_Img rec_ = C_Usr_Review_Img_Manager.getCI().get_rec(session_, c_usr_review_img_id_);
    if (rec_ != null) {
      return "get_img_converted_by_max_w_and_h?img_id=" + rec_.getC_img() + "&img_type_code=png&img_max_width=" + img_max_width_ + "&img_max_height=" + img_max_height_ + "&v=" + C_Img_Manager.getCI().get_img_version(session_, rec_.getC_img());
    } else {
      return "";
    }
  }

  public String get_img_url(Integer c_usr_review_img_id_, Integer img_max_width_, Integer img_max_height_) {
    String res = "";
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_img_url(session_, c_usr_review_img_id_, img_max_width_, img_max_height_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

}
