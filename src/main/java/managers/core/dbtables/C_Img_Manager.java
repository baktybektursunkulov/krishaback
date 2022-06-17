package managers.core.dbtables;

import additional_classes.My_Uploaded_File;
import model.core.dbutil.CoreSessionFactoryUtil;
;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import org.hibernate.Query;

import org.hibernate.Session;
import gs.common.hibernate_funcs;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import gs.common.model.db.Abstract_Entity;
import model.core.dbtables.*;
import gs.common.model.db.SQL_Order_Condition;
import static managers.core.dbtables.Abstract_Controller_Manager.use_query_cache;
import others.CustomLogger;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import org.hibernate.Query;

import org.hibernate.Session;
import gs.common.hibernate_funcs;
import gs.common.image.image_funcs;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import gs.common.model.db.Abstract_Entity;
import model.core.dbtables.*;
import gs.common.model.db.SQL_Order_Condition;
import static managers.core.dbtables.Abstract_Controller_Manager.use_query_cache;
import org.primefaces.model.file.UploadedFile;
import others.CustomLogger;



@ManagedBean
@ApplicationScoped
public class C_Img_Manager extends Abstract_Controller_Manager<C_Img> {

  private static C_Img_Manager currentInstance = null;

  public static C_Img_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Img_Manager();
    }
    return currentInstance;
  }

  public C_Img_Manager() {
    super(C_Img.class);
  }

  public static C_Img get_img_by_file_name(String file_name_) {
    C_Img res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Img where is_deleted=false and file_name='" + file_name_ + "'");
      q_.setCacheable(use_query_cache);
      if (!q_.list().isEmpty()) {
        res = (C_Img) q_.list().get(0);
      }
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public C_Img get_empty_img() {
    Transaction tx = null;
    C_Img res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_empty_img(session_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public C_Img get_empty_img(Session session_) {
    C_Img res = null;
    Query q_ = session_.createQuery("from C_Img where c_img=-5");
    q_.setCacheable(use_query_cache);
    List<C_Img> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public Long get_empty_img_id(Session session_) {
    Long res = null;
    Query q_ = session_.createQuery("select c_img from C_Img where c_img=-5");
    q_.setCacheable(use_query_cache);
    List<Long> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public Integer get_img_version(Session session_, Long img_id_) {
    Query q_ = session_.createQuery("select version from C_Img where c_img=:img_id_");
    q_.setLong("img_id_", img_id_);
    q_.setCacheable(use_query_cache);
    List<Integer> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    } else {
      return null;
    }
  }

  public Integer get_img_version(Long img_id_) {
    Integer res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_img_version(session_, img_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public String get_img_file_name(Session session_, Long img_id_) {
    Query q_ = session_.createQuery("select file_name from C_Img where c_img=:img_id_");
    q_.setLong("img_id_", img_id_);
    q_.setCacheable(use_query_cache);
    List<String> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    } else {
      return null;
    }
  }

  public String get_img_file_name(Long img_id_) {
    String res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_img_file_name(session_, img_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public static boolean is_img_exists(Session session_, Long img_id_) {
    Query q_ = session_.createQuery("from C_Img where c_img=:img_id_");
    q_.setLong("img_id_", img_id_);
    q_.setCacheable(use_query_cache);
    List<C_Img> list_ = q_.list();
    return !list_.isEmpty();
  }

  public Long ins_row(Session session_, My_Uploaded_File my_Uploaded_File) throws Exception {
    C_Img img_ = new C_Img();

    C_Bin_File_Body bin_file_body_;
    bin_file_body_ = new C_Bin_File_Body();
    bin_file_body_.setFile_body(my_Uploaded_File.getContent());
    session_.save(bin_file_body_);

    img_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
    img_.setFile_name(my_Uploaded_File.getFileName());
    img_.setWidth(image_funcs.getImageWidth(bin_file_body_.getFile_body()));
    img_.setHeight(image_funcs.getImageHeight(bin_file_body_.getFile_body()));
    img_.setSize(my_Uploaded_File.getSize());
    img_.setContent_type(my_Uploaded_File.getContentType());
    img_.setVersion(1);
    img_.setIs_deleted(false);
    session_.save(img_);
    return img_.getC_img();
  }

  public String get_img_url_2(Session session_, Long img_id_, Integer img_max_width_, Integer img_max_height_) {
    if (img_id_ != null) {
      return "get_img_converted_by_max_w_and_h?img_id=" + img_id_ + "&img_type_code=png&img_max_width=" + img_max_width_ + "&img_max_height=" + img_max_height_ + "&v=" + C_Img_Manager.getCI().get_img_version(session_, img_id_);
    } else {
      return "";
    }
  }

  public String get_img_url(Long img_id_, Integer img_max_width_, Integer img_max_height_) {
    String res = "";
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_img_url_2(session_, img_id_, img_max_width_, img_max_height_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public String get_img_url_by_min_2(Session session_, Long img_id_, Integer img_min_width_, Integer img_min_height_) {
    if (img_id_ != null) {
      return "get_img_converted_by_min_w_and_h?img_id=" + img_id_ + "&img_type_code=png&img_min_width=" + img_min_width_ + "&img_min_height=" + img_min_height_ + "&v=" + C_Img_Manager.getCI().get_img_version(session_, img_id_);
    } else {
      return "";
    }
  }

  public String get_img_url_by_min(Long img_id_, Integer img_min_width_, Integer img_min_height_) {
    String res = "";
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_img_url_by_min_2(session_, img_id_, img_min_width_, img_min_height_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public String get_empty_img_url_2(Session session_, Integer img_max_width_, Integer img_max_height_) {
    Long img_id_ = get_empty_img_id(session_);
    return get_img_url_2(session_, img_id_, img_max_width_, img_max_height_);
  }

  public String get_empty_img_url(Integer img_max_width_, Integer img_max_height_) {
    String res = "";
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_empty_img_url_2(session_, img_max_width_, img_max_height_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public String get_empty_img_url_by_min_2(Session session_, Integer img_min_width_, Integer img_min_height_) {
    Long img_id_ = get_empty_img_id(session_);
    return get_img_url_by_min_2(session_, img_id_, img_min_width_, img_min_height_);
  }

  public String get_empty_img_url_by_min(Integer img_min_width_, Integer img_min_height_) {
    String res = "";
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_empty_img_url_by_min_2(session_, img_min_width_, img_min_height_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

  public String get_img_url_by_height_2(Session session_, Long img_id_, Integer img_height_) {
    if (img_id_ != null) {
      return "get_img_converted_by_height?img_id=" + img_id_ + "&img_type_code=png&img_height=" + img_height_ + "&v=" + C_Img_Manager.getCI().get_img_version(session_, img_id_);
    } else {
      return "";
    }
  }

  public String get_img_url_by_height(Long img_id_, Integer img_height_) {
    String res = "";
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_img_url_by_height_2(session_, img_id_, img_height_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

}
