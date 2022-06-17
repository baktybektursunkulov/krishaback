package controllers.core.dbtables;

import beans.ApplicationBean;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;
import managers.core.dbtables.C_System_Version_Manager;
import org.hibernate.Session;import gs.common.hibernate_funcs;

@ManagedBean 
@ViewScoped
public class C_System_Version_Controller extends Abstract_Controller<C_System_Version> {

  public C_System_Version_Controller() {
    super(C_System_Version.class, "c_system_version_list.xhtml");
  }

  public C_System_Version getC_system_version() {
    return getAbstract_entity();
  }

  @Override
  protected void afterLoadDefaultRec() {
    Integer major_version_ = C_System_Version_Manager.getCI().get_system_max_major_version();
    if (major_version_ == null) {
      major_version_ = 0;
    }
    getC_system_version().setMajor_version(major_version_);
    Integer minor_version_ = C_System_Version_Manager.getCI().get_system_max_minor_version(major_version_);
    if (minor_version_ == null) {
      minor_version_ = 0;
    }
    getC_system_version().setMinor_version(minor_version_ + 1);
    getC_system_version().setIs_sent_to_subscribed_users(false);
  }

  @Override
  protected void afterDeleteRec(Session session_) {
    //ApplicationBean.getCI().refresh_current_version(session_);
  }

  @Override
  protected void afterUpdateRec(Session session_) {
    //C_System_Version_Manager.getCI().refresh_current_version(session_);
  }

  @Override
  protected void afterInsertRec(Session session_) {
    //C_System_Version_Manager.getCI().refresh_current_version(session_);
  }

}
