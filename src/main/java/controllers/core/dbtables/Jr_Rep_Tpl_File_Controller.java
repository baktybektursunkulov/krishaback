package controllers.core.dbtables;

import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import managers.core.dbtables.Jr_Rep_Tpl_File_Manager;
import org.hibernate.Session;import gs.common.hibernate_funcs;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@SessionScoped
public class Jr_Rep_Tpl_File_Controller extends Abstract_Controller<Jr_Rep_Tpl_File> {

  public Jr_Rep_Tpl_File_Controller() {
    super(Jr_Rep_Tpl_File.class, "jr_rep_tpl_file_list.xhtml", false);
  }

  public Jr_Rep_Tpl_File getJr_rep_tpl_file() {
    return getAbstract_entity();
  }

  private UploadedFile file;

  public UploadedFile getFile() {
    return file;
  }

  public void setFile(UploadedFile file) {
    this.file = file;
  }

  @Override
  protected void beforeInsertAndUpdateRec(Session session_) {
    if (getFile() == null) {
      jsf_funcs.addErrorMessage(bundle_funcs.getBundleValue("Fajl_ne_vybran"));
      return;
    }
  }

  @Override
  protected void insertRec(Session session_) {
    Jr_Rep_Tpl_File_Manager.getCI().load_jr_rep_tpl_file(session_, getJr_rep_tpl_file().getJr_rep_tpl_t_2(session_).getCode(), file.getContent(), file.getFileName());
  }

  @Override
  protected void updateRec(Session session_) {
    Jr_Rep_Tpl_File_Manager.getCI().load_jr_rep_tpl_file(session_, getJr_rep_tpl_file().getJr_rep_tpl_t_2(session_).getCode(), file.getContent(), file.getFileName());
  }

  public void handleFileUpload(FileUploadEvent event) {
    file = event.getFile();
  }
}
