package additional_classes;

import model.core.dbtables.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import gs.common.model.db.Abstract_Entity;
import managers.core.dbtables.*;
import org.hibernate.Session;

public class C_Loc_Collector implements Serializable {

  private C_Loc c_loc;

  public C_Loc_Collector() {

  }

  public C_Loc getC_loc() {
    return c_loc;
  }

  public void setC_loc(C_Loc c_loc) {
    this.c_loc = c_loc;
  }

  public String getC_loc__name() {
    return getC_loc() == null ? "" : getC_loc().getName();
  }

  public void setC_loc__name(String c_loc__name) {
  }

  public String getC_loc__calc_full_name() {
    return getC_loc() == null ? "" : getC_loc().getCalc_full_name();
  }

  public void setC_loc__calc_full_name(String c_loc__calc_full_name) {
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 89 * hash + Objects.hashCode(this.c_loc);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final C_Loc_Collector other = (C_Loc_Collector) obj;
    if (!Objects.equals(this.c_loc, other.c_loc)) {
      return false;
    }
    return true;
  }

}
