package additional_classes;

import com.jaspersoft.jasperserver.dto.common.validations.ValidationRule;
import com.jaspersoft.jasperserver.dto.reports.inputcontrols.InputControlState;
import gs.common.jsf.bundle_funcs;
import java.io.Serializable; import gs.common.model.db.Abstract_Entity;
import java.util.List;
import java.util.Objects;

public class JR_Report_Param implements Serializable{

  private String id;
  private String description;
  private String type;
  private String uri;
  private String label;
  private Boolean mandatory;
  private Boolean readOnly;
  private Boolean visible;
  private List<String> masterDependencies;
  private List<String> slaveDependencies;
  private List<ValidationRule> validationRules;
  private InputControlState state;
  private Object value;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Boolean isMandatory() {
    return mandatory;
  }

  public void setMandatory(Boolean mandatory) {
    this.mandatory = mandatory;
  }

  public Boolean isReadOnly() {
    return readOnly;
  }

  public void setReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
  }

  public Boolean isVisible() {
    return visible;
  }

  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  public List<String> getMasterDependencies() {
    return masterDependencies;
  }

  public void setMasterDependencies(List<String> masterDependencies) {
    this.masterDependencies = masterDependencies;
  }

  public List<String> getSlaveDependencies() {
    return slaveDependencies;
  }

  public void setSlaveDependencies(List<String> slaveDependencies) {
    this.slaveDependencies = slaveDependencies;
  }

  public List<ValidationRule> getValidationRules() {
    return validationRules;
  }

  public void setValidationRules(List<ValidationRule> validationRules) {
    this.validationRules = validationRules;
  }

  public InputControlState getState() {
    return state;
  }

  public void setState(InputControlState state) {
    this.state = state;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "JR_Report_Param{" + "id=" + id + ", description=" + description + ", type=" + type + ", uri=" + uri + ", label=" + label + ", mandatory=" + mandatory + ", readOnly=" + readOnly + ", visible=" + visible + ", masterDependencies=" + masterDependencies + ", slaveDependencies=" + slaveDependencies + ", validationRules=" + validationRules + ", state=" + state + '}';
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 89 * hash + Objects.hashCode(this.id);
    hash = 89 * hash + Objects.hashCode(this.description);
    hash = 89 * hash + Objects.hashCode(this.type);
    hash = 89 * hash + Objects.hashCode(this.uri);
    hash = 89 * hash + Objects.hashCode(this.label);
    hash = 89 * hash + Objects.hashCode(this.mandatory);
    hash = 89 * hash + Objects.hashCode(this.readOnly);
    hash = 89 * hash + Objects.hashCode(this.visible);
    hash = 89 * hash + Objects.hashCode(this.masterDependencies);
    hash = 89 * hash + Objects.hashCode(this.slaveDependencies);
    hash = 89 * hash + Objects.hashCode(this.validationRules);
    hash = 89 * hash + Objects.hashCode(this.state);
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
    final JR_Report_Param other = (JR_Report_Param) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    if (!Objects.equals(this.description, other.description)) {
      return false;
    }
    if (!Objects.equals(this.type, other.type)) {
      return false;
    }
    if (!Objects.equals(this.uri, other.uri)) {
      return false;
    }
    if (!Objects.equals(this.label, other.label)) {
      return false;
    }
    if (!Objects.equals(this.mandatory, other.mandatory)) {
      return false;
    }
    if (!Objects.equals(this.readOnly, other.readOnly)) {
      return false;
    }
    if (!Objects.equals(this.visible, other.visible)) {
      return false;
    }
    if (!Objects.equals(this.masterDependencies, other.masterDependencies)) {
      return false;
    }
    if (!Objects.equals(this.slaveDependencies, other.slaveDependencies)) {
      return false;
    }
    if (!Objects.equals(this.validationRules, other.validationRules)) {
      return false;
    }
    if (!Objects.equals(this.state, other.state)) {
      return false;
    }
    return true;
  }

}
