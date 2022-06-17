package others;

import controllers.JSStrListController;
import org.primefaces.PrimeFaces;

public class pc_google_map_polyline_funcs {

  public static void mapPolylineArrMakeVisible(String map_, String polyline_arr_) {
    String js_str_;
    js_str_ = "mapPolylineArrMakeVisible(map_, polyline_arr_);";
    js_str_ = js_str_.replace("map_", map_);
    js_str_ = js_str_.replace("polyline_arr_", polyline_arr_);
    JSStrListController.getCurrentBean().add_js_str(PrimeFaces.current(), js_str_);
  }

  public static void mapPolylineArrMakeInvisible(String polyline_arr_) {
    String js_str_;
    js_str_ = "mapPolylineArrMakeInvisible(polyline_arr_);";
    js_str_ = js_str_.replace("polyline_arr_", polyline_arr_);
    JSStrListController.getCurrentBean().add_js_str(PrimeFaces.current(), js_str_);
  }

}
