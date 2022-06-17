package beans;

import java.io.ByteArrayInputStream;
import java.io.Serializable;import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import others.CustomLogger;

public class Single_File_Upload_Bean implements Serializable {

  private byte[] file_body;
  private String file_name;

  public byte[] getFile_body() {
    return file_body;
  }

  public void setFile_body(byte[] file_body) {
    this.file_body = file_body;
  }

  public String getFile_name() {
    return file_name;
  }

  public void setFile_name(String file_name) {
    this.file_name = file_name;
  }
  
  

  public StreamedContent getFile_body_image() {
    StreamedContent res = null;
    if (getFile_body() == null) {
      return null;
    }
    res = new DefaultStreamedContent(new ByteArrayInputStream(getFile_body()), "image/jpeg");
    CustomLogger.log("res=" + res);
    return res;
  }

  public void handleFileUpload(FileUploadEvent event) {
    UploadedFile uploadedFile = event.getFile();
    //CustomLogger.log("uploadedFile.getFileName()=" + uploadedFile.getFileName());
    //CustomLogger.log("uploadedFile.getContents()=" + event.getFile().getContents());
    setFile_name(uploadedFile.getFileName());
    setFile_body(uploadedFile.getContent());
    //CustomLogger.log("getFile_body()=" + getFile_body());
  }
}
