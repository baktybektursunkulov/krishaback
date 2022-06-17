package managers.core.dbtables;

import additional_classes.Select_Item;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean
@ApplicationScoped
public class C_Theme_Manager extends Abstract_Controller_Manager<C_Theme> {

  private static C_Theme_Manager currentInstance = null;
  private List<Select_Item> themes;

  public static C_Theme_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Theme_Manager();
    }
    return currentInstance;
  }

  public C_Theme_Manager() {
    super(C_Theme.class);
  }

  @PostConstruct
  public void init() {
    themes = new ArrayList<>();
    themes.add(new Select_Item("nova-light", "Nova-Light"));
    themes.add(new Select_Item("nova-dark", "Nova-Dark"));
    themes.add(new Select_Item("nova-colored", "Nova-Colored"));
    themes.add(new Select_Item("luna-blue", "Luna-Blue"));
    themes.add(new Select_Item("luna-amber", "Luna-Amber"));
    themes.add(new Select_Item("luna-green", "Luna-Green"));
    themes.add(new Select_Item("luna-pink", "Luna-Pink"));
    themes.add(new Select_Item("omega", "Omega"));
  }

  public List<Select_Item> getThemes() {
    return themes;
  }

  public void setThemes(List<Select_Item> themes) {
    this.themes = themes;
  }

}
