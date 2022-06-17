package others;

import additional_classes.JR_Report;
import additional_classes.JR_Report_Param;
import beans.CUsrBean;
import beans.VariablesBean;
import com.jaspersoft.jasperserver.dto.reports.inputcontrols.InputControlOption;
import com.jaspersoft.jasperserver.dto.reports.inputcontrols.ReportInputControl;
import com.jaspersoft.jasperserver.dto.reports.inputcontrols.ReportInputControlsListWrapper;
import com.jaspersoft.jasperserver.dto.resources.ClientResourceListWrapper;
import com.jaspersoft.jasperserver.dto.resources.ClientResourceLookup;
import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.reporting.ReportOutputFormat;
import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.reporting.ReportsAdapter;
import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.reporting.RunReportAdapter;
import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.reporting.reportparameters.ReportParametersAdapter;
import com.jaspersoft.jasperserver.jaxrs.client.apiadapters.resources.ResourceSearchParameter;
import com.jaspersoft.jasperserver.jaxrs.client.core.JasperserverRestClient;
import com.jaspersoft.jasperserver.jaxrs.client.core.RestClientConfiguration;
import com.jaspersoft.jasperserver.jaxrs.client.core.Session;
import com.jaspersoft.jasperserver.jaxrs.client.core.operationresult.OperationResult;
import controllers.JSStrListController;
import gs.common.Consts;
import gs.common.byte_funcs;
import gs.common.jr_funcs;
import gs.common.jsf.bundle_funcs;
import gs.common.jsf.jsf_funcs;
import gs.common.primefaces.primefaces_funcs;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import managers.core.dbtables.C_Bin_File_Body_Manager;
import managers.core.dbtables.C_Tbl_Rec_File_Manager;
import managers.core.dbtables.C_Tbl_Manager;
import managers.core.dbtables.C_Usr_Manager;
import model.core.dbtables.C_Bin_File_Body;
import model.core.dbtables.Jr_Rep;
import model.core.dbtables.C_Tbl_Rec_File;
import model.core.dbtables.C_Usr;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.PrimeFaces;

public class CustomJRReportFuncs {

  public static String jrs_rest_url;
  public static String jrs_rest_admin_user_name;
  public static String jrs_rest_admin_user_password;

  public static String getJrs_rest_url() {
    if (jrs_rest_url == null) {
      jrs_rest_url = System.getProperty("jrs_rest_url");
    }
    return jrs_rest_url;
  }

  public static void setJrs_rest_url(String jrs_rest_url_) {
    CustomJRReportFuncs.jrs_rest_url = jrs_rest_url_;
  }

  public static String getJrs_rest_admin_user_name() {
    if (jrs_rest_admin_user_name == null) {
      jrs_rest_admin_user_name = System.getProperty("jrs_rest_admin_user_name");
    }
    return jrs_rest_admin_user_name;
  }

  public static void setJrs_rest_admin_user_name(String jrs_rest_admin_user_name) {
    CustomJRReportFuncs.jrs_rest_admin_user_name = jrs_rest_admin_user_name;
  }

  public static String getJrs_rest_admin_user_password() {
    if (jrs_rest_admin_user_password == null) {
      jrs_rest_admin_user_password = System.getProperty("jrs_rest_admin_user_password");
    }
    return jrs_rest_admin_user_password;
  }

  public static void setJrs_rest_admin_user_password(String jrs_rest_admin_user_password) {
    CustomJRReportFuncs.jrs_rest_admin_user_password = jrs_rest_admin_user_password;
  }

  public static Session getAdminSession() {
    RestClientConfiguration configuration = new RestClientConfiguration(getJrs_rest_url());
    JasperserverRestClient client = new JasperserverRestClient(configuration);
    Session session_ = client.authenticate(getJrs_rest_admin_user_name(), getJrs_rest_admin_user_password());
    return session_;
  }

  public static Session getLoggerUsrSession(C_Usr logged_c_usr_) {
    RestClientConfiguration configuration = new RestClientConfiguration(getJrs_rest_url());
    JasperserverRestClient client = new JasperserverRestClient(configuration);
    Session session_ = client.authenticate(logged_c_usr_.getName(), "barkuan_7890");
    return session_;
  }

