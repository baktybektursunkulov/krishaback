package managers.core.dbtables;

import gs.common.hibernate_funcs;
import gs.common.image.image_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class C_Img_Converted_Manager extends Abstract_Controller_Manager<C_Img_Converted> {

  private static C_Img_Converted_Manager currentInstance = null;

  public static C_Img_Converted_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Img_Converted_Manager();
    }
    return currentInstance;
  }

  public C_Img_Converted_Manager() {
    super(C_Img_Converted.class);
  }

  public C_Img_Converted get_img_converted(Long img_id_, int img_type_id_, int img_width_) {
    Transaction tx = null;
    C_Img_Converted res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_img_converted(session_, img_id_, img_type_id_, img_width_);
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

  public C_Img_Converted get_img_converted(Session session_, Long img_id_, int img_type_id_, int img_width_) {
    C_Img_Converted res = null;
    Query q_ = session_.createQuery("from C_Img_Converted where c_img=:img_id_ and c_img_type.img_type=:img_type_id_ and img_width=:img_width_ and is_deleted=false");
    //q_.setCacheable(use_query_cache);
    q_.setLong("img_id_", img_id_);
    q_.setInteger("img_type_id_", img_type_id_);
    q_.setInteger("img_width_", img_width_);
    List<C_Img_Converted> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public C_Img_Converted get_img_converted_by_height(Session session_, Long img_id_, int img_type_id_, int img_height_) {
    C_Img_Converted res = null;
    Query q_ = session_.createQuery("from C_Img_Converted where c_img=:img_id_ and c_img_type.img_type=:img_type_id_ and img_height=:img_height_ and is_deleted=false");
    //q_.setCacheable(use_query_cache);
    q_.setLong("img_id_", img_id_);
    q_.setInteger("img_type_id_", img_type_id_);
    q_.setInteger("img_height_", img_height_);
    List<C_Img_Converted> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public C_Img_Converted get_img_converted(C_Img img_, int img_type_id_, int img_width_, boolean is_create_if_not_exists_) {
    C_Img_Converted res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_img_converted(session_, img_, img_type_id_, img_width_, is_create_if_not_exists_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
    }
    return res;
  }

  public C_Img_Converted get_img_converted_by_height(C_Img img_, int img_type_id_, int img_height_, boolean is_create_if_not_exists_) {
    C_Img_Converted res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_img_converted_by_height(session_, img_, img_type_id_, img_height_, is_create_if_not_exists_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
    }
    return res;
  }

  public C_Img_Converted get_img_converted(Session session_, C_Img img_, int img_type_id_, int img_width_, boolean is_create_if_not_exists_) throws Exception {
    C_Img_Converted img_converted_ = get_img_converted(session_, img_.getC_img(), img_type_id_, img_width_);
    if (img_converted_ == null) {
      if (is_create_if_not_exists_) {
        generate_img_converted(session_, img_, img_type_id_, img_width_);
        img_converted_ = get_img_converted(session_, img_.getC_img(), img_type_id_, img_width_);
      }
      return img_converted_;
    } else {
      return img_converted_;
    }
  }

  public C_Img_Converted get_img_converted_by_max_w_and_h(C_Img img_, int img_type_id_, int img_max_width_, int img_max_height_, boolean is_create_if_not_exists_) {
    C_Img_Converted res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_img_converted_by_max_w_and_h(session_, img_, img_type_id_, img_max_width_, img_max_height_, is_create_if_not_exists_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
    }
    return res;
  }

  public C_Img_Converted get_img_converted_by_max_w_and_h(Session session_, C_Img img_, int img_type_id_, int img_max_width_, int img_max_height_, boolean is_create_if_not_exists_)
    throws Exception {
    InputStream is_ = new ByteArrayInputStream(img_.getC_bin_file_body_t_2(session_).getFile_body());
    Integer img_width_ = image_funcs.getImageWidth(is_);
    Integer img_height_ = image_funcs.getImageHeight(is_);
    int new_img_width_;
    int new_img_height_;
    new_img_width_ = img_max_width_;
    if (new_img_width_ > img_width_) {
      new_img_width_ = img_width_;
    }
    new_img_height_ = image_funcs.getImageScaledHeight(is_, new_img_width_);
    if (new_img_height_ > img_height_) {
      new_img_height_ = img_height_;
    }
    if (new_img_height_ > img_max_height_) {
      new_img_height_ = img_max_height_;
      new_img_width_ = image_funcs.getImageScaledWidth(is_, new_img_height_);
    }

    C_Img_Converted img_converted_ = get_img_converted(session_, img_.getC_img(), img_type_id_, new_img_width_);
    if (img_converted_ == null) {
      if (is_create_if_not_exists_) {
        generate_img_converted(session_, img_, img_type_id_, new_img_width_);
        img_converted_ = get_img_converted(session_, img_.getC_img(), img_type_id_, new_img_width_);
      }
      return img_converted_;
    } else {
      return img_converted_;
    }
  }

  public C_Img_Converted get_img_converted_by_height(Session session_, C_Img img_, int img_type_id_, int img_height_, boolean is_create_if_not_exists_) throws Exception {
    C_Img_Converted img_converted_ = get_img_converted_by_height(session_, img_.getC_img(), img_type_id_, img_height_);
    if (img_converted_ == null) {
      if (is_create_if_not_exists_) {
        generate_img_converted_by_height(session_, img_, img_type_id_, img_height_);
        img_converted_ = get_img_converted_by_height(session_, img_.getC_img(), img_type_id_, img_height_);
      }
      return img_converted_;
    } else {
      return img_converted_;
    }
  }

  public void generate_img_converted(C_Img img_, int img_type_id_, int img_width_) {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      generate_img_converted(session_, img_, img_type_id_, img_width_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
    }
  }

  public void generate_img_converted(Session session_, C_Img img_, int img_type_id_, int img_width_) throws Exception {
    C_Img_Converted img_converted_ = new C_Img_Converted();
    img_converted_.setC_img(img_.getC_img());
    img_converted_.setC_img_type(img_type_id_);
    img_converted_.setImg_width(img_width_);

    InputStream is_ = new ByteArrayInputStream(img_converted_.getC_img_t_2(session_).getC_bin_file_body_t_2(session_).getFile_body());
    Integer img_height_ = image_funcs.getImageScaledHeight(is_, img_width_);

    is_ = new ByteArrayInputStream(img_converted_.getC_img_t_2(session_).getC_bin_file_body_t_2(session_).getFile_body());
    ByteArrayOutputStream os_ = new ByteArrayOutputStream();
    image_funcs.rescale(is_, os_, "png", img_width_, img_height_);

    C_Bin_File_Body bin_file_body_;
    bin_file_body_ = new C_Bin_File_Body();
    bin_file_body_.setFile_body(os_.toByteArray());
    session_.save(bin_file_body_);
    img_converted_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
    img_converted_.setImg_height(img_height_);
    img_converted_.setIs_deleted(false);
    session_.save(img_converted_);
  }

  /*
  public void generate_img_converted_by_height(Session session_, Long img_id_, int img_type_id_, int img_height_) throws Exception {
    generate_img_converted_by_height(session_, Img_Manager.getCI().get_rec(session_, img_id_), img_type_id_, img_height_);
  }
   */
  public void generate_img_converted_by_height(Session session_, C_Img img_, int img_type_id_, int img_height_) throws Exception {
    C_Img_Converted img_converted_ = new C_Img_Converted();
    img_converted_.setC_img(img_.getC_img());
    img_converted_.setC_img_type(img_type_id_);
    img_converted_.setImg_height(img_height_);

    InputStream is_ = new ByteArrayInputStream(img_converted_.getC_img_t_2(session_).getC_bin_file_body_t_2(session_).getFile_body());
    Integer img_width_ = image_funcs.getImageScaledWidth(is_, img_height_);

    is_ = new ByteArrayInputStream(img_converted_.getC_img_t_2(session_).getC_bin_file_body_t_2(session_).getFile_body());
    ByteArrayOutputStream os_ = new ByteArrayOutputStream();
    image_funcs.rescale(is_, os_, "png", img_width_, img_height_);
    
    C_Bin_File_Body bin_file_body_;
    bin_file_body_ = new C_Bin_File_Body();
    bin_file_body_.setFile_body(os_.toByteArray());
    session_.save(bin_file_body_);
    
    img_converted_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
    img_converted_.setImg_width(img_width_);
    img_converted_.setIs_deleted(false);
    session_.save(img_converted_);
  }

  public static void delete_img_converted_by_img_id(Session session_, Long img_id_) {
    if (img_id_ == null) {
      return;
    }
    C_Img_Rotated_Manager.delete_img_rotated_by_img_id(session_, img_id_);
    Query q_ = session_.createQuery("update C_Img_Converted set is_deleted=true where c_img=:img_id_");
    q_.setLong("img_id_", img_id_);
    q_.executeUpdate();
  }

  public static void delete_img_converted_by_img_id(Long img_id_) {
    if (img_id_ == null) {
      return;
    }
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Transaction tx = null;
    try {
      tx = session_.beginTransaction();
      delete_img_converted_by_img_id(img_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public static C_Img_Converted get_img_converted(Long img_id_, String img_type_code_, int img_max_width_, int img_max_height_) {
    C_Img img_ = C_Img_Manager.getCI().get_rec(img_id_);
    int img_type_id_ = C_Img_Type_Manager.getCI().get_rec_by_code(img_type_code_).getC_img_type();

    C_Img_Converted img_converted_ = C_Img_Converted_Manager.getCI().get_img_converted_by_max_w_and_h(img_, img_type_id_, img_max_width_, img_max_height_, true);
    return img_converted_;
  }

  public String get_img_converted__img_type__code(Session session_, Long img_converted_id_) {
    Query q_ = session_.createQuery("select c_img_type.code from C_Img_Converted where c_img_converted=:img_converted_id_");
    q_.setLong("img_converted_id_", img_converted_id_);
    q_.setCacheable(use_query_cache);
    List<String> list_ = q_.list();
    if (!list_.isEmpty()) {
      return list_.get(0);
    } else {
      return null;
    }
  }

  public String get_img_converted__img_type__code(Long img_converted_id_) {
    String res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = get_img_converted__img_type__code(session_, img_converted_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      hibernate_funcs.rollbackAndClose(session_);
      throw e;
    }
    return res;
  }

}
