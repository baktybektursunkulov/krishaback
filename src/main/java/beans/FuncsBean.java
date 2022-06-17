package beans;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import others.CustomLogger;
import gs.common.MetricConversionConstants;
import javax.faces.context.ExternalContext;

@ManagedBean
@ApplicationScoped
public class FuncsBean implements Serializable {

  private static FuncsBean currentInstance = null;

  public static FuncsBean getCI() {
    if (currentInstance == null) {
      currentInstance = new FuncsBean();
    }
    return currentInstance;
  }

  public Long convertStringToLong(String str_) {
    if (str_ == null) {
      return null;
    }
    return Long.valueOf(str_);
  }

  public Integer convertStringToInteger(String str_) {
    if (str_ == null) {
      return null;
    }
    return Integer.valueOf(str_);
  }

  public String getImageURLForBoolean(Boolean bool_) {
    if ((bool_ == null) || (bool_ == false)) {
      return "images/icon-no.gif";
    } else {
      return "images/icon-yes.gif";
    }
  }

  public String convertBooleanToImageURL(Boolean bool_) {
    if ((bool_ == null) || (bool_ == false)) {
      return "images/icon-no.gif";
    } else {
      return "images/icon-yes.gif";
    }
  }

  public String getTest(boolean bool_) {
    return "";
  }

  public boolean stringEquals(String str1_, String str2_) {
    return str1_.equalsIgnoreCase(str2_);
  }

  public StreamedContent bytesToImageStreamedContent(byte[] bytes) {
    StreamedContent res = null;
    if (bytes == null) {
      return null;
    }
    //InputStream is = new ByteArrayInputStream(bytes);
    //res = new DefaultStreamedContent(is, "image/jpeg");
    res = new DefaultStreamedContent(new ByteArrayInputStream(bytes), "image/jpeg");
    CustomLogger.log("bytesToImageStreamedContent res=" + res);
    return res;
  }

  public String dateToStr(Date date_, SimpleDateFormat sdf_) {
    if (date_ == null) {
      return "";
    }
    return sdf_.format(date_);
  }

}
