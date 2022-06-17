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

public class C_Loc_Mass_Add_Collector implements Serializable {

  private String name;

  public C_Loc_Mass_Add_Collector() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 59 * hash + Objects.hashCode(this.name);
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
    final C_Loc_Mass_Add_Collector other = (C_Loc_Mass_Add_Collector) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    return true;
  }

}
