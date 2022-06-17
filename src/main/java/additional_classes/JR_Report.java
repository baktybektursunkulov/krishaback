package additional_classes;

import gs.common.jsf.bundle_funcs;
import java.io.Serializable;import java.util.LinkedList;
import java.util.Objects;
import model.core.dbtables.C_Usr;
import others.CustomJRFuncs;
import others.CustomJRReportFuncs;
import others.CustomLogger;

public class JR_Report implements Serializable {

  private Integer id = 0;
  private String label;
  private String name;
  private String description;
  private String uri;
  private LinkedList<JR_Report_Param> jr_report_param_list;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getName() {
    if (name == null) {
      name = bundle_funcs.getBundleValue(getDescription());
    }
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public LinkedList<JR_Report_Param> getJr_report_param_list(C_Usr logged_c_usr_) {
    if (jr_report_param_list == null) {
      try {
        jr_report_param_list = CustomJRReportFuncs.get_jr_report_param_list(this, logged_c_usr_);
      } catch (Exception ex) {
        //Logger.getLogger(JR_Report.class.getName()).log(Level.SEVERE, null, ex);
        CustomLogger.error(ex);
      }
    }
    return jr_report_param_list;
  }

  public void setJr_report_param_list(LinkedList<JR_Report_Param> jr_report_param_list) {
    this.jr_report_param_list = jr_report_param_list;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 31 * hash + Objects.hashCode(this.label);
    hash = 31 * hash + Objects.hashCode(this.name);
    hash = 31 * hash + Objects.hashCode(this.description);
    hash = 31 * hash + Objects.hashCode(this.uri);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final JR_Report other = (JR_Report) obj;
    if (!Objects.equals(this.label, other.label)) {
      return false;
    }
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.description, other.description)) {
      return false;
    }
    if (!Objects.equals(this.uri, other.uri)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "JR_Report{" + "label=" + label + ", name=" + name + ", description=" + description + ", uri=" + uri + '}';
  }

}
