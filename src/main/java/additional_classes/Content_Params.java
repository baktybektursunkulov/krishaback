package additional_classes;

import model.core.dbtables.C_Site;
import org.hibernate.Session;

public class Content_Params {

  public C_Site c_site;
  public String lang;
  
  public Content_Params(Session session_, C_Site c_site_, String lang_) {
    c_site = c_site_;
    lang = lang_;
  }
}
