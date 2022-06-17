package others;

import additional_classes.Select_Item;
import beans.CUsrBean;
import beans.VariablesBean;
import controllers.JSStrListController;
import gs.common.Consts;
import gs.common.MyException;
import gs.common.byte_funcs;
import gs.common.date_time_funcs;
import gs.common.jr_funcs;
import static gs.common.jr_funcs.setPDFProps;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.locale_funcs;
import gs.common.other_funcs;
import gs.common.jsf.jsf_funcs;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import managers.core.dbtables.Jr_Lov_Row_Manager;
import managers.core.dbtables.Jr_Rep_Col_Manager;
import managers.core.dbtables.Jr_Rep_Col_Sort_Manager;
import managers.core.dbtables.Jr_Rep_Manager;
import managers.core.dbtables.Jr_Rep_Tpl_Col_Manager;
import managers.core.dbtables.Jr_Rep_Tpl_File_Manager;
import managers.core.dbtables.Jr_Rep_Tpl_Param_Manager;
import managers.core.dbtables.C_Tbl_Rec_File_Manager;
import managers.core.dbtables.C_Tbl_Manager;
import model.core.dbtables.Jr_Lov_Row;
import model.core.dbtables.Jr_Query;
import model.core.dbtables.Jr_Rep;
import model.core.dbtables.Jr_Rep_Col;
import model.core.dbtables.Jr_Rep_Col_Sort;
import model.core.dbtables.Jr_Rep_Tpl_Col;
import model.core.dbtables.Jr_Rep_Tpl_Param;
import model.core.dbtables.C_Tbl_Rec_File;
import model.core.dbtables.C_Usr;
import model.core.dbutil.CoreSessionFactoryUtil;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRSortField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignSortField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.fill.JRParameterDefaultValuesEvaluator;
import net.sf.jasperreports.engine.type.SortFieldTypeEnum;
import net.sf.jasperreports.engine.type.SortOrderEnum;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.hibernate.Session;
import gs.common.hibernate_funcs;
import gs.common.primefaces.primefaces_funcs;
import model.core.dbtables.C_Bin_File_Body;
import org.hibernate.Transaction;
import org.primefaces.behavior.ajax.AjaxBehavior;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectmanymenu.SelectManyMenu;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.PrimeFaces;

public class CustomJRRepFuncs {

