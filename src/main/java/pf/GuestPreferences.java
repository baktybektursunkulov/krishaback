package pf;

import beans.SessionBean;
import java.io.Serializable;
import gs.common.model.db.Abstract_Entity;
import gs.common.jsf.jsf_funcs;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class GuestPreferences implements Serializable {

  private String theme = "nova-light";//"manhattan-blue";//"aristo"; //default afterwork

  public static GuestPreferences getGuestPreferencesBean() {
    return jsf_funcs.findBean("guestPreferences");
  }

  public String getTheme() {
    if (theme == null && SessionBean.getCurrentBean().getCurrent_c_site() != null) {
      theme = "omega";// theme = SessionBean.getCurrentBean().getCurrent_c_site().getC_theme_t().getCode();
    //} else { 
    //  theme = "omega";
    }
    /*
    Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    if (params.containsKey("theme")) {
      theme = params.get("theme");
    }
*/

    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public void saveTheme() {
    if (getTheme() == null || getTheme().trim().isEmpty()) {
      return;
    }
    GuestPreferences gp_ = GuestPreferences.getGuestPreferencesBean();
    gp_.setTheme(getTheme());
    //setTheme(getTheme());
  }
  
  public String getThemeColor() {
    if (getTheme().contains("-")) {
      return getTheme().substring(getTheme().indexOf("-") + 1);
    } else {
      return getTheme();
    }
  }
}
