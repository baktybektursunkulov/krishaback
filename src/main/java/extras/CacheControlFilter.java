package extras;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CacheControlFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    int cacheAgeInSec = 30 * 1440 * 60 * 1000;// 1 месяц
    long expiry = new Date().getTime() + cacheAgeInSec * 1000;

    HttpServletResponse httpResponse = (HttpServletResponse) response;
    httpResponse.setDateHeader("Expires", expiry);
    httpResponse.setHeader("Cache-Control", "max-age=" + cacheAgeInSec);

    chain.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }
}
