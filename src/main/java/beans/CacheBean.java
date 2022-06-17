package beans;

import gs.common.jsf.jsf_funcs;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_System_Version_Manager;
import model.core.dbtables.C_System_Version;

@ManagedBean
@ApplicationScoped
public class CacheBean {

  String current_version;

  public static CacheBean getCacheBean() {
    CacheBean res = jsf_funcs.findBean("cacheBean");
    if (res == null) {
      res = new CacheBean();
      FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("cacheBean", res);
    }
    return res;
  }

  public String getCurrent_version() {
    //if (current_version == null) {
      refresh_current_version();
    //}
    return current_version;
  }

  public void setCurrent_version(String current_version) {
    this.current_version = current_version;
  }

  public void refresh_current_version() {
    C_System_Version c_system_version_ = C_System_Version_Manager.getCI().get_current_system_version();
    if (c_system_version_ != null) {
      current_version = c_system_version_.getVersion();
    }
  }

}