  public static LinkedList<JR_Report> get_standart_jr_report_list() {
    LinkedList<JR_Report> list_ = new LinkedList<JR_Report>();
    Session session_ = getAdminSession();

    OperationResult<ClientResourceListWrapper> result = session_
      .resourcesService()
      .resources()
      .parameter(ResourceSearchParameter.FOLDER_URI, "/StandartReports")
      .parameter(ResourceSearchParameter.LIMIT, "1000")
      .search();
    ClientResourceListWrapper resourceListWrapper = result.getEntity();

    ClientResourceLookup crl_;
    JR_Report jr_report_;
    for (int i = 0; i < resourceListWrapper.getResourceLookups().size(); i++) {
      crl_ = resourceListWrapper.getResourceLookups().get(i);
      jr_report_ = new JR_Report();
      jr_report_.setId(i);
      jr_report_.setDescription(crl_.getDescription());
      jr_report_.setLabel(crl_.getLabel());
      jr_report_.setUri(crl_.getUri());
      list_.add(jr_report_);
    }

    jr_funcs.closeSession(session_);

    return list_;
  }

  public static JR_Report get_jr_report(String report_path_, String report_label_) {
    Session session_ = getAdminSession();

    if (!report_path_.startsWith("/")) {
      report_path_ = "/" + report_path_;
    }
    //if (!report_path_.endsWith("/")) {
    //  report_path_ = report_path_ + "/";
    //}
    OperationResult<ClientResourceListWrapper> result = session_
      .resourcesService()
      .resources()
      .parameter(ResourceSearchParameter.FOLDER_URI, report_path_)
      .parameter(ResourceSearchParameter.LIMIT, "1000")
      .search();
    ClientResourceListWrapper resourceListWrapper = result.getEntity();

    ClientResourceLookup crl_;
    JR_Report jr_report_;
    //LinkedList<JR_Report> list_ = new LinkedList<JR_Report>();
    for (int i = 0; i < resourceListWrapper.getResourceLookups().size(); i++) {
      crl_ = resourceListWrapper.getResourceLookups().get(i);
      if (crl_.getLabel().equals(report_label_)) {
        jr_report_ = new JR_Report();
        jr_report_.setId(i);
        jr_report_.setDescription(crl_.getDescription());
        jr_report_.setLabel(crl_.getLabel());
        jr_report_.setUri(crl_.getUri());
        return jr_report_;
      }
    }

    jr_funcs.closeSession(session_);

    return null;
  }

  public static LinkedList<JR_Report_Param> get_jr_report_param_list(JR_Report jr_report_, C_Usr logged_c_usr_) throws Exception {
    LinkedList<JR_Report_Param> list_ = new LinkedList<JR_Report_Param>();
    Session session_ = getAdminSession();
    ReportsAdapter reportsAdapter = jr_funcs.getReportsAdapter(session_, jr_report_.getUri());
    ReportParametersAdapter reportParametersAdapter = reportsAdapter.reportParameters();
    reportParametersAdapter = reportParametersAdapter.parameter("logged_in_user_name", logged_c_usr_.getName());
    reportParametersAdapter = reportParametersAdapter.parameter("logged_in_user_password", logged_c_usr_.getPswd());
    reportParametersAdapter = reportParametersAdapter.parameter("REPORT_TIME_ZONE", TimeZone.getTimeZone("GMT").toString());

    ReportInputControlsListWrapper inputControls
      = reportParametersAdapter
        .get()
        .getEntity();
    ReportInputControl ric_;
    JR_Report_Param jr_report_param_;
    String tmp_str_;
    Date tmp_date_;
    for (int i = 0; i < inputControls.getInputParameters().size(); i++) {
      ric_ = inputControls.getInputParameters().get(i);
      jr_report_param_ = new JR_Report_Param();
      jr_report_param_.setDescription(ric_.getDescription());
      jr_report_param_.setId(ric_.getId());
      jr_report_param_.setLabel(ric_.getLabel());
      jr_report_param_.setMandatory(ric_.getMandatory());
      jr_report_param_.setMasterDependencies(ric_.getMasterDependencies());
      jr_report_param_.setReadOnly(ric_.getReadOnly());
      jr_report_param_.setSlaveDependencies(ric_.getSlaveDependencies());
      jr_report_param_.setState(ric_.getState());
      jr_report_param_.setType(ric_.getType());
      jr_report_param_.setUri(ric_.getUri());
      jr_report_param_.setValidationRules(ric_.getValidationRules());
      jr_report_param_.setVisible(ric_.getVisible());
      jr_report_param_.setValue(null);
      if (list_.contains(jr_report_param_)) {
        continue;
      } else {
        list_.add(jr_report_param_);
      }
    }
    jr_funcs.closeSession(session_);

    return list_;
  }

