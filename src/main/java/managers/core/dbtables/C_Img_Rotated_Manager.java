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
public class C_Img_Rotated_Manager extends Abstract_Controller_Manager<C_Img_Rotated> {

  private static C_Img_Rotated_Manager currentInstance = null;

  public static C_Img_Rotated_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Img_Rotated_Manager();
    }
    return currentInstance;
  }

  public C_Img_Rotated_Manager() {
    super(C_Img_Rotated.class);
  }

  public C_Img_Rotated get_img_rotated(int img_converted_id_, int rotate_angle_) {
    Transaction tx = null;
    C_Img_Rotated res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_img_rotated(session_, img_converted_id_, rotate_angle_);
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

  public C_Img_Rotated get_img_rotated(Session session_, int img_converted_id_, int rotate_angle_) {
    C_Img_Rotated res = null;
    Query q_ = session_.createQuery("from C_Img_Rotated where is_deleted=false and c_img_converted=:img_converted_id_ and rotate_angle=:rotate_angle_ ");
    //q_.setCacheable(use_query_cache);
    q_.setInteger("img_converted_id_", img_converted_id_);
    q_.setInteger("rotate_angle_", rotate_angle_);
    List<C_Img_Rotated> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public C_Img_Rotated get_img_rotated(int img_converted_id_, int rotate_angle_, boolean is_create_if_not_exists_) {
    Transaction tx = null;
    C_Img_Rotated res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_img_rotated(session_, img_converted_id_, rotate_angle_, is_create_if_not_exists_);
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

  public C_Img_Rotated get_img_rotated(Session session_, int img_converted_id_, int rotate_angle_, boolean is_create_if_not_exists_) {
    C_Img_Rotated img_rotated_ = get_img_rotated(session_, img_converted_id_, rotate_angle_);
    if (img_rotated_ == null) {
      if (is_create_if_not_exists_) {
        generate_img_rotated(session_, img_converted_id_, rotate_angle_);
        img_rotated_ = get_img_rotated(session_, img_converted_id_, rotate_angle_);
      }
      return img_rotated_;
    } else {
      if (!img_rotated_.getImg_width().equals(img_rotated_.getC_img_converted_t_2(session_).getImg_width())) {
        if (is_create_if_not_exists_) {
          fix_img_rotated(session_, img_rotated_);
          img_rotated_ = get_img_rotated(session_, img_converted_id_, rotate_angle_);
        }
      }
      return img_rotated_;
    }
  }

  public void generate_img_rotated(int img_converted_id_, int rotate_angle_) {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      generate_img_rotated(session_, img_converted_id_, rotate_angle_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
    }
  }

  public void generate_img_rotated(Session session_, int img_converted_id_, int rotate_angle_) {
    try {
      C_Img_Converted img_converted_ = C_Img_Converted_Manager.getCI().get_rec(session_, img_converted_id_);

      InputStream is_ = new ByteArrayInputStream(img_converted_.getC_bin_file_body_t_2(session_).getFile_body());
      ByteArrayOutputStream os_ = new ByteArrayOutputStream();
      image_funcs.rotate_without_changing_width_and_height(is_, os_, img_converted_.getC_img_type_t_2(session_).getCode(), rotate_angle_);

      C_Img_Rotated img_rotated_ = new C_Img_Rotated();
      img_rotated_.setC_img_converted(img_converted_.getC_img_converted());
      img_rotated_.setRotate_angle(rotate_angle_);

      C_Bin_File_Body bin_file_body_;
      bin_file_body_ = new C_Bin_File_Body();
      bin_file_body_.setFile_body(os_.toByteArray());
      session_.save(bin_file_body_);

      img_rotated_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      img_rotated_.setImg_width(image_funcs.getImageWidth(img_rotated_.getC_bin_file_body_t_2(session_).getFile_body()));
      img_rotated_.setImg_height(image_funcs.getImageHeight(img_rotated_.getC_bin_file_body_t_2(session_).getFile_body()));
      img_rotated_.setIs_deleted(false);

      session_.save(img_rotated_);
    } catch (Exception e) {
      CustomLogger.error(e);
    }
  }

  public void fix_img_rotated(Session session_, C_Img_Rotated img_rotated_) {
    try {
      InputStream is_ = new ByteArrayInputStream(img_rotated_.getC_img_converted_t_2(session_).getC_bin_file_body_t_2(session_).getFile_body());
      ByteArrayOutputStream os_ = new ByteArrayOutputStream();
      image_funcs.rotate_without_changing_width_and_height(is_, os_, C_Img_Converted_Manager.getCI().get_img_converted__img_type__code(session_, img_rotated_.getC_img_converted()), img_rotated_.getRotate_angle());

      C_Bin_File_Body bin_file_body_;
      bin_file_body_ = new C_Bin_File_Body();
      bin_file_body_.setFile_body(os_.toByteArray());
      session_.save(bin_file_body_);

      img_rotated_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      img_rotated_.setImg_width(image_funcs.getImageWidth(is_));
      img_rotated_.setImg_height(image_funcs.getImageHeight(is_));
      img_rotated_.setIs_deleted(false);

      session_.merge(img_rotated_);
    } catch (Exception e) {
      CustomLogger.error(e);
    }
  }

  public static void delete_img_rotated_by_img_converted_id(Session session_, Long img_converted_id_) {
    if (img_converted_id_ == null) {
      return;
    }
    Query q_ = session_.createQuery("delete from C_Img_Rotated where c_img_converted=:img_converted_id_");
    q_.setLong("img_converted_id_", img_converted_id_);
    q_.executeUpdate();
  }

  public static void delete_img_rotated_by_img_converted_id(Long img_converted_id_) {
    if (img_converted_id_ == null) {
      return;
    }
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Transaction tx = null;
    try {
      tx = session_.beginTransaction();
      delete_img_rotated_by_img_converted_id(img_converted_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public static void delete_img_rotated_by_img_id(Session session_, Long img_id_) {
    if (img_id_ == null) {
      return;
    }
    Query q_ = session_.createQuery("delete from C_Img_Rotated ir where ir.c_img_rotated in (select ir2.c_img_rotated from C_Img_Rotated ir2, C_Img_Converted ic2 where ir2.c_img_converted=ic2.c_img_converted and ic2.c_img=:img_id_)");
    q_.setLong("img_id_", img_id_);
    q_.executeUpdate();
  }

}
