package others;

import gs.common.logdb.LogDB_Ins_Thread;
import gs.common.logdb.dbtables.Lg_App;
import gs.common.logdb.dbtables.Lg_App_Host;
import gs.common.logdb.dbtables.Lg_App_Path;
import gs.common.logdb.managers.Lg_App_Host_Manager;
import gs.common.logdb.managers.Lg_App_Manager;
import gs.common.logdb.managers.Lg_App_Path_Manager;
import gs.common.logdb.managers.Lg_Log_Lvl_Manager;
import gs.common.other_funcs;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class CustomLogDBFuncs {

  private static Lg_App lg_app;
  private static Lg_App_Path lg_app_path;
  private static Lg_App_Host lg_app_host;

  public static Lg_App getLg_app() {
    if (lg_app == null) {
      lg_app = Lg_App_Manager.getCI().get_or_insert("core-web");
    }
    return lg_app;
  }

  public static Lg_App getLg_app__mobile_app_gts4b() {
    if (lg_app == null) {
      lg_app = Lg_App_Manager.getCI().get_or_insert("Mobile app GTS4B");
    }
    return lg_app;
  }

  public static Lg_App_Path getLg_app_path() {
    if (lg_app_path == null) {
      lg_app_path = Lg_App_Path_Manager.getCI().get_or_insert(System.getProperty("user.dir"));
    }
    return lg_app_path;
  }

  public static Lg_App_Host getLg_app_host() throws UnknownHostException {
    if (lg_app_host == null) {
      lg_app_host = Lg_App_Host_Manager.getCI().get_or_insert(InetAddress.getLocalHost().getHostName());
    }
    return lg_app_host;
  }

  public static void SendToLog(Level level_, String s_, Lg_App lg_app_) {
    JSONObject log_params_ = new JSONObject();
    /*
    try {
      //log_params_.put("port", port_);
    } catch (JSONException ex) {
      ex.printStackTrace();
    }
*/
    try {
      LogDB_Ins_Thread.add(new Date(), s_, log_params_, Lg_Log_Lvl_Manager.getCI().get_or_insert(level_.getName().toLowerCase()), lg_app_, getLg_app_path(), getLg_app_host());
    } catch (UnknownHostException ex) {
      
    }
  }

}