  public static LinkedList<JR_Report_Param> get_jr_rep_param_list(Jr_Rep jr_rep_, C_Usr logged_c_usr_) throws Exception {
    LinkedList<JR_Report_Param> list_ = new LinkedList<JR_Report_Param>();
    Session session_ = getAdminSession();
    ReportsAdapter reportsAdapter = jr_funcs.getReportsAdapter(session_, jr_rep_.getJr_rep_tpl_t().getCode());
    ReportParametersAdapter reportParametersAdapter = reportsAdapter.reportParameters();
    reportParametersAdapter = reportParametersAdapter.parameter("logged_in_user_name", logged_c_usr_.getName());
    reportParametersAdapter = reportParametersAdapter.parameter("logged_in_user_password", logged_c_usr_.getPswd());
    reportParametersAdapter = reportParametersAdapter.parameter("REPORT_TIME_ZONE", TimeZone.getTimeZone("GMT").toString());

    ReportInputControlsListWrapper inputControls
      = reportParametersAdapter
        .get()
        .getEntity();
    ReportInputControl ric_;
    JR_Report_Param jr_report_param_;
    String tmp_str_;
    Date tmp_date_;
    for (int i = 0; i < inputControls.getInputParameters().size(); i++) {
      ric_ = inputControls.getInputParameters().get(i);
      jr_report_param_ = new JR_Report_Param();
      jr_report_param_.setDescription(ric_.getDescription());
      jr_report_param_.setId(ric_.getId());
      jr_report_param_.setLabel(ric_.getLabel());
      jr_report_param_.setMandatory(ric_.getMandatory());
      jr_report_param_.setMasterDependencies(ric_.getMasterDependencies());
      jr_report_param_.setReadOnly(ric_.getReadOnly());
      jr_report_param_.setSlaveDependencies(ric_.getSlaveDependencies());
      jr_report_param_.setState(ric_.getState());
      jr_report_param_.setType(ric_.getType());
      jr_report_param_.setUri(ric_.getUri());
      jr_report_param_.setValidationRules(ric_.getValidationRules());
      jr_report_param_.setVisible(ric_.getVisible());
      jr_report_param_.setValue(null);
      if (list_.contains(jr_report_param_)) {
        continue;
      } else {
        list_.add(jr_report_param_);
      }
    }
    jr_funcs.closeSession(session_);

    return list_;
  }

