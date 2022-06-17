package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import gs.common.jsf.jsf_funcs;

@ManagedBean
@SessionScoped
public class ErrorBean implements Serializable {

  String message_text;
  String cause_text;
  String return_url;
  String main_url;

  public String getMessage_text() {
    return message_text;
  }

  public void setMessage_text(String message_text) {
    this.message_text = message_text;
  }

  public String getCause_text() {
    return cause_text;
  }

  public void setCause_text(String cause_text) {
    this.cause_text = cause_text;
  }

  public String getReturn_url() {
    return return_url;
  }

  public void setReturn_url(String return_url) {
    this.return_url = return_url;
  }

  public String getMain_url() {
    return main_url;
  }

  public void setMain_url(String main_url) {
    this.main_url = main_url;
  }

  public static ErrorBean getErrorBean() {
    return jsf_funcs.findBean("errorBean");
  }
}
