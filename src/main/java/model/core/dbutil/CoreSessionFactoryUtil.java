package model.core.dbutil;

//import additional_classes.ActiveMQMessageReceiverThread;
//import additional_classes.ActiveMQMessageSender;
import beans.VariablesBean;
//import envers.MyDefaultRevisionEntity;
import gs.common.model.db.MySessionFactoryUtil;
import managers.core.dbtables.*;
import org.hibernate.Session;
import gs.common.hibernate_funcs;
import gs.common.other_funcs;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import others.CustomLogger;

public class CoreSessionFactoryUtil extends MySessionFactoryUtil {

  private static CoreSessionFactoryUtil sessionFactoryUtilInstance;

  public static SessionFactory getInstance() {
    return getSessionFactoryUtilInstance().getSf();
  }

  public static CoreSessionFactoryUtil getSessionFactoryUtilInstance() {
    if (sessionFactoryUtilInstance == null) {
      sessionFactoryUtilInstance = new CoreSessionFactoryUtil();
      //sessionFactoryUtilInstance.initialize("core__", System.getProperties());
    }
    return sessionFactoryUtilInstance;
  }

  public CoreSessionFactoryUtil() {
  }

  static {
    getSessionFactoryUtilInstance().initialize("core__", System.getProperties());
  }

  @Override
  public void after_initialize() {
    //Cons_Manager.initialize();
    //V3_Common_Settings_Manager.initialize();
    if (System.getProperty("is_initialize_res_bundle") == null || System.getProperty("is_initialize_res_bundle").equals("true")) {
      C_Res_Bundle_Manager.initialize();
    }
    //ApplicationBean.getCI().initialize();
    try {
      if (System.getProperty("activemq_is_launch_message") != null && System.getProperty("activemq_is_launch_message").equals("true")) {
        //ActiveMQMessageSender.createInstance();
        //ActiveMQMessageReceiverThread.myStart();
      }
    } catch (Exception e) {
      e.printStackTrace();
      try {
        email.funcs.send_email_from_gts_sender_2("barkuan@mail.ru", "Error in " + System.getProperty("user.dir") + ", computer_name=" + InetAddress.getLocalHost().getHostName(), other_funcs.stack2string(e));
      } catch (UnknownHostException ex) {
        ex.printStackTrace();
      }
    } 
    
  }

  @Override
  public void addAnnotatedClasses(Configuration ac) {

    ac.addAnnotatedClass(model.core.dbtables.C_Country.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Cons.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Proj.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Cur.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Cur_Course.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Date_Format.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Date_Time_Format.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Distance_Unit.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Smtp_Security.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Email_Out.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Email_Out_File.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Geocoding_Service.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Java_Data_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Lang.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Mob_Notif_App.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tz.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Status.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Mob_Notif_Out.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Mob_Notif_Out_Token.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Mob_Notif_Reg_Token.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Month.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Proj_Sender_Email.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Res_Bundle_Base.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Res_Bundle.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Right_Kind.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Right.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Sms_Out.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Speed_Unit.class);

    ac.addAnnotatedClass(model.core.dbtables.C_System_Version.class);

    ac.addAnnotatedClass(model.core.dbtables.C_System_Version_Sent_Email.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Oper_Kind.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Oper.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Prop.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Rec_Prop_Val.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Text_Match_Mode.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Time_Format.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Log_Service.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Log_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Log.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Volume_Unit.class);

    ac.addAnnotatedClass(model.core.dbtables.Dc_Doc.class);

    ac.addAnnotatedClass(model.core.dbtables.Dc_Doc_Cont.class);

    ac.addAnnotatedClass(model.core.dbtables.Dc_Doc_Cont_Row.class);

    ac.addAnnotatedClass(model.core.dbtables.C_File_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_File.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Rec_File.class);

    ac.addAnnotatedClass(model.core.dbtables.I_Tbl.class);

    ac.addAnnotatedClass(model.core.dbtables.I_Tbl_Fld.class);

    ac.addAnnotatedClass(model.core.dbtables.I_Tbl_Fld_Trans.class);

    ac.addAnnotatedClass(model.core.dbtables.I_Plain_Txt.class);

    ac.addAnnotatedClass(model.core.dbtables.I_Html_Txt.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Img.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Img_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Img_Converted.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Img_Converted_By_Max_Wh.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Img_Converted_Color.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Img_Rotated.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Input_Control_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Lov.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Lov_Row.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Query.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Input_Control.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Page_Orient.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Tpl_Grp.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Tpl.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Tpl_Col.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Col.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Col_Fil_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Col_Fil_Type_Op.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Col_Fil.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Sort_Order.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Col_Sort.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Tpl_File.class);

    ac.addAnnotatedClass(model.core.dbtables.Jr_Rep_Tpl_Param.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Theme.class);
    ac.addAnnotatedClass(model.core.dbtables.C_Site.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Period_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Tariff.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Svc.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Svc_Cost_Row.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Bal_Op_Kind.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Day_Op_Kind.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Bal_Op.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Day_Op.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Limit.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Limit_Log.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Right_Dep.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Review.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Review_Comment.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Review_Helpful.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Dyn_Guide.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Dyn_Guide_Row.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Site_Img_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Site_Img.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Gender.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Img_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Img.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Addr_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Weight_Unit.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Addr.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Id_Doc_Kind.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Person_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Bank_Card.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Phone_Num_Verify.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Email_Verify.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Jur_Person.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Nat_Person.class);
    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Contact_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Contact.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Site_Meta.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Site_Page.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Site_Page_Meta.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Site_Page_Meta_Val.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Proj_Lang.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Proj_Country.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Proj_Cur.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Loc.class);
    ac.addAnnotatedClass(model.core.dbtables.C_Loc_Grp.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Loc_Grp_Loc.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Country.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Sign.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Length_Unit.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Bin_File_Body.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Business_Form.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Jur_Person_Addr_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Jur_Person_Addr.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Broker_Sender.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Broker_Receiver.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Broker_Msg.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Broker_Msg_Receiver.class);
    ac.addAnnotatedClass(model.core.dbtables.C_Translation.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Pswd_Restore.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Session_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Session.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Addr_V2.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Geocoding.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Reverse_Geocoding.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Role.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Role_Right_Kind.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Review_Kind.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Review_Rating.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Review_Img.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Rec_Rating.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Rec_Review_Cnt.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Rec_Rating_His.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Review_Answer.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Usr_Review_Addition.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Rec_Img.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Chat_Msg_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Chat.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Chat_Cli.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Chat_Msg.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Chat_Msg_File.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Chat_Msg_Recipient.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Ip2location.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Chat_Sql.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Img_Converted_By_Min_Wh.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Chat_Party_Status.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Http_Req_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Http_Req.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Rec_Contact_Type.class);

    ac.addAnnotatedClass(model.core.dbtables.C_Tbl_Rec_Contact.class);

    ac.addAnnotatedClass(model.core.dbtables.C_List_Sort_Order.class);



  }

  @Override
  protected void error(Exception e) {
    CustomLogger.error(e);
  }

  @Override
  protected void log(String s_) {
    CustomLogger.log(s_);
  }

  @Override
  protected boolean getIs_print_stack_trace() {
    return VariablesBean.getCI().getIs_debug_session();
  }

}
