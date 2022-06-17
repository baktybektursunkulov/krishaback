package beans;

import java.io.Serializable;
import gs.common.model.db.Abstract_Entity;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import managers.core.dbtables.C_Tbl_Rec_File_Manager;
import managers.core.dbtables.C_Tbl_Manager;
import model.core.dbtables.C_Tbl_Rec_File;
import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import gs.common.Consts;
import managers.core.dbtables.C_Bin_File_Body_Manager;
import model.core.dbtables.C_Bin_File_Body;
import others.CustomLogger;

@ManagedBean
@SessionScoped
public class FileUploadControllerBean implements Serializable {

  private Logger logger = LoggerFactory.getLogger(FileUploadControllerBean.class);

  public void handleFileUpload(FileUploadEvent event) {
    try {
      String file_name_ = event.getFile().getFileName();
      String utf_file_name_ = "";
      //byte[] b = file_name_.getBytes("UTF-8");
      utf_file_name_ = new String(file_name_.getBytes(), "UTF-8");
      //utf_file_name_ = new String(b);

      logger.info("Uploaded: {}", utf_file_name_);
      CustomLogger.log(utf_file_name_);

      Map<String, Object> map_ = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
      FileUploadBean fileUploadBean_ = (FileUploadBean) map_.get("fileUploadBean");
      CustomLogger.log("fileUploadBean_=" + fileUploadBean_);

      java.util.Date now_ = new java.util.Date();
      C_Tbl_Rec_File rec_ = new C_Tbl_Rec_File();
      rec_.setC_tbl(fileUploadBean_.getC_tbl_id());
      rec_.setRec_id(fileUploadBean_.getRec_id());
      rec_.setFile_name(utf_file_name_);
      rec_.setIns_dt(now_);
      rec_.setIs_manually_added(true);
      rec_.setUser_name(fileUploadBean_.getUser_name());

      C_Bin_File_Body bin_file_body_;
      bin_file_body_ = new C_Bin_File_Body();
      bin_file_body_.setFile_body(event.getFile().getContent());
      C_Bin_File_Body_Manager.getCI().insert_rec(bin_file_body_);

      rec_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      rec_.setIs_deleted(false);
      CustomLogger.log("rec_=" + rec_);
      C_Tbl_Rec_File_Manager.getCI().insert_rec(rec_);

      FacesMessage msg = new FacesMessage(utf_file_name_ + " is uploaded.");
      FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
      FacesMessage msg = new FacesMessage(gs.common.other_funcs.stack2string(e));
      FacesContext.getCurrentInstance().addMessage(null, msg);
      CustomLogger.error(e);
    }
  }

//  public void handleFileUpload(org.primefaces.event.FileUploadEvent event) {  
//    CustomLogger.log("handleFileUpload 555");
//    logger.info("Uploaded: {}", event.getFile().getFileName());  
//
//    FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
//    FacesContext.getCurrentInstance().addMessage(null, msg);  
//  }  
//  public void listener(FileUploadEvent event) throws Exception {
//    UploadedFile item = event.getUploadedFile();
////    UploadedImage file = new UploadedImage();
////    file.setLength(item.getData().length);
////    file.setName(item.getName());
////    file.setData(item.getData());
//    logger.info("Uploaded: {}", item.getName());  
//    
//    //files.add(file);
//  }
}
