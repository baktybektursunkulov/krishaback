package additional_classes;

import gs.common.servlet.servlet_funcs;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

public class MyHttpServletRequest implements Serializable {

  int serverPort;
  String serverName;
  String contextPath;
  String scheme;

  public MyHttpServletRequest(HttpServletRequest request) {
    this.serverPort = request.getServerPort();
    this.serverName = request.getServerName();
    this.contextPath = request.getContextPath();
    this.scheme = request.getScheme();
  }

  public int getServerPort() {
    return serverPort;
  }

  public void setServerPort(int serverPort) {
    this.serverPort = serverPort;
  }

  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }

  public String getContextPath() {
    return contextPath;
  }

  public void setContextPath(String contextPath) {
    this.contextPath = contextPath;
  }

  public String getScheme() {
    return scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

}
