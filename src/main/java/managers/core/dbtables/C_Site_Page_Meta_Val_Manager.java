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
public class C_Site_Page_Meta_Val_Manager extends Abstract_Controller_Manager<C_Site_Page_Meta_Val> {

  private static C_Site_Page_Meta_Val_Manager currentInstance = null;

  public static C_Site_Page_Meta_Val_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Site_Page_Meta_Val_Manager();
    }
    return currentInstance;
  }

  public C_Site_Page_Meta_Val_Manager() {
    super(C_Site_Page_Meta_Val.class);
  }

  public C_Site_Page_Meta_Val get_c_site_page_meta_val_wo_creation(Session session_, Integer c_site_page_meta_id_) {
    Query q_ = session_.createQuery("from C_Site_Page_Meta_Val where is_deleted=false and c_site_page_meta=:c_site_page_meta_id_");
    q_.setInteger("c_site_page_meta_id_", c_site_page_meta_id_);
    //q_.setCacheable(use_query_cache);
    List<C_Site_Page_Meta_Val> list_ = q_.list();
    if (list_.isEmpty()) {
      return null;
    } else {
      return list_.get(0);
    }
  }

  public C_Site_Page_Meta_Val get_c_site_page_meta_val_with_creation(Session session_, Integer c_site_page_meta_id_) {
    C_Site_Page_Meta_Val res = null;

    res = get_c_site_page_meta_val_wo_creation(session_, c_site_page_meta_id_);
    if (res == null) {
      res = new C_Site_Page_Meta_Val();
      res.setC_site_page_meta(c_site_page_meta_id_);
      res.setVal("");
      res.setVal_in_html("");
      res.setIs_deleted(false);
      C_Site_Page_Meta_Val_Manager.getCI().insert_rec(session_, res);
    }

    return res;
  }

  public C_Site_Page_Meta_Val get_c_site_page_meta_val_with_creation(Session session_, Integer c_site_id_, Integer c_site_page_id_, Integer c_site_meta_id_) {
    C_Site_Page_Meta_Val res = null;

    C_Site_Page_Meta c_Site_Page_Meta = C_Site_Page_Meta_Manager.getCI().get_c_site_page_meta_with_creation(session_, c_site_id_, c_site_page_id_, c_site_meta_id_);
    res = get_c_site_page_meta_val_with_creation(session_, c_Site_Page_Meta.getC_site_page_meta());

    return res;
  }

  public String get_c_site_page_meta_val_translation(Session session_, Integer c_site_id_, Integer c_site_page_id_, Integer c_site_meta_id_, String lang_) throws Exception {
    C_Site_Page_Meta_Val c_Site_Page_Meta_Val;
    c_Site_Page_Meta_Val = C_Site_Page_Meta_Val_Manager.getCI().get_c_site_page_meta_val_with_creation(session_, c_site_id_,
      c_site_page_id_, c_site_meta_id_);
    C_Site_Meta c_Site_Meta = C_Site_Meta_Manager.getCI().get_rec(session_, c_site_meta_id_);
    if (lang_.equals("ru")) {
      if (c_Site_Meta.getIs_html()) {
        return c_Site_Page_Meta_Val.getVal_in_html();
      } else {
        return c_Site_Page_Meta_Val.getVal();
      }
    } else {
      if (c_Site_Meta.getIs_html()) {
        return I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, "C_Site_Page_Meta_Val", c_Site_Page_Meta_Val.getC_site_page_meta_val(), "val_in_html", lang_,
          c_Site_Page_Meta_Val.getVal_in_html());
      } else {
        return I_Tbl_Fld_Trans_Manager.get_tbl_fld_translation(session_, "C_Site_Page_Meta_Val", c_Site_Page_Meta_Val.getC_site_page_meta_val(), "val", lang_,
          c_Site_Page_Meta_Val.getVal());
      }
    }
  }

  public String get_c_site_page_meta_val_translation_2(Session session_, Integer c_site_id_, Integer c_site_page_id_, Integer c_site_meta_id_, String lang_) throws Exception {
    return get_c_site_page_meta_val_translation(session_, c_site_id_, c_site_page_id_, c_site_meta_id_, lang_);
  }
}
