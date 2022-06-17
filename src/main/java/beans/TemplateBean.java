package beans;

import java.io.Serializable;import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class TemplateBean implements Serializable {

    public String getBodyClass() {
      String res = "";
      String viewId = "";
      FacesContext fc = FacesContext.getCurrentInstance();
      viewId = fc.getViewRoot().getViewId();
      if (viewId.contains("main_menu.xhtml")) {
        return "dashboard";
      } else if (viewId.contains("user_list.xhtml")) {
        return "change-list";
      } else if (viewId.contains("user_add.xhtml")) {
        return "change-form";
      } else {
        return "";
      }

    }

}