  public static void runReport(JR_Report jr_report_, ReportOutputFormat reportOutputFormat, String parent_element_id_, boolean is_attachment_, C_Usr logged_c_usr_) throws Exception {
    Session session_ = getAdminSession();
    ReportsAdapter reportsAdapter = jr_funcs.getReportsAdapter(session_, jr_report_.getUri());
    RunReportAdapter runReportAdapter = reportsAdapter.prepareForRun(reportOutputFormat, 1);
    JR_Report_Param jr_report_param_;
    for (int i = 0; i < jr_report_.getJr_report_param_list(logged_c_usr_).size(); i++) {
      jr_report_param_ = jr_report_.getJr_report_param_list(logged_c_usr_).get(i);
      if (jr_report_param_.getId().equals("logged_in_user_name")) {
        runReportAdapter = runReportAdapter.parameter(jr_report_param_.getId(), logged_c_usr_.getName());
        continue;
      }
      if (jr_report_param_.getId().equals("logged_in_user_password")) {
        runReportAdapter = runReportAdapter.parameter(jr_report_param_.getId(), logged_c_usr_.getPswd());
        continue;
      }
      if (jr_report_param_.getType().equals("singleValueDatetime")) {
        runReportAdapter = runReportAdapter.parameter(jr_report_param_.getId(), new SimpleDateFormat(Consts.yyyy_MM_ddHHmmss).format((Date) jr_report_param_.getValue()).replace(" ", "T"));
      } else if (jr_report_param_.getType().equals("singleSelect")) {
        runReportAdapter = runReportAdapter.parameter(jr_report_param_.getId(), (String) jr_report_param_.getValue());
      }
    }
    OperationResult<InputStream> result = runReportAdapter.run();
    InputStream is_ = result.getEntity();

    //new FileOutputStream("c:\\Temp\\out.html").write(IOUtils.readFully(is_, -1, false));
    java.util.Date now_ = new java.util.Date();
    C_Tbl_Rec_File rec_ = new C_Tbl_Rec_File();
    rec_.setC_tbl_t(C_Tbl_Manager.getCI().get_rec_by_code("report"));
    rec_.setRec_id((long)logged_c_usr_.getC_usr());
    String extension_ = "";
    if (reportOutputFormat.equals(ReportOutputFormat.HTML)) {
      extension_ = "html";
    } else if (reportOutputFormat.equals(ReportOutputFormat.PDF)) {
      extension_ = "pdf";
      //is_attachment_ = false;
    } else if (reportOutputFormat.equals(ReportOutputFormat.DOCX)) {
      extension_ = "docx";
    } else if (reportOutputFormat.equals(ReportOutputFormat.XLS)) {
      extension_ = "xls";
    } else if (reportOutputFormat.equals(ReportOutputFormat.XLSX)) {
      extension_ = "xlsx";
    } else if (reportOutputFormat.equals(ReportOutputFormat.CSV)) {
      extension_ = "csv";
    } else if (reportOutputFormat.equals(ReportOutputFormat.JRPRINT)) {
      extension_ = "jrprint";
    } else if (reportOutputFormat.equals(ReportOutputFormat.ODS)) {
      extension_ = "ods";
    } else if (reportOutputFormat.equals(ReportOutputFormat.ODT)) {
      extension_ = "odt";
    } else if (reportOutputFormat.equals(ReportOutputFormat.RTF)) {
      extension_ = "rtf";
    } else if (reportOutputFormat.equals(ReportOutputFormat.XML)) {
      extension_ = "xml";
    }
    rec_.setFile_name(String.valueOf(now_.getTime() + "." + extension_));
    rec_.setIns_dt(now_);
    rec_.setIs_manually_added(false);
    rec_.setUser_name(logged_c_usr_.getName());
    
    C_Bin_File_Body bin_file_body_;
    bin_file_body_ = new C_Bin_File_Body();
    bin_file_body_.setFile_body(byte_funcs.convertInputStreamToByteArr(is_));
    C_Bin_File_Body_Manager.getCI().insert_rec(bin_file_body_);
    
    rec_.setC_bin_file_body(bin_file_body_.getC_bin_file_body());
    rec_.setIs_deleted(false);
    CustomLogger.log("rec_=" + rec_);
    C_Tbl_Rec_File_Manager.getCI().insert_rec(rec_);
    long object_file_id_ = rec_.getC_tbl_rec_file();
    String url_ = "open_tbl_rec_file?id=" + object_file_id_ + "&is_delete=true" + (is_attachment_ ? "&is_attachment=true" : "");
    if (reportOutputFormat.equals(ReportOutputFormat.HTML) && !is_attachment_) {
      String iframe_html_ = "<iframe id='id_iframe_report_results' name='iframe_report_results' src='" + url_ + "' width='100%' height='500px' frameborder='0' scrolling='auto'>Vash_brauzer_ne_podderzhivaet_frejmy</iframe>";
      JSStrListController.getCurrentBean().add_js_str(PrimeFaces.current(), "var el_ = document.getElementById(\"" + parent_element_id_ + "\"); el_.innerHTML = ''; el_.innerHTML = \"" + iframe_html_ + "\";");
    } else {
      JSStrListController.getCurrentBean().add_js_str(PrimeFaces.current(), "var new_win_ = window.open('" + url_ + "', '_blank'); new_win_.focus();");
    }

    jr_funcs.closeSession(session_);
  }

