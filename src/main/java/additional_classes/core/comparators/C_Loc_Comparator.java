package additional_classes.core.comparators;

import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.core.dbtables.*;
import others.CustomLogger;

public class C_Loc_Comparator implements Comparator<C_Loc> {

  @Override
  public int compare(C_Loc o1, C_Loc o2) {
    int res = 0;
    try {
      res = o1.getName_translation().trim().compareTo(o2.getName_translation().trim());
    } catch (Exception ex) {
      CustomLogger.error(ex);
    }
    return res;
  }

}
