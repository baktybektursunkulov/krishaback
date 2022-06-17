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

public class RemoveSessionIdFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse res,
    FilterChain chain) throws IOException, ServletException {

    if (!(req instanceof HttpServletRequest)) {
      chain.doFilter(req, res);
      return;
    } 

    HttpServletRequest httpServletRequest = (HttpServletRequest) req;
    String url_ = httpServletRequest.getRequestURL().toString() + (httpServletRequest.getQueryString() != null ? "?"
      + httpServletRequest.getQueryString() : "");
    if (!url_.contains(";jsessionid=")) {
      chain.doFilter(req, res);
      return;
    }
    if (!url_.contains("/javax.faces.resource/components") && !url_.contains("/javax.faces.resource/jquery") && !url_.contains("/javax.faces.resource/core.js") 
      && !url_.contains("/javax.faces.resource/colorpicker") && !url_.contains("/javax.faces.resource/fileupload")
      && !url_.contains("/javax.faces.resource/inputnumber") && !url_.contains("/javax.faces.resource/scrollpanel")
      && !url_.contains("/get_img_converted_by_width;") && !url_.contains("/get_img_converted_by_height;")
      && !url_.contains("/get_img;")
      && !url_.contains("/images/") && !url_.contains("/css/") && !url_.contains("/js/") && !url_.contains("/docs/") && !url_.contains("/doc/")) {
      chain.doFilter(req, res);
      return;
    }

    //CustomLogger.log("Found url with jsession id in it:" + ((HttpServletRequest) req).getRequestURL());
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    // Redirect requests with JSESSIONID in URL to clean old links
    /* If you really want clean up some old links which have Jsession id bookmarked clean it. If its new app 
            this  below check is not required. */
 /*
    if (request.isRequestedSessionIdFromURL()) {
      String url = request.getRequestURL().append(request.getQueryString() != null ? "?"
        + request.getQueryString() : "").toString();
      response.setHeader("Location", url);
      response.sendError(HttpServletResponse.SC_MOVED_PERMANENTLY);
      CustomLogger.log("Found url with jsession id in it:" + request.getRequestURL() + ": url=" + url);
      return;
    }
     */
    String new_url_ = url_.substring(0, url_.indexOf(";jsessionid=")) + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
    response.setHeader("Location", new_url_);
    response.sendError(HttpServletResponse.SC_MOVED_PERMANENTLY);
    //CustomLogger.log("Found url with jsession id in it:" + request.getRequestURL() + ": new_url_=" + new_url_);
    return;

    /*
    // Prevent rendering of JSESSIONID in URLs for all outgoing links
    HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(
      response) {
      @Override
      public String encodeRedirectUrl(String url) {
        return url;
      }

      @Override
      public String encodeRedirectURL(String url) {
        return url;
      }

      @Override
      public String encodeUrl(String url) {
        return url;
      }

      @Override
      public String encodeURL(String url) {
        return url;
      }
    };

    chain.doFilter(req, wrappedResponse);
     */
  }

  public void destroy() {
  }

  public void init(FilterConfig arg0) throws ServletException {
  }
}
