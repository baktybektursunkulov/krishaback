package additional_classes.core.comparators;

import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.core.dbtables.*;
import others.CustomLogger;

public class C_Lang_Comparator implements Comparator<C_Lang> {

  @Override
  public int compare(C_Lang o1, C_Lang o2) {
    int res = 0;
    try {
      res = o1.getName().trim().compareTo(o2.getName().trim());
    } catch (Exception ex) {
      CustomLogger.error(ex);
    }
    return res;
  }

}
