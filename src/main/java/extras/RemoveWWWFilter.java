package extras;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import others.CustomLogger;

public class RemoveWWWFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse res,
    FilterChain chain) throws IOException, ServletException {

    if (!(req instanceof HttpServletRequest)) {
      chain.doFilter(req, res);
      return;
    }

    HttpServletRequest httpServletRequest = (HttpServletRequest) req;
    String url_ = httpServletRequest.getRequestURL().toString() + (httpServletRequest.getQueryString() != null ? "?"
      + httpServletRequest.getQueryString() : "");
    if (!url_.contains("www.")) {
      chain.doFilter(req, res);
      return;
    }

    //HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    String new_url_ = url_.substring(0, url_.indexOf("www.")) + url_.substring(url_.indexOf("www.") + 4);
    response.setHeader("Location", new_url_);
    response.setStatus(301);
    response.setHeader("Connection", "close");
  }

  public void destroy() {
  }

  public void init(FilterConfig arg0) throws ServletException {
  }
}