  public static List<Jr_Rep_Tpl_Param> get_jr_rep_tpl_param_list(Jr_Rep jr_rep_, C_Usr C_Usr_) throws Exception {
    List<Jr_Rep_Tpl_Param> res;
    Transaction tx_ = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      res = get_jr_rep_tpl_param_list(session_, jr_rep_, C_Usr_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static List<Jr_Rep_Tpl_Param> get_clone_jr_rep_tpl_param_list(Session core_session_, Jr_Rep jr_rep_, C_Usr logged_c_usr_) throws Exception {
    List<Jr_Rep_Tpl_Param> res = new ArrayList();
    List<Jr_Rep_Tpl_Param> list_ = get_jr_rep_tpl_param_list(core_session_, jr_rep_, logged_c_usr_);
    for (int i = 0; i < list_.size(); i++) {
      res.add((Jr_Rep_Tpl_Param) list_.get(i).clone());
    }
    return res;
  }

  public static List<Jr_Rep_Tpl_Param> get_clone_jr_rep_tpl_param_list(Jr_Rep jr_rep_, C_Usr logged_c_usr_) throws Exception {
    List<Jr_Rep_Tpl_Param> res = new ArrayList();
    List<Jr_Rep_Tpl_Param> list_ = get_jr_rep_tpl_param_list(jr_rep_, logged_c_usr_);
    for (int i = 0; i < list_.size(); i++) {
      res.add((Jr_Rep_Tpl_Param) list_.get(i).clone());
    }
    return res;
  }

  public static List<Jr_Rep_Tpl_Param> get_jr_rep_tpl_param_list(Session core_session_, Jr_Rep jr_rep_, C_Usr C_Usr_) throws Exception {
    List<Jr_Rep_Tpl_Param> list_ = Jr_Rep_Tpl_Param_Manager.getCI().get_jr_rep_tpl_param_list(core_session_, jr_rep_.getJr_rep_tpl_t_2(core_session_).getJr_rep_tpl());

    /*
    if (C_Usr_ == null) {
      C_Usr_ = C_Usr_Manager.getCI().getDefault_c_usr_2(core_session_);
    }
    */
    HashMap report_params_ = new HashMap();
    report_params_.put("logged_in_user_name", C_Usr_.getName());
    report_params_.put("logged_in_user_password", C_Usr_.getPswd());
    /*
    java.util.TimeZone tz_ = tz_funcs.getTimeZone(C_Usr_.getV3_tz().getInterval_in_min());
    report_params_.put(JRParameter.REPORT_TIME_ZONE, tz_);// Should be equal to user time zone
     */
    report_params_.put(JRParameter.REPORT_TIME_ZONE, VariablesBean.getCI().getLocalTimeZone());
    byte[] byte_arr_ = Jr_Rep_Tpl_File_Manager.getCI().get_jr_rep_tpl_file(core_session_, jr_rep_.getJr_rep_tpl_t_2(core_session_).getJr_rep_tpl()).getBin_file_body_t_2(core_session_).getFile_body();
    InputStream is_ = byte_funcs.convertByteArrToInputStream(byte_arr_);
    is_.reset();
    JasperDesign jd_ = JRXmlLoader.load(is_);
    JasperReport jr_ = JasperCompileManager.compileReport(jd_);
    Map jr_default_value_map_ = JRParameterDefaultValuesEvaluator.evaluateParameterDefaultValues(DefaultJasperReportsContext.getInstance(),
      jr_, report_params_);
    //CustomLogger.log("jr_default_values=" + jr_default_value_map_);

    Object default_val_;
    for (int i = 0; i < list_.size(); i++) {
      default_val_ = jr_default_value_map_.get(list_.get(i).getCode());
      list_.get(i).setDefault_value(default_val_);
    }
    is_.close();

    return list_;
  }

  public static Jr_Rep_Tpl_Param get_jr_rep_tpl_param(List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list_, String tpl_param_code_) {
    for (int i = 0; i < jr_rep_tpl_param_list_.size(); i++) {
      if (jr_rep_tpl_param_list_.get(i).getCode().equals(tpl_param_code_)) {
        return jr_rep_tpl_param_list_.get(i);
      }
    }
    return null;
  }

  public static void set_jr_rep_tpl_param_val_str(Jr_Rep jr_rep_, String tpl_param_code_, String val_) throws Exception {
    set_jr_rep_tpl_param_val_str(jr_rep_.getJr_rep_tpl_param_list(), tpl_param_code_, val_);
  }

  public static void set_jr_rep_tpl_param_val_str(List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list_, String tpl_param_code_, String param_val_) throws Exception {
    Jr_Rep_Tpl_Param jr_rep_tpl_param_ = get_jr_rep_tpl_param(jr_rep_tpl_param_list_, tpl_param_code_);
    if (jr_rep_tpl_param_ != null) {
      List<String> list_val_ = new ArrayList();
      if (jr_rep_tpl_param_.getC_java_data_type_t().getCode().equals("List")) {
        if (param_val_ != null && !param_val_.trim().isEmpty()) {
          list_val_ = other_funcs.StrToStrList(param_val_);
        }
      }
      set_jr_rep_tpl_param_val(jr_rep_tpl_param_list_, tpl_param_code_, param_val_, list_val_);
    }
  }

  public static void set_jr_rep_tpl_param_val(Jr_Rep jr_rep_, String tpl_param_code_, Object val_, List list_val_) throws Exception {
    set_jr_rep_tpl_param_val(jr_rep_.getJr_rep_tpl_param_list(), tpl_param_code_, val_, list_val_);
  }

  public static void set_jr_rep_tpl_param_val(List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list_, String tpl_param_code_, Object val_, List list_val_) throws Exception {
    Jr_Rep_Tpl_Param jr_rep_tpl_param_ = get_jr_rep_tpl_param(jr_rep_tpl_param_list_, tpl_param_code_);
    if (jr_rep_tpl_param_ != null) {
      String java_data_type_code_;
      java_data_type_code_ = jr_rep_tpl_param_.getC_java_data_type_t().getCode();
      if ((val_ != null) && (val_ instanceof String) && (!java_data_type_code_.equals("String"))) {
        if (java_data_type_code_.equals("String")) {
          jr_rep_tpl_param_.setValue(val_);
        } else if (java_data_type_code_.equals("Integer")) {
          jr_rep_tpl_param_.setValue(Integer.valueOf((String) val_));
        } else if (java_data_type_code_.equals("Double")) {
          jr_rep_tpl_param_.setValue(Double.valueOf((String) val_));
        } else if (java_data_type_code_.equals("Date")) {
          jr_rep_tpl_param_.setValue(Consts.sdfddMMyyyy().parse((String) val_));
        } else if (java_data_type_code_.equals("Time")) {
          jr_rep_tpl_param_.setValue(Consts.sdfHHmmss().parse((String) val_));
        } else if (java_data_type_code_.equals("Boolean")) {
          jr_rep_tpl_param_.setValue(Boolean.valueOf((String) val_));
        } else if (java_data_type_code_.equals("Timestamp")) {
          jr_rep_tpl_param_.setValue(Consts.sdfddMMyyyyHHmmss().parse((String) val_));
        } else if (java_data_type_code_.equals("Long")) {
          jr_rep_tpl_param_.setValue(Long.valueOf((String) val_));
        } else if (java_data_type_code_.equals("List")) {
          jr_rep_tpl_param_.setList_value(list_val_);
        } else {
          jr_rep_tpl_param_.setValue(val_);
        }
      } else {
        jr_rep_tpl_param_.setValue(val_);
      }
    }
  }

  /*
  public static String get_jr_rep_tpl_param_val_str(List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list_, String tpl_param_code_) {
    Jr_Rep_Tpl_Param jr_rep_tpl_param_ = get_jr_rep_tpl_param(jr_rep_tpl_param_list_, tpl_param_code_);
    if (jr_rep_tpl_param_ != null) {
      if (jr_rep_tpl_param_.getC_java_data_type().getCode().equals("List")) {
        if (jr_rep_tpl_param_.getList_value() != null) {
          return other_funcs.StrListToStr(jr_rep_tpl_param_.getList_value());
        } else {
          return null;
        }
      } else if (jr_rep_tpl_param_.getValue() != null) {
        return String.valueOf(jr_rep_tpl_param_.getValue());
      } else {
        return null;
      }
    }
    return null;
  }
   */
  public static String get_jr_rep_tpl_param_val_str(Jr_Rep_Tpl_Param jr_rep_tpl_param_) {
    if (jr_rep_tpl_param_.getC_java_data_type_t().getCode().equals("List")) {
      if (jr_rep_tpl_param_.getList_value() != null) {
        return other_funcs.StrListToStr(jr_rep_tpl_param_.getList_value());
      } else {
        return null;
      }
    } else if (jr_rep_tpl_param_.getValue() != null) {
      return String.valueOf(jr_rep_tpl_param_.getValue());
    } else {
      return null;
    }
  }

  public static boolean is_jr_rep_tpl_param_filled(Jr_Rep_Tpl_Param jr_rep_tpl_param_) {
    if (jr_rep_tpl_param_.getC_java_data_type_t().getCode().equals("List")) {
      if (jr_rep_tpl_param_.getList_value() == null || jr_rep_tpl_param_.getList_value().isEmpty()) {
        return false;
      }
    } else if (jr_rep_tpl_param_.getValue() == null) {
      return false;
    }
    return true;
  }

  public static OutputStream runReport(Session core_session_, Integer jr_rep_id_, HashMap report_params_,
    String format_str_, C_Usr C_Usr_, ResourceBundle bundle_, String sid_) throws Exception {
    OutputStream res = new ByteArrayOutputStream();

    String lang_ = locale_funcs.getLanguageTag(bundle_.getLocale());
    //test1();
    Jr_Rep jr_rep_ = Jr_Rep_Manager.getCI().get_rec(core_session_, jr_rep_id_);
    //String report_path_ = jr_rep_.getJr_rep_tpl().getReport_path();
    //String report_name_ = jr_rep_.getJr_rep_tpl().getCode();

    byte[] byte_arr_ = Jr_Rep_Tpl_File_Manager.getCI().get_jr_rep_tpl_file(core_session_, jr_rep_.getJr_rep_tpl_t_2(core_session_).getJr_rep_tpl()).getBin_file_body_t_2(core_session_).getFile_body();
    InputStream jrxml_is_ = byte_funcs.convertByteArrToInputStream(byte_arr_);
    jrxml_is_.reset();
    JasperDesign jd_ = JRXmlLoader.load(jrxml_is_);

    if (format_str_.toUpperCase().equals("PDF")) {
      setPDFProps(jd_);
    }
    jr_funcs.setFont(jd_, "Times New Roman");

    jd_.setTitleNewPage(jr_rep_.getIs_title_on_new_page());
    jd_.setSummaryNewPage(jr_rep_.getIs_summary_on_new_page());
    jd_.setSummaryWithPageHeaderAndFooter(jr_rep_.getIs_summary_with_page_head_foot());
    jd_.setFloatColumnFooter(jr_rep_.getIs_float_column_footer());
    if (format_str_.toUpperCase().equals("PDF")) {
      jd_.setIgnorePagination(false);
    } else {
      jd_.setIgnorePagination(jr_rep_.getIs_ignore_pagination());
    }
    //jd_.setPageWidth(jr_rep_.getPage_width());
    //jd_.setPageHeight(jr_rep_.getPage_height());
    //jd_.setTopMargin(jr_rep_.getPage_top_margin());
    //jd_.setLeftMargin(jr_rep_.getPage_left_margin());
    //jd_.setBottomMargin(jr_rep_.getPage_bottom_margin());
    //jd_.setRightMargin(jr_rep_.getPage_right_margin());
    //jd_.setOrientation(jr_rep_.getJr_rep_page_orient().getCode().equals("portrait") ? OrientationEnum.PORTRAIT : OrientationEnum.LANDSCAPE);

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

    if (jr_rep_.getCreator_usr() != null && jr_rep_.getCreator_usr_t_2(core_session_).getC_usr() != 1) {
      report_params_.put("report_title", jr_rep_.getName());
    } else {
      report_params_.put("report_title", jr_rep_.getName_translation_3(core_session_, lang_));
    }
    report_params_.put("title_band_visible", jr_rep_.getIs_display_report_title());
    report_params_.put("is_display_total", jr_rep_.getIs_display_total());
    report_params_.put("is_display_row_num", jr_rep_.getIs_display_row_num());
    report_params_.put("date_format_pattern", jr_rep_.getDate_format_pattern());
    report_params_.put("time_format_pattern", jr_rep_.getTime_format_pattern());
    report_params_.put("date_time_format_pattern", jr_rep_.getDate_time_format_pattern());
    report_params_.put("speed_unit_name", jr_rep_.getC_speed_unit_t_2(core_session_).getName_translation_3(core_session_, lang_));
    report_params_.put("speed_unit_multiplier_to_base_unit", jr_rep_.getC_speed_unit_t_2(core_session_).getMultiplier_to_base_unit());
    report_params_.put("distance_unit_name", jr_rep_.getC_distance_unit_t_2(core_session_).getName_translation_3(core_session_, lang_));
    report_params_.put("distance_unit_multiplier_to_base_unit", jr_rep_.getC_distance_unit_t_2(core_session_).getMultiplier_to_base_unit());
    report_params_.put("volume_unit_name", jr_rep_.getC_volume_unit_t_2(core_session_).getName_translation_3(core_session_, lang_));
    report_params_.put("volume_unit_multiplier_to_base_unit", jr_rep_.getC_volume_unit_t_2(core_session_).getMultiplier_to_base_unit());
    report_params_.put("logged_in_user_name", C_Usr_.getName());
    report_params_.put("logged_in_user_password", C_Usr_.getPswd());
    report_params_.put("title_band_visible", jr_rep_.getIs_display_report_title());
    report_params_.put("sid", sid_);
    report_params_.put("run_id", other_funcs.getUniqueId());
    report_params_.put("is_add_total", jr_rep_.getIs_add_total());
    report_params_.put("is_grp_by_dates", jr_rep_.getIs_grp_by_dates());
    //report_params_.put("jr_rep_rec", jr_rep_);

    report_params_.put("output_format", format_str_.toLowerCase());

    // Show columns
    List<Jr_Rep_Tpl_Col> jr_rep_tpl_col_list_ = Jr_Rep_Tpl_Col_Manager.getCI().get_jr_rep_tpl_col_list(core_session_, jr_rep_.getJr_rep_tpl_t_2(core_session_).getJr_rep_tpl());
    List<Jr_Rep_Col> jr_rep_col_list_ = Jr_Rep_Col_Manager.getCI().get_jr_rep_col_list(core_session_, jr_rep_.getJr_rep());
    boolean exists_;
    for (int i = 0; i < jr_rep_tpl_col_list_.size(); i++) {
      exists_ = false;
      for (int j = 0; j < jr_rep_col_list_.size(); j++) {
        if (jr_rep_col_list_.get(j).getJr_rep_tpl_col_t_2(core_session_).getJr_rep_tpl_col().equals(jr_rep_tpl_col_list_.get(i).getJr_rep_tpl_col())) {
          exists_ = true;
          break;
        }
      }
      report_params_.put("is_show_column_" + jr_rep_tpl_col_list_.get(i).getCode(), exists_);
    }

    // Sort columns
    List<Jr_Rep_Col_Sort> jr_rep_col_sort_list_ = Jr_Rep_Col_Sort_Manager.getCI().get_jr_rep_col_sort_list(core_session_, jr_rep_.getJr_rep());
    if (!jr_rep_col_sort_list_.isEmpty()) {
      List<JRSortField> sort_fields_ = new ArrayList<JRSortField>();
      JRDesignSortField sort_field_;
      for (int i = 0; i < jr_rep_col_sort_list_.size(); i++) {
        sort_field_ = new JRDesignSortField();
        sort_field_.setName(jr_rep_col_sort_list_.get(i).getJr_rep_tpl_col_t_2(core_session_).getCode());
        sort_field_.setOrder(jr_rep_col_sort_list_.get(i).getJr_rep_sort_order_t_2(core_session_).getCode().equals("asc") ? SortOrderEnum.ASCENDING : SortOrderEnum.DESCENDING);
        sort_field_.setType(SortFieldTypeEnum.FIELD);
        sort_fields_.add(sort_field_);
      }
      report_params_.put(JRParameter.SORT_FIELDS, sort_fields_);
    }

    // Filter columns
    /*
       List<Jr_Rep_Col_Fil> jr_rep_col_fil_list_ = Jr_Rep_Col_Fil_Manager.getCI().get_jr_rep_col_fil_list(jr_rep_.getJr_rep());
       if (!jr_rep_col_fil_list_.isEmpty()) {
       Jr_Rep_Col_Fil jr_rep_col_fil_;
       jr_rep_col_fil_ = jr_rep_col_fil_list_.get(0);
       DatasetFilter dataset_filter_ = new FieldFilter(jr_rep_col_fil_.getJr_rep_tpl_col().getCode(), jr_rep_col_fil_.getStart_val(), jr_rep_col_fil_.getFinal_val(),
       jr_rep_col_fil_.getJr_rep_col_fil_type().getCode(), jr_rep_col_fil_.getJr_rep_col_fil_type_op().getCode());
       if (jr_rep_col_fil_list_.size() == 1) {
       report_params_.put(JRParameter.FILTER, dataset_filter_);
       } else {
       DatasetFilter existing_filter = dataset_filter_;
       DatasetFilter combined_filter_ = dataset_filter_;
       for (int i = 1; i < jr_rep_col_fil_list_.size(); i++) {
       jr_rep_col_fil_ = jr_rep_col_fil_list_.get(i);
       DatasetFilter new_dataset_filter_ = new FieldFilter(jr_rep_col_fil_.getJr_rep_tpl_col().getCode(), jr_rep_col_fil_.getStart_val(), jr_rep_col_fil_.getFinal_val(),
       jr_rep_col_fil_.getJr_rep_col_fil_type().getCode(), jr_rep_col_fil_.getJr_rep_col_fil_type_op().getCode());
       combined_filter_ = CompositeDatasetFilter.combine(existing_filter, new_dataset_filter_);
       }
       report_params_.put(JRParameter.FILTER, combined_filter_);
       }
       }
     */
    Connection connection_ = CustomJRFuncs.getReportConnection(VariablesBean.getCI().getReport_db_connection_url(),
      VariablesBean.getCI().getReport_db_connection_username(), VariablesBean.getCI().getReport_db_connection_password(),
      VariablesBean.getCI().getReport_db_connection_driver_class());

    JasperPrint jp_ = JasperFillManager.fillReport(jr_, report_params_, connection_);
    jp_.setProperty(JasperPrint.PROPERTY_CREATE_BOOKMARKS, jr_rep_.getIs_create_bookmarks().toString());
    jr_funcs.exportReport(jp_, format_str_, res);

    //JasperExportManager.exportReportToHtmlFile(jp_, "c:\\Temp\\out.html");
    //JRHtmlExporter
    //JRRtfExporter exporter = new JRRtfExporter();
    //exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));
    //jr_funcs.closeSession(jrs_session_);    
    
    return res;
  }

  public static String runReport(JSStrListController mainJSStrListController_, PrimeFaces primeFaces, C_Usr C_Usr_, Jr_Rep jr_rep_, String format_str_, String parent_element_id_, boolean is_attachment_, ResourceBundle bundle_,
    HttpSession http_session_, List<Jr_Rep_Tpl_Param> default_val_jr_rep_tpl_param_list_) throws Exception {
    String res;
    //Transaction tx_ = null;
    //Session session_ = SessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      session_.beginTransaction();
      res = runReport(mainJSStrListController_, primeFaces, session_, C_Usr_, jr_rep_, format_str_, parent_element_id_, is_attachment_, bundle_, http_session_, default_val_jr_rep_tpl_param_list_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error("jr_rep_=" + jr_rep_ + ", " + other_funcs.stack2string(e));
      if (session_.getTransaction() != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    return res;
  }

  public static String runReport(JSStrListController mainJSStrListController_, PrimeFaces primeFaces, Session core_session_, C_Usr C_Usr_, Jr_Rep jr_rep_, String format_str_, String parent_element_id_, boolean is_attachment_,
    ResourceBundle bundle_, HttpSession http_session_, List<Jr_Rep_Tpl_Param> default_val_jr_rep_tpl_param_list_) throws Exception {
    String res = "";
    /*
    if (1 == 1) {
      throw new Exception("Ok");
    }
     */
    byte[] file_body_ = null;
    try {
      file_body_ = runReport(core_session_, C_Usr_, jr_rep_, format_str_, bundle_, http_session_, default_val_jr_rep_tpl_param_list_);
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
    rec_.setFile_name(jr_rep_.getJr_rep_tpl_t_2(core_session_).getCode() + "_" + String.valueOf(now_.getTime() + "." + extension_));
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
      mainJSStrListController_.add_js_str(primeFaces, "var el_ = document.getElementById(\"" + parent_element_id_ + "\"); el_.innerHTML = ''; el_.innerHTML = \"" + iframe_html_ + "\";");
    } else {
      mainJSStrListController_.add_js_str(primeFaces, "var new_win_ = window.open('" + url_ + "', '_blank'); new_win_.focus();");
    }
    return res;
  }

  public static byte[] runReport(Session core_session_, C_Usr C_Usr_, Jr_Rep jr_rep_, String format_str_, ResourceBundle bundle_,
    HttpSession http_session_, List<Jr_Rep_Tpl_Param> default_val_jr_rep_tpl_param_list_) throws Exception {
    byte[] res = null;
    String lang_ = locale_funcs.getLanguageTag(bundle_.getLocale());
    HashMap report_params_ = new HashMap();
    Jr_Rep_Tpl_Param jr_rep_tpl_param_;
    Date tmp_date_;
    Integer tmp_integer_;
    String tmp_string_;
    String err_msg_;
    report_params_.put("jr_rep_id", jr_rep_.getJr_rep());
    for (int i = 0; i < jr_rep_.getJr_rep_tpl_param_list().size(); i++) {
      jr_rep_tpl_param_ = jr_rep_.getJr_rep_tpl_param_list().get(i);
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
      } else if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("Time")) {
        tmp_date_ = (Date) jr_rep_tpl_param_.getValue();
        if (jr_rep_tpl_param_.getIs_required() && tmp_date_ == null) {
          err_msg_ = bundle_funcs.getBundleValue(bundle_, "Pole_%1_javljaetsja_objazatelnym");
          err_msg_ = err_msg_.replace("%1", jr_rep_tpl_param_.getName_translation_3(core_session_, lang_));
          throw new MyException(err_msg_);
        }
        report_params_.put(jr_rep_tpl_param_.getCode(), tmp_date_ == null ? null : date_time_funcs.get_time(tmp_date_));
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
            err_msg_ = bundle_funcs.getBundleValue(bundle_, "U_vas_net_prav_na_vypolnenie_dannoj_operacii");
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
      if (default_val_jr_rep_tpl_param_list_ != null) {
        boolean found_ = false;
        for (int j = 0; j < default_val_jr_rep_tpl_param_list_.size(); j++) {
          if (default_val_jr_rep_tpl_param_list_.get(j).getCode().equals(jr_rep_tpl_param_.getCode()) && default_val_jr_rep_tpl_param_list_.get(j).getC_java_data_type().equals(jr_rep_tpl_param_.getC_java_data_type())) {
            found_ = true;
            if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("List")) {
              default_val_jr_rep_tpl_param_list_.get(j).setList_value((List) report_params_.get(jr_rep_tpl_param_.getCode()));
            } else {
              default_val_jr_rep_tpl_param_list_.get(j).setValue(report_params_.get(jr_rep_tpl_param_.getCode()));
            }
            break;
          }
        }
        if (!found_) {
          default_val_jr_rep_tpl_param_list_.add(jr_rep_tpl_param_);
          default_val_jr_rep_tpl_param_list_.get(default_val_jr_rep_tpl_param_list_.size() - 1).setValue(report_params_.get(jr_rep_tpl_param_.getCode()));
        }
      }

    }

    String sid_ = "";
    if (http_session_ != null) {
      sid_ = jsf_funcs.getSessionId(http_session_);
    }
    OutputStream os_ = runReport(core_session_, jr_rep_.getJr_rep(), report_params_,
      format_str_, C_Usr_, bundle_, sid_);

    res = byte_funcs.convertOutputStreamToByteArr(os_);
    return res;
  }

  public static void render_jr_rep_params(UIComponent uicomponent_, Jr_Rep jr_rep_, String jr_report_value_expression_, boolean is_render_obj_props_btn_,
    List<Jr_Rep_Tpl_Param> default_val_jr_rep_tpl_param_list_, C_Usr logged_c_usr_) throws Exception {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      render_jr_rep_params(session_, uicomponent_, jr_rep_, jr_report_value_expression_, is_render_obj_props_btn_, default_val_jr_rep_tpl_param_list_, logged_c_usr_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public static void render_jr_rep_params(Session core_session_, UIComponent uicomponent_, Jr_Rep jr_rep_, String jr_report_value_expression_,
    boolean is_render_obj_props_btn_, List<Jr_Rep_Tpl_Param> default_val_jr_rep_tpl_param_list_, C_Usr logged_c_usr_) throws Exception {
    if (jr_rep_ == null) {
      return;
    }
    List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list_ = get_clone_jr_rep_tpl_param_list(core_session_, jr_rep_, logged_c_usr_);
    render_jr_rep_params(core_session_, uicomponent_, jr_rep_, jr_report_value_expression_, jr_rep_tpl_param_list_, "", is_render_obj_props_btn_, default_val_jr_rep_tpl_param_list_, logged_c_usr_);
  }

  public static void render_jr_rep_params(UIComponent uicomponent_, Jr_Rep jr_rep_, String jr_report_value_expression_, List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list_,
    String prepend_id_, boolean is_render_obj_props_btn_, List<Jr_Rep_Tpl_Param> default_val_jr_rep_tpl_param_list_, C_Usr logged_c_usr_) throws Exception {
    Transaction tx = null;
    Session session_ = CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx = session_.beginTransaction();
      render_jr_rep_params(session_, uicomponent_, jr_rep_, jr_report_value_expression_, jr_rep_tpl_param_list_, prepend_id_, is_render_obj_props_btn_,
        default_val_jr_rep_tpl_param_list_, logged_c_usr_);
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
  }

  public static void clear_jr_rep_params_component(UIComponent uicomponent_) {
    if (!uicomponent_.getChildren().isEmpty()) {
      while (!uicomponent_.getChildren().isEmpty()) {
        uicomponent_.getChildren().remove(0);
      }
      primefaces_funcs.updateElement(uicomponent_.getClientId());
    }
  }

  public static void render_jr_rep_params(Session core_session_, UIComponent uicomponent_,
    Jr_Rep jr_rep_, String jr_report_value_expression_, List<Jr_Rep_Tpl_Param> jr_rep_tpl_param_list_, String prepend_id_, boolean is_render_obj_props_btn_,
    List<Jr_Rep_Tpl_Param> default_val_jr_rep_tpl_param_list_, C_Usr logged_c_usr_) throws Exception {
    System.out.println("render_jr_rep_params");
    if (jr_rep_ == null) {
      return;
    }
    jr_rep_.setJr_rep_tpl_param_list(jr_rep_tpl_param_list_);
    if (uicomponent_.getChildren() != null && !uicomponent_.getChildren().isEmpty()) {
      while (!uicomponent_.getChildren().isEmpty()) {
        uicomponent_.getChildren().remove(0);
      }
      primefaces_funcs.updateElement(uicomponent_.getClientId());
    }
    //Jr_Rep_Tpl jr_rep_tpl_ = jr_rep_.getJr_rep_tpl();
    String el_id_;
    boolean is_add_label_;
    Jr_Rep_Tpl_Param jr_rep_tpl_param_;
    SelectItem si_ = new SelectItem();
    String label_;
    for (int i = 0; i < jr_rep_.getJr_rep_tpl_param_list().size(); i++) {
      jr_rep_tpl_param_ = jr_rep_.getJr_rep_tpl_param_list().get(i);
      if (!jr_rep_tpl_param_.getIs_visible()) {
        continue;
      }
      if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("List")) {
        if (jr_rep_tpl_param_.getList_value() == null) {
          if (jr_rep_tpl_param_.getDefault_value() == null) {
            jr_rep_tpl_param_.setList_value(new ArrayList());
          } else {
            jr_rep_tpl_param_.setList_value((List<String>) jr_rep_tpl_param_.getDefault_value());
          }
        }
      } else if (jr_rep_tpl_param_.getValue() == null) {
        jr_rep_tpl_param_.setValue(jr_rep_tpl_param_.getDefault_value());
      }
      if (default_val_jr_rep_tpl_param_list_ != null) {
        for (int j = 0; j < default_val_jr_rep_tpl_param_list_.size(); j++) {
          if (default_val_jr_rep_tpl_param_list_.get(j).getCode().equals(jr_rep_tpl_param_.getCode()) && default_val_jr_rep_tpl_param_list_.get(j).getC_java_data_type().equals(jr_rep_tpl_param_.getC_java_data_type())) {
            if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("List")) {
              jr_rep_tpl_param_.setList_value(default_val_jr_rep_tpl_param_list_.get(j).getList_value());
            } else {
              jr_rep_tpl_param_.setValue(default_val_jr_rep_tpl_param_list_.get(j).getValue());
            }
            break;
          }
        }
      }
      /*
      if (!jr_rep_tpl_param_.getDefault_val().trim().isEmpty()) {
        if (jr_rep_tpl_param_.getC_java_data_type().getCode().equals("String")) {
          jr_rep_tpl_param_.setValue(jr_rep_tpl_param_.getDefault_val());
        } else if (jr_rep_tpl_param_.getC_java_data_type().getCode().equals("Integer")) {
          jr_rep_tpl_param_.setValue(Integer.valueOf(jr_rep_tpl_param_.getDefault_val()));
        } else if (jr_rep_tpl_param_.getC_java_data_type().getCode().equals("Double")) {
          jr_rep_tpl_param_.setValue(Double.valueOf(jr_rep_tpl_param_.getDefault_val()));
        } else if (jr_rep_tpl_param_.getC_java_data_type().getCode().equals("Date")) {
          jr_rep_tpl_param_.setValue(new SimpleDateFormat(Consts.ddMMyyyy).parse(jr_rep_tpl_param_.getDefault_val()));
        } else if (jr_rep_tpl_param_.getC_java_data_type().getCode().equals("Time")) {
          jr_rep_tpl_param_.setValue(Consts.sdfHHmmss.parse(jr_rep_tpl_param_.getDefault_val()));
        } else if (jr_rep_tpl_param_.getC_java_data_type().getCode().equals("Boolean")) {
          jr_rep_tpl_param_.setValue(Boolean.valueOf(jr_rep_tpl_param_.getDefault_val()));
        } else if (jr_rep_tpl_param_.getC_java_data_type().getCode().equals("Timestamp")) {
          jr_rep_tpl_param_.setValue(new SimpleDateFormat(Consts.ddMMyyyyHHmmss).parse(jr_rep_tpl_param_.getDefault_val()));
        } else if (jr_rep_tpl_param_.getC_java_data_type().getCode().equals("Long")) {
          jr_rep_tpl_param_.setValue(Long.valueOf(jr_rep_tpl_param_.getDefault_val()));
        }
      }
       */

 /*
        if (VariablesBean.getCI().getIs_test_mode()) {
          if (jr_rep_tpl_param_.getCode().equals("begin_dt")) {
            jr_rep_tpl_param_.setValue(new java.sql.Timestamp(115, 5, 6, 0, 0, 0, 0));
          } else if (jr_rep_tpl_param_.getCode().equals("end_dt")) {
            jr_rep_tpl_param_.setValue(new java.sql.Timestamp(115, 5, 6, 1, 59, 59, 0));
          }
        }
       */
      el_id_ = prepend_id_ + "id_" + jr_rep_tpl_param_.getCode();
      is_add_label_ = false;
      if (jr_rep_tpl_param_.getJr_input_control() == null) {
        if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("Timestamp")) {
          Calendar calendar_ = new Calendar();
          ValueExpression valueExpression = FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
            .createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{" + jr_report_value_expression_ + ".jr_rep_tpl_param_list.get(" + i + ").value}", Date.class);
          calendar_.setValueExpression("value", valueExpression);
          calendar_.setShowButtonPanel(true);
          calendar_.setPattern("dd.MM.yyyy HH:mm:ss");
          calendar_.setId(el_id_);
          calendar_.setTimeZone(VariablesBean.getCI().getLocalTimeZone());
          calendar_.setReadonly(jr_rep_tpl_param_.getIs_readonly());
          calendar_.setRequired(jr_rep_tpl_param_.getIs_required());
          calendar_.setNavigator(true);
          calendar_.setMask("true");
          uicomponent_.getChildren().add(calendar_);
          is_add_label_ = true;
        } else if (jr_rep_tpl_param_.getC_java_data_type_t_2(core_session_).getCode().equals("Time")) {
          Calendar calendar_ = new Calendar();
          ValueExpression valueExpression = FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
            .createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{" + jr_report_value_expression_ + ".jr_rep_tpl_param_list.get(" + i + ").value}", Date.class);
          calendar_.setValueExpression("value", valueExpression);
          calendar_.setShowButtonPanel(true);
          calendar_.setPattern("HH:mm:ss");
          calendar_.setId(el_id_);
          calendar_.setTimeZone(VariablesBean.getCI().getLocalTimeZone());
          calendar_.setReadonly(jr_rep_tpl_param_.getIs_readonly());
          calendar_.setRequired(jr_rep_tpl_param_.getIs_required());
          calendar_.setNavigator(false);
          calendar_.setMask("true");
          calendar_.setSize(8);
          calendar_.setTimeOnly(true);
          uicomponent_.getChildren().add(calendar_);
          is_add_label_ = true;
        }
      } else if (jr_rep_tpl_param_.getJr_input_control() != null) {
        if (jr_rep_tpl_param_.getJr_input_control_t_2(core_session_).getJr_lov() != null) {
          List<Jr_Lov_Row> jr_lov_row_list_ = Jr_Lov_Row_Manager.getCI().get_jr_lov_row_list(core_session_, jr_rep_tpl_param_.getJr_input_control_t_2(core_session_).getJr_lov_t_2(core_session_).getJr_lov());
          Jr_Lov_Row jr_lov_row_;
          if (jr_rep_tpl_param_.getJr_input_control_t_2(core_session_).getJr_input_control_type_t_2(core_session_).getCode().equals("single_select_lov")) {
            SelectOneMenu som_ = new SelectOneMenu();
            ValueExpression valueExpression = FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
              .createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{" + jr_report_value_expression_ + ".jr_rep_tpl_param_list.get(" + i + ").value}", String.class);
            som_.setValueExpression("value", valueExpression);
            som_.setId(el_id_);
            som_.setReadonly(jr_rep_tpl_param_.getIs_readonly());
            som_.setRequired(jr_rep_tpl_param_.getIs_required());
            som_.setFilter(true);
            som_.setFilterMatchMode("contains");
            som_.setWidgetVar("wv_" + el_id_);
            addAjaxBehavior(som_, jr_rep_tpl_param_);

            UISelectItems selectItems = new UISelectItems();
            List<SelectItem> si_list_ = new ArrayList();
            si_list_.add(new SelectItem("", "-"));
            for (int j = 0; j < jr_lov_row_list_.size(); j++) {
              jr_lov_row_ = jr_lov_row_list_.get(j);
              if (jr_lov_row_.getName().startsWith("$R{")) {
                label_ = bundle_funcs.getBundleValue(jr_lov_row_.getName().substring(3).replace("}", ""));
              } else {
                label_ = bundle_funcs.getBundleValue(jr_lov_row_.getName());
              }
              si_list_.add(new SelectItem(jr_lov_row_.getVal(), label_));
            }
            selectItems.setValue(si_list_);
            som_.getChildren().add(selectItems);
            uicomponent_.getChildren().add(som_);
            is_add_label_ = true;
          }
          if (jr_rep_tpl_param_.getJr_input_control_t_2(core_session_).getJr_input_control_type_t_2(core_session_).getCode().equals("multi_select_lov")) {
            SelectManyMenu som_ = new SelectManyMenu();
            ValueExpression valueExpression = FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
              .createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{" + jr_report_value_expression_ + ".jr_rep_tpl_param_list.get(" + i + ").list_value}", List.class);
            som_.setValueExpression("value", valueExpression);
            som_.setId(el_id_);
            som_.setReadonly(jr_rep_tpl_param_.getIs_readonly());
            som_.setRequired(jr_rep_tpl_param_.getIs_required());
            som_.setFilter(true);
            som_.setFilterMatchMode("contains");
            som_.setWidgetVar("wv_" + el_id_);
            som_.setShowCheckbox(true);
            addAjaxBehavior(som_, jr_rep_tpl_param_);

            UISelectItems selectItems = new UISelectItems();
            List<SelectItem> si_list_ = new ArrayList();
            //si_list_.add(new SelectItem("", "-"));
            for (int j = 0; j < jr_lov_row_list_.size(); j++) {
              jr_lov_row_ = jr_lov_row_list_.get(j);
              if (jr_lov_row_.getName().startsWith("$R{")) {
                label_ = bundle_funcs.getBundleValue(jr_lov_row_.getName().substring(3).replace("}", ""));
              } else {
                label_ = bundle_funcs.getBundleValue(jr_lov_row_.getName());
              }
              si_list_.add(new SelectItem(jr_lov_row_.getVal(), label_));
            }
            selectItems.setValue(si_list_);
            som_.getChildren().add(selectItems);
            uicomponent_.getChildren().add(som_);
            is_add_label_ = true;
          }
        } else if (jr_rep_tpl_param_.getJr_input_control_t_2(core_session_).getJr_query() != null) {
          List<Select_Item> select_item_list_ = CustomJRRepFuncs.get_select_item_list(jr_rep_, logged_c_usr_, jr_rep_tpl_param_.getJr_input_control_t_2(core_session_).getJr_query_t_2(core_session_), jsf_funcs.getSessionId());
          //Select_Item select_item_;
          if (jr_rep_tpl_param_.getJr_input_control_t_2(core_session_).getJr_input_control_type_t_2(core_session_).getCode().equals("single_select_query")) {
            SelectOneMenu som_ = new SelectOneMenu();
            som_.setId(el_id_);
            ValueExpression valueExpression = FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
              .createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{" + jr_report_value_expression_ + ".jr_rep_tpl_param_list.get(" + i + ").value}", String.class);
            som_.setValueExpression("value", valueExpression);
            som_.setReadonly(jr_rep_tpl_param_.getIs_readonly());
            som_.setRequired(jr_rep_tpl_param_.getIs_required());
            som_.setFilter(true);
            som_.setFilterMatchMode("contains");
            som_.setWidgetVar("wv_" + el_id_);
            addAjaxBehavior(som_, jr_rep_tpl_param_);

            //som_.setOnchange("report_param_onchange([{name: 'report_param_code', value: '" + jr_rep_tpl_param_.getCode() + "'}]);");
            refill_select_one_menu_items(jr_rep_tpl_param_, som_, select_item_list_);
            uicomponent_.getChildren().add(som_);
            is_add_label_ = true;
          } else if (jr_rep_tpl_param_.getJr_input_control_t_2(core_session_).getJr_input_control_type_t_2(core_session_).getCode().equals("multi_select_query")) {
            SelectManyMenu som_ = new SelectManyMenu();
            som_.setId(el_id_);
            ValueExpression valueExpression = FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
              .createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{" + jr_report_value_expression_ + ".jr_rep_tpl_param_list.get(" + i + ").list_value}", List.class);
            som_.setValueExpression("value", valueExpression);
            som_.setReadonly(jr_rep_tpl_param_.getIs_readonly());
            som_.setRequired(jr_rep_tpl_param_.getIs_required());
            som_.setFilter(true);
            som_.setFilterMatchMode("contains");
            som_.setWidgetVar("wv_" + el_id_);
            som_.setShowCheckbox(true);
            addAjaxBehavior(som_, jr_rep_tpl_param_);

            //som_.setOnchange("report_param_onchange([{name: 'report_param_code', value: '" + jr_rep_tpl_param_.getCode() + "'}]);");
            refill_select_many_menu_items(jr_rep_tpl_param_, som_, select_item_list_);
            uicomponent_.getChildren().add(som_);
            is_add_label_ = true;
          }
        }
      }
      if (is_add_label_) {
        OutputLabel ol_ = new OutputLabel();
        ol_.setValue(bundle_funcs.getBundleValue(jr_rep_tpl_param_.getName_translation_2(core_session_)));
        ol_.setFor(el_id_);
        ol_.setEscape(false);
        uicomponent_.getChildren().add(uicomponent_.getChildren().size() - 1, ol_);
      }
      if (jr_rep_tpl_param_.getCode().equals("obj_id") && is_render_obj_props_btn_) {
        CommandButton cb_ = new CommandButton();
        cb_.setId("id_cb_upd_v3_obj");
        //cb_.setUpdate(":id_dialog_main_objects_ins");
        //cb_.setOnstart("PF('wv_dlg_ex').show();");
        //cb_.setOncomplete("PF('wv_dlg_ex').hide(); ");
        cb_.setIcon("ui-icon-wrench");
        cb_.setOnclick("PF('wv_dlg_ex').show(); show_dialog_object_properties([{name: 'obj_id', value: PF('wv_" + el_id_ + "').getSelectedValue()}]);");

        //cb_.setProcess("id_tv_l:id_form_main_reports:id_ap_reports:id_obj_id");
        //cb_.setAjax(false);
        //String expr_ = "#{mainObjects_V3_Obj_Controller.show_dialog_main_objects_ins_2}";
        //String expr_ = "#{mainObjects_V3_Obj_Controller.show_dialog_main_objects_ins(mainReportsController.selected_jr_rep.jr_rep_tpl_param_list.get(" + i + ").value)}";
        //CustomLogger.log("expr_=" + expr_);
        //MethodExpression me = jsf_funcs.createMethodExpression(expr_, Void.TYPE, new Class[]{ActionEvent.class});
        //MethodExpressionActionListener meal = new MethodExpressionActionListener(me);
        //cb_.addActionListener(jsf_funcs.createMethodActionListener(expr_, Void.TYPE, new Class[]{ActionEvent.class}));
        //cb_.addActionListener(jsf_funcs.createMethodActionListener(expr_, Void.TYPE, new Class[]{Integer.class}));
        cb_.setTitle(bundle_funcs.getBundleValue("Svojstva_objekta"));
        cb_.setAsync(false);
        cb_.setImmediate(true);
        //uicomponent_.getChildren().add(cb_);

        PanelGrid pg_ = new PanelGrid();
        pg_.setId("id_pg_obj_id");
        pg_.setColumns(2);
        pg_.getChildren().add(uicomponent_.getChildren().get(uicomponent_.getChildren().size() - 1));
        //HtmlOutputText hot_ = new HtmlOutputText();
        //hot_.setValue("<br/>");
        //hot_.setEscape(false);
        //pg_.getChildren().add(hot_);
        //uicomponent_.getChildren().remove(uicomponent_.getChildren().size() - 2);
        pg_.getChildren().add(cb_);

        uicomponent_.getChildren().add(pg_);
      }
    }
    System.out.println("uicomponent_.getId()=" + uicomponent_.getClientId());
    primefaces_funcs.updateElement(uicomponent_.getClientId());
    //uicomponent_.
  }

  public static void addAjaxBehavior(SelectOneMenu som_, Jr_Rep_Tpl_Param jr_rep_tpl_param_) {
    AjaxBehavior ajaxBehavior = new AjaxBehavior();
    ajaxBehavior.setAsync(false);
    ajaxBehavior.setGlobal(false);
    ajaxBehavior.setProcess("@this");
    ajaxBehavior.setOncomplete("report_param_onchange([{name: 'report_param_code', value: '" + jr_rep_tpl_param_.getCode() + "'}]);");
    som_.addClientBehavior("change", ajaxBehavior);
  }

  public static void addAjaxBehavior(SelectManyMenu som_, Jr_Rep_Tpl_Param jr_rep_tpl_param_) {
    AjaxBehavior ajaxBehavior = new AjaxBehavior();
    ajaxBehavior.setAsync(false);
    ajaxBehavior.setGlobal(false);
    ajaxBehavior.setProcess("@this");
    ajaxBehavior.setOncomplete("report_param_onchange([{name: 'report_param_code', value: '" + jr_rep_tpl_param_.getCode() + "'}]);");
    som_.addClientBehavior("change", ajaxBehavior);
  }

  public static void refill_select_one_menu_items(Jr_Rep_Tpl_Param jr_rep_tpl_param_, SelectOneMenu som_, List<Select_Item> select_item_list_) {
    som_.getChildren().clear();
    UISelectItems selectItems = new UISelectItems();
    List<SelectItem> si_list_ = new ArrayList();
    //if (!som_.isRequired()) {
    si_list_.add(new SelectItem("", "-"));
    //}
    Select_Item select_item_;
    String label_;
    boolean found_ = false;
    for (int j = 0; j < select_item_list_.size(); j++) {
      select_item_ = select_item_list_.get(j);
      if (select_item_.getLabel().startsWith("$R{")) {
        label_ = bundle_funcs.getBundleValue(select_item_.getLabel().substring(3).replace("}", ""));
      } else {
        label_ = bundle_funcs.getBundleValue(select_item_.getLabel());
      }
      si_list_.add(new SelectItem(select_item_.getValue(), label_));
      if (jr_rep_tpl_param_.getValue() == null || select_item_.getValue().equals(jr_rep_tpl_param_.getValue())) {
        found_ = true;
      }
    }
    if (!found_) {
      jr_rep_tpl_param_.setValue(null);
    }
    selectItems.setValue(si_list_);
    som_.getChildren().add(selectItems);
  }

  public static void refill_select_many_menu_items(Jr_Rep_Tpl_Param jr_rep_tpl_param_, SelectManyMenu som_, List<Select_Item> select_item_list_) {
    som_.getChildren().clear();
    UISelectItems selectItems = new UISelectItems();
    List<SelectItem> si_list_ = new ArrayList();
    //if (!som_.isRequired()) {
    //si_list_.add(new SelectItem("", "-"));
    //}
    Select_Item select_item_;
    String label_;
    for (int j = 0; j < select_item_list_.size(); j++) {
      select_item_ = select_item_list_.get(j);
      if (select_item_.getLabel().startsWith("$R{")) {
        label_ = bundle_funcs.getBundleValue(select_item_.getLabel().substring(3).replace("}", ""));
      } else {
        label_ = bundle_funcs.getBundleValue(select_item_.getLabel());
      }
      si_list_.add(new SelectItem(select_item_.getValue(), label_));
    }
    selectItems.setValue(si_list_);
    som_.getChildren().add(selectItems);
  }

  public static List<Select_Item> get_select_item_list(Jr_Rep jr_rep_, C_Usr C_Usr_, Jr_Query jr_query_, String sid_) throws Exception {
    List<Select_Item> res = new ArrayList<Select_Item>();
    /*
    if (C_Usr_ == null) {
      C_Usr_ = C_Usr_Manager.getCI().getDefault_c_usr();
    }
*/
    String query_str_ = jr_query_.getQuery_string();
    query_str_ = query_str_.replace("$P{sid}", "'" + sid_ + "'");
    query_str_ = query_str_.replace("$P{logged_in_user_name}", "'" + C_Usr_.getName() + "'");
    query_str_ = query_str_.replace("$P{logged_in_user_password}", "'" + C_Usr_.getPswd() + "'");
    Jr_Rep_Tpl_Param jr_rep_tpl_param_;
    String str1_;
    String java_data_type_code_ = "";
    for (int i = 0; i < jr_rep_.getJr_rep_tpl_param_list().size(); i++) {
      jr_rep_tpl_param_ = jr_rep_.getJr_rep_tpl_param_list().get(i);
      str1_ = "$P{" + jr_rep_tpl_param_.getCode() + "}";
      java_data_type_code_ = jr_rep_tpl_param_.getC_java_data_type_t().getCode();
      if (jr_rep_tpl_param_.getValue() == null) {
        query_str_ = query_str_.replace(str1_, "null");
      } else if (java_data_type_code_.equals("String")) {
        query_str_ = query_str_.replace(str1_, "'" + jr_rep_tpl_param_.getValue().toString() + "'");
      } else if (java_data_type_code_.equals("Integer")) {
        query_str_ = query_str_.replace(str1_, jr_rep_tpl_param_.getValue().toString());
      } else if (java_data_type_code_.equals("Double")) {
        query_str_ = query_str_.replace(str1_, jr_rep_tpl_param_.getValue().toString());
      } else if (java_data_type_code_.equals("Date")) {
        query_str_ = query_str_.replace(str1_, jr_rep_tpl_param_.getValue().toString());
      } else if (java_data_type_code_.equals("Time")) {
        query_str_ = query_str_.replace(str1_, jr_rep_tpl_param_.getValue().toString());
      } else if (java_data_type_code_.equals("Boolean")) {
        query_str_ = query_str_.replace(str1_, jr_rep_tpl_param_.getValue().toString());
      } else if (java_data_type_code_.equals("Timestamp")) {
        query_str_ = query_str_.replace(str1_, jr_rep_tpl_param_.getValue().toString());
      } else if (java_data_type_code_.equals("Timestamp")) {
        query_str_ = query_str_.replace(str1_, jr_rep_tpl_param_.getValue().toString());
      } else if (java_data_type_code_.equals("Long")) {
        query_str_ = query_str_.replace(str1_, jr_rep_tpl_param_.getValue().toString());
      } else {
        query_str_ = query_str_.replace(str1_, jr_rep_tpl_param_.getValue().toString());
      }
    }
    CustomLogger.log("query_str_=" + query_str_);
    Statement stmt_ = null;
    Connection con_ = CustomJRFuncs.getReportConnection();
    stmt_ = con_.createStatement();
    ResultSet rset_ = stmt_.executeQuery(query_str_);
    Select_Item select_item_;
    while (rset_.next()) {
      select_item_ = new Select_Item();
      select_item_.setValue(rset_.getObject(1));
      select_item_.setLabel(rset_.getString(2));
      res.add(select_item_);
    }
    rset_.close();
    con_.close();
    return res;
  }

}
