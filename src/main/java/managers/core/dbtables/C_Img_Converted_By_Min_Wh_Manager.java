package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import gs.common.image.image_funcs;
import java.util.*;
import java.text.*;
import model.core.dbutil.CoreSessionFactoryUtil;

@ManagedBean
@ApplicationScoped
public class C_Img_Converted_By_Min_Wh_Manager extends Abstract_Controller_Manager<C_Img_Converted_By_Min_Wh> {

  private static C_Img_Converted_By_Min_Wh_Manager currentInstance = null;

  public static C_Img_Converted_By_Min_Wh_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Img_Converted_By_Min_Wh_Manager();
    }
    return currentInstance;
  }

  public C_Img_Converted_By_Min_Wh_Manager() {
    super(C_Img_Converted_By_Min_Wh.class);
  }

  public static void delete_img_converted_min_wh_by_img_id(Session session_, Long img_id_) {
    if (img_id_ == null) {
      return;
    }
    C_Img_Rotated_Manager.delete_img_rotated_by_img_id(session_, img_id_);
    Query q_ = session_.createQuery("update C_Img_Converted_By_Min_Wh set is_deleted=true where c_img=:img_id_");
    q_.setLong("img_id_", img_id_);
    q_.executeUpdate();
  }

  /*
  public boolean is_img_converted_min_wh_exists(Session session_, Long img_id_, int img_type_id_, int img_min_width_, int img_min_height_) {
    Query q_ = session_.createSQLQuery("select 1 from C_Img_Converted_By_Min_Wh where c_img=:img_id_ and c_img_type.img_type=:img_type_id_ and img_min_width=:img_min_width_ and img_min_height=:img_min_height_ and is_deleted=false");
  //q_.setCacheable(use_query_cache);
    q_.setInteger("img_id_", img_id_);
    q_.setInteger("img_type_id_", img_type_id_);
    q_.setInteger("img_min_width_", img_min_width_);
    q_.setInteger("img_min_height_", img_min_height_);
    q_.setMaxResults(1);
    return (q_.list().size() > 0);
  }
   */
  public C_Img_Converted_By_Min_Wh get_img_converted_min_wh(Session session_, Long img_id_, int img_type_id_, int img_min_width_, int img_min_height_) {
    C_Img_Converted_By_Min_Wh res = null;
    Query q_ = session_.createQuery("from C_Img_Converted_By_Min_Wh where c_img=:img_id_ and c_img_type.img_type=:img_type_id_ and img_min_width=:img_min_width_ and img_min_height=:img_min_height_ and is_deleted=false");
    //q_.setCacheable(use_query_cache);
    q_.setLong("img_id_", img_id_);
    q_.setInteger("img_type_id_", img_type_id_);
    q_.setInteger("img_min_width_", img_min_width_);
    q_.setInteger("img_min_height_", img_min_height_);
    List<C_Img_Converted_By_Min_Wh> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public Integer get_img_converted_min_wh_id(Session session_, Long img_id_, int img_type_id_, int img_min_width_, int img_min_height_) {
    Integer res = null;
    Query q_ = session_.createQuery("select c_img_converted_by_min_wh from C_Img_Converted_By_Min_Wh where c_img=:img_id_ and c_img_type.img_type=:img_type_id_ and img_min_width=:img_min_width_ and img_min_height=:img_min_height_ and is_deleted=false");
    //q_.setCacheable(use_query_cache);
    q_.setLong("img_id_", img_id_);
    q_.setInteger("img_type_id_", img_type_id_);
    q_.setInteger("img_min_width_", img_min_width_);
    q_.setInteger("img_min_height_", img_min_height_);
    List list_ = q_.list();
    if (list_.size() > 0) {
      res = (Integer) list_.get(0);
    }
    return res;
  }

  public void generate_img_converted_min_wh(Session session_, Long img_id_, int img_type_id_, int img_min_width_, int img_min_height_) throws Exception {
    C_Img img_ = C_Img_Manager.getCI().get_rec(session_, img_id_);
    generate_img_converted_min_wh(session_, img_, img_type_id_, img_min_width_, img_min_height_);
  }

  public void generate_img_converted_min_wh(Session session_, C_Img img_, int img_type_id_, int img_min_width_, int img_min_height_) throws Exception {
    C_Img_Converted_By_Min_Wh img_converted_by_min_wh_ = new C_Img_Converted_By_Min_Wh();
    img_converted_by_min_wh_.setC_img(img_.getC_img());
    img_converted_by_min_wh_.setC_img_type(img_type_id_);
    img_converted_by_min_wh_.setImg_min_width(img_min_width_);
    img_converted_by_min_wh_.setImg_min_height(img_min_height_);

    byte[] byte_arr_ = image_funcs.get_img_by_min_w_and_h(img_.getC_bin_file_body_t_2(session_).getFile_body(), img_min_width_, img_min_height_);

    C_Bin_File_Body bin_file_body_;
    bin_file_body_ = new C_Bin_File_Body();
    bin_file_body_.setFile_body(byte_arr_);
    session_.save(bin_file_body_);

    img_converted_by_min_wh_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
    img_converted_by_min_wh_.setIs_deleted(false);
    session_.save(img_converted_by_min_wh_);
  }

  public C_Img_Converted_By_Min_Wh get_img_converted_by_min_w_and_h(Long img_id_, String img_type_code_, int img_min_width_, int img_min_height_, boolean is_create_if_not_exists_) throws Exception {
    C_Img_Converted_By_Min_Wh res = null;

    C_Img img_ = C_Img_Manager.getCI().get_rec(img_id_);
    C_Img_Type img_type_ = C_Img_Type_Manager.getCI().get_rec_by_code(img_type_code_);
    res = get_img_converted_by_min_w_and_h(img_, img_type_.getC_img_type(), img_min_width_, img_min_height_, is_create_if_not_exists_);

    return res;
  }

  public C_Img_Converted_By_Min_Wh get_img_converted_by_min_w_and_h(C_Img img_, int img_type_id_, int img_min_width_, int img_min_height_, boolean is_create_if_not_exists_)
    throws Exception {
    C_Img_Converted_By_Min_Wh res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_img_converted_by_min_w_and_h(session_, img_, img_type_id_, img_min_width_, img_min_height_, is_create_if_not_exists_);
      hibernate_funcs.commitAndClose(session_);
      return res;
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public C_Img_Converted_By_Min_Wh get_img_converted_by_min_w_and_h(Session session_, C_Img img_, int img_type_id_, int img_min_width_, int img_min_height_, boolean is_create_if_not_exists_)
    throws Exception {

    C_Img_Converted_By_Min_Wh img_converted_by_min_wh_ = get_img_converted_min_wh(session_, img_.getC_img(), img_type_id_, img_min_width_, img_min_height_);
    if (img_converted_by_min_wh_ == null) {
      if (is_create_if_not_exists_) {
        generate_img_converted_min_wh(session_, img_, img_type_id_, img_min_width_, img_min_height_);
        img_converted_by_min_wh_ = get_img_converted_min_wh(session_, img_.getC_img(), img_type_id_, img_min_width_, img_min_height_);
      }
      return img_converted_by_min_wh_;
    } else {
      return img_converted_by_min_wh_;
    }
  }

  public Integer get_img_converted_by_min_w_and_h_id(Session session_, Long img_id_, int img_type_id_, int img_min_width_, int img_min_height_, boolean is_create_if_not_exists_)
    throws Exception {

    Integer img_converted_by_min_wh_id_ = get_img_converted_min_wh_id(session_, img_id_, img_type_id_, img_min_width_, img_min_height_);
    if (img_converted_by_min_wh_id_ == null) {
      if (is_create_if_not_exists_) {
        generate_img_converted_min_wh(session_, img_id_, img_type_id_, img_min_width_, img_min_height_);
        img_converted_by_min_wh_id_ = get_img_converted_min_wh_id(session_, img_id_, img_type_id_, img_min_width_, img_min_height_);
      }
      return img_converted_by_min_wh_id_;
    } else {
      return img_converted_by_min_wh_id_;
    }
  }

  
}
