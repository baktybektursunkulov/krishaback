package others;

import beans.VariablesBean;
import controllers.JSStrListController;
import gs.common.MyException;
import gs.common.byte_funcs;
import gs.common.jr_funcs;
import static gs.common.jr_funcs.setPDFProps;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.locale_funcs;
import gs.common.tz_funcs;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.http.HttpSession;
import managers.core.dbtables.Jr_Rep_Tpl_File_Manager;
import managers.core.dbtables.Jr_Rep_Tpl_Manager;
import model.core.dbtables.Jr_Rep;
import model.core.dbtables.Jr_Rep_Tpl;
import model.core.dbtables.Jr_Rep_Tpl_Param;
import model.core.dbtables.C_Usr;
import model.core.dbutil.CoreSessionFactoryUtil;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.hibernate.Session;import gs.common.hibernate_funcs;
import managers.core.dbtables.C_Tbl_Manager;
import managers.core.dbtables.C_Tbl_Rec_File_Manager;
import model.core.dbtables.C_Bin_File_Body;
import model.core.dbtables.C_Tbl_Rec_File;
import org.hibernate.Transaction;
import org.primefaces.PrimeFaces;
import static others.CustomJRRepFuncs.runReport;

public class CustomJRRepTplFuncs {

  public static String runReport(C_Usr C_Usr_, Jr_Rep_Tpl jr_rep_tpl_, String format_str_, String parent_element_id_, boolean is_attachment_, ResourceBundle bundle_, HttpSession http_session_, Connection connection_) throws Exception {
    String res;
    //Transaction tx_ = null;
    //Session session_ = SessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = runReport(session_, C_Usr_, jr_rep_tpl_, format_str_, parent_element_id_, is_attachment_, bundle_, http_session_, connection_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (session_.getTransaction() != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static String runReport(Session core_session_, C_Usr C_Usr_, Jr_Rep_Tpl jr_rep_tpl_, String format_str_, String parent_element_id_, boolean is_attachment_,
    ResourceBundle bundle_, HttpSession http_session_, Connection connection_) throws Exception {
    String res = "";

    byte[] file_body_ = null;
    try {
      file_body_ = runReport(core_session_, C_Usr_, jr_rep_tpl_, format_str_, bundle_, http_session_, connection_);
    } catch (MyException e) {
      res = e.getMessage();
      return res;
    }

    java.util.Date now_ = new java.util.Date();
    C_Tbl_Rec_File rec_ = new C_Tbl_Rec_File();
    rec_.setC_tbl_t(C_Tbl_Manager.getCI().get_rec(core_session_, "report"));
    rec_.setRec_id((long)C_Usr_.getC_usr());
    String extension_;
    extension_ = format_str_.toLowerCase();
    rec_.setFile_name(jr_rep_tpl_.getCode() + "_" + String.valueOf(now_.getTime() + "." + extension_));
    rec_.setIns_dt(now_);
    rec_.setIs_manually_added(false);
    rec_.setUser_name(C_Usr_.getName());
    
    C_Bin_File_Body bin_file_body_;
    bin_file_body_ = new C_Bin_File_Body();
    bin_file_body_.setFile_body(file_body_);
    core_session_.save(bin_file_body_);
    
    rec_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
    rec_.setIs_deleted(false);
    CustomLogger.log("rec_=" + rec_);
    C_Tbl_Rec_File_Manager.getCI().insert_rec(core_session_, rec_);

    long object_file_id_ = rec_.getC_tbl_rec_file();
    String url_ = "open_tbl_rec_file?id=" + object_file_id_ + "&is_delete=true" + (is_attachment_ ? "&is_attachment=true" : "");
    if (format_str_.equals("HTML") && !is_attachment_) {
      //hibernate_funcs.commitAndClose(session_);
      //core_session_.beginTransaction();

      String iframe_html_ = "<iframe id='id_iframe_report_results' name='iframe_report_results' src='" + url_ + "' width='100%' height='500px' frameborder='0' scrolling='auto'>Vash_brauzer_ne_podderzhivaet_frejmy</iframe>";
      JSStrListController.getCurrentBean().add_js_str(PrimeFaces.current(), "var el_ = document.getElementById(\"" + parent_element_id_ + "\"); el_.innerHTML = ''; el_.innerHTML = \"" + iframe_html_ + "\";");
    } else {
      JSStrListController.getCurrentBean().add_js_str(PrimeFaces.current(), "var new_win_ = window.open('" + url_ + "', '_blank'); new_win_.focus();");
    }
    return res;
  }

