package additional_classes.core.comparators;

import java.util.Comparator;
import model.core.dbtables.*;
import others.CustomLogger;

public class C_Dyn_Guide_Row_Comparator implements Comparator<C_Dyn_Guide_Row> {

  @Override
  public int compare(C_Dyn_Guide_Row o1, C_Dyn_Guide_Row o2) {
    int res = 0;
    try {
      res = o1.getVal_translation().trim().compareTo(o2.getVal_translation().trim());
    } catch (Exception ex) {
      CustomLogger.error(ex);
    }
    return res;
  }

}
