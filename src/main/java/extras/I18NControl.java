package extras;

import gs.common.locale_funcs;
import java.io.IOException;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import managers.core.dbtables.C_Res_Bundle_Manager;

public class I18NControl extends Control {

  /*
  private List<C_Res_Bundle> v3_res_bundle_list = null;

  public I18NControl(List<C_Res_Bundle> v3_res_bundle_list_) {
    this.v3_res_bundle_list = v3_res_bundle_list_;
  }
   */
  //private Logger logger = LoggerFactory.getLogger(I18NControl.class);
  @Override
  public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
    if ((baseName == null) || (locale == null) || (format == null) || (loader == null)) {
      throw new NullPointerException();
    }
    ListResourceBundle listResourceBundle = new MyResources(baseName, locale);
    //C_Res_Bundle_Manager.resource_bundle_list.add(listResourceBundle);
    return listResourceBundle;
  }
/*
  @Override
  public long getTimeToLive(String arg0, Locale arg1) {
    return TTL_DONT_CACHE;
  }

  @Override
  public boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle, long loadTime) {
    System.err.println(baseName + "_" + locale + " - " + new Date(loadTime));
    return true;
  }
*/
  protected class MyResources extends ListResourceBundle {

    private String baseName;
    private Locale locale;

    public MyResources(String baseName, Locale locale) {
      this.baseName = baseName;
      this.locale = locale;
    }

    @Override
    protected Object[][] getContents() {
      Object[][] res = new Object[0][2];
      if (C_Res_Bundle_Manager.c_res_bundle_map == null) {
        return res;
      } else {
        res = C_Res_Bundle_Manager.c_res_bundle_map.get(baseName + "_" + locale_funcs.getLanguageTag(locale));
        if (res == null) {
          return new Object[0][2];
        }
      } 
      return res;
    }
  }
}
