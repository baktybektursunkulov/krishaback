package managers.core.dbtables;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import model.core.dbtables.*;
import gs.common.managers.My_Abstract_Controller_Manager;
import gs.common.model.db.*;
import org.hibernate.*;
import others.CustomLogger;
import gs.common.hibernate_funcs;
import java.util.*;
import java.text.*;

@ManagedBean
@ApplicationScoped
public class C_Tbl_Rec_Contact_Type_Manager extends Abstract_Controller_Manager<C_Tbl_Rec_Contact_Type> {

  private static C_Tbl_Rec_Contact_Type_Manager currentInstance = null;
  private Integer id_phone = 1;
  private Integer id_email = 5;
  private Integer id_whatsapp = 10;
  private Integer id_telegram = 15;
  private Integer id_viber = 20;

  public static C_Tbl_Rec_Contact_Type_Manager getCI() {
    if (currentInstance == null) {
      currentInstance = new C_Tbl_Rec_Contact_Type_Manager();
    }
    return currentInstance;
  }

  public Integer getId_phone() {
    return id_phone;
  }

  public void setId_phone(Integer id_phone) {
    this.id_phone = id_phone;
  }

  public Integer getId_email() {
    return id_email;
  }

  public void setId_email(Integer id_email) {
    this.id_email = id_email;
  }

  public Integer getId_whatsapp() {
    return id_whatsapp;
  }

  public void setId_whatsapp(Integer id_whatsapp) {
    this.id_whatsapp = id_whatsapp;
  }

  public Integer getId_telegram() {
    return id_telegram;
  }

  public void setId_telegram(Integer id_telegram) {
    this.id_telegram = id_telegram;
  }

  public Integer getId_viber() {
    return id_viber;
  }

  public void setId_viber(Integer id_viber) {
    this.id_viber = id_viber;
  }

  public C_Tbl_Rec_Contact_Type_Manager() {
    super(C_Tbl_Rec_Contact_Type.class);
  }

}
