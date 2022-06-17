package additional_classes;


public class URL_Param {
  private String param_name;
  private String[] param_val;

  public String getParam_name() {
    return param_name;
  }

  public void setParam_name(String param_name) {
    this.param_name = param_name;
  }

  public String[] getParam_val() {
    return param_val;
  }

  public void setParam_val(String[] param_val) {
    this.param_val = param_val;
  }

  public URL_Param(String param_name, String[] param_val) {
    this.param_name = param_name;
    this.param_val = param_val;
  }
  
  public URL_Param(String param_name, String param_val) {
    this.param_name = param_name;
    String[] str_arr_ = new String[1];
    str_arr_[0] = param_val;
    this.param_val = str_arr_;
  }
}
