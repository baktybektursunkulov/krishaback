package beans;

import additional_classes.Lang;
import java.io.Serializable;import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class LangSwitcherBean implements Serializable {

  private List<Lang> langs;

  @PostConstruct
  public void init() {
    langs = new ArrayList<Lang>();
    langs.add(new Lang("казахский", "kz.png"));
    langs.add(new Lang("русский", "ru.png"));
    langs.add(new Lang("английский", "en.png"));
  }

  public void saveTheme() {
    //GuestPreferences gp_ = (GuestPreferences)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("guestPreferences");
    //gp_.setTheme(theme);
  }

  public List<Lang> getLangs() {
    return langs;
  }
}
