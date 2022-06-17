package extras;

import java.io.IOException;
import java.util.EnumSet;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SessionTrackingMode;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gs.common.servlet.AttributeTools;

public class SessionIdFilter implements Filter {

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    //req.getServletContext().setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
    boolean do_work_ = false;
    if (do_work_) {
      HttpServletRequest http_servlet_req_ = (HttpServletRequest) req;
      //HttpServletResponse http_servlet_resp_ = (HttpServletResponse)resp;
      String url_ = http_servlet_req_.getRequestURL().toString() + (http_servlet_req_.getQueryString() != null ? "?"
        + http_servlet_req_.getQueryString() : "");;
      String jsessionid_ = "";
      if (url_.contains("jsessionid")) {
        jsessionid_ = url_.substring(url_.indexOf("jsessionid") + 10);
      }

      if (!jsessionid_.isEmpty()) {
        //Cookie[] cookie_arr_ = http_servlet_req_.getCookies();
        //cookie_arr_[cookie_arr_.length] = new Cookie("jsessionid", jsessionid_);   
        if (!req.getParameterMap().containsKey("jsessionid")) {
          req.getParameterMap().put("jsessionid", new String[]{jsessionid_});
        }
      }
    }

    //FacesContext facesContext = FacesContext.getCurrentInstance();
    //facesContext.get
    //facesContext.getExternalContext().
    //http_servlet_resp_.ad
    chain.doFilter(req, resp);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }
}
