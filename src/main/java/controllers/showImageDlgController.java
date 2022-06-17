package controllers;

import gs.common.image.image_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.other_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import others.CustomLogger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class showImageDlgController implements Serializable {

  private StreamedContent streamedContent;
  private byte[] streamedContentBody;
  private Integer max_width;
  private Integer max_height;

  public Integer getMax_width() {
    return max_width;
  }

  public Integer getMax_height() {
    return max_height;
  }

  public StreamedContent getStreamedContent() {
    FacesContext context = FacesContext.getCurrentInstance();
    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
      // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
      return new DefaultStreamedContent();
    } else {
      streamedContent = new DefaultStreamedContent(new ByteArrayInputStream(streamedContentBody));
    }
    return streamedContent;
  }

  public static showImageDlgController getCurrentBean() {
    return jsf_funcs.findBean(other_funcs.getBeanName(showImageDlgController.class));
  }

  public void openDialog(byte[] byte_arr_, int max_width_, int max_height_) {
    try {
      streamedContentBody = image_funcs.get_img_by_max_w_and_h(byte_arr_, max_width_, max_height_);
      this.max_width = image_funcs.getImageWidth(streamedContentBody);
      this.max_height = image_funcs.getImageHeight(streamedContentBody);
      showDialog();
    } catch (Exception e) {
      CustomLogger.error(e);
      jsf_funcs.addErrorMessage(e);
    }
  }

  public void showDialog() {
    primefaces_funcs.executeJS("PF('wv_show_image_dlg').show();");
  }

  public void hideDialog() {
    primefaces_funcs.executeJS("PF('wv_show_image_dlg').hide();");
  }
}
