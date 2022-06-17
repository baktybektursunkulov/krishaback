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
public class C_Img_Converted_By_Max_Wh_Manager extends Abstract_Controller_Manager<C_Img_Converted_By_Max_Wh> {

  private static C_Img_Converted_By_Max_Wh_Manager currentInstance = null;

  public static C_Img_Converted_By_Max_Wh_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Img_Converted_By_Max_Wh_Manager();
    }
    return currentInstance;
  }

  public C_Img_Converted_By_Max_Wh_Manager() {
    super(C_Img_Converted_By_Max_Wh.class);
  }

  public static void delete_img_converted_max_wh_by_img_id(Session session_, Long c_img_id_) {
    if (c_img_id_ == null) {
      return;
    }
    C_Img_Rotated_Manager.delete_img_rotated_by_img_id(session_, c_img_id_);
    Query q_ = session_.createQuery("update C_Img_Converted_By_Max_Wh set is_deleted=true where c_img=:c_img_id_");
    q_.setLong("c_img_id_", c_img_id_);
    q_.executeUpdate();
  }

  /*
  public boolean is_img_converted_max_wh_exists(Session session_, Long img_id_, int img_type_id_, int img_max_width_, int img_max_height_) {
    Query q_ = session_.createSQLQuery("select 1 from C_Img_Converted_By_Max_Wh where c_img=:img_id_ and c_img_type.img_type=:img_type_id_ and img_max_width=:img_max_width_ and img_max_height=:img_max_height_ and is_deleted=false");
  //q_.setCacheable(use_query_cache);
    q_.setInteger("img_id_", img_id_);
    q_.setInteger("img_type_id_", img_type_id_);
    q_.setInteger("img_max_width_", img_max_width_);
    q_.setInteger("img_max_height_", img_max_height_);
    q_.setMaxResults(1);
    return (q_.list().size() > 0);
  }
   */
  public C_Img_Converted_By_Max_Wh get_img_converted_max_wh(Session session_, Long img_id_, int img_type_id_, int img_max_width_, int img_max_height_) {
    C_Img_Converted_By_Max_Wh res = null;
    Query q_ = session_.createQuery("from C_Img_Converted_By_Max_Wh where c_img=:img_id_ and c_img_type.img_type=:img_type_id_ and img_max_width=:img_max_width_ and img_max_height=:img_max_height_ and is_deleted=false");
    //q_.setCacheable(use_query_cache);
    q_.setLong("img_id_", img_id_);
    q_.setInteger("img_type_id_", img_type_id_);
    q_.setInteger("img_max_width_", img_max_width_);
    q_.setInteger("img_max_height_", img_max_height_);
    List<C_Img_Converted_By_Max_Wh> list_ = q_.list();
    if (list_.size() > 0) {
      res = list_.get(0);
    }
    return res;
  }

  public Integer get_img_converted_max_wh_id(Session session_, Long img_id_, int img_type_id_, int img_max_width_, int img_max_height_) {
    Integer res = null;
    Query q_ = session_.createQuery("select img_converted_by_max_wh from C_Img_Converted_By_Max_Wh where c_img=:img_id_ and c_img_type.img_type=:img_type_id_ and img_max_width=:img_max_width_ and img_max_height=:img_max_height_ and is_deleted=false");
    //q_.setCacheable(use_query_cache);
    q_.setLong("img_id_", img_id_);
    q_.setInteger("img_type_id_", img_type_id_);
    q_.setInteger("img_max_width_", img_max_width_);
    q_.setInteger("img_max_height_", img_max_height_);
    List list_ = q_.list();
    if (list_.size() > 0) {
      res = (Integer) list_.get(0);
    }
    return res;
  }

  public void generate_img_converted_max_wh(Session session_, Long img_id_, int img_type_id_, int img_max_width_, int img_max_height_) throws Exception {
    C_Img img_ = C_Img_Manager.getCI().get_rec(session_, img_id_);
    generate_img_converted_max_wh(session_, img_, img_type_id_, img_max_width_, img_max_height_);
  }

  public void generate_img_converted_max_wh(Session session_, C_Img img_, int c_img_type_id_, int img_max_width_, int img_max_height_) throws Exception {
    C_Img_Converted_By_Max_Wh img_converted_by_max_wh_ = new C_Img_Converted_By_Max_Wh();
    img_converted_by_max_wh_.setC_img(img_.getC_img());
    img_converted_by_max_wh_.setC_img_type(c_img_type_id_);
    img_converted_by_max_wh_.setImg_max_width(img_max_width_);
    img_converted_by_max_wh_.setImg_max_height(img_max_height_);

    byte[] byte_arr_ = image_funcs.get_img_by_max_w_and_h(img_.getC_bin_file_body_t_2(session_).getFile_body(), img_max_width_, img_max_height_);

    C_Bin_File_Body bin_file_body_;
    bin_file_body_ = new C_Bin_File_Body();
    bin_file_body_.setFile_body(byte_arr_);
    session_.save(bin_file_body_);

    img_converted_by_max_wh_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
    img_converted_by_max_wh_.setIs_deleted(false);
    session_.save(img_converted_by_max_wh_);
  }

  public C_Img_Converted_By_Max_Wh get_img_converted_by_max_w_and_h(Long img_id_, String c_img_type_code_, int img_max_width_, int img_max_height_, boolean is_create_if_not_exists_) throws Exception {
    C_Img_Converted_By_Max_Wh res = null;

    C_Img img_ = C_Img_Manager.getCI().get_rec(img_id_);
    C_Img_Type img_type_ = C_Img_Type_Manager.getCI().get_rec_by_code(c_img_type_code_);
    res = get_img_converted_by_max_w_and_h(img_, img_type_.getC_img_type(), img_max_width_, img_max_height_, is_create_if_not_exists_);

    return res;
  }

  public C_Img_Converted_By_Max_Wh get_img_converted_by_max_w_and_h(C_Img img_, int c_img_type_id_, int img_max_width_, int img_max_height_, boolean is_create_if_not_exists_)
    throws Exception {
    C_Img_Converted_By_Max_Wh res = null;
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      res = get_img_converted_by_max_w_and_h(session_, img_, c_img_type_id_, img_max_width_, img_max_height_, is_create_if_not_exists_);
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

  public C_Img_Converted_By_Max_Wh get_img_converted_by_max_w_and_h(Session session_, C_Img c_img_, int c_img_type_id_, int img_max_width_, int img_max_height_, boolean is_create_if_not_exists_)
    throws Exception {

    C_Img_Converted_By_Max_Wh img_converted_by_max_wh_ = get_img_converted_max_wh(session_, c_img_.getC_img(), c_img_type_id_, img_max_width_, img_max_height_);
    if (img_converted_by_max_wh_ == null) {
      if (is_create_if_not_exists_) {
        generate_img_converted_max_wh(session_, c_img_, c_img_type_id_, img_max_width_, img_max_height_);
        img_converted_by_max_wh_ = get_img_converted_max_wh(session_, c_img_.getC_img(), c_img_type_id_, img_max_width_, img_max_height_);
      }
      return img_converted_by_max_wh_;
    } else {
      return img_converted_by_max_wh_;
    }
  }

  public Integer get_img_converted_by_max_w_and_h_id(Session session_, Long c_img_id_, int c_img_type_id_, int img_max_width_, int img_max_height_, boolean is_create_if_not_exists_)
    throws Exception {

    Integer img_converted_by_max_wh_id_ = get_img_converted_max_wh_id(session_, c_img_id_, c_img_type_id_, img_max_width_, img_max_height_);
    if (img_converted_by_max_wh_id_ == null) {
      if (is_create_if_not_exists_) {
        generate_img_converted_max_wh(session_, c_img_id_, c_img_type_id_, img_max_width_, img_max_height_);
        img_converted_by_max_wh_id_ = get_img_converted_max_wh_id(session_, c_img_id_, c_img_type_id_, img_max_width_, img_max_height_);
      }
      return img_converted_by_max_wh_id_;
    } else {
      return img_converted_by_max_wh_id_;
    }
  }

}
