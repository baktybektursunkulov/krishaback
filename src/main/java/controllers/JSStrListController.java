package controllers;

import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class JSStrListController implements Serializable {
  
  LinkedList<String> js_str_list = new LinkedList<String>();
  
  public LinkedList<String> getJs_str_list() {
    return js_str_list;
  }
  
  public void setJs_str_list(LinkedList<String> js_str_list) {
    this.js_str_list = js_str_list; 
  }
  
  public void add_js_str(PrimeFaces primeFaces, String js_str_) {
    CustomLogger.log("add_js_str: " + js_str_);
    //primefaces_funcs.executeJS(requestContext_, js_str_);
    js_str_list.addLast(js_str_);
  }
  
  public void add_js_str(String js_str_) {
    CustomLogger.log("add_js_str: " + js_str_);
    //primefaces_funcs.executeJS(requestContext_, js_str_);
    js_str_list.addLast(js_str_);
  }
  
  
  public void add_js_str_list(PrimeFaces primeFaces, List<String> js_str_list_) {
    CustomLogger.log("add_js_str_list: " + js_str_list_);
    for (int i = 0; i < js_str_list_.size(); i++) {
      add_js_str(primeFaces, js_str_list_.get(i));
    }
    //js_str_list.addLast(js_str_);
  }
  
  public static JSStrListController getCurrentBean() {
    JSStrListController controller_ = jsf_funcs.findBean(other_funcs.getBeanName(JSStrListController.class));
    if (controller_ == null) {
      controller_ = new JSStrListController();
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(other_funcs.getBeanName(JSStrListController.class), controller_);
    }    
    return controller_;
  }

  public static JSStrListController getCurrentBean(HttpSession session_) {
    JSStrListController controller_ = (JSStrListController) session_.getAttribute(other_funcs.getBeanName(JSStrListController.class));
    if (controller_ == null) {
      controller_ = new JSStrListController();
      session_.setAttribute(other_funcs.getBeanName(JSStrListController.class), controller_);
    }    
    return controller_;
  }
  
  @Override
  public String toString() {
    return "JSStrListController{" + "js_str_list=" + js_str_list + '}';
  }
  
  
}
