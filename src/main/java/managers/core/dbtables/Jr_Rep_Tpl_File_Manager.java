package managers.core.dbtables;

import gs.common.byte_funcs;
import gs.common.hibernate_funcs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.SQL_Where_Condition;
import java.io.FileInputStream;
import java.util.List;
import model.core.dbutil.CoreSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import others.CustomLogger;

@ManagedBean
@ApplicationScoped
public class Jr_Rep_Tpl_File_Manager extends Abstract_Controller_Manager<Jr_Rep_Tpl_File> {

  private static Jr_Rep_Tpl_File_Manager currentInstance = null;

  public static Jr_Rep_Tpl_File_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new Jr_Rep_Tpl_File_Manager();
    }
    return currentInstance;
  }

  public Jr_Rep_Tpl_File_Manager() {
    super(Jr_Rep_Tpl_File.class);
  }

  public Jr_Rep_Tpl_File get_jr_rep_tpl_file(Integer jr_rep_tpl_id_) {
    List<Jr_Rep_Tpl_File> list_ = get_rec_list_6_c(new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()), true);
    return (list_ == null || list_.isEmpty() ? null : list_.get(0));
  }

  public Jr_Rep_Tpl_File get_jr_rep_tpl_file(Session session_, Integer jr_rep_tpl_id_) {
    List<Jr_Rep_Tpl_File> list_ = get_rec_list_6_1_c(session_, new SQL_Where_Condition("jr_rep_tpl.jr_rep_tpl", "=", jr_rep_tpl_id_.toString()), true);
    return (list_ == null || list_.isEmpty() ? null : list_.get(0));
  }

  public void load_jr_rep_tpl_file(String jr_rep_tpl_code_, byte[] file_body_) {
    Jr_Rep_Tpl jr_rep_tpl_ = Jr_Rep_Tpl_Manager.getCI().get_rec_by_code_with_cache(jr_rep_tpl_code_);
    Jr_Rep_Tpl_File jr_rep_tpl_file_ = get_jr_rep_tpl_file(jr_rep_tpl_.getJr_rep_tpl());
    if (jr_rep_tpl_file_ == null) {
      jr_rep_tpl_file_ = new Jr_Rep_Tpl_File();
      jr_rep_tpl_file_.setJr_rep_tpl(jr_rep_tpl_.getJr_rep_tpl());

      C_Bin_File_Body bin_file_body_;
      bin_file_body_ = new C_Bin_File_Body();
      bin_file_body_.setFile_body(file_body_);
      C_Bin_File_Body_Manager.getCI().insert_rec(bin_file_body_);

      jr_rep_tpl_file_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      Jr_Rep_Tpl_File_Manager.getCI().insert_rec(jr_rep_tpl_file_);
    } else {
      C_Bin_File_Body bin_file_body_ = C_Bin_File_Body_Manager.getCI().get_rec(jr_rep_tpl_file_.getC_bin_file_body());
      bin_file_body_.setFile_body(file_body_);
      C_Bin_File_Body_Manager.getCI().update_rec(bin_file_body_);

      jr_rep_tpl_file_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      Jr_Rep_Tpl_File_Manager.getCI().update_rec(jr_rep_tpl_file_);
    }
  }

  public void load_jr_rep_tpl_file(String jr_rep_tpl_code_, byte[] file_body_, String file_name_) {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      load_jr_rep_tpl_file(session_, jr_rep_tpl_code_, file_body_, file_name_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public void load_jr_rep_tpl_file(Session session_, String jr_rep_tpl_code_, byte[] file_body_, String file_name_) {
    Jr_Rep_Tpl jr_rep_tpl_ = Jr_Rep_Tpl_Manager.getCI().get_rec_by_code_with_cache(session_, jr_rep_tpl_code_);
    Jr_Rep_Tpl_File jr_rep_tpl_file_ = get_jr_rep_tpl_file(session_, jr_rep_tpl_.getJr_rep_tpl());
    if (jr_rep_tpl_file_ == null) {
      jr_rep_tpl_file_ = new Jr_Rep_Tpl_File();
      jr_rep_tpl_file_.setJr_rep_tpl(jr_rep_tpl_.getJr_rep_tpl());

      C_Bin_File_Body bin_file_body_;
      bin_file_body_ = new C_Bin_File_Body();
      bin_file_body_.setFile_body(file_body_);
      session_.save(bin_file_body_);

      jr_rep_tpl_file_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      jr_rep_tpl_file_.setChange_dt(new java.util.Date());
      jr_rep_tpl_file_.setFile_name(file_name_);
      Jr_Rep_Tpl_File_Manager.getCI().insert_rec(session_, jr_rep_tpl_file_);
    } else {
      C_Bin_File_Body bin_file_body_ = C_Bin_File_Body_Manager.getCI().get_rec(jr_rep_tpl_file_.getC_bin_file_body());
      bin_file_body_.setFile_body(file_body_);
      C_Bin_File_Body_Manager.getCI().update_rec(session_, bin_file_body_);
      
      jr_rep_tpl_file_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
      jr_rep_tpl_file_.setChange_dt(new java.util.Date());
      jr_rep_tpl_file_.setFile_name(file_name_);
      Jr_Rep_Tpl_File_Manager.getCI().update_rec(session_, jr_rep_tpl_file_);
    }
  }

  public void load_jr_rep_tpl_file(Session session_, String jr_rep_tpl_code_, String file_path_) throws Exception {
    FileInputStream fis_ = new FileInputStream(file_path_);
    java.io.File file_ = new java.io.File(file_path_);
    byte[] byte_arr_ = byte_funcs.convertInputStreamToByteArr(fis_);
    load_jr_rep_tpl_file(session_, jr_rep_tpl_code_, byte_arr_, file_.getName());
  }

  public void load_jr_rep_tpl_file(String jr_rep_tpl_code_, String file_path_) throws Exception {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      load_jr_rep_tpl_file(session_, jr_rep_tpl_code_, file_path_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public Jr_Rep_Tpl_File get_jr_rep_tpl_file(Session session_, String file_name_) {
    List<Jr_Rep_Tpl_File> list_ = get_rec_list_6_1_c(session_, new SQL_Where_Condition("file_name='" + file_name_ + "'"), true);
    return (list_ == null || list_.isEmpty() ? null : list_.get(0));
  }
}
