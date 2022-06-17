package additional_classes;

import java.io.Serializable; import gs.common.model.db.Abstract_Entity;

public class Select_Item implements Serializable {

    private Object value;
    private String label;

    public Select_Item() {
    }

    public Select_Item(Object value, String label) {
        this.value = value;
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Select_Item{" + "value=" + value + ", label=" + label + '}';
    }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 83 * hash + (this.value != null ? this.value.hashCode() : 0);
    hash = 83 * hash + (this.label != null ? this.label.hashCode() : 0);
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
    final Select_Item other = (Select_Item) obj;
    if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
      return false;
    }
    if ((this.label == null) ? (other.label != null) : !this.label.equals(other.label)) {
      return false;
    }
    return true;
  }


}
