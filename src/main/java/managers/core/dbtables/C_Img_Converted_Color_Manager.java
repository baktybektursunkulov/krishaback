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
public class C_Img_Converted_Color_Manager extends Abstract_Controller_Manager<C_Img_Converted_Color> {

  private static C_Img_Converted_Color_Manager currentInstance = null;

  public static C_Img_Converted_Color_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Img_Converted_Color_Manager();
    }
    return currentInstance;
  }

  public C_Img_Converted_Color_Manager() {
    super(C_Img_Converted_Color.class);
  }

  public C_Img_Converted_Color get_img_converted_color(Long img_id_, int img_type_id_, int img_width_, String img_color_) {
    Transaction tx = null;
    C_Img_Converted_Color res = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      Query q_ = session_.createQuery("from C_Img_Converted_Color where is_deleted=false and c_img=:img_id_ and c_img_type.img_type=:img_type_id_ and img_width=:img_width_ and img_color=:img_color_ ");
      //q_.setCacheable(use_query_cache);
      q_.setLong("img_id_", img_id_);
      q_.setInteger("img_type_id_", img_type_id_);
      q_.setInteger("img_width_", img_width_);
      q_.setString("img_color_", img_color_);
      List<C_Img_Converted_Color> list_ = q_.list();
      if (list_.size() > 0) {
        res = list_.get(0);
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

  public void generate_img_converted(Long img_id_, int img_type_id_, int img_width_, String img_color_) {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();

      C_Img_Converted_Color img_converted_color_ = new C_Img_Converted_Color();
      img_converted_color_.setC_img(img_id_);
      img_converted_color_.setC_img_type(img_type_id_);
      img_converted_color_.setImg_width(img_width_);

      InputStream is_ = new ByteArrayInputStream(img_converted_color_.getC_img_t_2(session_).getC_bin_file_body_t_2(session_).getFile_body());
      Integer img_height_ = image_funcs.getImageScaledHeight(is_, img_width_);

      is_ = new ByteArrayInputStream(img_converted_color_.getC_img_t_2(session_).getC_bin_file_body_t_2(session_).getFile_body());
      ByteArrayOutputStream os_ = new ByteArrayOutputStream();
      image_funcs.rescale(is_, os_, "png", img_width_, img_height_);

      C_Bin_File_Body bin_file_body_;
      bin_file_body_ = new C_Bin_File_Body();
      bin_file_body_.setFile_body(os_.toByteArray());
      session_.save(bin_file_body_);

      img_converted_color_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      img_converted_color_.setImg_height(img_height_);
      img_converted_color_.setImg_color(img_color_);
      img_converted_color_.setIs_deleted(false);
      session_.save(img_converted_color_);

      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
    }
  }

  public static void delete_img_converted_color_by_img_id(Session session_, Long img_id_) {
    if (img_id_ == null) {
      return;
    }
    Query q_ = session_.createQuery("update C_Img_Converted_Color set is_deleted=true where c_img=:img_id_");
    q_.setLong("img_id_", img_id_);

    q_.executeUpdate();
  }

  public static void delete_img_converted_color_by_img_id(Long img_id_) {
    if (img_id_ == null) {
      return;
    }
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Transaction tx = null;
    try {
      tx = session_.beginTransaction();
      delete_img_converted_color_by_img_id(session_, img_id_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

}
