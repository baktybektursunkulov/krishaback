package others;

import beans.VariablesBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class CustomJRFuncs {

  public static Connection getReportConnection(String connection_url_, String connection_username_, String connection_password_,
    String connection_driver_class_) throws Exception {
    Class.forName(connection_driver_class_);
    String url = connection_url_;
    Properties props = new Properties();
    props.setProperty("user", connection_username_);
    props.setProperty("password", connection_password_);
    Connection connection_ = DriverManager.getConnection(url, props);
    connection_.setAutoCommit(false);
    return connection_;
  }

  public static Connection getReportConnection() throws Exception {
    Connection connection_ = getReportConnection(VariablesBean.getCI().getReport_db_connection_url(),
      VariablesBean.getCI().getReport_db_connection_username(), VariablesBean.getCI().getReport_db_connection_password(),
      VariablesBean.getCI().getReport_db_connection_driver_class());
    return connection_;
  }

  public static Connection getConnection() throws Exception {
    Connection connection_ = getReportConnection(VariablesBean.getCI().getDb_connection_url(),
      VariablesBean.getCI().getDb_connection_username(), VariablesBean.getCI().getDb_connection_password(),
      VariablesBean.getCI().getDb_connection_driver_class());
    return connection_;
  }
  
}
