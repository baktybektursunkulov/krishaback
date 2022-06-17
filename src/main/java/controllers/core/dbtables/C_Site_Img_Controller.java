package controllers.core.dbtables;

import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.*;
import java.util.*;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import javax.faces.bean.SessionScoped;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class C_Site_Img_Controller extends Abstract_Controller<C_Site_Img> {

  public C_Site_Img_Controller() {
    super(C_Site_Img.class, "c_site_img_list.xhtml", false);
  }

  public static C_Site_Img_Controller getCurrentBean() {
    return jsf_funcs.findBean(C_Site_Img_Controller.class);
  }

  public C_Site_Img getC_site_img() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    getAbstract_entity().setIs_deleted(false);
    getAbstract_entity().setImg_t(new C_Img());
  }

  @Override
  protected void afterLoadRec() {
    if (getAbstract_entity().getC_img() == null) {
      getAbstract_entity().setImg_t(new C_Img());
    }
  }

  @Override
  protected void afterLoadCopyRec() {
    getAbstract_entity().setImg_t(new C_Img());
  }

  @Override
  protected void deleteRec(Session session_) {
    getAbstract_entity().setIs_deleted(true);
    session_.merge(getAbstract_entity());
  }

  @Override
  protected void beforeInsertAndUpdateRec(Session session_) {
    try {
      getAbstract_entity().setImg_t(getAbstract_entity().getImg_t_2(session_).getCreatedImg(session_));
    } catch (Exception ex) {
      jsf_funcs.addErrorMessage(ex);
    }
  }
  
}
