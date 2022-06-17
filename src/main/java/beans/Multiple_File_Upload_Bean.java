package beans;

import java.io.Serializable;import java.util.ArrayList;
import java.util.List;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

public class Multiple_File_Upload_Bean implements Serializable {

  private List<Single_File_Upload_Bean> file_list = new ArrayList<Single_File_Upload_Bean>();

  public List<Single_File_Upload_Bean> getFile_list() {
    return file_list;
  }

  public void setFile_list(List<Single_File_Upload_Bean> file_list) {
    this.file_list = file_list;
  }

  
  
  public void handleFileUpload(FileUploadEvent event) {
    UploadedFile uploadedFile = event.getFile();
    //CustomLogger.log("uploadedFile.getFileName()=" + uploadedFile.getFileName());
    //CustomLogger.log("uploadedFile.getContents()=" + event.getFile().getContents());
    Single_File_Upload_Bean file_ = new Single_File_Upload_Bean();
    file_.setFile_name(uploadedFile.getFileName());
    file_.setFile_body(uploadedFile.getContent());
    //CustomLogger.log("getFile_body()=" + file_.getFile_body());
    file_list.add(file_);
  }
  
  
}