  public static byte[] runReport(Session core_session_, C_Usr C_Usr_, Jr_Rep_Tpl jr_rep_tpl_, String format_str_, ResourceBundle bundle_, HttpSession http_session_, Connection connection_) throws Exception {
    byte[] res = null;
    String lang_ = locale_funcs.getLanguageTag(bundle_.getLocale());
    HashMap report_params_ = new HashMap();
    Jr_Rep_Tpl_Param jr_rep_tpl_param_;
    Date tmp_date_;
    Integer tmp_integer_;
    String tmp_string_;
    String err_msg_;
    for (int i = 0; i < jr_rep_tpl_.getJr_rep_tpl_param_list().size(); i++) {
      jr_rep_tpl_param_ = jr_rep_tpl_.getJr_rep_tpl_param_list().get(i);
      if (!jr_rep_tpl_param_.getIs_visible()) {
        continue;
      }
      if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("Timestamp")) {
        tmp_date_ = (Date) jr_rep_tpl_param_.getValue();
        if (jr_rep_tpl_param_.getIs_required() && tmp_date_ == null) {
          err_msg_ = bundle_funcs.getBundleValue(bundle_, "Pole_%1_javljaetsja_objazatelnym");
          err_msg_ = err_msg_.replace("%1", jr_rep_tpl_param_.getName_translation_3(core_session_, lang_));
          throw new MyException(err_msg_);
        }
        report_params_.put(jr_rep_tpl_param_.getCode(), new java.sql.Timestamp(tmp_date_.getTime()));
      } else if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("Integer")) {
        if (jr_rep_tpl_param_.getValue() instanceof Integer) {
          tmp_integer_ = (Integer) jr_rep_tpl_param_.getValue();
        } else if (jr_rep_tpl_param_.getValue() instanceof String) {
          tmp_integer_ = Integer.valueOf((String) jr_rep_tpl_param_.getValue());
        } else {
          tmp_string_ = (String) jr_rep_tpl_param_.getValue();
          if (tmp_string_ == null) {
            tmp_integer_ = null;
          } else {
            tmp_integer_ = Integer.valueOf(tmp_string_);
          }
        }
        if (jr_rep_tpl_param_.getIs_required() && (tmp_integer_ == null || tmp_integer_ == 0)) {
          err_msg_ = bundle_funcs.getBundleValue(bundle_, "Pole_%1_javljaetsja_objazatelnym");
          err_msg_ = err_msg_.replace("%1", jr_rep_tpl_param_.getName_translation_3(core_session_, lang_));
          throw new MyException(err_msg_);
        }
        /*
        if (jr_rep_tpl_param_.getCode().equals("obj_id") && tmp_integer_ != null && tmp_integer_ != 0) {
          V3_Obj v3_obj_ = V3_Obj_Manager.getCI().get_rec(core_session_, tmp_integer_);
          if (!v3_obj_.getHas_right_request_messages_and_reports_3(core_session_, C_Usr_)) {
            err_msg_ = bundle_funcs.getBundleValue("U_vas_net_prav_na_vypolnenie_dannoj_operacii");
            throw new MyException(err_msg_);
          }
        }
        */
        report_params_.put(jr_rep_tpl_param_.getCode(), tmp_integer_);
      } else if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("String")) {
        tmp_string_ = (String) jr_rep_tpl_param_.getValue();
        if (jr_rep_tpl_param_.getIs_required() && (tmp_string_ == null || tmp_string_.isEmpty())) {
          err_msg_ = bundle_funcs.getBundleValue(bundle_, "Pole_%1_javljaetsja_objazatelnym");
          err_msg_ = err_msg_.replace("%1", jr_rep_tpl_param_.getName_translation_3(core_session_, lang_));
          throw new MyException(err_msg_);
        }
        report_params_.put(jr_rep_tpl_param_.getCode(), tmp_string_);
        /*
           } else if (jr_report_param_.getType().equals("singleSelect")) {
           report_params_.put(jr_report_param_.getId(), (String) jr_report_param_.getValue());
         */
      } else if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("List")) {
        List tmp_list_ = (List) jr_rep_tpl_param_.getList_value();
        if (jr_rep_tpl_param_.getIs_required() && (tmp_list_ == null || tmp_list_.isEmpty())) {
          err_msg_ = bundle_funcs.getBundleValue(bundle_, "Pole_%1_javljaetsja_objazatelnym");
          err_msg_ = err_msg_.replace("%1", jr_rep_tpl_param_.getName_translation_3(core_session_, lang_));
          throw new MyException(err_msg_);
        }
        report_params_.put(jr_rep_tpl_param_.getCode(), tmp_list_);
      }
    }

    String sid_ = "";
    if (http_session_ != null) {
      sid_ = jsf_funcs.getSessionId(http_session_);
    }
    OutputStream os_ = runReport(core_session_, jr_rep_tpl_.getJr_rep_tpl(), report_params_,
      format_str_, C_Usr_, bundle_, sid_, connection_);

    res = byte_funcs.convertOutputStreamToByteArr(os_);
    return res;
  }

  public static OutputStream runReport(Session core_session_, Integer jr_rep_tpl_id_, HashMap report_params_,
    String format_str_, C_Usr C_Usr_, ResourceBundle bundle_, String sid_, Connection connection_) throws Exception {
    OutputStream res = new ByteArrayOutputStream();

    String lang_ = locale_funcs.getLanguageTag(bundle_.getLocale());
    //test1();
    Jr_Rep_Tpl jr_rep_tpl_ = Jr_Rep_Tpl_Manager.getCI().get_rec(core_session_, jr_rep_tpl_id_);
    //String report_path_ = jr_rep_.getJr_rep_tpl().getReport_path();
    //String report_name_ = jr_rep_.getJr_rep_tpl().getCode();

    byte[] byte_arr_ = Jr_Rep_Tpl_File_Manager.getCI().get_jr_rep_tpl_file(core_session_, jr_rep_tpl_.getJr_rep_tpl()).getBin_file_body_t_2(core_session_).getFile_body();
    InputStream jrxml_is_ = byte_funcs.convertByteArrToInputStream(byte_arr_);
    jrxml_is_.reset();
    JasperDesign jd_ = JRXmlLoader.load(jrxml_is_);

    if (format_str_.toUpperCase().equals("PDF")) {
      setPDFProps(jd_);
    }

    if (format_str_.toUpperCase().equals("PDF")) {
      jd_.setIgnorePagination(false);
    }

    JasperReport jr_ = JasperCompileManager.compileReport(jd_);

    Locale locale_ = locale_funcs.getLocale(lang_);
    report_params_.put(JRParameter.REPORT_LOCALE, locale_);
    report_params_.put(JRParameter.REPORT_RESOURCE_BUNDLE, bundle_);

    //java.util.TimeZone tz_ = tz_funcs.getTimeZone(C_Usr_.getV3_tz().getInterval_in_min());
    //report_params_.put(JRParameter.REPORT_TIME_ZONE, tz_);// Should be equal to user time zone
    report_params_.put(JRParameter.REPORT_TIME_ZONE, VariablesBean.getCI().getLocalTimeZone());

    //FormatFactory format_factory_ = new CustomReportFormatFactory(jr_rep_.getDate_format_pattern(), jr_rep_.getTime_format_pattern(), jr_rep_.getDate_time_format_pattern());
    //report_params_.put(JRParameter.REPORT_FORMAT_FACTORY, format_factory_);
    report_params_.put("report_lang", lang_);

    report_params_.put("logged_in_user_name", C_Usr_.getName());
    report_params_.put("logged_in_user_password", C_Usr_.getPswd());
    report_params_.put("sid", sid_);

    report_params_.put("output_format", format_str_.toLowerCase());

    if (connection_ == null) {
      connection_ = CustomJRFuncs.getReportConnection(VariablesBean.getCI().getReport_db_connection_url(),
        VariablesBean.getCI().getReport_db_connection_username(), VariablesBean.getCI().getReport_db_connection_password(),
        VariablesBean.getCI().getReport_db_connection_driver_class());
    }

    JasperPrint jp_ = JasperFillManager.fillReport(jr_, report_params_, connection_);
    jr_funcs.exportReport(jp_, format_str_, res);

    //JasperExportManager.exportReportToHtmlFile(jp_, "c:\\Temp\\out.html");
    //JRHtmlExporter
    //JRRtfExporter exporter = new JRRtfExporter();
    //exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));
    //jr_funcs.closeSession(jrs_session_);
    return res;
  }

}
