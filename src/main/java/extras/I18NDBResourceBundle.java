package extras;

import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;
import managers.core.dbtables.C_Res_Bundle_Manager;

public class I18NDBResourceBundle extends ResourceBundle {

  /*
  public DBResourceBundle() {
    System.out.println(getLocale());
  }
   */
  public I18NDBResourceBundle(String baseName, final Locale locale) {
    ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, locale, new I18NControl());
    //C_Res_Bundle_Manager.resource_bundle_list.add(resourceBundle);
    setParent(resourceBundle); 
  }

  @Override
  protected Object handleGetObject(String key) {
    return parent.getObject(key);
  }

  @Override
  public Enumeration getKeys() {
    return parent.getKeys();
  }
}
