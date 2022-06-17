package extras;

import beans.ApplicationBean;
import beans.VariablesBean;
import java.io.IOException;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.core.dbtables.C_Site;

public class RedirectToHttpsFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse res,
    FilterChain chain) throws IOException, ServletException {

    if (!(req instanceof HttpServletRequest)) {
      chain.doFilter(req, res);
      return;
    }

    HttpServletRequest httpServletRequest = (HttpServletRequest) req;
    String url_ = httpServletRequest.getRequestURL().toString() + (httpServletRequest.getQueryString() != null ? "?"
      + httpServletRequest.getQueryString() : "");
    if (!url_.contains("http:")) {
      chain.doFilter(req, res);
      return;
    }

    Map<String, C_Site> C_Site_map_with_expiration_ = ApplicationBean.getCI().getC_site_map_with_expiration();
    String domain_ = httpServletRequest.getServerName().toLowerCase();
    if (C_Site_map_with_expiration_.containsKey(domain_) && C_Site_map_with_expiration_.get(domain_).getUse_https() && !VariablesBean.getCI().getIs_test_mode()) {
      HttpServletResponse response = (HttpServletResponse) res;
      String new_url_ = url_.replace("http:", "https:");
      response.setHeader("Location", new_url_);
      response.setStatus(301); 
      response.setHeader("Connection", "close");
    } else { 
      chain.doFilter(req, res);
      return;
    }

  }

  public void destroy() {
  }

  public void init(FilterConfig arg0) throws ServletException {
  }
}
