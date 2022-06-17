package beans;

import java.io.Serializable;
import gs.common.model.db.Abstract_Entity;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import managers.core.dbtables.C_Tbl_Oper_Manager;
import managers.core.dbtables.C_Tbl_Manager;
import model.core.dbtables.C_Tbl_Oper;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class Dlg_Tbl_Oper_List_Bean implements Serializable {

  private String c_tbl_code;
  private String c_tbl_name;
  private String rec_id;

  private List<C_Tbl_Oper> rec_list;
  private C_Tbl_Oper selected_record;
  private C_Tbl_Oper[] selected_record_list;

  public C_Tbl_Oper getSelected_record() {
    return selected_record;
  }

  public void setSelected_record(C_Tbl_Oper selected_record) {
    this.selected_record = selected_record;
  }

  public C_Tbl_Oper[] getSelected_record_list() {
    return selected_record_list;
  }

  public void setSelected_record_list(C_Tbl_Oper[] selected_record_list) {
    this.selected_record_list = selected_record_list;
  }

  public String getRec_id() {
    return rec_id;
  }

  public void setRec_id(String rec_id) {
    this.rec_id = rec_id;
  }

  public String getC_tbl_code() {
    return c_tbl_code;
  }

  public void setC_tbl_code(String c_tbl_code) {
    this.c_tbl_code = c_tbl_code;
  }

  public String getC_tbl_name() {
    if ((getC_tbl_code() == null) || (getC_tbl_code().isEmpty())) {
      return "";
    } else {
      return C_Tbl_Manager.getCI().get_rec_by_code(getC_tbl_code()).getName();
    }
  }

  public void setC_tbl_name(String c_tbl_name) {
    this.c_tbl_name = c_tbl_name;
  }

  @Override
  public String toString() {
    return "Dlg_Tbl_Oper_List_Bean{" + "c_tbl_code=" + c_tbl_code + ", c_tbl_name=" + c_tbl_name + ", rec_id=" + rec_id + ", rec_list=" + rec_list + ", selected_record=" + selected_record + ", selected_record_list=" + selected_record_list + '}';
  }

  public List<C_Tbl_Oper> getRec_list() {
//    refreshRecList();
    return this.rec_list;
  }

  public void setRec_list(List<C_Tbl_Oper> rec_list) {
    this.rec_list = rec_list;
  }

  public void refreshRecList() {
    //CustomLogger.log("c_tbl=" + getC_tbl_code());
    //CustomLogger.log("rec_id=" + getRec_id());
    rec_list = C_Tbl_Oper_Manager.get_tbl_oper_list_2(c_tbl_code, rec_id);
  }

  public void refreshRecList(String c_tbl_code_, String rec_id_) {
    this.c_tbl_code = c_tbl_code_;
    this.rec_id = rec_id_;
    CustomLogger.log("c_tbl=" + c_tbl_code_);
    CustomLogger.log("rec_id=" + rec_id_);
    rec_list = C_Tbl_Oper_Manager.get_tbl_oper_list_2(c_tbl_code_, rec_id_);
  }

  public void refreshRecList2(String c_tbl_code_, String rec_id_) {
    this.c_tbl_code = c_tbl_code_;
    this.rec_id = rec_id_;
    CustomLogger.log("c_tbl_code=" + c_tbl_code_);
    CustomLogger.log("rec_id=" + rec_id_);
    rec_list = C_Tbl_Oper_Manager.get_tbl_oper_list_2(c_tbl_code_, rec_id_);
  }

}
