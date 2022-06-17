package beans;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class test_LocaleBean implements Serializable {

  private Locale locale = null;

  @PostConstruct
  public void init() {
    locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
  }

  public Locale getLocale() {
    if (locale == null) {
      locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }
    return locale;
  }

}
