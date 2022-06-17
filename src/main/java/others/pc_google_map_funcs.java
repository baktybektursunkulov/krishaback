package others;

import controllers.JSStrListController;
import java.util.List;
import org.primefaces.PrimeFaces;

public class pc_google_map_funcs {

  public static void mapSetCenterByLatLon(JSStrListController mainJSStrListController_, String map_, Double lat_, Double lon_) {
    mapSetCenterByLatLon(PrimeFaces.current(), mainJSStrListController_, map_, lat_, lon_);
  }

  public static void mapSetCenterByLatLon(PrimeFaces primeFaces, JSStrListController mainJSStrListController_, String map_, Double lat_, Double lon_) {
    if (lat_ == null || lat_ == 0 || lon_ == null || lon_ == 0) {
      return;
    }
    String js_str_;
    js_str_ = "mapSetCenterByLatLon(map_, lat_, lon_);";
    js_str_ = js_str_.replace("map_", map_);
    js_str_ = js_str_.replace("lat_", lat_.toString());
    js_str_ = js_str_.replace("lon_", lon_.toString());
    mainJSStrListController_.add_js_str(primeFaces, js_str_);
  }

  public static void mapSetMapTypeId(String map_, String mapTypeId) {
    if (mapTypeId == null || mapTypeId.isEmpty()) {
      return;
    }
    String js_str_;
    js_str_ = "mapSetMapTypeId(map_, mapTypeId);";
    js_str_ = js_str_.replace("map_", map_);
    js_str_ = js_str_.replace("mapTypeId", "'" + mapTypeId + "'");
    JSStrListController.getCurrentBean().add_js_str(PrimeFaces.current(), js_str_);
  }

  public static void mapFitBounds(JSStrListController mainJSStrListController_, String map_, List<Lat_Lng> lat_lng_list_) {
    mapFitBounds(PrimeFaces.current(), mainJSStrListController_, map_, lat_lng_list_);
  }

  public static void mapFitBounds(PrimeFaces primeFaces, JSStrListController mainJSStrListController_, String map_, List<Lat_Lng> lat_lng_list_) {
    if (lat_lng_list_ == null) {
      return;
    }
    String js_str_;
    String var_name_ = "temp_LatLngBounds_" + System.currentTimeMillis() + "_";

    create_LatLngBounds_variable(primeFaces, mainJSStrListController_, lat_lng_list_, var_name_);

    js_str_ = "mapFitBounds(" + map_ + ", " + var_name_ + ");";
    mainJSStrListController_.add_js_str(primeFaces, js_str_);

    js_str_ = var_name_ + " = null;";
    mainJSStrListController_.add_js_str(primeFaces, js_str_);
  }

  public static void mapFitBoundsV2(PrimeFaces primeFaces, JSStrListController mainJSStrListController_, String map_, List<Lat_Lng> lat_lng_list_) {
    if (lat_lng_list_ == null) {
      return;
    }
    String js_str_;
    String var_name_ = "temp_LatLngBounds_" + System.currentTimeMillis() + "_";

    create_LatLngBounds_variable(primeFaces, mainJSStrListController_, lat_lng_list_, var_name_);

    js_str_ = "mapFitBoundsV2(" + map_ + ", " + var_name_ + ");";
    mainJSStrListController_.add_js_str(primeFaces, js_str_);

    js_str_ = var_name_ + " = null;";
    mainJSStrListController_.add_js_str(primeFaces, js_str_);
  }
  
  public static void create_LatLngBounds_variable(JSStrListController mainJSStrListController_, List<Lat_Lng> lat_lng_list_, String js_var_name_) {
    create_LatLngBounds_variable(PrimeFaces.current(), mainJSStrListController_, lat_lng_list_, js_var_name_);
  }

  public static void create_LatLngBounds_variable(PrimeFaces primeFaces, JSStrListController mainJSStrListController_, List<Lat_Lng> lat_lng_list_, String js_var_name_) {
    if (lat_lng_list_ == null) {
      return;
    }
    String js_str_;
    js_str_ = js_var_name_ + " = new google.maps.LatLngBounds();";
    mainJSStrListController_.add_js_str(primeFaces, js_str_);

    for (Lat_Lng lat_lng_ : lat_lng_list_) {
      js_str_ = js_var_name_ + ".extend(new google.maps.LatLng(lat_, lng_));";
      js_str_ = js_str_.replace("lat_", lat_lng_.getLat().toString());
      js_str_ = js_str_.replace("lng_", lat_lng_.getLng().toString());
      mainJSStrListController_.add_js_str(primeFaces, js_str_);
    }

  }
}
