package others;

public class CustomRedisConsts {

  public static final String c_key__mileage_counter_task = "me_cr_t";
  public static final String c_key__motohour_counter_task = "mr_cr_t";
  //public static final String c_key__binding_driver_i_button_check_task = "bdibc_t";
  public static final String c_hash_key__object_prop = "h:object_prop";

  public static String get_mileage_counter_task_list_key() {
    return "l:" + c_key__mileage_counter_task;
  }

  public static String get_mileage_counter_task_set_key() {
    return "s:" + c_key__mileage_counter_task;
  }

  public static String get_motohour_counter_task_list_key() {
    return "l:" + c_key__motohour_counter_task;
  }

  public static String get_motohour_counter_task_set_key() {
    return "s:" + c_key__motohour_counter_task;
  }
/*
  public static String get_binding_driver_i_button_check_task_list_key() {
    return "l:" + c_key__binding_driver_i_button_check_task;
  }

  public static String get_binding_driver_i_button_check_task_set_key() {
    return "s:" + c_key__binding_driver_i_button_check_task;
  }
*/
}
