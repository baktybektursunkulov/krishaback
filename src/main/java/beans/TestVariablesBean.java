package beans;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class TestVariablesBean implements Serializable {
 
  static TestVariablesBean currentInstance;
  String dt_user_mode_current_page = c_id_tab_reports;
  //String dt_user_mode_js = "getById('id_tv_l:id_form_main_tasks:id_cb_ins').click();";
  String dt_user_mode_js = ""; 
  String dt_manager_mode_current_page = "id_tab_objects";
  String dt_manager_mode_js = ""; 
  String mob_current_page = "id_tab_monitoring"; 
  String mob_js = "";   
  boolean is_turn_on_all_functions = true;
  boolean is_load_monitoring = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_monitoring");
  boolean is_check_new_messages = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_monitoring");
  boolean is_check_other_events = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_notifications");
  boolean is_load_tracks = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_tracks");
  boolean is_load_messages = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_messages");
  boolean is_load_poi = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_poi");
  boolean is_load_gz = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_gz");
  boolean is_load_reports = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_reports");
  boolean is_load_users = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_users");
  boolean is_load_objects = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_objects");
  boolean is_load_object_grps = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_object_grps");
  boolean is_load_reports_setup = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_reports_setup");
  boolean is_load_maint = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_maint");
  boolean is_load_sites = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_sites");
  boolean is_load_usr_tariffs = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_usr_tariffs");
  boolean is_load_usr_bal_ops = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_usr_bal_ops");
  boolean is_load_usr_day_ops = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_usr_day_ops");
  boolean is_load_obj_tariffs = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_obj_tariffs");
  boolean is_load_obj_bal_ops = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_obj_bal_ops");
  boolean is_load_obj_day_ops = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_obj_day_ops");
  boolean is_load_test_port = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_test_port");
  boolean is_load_tasks = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_tasks");
  boolean is_load_notifications = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_notifications");
  boolean is_load_drivers = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_drivers");
  boolean is_load_clients = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_clients");
  boolean is_load_waybills = is_turn_on_all_functions || false || dt_user_mode_current_page.equals("id_tab_waybills");
  /*
  boolean is_load_map_type = false;
  boolean is_load_map_layers = false;
   */
  boolean is_load_theme = is_turn_on_all_functions || false;
  boolean is_load_services = is_turn_on_all_functions || false;
  boolean is_load_map = is_load_monitoring || is_check_new_messages || is_check_other_events || is_load_tracks || is_load_messages || is_load_poi || is_load_gz || is_load_reports || is_load_drivers || true;
  boolean is_load_time = is_turn_on_all_functions || false;
  boolean is_load_user_menu = is_turn_on_all_functions || true;

  public static final String c_id_tab_monitoring = "id_tab_monitoring";
  public static final String c_id_tab_tracks = "id_tab_tracks";
  public static final String c_id_tab_messages = "id_tab_messages";
  public static final String c_id_tab_poi = "id_tab_poi";
  public static final String c_id_tab_gz = "id_tab_gz";
  public static final String c_id_tab_reports = "id_tab_reports";
  public static final String c_id_tab_users = "id_tab_users";
  public static final String c_id_tab_objects = "id_tab_objects";
  public static final String c_id_tab_object_grps = "id_tab_object_grps";
  public static final String c_id_tab_reports_setup = "id_tab_reports_setup";
  public static final String c_id_tab_maint = "id_tab_maint";
  public static final String c_id_tab_sites = "id_tab_sites";
  public static final String c_id_tab_usr_tariffs = "id_tab_usr_tariffs";
  public static final String c_id_tab_usr_bal_ops = "id_tab_usr_bal_ops";
  public static final String c_id_tab_usr_day_ops = "id_tab_usr_day_ops";
  public static final String c_id_tab_obj_tariffs = "id_tab_obj_tariffs";
  public static final String c_id_tab_obj_bal_ops = "id_tab_obj_bal_ops";
  public static final String c_id_tab_obj_day_ops = "id_tab_obj_day_ops";
  public static final String c_id_tab_test_port = "id_tab_test_port";
  public static final String c_id_tab_tasks = "id_tab_tasks";
  public static final String c_id_tab_notifications = "id_tab_notifications";
  public static final String c_id_tab_drivers = "id_tab_drivers";
  public static final String c_id_tab_clients = "id_tab_clients";
  public static final String c_id_tab_waybills = "id_tab_waybills";

  public static TestVariablesBean getCI() {
    if (currentInstance == null) {
      currentInstance = new TestVariablesBean();
    }
    return currentInstance;
  }

  public String getMob_current_page() {
    return mob_current_page;
  }

  public void setMob_current_page(String mob_current_page) {
    this.mob_current_page = mob_current_page;
  }

  public String getMob_js() {
    return mob_js;
  }

  public void setMob_js(String mob_js) {
    this.mob_js = mob_js;
  }

  public boolean getIs_turn_on_all_functions() {
    return is_turn_on_all_functions;
  }

  public void setIs_turn_on_all_functions(boolean is_turn_on_all_functions) {
    this.is_turn_on_all_functions = is_turn_on_all_functions;
  }

  public String getDt_user_mode_current_page() {
    return dt_user_mode_current_page;
  }

  public void setDt_user_mode_current_page(String dt_user_mode_current_page) {
    this.dt_user_mode_current_page = dt_user_mode_current_page;
  }

  public String getDt_user_mode_js() {
    return dt_user_mode_js;
  }

  public void setDt_user_mode_js(String dt_user_mode_js) {
    this.dt_user_mode_js = dt_user_mode_js;
  }

  public String getDt_manager_mode_current_page() {
    return dt_manager_mode_current_page;
  }

  public void setDt_manager_mode_current_page(String dt_manager_mode_current_page) {
    this.dt_manager_mode_current_page = dt_manager_mode_current_page;
  }

  public String getDt_manager_mode_js() {
    return dt_manager_mode_js;
  }

  public void setDt_manager_mode_js(String dt_manager_mode_js) {
    this.dt_manager_mode_js = dt_manager_mode_js;
  }

  public boolean getIs_load_monitoring() {
    return is_load_monitoring;
  }

  public void setIs_load_monitoring(boolean is_load_monitoring) {
    this.is_load_monitoring = is_load_monitoring;
  }

  public boolean getIs_check_new_messages() {
    return is_check_new_messages;
  }

  public void setIs_check_new_messages(boolean is_check_new_messages) {
    this.is_check_new_messages = is_check_new_messages;
  }

  public boolean getIs_check_other_events() {
    return is_check_other_events;
  }

  public void setIs_check_other_events(boolean is_check_other_events) {
    this.is_check_other_events = is_check_other_events;
  }

  public boolean getIs_load_tracks() {
    return is_load_tracks;
  }

  public void setIs_load_tracks(boolean is_load_tracks) {
    this.is_load_tracks = is_load_tracks;
  }

  public boolean getIs_load_messages() {
    return is_load_messages;
  }

  public void setIs_load_messages(boolean is_load_messages) {
    this.is_load_messages = is_load_messages;
  }

  public boolean getIs_load_poi() {
    return is_load_poi;
  }

  public void setIs_load_poi(boolean is_load_poi) {
    this.is_load_poi = is_load_poi;
  }

  public boolean getIs_load_gz() {
    return is_load_gz;
  }

  public void setIs_load_gz(boolean is_load_gz) {
    this.is_load_gz = is_load_gz;
  }

  public boolean getIs_load_reports() {
    return is_load_reports;
  }

  public void setIs_load_reports(boolean is_load_reports) {
    this.is_load_reports = is_load_reports;
  }

  public boolean getIs_load_users() {
    return is_load_users;
  }

  public void setIs_load_users(boolean is_load_users) {
    this.is_load_users = is_load_users;
  }

  public boolean getIs_load_objects() {
    return is_load_objects;
  }

  public void setIs_load_objects(boolean is_load_objects) {
    this.is_load_objects = is_load_objects;
  }

  public boolean getIs_load_object_grps() {
    return is_load_object_grps;
  }

  public void setIs_load_object_grps(boolean is_load_object_grps) {
    this.is_load_object_grps = is_load_object_grps;
  }

  public boolean getIs_load_reports_setup() {
    return is_load_reports_setup;
  }

  public void setIs_load_reports_setup(boolean is_load_reports_setup) {
    this.is_load_reports_setup = is_load_reports_setup;
  }

  public boolean getIs_load_maint() {
    return is_load_maint;
  }

  public void setIs_load_maint(boolean is_load_maint) {
    this.is_load_maint = is_load_maint;
  }

  public boolean getIs_load_sites() {
    return is_load_sites;
  }

  public void setIs_load_sites(boolean is_load_sites) {
    this.is_load_sites = is_load_sites;
  }

  public boolean getIs_load_usr_tariffs() {
    return is_load_usr_tariffs;
  }

  public void setIs_load_usr_tariffs(boolean is_load_usr_tariffs) {
    this.is_load_usr_tariffs = is_load_usr_tariffs;
  }

  public boolean getIs_load_usr_bal_ops() {
    return is_load_usr_bal_ops;
  }

  public void setIs_load_usr_bal_ops(boolean is_load_usr_bal_ops) {
    this.is_load_usr_bal_ops = is_load_usr_bal_ops;
  }

  public boolean getIs_load_usr_day_ops() {
    return is_load_usr_day_ops;
  }

  public void setIs_load_usr_day_ops(boolean is_load_usr_day_ops) {
    this.is_load_usr_day_ops = is_load_usr_day_ops;
  }

  public boolean getIs_load_obj_tariffs() {
    return is_load_obj_tariffs;
  }

  public void setIs_load_obj_tariffs(boolean is_load_obj_tariffs) {
    this.is_load_obj_tariffs = is_load_obj_tariffs;
  }

  public boolean getIs_load_obj_bal_ops() {
    return is_load_obj_bal_ops;
  }

  public void setIs_load_obj_bal_ops(boolean is_load_obj_bal_ops) {
    this.is_load_obj_bal_ops = is_load_obj_bal_ops;
  }

  public boolean getIs_load_obj_day_ops() {
    return is_load_obj_day_ops;
  }

  public void setIs_load_obj_day_ops(boolean is_load_obj_day_ops) {
    this.is_load_obj_day_ops = is_load_obj_day_ops;
  }

  public boolean getIs_load_test_port() {
    return is_load_test_port;
  }

  public void setIs_load_test_port(boolean is_load_test_port) {
    this.is_load_test_port = is_load_test_port;
  }

  public boolean getIs_load_tasks() {
    return is_load_tasks;
  }

  public void setIs_load_tasks(boolean is_load_tasks) {
    this.is_load_tasks = is_load_tasks;
  }

  public boolean getIs_load_notifications() {
    return is_load_notifications;
  }

  public void setIs_load_notifications(boolean is_load_notifications) {
    this.is_load_notifications = is_load_notifications;
  }

  public boolean getIs_load_drivers() {
    return is_load_drivers;
  }

  public void setIs_load_drivers(boolean is_load_drivers) {
    this.is_load_drivers = is_load_drivers;
  }

  public boolean getIs_load_clients() {
    return is_load_clients;
  }

  public void setIs_load_clients(boolean is_load_clients) {
    this.is_load_clients = is_load_clients;
  }

  public boolean getIs_load_waybills() {
    return is_load_waybills;
  }

  public void setIs_load_waybills(boolean is_load_waybills) {
    this.is_load_waybills = is_load_waybills;
  }

  /*
  public boolean getIs_load_map_type() {
    return is_load_map_type;
  }

  public void setIs_load_map_type(boolean is_load_map_type) {
    this.is_load_map_type = is_load_map_type;
  }

  public boolean getIs_load_map_layers() {
    return is_load_map_layers;
  }

  public void setIs_load_map_layers(boolean is_load_map_layers) {
    this.is_load_map_layers = is_load_map_layers;
  }
   */
  public boolean getIs_load_theme() {
    return is_load_theme;
  }

  public void setIs_load_theme(boolean is_load_theme) {
    this.is_load_theme = is_load_theme;
  }

  public boolean getIs_load_services() {
    return is_load_services;
  }

  public void setIs_load_services(boolean is_load_services) {
    this.is_load_services = is_load_services;
  }

  public boolean getIs_load_map() {
    return is_load_map;
  }

  public void setIs_load_map(boolean is_load_map) {
    this.is_load_map = is_load_map;
  }

  public boolean getIs_load_time() {
    return is_load_time;
  }

  public void setIs_load_time(boolean is_load_time) {
    this.is_load_time = is_load_time;
  }

  public boolean getIs_load_user_menu() {
    return is_load_user_menu;
  }

  public void setIs_load_user_menu(boolean is_load_user_menu) {
    this.is_load_user_menu = is_load_user_menu;
  }

}
