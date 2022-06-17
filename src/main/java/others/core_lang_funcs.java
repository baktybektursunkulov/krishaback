package others;

import gs.services.core.dbtables.C_Lang_Service;

public class core_lang_funcs {

  public static String get_lang(C_Lang_Service c_Lang_Service) {
    if (c_Lang_Service == null) {
      return "ru";
    }
    String lang_ = c_Lang_Service.get_lang_from_request();
    if (lang_ == null) {
      return "ru";
    } else {
      return lang_;
    }
  }

}
