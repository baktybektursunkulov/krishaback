package additional_classes;

import java.io.Serializable;

public class Obj_Col implements Serializable {

  public Integer obj_id;
  public String col_id;
  public String val;

  public Integer getObj_id() {
    return obj_id;
  }

  public void setObj_id(Integer obj_id) {
    this.obj_id = obj_id;
  }

  public String getCol_id() {
    return col_id;
  }

  public void setCol_id(String col_id) {
    this.col_id = col_id;
  }

  public String getVal() {
    return val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  public Obj_Col(Integer obj_id, String col_id) {
    this.obj_id = obj_id;
    this.col_id = col_id;
    this.val = null;
  }

  public Obj_Col(Integer obj_id, String col_id, String val) {
    this.obj_id = obj_id;
    this.col_id = col_id;
    this.val = val;
  }

}
