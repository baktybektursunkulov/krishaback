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
public class C_Site_Meta_Manager extends Abstract_Controller_Manager<C_Site_Meta> {

  private static C_Site_Meta_Manager currentInstance = null;
  private Integer c_site_meta_id__title = 1; // Заголовок
  private Integer c_site_meta_id__description = 2; // Описание
  private Integer c_site_meta_id__content = 3; // Содержимое
  //private C_Site_Meta title_c_site_meta;
  //private C_Site_Meta description_c_site_meta;

  public static C_Site_Meta_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Site_Meta_Manager();
    }
    return currentInstance;
  }

  public C_Site_Meta_Manager() {
    super(C_Site_Meta.class);
  }

  public Integer getC_site_meta_id__title() {
    return c_site_meta_id__title;
  }

  public void setC_site_meta_id__title(Integer c_site_meta_id__title) {
    this.c_site_meta_id__title = c_site_meta_id__title;
  }

  public Integer getC_site_meta_id__description() {
    return c_site_meta_id__description;
  }

  public void setC_site_meta_id__description(Integer c_site_meta_id__description) {
    this.c_site_meta_id__description = c_site_meta_id__description;
  }

  /*
  public C_Site_Meta getTitle_c_site_meta() {
    if (title_c_site_meta == null) {
      title_c_site_meta = C_Site_Meta_Manager.getCI().get_rec(getC_site_meta_id__title());
    }
    return title_c_site_meta;
  }

  public void setTitle_c_site_meta(C_Site_Meta title_c_site_meta) {
    this.title_c_site_meta = title_c_site_meta;
  }

  public C_Site_Meta getTitle_c_site_meta_2(Session session_) {
    if (title_c_site_meta == null) {
      title_c_site_meta = C_Site_Meta_Manager.getCI().get_rec(session_, getC_site_meta_id__title());
    }
    return title_c_site_meta;
  }

  public C_Site_Meta getDescription_c_site_meta() {
    if (description_c_site_meta == null) {
      description_c_site_meta = C_Site_Meta_Manager.getCI().get_rec(getC_site_meta_id__description());
    }
    return description_c_site_meta;
  }

  public void setDescription_c_site_meta(C_Site_Meta description_c_site_meta) {
    this.description_c_site_meta = description_c_site_meta;
  }

  public C_Site_Meta getDescription_c_site_meta_2(Session session_) {
    if (description_c_site_meta == null) {
      description_c_site_meta = C_Site_Meta_Manager.getCI().get_rec(session_, getC_site_meta_id__description());
    }
    return description_c_site_meta;
  }
   */
  public Integer getC_site_meta_id__content() {
    return c_site_meta_id__content;
  }

  public void setC_site_meta_id__content(Integer c_site_meta_id__content) {
    this.c_site_meta_id__content = c_site_meta_id__content;
  }
}
