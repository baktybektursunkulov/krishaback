package additional_classes;

import java.io.Serializable;
import gs.common.model.db.Abstract_Entity;
import java.util.Objects;

public class MessageParam implements Serializable {

  private String param_code;
  private String param_val;

  public MessageParam() {
  }

  public MessageParam(String param_code, String param_val) {
    this.param_code = param_code;
    this.param_val = param_val;
  }

  public String getParam_code() {
    return param_code;
  }

  public void setParam_code(String param_code) {
    this.param_code = param_code;
  }

  public String getParam_val() {
    return param_val;
  }

  public void setParam_val(String param_val) {
    this.param_val = param_val;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 19 * hash + Objects.hashCode(this.param_code);
    hash = 19 * hash + Objects.hashCode(this.param_val);
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
    final MessageParam other = (MessageParam) obj;
    if (!Objects.equals(this.param_code, other.param_code)) {
      return false;
    }
    if (!Objects.equals(this.param_val, other.param_val)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "EvtParam{" + "param_code=" + param_code + ", param_val=" + param_val + '}';
  }

}
