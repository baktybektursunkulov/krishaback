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

public class C_Dyn_Guide_Row_Collector implements Serializable {

  private String val;

  public C_Dyn_Guide_Row_Collector() {

  }

  public String getVal() {
    return val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 17 * hash + Objects.hashCode(this.val);
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
    final C_Dyn_Guide_Row_Collector other = (C_Dyn_Guide_Row_Collector) obj;
    if (!Objects.equals(this.val, other.val)) {
      return false;
    }
    return true;
  }

}
