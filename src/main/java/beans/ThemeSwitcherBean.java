package beans;

import java.io.Serializable; import gs.common.model.db.Abstract_Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Tbl_Rec_Prop_Val_Manager;
import pf.GuestPreferences;
import pf.Theme;

@ManagedBean
@ApplicationScoped
public class ThemeSwitcherBean implements Serializable {

  //private Map<String, String> themes;
  private static ThemeSwitcherBean currentInstance = null;
  private List<Theme> advancedThemes;
  //private String theme;  

  public static ThemeSwitcherBean getCI() {
    if (currentInstance == null) {
      currentInstance = new ThemeSwitcherBean();
    }
    return currentInstance;
  }

  public ThemeSwitcherBean() {
    super();
    advancedThemes = new ArrayList<Theme>();
    advancedThemes.add(new Theme("aristo", "aristo.png"));
    advancedThemes.add(new Theme("black-tie", "black-tie.png"));
    advancedThemes.add(new Theme("blitzer", "blitzer.png"));
    advancedThemes.add(new Theme("bluesky", "bluesky.png"));
    advancedThemes.add(new Theme("casablanca", "casablanca.png"));
    advancedThemes.add(new Theme("cupertino", "cupertino.png"));
    advancedThemes.add(new Theme("dark-hive", "dark-hive.png"));
    advancedThemes.add(new Theme("dot-luv", "dot-luv.png"));
    advancedThemes.add(new Theme("eggplant", "eggplant.png"));
    advancedThemes.add(new Theme("excite-bike", "excite-bike.png"));
    advancedThemes.add(new Theme("flick", "flick.png"));
    advancedThemes.add(new Theme("glass-x", "glass-x.png"));
    advancedThemes.add(new Theme("hot-sneaks", "hot-sneaks.png"));
    advancedThemes.add(new Theme("humanity", "humanity.png"));
    advancedThemes.add(new Theme("le-frog", "le-frog.png"));
    advancedThemes.add(new Theme("midnight", "midnight.png"));
    advancedThemes.add(new Theme("mint-choc", "mint-choc.png"));
    advancedThemes.add(new Theme("overcast", "overcast.png"));
    advancedThemes.add(new Theme("pepper-grinder", "pepper-grinder.png"));
    advancedThemes.add(new Theme("redmond", "redmond.png"));
    advancedThemes.add(new Theme("rocket", "rocket.png"));
    advancedThemes.add(new Theme("sam", "sam.png"));
    advancedThemes.add(new Theme("smoothness", "smoothness.png"));
    advancedThemes.add(new Theme("south-street", "south-street.png"));
    advancedThemes.add(new Theme("start", "start.png"));
    advancedThemes.add(new Theme("sunny", "sunny.png"));
    advancedThemes.add(new Theme("swanky-purse", "swanky-purse.png"));
    advancedThemes.add(new Theme("trontastic", "trontastic.png"));
    advancedThemes.add(new Theme("ui-darkness", "ui-darkness.png"));
    advancedThemes.add(new Theme("ui-lightness", "ui-lightness.png"));
    advancedThemes.add(new Theme("vader", "vader.png"));
  }
/*
  public Map<String, String> getThemes() {
    return themes;
  }
*/
  @PostConstruct
  public void init() {
/*
    themes = new TreeMap<String, String>();
    themes.put("Aristo", "aristo");
    themes.put("Black-Tie", "black-tie");
    themes.put("Blitzer", "blitzer");
    themes.put("Bluesky", "bluesky");
    themes.put("Casablanca", "casablanca");
    themes.put("Cupertino", "cupertino");
    themes.put("Dark-Hive", "dark-hive");
    themes.put("Dot-Luv", "dot-luv");
    themes.put("Eggplant", "eggplant");
    themes.put("Excite-Bike", "excite-bike");
    themes.put("Flick", "flick");
    themes.put("Glass-X", "glass-x");
    themes.put("Hot-Sneaks", "hot-sneaks");
    themes.put("Humanity", "humanity");
    themes.put("Le-Frog", "le-frog");
    themes.put("Midnight", "midnight");
    themes.put("Mint-Choc", "mint-choc");
    themes.put("Overcast", "overcast");
    themes.put("Pepper-Grinder", "pepper-grinder");
    themes.put("Redmond", "redmond");
    themes.put("Rocket", "rocket");
    themes.put("Sam", "sam");
    themes.put("Smoothness", "smoothness");
    themes.put("South-Street", "south-street");
    themes.put("Start", "start");
    themes.put("Sunny", "sunny");
    themes.put("Swanky-Purse", "swanky-purse");
    themes.put("Trontastic", "trontastic");
    themes.put("UI-Darkness", "ui-darkness");
    themes.put("UI-Lightness", "ui-lightness");
    themes.put("Vader", "vader");
*/
  }
/*
  public void saveTheme() {
    GuestPreferences gp_ = (GuestPreferences) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("guestPreferences");
    gp_.setTheme(theme);
  }
*/
  public List<Theme> getAdvancedThemes() {
    return advancedThemes;
  }

  public static void test1() {

  }

  public static Theme getThemeByName(String name_) {
    Theme res = null;
    List<Theme> advancedThemes = beans.ThemeSwitcherBean.getCI().getAdvancedThemes();
    for (int i = 0; i < advancedThemes.size(); i++) {
      if (advancedThemes.get(i).getName().equals(name_)) {
        res = advancedThemes.get(i);
        break;
      }
    }
    return res;
  }
}
