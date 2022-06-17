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

public class RedirectDocsFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse res,
    FilterChain chain) throws IOException, ServletException {

    if (!(req instanceof HttpServletRequest)) {
      chain.doFilter(req, res);
      return;
    }

    HttpServletRequest httpServletRequest = (HttpServletRequest) req;
    String url_ = httpServletRequest.getRequestURL().toString() + (httpServletRequest.getQueryString() != null ? "?"
      + httpServletRequest.getQueryString() : "");

    String new_url_ = "";
    if (url_.contains("/ts/docs/ru")) {
      new_url_ = url_.replace("/ts/docs/ru", "/ru/docs");
    } else if (url_.contains("/ts/docs/en")) {
      new_url_ = url_.replace("/ts/docs/en", "/en/docs");
    }
    if (new_url_.isEmpty()) {
      chain.doFilter(req, res);
      return;
    } else {
      HttpServletResponse response = (HttpServletResponse) res;
      response.setHeader("Location", new_url_);
      response.setStatus(301);
      response.setHeader("Connection", "close");
    }
  }

  public void destroy() {
  }

  public void init(FilterConfig arg0) throws ServletException {
  }
}
