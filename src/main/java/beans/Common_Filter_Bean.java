package beans;

import gs.common.jsf.bundle_funcs;
import java.io.Serializable; import gs.common.model.db.Abstract_Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ApplicationScoped
public class Common_Filter_Bean implements Serializable {

  private ArrayList<SelectItem> row_cnt_per_page_list = new ArrayList<SelectItem>();
  private ArrayList<SelectItem> sort_field_order_list = new ArrayList<SelectItem>();

  public Common_Filter_Bean() {
  }

  public ArrayList<SelectItem> getRow_cnt_per_page_list() {
    row_cnt_per_page_list = new ArrayList<SelectItem>();
    row_cnt_per_page_list.add(new SelectItem("10", "10"));
    row_cnt_per_page_list.add(new SelectItem("20", "20"));
    row_cnt_per_page_list.add(new SelectItem("50", "50"));
    row_cnt_per_page_list.add(new SelectItem("100", "100"));
    row_cnt_per_page_list.add(new SelectItem("1000", "1000"));
    row_cnt_per_page_list.add(new SelectItem("1000000", bundle_funcs.getBundleValue("Vse")));
    return row_cnt_per_page_list;
  }

  public void setRow_cnt_per_page_list(ArrayList<SelectItem> row_cnt_per_page_list) {
    this.row_cnt_per_page_list = row_cnt_per_page_list;
  }

  public ArrayList<SelectItem> getSort_field_order_list() {
    sort_field_order_list = new ArrayList<SelectItem>();
    sort_field_order_list.add(new SelectItem("asc", bundle_funcs.getBundleValue("Po_vozrastaniju")));
    sort_field_order_list.add(new SelectItem("desc", bundle_funcs.getBundleValue("Po_ubyvaniju")));
    return sort_field_order_list;
  }

  public void setSort_field_order_list(ArrayList<SelectItem> sort_field_order_list) {
    this.sort_field_order_list = sort_field_order_list;
  }
}
