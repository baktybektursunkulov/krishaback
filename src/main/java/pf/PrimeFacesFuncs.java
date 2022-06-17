package pf;

import gs.common.jsf.jsf_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import others.CustomLogger;

public class PrimeFacesFuncs implements Serializable {

  public static void dataTableScrollToRow(String component_id_, int row_index_) {
    DataTable dt_1_ = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(component_id_);
    Integer page_row_count_ = dt_1_.getRows();
    if (row_index_ >= page_row_count_) {
      return;
    }
    String js_str_;
    js_str_ = "var scrollHeight_ = jQuery('#jquery_component_id_ .ui-datatable-scrollable-body').prop('scrollHeight'); "
            + "var scroll_pos_ = (scrollHeight_ / page_row_count_) * row_num_; "
            + "jQuery('#jquery_component_id_ .ui-datatable-scrollable-body').scrollTop(scroll_pos_);";
    String jquery_component_id_ = component_id_.replace(":", "\\\\:");
    CustomLogger.log(jquery_component_id_);
    js_str_ = js_str_.replace("jquery_component_id_", jquery_component_id_);
    //js_str_ = js_str_.replace("component_id_", component_id_);
    js_str_ = js_str_.replace("row_num_", String.valueOf(row_index_));
    js_str_ = js_str_.replace("page_row_count_", page_row_count_.toString());
    CustomLogger.log(js_str_);
    primefaces_funcs.executeJS(js_str_);

  }

}
