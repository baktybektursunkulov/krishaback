package extras;

import beans.CUsrBean;
import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import others.CustomLogger;
import others.core_custom_funcs;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

  private ExceptionHandler parent;

  public CustomExceptionHandler(ExceptionHandler parent) {
    this.parent = parent;
  }

  @Override
  public ExceptionHandler getWrapped() {
    return this.parent;
  }

  @Override
  public void handle() throws FacesException {
    try {
      for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext();) {
        ExceptionQueuedEvent event = i.next();
        ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
        Throwable t = context.getException();
        CustomLogger.log("CustomExceptionHandler event=" + event + ", context=" + context + ", exception=" + t);
        CustomLogger.error_with_c_usr_login(CUsrBean.getCurrentBean().getLoggedCUsr(), t);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        String url_;
        if (t instanceof ViewExpiredException) {
          //ViewExpiredException vee = (ViewExpiredException) t;
          /*
          HttpSession session_ = CustomFuncs.getSession(facesContext);
          if (session_ != null) {
            session_.invalidate();
          }
           */

          //Map<String, Object> requestMap = facesContext.getExternalContext().getRequestMap();
          try {
            /*
          // Push some useful stuff to the request scope for use in the page
          requestMap.put("currentViewId", vee.getViewId());
          facesContext.getExternalContext().getFlash().put("expiredViewId", vee.getViewId());
          url_ = other_funcs.getRequestURL(facesContext);
          CustomLogger.log("url_=" + url_);
          //FacesContext.getCurrentInstance().getViewRoot().get

          url_ = CustomFuncs.getViewExpiredURLForRedirect(facesContext);
          //String js_str_;          
          //js_str_ = servlet_funcs.getAbsoluteContextPath(jsf_funcs.getRequest())+ "/client/" + url_;
          //mainJSStrListController.getCurrentBean().add_js_str(RequestContext.getCurrentInstance(), js_str_);
          //navigationHandler.handleNavigation(facesContext, null, url_);
          ExternalContext ec_ = facesContext.getExternalContext();
          try {
            ec_.redirect(url_);
          } catch (Exception e2) {
            CustomLogger.error(e2);
          }
          //facesContext.renderResponse();
             */
            gotoExpiredUrl(facesContext);
          } catch (Exception ex) {
            //CustomLogger.error(ex);
            //CustomLogger.log(other_funcs.stack2string(ex));
          }
        } else if (t instanceof Throwable) {
          Throwable t2 = (Throwable) t;

          //NavigationHandler nav = facesContext.getApplication().getNavigationHandler();
          /*
        if (VariablesBean.getCI().getIs_debug_mode()) {
          try {
            ErrorBean errorBean = ErrorBean.getErrorBean();
            if (errorBean == null) {
              errorBean = new ErrorBean();
            }
            errorBean.setMessage_text(other_funcs.stack2string(t2));
            errorBean.setCause_text(t2.getCause() == null ? "" : t2.getCause().toString());
            errorBean.setReturn_url(getRequestURL(facesContext));
            errorBean.setMain_url(CustomFuncs.getMainURL(facesContext));
            //t2.printStackTrace();
            CustomLogger.error(t2);
            url_ = CustomFuncs.getErrorURLForRedirect(facesContext);
            CustomLogger.log("url_=" + url_);
            //facesContext.getExternalContext().redirect(url_);
            //facesContext.renderResponse();
            //nav.handleNavigation(fc, null, url_);
            //facesContext.renderResponse();
            //CustomLogger.error(t2);
          } catch (Exception ex) {
            CustomLogger.error(ex);
          } finally {
            i.remove();
          }
        } else {
           */
          CustomLogger.log("t2.getMessage()=" + t2.getMessage());
          CustomLogger.error(t2);
          if (t2.getMessage() == null || (t2.getMessage().contains("Component ID") && t2.getMessage().contains("has already been found in the view"))) {
            // Component ID j_idt2 has already been found in the view.  
            /*
          HttpSession session_ = CustomFuncs.getSession(facesContext);
          if (session_ != null) {
            session_.invalidate();
          }
             */
            //url_ = CustomFuncs.getViewExpiredURLForRedirect(facesContext);
            //CustomLogger.log("url_=" + url_);
            try {
              /*
              HttpSession session_ = CustomFuncs.getSession(facesContext);
              if (session_ != null) {
                session_.invalidate();
              }
               */
              //facesContext.getExternalContext().redirect(url_);
              //facesContext.renderResponse();
              //CustomLogger.error(t2);
              gotoExpiredUrl(facesContext);
            } catch (Exception ex) {
              //CustomLogger.error(ex);
            }
          }
          i.remove();
        }
      }

      // At this point, the queue will not contain any ViewExpiredEvents.
      // Therefore, let the parent handle them.
      getWrapped().handle(); 
    } catch (Exception ex) {
      CustomLogger.error(ex);
    }
  }

  public void gotoExpiredUrl(FacesContext facesContext) throws Exception {
    CustomLogger.log("gotoExpiredUrl");
    String url_ = core_custom_funcs.getViewExpiredURLForRedirect(facesContext);
    //NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
    //navigationHandler.handleNavigation(facesContext, null, url_);
    //facesContext.renderResponse();

    // I commented below line, because when changing language redirects to view expired page
    // don't call JS with "location.href=", because it will call it on browser on any page, that user work at that moment, it is not correct
    //String js_str_ = "setTimeout('location.href=\"" + servlet_funcs.getAbsoluteContextPath(jsf_funcs.getHttpServletRequest()) + "/client/" + url_ + "\"', 60000);";
    //mainJSStrListController.getCurrentBean().add_js_str(js_str_);
    facesContext.getExternalContext().redirect(url_);
  }
}
