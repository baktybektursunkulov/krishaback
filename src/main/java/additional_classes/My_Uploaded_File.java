package additional_classes;

import gs.common.image.image_funcs;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import model.core.dbtables.C_Img;
import org.hibernate.Session;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

public class My_Uploaded_File implements Serializable {

  //private UploadedFile uploadedFile;
  private String fileName;
  private byte[] content;
  private String contentType;
  private long size;

  private StreamedContent streamedContent;
  private byte[] streamedContentBody;

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public byte[] getContent() {
    return content;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public byte[] getStreamedContentBody() {
    return streamedContentBody;
  }

  public void setStreamedContentBody(byte[] streamedContentBody) {
    this.streamedContentBody = streamedContentBody;
  }

  public StreamedContent getStreamedContent() {
    FacesContext context = FacesContext.getCurrentInstance();
    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
      // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
      return new DefaultStreamedContent();
    } else {
      if (streamedContent == null) {
        streamedContent = new DefaultStreamedContent(new ByteArrayInputStream(getContent()));
      }
    }
    return streamedContent;
  }

  public StreamedContent getStreamedContent2(int img_max_width_, int img_max_height_) throws Exception {
    FacesContext context = FacesContext.getCurrentInstance();
    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
      // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
      return new DefaultStreamedContent();
    } else {
      // So, browser is requesting the image. Get ID value from actual request param.
      //if (streamedContent == null) {
      if (streamedContentBody == null) {
        byte[] byte_arr_ = getContent();
        byte_arr_ = image_funcs.get_img_by_max_w_and_h(byte_arr_, 100, 100);
        streamedContentBody = byte_arr_;
      }
      streamedContent = new DefaultStreamedContent(new ByteArrayInputStream(streamedContentBody));
      //}
    }
    //}
    return streamedContent;
  }

  public void setStreamedContent(StreamedContent streamedContent) {
    this.streamedContent = streamedContent;
  }

  public My_Uploaded_File(UploadedFile uploadedFile) {
    this.fileName = uploadedFile.getFileName();
    this.content = uploadedFile.getContent();
    this.contentType = uploadedFile.getContentType();
    this.size = uploadedFile.getSize();
  }

  public My_Uploaded_File(String fileName, byte[] content, String contentType) {
    this.fileName = fileName;
    this.content = content;
    this.contentType = contentType;
    this.size = this.content.length;
  }
  
  

  public My_Uploaded_File(Session session_, C_Img img) {
    this.fileName = img.getFile_name();
    this.content = img.getC_bin_file_body_t_2(session_).getFile_body();
    this.contentType = img.getContent_type();
    this.size = img.getSize();
  }

  /*
  public UploadedFile getUploadedFile() {
    return uploadedFile;
  }

  public void setUploadedFile(UploadedFile uploadedFile) {
    this.uploadedFile = uploadedFile;
  }
   */
}
