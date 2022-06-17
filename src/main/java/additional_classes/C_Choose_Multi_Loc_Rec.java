
package additional_classes;

import java.io.Serializable;
import java.util.List;
import model.core.dbtables.C_Loc;


public class C_Choose_Multi_Loc_Rec implements Serializable {
  public List<C_Loc> list;
  public List<C_Loc> list_selected_record_list;
  public C_Loc list_active_record;
  public C_Loc parent;

  public List<C_Loc> getList() {
    return list;
  }

  public void setList(List<C_Loc> list) {
    this.list = list;
  }

  public List<C_Loc> getList_selected_record_list() {
    return list_selected_record_list;
  }

  public void setList_selected_record_list(List<C_Loc> list_selected_record_list) {
    this.list_selected_record_list = list_selected_record_list;
  }

  public C_Loc getList_active_record() {
    return list_active_record;
  }

  public void setList_active_record(C_Loc list_active_record) {
    this.list_active_record = list_active_record;
  }

  
  
  public C_Loc getParent() {
    return parent;
  }

  public void setParent(C_Loc parent) {
    this.parent = parent;
  }
  
  
}
