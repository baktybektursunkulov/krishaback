package controllers.core.dbtables;

import beans.Single_File_Upload_Bean;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
@ManagedBean
@ViewScoped
public class File_Controller extends Abstract_Controller<C_File> {
  
  private Single_File_Upload_Bean single_file_upload_bean = new Single_File_Upload_Bean();

  public Single_File_Upload_Bean getSingle_file_upload_bean() {
    return single_file_upload_bean;
  }

  public void setSingle_file_upload_bean(Single_File_Upload_Bean single_file_upload_bean) {
    this.single_file_upload_bean = single_file_upload_bean;
  }
  
  public File_Controller() {
    super(C_File.class, "file_list.xhtml", false);
  }
  
  public C_File getFile() {
    return getAbstract_entity();
  }
  
   @Override
  protected void afterLoadDefaultRec() {
    setAbstract_entity(new C_File());
    single_file_upload_bean.setFile_body(null);
    single_file_upload_bean.setFile_name(null);
  }

  
  @Override
  protected void beforeInsertRec(Session session_) {
    if (single_file_upload_bean.getFile_body() != null) {
      getFile().setFile_name(single_file_upload_bean.getFile_name());
      //getFile().setFile_body(single_file_upload_bean.getFile_body());
      getFile().setVersion(1);
    }
  }

  @Override
  protected void afterLoadRec() {
    //single_file_upload_bean.setFile_body(getFile().getFile_body());
    single_file_upload_bean.setFile_name(getFile().getFile_name());
  }

  @Override
  protected void beforeUpdateRec() {
    if (single_file_upload_bean.getFile_body() != null) {
      //getFile().setFile_body(single_file_upload_bean.getFile_body());
      getFile().setFile_name(single_file_upload_bean.getFile_name());
      getFile().setVersion(getFile().getVersion() + 1);
    }
  }

}
