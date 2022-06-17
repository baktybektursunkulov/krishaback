package additional_classes.core.comparators;

import virtualentities.VE_I_Tbl_Row;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.core.dbtables.*;
import others.CustomLogger;

public class VE_I_Tbl_Row_Comparator implements Comparator<VE_I_Tbl_Row> {

  @Override
  public int compare(VE_I_Tbl_Row o1, VE_I_Tbl_Row o2) {
    int res = 0;
    try {
      res = o1.getLabel_translation().trim().compareTo(o2.getLabel_translation().trim());
    } catch (Exception ex) {
      CustomLogger.error(ex);
    }
    return res;
  }

}
