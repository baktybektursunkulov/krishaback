package others;

import gs.common.MyException;
import java.util.List;
import org.codehaus.jettison.json.JSONObject;


public class JsonApiFuncs {
  static String c_parameter_1_not_specified = "Parameter '%1' not specified";
  static String c_parameter_1_is_not_filled = "Parameter '%1' is not filled";
  
  public static void check_on_fill(String str_, String var_name_) throws Exception {
    if (str_.isEmpty()) {
      throw new MyException(c_parameter_1_is_not_filled.replace("%1", var_name_));
    }
  }

  public static void check_on_fill(JSONObject params_json_obj_, String var_name_) throws Exception {
    if (params_json_obj_.has(var_name_)) {
      Object obj_ = params_json_obj_.get(var_name_);
      //CustomLogger.log("obj_=" + obj_);
      if (obj_ instanceof String && ((String) obj_).isEmpty()) {
        throw new MyException(c_parameter_1_is_not_filled.replace("%1", var_name_));
      }
    }
  }

  /*
   private void check_on_specify(String str_, String var_name_) throws Exception {
   if (str_.isEmpty()) {
   throw new MyException(c_parameter_1_not_specified.replace("%1", var_name_));
   }
   }
   */
  public static void check_on_specify(JSONObject params_json_obj_, String var_name_) throws Exception {
    if (!params_json_obj_.has(var_name_)) {
      throw new MyException(c_parameter_1_not_specified.replace("%1", var_name_));
    }
  }

  public static void check_on_specify_and_fill(JSONObject params_json_obj_, String var_name_) throws Exception {
    check_on_specify(params_json_obj_, var_name_);
    check_on_fill(params_json_obj_, var_name_);
  }
}