  public static void render_jr_report_params(UIComponent uicomponent_, JR_Report jr_report_, String jr_report_value_expression_, C_Usr logged_c_usr_) throws Exception {
    System.out.println("render_jr_report_params");
    if (!uicomponent_.getChildren().isEmpty()) {
      while (!uicomponent_.getChildren().isEmpty()) {
        uicomponent_.getChildren().remove(0);
      }
      primefaces_funcs.updateElement(uicomponent_.getClientId());
    }
    if (jr_report_ == null) {
      return;
    }
    String res = "";
    String str_;
    String el_id_;
    boolean is_add_label_;
    String tmp_str_;
    Date tmp_date_;
    JR_Report_Param jr_report_param_;
    SelectItem si_ = new SelectItem();
    InputControlOption ico_;
    String label_;
    for (int i = 0; i < jr_report_.getJr_report_param_list(logged_c_usr_).size(); i++) {
      jr_report_param_ = jr_report_.getJr_report_param_list(logged_c_usr_).get(i);
      if (!jr_report_param_.isVisible()) {
        continue;
      }
      el_id_ = "id_" + jr_report_param_.getId();
      is_add_label_ = false;
      if (jr_report_param_.getType().equals("singleValueDatetime")) {
        Calendar calendar_ = new Calendar();
        tmp_str_ = jr_report_param_.getState().getValue();
        if (tmp_str_ != null && !tmp_str_.isEmpty()) {
          tmp_str_ = tmp_str_.replace("T", " ");
          tmp_date_ = new SimpleDateFormat(Consts.yyyy_MM_ddHHmmss).parse(tmp_str_);
          jr_report_param_.setValue(tmp_date_);
        }
        ValueExpression valueExpression = FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
          .createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{" + jr_report_value_expression_ + ".jr_report_param_list.get(" + i + ").value}", Date.class);
        calendar_.setValueExpression("value", valueExpression);
        calendar_.setShowButtonPanel(true);
        calendar_.setPattern("dd.MM.yyyy HH:mm:ss");
        calendar_.setId(el_id_);
        calendar_.setTimeZone(VariablesBean.getCI().getLocalTimeZone());
        calendar_.setReadonly(jr_report_param_.isReadOnly());
        calendar_.setRequired(jr_report_param_.isMandatory());
        calendar_.setNavigator(true);
        uicomponent_.getChildren().add(calendar_);
        is_add_label_ = true;
      } else if (jr_report_param_.getType().equals("singleSelect")) {
        SelectOneMenu som_ = new SelectOneMenu();
        if (jr_report_param_.getState().getOptions() != null) {
          for (int j = 0; j < jr_report_param_.getState().getOptions().size(); j++) {
            ico_ = jr_report_param_.getState().getOptions().get(j);
            if (ico_.isSelected()) {
              jr_report_param_.setValue(ico_.getValue());
            }
          }
        }
        ValueExpression valueExpression = FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
          .createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{" + jr_report_value_expression_ + ".jr_report_param_list.get(" + i + ").value}", String.class);
        som_.setValueExpression("value", valueExpression);
        som_.setId(el_id_);
        som_.setReadonly(jr_report_param_.isReadOnly());
        som_.setRequired(jr_report_param_.isMandatory());
        UISelectItems selectItems = new UISelectItems();
        List<SelectItem> si_list_ = new ArrayList();
        si_list_.add(new SelectItem("", "-"));
        if (jr_report_param_.getState().getOptions() != null) {
          for (int j = 0; j < jr_report_param_.getState().getOptions().size(); j++) {
            ico_ = jr_report_param_.getState().getOptions().get(j);
            if (ico_.getLabel().startsWith("$R{")) {
              label_ = bundle_funcs.getBundleValue(ico_.getLabel().substring(3).replace("}", ""));
            } else {
              label_ = bundle_funcs.getBundleValue(ico_.getLabel());
            }
            si_list_.add(new SelectItem(ico_.getValue(), label_));
          }
        }
        selectItems.setValue(si_list_);
        som_.getChildren().add(selectItems);
        uicomponent_.getChildren().add(som_);
        is_add_label_ = true;
      }
      if (is_add_label_) {
        OutputLabel ol_ = new OutputLabel();
        ol_.setValue(bundle_funcs.getBundleValue(jr_report_param_.getDescription()));
        ol_.setFor(el_id_);
        ol_.setEscape(false);
        uicomponent_.getChildren().add(uicomponent_.getChildren().size() - 1, ol_);
      }
    }
    System.out.println("uicomponent_.getId()=" + uicomponent_.getClientId());
    primefaces_funcs.updateElement(uicomponent_.getClientId());
    //uicomponent_.
  }

}
